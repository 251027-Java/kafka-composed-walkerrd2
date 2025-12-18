package com.revature.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("message-topic", message);
    }

    @KafkaListener(topics = "message-topic", groupId = "group-id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

}
