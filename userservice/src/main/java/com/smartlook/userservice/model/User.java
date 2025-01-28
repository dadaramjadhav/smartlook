package com.smartlook.userservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.smartlook.userservice.domain.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "full name is mandatory")
    private String fullName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "username is mandatory")
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "email is mandatory")
    @Email(message = "email should be in correct format")
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.CUSTOMER;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt ; 

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime udpatedAt;

    public User( String fullName, String username,    String email,        String phone) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phone = phone;
    } 

}
