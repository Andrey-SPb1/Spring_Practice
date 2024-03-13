package org.andrey.spring;

import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.database.repository.CrudRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
            String driver = context.getBean("driver", String.class);
            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
