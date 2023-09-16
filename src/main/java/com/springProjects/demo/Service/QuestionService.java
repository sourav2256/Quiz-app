package com.springProjects.demo.Service;

import com.springProjects.demo.Entity.Question;
import com.springProjects.demo.Repository.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return  new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "Success";
    }

    public int deleteQuestion(int id) {
        questionDAO.deleteById(id);
        return id;
    }

    public String updateQuestion(int id) {
        questionDAO.saveAndFlush(new Question());
        return "Success";
    }

    public ResponseEntity<Question> getQuestionById(int id, Question question) {
        Question getQuestion = questionDAO.getById(id);
        getQuestion.setQuestionTitle(question.getQuestionTitle());
        getQuestion.setCategory(question.getCategory());
        getQuestion.setDifficulty_level(question.getDifficulty_level());
        getQuestion.setCorrectAnswer(question.getCorrectAnswer());
        Question updateQuestion = questionDAO.save(getQuestion);
        return ResponseEntity.ok().body(updateQuestion);
    }
}
