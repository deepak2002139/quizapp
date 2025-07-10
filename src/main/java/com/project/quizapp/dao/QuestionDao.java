package com.project.quizapp.dao;

import com.project.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>
{
    List<Question> findByCategory(String category);

}
