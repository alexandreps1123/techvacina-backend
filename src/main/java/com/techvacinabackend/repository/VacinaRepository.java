package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    
}