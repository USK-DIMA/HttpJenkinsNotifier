package ru.uskov.dmitry.httpjenkinsnotifier.client.services;

import java.util.Arrays;
import java.util.List;

public class EventNotification {

    private final EventType eventType;
    private final TicketOrPullRequest ticketOrPullRequest;
    private final String id;

    public EventNotification(EventType eventType, TicketOrPullRequest ticketOrPullRequest, String id) {
        this.eventType = eventType;
        this.ticketOrPullRequest = ticketOrPullRequest;
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public TicketOrPullRequest getTicketOrPullRequest() {
        return ticketOrPullRequest;
    }

    public String getId() {
        return id;
    }

    public enum EventType {
        PULL_REQUEST("pull_request.wav", null),
        APPROVE("approve.wav", null),
        NEED_WORK("need_work.wav", null),
        BUILD_SUCCESS("build_success.wav", null),
        BUILD_FAILED("build_failed.wav", null),
        MERGE("merge.wav", null);

        private final String audioNameNote;
        private final String audioNameEvent;

        EventType(String audioNameNote, String audioNameEvent) {
            this.audioNameNote = audioNameNote;
            this.audioNameEvent = audioNameEvent;
        }

        public String getAudioNameNote() {
            return audioNameNote;
        }

        public String getAudioNameEvent() {
            return audioNameEvent;
        }
    }


    public enum TicketOrPullRequest {
        PULL_REQUEST(null),
        TICKET(null);

        private final List<String> audioName;

        TicketOrPullRequest(String... audioName) {
            this.audioName = Arrays.asList(audioName);
        }

        public List<String> getAudioName() {
            return audioName;
        }
    }



}
