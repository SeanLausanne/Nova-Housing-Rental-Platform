// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public class PropertyTypeFilter extends AlphabeticFilter {

	public PropertyTypeFilter(String filterValue) {
		super(filterValue);
		this.filterCategory = "propertyType";
	}
}
