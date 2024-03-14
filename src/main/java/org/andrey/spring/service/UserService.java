package org.andrey.spring.service;

import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.database.repository.CrudRepository;
import org.andrey.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
