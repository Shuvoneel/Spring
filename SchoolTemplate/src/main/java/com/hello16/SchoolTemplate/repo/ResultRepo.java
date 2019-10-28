package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.Result;
import com.hello16.SchoolTemplate.entity.Student;
import com.hello16.SchoolTemplate.entity.Teacher;
import com.hello16.SchoolTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long> {

    List<Result> findAllByUser(User user);

    List<Result> findAllByStudent(Student student);

    List<Result> findAllByTeacher(Teacher teacher);
}
