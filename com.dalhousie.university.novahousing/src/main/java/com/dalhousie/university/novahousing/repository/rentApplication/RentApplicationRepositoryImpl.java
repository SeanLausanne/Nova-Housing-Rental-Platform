package com.dalhousie.university.novahousing.repository.rentApplication;

//Author: Rutu Sadaykumar Joshi

import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RentApplicationRepositoryImpl implements RentApplicationRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long applyRent(RentApplication rentApplicationObj) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("rent_application").usingColumns("applier_username","propertyId","moveInDate","phone_number","animal","occupants","annualsalary");
        BeanPropertySqlParameterSource rentApplicationParam = new BeanPropertySqlParameterSource(rentApplicationObj);
        int id=insertActor.execute(rentApplicationParam);
        return id;
    }
}
