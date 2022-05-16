// Author: Xiao Ling

package com.dalhousie.university.novahousing.utils;

public class StringChecker {

	public boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
