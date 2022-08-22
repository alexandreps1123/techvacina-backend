package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Long> {
    
}
