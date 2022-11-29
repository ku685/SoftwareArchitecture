package com.example.demo.repository;

//import com.exam.portal.Model.Answer;
import com.example.demo.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
