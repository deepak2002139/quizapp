package com.project.quizapp.service;

import com.project.quizapp.dao.QuestionDao;
import com.project.quizapp.dao.QuizDao;
import com.project.quizapp.models.Question;
import com.project.quizapp.models.QuestionWrapper;
import com.project.quizapp.models.Quiz;
import com.project.quizapp.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService
{
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title)
    {
        List<Question> questions=questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionFromDB)
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionText(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calulateResult(Integer id, List<Response> responses)
    {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int Right=0,i=0;
        for(Response response:responses)
        {
            if(response.getResponse().equals(questions.get(i).getCorrectOption()))
            {Right++;}
            i++;
        }
        return new ResponseEntity<>(Right,HttpStatus.OK);
    }
}
