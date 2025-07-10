package com.project.quizapp.controller;

import com.project.quizapp.models.Question;
import com.project.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public List<Question> getQuestionByCategory(@PathVariable String cat)
    {
        return questionService.getQuestionByCategory(cat);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
}
