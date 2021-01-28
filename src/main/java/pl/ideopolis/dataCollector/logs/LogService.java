package pl.ideopolis.dataCollector.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private LogRepository logsRepository;

    @Autowired
    public LogService(LogRepository logsRepository){
        this.logsRepository = logsRepository;
    }

    public void saveLog(Log log){
        logsRepository.save(log);
    }

}
