package com.dalhousie.university.novahousing.controller.userRegistration;

// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.controller.dto.UserDto;
import com.dalhousie.university.novahousing.model.Userfactory.factoryModelImpl.UserFactory;
import com.dalhousie.university.novahousing.model.Userfactory.factoryModelImpl.UserFactoryImpl;
import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import com.dalhousie.university.novahousing.services.user.UserService;
import com.dalhousie.university.novahousing.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    private UserFactory userFactoryImpl;

    @GetMapping
    public String displayRegistrationForm(Model userModal) {
        userModal.addAttribute("userDtoObj",new UserDto());
        userModal.addAttribute("rollTypes", Role.values());
        return "registration";
    }

    @GetMapping("/registrationSuccess")
    public String registrationSuccessful() {
        return "registrationSuccess";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userDtoObj") UserDto userDtoObj) {
        String result="";
        userFactoryImpl = new UserFactoryImpl();
        try{
            User userModal = userFactoryImpl.createInstance(userDtoObj.getRole());//modelMapper.map(), User.class);
            userModal.setFirstName(userDtoObj.getFirstName());
            userModal.setLastName(userDtoObj.getLastName());
            userModal.setUsername(userDtoObj.getUsername());
            userModal.setConfirm_password(userDtoObj.getConfirm_password());
            userModal.setPhone_number(userDtoObj.getPhone_number());
            userModal.setRole(userDtoObj.getRole());
            userModal.setPassword(userDtoObj.getPassword());
            if(userService.registerUser(userModal)==0){
                result="redirect:/registration?error";
            }
            else{
                result="redirect:/registration/registrationSuccess";
            }
        }catch(Exception ex){
            result="redirect:/registration?error";
            System.out.println(ex);
        } finally{
            return result;
        }
    }
}
