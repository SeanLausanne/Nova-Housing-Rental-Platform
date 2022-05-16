//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.services.applyRent;

import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;
import com.dalhousie.university.novahousing.model.post.Post;

import java.util.List;

public interface ApplyRentService {
    boolean applyRent(RentApplication postProperty) throws ApplyException;
    public List<Post> getAllPostProperty() throws FilterNotValidException;
}
