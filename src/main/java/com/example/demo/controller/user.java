package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Exam;
import com.example.demo.model.Option;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.OptionRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class user {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/id")
//    @PathVariable("user-id") Long id
    public ModelAndView getAllExams(@RequestParam(name = "id") Long userId) {
        return userService.getMarksForAllExam(userId);
    }
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/organiser/login")
    public String login() {

       System.out.println("here");
        return "organiser/exam/view1";
    }

    @Autowired
    private QuestionRepository repo;
    @Autowired
    private OptionRepository optionRepo;

    @Autowired
    private AnswerRepository answerRepo;
    @Autowired
    private ExamRepository examRepo;
    @PostMapping("/organiser/question/add")
    public String addQuestion(@RequestParam(name = "question")String question, @RequestParam(name = "option[]") List<String> options,@RequestParam(name="exam_id")Long exam_id,  @RequestParam(name = "answer")Integer answer){
        Exam exam=examRepo.findById(exam_id).get();
        System.out.println("question here");
        Question q=new Question();
        q.setStatement(question);
        q.setExams(exam);
        repo.save(q);

        ArrayList<Option> optionList= new ArrayList<>();
        for (String option : options) {
            Option o=new Option(q, option);
            optionList.add(o);
            optionRepo.save(o);
        }

        Answer a=new Answer(q,optionList.get(answer-1));
        answerRepo.save(a);

        return "index";
    }



}
