//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.model.bookViewing.RentalApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
@Primary
public class RentalApplicationRepositoryImp extends JdbcDaoSupport implements RentalApplicationRepository {

    @Autowired
    public RentalApplicationRepositoryImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public RentalApplicationRepositoryImp(){ }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<RentalApplication> GetRentalApplicationPropertyID(String propertyID) {
        String sql = "select * from rent_application WHERE propertyId="+propertyID;
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(RentalApplication.class));

    }

}
