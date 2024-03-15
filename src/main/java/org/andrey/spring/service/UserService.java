package org.andrey.spring.service;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.repository.CrudRepository;
import org.andrey.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
