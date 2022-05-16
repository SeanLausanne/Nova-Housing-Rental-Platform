//Author: Sidharth
package com.dalhousie.university.novahousing.services.bookViewing;

import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import com.dalhousie.university.novahousing.repository.bookViewing.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepository userDetailsRepositoryImpl;

    @Override
    public UserDetails getDetails(String username) {
        return userDetailsRepositoryImpl.getUserDetails(username) ;
    }

    @Override
    public void addUserDetails(UserDetails userDetails) {
        userDetailsRepositoryImpl.addUserDetails(userDetails);
    }
}
