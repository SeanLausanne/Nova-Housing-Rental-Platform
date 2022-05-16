// Author: Xiao Ling

package com.dalhousie.university.novahousing.model.post;

public class Apartment extends Property {
	
	public Apartment() {
		this.type = "Apartment";
	}
	
	public static class Builder extends Property.Builder {
		
		public Apartment apartment = new Apartment();
		
		@Override
		public Builder setArea(int area) {
			this.apartment.area = area;
			return this;
		}

		@Override
		public Builder setBedroomNumber(int bedroomNumber) {
			this.apartment.bedroomNumber = bedroomNumber;
			return this;
		}

		@Override
		public Builder setBathroomNumber(double bathroomNumber) {
			this.apartment.bathroomNumber = bathroomNumber;
			return this;
		}

		@Override
		public Apartment build() {
			return this.apartment;
		}
		
	}
}
