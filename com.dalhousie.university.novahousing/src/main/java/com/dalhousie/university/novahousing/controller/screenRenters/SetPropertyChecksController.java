//Author: Sidharth
package com.dalhousie.university.novahousing.controller.screenRenters;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.services.screening.PropertyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SetPropertyChecks")
public class SetPropertyChecksController {

    @Autowired
    private PropertyCheckService propertyCheckService;

    @ModelAttribute("propertyChecks")
    public PropertyChecks propertyChecksDto(){
        return new PropertyChecks();
    }

    @GetMapping
    public String showSetPropertyChecksForm() {
        return "SetPropertyChecks";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String SubmitApplication(@ModelAttribute("propertyChecks") PropertyChecks PCObj) throws FilterNotValidException {
        System.out.println("check 3");
        propertyCheckService.settingUpPropertyCheck(PCObj);
        return "redirect:/BookViewing";
    }

}
