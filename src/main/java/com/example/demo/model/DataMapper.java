package com.example.demo.model;

public class DataMapper {

	public static DataDTO toDTO(DataEntity entity) {
		return new DataDTO(entity.getNumber());
	}

	public static DataEntity toEntity(DataDTO dto) {
		return new DataEntity(dto.getNumber());
	}
}
