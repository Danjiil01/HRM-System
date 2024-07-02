package com.tms.hrm.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "employment_type")
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "employmentType")
    private List<JobAdvertisement> jobAdvertisements;
}
