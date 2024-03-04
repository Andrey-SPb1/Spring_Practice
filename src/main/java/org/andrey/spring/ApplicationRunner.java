package org.andrey.spring;

import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.database.repository.UserRepository;
import org.andrey.spring.ioc.Container;
import org.andrey.spring.service.UserService;

public class ApplicationRunner {
    public static void main(String[] args) {

        Container container = new Container();

//        ConnectionPool connectionPool = new ConnectionPool();
//        UserRepository userRepository = new UserRepository(connectionPool);
//        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
//        UserService userService = new UserService(userRepository, companyRepository);

        UserService userService = container.get(UserService.class);
        // TODO: 04.03.2024
    }
}
