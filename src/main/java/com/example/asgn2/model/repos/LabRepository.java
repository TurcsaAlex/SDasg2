package com.example.asgn2.model.repos;

import com.example.asgn2.model.Lab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LabRepository extends JpaRepository<Lab,Integer> {

    Optional<Lab> getLabByLabNr(Integer labNr);
    void deleteByLabNr(Integer labNr);}
