// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.filters;

public class AdminApprovalFilter extends AlphabeticFilter  {

	public AdminApprovalFilter(String filterValue) {
		super(filterValue);
		this.filterCategory = "adminApproved";
	}
}
