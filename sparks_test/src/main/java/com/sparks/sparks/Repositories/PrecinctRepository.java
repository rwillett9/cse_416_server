package com.sparks.sparks.Repositories;

import com.sparks.sparks.Entities.Precinct;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PrecinctRepository extends CrudRepository<Precinct, Long> {
    
}
