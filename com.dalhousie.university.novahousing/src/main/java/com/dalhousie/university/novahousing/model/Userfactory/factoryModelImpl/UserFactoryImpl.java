package com.dalhousie.university.novahousing.model.Userfactory.factoryModelImpl;


// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import com.dalhousie.university.novahousing.model.Userfactory.model.AdminUser;
import com.dalhousie.university.novahousing.model.Userfactory.model.GeneralUser;
import com.dalhousie.university.novahousing.model.Userfactory.model.LandlordUser;
import com.dalhousie.university.novahousing.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserFactoryImpl implements UserFactory{

    @Autowired
    private static AdminUser adminUser;

    @Autowired
    private GeneralUser generalUser;

    @Autowired
    private LandlordUser landlordUser;

    private static final Map<Role, User> handler = new HashMap<Role, User>();

    @PostConstruct
    private Map<Role, User> getObject() {
        handler.put(Role.ROLE_ADMIN, adminUser);
        handler.put(Role.ROLE_USER, generalUser);
        handler.put(Role.ROLE_LANDLORD, landlordUser);
        return handler;
    }

    @Override
    public User createInstance(Role role) throws Exception {
        return Optional.ofNullable(handler.get(role)).orElseThrow(() -> new IllegalArgumentException("Invalid Role Type"));
    }
}
