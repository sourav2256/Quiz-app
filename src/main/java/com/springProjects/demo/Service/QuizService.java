package com.springProjects.demo.Service;

import com.springProjects.demo.Entity.Question;
import com.springProjects.demo.Entity.QuestionWrapper;
import com.springProjects.demo.Entity.Quiz;
import com.springProjects.demo.Repository.QuestionDAO;
import com.springProjects.demo.Repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> question=questionDAO.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
       Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForuser = new ArrayList<>();
        for(Question q :questionFromDB){
            QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            questionForuser.add(qw);
        }
        return new ResponseEntity<>(questionForuser,HttpStatus.OK);

    }
}
