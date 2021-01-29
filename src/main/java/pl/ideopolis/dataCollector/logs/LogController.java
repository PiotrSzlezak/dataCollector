package pl.ideopolis.dataCollector.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/logs")
public class LogController {

    private LogService logService;

    @Autowired
    public LogController (LogService logService){
        this.logService = logService;
    }

    @GetMapping("/getLogs")
    public List<Log> getLogs (){
        return logService.getLogs();
    }

}
