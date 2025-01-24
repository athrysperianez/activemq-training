package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DataDTO;

@Service
public interface DataService {
	public void saveData(DataDTO dto);

	public List<DataDTO> obtainAllData();
}
