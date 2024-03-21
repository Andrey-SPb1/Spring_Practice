package org.andrey.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.database.repository.UserRepository;
import org.andrey.spring.integration.annotation.IT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
    }
}