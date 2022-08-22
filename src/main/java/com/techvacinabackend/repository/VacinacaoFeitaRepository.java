package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.VacinacaoFeita;

@Repository
public interface VacinacaoFeitaRepository extends JpaRepository<VacinacaoFeita, Long> {
    
}
