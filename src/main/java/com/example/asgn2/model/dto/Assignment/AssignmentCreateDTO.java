package com.example.asgn2.model.dto.Assignment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AssignmentCreateDTO {

    private Integer labNr;
    private String assignmentName;
    private String assignmentDeadline;
    private String assignmentDescription;
}
