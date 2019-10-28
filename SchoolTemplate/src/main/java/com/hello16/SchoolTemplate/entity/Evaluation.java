package com.hello16.SchoolTemplate.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Evaluation {

    //    Fields Name start..............................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please Evaluate")
    private String teaching;

    @NotEmpty(message = "Please Evaluate")
    private String communication;

    @NotEmpty(message = "Please Evaluate")
    private String problemSolving;

    @NotEmpty(message = "Please Evaluate")
    private String listening;

    @NotEmpty(message = "Please Evaluate")
    private String discipline;

    @NotEmpty(message = "Please Evaluate")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //    Fields Name end.........................................

    public Evaluation() {
    }

    public Evaluation(Long id) {
        this.id = id;
    }


    public Evaluation(@NotEmpty(message = "Please Evaluate") String teaching, @NotEmpty(message = "Please Evaluate") String communication, @NotEmpty(message = "Please Evaluate") String problemSolving, @NotEmpty(message = "Please Evaluate") String listening, @NotEmpty(message = "Please Evaluate") String discipline, @NotEmpty(message = "Please Evaluate") String relationship, Student student, Teacher teacher, User user) {
        this.teaching = teaching;
        this.communication = communication;
        this.problemSolving = problemSolving;
        this.listening = listening;
        this.discipline = discipline;
        this.relationship = relationship;
        this.student = student;
        this.teacher = teacher;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getProblemSolving() {
        return problemSolving;
    }

    public void setProblemSolving(String problemSolving) {
        this.problemSolving = problemSolving;
    }

    public String getListening() {
        return listening;
    }

    public void setListening(String listening) {
        this.listening = listening;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
