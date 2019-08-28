package com.dawntechbd.repo;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.entity.references.Reference;
import com.dawntechbd.entity.skills.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceRepo extends JpaRepository<Reference, Long> {
    List<Reference> findAllByUser(User user);

}
