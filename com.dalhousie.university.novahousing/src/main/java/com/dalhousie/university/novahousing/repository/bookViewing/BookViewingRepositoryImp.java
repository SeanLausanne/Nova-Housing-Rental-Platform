//Author: Sidharth
package com.dalhousie.university.novahousing.repository.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;
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
public class BookViewingRepositoryImp extends JdbcDaoSupport implements BookViewingRepository{

    @Autowired
    public BookViewingRepositoryImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public BookViewingRepositoryImp() {
    }

    @Override
    public void createViewing(BookViewing bookViewing){
        long BookingID= bookViewing.getBookingID();
        String propertyID = bookViewing.getPropertyID();
        String username= bookViewing.getUsername();
        String visitDate= bookViewing.getVisitDate();
        boolean conformationStatus= bookViewing.isConformationStatus();

        String query = "INSERT INTO viewings_application VALUES (?, ?, ?, ?, ?)";
        int update=this.getJdbcTemplate().update(query, new Object[] { BookingID, propertyID, username, visitDate ,conformationStatus});

        System.out.println("update = "+ String.valueOf(update));
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BookViewing GetViewingDetailsBookingID(long bookingID){
        String sql="SELECT * from viewings_application where bookingID= "+bookingID;
        List<BookViewing> bookingList= jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(BookViewing.class));
        return bookingList.get(0);
    }

    @Override
    public void approveViewing(long bookingID) {
        String query = "UPDATE viewings_application SET conformationStatus=true where bookingID="+bookingID+";";
        int update=this.getJdbcTemplate().update(query);
        System.out.println("update= "+String.valueOf(update));
    }

    @Override
    public List<BookViewing> GetViewingDetailsPropertyID(String propertyID) {
        String sql = "select * from viewings_application WHERE propertyID='"+propertyID+"';";

        List<BookViewing> BookingList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(BookViewing.class));
        return BookingList;
    }

    @Override
    public List<BookViewing> getAllViewings() {
        String sql = "select * from viewings_application";

        List<BookViewing> BookingList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(BookViewing.class));

        return BookingList;
    }
}
