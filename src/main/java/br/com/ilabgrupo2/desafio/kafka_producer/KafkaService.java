package br.com.ilabgrupo2.desafio.kafka_producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaService {
    public static void sendMessage(String key, String value) throws InterruptedException, ExecutionException{

        var producer = new KafkaProducer<String,String>(properties());
        var record = new ProducerRecord<String, String>(System.getenv("KAFKA_TOPIC"), key, value);

        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Mensagem enviada com sucesso para: " + data.topic() + " | partition " + data.partition() + "| offset " + data.offset() + "| tempo " + data.timestamp());
        };

        producer.send(record, callback).get();
        producer.close();
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv("KAFKA_HOST"));
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
