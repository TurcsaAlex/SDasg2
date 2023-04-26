package com.example.asgn2.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String error;
    private String errorDescription;

    public String toJson() {
        return "{" +
                "\"error\":\"" + error + '\"' +
                ",\n\"error_description\":\"" + errorDescription + '\"' +
                '}';
    }
}
