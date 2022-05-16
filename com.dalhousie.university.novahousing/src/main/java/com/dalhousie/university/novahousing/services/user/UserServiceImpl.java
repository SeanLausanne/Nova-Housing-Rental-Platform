package com.dalhousie.university.novahousing.services.user;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.validations.userRegistrationValidation.UserRegistrationValidation;
import com.dalhousie.university.novahousing.validations.userRegistrationValidation.UserRegistrationValidationImpl;
import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import com.dalhousie.university.novahousing.repository.user.UserRepository;
import com.dalhousie.university.novahousing.utils.AESEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    UserRegistrationValidation registrationValidator;

    @Override
    public long registerUser(User userDetails) throws Exception {
        registrationValidator=new UserRegistrationValidationImpl();
        long id=0;

        if(registrationValidator.validateUserInput(userDetails)){
            userDetails.setPassword(AESEncryption.encrypt(userDetails.getPassword()));
            userDetails.setConfirm_password(AESEncryption.encrypt(userDetails.getConfirm_password()));
            id= userRepository.save(userDetails);
        }
        return id;
    }
}
