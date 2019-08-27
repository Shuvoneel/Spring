package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByMobile(String mobile);

    User findByUserName(String userName);

    User findUserById(Long id);

    User findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserNameOrEmail(String userName, String email);

}
