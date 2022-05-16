package com.dalhousie.university.novahousing.repository.adminPostAction;

// Author- Anita Kumari (B00884141)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminPostActionRepositoryImpl implements AdminPostActionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean approvePost(String id,String approveStatus) {
        String updateQuery = "UPDATE Posts set adminApproved = ? where id = ?";
        this.jdbcTemplate.update(updateQuery, approveStatus,id );
        return true;
    }
}
