package com.example.demo.dao.repostories;

import com.example.demo.dao.enteties.Cours;
import com.example.demo.dao.enteties.Student;
import com.example.demo.dao.enteties.seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SeanceRepository extends JpaRepository<seance,Integer> {
}
