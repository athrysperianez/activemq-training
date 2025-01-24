package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.DataEntity;

public interface DataEntityRepository extends CrudRepository<DataEntity, Integer> {}
