
public abstract class Property {
	protected static int ID = 1;
	protected int propertyID;

	protected String ownerName;
	protected String ownerID;
	protected String city;
	protected String region;
	protected String district;
	protected String street;
	protected double area;
	protected double dailyRent;
	protected boolean rented;
	protected double pricOf1meter;

	public Property(String ownerName, String ownerID, String city, String region, String district, String street,
			double area) {
		propertyID = ID++;
		this.ownerName = ownerName;
		this.ownerID = ownerID;
		this.city = city;
		this.region = region;
		this.district = district;
		this.street = street;
		this.area = area;
		rented = false;
		pricOf1meter = 0;
		dailyRent = 0;
	}

	public Property() {
	}

	public abstract double calculateDailyRent();

	@Override
	public String toString() {
		String isRented = rented ? "Status: Rented" : "status: Not rented";

		return "propertyID: " + propertyID + "\nCity: " + city + "\nRegion: " + region + "\nDistrict: " + district
				+ "\nStreet: " + street + "\nArea in meters: " + area + "\nPrice Of one meter: " + pricOf1meter
				+ "\nDaily Rent (SR): " + dailyRent + "\n" + isRented + "\n";
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getPropertyID() {
		return propertyID;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getOwnerID() {
		return ownerID;
	}

}

