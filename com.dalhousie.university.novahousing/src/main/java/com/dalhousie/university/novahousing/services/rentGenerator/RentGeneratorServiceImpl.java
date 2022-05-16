//Author: Sidharth
package com.dalhousie.university.novahousing.services.rentGenerator;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.services.filters.PostIdFilter;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import com.dalhousie.university.novahousing.services.postSearch.PropertyPostSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentGeneratorServiceImpl implements RentGeneratorService{

    @Autowired
    PropertyPostSearcher postSearcher;

    @Override
    public int generateRent(String PropertyID) throws FilterNotValidException {

        SearchFilter filter = new PostIdFilter("\"" +PropertyID + "\"");
        postSearcher.addFilter(filter);
        List<Post> posts = postSearcher.searchPost();

        String PropertyType=posts.get(0).getProperty().getType();
        int area=posts.get(0).getProperty().getArea();
        int bedroomNumber=posts.get(0).getProperty().getBedroomNumber();
        double bathroomNumber=posts.get(0).getProperty().getBathroomNumber();

        int rent;

        if(PropertyType.equals("House")){
            rent=(int) (600+600*area/10+10*bedroomNumber+bathroomNumber*5);
            return (int)Math.floor(Math.random()*(rent*0.2+1)+rent);

        }
        else if(PropertyType.equals("Apartment")){
            rent= (int) (400+400*area/10+10*bedroomNumber+bathroomNumber*5);
            return (int)Math.floor(Math.random()*(rent*0.25+1)+rent);

        }
        return 0;
    }

}
