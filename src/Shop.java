
public class Shop extends Property{

	public Shop(String city, String region, String district, String street, double area) {
		super(city, region, district, street, area);
		pricOf1meter = 800;
	}
	//copyConstructor
	
	public double calculateDailyRent() {
		return (pricOf1meter * area );
		
		
	}

	//toString
	
	public double getPricOf1meter() {
		return pricOf1meter;
	}

	public void setPricOf1meter(int pricOf1meter) {
		pricOf1meter = pricOf1meter;
	}
	

}
