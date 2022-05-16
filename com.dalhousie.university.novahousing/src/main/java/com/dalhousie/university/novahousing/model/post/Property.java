// Author: Xiao Ling

package com.dalhousie.university.novahousing.model.post;

public abstract class Property {

	int area;
	int bedroomNumber;
	double bathroomNumber;
	String type;

	public static abstract class Builder {

		public Builder() {
		}

		public abstract Builder setArea(int area);

		public abstract Builder setBedroomNumber(int bedroomNumber);

		public abstract Builder setBathroomNumber(double bathroomNumber);

		public abstract Property build();
	}

	public int getArea() {
		return this.area;
	}

	public int getBedroomNumber() {
		return this.bedroomNumber;
	}

	public double getBathroomNumber() {
		return this.bathroomNumber;
	}

	public String getType() {
		return this.type;
	}
}
