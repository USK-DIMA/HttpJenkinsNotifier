package ru.uskov.dmitry.httpjenkinsnotifier.client.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.uskov.dmitry.httpjenkinsnotifier.client.sound.SoundPlayer;

import java.nio.file.Paths;

@Service
public class SoundNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundNotificationService.class);

    @Value("${audio.path}")
    private String audioPath;

    public void notify(EventType eventType) {
        try {
            SoundPlayer.playSound(Paths.get(audioPath).resolve(eventType.getAudioName()).toString());
        } catch (Exception e) {
            LOGGER.error("Could not play sound for event {}", eventType, e);
        }
    }

    public enum EventType {
        PULL_REQUEST("pull_request.wav"),
        APPROVE("approve.wav"),
        NEED_WORK("need_work.wav"),
        BUILD_SUCCESS("build_success.wav"),
        BUILD_FAILED("build_failed.wav"),
        MERGE("merge.wav");

        private final String audioName;

        EventType(String audioName) {
            this.audioName = audioName;
        }

        public String getAudioName() {
            return audioName;
        }
    }

}