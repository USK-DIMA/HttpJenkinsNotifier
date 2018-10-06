package ru.uskov.dmitry.httpjenkinsnotifier.sound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class SoundNotifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundNotifier.class);

    @Value("${audio.path}")
    private String audioPath;

    public void notify(EventType eventType) {
        try {
            SoundPlayer.playSound(Paths.get(audioPath).resolve(eventType.getAudioName()).toString());
        } catch (Exception e) {
            LOGGER.error("Could not play sound for event {}", eventType, e);
        }
    }
}
