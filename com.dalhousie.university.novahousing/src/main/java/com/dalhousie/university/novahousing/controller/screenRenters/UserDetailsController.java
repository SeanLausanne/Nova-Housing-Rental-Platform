//Author: Sidharth
package com.dalhousie.university.novahousing.controller.screenRenters;

import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import com.dalhousie.university.novahousing.services.bookViewing.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/BookViewing/UserDetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @ModelAttribute("userDetails")
    public UserDetails userDetailsDto(){
        return new UserDetails();
    }

    @GetMapping
    public String showUserDetailsForm() {
        return "userDetails";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String SubmitApplication(@ModelAttribute("userDetails") UserDetails UDObj) {
        userDetailsService.addUserDetails(UDObj);
        return "redirect:/BookViewing/ApplicationSuccess";
    }

}
