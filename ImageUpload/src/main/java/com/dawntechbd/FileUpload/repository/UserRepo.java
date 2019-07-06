package com.dawntechbd.FileUpload.repository;

import com.dawntechbd.FileUpload.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByFileName(String fileName);
}
