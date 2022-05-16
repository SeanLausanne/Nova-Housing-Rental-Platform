// Author: Xiao Ling

package com.dalhousie.university.novahousing.validations.postValidation;

public class PostDbUpdateVlidator implements Validator {

	int databaseUpdate;

	public PostDbUpdateVlidator(int databaseUpdate) {
		this.databaseUpdate = databaseUpdate;
	}

	@Override
	public boolean validate() {
		if (this.databaseUpdate == 0) {
			return false;
		}
		return true;
	}
}
