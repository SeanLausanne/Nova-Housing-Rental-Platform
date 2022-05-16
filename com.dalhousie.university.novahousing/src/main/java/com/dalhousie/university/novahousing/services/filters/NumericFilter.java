// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public abstract class NumericFilter implements SearchFilter {
	
	String filterCategory;
	int filterValue;
	
	public NumericFilter(int filterValue) {
		this.filterValue = filterValue;
	}
	
	@Override
	public String getFilterCategory() {
		return filterCategory;
	}
	
	@Override
	public String getFilterValue() {
		return String.valueOf(filterValue);
	}
}

