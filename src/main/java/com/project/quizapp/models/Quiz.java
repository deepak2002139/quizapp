package com.project.quizapp.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany
    public List<Question> questions;

}
