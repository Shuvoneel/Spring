package com.hello16.EmailSendinng.repo;

import com.hello16.EmailSendinng.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
