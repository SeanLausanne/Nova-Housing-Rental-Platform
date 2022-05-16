// Author: Xiao Ling

package com.dalhousie.university.novahousing.validations.postValidation;

import java.util.List;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;

public class FilterListValidator implements Validator {

	List<SearchFilter> filters;

	public FilterListValidator(List<SearchFilter> filters) {
		this.filters = filters;
	}

	@Override
	public boolean validate() {
		if (filters == null) {
			return false;
		}

		return true;
	}
}
