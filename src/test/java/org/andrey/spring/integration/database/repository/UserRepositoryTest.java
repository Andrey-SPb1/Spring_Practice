package org.andrey.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Role;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.database.repository.UserRepository;
import org.andrey.spring.integration.annotation.IT;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkPageable() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
        Slice<User> slice = userRepository.findAllBy(pageRequest);
        slice.forEach(user -> System.out.println(user.getId()));

        while(slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getId()));
        }
    }

    @Test
    void checkSort() {
        Sort.TypedSort<User> sortBy = Sort.sort(User.class);
        Sort sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));

//        Sort sort = Sort.by("username").and(Sort.by("lastname"));
        List<User> users =
                userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(users).hasSize(3);
    }

    @Test
    void checkTopByIdDesc() {
        Optional<User> topUser = userRepository.findTopByOrderByIdDesc();
        assertTrue(topUser.isPresent());
        topUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }

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