
public class Apartment extends Property{
private int  NumOfRooms ;
//#
protected int PricOf1meter = 800;



public Apartment(String tanentName, String city, String region, String district, String street, double area,
		int numOfRooms, int pricOf1meter) {
	super(tanentName, city, region, district, street, area);
	NumOfRooms = numOfRooms;
	PricOf1meter = pricOf1meter;
}


//copyConstructor
public Apartment(Apartment Ap) {
	super(Ap.tanentName, Ap.city, Ap.region,Ap.district,Ap.street, Ap.area);
	NumOfRooms = Ap.NumOfRooms;
	PricOf1meter = Ap.PricOf1meter;		
	
}



public double calculateDailyRent() {
if (NumOfRooms<2)
return (PricOf1meter * area)+(NumOfRooms*1000);
else
	return (PricOf1meter * area)	;
}


@Override
public String toString() { //#
	return super.toString()+"Apartment [NumOfRooms=" + NumOfRooms + ", PricOf1meter=" + PricOf1meter + "]";
}


public int getNumOfRooms() {
	return NumOfRooms;
}


public int getPricOf1meter() {
	return PricOf1meter;
}


public void setNumOfRooms(int numOfRooms) {
	NumOfRooms = numOfRooms;
}


public void setPricOf1meter(int pricOf1meter) {
	PricOf1meter = pricOf1meter;
}

}
