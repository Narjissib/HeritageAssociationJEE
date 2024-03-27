package com.example.demo.dao.repostories;

import com.example.demo.dao.enteties.Cours;
import com.example.demo.dao.enteties.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
