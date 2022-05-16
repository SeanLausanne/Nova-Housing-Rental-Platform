//Author: Sidharth
package com.dalhousie.university.novahousing.repository.bookViewing;

import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import com.dalhousie.university.novahousing.services.rentGenerator.CreditScoreCalculatorService;
import com.dalhousie.university.novahousing.services.rentGenerator.CreditScoreCalculatorServiceImpl;
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
public class UserDetailsRepositoryImpl extends JdbcDaoSupport implements UserDetailsRepository{

    @Autowired
    public UserDetailsRepositoryImpl(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public UserDetailsRepositoryImpl() {
    }

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public UserDetails getUserDetails(String username) {
        String sql="SELECT * FROM user_details WHERE username='"+username+"';";
        List<UserDetails> UserList=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserDetails.class));

        if(UserList.size()>0){
        return UserList.get(0);}
        else{
            return null;
        }
    }

    @Override
    public void addUserDetails(UserDetails userDetails) {

        String username=userDetails.getUsername();
        String user_status=userDetails.getUser_status();
        int annual_income=userDetails.getAnnual_income();
        boolean rental_history=userDetails.isRental_history();
        CreditScoreCalculatorService creditScoreCalculatorService =new CreditScoreCalculatorServiceImpl();
        int credit_score= creditScoreCalculatorService.calculateCredit(user_status,annual_income,rental_history);

        String query = "INSERT INTO user_details VALUES (?, ?, ?, ?, ?)";
        int update=this.getJdbcTemplate().update(query, new Object[] { username,credit_score,user_status,annual_income,rental_history});
        System.out.println("update = "+ String.valueOf(update));
    }

}
