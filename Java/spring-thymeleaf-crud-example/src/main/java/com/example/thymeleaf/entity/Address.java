package com.example.thymeleaf.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "address")
@EqualsAndHashCode(of = {"id"})
public class Address {

    @Id
    private String id;

    @Column(name = "zip_code")
    @Pattern(regexp = "^[0-9\\-]$")
    @NotEmpty
    private String zipCode;

    @Size(min = 1, max = 30)
    @Pattern(regexp = "^[a-zA-Z]$")
    @NotEmpty
    private String street;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^[0-9]$")
    @NotEmpty
    private int number;

    @Size(min = 1, max = 35)
    @Pattern(regexp = "^[a-zA-Z]$")
    @NotEmpty
    private String complement;

    @Size(min = 1, max = 35)
    @Pattern(regexp = "^[a-zA-Z]$")
    @NotEmpty
    private String district;

    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[a-zA-Z]$")
    @NotEmpty
    private String city;

    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[a-zA-Z]$")
    @NotEmpty
    private String state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "fk_student")
    private Student student;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
