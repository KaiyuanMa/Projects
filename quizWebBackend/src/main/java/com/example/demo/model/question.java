package com.example.demo.model;



import javax.persistence.*;
import java.util.ArrayList;



@Entity
@Table(name = "questions")
public class question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private int question_id;
    @Column(name = "question")
    private String question;
    @Column(name = "choice_A")
    private String choice_A;
    @Column(name = "choice_B")
    private String choice_B;
    @Column(name = "choice_C")
    private String choice_C;
    @Column(name = "choice_D")
    private String choice_D;
    @Column(name = "answer")
    private String answer;
    @Column(name = "difficulty_id")
    private int difficulty;
    //TODO: change type to subject type, change String to int
    @Column(name = "type")
    private String type;

    public question() {
    }

    public question(int question_id, String question, String choice_A, String choice_B, String choice_C, String choice_D, String answer, int difficulty, String type) {
        this.question_id = question_id;
        this.question = question;
        this.choice_A = choice_A;
        this.choice_B = choice_B;
        this.choice_C = choice_C;
        this.choice_D = choice_D;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
