//Author: Sidharth
package com.dalhousie.university.novahousing.controller.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;
import com.dalhousie.university.novahousing.services.bookViewing.BookViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/RecommendedViewingApplications")
public class RecommendedViewingApplicationsController {

    @Autowired
    private BookViewingService bookViewingService;

    @ModelAttribute("bookViewing")
    public BookViewing bookViewingDto(){
        return new BookViewing();
    }

    @GetMapping
    public String RecommendedApplications(Model model){
            String propertyID= String.valueOf(247);
            model.addAttribute("recommendedApplications", bookViewingService.RecommendedViewingApplication(propertyID));
            return "RecommendedViewingApplications";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String SubmitApplication(@ModelAttribute("bookViewing") BookViewing BVObj){
        System.out.println("TEST");
        bookViewingService.approveViewingApplication(BVObj.getBookingID());
        return "redirect:/RecommendedViewingApplications";
    }

}
