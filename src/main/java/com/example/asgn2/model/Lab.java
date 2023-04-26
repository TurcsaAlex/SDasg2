package com.example.asgn2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "labs")
public class Lab {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "lab_nr")
    private Integer labNr;

    @Column(name = "lab_title")
    private String labTitle;

    @Column(name = "lab_curricula")
    private String labCurricula;

    @Column(name = "lab_description")
    private String labDescription;

    @OneToMany
    @JoinColumn(name = "lab_id")
    @JsonIgnore
    private Set<Assignment> assignments;

    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
    }
}
