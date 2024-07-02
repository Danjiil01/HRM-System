package com.tms.hrm.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_part")
    private String schoolPart;

    @Column(name = "availability_date")
    private Date availabilitiyDate;

    @Column(name = "starting_date", nullable = true)
    private Date startingDate;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
