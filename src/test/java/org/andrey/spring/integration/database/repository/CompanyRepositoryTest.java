package org.andrey.spring.integration.database.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.integration.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private static final Integer COMPANY_ID = 6;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries() {
        companyRepository.findByName("google");
        companyRepository.findAllByNameContainingIgnoreCase("a");
    }

    @Test
    void delete() {
        Optional<Company> optionalCompany = companyRepository.findById(COMPANY_ID);
        assertTrue(optionalCompany.isPresent());
        optionalCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(COMPANY_ID).isEmpty());
    }

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
                .name("Apple")
                .locales(Map.of(
                        "en", "Apple description",
                        "ru", "Apple описание"
                ))
                .build();

        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}