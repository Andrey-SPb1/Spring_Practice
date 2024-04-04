package org.andrey.spring.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.andrey.spring.database.entity.Role;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
