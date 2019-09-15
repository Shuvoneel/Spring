package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.jobHistory.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepo extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findAllByUser(User user);
}
