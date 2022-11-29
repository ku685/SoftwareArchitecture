package com.example.demo.repository;

import com.example.demo.model.Exam;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {

    @Query(value = "SELECT * FROM exam e WHERE e.user_user_id = ?", nativeQuery = true)
    public Collection<Exam> findByUser(Long userId);

    public Exam findByExamId(Long userId);


}
