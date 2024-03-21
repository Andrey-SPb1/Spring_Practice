package org.andrey.spring.service;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
}
