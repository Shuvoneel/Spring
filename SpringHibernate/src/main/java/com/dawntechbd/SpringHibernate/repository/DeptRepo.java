package com.dawntechbd.SpringHibernate.repository;

import com.dawntechbd.SpringHibernate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department, Long> {
}
