
public class Apartment extends Property{
private int  NumOfRooms ;




	public Apartment(String ownerName, String ownerID, String city,
		String region, String district, String street,
		double area, int numOfRooms) {
	
	super(ownerName, ownerID, city, region, district, street, area);
	pricOf1meter = 800;
	NumOfRooms = numOfRooms;
	dailyRent = calculateDailyRent();
	System.out.println("Apartment was added succsefully with property ID: " + propertyID);

	}



//copyConstructor
	public Apartment(Apartment Ap) {
	super(Ap.ownerName, Ap.ownerID, Ap.city, Ap.region, Ap.district, Ap.street, Ap.area);
	pricOf1meter = Ap.pricOf1meter;
	NumOfRooms = Ap.NumOfRooms;	
	dailyRent = Ap.dailyRent;
	}



	public double calculateDailyRent() {
	if (NumOfRooms<2)
	return (pricOf1meter * area)+(NumOfRooms*1000);
	else
	return (pricOf1meter * area);
	}


	@Override
	public String toString() {
	return "Property kind: Apartment\n" + super.toString()+
			"Number Of Rooms: " + NumOfRooms + "\n";
}

}
