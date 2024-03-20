package org.andrey.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.pool.ConnectionPool;
import org.andrey.spring.integration.annotation.IT;
import org.andrey.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@IT
@RequiredArgsConstructor
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test() {
        System.out.println();
    }
    @Test
    void test2() {
        System.out.println();
    }
}
