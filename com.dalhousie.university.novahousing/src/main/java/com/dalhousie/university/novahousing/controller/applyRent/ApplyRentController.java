//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.controller.applyRent;


import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.services.applyRent.ApplyRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/applyrent")
public class ApplyRentController {

    @Autowired
    private ApplyRentService applyRentService;

    //mapping all approved properties
    @RequestMapping(method = RequestMethod.GET)
    public String showAllProperty(Model model) throws FilterNotValidException {
        List < Post > results = applyRentService.getAllPostProperty();

        model.addAttribute("allPostProperties", results);
        return "listPostedProperty";
    }

    //Application submission
    @RequestMapping(value = "/appliedRent", method = RequestMethod.GET)
    public String appliedSuccessPage() {
        return "appliedRent";
    }

    @RequestMapping(value = {
        "/selectedPostProperty"
    }, method = RequestMethod.POST)
    public String showSelectedPost(@RequestParam(name = "id", required = false) String postId, Model model) {
        RentApplication rentFormObj = new RentApplication();
        rentFormObj.setPropertyId(postId);
        model.addAttribute("rentFormObj", rentFormObj);
        return "rentalForm";
    }

    //mapping to application form
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public String rentApplication(@ModelAttribute("rentFormObj") RentApplication rentObj) {
        String result = "";
        try {
            if (applyRentService.applyRent(rentObj)) {
                result = "redirect:/applyrent/appliedRent";
            } else {
                result = "redirect:/applyrent?error";
            }
        } catch (ApplyException ex) {
            result = "redirect:/applyrent?error";
            System.out.println(ex);
        } catch (Exception ex) {
            result = "redirect:/applyrent?error";
            System.out.println(ex);
        } finally {
            return result;
        }
    }
}
