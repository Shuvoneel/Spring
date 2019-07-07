package com.dawntechbd.SpringHibernate.repository;

import com.dawntechbd.SpringHibernate.entity.Country;
import com.dawntechbd.SpringHibernate.entity.Department;
import com.dawntechbd.SpringHibernate.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Long> {

    List<Division> findAllByCountry(Country country);
}
