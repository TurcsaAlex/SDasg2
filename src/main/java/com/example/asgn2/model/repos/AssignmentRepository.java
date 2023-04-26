package com.example.asgn2.model.repos;

import com.example.asgn2.model.Assignment;
import com.example.asgn2.model.Lab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    Optional<Assignment> getAssignmentByAssignmentName(String assignmentName);

    @Override
    Assignment getById(Integer integer);

    List<Assignment> getAssignmentsByLab(Lab lab);
}
