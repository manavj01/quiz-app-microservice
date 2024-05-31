package com.manav.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ElementCollection
    private List<Integer> questionIds;
}
