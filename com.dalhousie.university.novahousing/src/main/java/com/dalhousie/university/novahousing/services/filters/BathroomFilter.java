// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public class BathroomFilter extends NumericFilter {
	
	public BathroomFilter(int filterValue) {
		super(filterValue);
		this.filterCategory = "bathroomNumber";
	}

}
