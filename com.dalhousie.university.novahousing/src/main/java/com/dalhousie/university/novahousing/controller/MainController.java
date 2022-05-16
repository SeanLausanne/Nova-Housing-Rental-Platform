
// Author- Anita Kumari (B00884141)
package com.dalhousie.university.novahousing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "novahousing";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
