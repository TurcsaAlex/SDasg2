package com.example.asgn2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "assignment_name")
    private String assignmentName;

    @Column(name = "assignment_deadline")
    private String assignmentDeadline;

    @Column(name = "assignment_description")
    private String assignmentDescription;


    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "lab_id")
    private Lab lab;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "assignments_submissions",
            joinColumns = {@JoinColumn(name = "assignment_id")},
            inverseJoinColumns = {@JoinColumn(name = "submissions_id")}
    )
    private Set<Submission> submissions;
}
