package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.Student;
import com.hello16.SchoolTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByUser(User user);
}
