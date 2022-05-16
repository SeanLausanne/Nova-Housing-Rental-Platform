//Author: Sidharth
package com.dalhousie.university.novahousing.services.bookViewing;

import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;

public interface UserDetailsService {
    UserDetails getDetails(String Username);
    void addUserDetails(UserDetails userDetails);
}
