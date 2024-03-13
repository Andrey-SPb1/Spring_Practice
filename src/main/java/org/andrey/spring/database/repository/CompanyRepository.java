package org.andrey.spring.database.repository;

import org.andrey.spring.bpp.Auditing;
import org.andrey.spring.bpp.Transaction;
import org.andrey.spring.database.entity.Company;
import org.andrey.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

//    @Resource(name = "pool1")
//    @Qualifier("pool1")
    @Autowired
    private ConnectionPool pool2;

    @Autowired
    private List<ConnectionPool> pools;

    @Value("${db.pool.size}")
    private Integer poolSize;

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
    public void delete(Company entity) {
        System.out.println("delete method...");
    }

//    @Autowired
//    public void setPool2(ConnectionPool pool2) {
//        this.pool2 = pool2;
//    }
}
