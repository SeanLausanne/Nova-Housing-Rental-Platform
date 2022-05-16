package com.dalhousie.university.novahousing.services.adminPostAction;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.validations.adminValidation.AdminPostActionValidationImpl;
import com.dalhousie.university.novahousing.exception.AdminException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.repository.adminPostAction.AdminPostActionRepository;
import com.dalhousie.university.novahousing.services.postSearch.PostSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPostActionServiceImpl implements AdminPostActionService {

    @Autowired
    private PostSearcher postSearcherService;

    @Autowired
    AdminPostActionRepository adminPostActionRepository;


    AdminPostActionValidationImpl adminPostActionValidation;

    @Override
    public List<Post> getAllPostProperty() throws AdminException, FilterNotValidException {
        List<Post> postList=postSearcherService.searchPost();
        if(postList.size()>0){
            return postList;
        }else{
            throw new AdminException("Database doesnt have any post yet");
        }
    }

    @Override
    public boolean approvePost(String id,String approveStatus) throws AdminException {
        adminPostActionValidation=new AdminPostActionValidationImpl();
        if(adminPostActionValidation.validateUserApproveListingInput(approveStatus) && adminPostActionValidation.validateUserPostId(id)){
            adminPostActionRepository.approvePost(id,approveStatus);
            return true;
        }
        return false;
    }
}
