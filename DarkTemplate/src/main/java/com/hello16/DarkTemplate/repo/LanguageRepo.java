package com.hello16.DarkTemplate.repo;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.entity.languageDetails.LanguageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepo extends JpaRepository<LanguageDetails, Long> {
    List<LanguageDetails> findAllByUser(User user);
}
