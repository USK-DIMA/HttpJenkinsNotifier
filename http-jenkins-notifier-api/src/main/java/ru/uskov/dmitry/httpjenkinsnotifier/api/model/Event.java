
package ru.uskov.dmitry.httpjenkinsnotifier.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Event implements Serializable {

    private String eventKey;
    private String date;
    private Actor actor;
    private PullRequest pullRequest;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 2255644676046222336L;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
