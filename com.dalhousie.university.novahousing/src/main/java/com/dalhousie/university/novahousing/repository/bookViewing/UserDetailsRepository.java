//Author: Sidharth
package com.dalhousie.university.novahousing.repository.bookViewing;

import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;

public interface UserDetailsRepository {
    UserDetails getUserDetails(String username);
    void addUserDetails(UserDetails userDetails);
}
