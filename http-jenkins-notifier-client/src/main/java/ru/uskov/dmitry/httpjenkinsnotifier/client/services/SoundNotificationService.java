package ru.uskov.dmitry.httpjenkinsnotifier.client.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.uskov.dmitry.httpjenkinsnotifier.client.sound.DigitsSoundUtils;
import ru.uskov.dmitry.httpjenkinsnotifier.client.sound.SoundPlayer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoundNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundNotificationService.class);

    private static final String DIGITS_PATH = "digits";

    @Value("${audio.path}")
    private String audioPath;

    public void notify(EventType eventType) {
        try {
            SoundPlayer.playSound(resolve(eventType.getAudioName()));
        } catch (Exception e) {
            LOGGER.error("Could not play sound for event {}", eventType, e);
        }
    }

    private String resolve(String audioName) {
        return Paths.get(audioPath).resolve(audioName).toString();
    }

    public void notifyNumber(String number) {
        Path digitsPath = Paths.get(audioPath).resolve(DIGITS_PATH);
        ArrayList<String> tracks1 = DigitsSoundUtils.getTracksClassic(number);
        System.out.println(tracks1);
        List<String> tracks = tracks1.stream().map(audioName -> digitsPath.resolve(audioName).toString()).collect(Collectors.toList());
        SoundPlayer.playSound(tracks);
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