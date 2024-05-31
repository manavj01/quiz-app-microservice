package com.manav.quiz_service.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.manav.quiz_service.dao.QuizDao;
import com.manav.quiz_service.feign.QuizInterface;
import com.manav.quiz_service.model.Quiz;
import com.manav.quiz_service.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.manav.quiz_service.model.QuestionWrapper;


@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizDao.findById(quizId).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

       ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}
