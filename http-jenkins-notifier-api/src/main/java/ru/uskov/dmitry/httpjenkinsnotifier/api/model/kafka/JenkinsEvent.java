package ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka;

import ru.uskov.dmitry.httpjenkinsnotifier.api.model.jenkins.Event;

public class JenkinsEvent {
    private long date;
    private Event event;

    public JenkinsEvent(long date, Event event) {
        this.date = date;
        this.event = event;
    }

    public JenkinsEvent() {
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public long getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }
}
