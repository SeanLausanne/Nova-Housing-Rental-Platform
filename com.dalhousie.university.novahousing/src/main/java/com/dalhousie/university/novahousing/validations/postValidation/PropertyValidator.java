// Author: Xiao Ling

package com.dalhousie.university.novahousing.validations.postValidation;

import com.dalhousie.university.novahousing.model.post.Property;

public class PropertyValidator implements Validator {

	Property property;

	public PropertyValidator(Property property) {
		this.property = property;
	}

	@Override
	public boolean validate() {

		if (property == null) {
			return false;
		}

		int area = property.getArea();
		int nBedroom = property.getBedroomNumber();
		double nBathroom = property.getBathroomNumber();
		String type = property.getType();

		if (area <= 0) {
			return false;
		}

		if (nBedroom < 0) {
			return false;
		}

		// nBathroom should be integer or x.5
		if (nBathroom < 0 || (2 * nBathroom) % 1 != 0) {
			return false;
		}

		return true;
	}
}
