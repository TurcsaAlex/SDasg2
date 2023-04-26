package com.example.asgn2.controlers.teacher;

import com.example.asgn2.model.Lab;
import com.example.asgn2.model.dto.Lab.LabCreateDTO;
import com.example.asgn2.model.dto.Lab.LabDeleteDTO;
import com.example.asgn2.model.dto.Lab.LabUpdateDTO;
import com.example.asgn2.services.LabService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class LabController {

    private LabService labService;

    @GetMapping("/lab")
    public @ResponseBody List<Lab> createLab() {
        return labService.getLabs();
    }

    @PostMapping("/lab")
    public @ResponseBody Lab createLab(@RequestBody LabCreateDTO labCreateDTO) {
        return labService.createLab(labCreateDTO);
    }

    @PutMapping("/lab")
    public @ResponseBody Lab updateLab(@RequestBody LabUpdateDTO labUpdateDTO) {
        return labService.updateLab(labUpdateDTO);
    }

    @DeleteMapping("/lab")
    public @ResponseBody ResponseEntity<?> deleteLab(@RequestBody LabDeleteDTO labDeleteDTO){
        labService.deleteLab(labDeleteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
