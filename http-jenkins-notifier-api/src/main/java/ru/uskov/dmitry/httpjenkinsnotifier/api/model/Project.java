
package ru.uskov.dmitry.httpjenkinsnotifier.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Project implements Serializable {

    private String key;
    private Long id;
    private String name;
    private String description;
    private Boolean _public;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -7977571174226534896L;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
