package com.project.quizapp.models;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper
{
    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    public QuestionWrapper(int id, String questionText, String optionA, String optionB, String optionC, String optionD)
    {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }
}
