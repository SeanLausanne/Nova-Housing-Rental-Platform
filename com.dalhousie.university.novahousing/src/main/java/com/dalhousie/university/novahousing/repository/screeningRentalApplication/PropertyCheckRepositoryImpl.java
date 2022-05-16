//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.services.rentGenerator.*;
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
public class PropertyCheckRepositoryImpl extends JdbcDaoSupport implements PropertyCheckRepository{

    @Autowired
    public PropertyCheckRepositoryImpl(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public PropertyCheckRepositoryImpl() {
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void setPropertyChecks(PropertyChecks propertyChecks) throws FilterNotValidException {

        String propertyID=propertyChecks.getPropertyID();

        RentGeneratorService rentGeneratorService=new RentGeneratorServiceImpl();
        int rent = rentGeneratorService.generateRent(propertyID);

        MinAnnualIncomeService minAnnualIncomeService=new MinAnnualIncomeServiceImpl();
        int minAnnualIncome= minAnnualIncomeService.minAnnualIncome(rent);

        String preferredTenantStatus= propertyChecks.getPreferredTenantStatus();

        boolean preferredRentalHistory=propertyChecks.isPreferredRentalHistory();

        CreditScoreCalculatorService creditScoreCalculatorService =new CreditScoreCalculatorServiceImpl();
        int minCreditScore= creditScoreCalculatorService.calculateCredit(preferredTenantStatus,minAnnualIncome,preferredRentalHistory);

        String query = "INSERT INTO property_checks VALUES (?, ?, ?, ?, ?, ?)";
        int update=this.getJdbcTemplate().update(query, new Object[] { propertyID, rent, minAnnualIncome, preferredTenantStatus, preferredRentalHistory, minCreditScore});
        System.out.println("update = "+ String.valueOf(update));
    }

    @Override
    public PropertyChecks getPropertyChecks(String propertyID) {
        String sql="SELECT * FROM property_checks WHERE propertyID='"+propertyID+"';";
        List<PropertyChecks> propertyChecksList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PropertyChecks.class));
        if(propertyChecksList.size()>0){
            return propertyChecksList.get(0);}
        else{
            return null;
        }
    }
}
