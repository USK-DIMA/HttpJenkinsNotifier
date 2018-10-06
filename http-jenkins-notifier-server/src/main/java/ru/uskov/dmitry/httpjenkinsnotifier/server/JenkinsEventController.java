package ru.uskov.dmitry.httpjenkinsnotifier.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.jenkins.Event;

@RestController
public class JenkinsEventController {

    public static final String PATH = "/event";

    @Autowired
    private KafkaSenderService kafkaSenderService;

    @RequestMapping(path = JenkinsEventController.PATH, method = RequestMethod.POST)
    public void event(@RequestBody Event event) {
        kafkaSenderService.send(event);
    }

}