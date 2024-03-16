public class Apartment extends Property {
	private int NumOfRooms;

	public Apartment(String ownerName, String ownerID, String city, String region, String district, String street,
			double area, int numOfRooms) {

		super(ownerName, ownerID, city, region, district, street, area);
		pricOf1meter = 800;
		NumOfRooms = numOfRooms;
		dailyRent = calculateDailyRent();
		System.out.println("Apartment was added succsefully with property ID: " + propertyID);

	}

//copyConstructor
	public Apartment(Apartment Ap) {
		propertyID = Ap.propertyID;
		ownerName = Ap.ownerName;
		ownerID = Ap.ownerID;
		city = Ap.city;
		region = Ap.region;
		district = Ap.district;
		street = Ap.street;
		area = Ap.area;
		pricOf1meter = 800;
		NumOfRooms = Ap.NumOfRooms;
		dailyRent = Ap.dailyRent;
	}

	public double calculateDailyRent() {
		if (NumOfRooms < 2)
			return (pricOf1meter * area) + (NumOfRooms * 1000);
		else
			return (pricOf1meter * area);
	}

	@Override
	public String toString() {
		return "Property kind: Apartment\n" + super.toString() + "Number Of Rooms: " + NumOfRooms + "\n";
	}

}

