//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.model.screenRenters.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class RentalRepositoryImpl extends JdbcDaoSupport implements RentalRepository {

    @Autowired
    public RentalRepositoryImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public RentalRepositoryImpl() {
    }

    public Rental getRentalDetails(String propertyID) {

        String sql = "SELECT * FROM Posts WHERE id='1639014167000'";
        System.out.println("A");

        assert this.getJdbcTemplate() != null;
        List<Rental> rentalList = this.getJdbcTemplate().query(sql,BeanPropertyRowMapper.newInstance(Rental.class));

        if (rentalList.size() > 0) {
            return rentalList.get(0);
        } else {
            return null;
        }
    }
}
