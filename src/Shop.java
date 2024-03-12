
public class Shop extends Property{
	protected int PricOf1meter = 800;

	
	public Shop(String propertyNum, String city, String region, String district, String street, int area , boolean rented) {
		super(propertyNum, city, region, district, street, area, rented);
	}
	
	public Shop(Shop s) {
		super(s.propertyNum, s.City, s.Region, s.District, s.Street, s.PricOf1meter, s.rented);
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
