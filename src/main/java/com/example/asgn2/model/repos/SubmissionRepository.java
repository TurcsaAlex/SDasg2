package com.example.asgn2.model.repos;

import com.example.asgn2.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
}
