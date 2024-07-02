package com.tms.hrm.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "verified_code")
@AllArgsConstructor
@NoArgsConstructor
public class VerifiedCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @NotNull
    @Column(name = "is_activate", columnDefinition = "boolean default false")
    private Boolean isActivate;

    @NotNull
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    @JsonIgnore
    private Boolean isDeleted = false;

    @Nullable
    @Column(name = "confirmed_date")
    private LocalDate confirmedDate;

    public VerifiedCode(int userId, String verificationCode, LocalDate expiredDate) {
        super();
        this.userId = userId;
        this.verificationCode = verificationCode;
        this.expiredDate = expiredDate;
    }
}
