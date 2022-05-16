package com.dalhousie.university.novahousing.repository.user;

// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserRepositoryImpl  implements UserRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public long save(User userDetails){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("user").usingColumns("firstName","lastName","username","password","confirm_password","phone_number","role");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(userDetails);
        return insertActor.execute(param);
    }
}
