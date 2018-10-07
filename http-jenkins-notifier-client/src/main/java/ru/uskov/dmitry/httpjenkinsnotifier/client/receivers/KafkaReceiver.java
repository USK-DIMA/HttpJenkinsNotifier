package ru.uskov.dmitry.httpjenkinsnotifier.client.receivers;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka.JenkinsEvent;
import ru.uskov.dmitry.httpjenkinsnotifier.api.model.kafka.JenkinsEventDeserializer;
import ru.uskov.dmitry.httpjenkinsnotifier.client.services.SoundNotificationService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


@Component
public class KafkaReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);

    @Value("${kafka.disable:false}")
    private boolean disable;

    @Value("${kafka.brokers:localhost:9092}")
    private String kafkaBrokers;

    @Value("${kafka.group.id:consumer-group-1}")
    private String groupId;

    @Value("${kafka.max.poll.records:1}")
    private String maxPollRecords;

    @Value("${kafka.topic.name:jenkins-notifier-topic}")
    private String topicName;

    @Autowired
    private SoundNotificationService soundNotificationService;

    private Consumer<String, JenkinsEvent> consumer;

    private Thread receiverThread;

    @PostConstruct
    public void init() {
        if(disable) {
            LOGGER.info("kafka.disable=false. Kafka consumer not started");
            return;
        }
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JenkinsEventDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topicName));
        receiverThread = new Thread(new Receiver());
        receiverThread.start();
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        if (receiverThread != null) {
            receiverThread.interrupt();
            receiverThread.join();
        }
        if (consumer != null) {
            consumer.close();
        }
    }

    private class Receiver implements Runnable {

        private final Duration duration = Duration.ofSeconds(1);

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    ConsumerRecords<String, JenkinsEvent> consumerRecords = consumer.poll(duration);
                    LOGGER.debug("Get {} events ", consumerRecords.count());
                    if (!consumerRecords.isEmpty()) {
                        consumerRecords.forEach(record -> {
                            LOGGER.debug("Receive message: {}", record.value());
                            soundNotificationService.notify(SoundNotificationService.EventType.PULL_REQUEST);
                        });
                        consumer.commitSync();
                    }
                } catch (InterruptException e) {
                    LOGGER.info("Receiver thread has interrupted");
                    return;
                }
            }
        }
    }

}