//Author: Sidharth
package com.dalhousie.university.novahousing.controller.screenRenters;

import com.dalhousie.university.novahousing.services.screening.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ScreenedRentalApplications")
public class ScreenedRentalApplicationsController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public String ScreenedApplications(Model model){
            String propertyID= "1638928474723";
            model.addAttribute("ScreenedApplications", rentalService.getRentalApplication(propertyID));
            return "ScreenedRentalApplications";
    }


}
