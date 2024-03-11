
public class Shop extends Property{

	public Shop(String propertyNum, String city, String region, String district, String street, double area) {
		super(propertyNum, city, region, district, street, area);
		PricOf1meter = 800;
	}
	
	public double CalculatePrice() {
		return (PricOf1meter * Area );
		
		
	}

	public int getPricOf1meter() {
		return PricOf1meter;
	}

	public void setPricOf1meter(int pricOf1meter) {
		PricOf1meter = pricOf1meter;
	}
	

}
