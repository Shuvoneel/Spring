package com.hello16.SchoolTemplate.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Result {

    //    Fields Name start..............................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please Evaluate")
    private String subject;

    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=100, message="must be equal or less than 100")
    private int marks;

    @NotEmpty(message = "Please Evaluate")
    private String grade;

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

    public Result() {
    }

    public Result(Long id) {
        this.id = id;
    }


    public Result(@NotEmpty(message = "Please Evaluate") String subject, @Min(value = 0, message = "must be equal or greater than 0") @Max(value = 100, message = "must be equal or less than 100") int marks, @NotEmpty(message = "Please Evaluate") String grade, Student student, Teacher teacher, User user) {
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
