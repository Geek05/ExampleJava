package kafka.examples;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Properties;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
public class ProducerDemoWithCallback {
    static Properties properties;
    static Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);

    static {
        String bootstrapServers = "localhost:9092";
        properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

    public static void main(String[] args) {
        //Create Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //Send data
        String TOPIC_NAME = "myFirstTopic";
        String data = "Hi This is first message from java code provider with callback2";
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, data);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                //executes every time the record is successfully sent or exception is thrown
                if (Objects.isNull(e)) {
                    logger.info("received new metadata Topic: {}, Partition: {}" , recordMetadata.topic(), recordMetadata.partition());
                } else {
                    logger.error("error found while procucing {}", e);
                }
            }
        });
        producer.flush();
        producer.close();
    }
}
