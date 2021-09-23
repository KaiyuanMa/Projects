package com.example.demo.repository;


import com.example.demo.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionRepository extends JpaRepository<question, Integer> {
    List<question> findALlByType(String type);

    List<question> findALlByTypeAndDifficulty(String type, int difficulty);

}
