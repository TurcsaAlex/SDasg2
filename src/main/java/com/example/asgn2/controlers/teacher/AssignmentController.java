package com.example.asgn2.controlers.teacher;

import com.example.asgn2.model.Assignment;
import com.example.asgn2.model.dto.Assignment.AssignmentCreateDTO;
import com.example.asgn2.model.dto.Assignment.AssignmentUpdateDTO;
import com.example.asgn2.services.AssignmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class AssignmentController {
    private AssignmentService assignmentService;

    @PostMapping("/assignment")
    public @ResponseBody Assignment createAssignment(@RequestBody AssignmentCreateDTO createDTO) {
        return assignmentService.createAssignment(createDTO);
    }

    @PutMapping("/assignmnet")
    public  @ResponseBody Assignment updateAssignment(@RequestBody AssignmentUpdateDTO updateDTO){

    }

}
