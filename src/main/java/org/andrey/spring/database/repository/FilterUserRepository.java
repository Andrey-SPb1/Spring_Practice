package org.andrey.spring.database.repository;

import org.andrey.spring.database.entity.User;
import org.andrey.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
