package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByMobile(String mobile);

    User findByUsername(String username);

    User findUserById(Long id);

    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsernameOrEmail(String username, String email);

}
