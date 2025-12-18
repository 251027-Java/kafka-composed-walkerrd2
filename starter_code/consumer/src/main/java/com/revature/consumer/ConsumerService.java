package com.revature.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private List<String> receivedMessages = new ArrayList<>();

    @KafkaListener(topics = "messages", groupId = "message-consumers")
      public void listen(String message) {
          System.out.println("Received message: " + message);
          receivedMessages.add(message);
      }

    public List<String> getMessages() {
        return receivedMessages;
    }

}


