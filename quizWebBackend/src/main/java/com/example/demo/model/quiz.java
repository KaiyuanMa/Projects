package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "quizzes")
public class quiz {

    @Id
    @GeneratedValue
    private int quiz_id;
    private int client_id;
    private int difficulty_id;
    private String date;
    private int grade;
    private int subject_id;

}
