package ru.uskov.dmitry.httpjenkinsnotifier.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.Event;
import ru.uskov.dmitry.httpjenkinsnotifier.sound.EventType;
import ru.uskov.dmitry.httpjenkinsnotifier.sound.SoundNotifier;

@RestController
public class JenkinsEventController {

    static final String PATH = "/event";
    private static final String PATH_TEST = "/event/test";

    @Autowired
    private SoundNotifier soundNotifier;

    @RequestMapping(path = JenkinsEventController.PATH, method = RequestMethod.POST)
    public String event(@RequestBody Event event) {
        return event.toString();
    }

    @RequestMapping(path = JenkinsEventController.PATH_TEST, method = RequestMethod.POST)
    public void eventTest(@RequestBody String eventType) {
        try {
            soundNotifier.notify(EventType.valueOf(eventType.trim().toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
