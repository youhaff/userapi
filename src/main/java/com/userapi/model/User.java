package com.userapi.model;

import com.userapi.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "\"USER\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;
}
