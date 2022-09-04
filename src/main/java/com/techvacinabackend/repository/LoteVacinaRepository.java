package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.LoteVacina;

@Repository
public interface LoteVacinaRepository extends JpaRepository<LoteVacina, Long> {
    
}
