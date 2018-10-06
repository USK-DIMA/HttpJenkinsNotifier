package ru.uskov.dmitry.httpjenkinsnotifier.client.receivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.uskov.dmitry.httpjenkinsnotifier.client.services.SoundNotificationService;

@RestController
public class RestReceiver {

    private static final String PATH_TEST = "/event/test";

    @Autowired
    private SoundNotificationService soundNotificationService;

    @RequestMapping(path = RestReceiver.PATH_TEST, method = RequestMethod.POST)
    public void eventTest(@RequestBody String eventType) {
        try {
            soundNotificationService.notify(SoundNotificationService.EventType.valueOf(eventType.trim().toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}