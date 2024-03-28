package org.andrey.spring.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.entity.Role;
import org.andrey.spring.database.entity.User;
import org.andrey.spring.database.querydsl.QPredicates;
import org.andrey.spring.dto.PersonalInfo;
import org.andrey.spring.dto.UserFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.andrey.spring.database.entity.QUser.*;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository{

    private static final String FIND_BY_COMPANY_AND_ROLE = """
            SELECT
                firstname,
                lastname,
                birth_date
            FROM users
            WHERE company_id = ?
                AND role = ?
            """;

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

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

    @Override
    public List<PersonalInfo> findAllByCompanyAndRole(Integer companyId, Role role) {
        return jdbcTemplate.query(FIND_BY_COMPANY_AND_ROLE, (rs, rowNum) -> new PersonalInfo(
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getDate("birth_date").toLocalDate()
        ), companyId, role.name());
    }
}
