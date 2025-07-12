package com.project.quizapp.service;

import com.project.quizapp.dao.QuestionDao;
import com.project.quizapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions()
    {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String cat)
    {
        return questionDao.findByCategory(cat);
    }

    public ResponseEntity<String> addQuestion(Question question)
    {
        questionDao.save(question);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
