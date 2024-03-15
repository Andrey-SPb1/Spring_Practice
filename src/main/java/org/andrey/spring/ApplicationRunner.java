package org.andrey.spring;

import org.andrey.spring.config.ApplicationConfiguration;
import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.database.repository.CrudRepository;
import org.andrey.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);

            CompanyService companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}
