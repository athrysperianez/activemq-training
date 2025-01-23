package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.MessageRepo;
import com.example.demo.model.DataDTO;
import com.example.demo.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepo repo;

	@Override
	public void sendMessage(DataDTO dto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		repo.sendMessage(mapper.writeValueAsString(dto));
	}
}
