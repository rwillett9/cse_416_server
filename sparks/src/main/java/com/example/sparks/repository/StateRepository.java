package com.example.sparks.repository;

import java.util.List;

import com.example.sparks.entity.State;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findByStateCode(String stateCode);
}