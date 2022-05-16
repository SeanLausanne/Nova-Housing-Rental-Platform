// Author: Xiao Ling

package com.dalhousie.university.novahousing.model.post;

import com.dalhousie.university.novahousing.utils.TimeGenerator;

public class PropertyPost extends Post {
	
	TimeGenerator timeGenerator = new TimeGenerator();
	
	
	public PropertyPost (Property property) {
		super(property);
		this.id = timeGenerator.generateCurrentTimeMillisecond();
		adminApproved = "No";
	}
}
