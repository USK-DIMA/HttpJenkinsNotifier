
package ru.uskov.dmitry.httpjenkinsnotifier.rest.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FromRef implements Serializable {

    private String id;
    private String displayId;
    private String latestCommit;
    private Repository repository;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 7912706902623531672L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public String getLatestCommit() {
        return latestCommit;
    }

    public void setLatestCommit(String latestCommit) {
        this.latestCommit = latestCommit;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
