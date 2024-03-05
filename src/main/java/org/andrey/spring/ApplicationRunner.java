package org.andrey.spring;

import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);
        String driver = context.getBean("driver", String.class);
        CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
    }
}
