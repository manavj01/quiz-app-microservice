package com.manav.quiz_service.model;


import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    @ManyToMany
    String title;
}
