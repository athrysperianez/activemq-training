package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataDTO;
import com.example.demo.service.DataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class JMSListenerController {

	@Autowired
	DataService dataService;

	@JmsListener(destination = "test")
	public void autoListener(String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		DataDTO dto = mapper.readValue(data, DataDTO.class);
		dto.setNumber(dto.getNumber() * 2);
		dataService.saveData(dto);
		System.out.println("Numero guardado " + dto.getNumber());
	}
}
