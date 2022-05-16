package com.dalhousie.university.novahousing.controller.admin;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.AdminException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.services.adminPostAction.AdminPostActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
@RequestMapping("/adminPropertyListing")
public class AdminController {

    @Autowired
    private AdminPostActionService adminPostActionService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllProperty(Model model){
        List<Post> results= null;
        try {
            results = adminPostActionService.getAllPostProperty();
        } catch (AdminException | FilterNotValidException e) {
            e.printStackTrace();
        }
        model.addAttribute("allPostProperties", results);
        return "approveAdminPropertyListing";
    }


    @RequestMapping(value={"/approveProperty"}, method = RequestMethod.POST)
    public String approvePostProperty(@RequestParam(name="id", required=false) String postId,@RequestParam(name="approveStatus", required=false) String approveStatus){
        String result="";
        try{
            if(postId==null || postId.isEmpty()){
                result="redirect:/approveAdminPropertyListing?error";
            }
            else{
                adminPostActionService.approvePost(postId,approveStatus);
                result= "adminApprovedSuccess";
            }
        }finally{
            return result;
        }
    }
}
