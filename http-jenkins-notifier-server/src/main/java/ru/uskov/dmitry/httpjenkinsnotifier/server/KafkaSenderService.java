package ru.uskov.dmitry.httpjenkinsnotifier.server;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.jenkins.Event;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka.JenkinsEvent;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka.JenkinsEventSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.Properties;

@Service
public class KafkaSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSenderService.class);

    @Value("${kafka.brokers:localhost:9092}")
    private String kafkaBrokers;

    @Value("${kafka.client.id:jenkins-notifier-producer}")
    private String clientID;

    @Value("${kafka.topic.name:jenkins-notifier-topic}")
    private String topicName;

    private KafkaProducer<String, JenkinsEvent> producer;

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, clientID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JenkinsEventSerializer.class.getName());
        producer = new KafkaProducer<>(props);
    }

    public void send(Event event) {
        ProducerRecord<String, JenkinsEvent> record = new ProducerRecord<>(topicName, new JenkinsEvent(new Date().getTime(), event));
        try {
            producer.send(record).get();
        } catch (Exception e) {
            LOGGER.error("Could not send even {}", event, e);
        }
    }

    @PreDestroy
    public void destroy() {
        if (producer != null) {
            producer.close();
        }
    }


}
