package org.andrey.spring.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.andrey.spring.config.condition.JpaCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init() {
        log.info("Jpa configuration is enabled");
    }

}
