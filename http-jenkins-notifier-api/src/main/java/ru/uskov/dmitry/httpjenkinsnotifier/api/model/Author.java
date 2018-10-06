
package ru.uskov.dmitry.httpjenkinsnotifier.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Author implements Serializable {

    private User user;
    private String role;
    private Boolean approved;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -6155373938012008059L;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
