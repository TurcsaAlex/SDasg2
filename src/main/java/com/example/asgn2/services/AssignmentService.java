package com.example.asgn2.services;

import com.example.asgn2.model.Assignment;
import com.example.asgn2.model.Lab;
import com.example.asgn2.model.dto.Assignment.AssignmentCreateDTO;
import com.example.asgn2.model.dto.Assignment.AssignmentDeleteDTO;
import com.example.asgn2.model.dto.Assignment.AssignmentGetByLabDTO;
import com.example.asgn2.model.dto.Assignment.AssignmentUpdateDTO;
import com.example.asgn2.model.dto.Lab.LabCreateDTO;
import com.example.asgn2.model.dto.Lab.LabDeleteDTO;
import com.example.asgn2.model.dto.Lab.LabUpdateDTO;
import com.example.asgn2.model.exceptions.service.LabMissingError;
import com.example.asgn2.model.exceptions.service.MyError;
import com.example.asgn2.model.repos.AssignmentRepository;
import com.example.asgn2.model.repos.LabRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private LabRepository labRepository;

    public Assignment createAssignment(AssignmentCreateDTO assignmentCreateDTO)throws LabMissingError{

        Integer labNr=assignmentCreateDTO.getLabNr();
        String assignmentName=assignmentCreateDTO.getAssignmentName();
        String assignmentDeadline= assignmentCreateDTO.getAssignmentDeadline();
        String assignmentDescription= assignmentCreateDTO.getAssignmentDescription();
        if(labRepository.getLabByLabNr(labNr).isEmpty()){
            throw new LabMissingError();
        }
        Lab lab=labRepository.getLabByLabNr(labNr).get();
        Assignment assignment=new Assignment(0,assignmentName,assignmentDeadline,assignmentDescription,lab,Set.of());
        assignmentRepository.save(assignment);
        Assignment newAssignment=assignmentRepository.getAssignmentByAssignmentName(assignmentName).get();
        lab.addAssignment(newAssignment);
        return newAssignment;
    }

    public Assignment updateAssignment(AssignmentUpdateDTO assignmentUpdateDTO) throws Exception{
        Integer labNr= assignmentUpdateDTO.getLabNr();
        if(labRepository.getLabByLabNr(labNr).isEmpty()){
            throw new LabMissingError();
        }
        Lab presentLab=labRepository.getLabByLabNr(labNr).get();
        Integer id=assignmentUpdateDTO.getId();
        Assignment assignment=assignmentRepository.getById(id);
        if(assignment==null){
            throw new MyError("no assignment");
        }
        String assignmentName=assignmentUpdateDTO.getAssignmentName();
        String assignmentDeadline=assignmentUpdateDTO.getAssignmentDeadline();
        String assignmentDescription= assignmentUpdateDTO.getAssignmentDescription();

        assignment.setAssignmentDeadline(assignmentDeadline);
        assignment.setLab(presentLab);
        assignment.setAssignmentDescription(assignmentDescription);
        assignment.setAssignmentName(assignmentName);

        assignmentRepository.save(assignment);
        return assignment;
    }
    public void deleteAssignment(AssignmentDeleteDTO assignmentDeleteDTO) throws MyError {
       assignmentRepository.deleteById(assignmentDeleteDTO.getDeleteId());
    }

    public List<Assignment> getAllByLab(AssignmentGetByLabDTO assignmentGetByLabDTO){
        if(labRepository.getLabByLabNr(assignmentGetByLabDTO.getLabNr()).isEmpty()){
            throw new LabMissingError();
        }
        Lab lab=labRepository.getLabByLabNr(assignmentGetByLabDTO.getLabNr()).get();
        return assignmentRepository.getAssignmentsByLab(lab);
    }

}
