// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public abstract class AlphabeticFilter implements SearchFilter {
	
	String filterCategory;
	String filterValue;
	
	public AlphabeticFilter(String filterValue) {
		this.filterValue = filterValue;
	}
	
	@Override
	public String getFilterCategory() {
		return filterCategory;
	}
	
	@Override
	public String getFilterValue() {
		return filterValue;
	}

}
