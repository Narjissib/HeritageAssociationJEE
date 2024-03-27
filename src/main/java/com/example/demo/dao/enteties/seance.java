package com.example.demo.dao.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Date h_debut;
    private Date h_fin;

    @ManyToMany(mappedBy = "seances", fetch = FetchType.EAGER)
    private Collection<Student> students;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cours cours;
    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", date=" + date +
                ", h_debut=" + h_debut +
                ", h_fin=" + h_fin +
                ", "+cours+
                ", "+students+
                '}';
    }
}