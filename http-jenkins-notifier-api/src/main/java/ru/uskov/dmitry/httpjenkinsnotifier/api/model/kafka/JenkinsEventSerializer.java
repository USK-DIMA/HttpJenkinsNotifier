package ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JenkinsEventSerializer implements Serializer<JenkinsEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsEventSerializer.class);

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String arg0, JenkinsEvent event) {
        try {
            return new ObjectMapper().writeValueAsString(event).getBytes();
        } catch (Exception e) {
            LOGGER.error("Could not serialize JenkinsEvent", e);
            return null;
        }
    }

    @Override
    public void close() {

    }
}
