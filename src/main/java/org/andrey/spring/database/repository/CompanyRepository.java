package org.andrey.spring.database.repository;

import org.andrey.spring.bpp.Auditing;
import org.andrey.spring.bpp.InjectBean;
import org.andrey.spring.bpp.Transaction;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete() {
        System.out.println("delete method...");
    }
}
