package com.example.demo.controller;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.service.MessageService;


@WebMvcTest(MessageController.class)
public class MessageControllerTest {

	@MockitoBean
	private MessageService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sendMessage() throws Exception {
		int rand = new Random().nextInt(Integer.MAX_VALUE / 2);
		RequestBuilder request = MockMvcRequestBuilders.get("/send/" + rand).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}

}
