
package ru.uskov.dmitry.httpjenkinsnotifier.api.model.jenkins;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Repository implements Serializable {

    private String slug;
    private Long id;
    private String name;
    private String scmId;
    private String state;
    private String statusMessage;
    private Boolean forkable;
    private Project project;
    private Boolean _public;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -7426424393739796461L;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScmId() {
        return scmId;
    }

    public void setScmId(String scmId) {
        this.scmId = scmId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Boolean getForkable() {
        return forkable;
    }

    public void setForkable(Boolean forkable) {
        this.forkable = forkable;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
