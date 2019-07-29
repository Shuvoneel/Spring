package com.dawntechbd.idb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByNameOrEmailOrRoles(String name, String email, Role role);
}
