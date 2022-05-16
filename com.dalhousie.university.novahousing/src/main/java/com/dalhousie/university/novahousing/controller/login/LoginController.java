package com.dalhousie.university.novahousing.controller.login;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.controller.dto.LoginDto;
import com.dalhousie.university.novahousing.model.login.Login;
import com.dalhousie.university.novahousing.services.login.LoginService;
import com.dalhousie.university.novahousing.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping
    public String showLoginForm(Model loginModel) {
        loginModel.addAttribute("loginObj",new LoginDto());
        loginModel.addAttribute("rollTypes", Role.values());
        return "login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute("loginObj") LoginDto loginDtoObj) {
        String result="";
        try{
            Login loginObj=new Login();
            loginObj.setUsername(loginDtoObj.getUsername());
            loginObj.setPassword(loginDtoObj.getPassword());
            loginObj.setRole(loginDtoObj.getRole());

            if(loginService.authenticateUser(loginObj)){
                result="redirect:/dashboard";
            }
            else{
                result= "redirect:/login?error";
            }
        }catch(Exception ex){
            result= "redirect:/login?error";
            System.out.println(ex);
        }
        finally{

            return result;
        }
    }
}