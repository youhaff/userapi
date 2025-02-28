package com.userapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.userapi.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotNull
    private String country;
    private String phoneNumber;
    private Gender gender;
}
