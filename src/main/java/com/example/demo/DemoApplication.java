package com.example.demo;

import com.example.demo.dao.enteties.*;
import com.example.demo.dao.repostories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private StudentRepository studentRepository; // Changer le nom du repository pour respecter les conventions
    @Autowired
    private SeanceRepository seanceRepository; // Changer le nom du repository pour respecter les conventions
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private PersonneRepository personneRepository; // Changer le nom du repository pour respecter les conventions

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Création d'un cours
        Cours cours = new Cours();
        cours.setTitle("JEE");
        cours.setDescription("Cours de JEE");
        cours = coursRepository.save(cours);

        // Création d'un professeur
        Teacher teacher = new Teacher();
        teacher.setName("teacher1");
        teacher.setDateOfBirth(new Date());
        teacher.setDateAffectation(new Date());
        teacher = personneRepository.save(teacher);

        // Associer le cours au professeur
        teacher.setCours(cours);
        teacher = personneRepository.save(teacher);

        // Création d'une séance
        seance seance = new seance();
        seance.setDate(new Date());
        seance.setH_debut(new Date());
        seance.setH_fin(new Date());
        seance.setCours(cours);
        seance = seanceRepository.save(seance);

        // Création d'un étudiant
        Student student = new Student();
        student.setMatricule("V4285");
        student.setName("Etudiant 1");
        student.setDateOfBirth(new Date());

        student = personneRepository.save(student);

        // Associer l'étudiant à la séance
        List<seance> seances = new ArrayList<>();
        seances.add(seance);
        List<Student> etudiants = new ArrayList<>();
        etudiants.add(student);
        seance.setStudents(etudiants);
        student.setSeances(seances);
        personneRepository.save(student);
        seanceRepository.save(seance);



        // Afficher les informations
        System.out.println("Voici le professeur");
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(teacherFromList -> {
            System.out.println(teacherFromList.toString());
        });
        System.out.println("Voici l'etudiant");
        List <Student> students= studentRepository.findAll();
        students.forEach(studentFromList->{
            System.out.println(studentFromList.toString());
        });
        System.out.println("Voici les cours");
        List <Cours> cour= coursRepository.findAll();
        cour.forEach(courFromList->{
            System.out.println(courFromList.toString());
        });
        System.out.println("Voici les seances");

        List <seance> seances1= seanceRepository.findAll();
        seances1.forEach(seanceFromList->{
            System.out.println(seanceFromList.toString());
        });
        System.out.println("Voici les personnes");

        List <Personne> personnes1= personneRepository.findAll();
        personnes1.forEach(personneFromList->{
            System.out.println(personneFromList.toString());
        });
        //updateCours
        Cours updateCours=new Cours();
        updateCours.setTitle("Title2");
        updateCours.setDescription("Description2");
        coursRepository.save(updateCours);
        System.out.println("Voici le cour avand modification");
        System.out.println(updateCours);
        updateCours.setDescription("Desc2");
        coursRepository.save(updateCours);
        System.out.println("Voici le cour aprés modification");
        System.out.println(updateCours);
        //UpdateEtudiant
        Student updatestudent=new Student();
        updatestudent.setName("Student2");
        updatestudent.setMatricule("Matricule2");
        updatestudent.setDateOfBirth(new Date(1980,12,10));
        personneRepository.save(updatestudent);
        System.out.println("Voici l'etudiant avand modification");
        System.out.println(updatestudent);
        updatestudent.setName("Taha");
        personneRepository.save(updatestudent);
        System.out.println("Voici l'etudiant aprés modification");
        System.out.println(updatestudent);
        //UpdateTeacher
        Teacher updateTeacher=new Teacher();
        updateTeacher.setName("Teacher 2");
        updateTeacher.setDateOfBirth(new Date(1996,12,24));
        updateTeacher.setDateAffectation(new Date(2024,05,28));
        personneRepository.save(updateTeacher);
        System.out.println("Voici le professeur avant modification");
        System.out.println(updateTeacher);
        updateTeacher.setDateAffectation(new Date(2024,02,07));
        personneRepository.save(updateTeacher);
        System.out.println("Voici l'etudiant aprés modification");
        System.out.println(updateTeacher);
        //UpdateSeance
        seance updateseance = new seance();
        updateseance.setH_debut(new Date());
        updateseance.setH_fin(new Date());
        updateseance.setDate(new Date());
        seanceRepository.save(updateseance);
        System.out.println("Voici la seance avant modification");
        System.out.println(updateseance);
        updateseance.setDate(new Date(2024,12,5));
        System.out.println("Voici la seance aprés modification");
        System.out.println(updateseance);
        //Delete Student
        Student studentDelete = new Student();
        studentDelete.setName("Student3");
        studentDelete.setMatricule("VG785");
        studentDelete.setDateOfBirth(new Date(1998,12,14));
        studentRepository.save(studentDelete);
        System.out.println(studentRepository.findById(5).get());
        studentRepository.delete(studentDelete);
        try {
            System.out.println(studentRepository.findById(5).get());
        } catch (Exception exception) {
            System.out.println("The student has been deleted");
        }
        //Delete Teacher
        Teacher teacherDelete = new Teacher();
        teacherDelete.setName("teacher3");
        teacherDelete.setDateAffectation(new Date(2011,12,18));
        teacherDelete.setDateOfBirth(new Date(1999,12,14));
        personneRepository.save(teacherDelete);
        System.out.println(personneRepository.findById(6).get());
        personneRepository.delete(teacherDelete);
        try {
            System.out.println(teacherRepository.findById(6).get());
        } catch (Exception exception) {
            System.out.println("The teacher has been deleted");
        }
        //Delete Cours
        Cours coursDelete = new Cours();
        coursDelete.setTitle("Title3");
        coursDelete.setDescription("Description3");
        coursRepository.save(coursDelete);
        System.out.println(coursRepository.findById(3).get());
        coursRepository.delete(coursDelete);
        try {
            System.out.println(coursRepository.findById(3).get());
        } catch (Exception exception) {
            System.out.println("The course has been deleted");
        }
        //Delete Seance
        seance seanceDelete = new seance();
        seanceDelete.setH_fin(new Date());
        seanceDelete.setH_debut(new Date());
        seanceDelete.setDate(new Date());
        seanceRepository.save(seanceDelete);
        System.out.println(seanceRepository.findById(3).get());
        seanceRepository.delete(seanceDelete);
        try {
            System.out.println(seanceRepository.findById(3).get());
        } catch (Exception exception) {
            System.out.println("The seance has been deleted");
        }
















    }
}