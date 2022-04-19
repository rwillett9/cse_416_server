package com.example.sparks.Repositories;

import com.example.sparks.Entities.SeatShareData;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SeatShareDataRepository extends CrudRepository<SeatShareData, Long> {

}