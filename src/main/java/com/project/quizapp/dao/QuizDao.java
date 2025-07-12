package com.project.quizapp.dao;

import com.project.quizapp.models.Question;
import com.project.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz,Integer>
{
//    List<Question> getQuiz(int id);
}
