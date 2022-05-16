// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public class BedroomFilter extends NumericFilter {
	
	public BedroomFilter(int filterValue) {
		super(filterValue);
		this.filterCategory = "bedroomNumber";
	}
}
