package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByUsernameOrPassword(String username, String password);

}
