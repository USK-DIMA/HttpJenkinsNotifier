
package ru.uskov.dmitry.httpjenkinsnotifier.rest.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Properties implements Serializable {

    private MergeCommit mergeCommit;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 8184128031070940020L;

    public MergeCommit getMergeCommit() {
        return mergeCommit;
    }

    public void setMergeCommit(MergeCommit mergeCommit) {
        this.mergeCommit = mergeCommit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
