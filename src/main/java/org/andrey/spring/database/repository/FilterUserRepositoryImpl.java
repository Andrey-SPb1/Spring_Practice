package org.andrey.spring.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.database.querydsl.QPredicates;
import org.andrey.spring.dto.UserFilter;

import java.util.List;

import static org.andrey.spring.database.entity.QUser.*;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository{

    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        Predicate predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstname::containsIgnoreCase)
                .add(filter.lastname(), user.lastname::containsIgnoreCase)
                .add(filter.birthDate(), user.birthDate::before)
                .build();

        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }
}
