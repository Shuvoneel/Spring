package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
    Role findRoleByRoleName(String roleName);
}
