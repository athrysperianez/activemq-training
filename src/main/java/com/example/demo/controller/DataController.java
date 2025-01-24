package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataDTO;
import com.example.demo.service.DataService;

@RestController
public class DataController {

	@Autowired
	DataService dataService;

	@GetMapping("/seeAll")
	public List<DataDTO> seeAll() {
		return dataService.obtainAllData();
	}
}
