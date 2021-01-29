package pl.ideopolis.dataCollector.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/getLogs")
    public String getLogs() {
        return logService.getLogs();
    }

//    @GetMapping("/getLastLog")
//    public Log getLastLog() {
//        final List<Log> logs = logService.getLogs();
//        final int size = logs.size();
//        return logs.get(size-1);
//    }
//
//    @GetMapping("/getLastLogAsString")
//    public String getLastLogAsString() {
//        final List<Log> logs = logService.getLogs();
//        final int size = logs.size();
//        return logs.get(size-1).toString();
//    }

}
