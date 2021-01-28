package pl.ideopolis.dataCollector.danepubliczne;

import org.springframework.beans.factory.annotation.Autowired;
import pl.ideopolis.dataCollector.danepubliczne.utils.SynopticDataJsonUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.ideopolis.dataCollector.logs.DataSource;
import pl.ideopolis.dataCollector.logs.Log;
import pl.ideopolis.dataCollector.logs.LogService;

@Service
public class SynopticDataService {

    private SynopticDataRepository synopticDataRepository;
    private SynopticDataJsonUtil synopticDataJsonUtil;
    private LogService logService;
    private int numberOfNewEntries;

    @Autowired
    public SynopticDataService (SynopticDataRepository repository, LogService logService){
        this.synopticDataRepository = repository;
        this.logService = logService;
    }

    public void saveAllSynopticData(String jsonAsString) {
        synopticDataJsonUtil = new SynopticDataJsonUtil(jsonAsString);
        List<SynopticDataDTO> synopticDataDTOs = synopticDataJsonUtil.deserializeSynopticDataToMatrix();
        numberOfNewEntries = 0;
        List<SynopticData> synopticDataList = convertSynopticDataDtoListToSynopticDataList(synopticDataDTOs);
        synopticDataRepository.saveAll(synopticDataList);
        if (numberOfNewEntries > 0) {
            System.out.println(numberOfNewEntries + " new entries added to database");
        } else if (numberOfNewEntries == 0) {
            System.out.println("No new entries were added. File was already present in the database.");
        }
        saveLogs();
    }

    private Optional<SynopticData> findMatchingData(SynopticDataDTO dto) {
        return synopticDataRepository.findMatchingEntry(dto.getIdStacji(), dto.getDataPomiaru(), dto.getGodzinaPomiaru());
    }

    private List<SynopticData> convertSynopticDataDtoListToSynopticDataList(List<SynopticDataDTO> synopticDataDTOs) {
        List<SynopticData> synopticDataList = new ArrayList<>();
        for (SynopticDataDTO dto : synopticDataDTOs) {
            Optional<SynopticData> optionalSynopticData = findMatchingData(dto);
            if (optionalSynopticData.isPresent()) {
                System.out.println("Entry already exists in database");
            } else {
                synopticDataList.add(new SynopticData(dto));
                numberOfNewEntries++;
            }
        }
        return synopticDataList;
    }

    private void saveLogs(){
        Date date = new Date();
        System.out.println(date);
        Log log = new Log(date, DataSource.SYNOPTIC_DATA, numberOfNewEntries);
        logService.saveLog(log);
    }

}
