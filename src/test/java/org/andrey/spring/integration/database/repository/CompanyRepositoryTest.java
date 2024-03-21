package org.andrey.spring.integration.database.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.integration.annotation.IT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private final EntityManager entityManager;

    private final TransactionTemplate transactionTemplate;
    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
            Company company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void save() {
        Company company = Company.builder()
                .name("apple")
                .locales(Map.of(
                        "en", "Apple description",
                        "ru", "Apple описание"
                ))
                .build();

        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}