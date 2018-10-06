
package ru.uskov.dmitry.httpjenkinsnotifier.api.model.jenkins;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MergeCommit implements Serializable {

    private String displayId;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -7405418385552343058L;

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
