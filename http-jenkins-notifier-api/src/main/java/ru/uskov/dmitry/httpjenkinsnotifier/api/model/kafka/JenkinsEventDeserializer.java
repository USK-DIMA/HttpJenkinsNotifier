package ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JenkinsEventDeserializer implements Deserializer<JenkinsEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsEventDeserializer.class);

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public JenkinsEvent deserialize(String arg0, byte[] eventBytes) {
        try {
            return new ObjectMapper().readValue(eventBytes, JenkinsEvent.class);
        } catch (Exception e) {
            LOGGER.error("Could not deserialize JenkinsEvent", e);
            return null;
        }
    }

    @Override
    public void close() {

    }
}
