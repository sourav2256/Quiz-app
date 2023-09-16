package com.springProjects.demo.controller;

import com.springProjects.demo.Entity.Question;
import com.springProjects.demo.Entity.QuestionWrapper;
import com.springProjects.demo.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
@PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String title){
    return quizService.createQuiz(category,numQ,title);
}
@GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
    return quizService.getQuizQuestion(id);
}

}
