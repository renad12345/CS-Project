
public abstract class Property {
	protected String tanentName;
	protected int propertyID;
	protected String city;
	protected String region;
	protected String district;
	protected String street;
	protected double area;
	protected boolean rented;
	protected double pricOf1meter;
	
	protected static int ID = 0;

	
	public Property(String tanentName, String city, String region, String district, String street, double area) {
	this.tanentName = tanentName;
		this.propertyID = ID++;
		this.city = city;
		this.region = region;
		this.district = district;
		this.street = street;
		area = 0;
		rented = false;
		pricOf1meter = 0;	
	}
	
	
	public abstract double calculateDailyRent();
	
	
	@Override
	public String toString() { //#
		return "Property [propertyNum=" + propertyID + ", City=" + city + ", Region=" + region + ", District="
				+ district + ", Street=" + street + ", Area=" + area + ", rented=" + rented 
				+ ", PricOf1meter=" + pricOf1meter;
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public double getArea() {
		return Area;
	}

	public void setArea(int area) {
		Area = area;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	
}
