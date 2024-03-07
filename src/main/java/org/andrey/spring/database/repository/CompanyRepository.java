package org.andrey.spring.database.repository;

import org.andrey.spring.bpp.InjectBean;
import org.andrey.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;

}
