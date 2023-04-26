package com.example.asgn2.model;

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
@Table(name = "submissions")
public class Submission {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Double grade;
    @Column(name = "submission_link")
    private String submissionLink;

    @Column(name="submisson_comment")
    private String submissionComment;

    @Getter
    @Setter
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "submissions")

    private Set<Assignment> assignments= new HashSet<>();
}
