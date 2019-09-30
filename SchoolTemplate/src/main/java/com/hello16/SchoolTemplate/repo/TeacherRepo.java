package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.Teacher;
import com.hello16.SchoolTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Teacher findByUser(User user);
}
