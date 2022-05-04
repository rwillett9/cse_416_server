package com.example.sparks.repository;

import java.util.List;

import com.example.sparks.entity.Precinct;

import org.springframework.data.repository.CrudRepository;

public interface PrecinctRepository extends CrudRepository<Precinct, Long>{
    List<Precinct> findAllByNameIgnoreCase(String name);
}
