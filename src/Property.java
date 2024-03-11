import org.w3c.dom.ls.LSOutput;

public abstract class Property {
	protected String propertyNum;
	protected String City;
	protected String Region;
	protected String District;
	protected String Street;
	protected int Area;
	protected boolean rented ;
	protected int PricOf1meter ;
	protected static int Id = 0 ;

	
	public Property(String propertyNum, String city, String region, String district, String street, int area, boolean rented ) {
	
		this.propertyNum = propertyNum;
		City = city;
		Region = region;
		District = district;
		Street = street;
		Area = 0;
		PricOf1meter =0 ;
		Id++;
		
	}
	public Property(Property p) {
		 propertyNum =p.propertyNum;
	     City=p.City;
		 Region=p.Region;
		 District=p.District;
	     Street=p.Street;
		 Area=p.Area;
		 rented =p.rented;
	     PricOf1meter=p.PricOf1meter;
         Id =p.Id;
	}
	
	public abstract double CalculatePrice() ;
	
	
	
	public boolean rented () {
		return rented ;
	}
	
	

	@Override
	public String toString() {
		return "Property [propertyNum=" + propertyNum + ", City=" + City + ", Region=" + Region + ", District="
				+ District + ", Street=" + Street + ", Area=" + Area + ", rented=" + rented 
				+ ", PricOf1meter=" + PricOf1meter + "Id" + Id + "]";
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
