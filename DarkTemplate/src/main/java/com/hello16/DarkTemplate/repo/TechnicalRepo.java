package com.hello16.DarkTemplate.repo;


import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.skills.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalRepo extends JpaRepository<Technical, Long> {
    List<Technical> findAllByUser(User user);
}
