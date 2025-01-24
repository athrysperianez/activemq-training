package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.DataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public interface MessageService {
	public void sendMessage(DataDTO dto) throws JsonProcessingException;
}
