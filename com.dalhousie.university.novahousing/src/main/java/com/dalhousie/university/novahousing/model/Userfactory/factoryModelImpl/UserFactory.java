package com.dalhousie.university.novahousing.model.Userfactory.factoryModelImpl;


// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import com.dalhousie.university.novahousing.utils.Role;

public interface UserFactory {
     User createInstance(Role role) throws Exception;
}
