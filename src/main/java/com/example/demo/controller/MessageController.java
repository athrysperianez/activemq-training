package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataDTO;
import com.example.demo.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MessageController {

	@Autowired
	private MessageService service;

	@GetMapping("/send/{number}")
	public String send(@PathVariable(value = "number") Integer id) throws JsonProcessingException {
		DataDTO dto = new DataDTO(id);
		service.sendMessage(dto);
		return "Message sent";
	}

}
