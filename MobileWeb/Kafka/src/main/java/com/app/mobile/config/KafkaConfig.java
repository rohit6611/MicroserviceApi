package com.app.mobile.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configurable
public class KafkaConfig {

	
	 @Bean
	    public NewTopic topic() {
	        return TopicBuilder.name("topic1")
	                .partitions(10)
	                .replicas(1)
	                .build();
	    }
	 
	 
	 
	

	    @Bean
	    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
	        return args -> {
	            template.send("topic1", "test");
	        };
	    }
	
	    
	    
	    
	    @Bean
	    public NewTopic createTopic(){
	        return new NewTopic("javatechie-demo", 3, (short) 1);
	    }

	    @Bean
	    public Map<String,Object> producerConfig(){
	        Map<String,Object> props=new HashMap<>();
	        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	                "localhost:9092");
	        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	                StringSerializer.class);
	        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	                JsonSerializer.class);
	        return props;
	    }

	    @Bean
	    public ProducerFactory<String,Object> producerFactory(){
	        return new DefaultKafkaProducerFactory<>(producerConfig());
	    }

	    @Bean
	    public KafkaTemplate<String,Object> kafkaTemplate(){
	        return new KafkaTemplate<>(producerFactory());
	    }
	    
	    
	    
}
