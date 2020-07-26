package kafka.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import javax.management.ValueExp;
import java.util.Properties;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
public class ProducerDemo {
    static Properties properties;

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
        String data = "Hi This is first message from java code";
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, data);

        producer.send(record);
        producer.flush();
        producer.close();
    }
}
