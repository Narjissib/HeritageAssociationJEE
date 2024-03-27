package com.example.demo.dao.repostories;

import com.example.demo.dao.enteties.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PersonneRepository  extends JpaRepository<Personne,Integer> {
}
