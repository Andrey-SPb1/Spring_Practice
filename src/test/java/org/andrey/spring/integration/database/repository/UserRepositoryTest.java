package org.andrey.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Role;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.database.repository.UserRepository;
import org.andrey.spring.integration.annotation.IT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkUpdate() {
        User ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN, ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        int resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        ivan.getCompany().getName(); // LazyInitializationException

        User ivan2 = userRepository.getById(1L);
        assertSame(Role.USER, ivan2.getRole());
    }

    @Test
    void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
    }
}