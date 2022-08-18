package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techvacinabackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
