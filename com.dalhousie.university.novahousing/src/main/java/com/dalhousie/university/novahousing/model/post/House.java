// Author: Xiao Ling

package com.dalhousie.university.novahousing.model.post;

public class House extends Property {
	
	public House() {
		this.type = "House";
	}
	
	public static class Builder extends Property.Builder {
		
		public House house = new House();
		
		@Override
		public Builder setArea(int area) {
			this.house.area = area;
			return this;
		}

		@Override
		public Builder setBedroomNumber(int bedroomNumber) {
			this.house.bedroomNumber = bedroomNumber;
			return this;
		}

		@Override
		public Builder setBathroomNumber(double bathroomNumber) {
			this.house.bathroomNumber = bathroomNumber;
			return this;
		}

		@Override
		public House build() {
			return this.house;
		}
		
	}
}
