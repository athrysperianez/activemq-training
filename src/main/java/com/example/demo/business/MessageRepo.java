package com.example.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageRepo {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${activemq.destination}")
	private String destination;

	public void sendMessage(String json) {
		jmsTemplate.convertAndSend(destination, json);

	}

}
