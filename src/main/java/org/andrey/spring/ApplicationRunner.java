package org.andrey.spring;

import org.andrey.spring.config.ApplicationConfiguration;
import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);

            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
