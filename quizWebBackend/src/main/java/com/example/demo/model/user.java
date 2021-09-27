package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "clients")
public class user{

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private int client_id;
    @Column(name = "email")
    private String email;
    @Column(name = "passcode")
    private String passcode;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "plan")
    private int plan;
    @Column(name = "card_number")
    private String card_number;
    @Column(name = "date")
    private String date;
    @Column(name = "ccv")
    private int ccv;
    @Column(name = "math_difficulty")
    private int math_difficulty;
    @Column(name = "cs_difficulty")
    private int cs_difficulty;
    @Column(name = "ge_difficulty")
    private int ge_difficulty;


    public user(String email, String passcode, String first_name, String last_name, int plan, String card_number, String date, int ccv, int math_difficulty, int cs_difficulty, int ge_difficulty) {
        this.email = email;
        this.passcode = passcode;
        this.first_name = first_name;
        this.last_name = last_name;
        this.plan = plan;
        this.card_number = card_number;
        this.date = date;
        this.ccv = ccv;
        this.math_difficulty = math_difficulty;
        this.cs_difficulty = cs_difficulty;
        this.ge_difficulty = ge_difficulty;
    }

    public user() {
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public int getMath_difficulty() {
        return math_difficulty;
    }

    public void setMath_difficulty(int math_difficulty) {
        this.math_difficulty = math_difficulty;
    }

    public int getCs_difficulty() {
        return cs_difficulty;
    }

    public void setCs_difficulty(int cs_difficulty) {
        this.cs_difficulty = cs_difficulty;
    }

    public int getGe_difficulty() {
        return ge_difficulty;
    }

    public void setGe_difficulty(int ge_difficulty) {
        this.ge_difficulty = ge_difficulty;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
//        return Collections.singletonList(authority);
//    }
//
//    @Override
//    public String getPassword() {
//        return passcode;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}