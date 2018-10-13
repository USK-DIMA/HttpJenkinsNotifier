package ru.uskov.dmitry.httpjenkinsnotifier.client.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.uskov.dmitry.httpjenkinsnotifier.client.sound.DigitsSoundUtils;
import ru.uskov.dmitry.httpjenkinsnotifier.client.sound.SoundPlayer;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SoundNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundNotificationService.class);

    private static final String NOTE_FOLDER = "note";
    private static final String DIGITS_FOLDER = "digits";
    private static final String COMMON_FOLDER = "common";
    private static final String EVENTS_FOLDER = "events";
    private static final String TICKET_OR_PR_FOLDER = "ticketOrPr";

    @Value("${audio.path}")
    private String audioPath;

    private EventType eventType = EventType.NOTE;

    private IdFormat idFormat = IdFormat.CLASSIC;

    public void notify(EventNotification eventNotification) {
        if(eventType == EventType.NOTE) {
            SoundPlayer.playSound(getNoteAudio(eventNotification));
        } else {
            List<String> tracks = new ArrayList<>();
            tracks.add(getNotificationAudio());
            tracks.addAll(getTicketOrPr(eventNotification));
            tracks.add(getAudioNumber());
            tracks.addAll(getId(eventNotification.getId(), idFormat.getIdToAudiosFilesConverter()));
            tracks.add(getEventTypeAudio(eventNotification));
            SoundPlayer.playSound(tracks);
        }
    }

    private String getNoteAudio(EventNotification eventNotification) {
        return resolve(NOTE_FOLDER, eventNotification.getEventType().getAudioNameNote());
    }

    private String getEventTypeAudio(EventNotification eventNotification) {
        return resolve(EVENTS_FOLDER, eventNotification.getEventType().getAudioNameEvent());
    }

    private Collection<? extends String> getTicketOrPr(EventNotification eventNotification) {
        return resolve(TICKET_OR_PR_FOLDER, eventNotification.getTicketOrPullRequest().getAudioName());
    }

    private List<String> getId(String number, Function<String, ArrayList<String>> numberToAudiosFilesConverter) {
        ArrayList<String> tracks1 = numberToAudiosFilesConverter.apply(number);
        return resolve(DIGITS_FOLDER, tracks1);
    }

    private String getAudioNumber() {
        return resolve(COMMON_FOLDER, "number.wav");
    }

    private String getNotificationAudio() {
        return resolve(COMMON_FOLDER, "notification.wav");
    }

    private String resolve(String folder, String audioName) {
        return Paths.get(audioPath).resolve(folder).resolve(audioName).toString();
    }

    private List<String> resolve(String folder, List<String> audioName) {
        return audioName.stream().map(a->resolve(folder, a)).collect(Collectors.toList());
    }

    public enum EventType {
        NOTE,
        FULL
    }

    public enum IdFormat {
        CLASSIC(DigitsSoundUtils::getTracksClassic),
        SPLIT(DigitsSoundUtils::getTracksSplit);
        private final Function<String, ArrayList<String>> numberToAudiosFilesConverter;

        IdFormat(Function<String, ArrayList<String>> numberToAudiosFilesConverter) {
            this.numberToAudiosFilesConverter = numberToAudiosFilesConverter;
        }

        public Function<String, ArrayList<String>> getIdToAudiosFilesConverter() {
            return numberToAudiosFilesConverter;
        }

    }

}