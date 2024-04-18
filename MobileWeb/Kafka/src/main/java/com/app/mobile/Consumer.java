package com.app.mobile;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class Consumer {

	
	@KafkaListener(id = "myId", topics = "topic1")
    public void listen(String in) {
        System.out.println(in);
    }
	
	@KafkaListener(topics = "topic-1", groupId = "group1")
    void listener(String data) {
		 System.out.println("Received message [{}] in group1"+data);
    }
	
}
