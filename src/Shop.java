
public class Shop extends Property{

	public Shop(String tanentName, int propertyID, String city, String region, String district, String street,
			double area, boolean rented) {
		super(tanentName,propertyID , city, region, district, street, area );
		pricOf1meter = 800;
	}
	//copyConstructor
	
//<<<<<<< HEAD
	public Shop(Shop s) {
		super(s.tanentName,s.propertyID , s.city, s.region, s.district, s.street, s.area );
		pricOf1meter = 800;
	}

//=======

	public double calculateDailyRent() {
		return (pricOf1meter * area );
		
		
//>>>>>>> branch 'main' of https://github.com/renad12345/CS-Project
	}

	//toString
	
	public double getPricOf1meter() {
		return pricOf1meter;
	}
	

}
