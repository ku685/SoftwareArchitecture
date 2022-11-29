package com.example.demo.repository;

//import com.exam.portal.Model.Option;
import com.example.demo.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}
