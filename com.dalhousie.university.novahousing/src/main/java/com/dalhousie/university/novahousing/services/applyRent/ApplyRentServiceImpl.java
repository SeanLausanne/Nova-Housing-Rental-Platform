//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.services.applyRent;

import com.dalhousie.university.novahousing.services.email.EmailSenderService;
import com.dalhousie.university.novahousing.services.email.EmailSenderServiceImpl;
import com.dalhousie.university.novahousing.validations.applyRent.ValidateApplyRent;
import com.dalhousie.university.novahousing.validations.applyRent.ValidateApplyRentImpl;
import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.repository.rentApplication.RentApplicationRepository;
import com.dalhousie.university.novahousing.services.filters.AdminApprovalFilter;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import com.dalhousie.university.novahousing.services.postSearch.PostSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyRentServiceImpl implements ApplyRentService{

    @Autowired
    private PostSearcher postSearcherService;

    @Autowired
    RentApplicationRepository applyRentRepository;

    EmailSenderService emailSenderService;

    ValidateApplyRent validateApplyRent = new ValidateApplyRentImpl();
    @Override
    public List<Post> getAllPostProperty() throws FilterNotValidException {
        SearchFilter filter = new AdminApprovalFilter("\"Yes\"");
        postSearcherService.addFilter(filter);
        List<Post> posts = postSearcherService.searchPost();
        return posts;
    }

    //Validate user input and store to database
    @Override
    public boolean applyRent(RentApplication rentObj) throws ApplyException {
        emailSenderService = new EmailSenderServiceImpl();
        if (validateApplyRent.validateUserName(rentObj) && validateApplyRent.validateDate(rentObj) && validateApplyRent.validateAnimal(rentObj) && validateApplyRent.validatePhonenumber(rentObj) && validateApplyRent.validateOccupants(rentObj) && validateApplyRent.validateSalary(rentObj)) {
      //      emailSenderService.sendSimpleEmail("rutujo1@gmail.com","Your Application has sent successfully","Your Rental Application");
            long id = applyRentRepository.applyRent(rentObj);
            if (id > -1) {
                return true;
            }
        }
        return false;
    }
}
