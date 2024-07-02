package com.tms.hrm.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "preliminary_explanation")
@AllArgsConstructor
@NoArgsConstructor
public class PreliminaryExplanation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "explanation")
    private String explanation;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
