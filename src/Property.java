
public abstract class Property {
	protected String propertyNum;
	protected String City;
	protected String Region;
	protected String District;
	protected String Street;
	protected double Area;
	protected boolean rented;
	protected double PricOf1meter;

	
	public Property(String propertyNum, String city, String region, String district, String street, double area ) {
	
		this.propertyNum = propertyNum;
		City = city;
		Region = region;
		District = district;
		Street = street;
		Area = 0;
		rented = false;
		PricOf1meter = 0;
	}
	
	public abstract double CalculatePrice() ;
	
	
	
	public boolean rented () {
		return rented ;
	}

	public String getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(String propertyNum) {
		this.propertyNum = propertyNum;
	}

	public String getCity() {
		return City;
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

	public int getArea() {
		return Area;
	}

	public void setArea(int area) {
		Area = area;
	}

	public Lease[] getLease() {
		return lease;
	}

	public void setLease(Lease[] lease) {
		this.lease = lease;
	}

	
}
