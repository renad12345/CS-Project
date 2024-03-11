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
int rentedPropertyNum = input.nextInt();

users[numOfusers++] = new User(ID, name, phoneNumber, propertyNum, rentedPropertyNum);



do {
	System.out.println("How can I help you? Enter one of the following options");
	System.out.println("1- Rent a property");
	System.out.println("2- Remove a rented property");
	System.out.println("3- Search for a rented property");
	System.out.println("4- list a property for renting");
	System.out.println("5- Remove your own property");
	System.out.println("6- Search for your own property");
	System.out.println("7- Show my information");
	System.out.println("8- Exit");
	System.out.print("option: ");
	int choice = input.nextInt();

	switch (choice){
	case 1: 
		System.out.println("**************************** 1- Rent a property *******************");
		System.out.println("Here are the available properties");
		for(int i=0; i<numOfusers; i++)
			users[i].availableProperties();
		
		
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
			
			Lease lease1 = new Lease(date1, date2, wantedProperty(propertyID), users[numOfusers].getName(), users[numOfusers].getID());
			users[numOfusers].addLease(lease1);}
		else
			System.out.println("Sorry, property was not found!");
		break;
	
	case 2:
		System.out.println("******************* 2- Remove a rented property *******************");
		System.out.println("Enter property's lease ID which you want to cancel");
		int LeaseID = input.nextInt();
		if(users[numOfusers].removeLease(LeaseID))
			System.out.println("Lease was deleted succsfully!");
		else 
			System.out.println("Sorry, Lease was not deleted succsfully!");
		break;
		
	case 3:
		System.out.println("******************* 3- Search for a rented property *******************");
		System.out.println("Enter property's lease ID which you want to search about");
		int LeaseID = input.nextInt();
		if(users[numOfusers].searchLease(LeaseID))
			System.out.println("Lease was found!");
		else 
			System.out.println("Sorry, Lease was not found!");
		break;
		
	case 4:
		System.out.println("******************* 4- list a property for renting *******************");
		System.out.println("Complete following information");

		System.out.print("City: ");
		String city = input.next();
		
		System.out.print("Region: ");
		String region = input.next();
		
		System.out.print("District: ");
		String district = input.next();

		System.out.print("Street: ");
		String street = input.next();
		
		System.out.print("Area: ");
		String area = input.next();
		
		System.out.println("Do you want to list a shop or an apartment for renting?");
		System.out.println("Enter 'S' for a shop and 'A' for an apartment");
		char propertyKind = input.next().charAt(0);
		
		if(propertyKind=='S') {
			Property property1 = new Shop(city, region, district, street, area);
			users[numOfusers].addProperty(property1);}
		
		else if(propertyKind=='A') {
			Property property1 = new Apartment(city, region, district, street, area);
			users[numOfusers].addProperty(property1);}
		
		else System.out.println("Invalid input");
		break;
		
	case 5:
		System.out.println("******************* 5- Remove your own property *******************");
		System.out.println("Enter property id");
		int propertyID=input.nextInt();
		if(users[numOfusers].removeProperty(propertyID))
			System.out.println("property was deleted succsfully!");
		else 
			System.out.println("Sorry, property was not deleted succsfully!");
		break;
		
	case 6:
		System.out.println("******************* 6- Search for your own property *******************")
		System.out.println("Enter property's id number which you want to search about");
		int propertyID = input.nextInt();
		if(users[numOfusers].findProperty(propertyID) != null)
			System.out.println("property is found!");
		else 
			System.out.println("Sorry, property is not found!");
		break;
		
		case 7:
			System.out.println("******************* 7- Show my information *******************");
			System.out.println(users[1].toString());
			break;
			
		case 8:
			System.out.println("******************* 8- Exit *******************");
			System.out,println("See you later!")
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
				
	

}
