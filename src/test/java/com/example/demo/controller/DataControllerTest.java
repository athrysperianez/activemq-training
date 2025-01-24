package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.DataDTO;
import com.example.demo.service.DataService;

@ExtendWith(SpringExtension.class)
public class DataControllerTest {

	@Mock
	private DataService dataService;

	@InjectMocks
	private DataController controller;

	@BeforeEach
	public void prepareMockResponse() {
		ArrayList<DataDTO> response = new ArrayList<DataDTO>();

		response.add(new DataDTO(5));
		response.add(new DataDTO(10));
		response.add(new DataDTO(213));
		response.add(new DataDTO(40));
		response.add(new DataDTO(159));

		when(dataService.obtainAllData()).thenReturn(response);
	}

	@Test
	public void seeAll() {
		assertThat(controller.seeAll()).isNotEmpty();
	}

}
