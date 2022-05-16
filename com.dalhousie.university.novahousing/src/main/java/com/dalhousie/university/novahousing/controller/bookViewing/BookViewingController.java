//Author: Sidharth
package com.dalhousie.university.novahousing.controller.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;
import com.dalhousie.university.novahousing.services.bookViewing.BookViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/BookViewing")
public class BookViewingController {

    @Autowired
    private BookViewingService bookViewingService;

    @ModelAttribute("bookViewing")
            public BookViewing bookViewingDto(){
                return new BookViewing();
            }

    @GetMapping
    public String showApplicationForm() {
        return "BookViewing";
    }


    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public String SubmitApplication(@ModelAttribute("bookViewing") BookViewing BVObj) {
        System.out.println("check 1");
        bookViewingService.newViewingApplication(BVObj);
        return "redirect:/BookViewing/ApplicationSuccess";
    }

}
