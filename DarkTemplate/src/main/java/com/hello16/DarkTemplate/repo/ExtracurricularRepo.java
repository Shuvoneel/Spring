package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.skills.Extracurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtracurricularRepo extends JpaRepository<Extracurricular, Long> {
    List<Extracurricular> findAllByUser(User user);

}
