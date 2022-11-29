package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.model.User;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private ExamRepository examRepository;

    public ModelAndView getMarksForAllExam(Long userId) {
        System.out.println(userId);
        ModelAndView mav = new ModelAndView("exam-marks");
//        List<Exam> ls=examRepository.findBy(equals());
//        List<Exam> x=new ArrayList<>();

        mav.addObject("marks",examRepository.findByUser(userId));
        return mav;
    }
}
