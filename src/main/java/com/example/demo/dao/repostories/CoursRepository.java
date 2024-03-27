package com.example.demo.dao.repostories;

import com.example.demo.dao.enteties.Cours;
import com.example.demo.dao.enteties.Teacher;
import com.example.demo.dao.enteties.seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Integer> {

}
