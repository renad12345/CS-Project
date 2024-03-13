
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
	
//<<<<<<< HEAD
	public Property(String tanentName, int propertyID, String city, String region, String district, String street,
		double area) {
		
	this.tanentName = tanentName;
	this.propertyID = propertyID;
	this.city = city;
	this.region = region;
	this.district = district;
	this.street = street;
	this.area = area;
	this.rented = false;
	ID++;
}
	public abstract double calculateDailyRent();
	
	public boolean rented () {
		return rented ;
//=======
//>>>>>>> branch 'main' of https://github.com/renad12345/CS-Project
	}
	
	@Override
	public String toString() { //#
		return "Property [propertyNum=" + propertyID + ", City=" + city + ", Region=" + region + ", District="
				+ district + ", Street=" + street + ", Area=" + area + ", rented=" + rented 
				+ ", PricOf1meter=" + pricOf1meter;
	}
}
