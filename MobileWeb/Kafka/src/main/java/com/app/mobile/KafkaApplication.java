package com.app.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication


public class KafkaApplication implements  CommandLineRunner{


	@Autowired 
	Producer mProducer;
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
		

		
		
		
		
		
	}
	
	
	@Override

	public void run(String... args) throws Exception {
		 for (int i=0;i<10;i++)
		 {
			 
			 try {
				new Producer().sendMessage("topic1",i+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	
	
	}
	
}
