package com.dalhousie.university.novahousing.repository.login;

// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.model.login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LoginUser getUserByUsername(String username) {
        String sql = "select * from user where username = ? ";
        Object[] args = {username};
        LoginUser userInfo=jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(LoginUser.class));
        return userInfo;

    }

}
