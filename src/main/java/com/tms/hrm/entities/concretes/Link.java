package com.tms.hrm.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "link")
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "link_url")
    private String linkUrl;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
