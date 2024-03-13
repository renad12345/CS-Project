
public abstract class Property {
	protected String tanentName;
	protected int propertyID;
	protected String city;
	protected String region;
	protected String district;
	protected String street;
	protected double area;
	protected static boolean rented;
	protected double pricOf1meter;
	
	protected static int ID = 0;

	
//<<<<<<< HEAD

	public Property(String tanentName, int propertyID, String city, String region, String district, String street,
		double area, boolean rented) {
		
	this.tanentName = tanentName;
	this.propertyID = propertyID;
	this.city = city;
	this.region = region;
	this.district = district;
	this.street = street;
	this.area = area;
	this.rented = rented;
	ID++;
}

	public abstract double CalculatePrice() ;
	

	public static boolean rented () {
		return rented ;
//=======
	
//>>>>>>> branch 'main' of https://github.com/renad12345/CS-Project
	}
	
	
	public abstract double calculateDailyRent();
	
	
	@Override
	public String toString() { //#
		return "Property [propertyNum=" + propertyID + ", City=" + city + ", Region=" + region + ", District="
				+ district + ", Street=" + street + ", Area=" + area + ", rented=" + rented 
				+ ", PricOf1meter=" + pricOf1meter;
	}


	public String getTanentName() {
		return tanentName;
	}


	public int getPropertyID() {
		return propertyID;
	}


	public String getCity() {
		return city;
	}


	public String getRegion() {
		return region;
	}


	public String getDistrict() {
		return district;
	}


	public String getStreet() {
		return street;
	}


	public double getArea() {
		return area;
	}


	public boolean isRented() {
		return rented;
	}

}
