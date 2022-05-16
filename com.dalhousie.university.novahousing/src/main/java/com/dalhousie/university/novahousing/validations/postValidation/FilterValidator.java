// Author: Xiao Ling

package com.dalhousie.university.novahousing.validations.postValidation;

import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import com.dalhousie.university.novahousing.utils.StringChecker;

public class FilterValidator implements Validator {

	SearchFilter filter;

	public FilterValidator(SearchFilter filter) {
		this.filter = filter;
	}

	@Override
	public boolean validate() {
		if (filter == null) {
			return false;
		}

		// number filter shouldn't be negative
		String filterValue = filter.getFilterValue();
		StringChecker checker = new StringChecker();
		if (checker.isInteger(filterValue)) {
			int value = Integer.parseInt(filterValue);
			if (value < 0) {
				return false;
			}
		}

		return true;
	}
}
