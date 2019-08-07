package com.dawntechbd.repo;

import com.dawntechbd.entity.references.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepo extends JpaRepository<Reference, Long> {
}
