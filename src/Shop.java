
public class Shop extends Property{

	public Shop(String ownerName, String ownerID, String city, String region,
			String district, String street,
			double area){
		
		super(ownerName, ownerID, city, region, district, street, area);
		pricOf1meter = 800;
		dailyRent = calculateDailyRent();
		System.out.println("Shop was added succsefully with property ID: " + propertyID);

	}
	
	//copyConstructor
	public Shop(Shop s) {
		super(s.ownerName, s.ownerID, s.city, s.region, s.district, s.street, s.area);
		pricOf1meter = 800;
		dailyRent = s.dailyRent;
	}
	
	public double calculateDailyRent() {
		return (pricOf1meter * area );
			}

	@Override
	public String toString() {
		return "Property kind: Shop\n" + super.toString();
	}
	

	
}
