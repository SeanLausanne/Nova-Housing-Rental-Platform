//Author: Sidharth
package com.dalhousie.university.novahousing.controller.bookViewing;
import com.dalhousie.university.novahousing.services.bookViewing.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BookViewing/ApplicationSuccess")
public class ApplicationSuccessController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public String ApplicationSuccessful(Model model){
        String username="test";
        if(userDetailsService.getDetails(username)!=null){
        model.addAttribute("userDetails", userDetailsService.getDetails(username));}
        else
        { model.addAttribute("userDetails",null);}
        return "ApplicationSuccess";
    }

}
