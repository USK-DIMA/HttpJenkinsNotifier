
package ru.uskov.dmitry.httpjenkinsnotifier.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PullRequest implements Serializable {

    private Long id;
    private Long version;
    private String title;
    private String state;
    private Boolean open;
    private Boolean closed;
    private Long createdDate;
    private Long updatedDate;
    private Long closedDate;
    private FromRef fromRef;
    private ToRef toRef;
    private Boolean locked;
    private Author author;
    private List<Reviewer> reviewers = null;
    private List<Object> participants = null;
    private Properties properties;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 7565493550956108825L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Long closedDate) {
        this.closedDate = closedDate;
    }

    public FromRef getFromRef() {
        return fromRef;
    }

    public void setFromRef(FromRef fromRef) {
        this.fromRef = fromRef;
    }

    public ToRef getToRef() {
        return toRef;
    }

    public void setToRef(ToRef toRef) {
        this.toRef = toRef;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public List<Object> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Object> participants) {
        this.participants = participants;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
