package com.dalhousie.university.novahousing.validations.adminValidation;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.AdminException;

public interface AdminPostActionValidation {
    boolean validateUserApproveListingInput(String approveStatus) throws AdminException;
    boolean validateUserPostId(String approveStatus) throws AdminException;
}
