package org.andrey.spring.dto;

import lombok.Value;
import org.andrey.spring.database.entity.Role;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
