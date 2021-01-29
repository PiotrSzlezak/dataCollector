package pl.ideopolis.dataCollector.danepubliczne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/danepubliczne")
public class SynopticDataRestController {

    private final String url = "https://danepubliczne.imgw.pl/api/data/synop";
    private SynopticDataService synopticDataService;

    @Autowired
    public SynopticDataRestController(SynopticDataService service){
        this.synopticDataService = service;
    }

    @GetMapping("/synopticdata")
    public ResponseEntity<String> getSynopticData() {
        synopticDataService.saveAllSynopticData(dataRequest());
        return new ResponseEntity<>("Data retrieved successfully.", HttpStatus.OK);
    }

    public String dataRequest(){
        String synopticDataAsString;
        RestTemplate restTemplate = new RestTemplate();
        synopticDataAsString = restTemplate.getForObject(url, String.class);
        System.out.println("danepubliczne - RestController - Dżejson pobrany.");
        System.out.println("danepubliczne - RestController - Wyświetl co udało się pobrać:\n");
        System.out.println(synopticDataAsString);

        final ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

}
