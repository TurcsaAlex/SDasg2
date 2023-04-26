package com.example.asgn2.model.dto.Lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LabCreateDTO {
    private Integer labNr;

    private String labTitle;

    private String labCurricula;

    private String labDescription;
}
