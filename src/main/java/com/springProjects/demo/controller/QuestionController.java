package com.springProjects.demo.controller;

import com.springProjects.demo.Entity.Question;
import com.springProjects.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>>getAllQuestions(){
//controller
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question ){
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{id}")
    public int deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id,@RequestBody Question question){
       return questionService.getQuestionById(id,question);
    }
}


