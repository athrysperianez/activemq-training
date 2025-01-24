package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DataDTO;
import com.example.demo.model.DataMapper;
import com.example.demo.repository.DataEntityRepository;
import com.example.demo.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataEntityRepository repo;

	@Override
	public void saveData(DataDTO dto) {
		repo.save(DataMapper.toEntity(dto));
	}

	@Override
	public List<DataDTO> obtainAllData() {
		ArrayList<DataDTO> result = new ArrayList<DataDTO>();

		repo.findAll().forEach(current -> {
			result.add(DataMapper.toDTO(current));
		});

		return result;
	}
}
