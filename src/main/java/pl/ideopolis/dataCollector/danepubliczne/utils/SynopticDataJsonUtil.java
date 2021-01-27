package pl.ideopolis.dataCollector.danepubliczne.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.ideopolis.dataCollector.danepubliczne.SynopticDataDTO;

import java.util.Arrays;
import java.util.List;

public class SynopticDataJsonUtil {

    private JsonNode jsonNode;

    public SynopticDataJsonUtil(String jsonAsString){
        convertStringToJson(jsonAsString);
    }

//    public JsonNode getJsonNode() {
//        return jsonNode;
//    }
//
//    public String getValue(String key){
//        JsonNode valueNode = jsonNode.findValue(key);
//        return valueNode.asText();
//    }

    public void convertStringToJson(String jsonAsString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.jsonNode = mapper.readTree(jsonAsString);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong with converting string to json");
            e.printStackTrace();
        }
    }

    public List<SynopticDataDTO> deserializeSynopticDataToMatrix() {
        ObjectMapper mapper = new ObjectMapper();
        List<SynopticDataDTO> synopticDataDTOList = null;
        try {
            synopticDataDTOList = Arrays.asList(mapper.readValue(this.jsonNode.toString(), SynopticDataDTO[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return synopticDataDTOList;
    }

}
