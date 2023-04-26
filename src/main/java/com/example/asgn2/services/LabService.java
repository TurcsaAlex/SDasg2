package com.example.asgn2.services;

import com.example.asgn2.model.Lab;
import com.example.asgn2.model.dto.Lab.LabCreateDTO;
import com.example.asgn2.model.dto.Lab.LabDeleteDTO;
import com.example.asgn2.model.dto.Lab.LabUpdateDTO;
import com.example.asgn2.model.exceptions.service.LabMissingError;
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
public class LabService {
    @Autowired
    private LabRepository labRepository;

    public Lab createLab(LabCreateDTO labCreateDTO){
        Integer labNr=labCreateDTO.getLabNr();
        String labTitle=labCreateDTO.getLabTitle();
        String labCurricula=labCreateDTO.getLabCurricula();
        String labDescription=labCreateDTO.getLabDescription();

        Lab lab=new Lab(0,labNr,labTitle,labCurricula,labDescription, Set.of());
        labRepository.save(lab);
        return labRepository.getLabByLabNr(labNr).get();
    }

    public Lab updateLab(LabUpdateDTO labUpdateDTO) throws LabMissingError{
        Integer labNr= labUpdateDTO.getLabNr();
        if(labRepository.getLabByLabNr(labNr).isEmpty()){
            throw new LabMissingError();
        }
        Lab presentLab=labRepository.getLabByLabNr(labNr).get();

        String labTitle= labUpdateDTO.getLabTitle();
        String labCurricula= labUpdateDTO.getLabCurricula();
        String labDescription= labUpdateDTO.getLabDescription();

        presentLab.setLabCurricula(labCurricula);
        presentLab.setLabDescription(labDescription);
        presentLab.setLabTitle(labTitle);

        labRepository.save(presentLab);
        return presentLab;
    }

    public void deleteLab(LabDeleteDTO labDeleteDTO) throws  LabMissingError{
        if(labRepository.getLabByLabNr(labDeleteDTO.getLabDeleteNr()).isEmpty()){
            throw new LabMissingError();
        }
        labRepository.deleteByLabNr(labDeleteDTO.getLabDeleteNr());
    }

    public List<Lab> getLabs(){
        return labRepository.findAll();
    }

}
