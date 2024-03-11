import java.util.*;
import java.text.SimpleDateFormat;

public class PropertyTest {
	static Scanner input = new Scanner (System.in);
	public static User[] users;
	public static int numOfusers;

	public static void main(String[] args) {
		
		users[numOfusers++] = new User(112233, "Sara", "055555");
		Property property = new Apartment("Riyadh", "Alhamra", "Almasane" , 200);
		users[numOfusers].addProperty(property);
		
		
System.out.println("******************* Property Renting *******************");
System.out.println("Welcome Here!");
System.out.println("Please, tell us more about you!");

System.out.print("ID number:");
String ID = input.next();

System.out.print("Full name:");
String name=input.nextLine();

System.out.print("Phone Number:");
String phoneNumber=input.next();
//wr
System.out.print("Maximum number of properties you might list to renting");
int propertyNum = input.nextInt();

System.out.print("Maximum number of properties you might rent");
int rentPropertyNum = input.nextInt();

users[numOfusers++] = new User(ID, name, phoneNumber, propertyNum, rentPropertyNum);



do {
	System.out.println("How can I help you? Enter one of the following options");
	System.out.println("1- Rent a property");
	System.out.println("2- Remove a rented property");
	System.out.println("3- Search for a rented property");
	System.out.println("4- list a property for renting");
	System.out.println("5- Remove a property");
	System.out.println("6- Search for a property");
	System.out.println("7- Show my information");
	System.out.println("8- Exit");
	int choice = input.nextInt();

	switch (choice){
	case 1: 
		System.out.println("Here are the available properties");
		availableProperties();
		
		System.out.println("Please, complete the following information");
		System.out.print("property ID: ");
		int propertyID = input.nextInt();
		System.out.print("Enter start Date: ");
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		String startDate = input.next();
		Date date1 = SDF.parse(startDate);
		System.out.println("Enter End Date: ");
		String endDate = input.next();
		Date date2 = SDF.parse(endDate);
		
		if (wantedProperty(propertyID) != null) {
			
			Lease lease1 = new Lease(date1, date2, pro)
			users[numOfusers].addLease(lease1);}
		else
			System.out.println("Sorry, property was not founded!");
		break;
	
	case 2:
		System.out.println("Enter property's lease number which you want to cancel");
		int LeaseNo = input.nextInt();
		if(users[numOfusers].removeLease(LeaseNo))
			System.out.println("Lease was deleted succsfully!");
		else 
			System.out.println("Sorry, Lease was not deleted succsfully!");
		break;
		
	case 3:
		System.out.println("Enter property's lease number which you want to search about");
		int LeaseNo = input.nextInt();
		if(users[numOfusers]1.searchLease(LeaseNo))
			System.out.println("Lease was founded!");
		else 
			System.out.println("Sorry, Lease is not found!");
		break;
		
	case 4:
		System.out.println("Complete following information");

		System.out.print("City: ");
		String city = input.next();
		
		System.out.print("Region: ");
		String Region = input.next();
		
		System.out.print("District: ");
		String District = input.next();

		System.out.print("Street: ");
		String Street = input.next();
		
		System.out.print("Area: ");
		String Area = input.next();
		
		System.out.println("Do you want to list a shop or an apartment for renting?");
		System.out.println("Enter 'S' for a shop and 'A' for an apartment");
		char propertyKind = input.next().charAt(0);
		
		if(propertyKind=='S') {
			Property property1 = new Shop(city, Region, District, Street, Area)
			users[numOfusers].addProperty(property1);}
		
		else if(propertyKind=='A') {
			Property property1 = new Apartment(city, Region, District, Street, Area)
			users[numOfusers].addProperty(property1);}
		
		else System.out.println("Invalid input");
		break;
		
	case 5:
		System.out.println("Enter property id");
		int propertyId=input.nextInt();
		if(users[numOfusers].removeProperty(propertyId))
			System.out.println("property was deleted succsfully!");
		else 
			System.out.println("Sorry, property was not deleted succsfully!");
		break;
		
	case 6:
		System.out.println("Enter property's id number which you want to search about");
		int propertyId = input.nextInt();
		if(users[numOfusers].findProperty(propertyId) != null)
			System.out.println("property is found!");
		else 
			System.out.println("Sorry, property is not found!");
		break;
		
		case 7:
			System.out.println(users[1].toString());
			break;
			
		case 8:
			System.exit(0);
	}
}
while (choice!=7)
	
	
	public static Property wantedProperty(int propertyId) {
		for(int i=0; i<numOfusers; i++)
			if(users[i].findProperty(propertyId)!=null)
				return users[i].findProperty(propertyId);
return null;
						
				
	}
	
	public static void availableProperties() {
		for(int i=0; i<numOfusers; i++)
			users[i].availableProperties();

	}

}
