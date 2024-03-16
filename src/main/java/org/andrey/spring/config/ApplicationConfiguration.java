package org.andrey.spring.config;

import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.database.repository.UserRepository;
import org.andrey.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {

        @Bean("pool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username) {
                return new ConnectionPool(username, 20);
        }
        @Bean
        public ConnectionPool pool3() {
                return new ConnectionPool("username", 25);
        }

        @Bean
        public UserRepository userRepository2(ConnectionPool pool2) {
                return new UserRepository(pool2);
        }

        @Bean
        @Profile("prod|web")
        public UserRepository userRepository3() {
                ConnectionPool connectionPool = pool3();
                ConnectionPool connectionPool2 = pool3();
                return new UserRepository(pool3());
        }
}
