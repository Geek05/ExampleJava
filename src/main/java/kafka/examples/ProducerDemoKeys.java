package kafka.examples;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
public class ProducerDemoKeys {
    static Properties properties;
    static Logger logger = LoggerFactory.getLogger(ProducerDemoKeys.class);

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

        IntStream.range(10, 20)
                .parallel()
                .forEach(i -> {
                    String data = "Hi This is first message from java code provider with callback " + i;
                    String key = "key_" + i;
                    ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, data);
                    try {
                        producer.send(record, new Callback() {
                            @Override
                            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                                //executes every time the record is successfully sent or exception is thrown
                                if (Objects.isNull(e)) {
                                    logger.info("received new metadata Topic: {}, Partition: {}", recordMetadata.topic(), recordMetadata.partition());
                                } else {
                                    logger.error("error found while procucing {}", e);
                                }
                            }
                        }).get(); //Block the send() to it synchronous (Not recomended in prod)
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        producer.flush();
        producer.close();
    }
}
