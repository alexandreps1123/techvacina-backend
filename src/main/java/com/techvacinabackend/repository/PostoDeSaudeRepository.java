package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.PostoDeSaude;

@Repository
public interface PostoDeSaudeRepository extends JpaRepository<PostoDeSaude, Long> {
    
}
