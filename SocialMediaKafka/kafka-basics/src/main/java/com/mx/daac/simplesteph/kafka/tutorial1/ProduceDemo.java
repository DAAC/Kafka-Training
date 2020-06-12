package com.mx.daac.simplesteph.kafka.tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

public class ProduceDemo {


    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(ProduceDemo.class);
        Properties properties = new Properties();
        String bootstrapServers = "127.0.0.1:9092";
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i <= 10; i++) {
            ProducerRecord<String, String> record =
                    new ProducerRecord<String, String>("twitter_tweets",
                            "");

                    //new ProducerRecord<String, String>("first_topic", "hello world" + Integer.toString(i));
            //send data - asynchronous
            producer.send(record);
        }

        producer.flush();
        producer.close();


        System.out.println("que onda ");
    }


}
