package com.dalhousie.university.novahousing.validations.adminValidation;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.AdminException;

import static java.util.Objects.isNull;

public class AdminPostActionValidationImpl implements AdminPostActionValidation {


    @Override
    public boolean validateUserApproveListingInput(String approveStatus) throws AdminException {
        if(isNull(approveStatus) || approveStatus.isEmpty()){
            throw new AdminException("Please approve or reject to continue");
        }
        return true;
    }

    @Override
    public boolean validateUserPostId(String postId) throws AdminException {
        if(isNull(postId) || postId.isEmpty()){
            throw new AdminException("Post id not provided");
        }
        return true;
    }

}
