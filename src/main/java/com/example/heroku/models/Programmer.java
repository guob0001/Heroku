package com.example.heroku.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="programmers")
@Entity
public class Programmer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String workplace;
    @Column
    public String hobby;

}
