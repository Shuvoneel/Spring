package com.dawntechbd.SpringHibernate.repository;

import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByDepartmentOrderByName(Department department);
    Iterable<Student> findAllByDepartmentAndGender(Department department, String gender);
    long countAllByDepartmentAndGender(Department department, String gender);
    Iterable<Student> findAllByAgeGreaterThanEqual(int age);
}