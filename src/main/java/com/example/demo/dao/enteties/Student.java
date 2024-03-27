package com.example.demo.dao.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Personne {
    private String matricule;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<seance> seances;

    @Override
    public String toString() {
        return "Student{" +
                "matricule='" + matricule + '\'' +
                "} " + super.toString();
    }
}