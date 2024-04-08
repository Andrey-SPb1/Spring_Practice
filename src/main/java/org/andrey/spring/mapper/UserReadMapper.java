package org.andrey.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.dto.CompanyReadDto;
import org.andrey.spring.dto.UserReadDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper <User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto company = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getImage(),
                object.getRole(),
                company
        );
    }
}
