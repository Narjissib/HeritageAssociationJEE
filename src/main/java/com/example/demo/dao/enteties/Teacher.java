package com.example.demo.dao.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Personne {
    private Date dateAffectation;

    @OneToOne
    private Cours cours;

    @Override
    public String toString() {
        return "Teacher{" +
                "Id= "+getId()+
                ", Nom="+getName()+
                ", dateAffectation=" + dateAffectation +
                ","+cours+
                '}';
    }
}