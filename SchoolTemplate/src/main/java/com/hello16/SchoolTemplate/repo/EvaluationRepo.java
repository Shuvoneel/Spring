package com.hello16.SchoolTemplate.repo;

import com.hello16.SchoolTemplate.entity.Evaluation;
import com.hello16.SchoolTemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findAllByUser(User user);
}
