import java.util.*;

public class PropertyTest {
	static Scanner input = new Scanner(System.in);
	public static User[] users;
	public static int numOfusers;

	public static void main(String[] args) {

		users = new User[100];
		numOfusers = 0;
		users[numOfusers++] = new User("112233", "Sara", "055555");
		Property property = new Apartment(users[0].getName(), users[0].getID(), "Riyadh", "Riyadh", "Alhamra",
				"Almasane", 200, 5);
		users[0].addProperty(property);
		System.out.println("******************* Property Renting *******************");
		System.out.println("Welcome Here!");
		System.out.println("\n");
		System.out.println("Please, tell us more about you!");
//Read info from user
		System.out.print("Full name: ");
		String name = input.nextLine();

		System.out.print("ID number: ");
		String ID = input.next();

		System.out.print("Phone Number: ");
		String phoneNumber = input.next();

		users[numOfusers++] = new User(ID, name, phoneNumber);

		int totalNumProperty;
		int choice;
		do {
			System.out.println("\n");
			System.out.println("How can I help you? Enter one of the following options");
			System.out.println("1- Rent a property");
			System.out.println("2- Cancel a lease");
			System.out.println("3- Search for a lease");
			System.out.println("4- add a property for rent");
			System.out.println("5- Cancel your own property");
			System.out.println("6- Search for your own property");
			System.out.println("7- Show my information");
			System.out.println("8- Exit");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\n");
				System.out.println("******************* 1- Rent a property *******************");
				// check if there is available properties to show
				totalNumProperty = 0;
				for (int i = 0; i < numOfusers; i++)
					totalNumProperty += users[i].availablePropertiesNum();

				if (totalNumProperty == 0)
					System.out.println("Sorry, there is no available properties!");

				else {
					System.out.println("Here are the available properties");
					for (int i = 0; i < numOfusers; i++)
						users[i].availableProperties();

					System.out.println("Please, complete the following information");
					System.out.print("property ID: ");
					int propertyID1 = input.nextInt();

					

					if (wantedProperty(propertyID1) != null && wantedProperty(propertyID1).getOwnerID() != null
							&& !(wantedProperty(propertyID1).getOwnerID().equals(users[1].getID()))) { //user can't be owner and tanent
						                                                                               //for same property
						                                                                               
						System.out.print("Enter suitable duration in days for the lease: ");
						int duration = input.nextInt();													
																										
						Lease lease1 = new Lease(users[1].getName(), users[1].getID(), duration,
								wantedProperty(propertyID1));
						users[1].addLease(lease1);
					} else
						System.out.println("Sorry, property was not rented sucsesfully!");
				}
				break;

			case 2:
				System.out.println("\n");
				System.out.println("******************* 2- Cancel a lease *******************");
				System.out.println("Enter property's lease ID which you want to cancel");
				int LeaseNo = input.nextInt();
				if (users[1].removeLease(LeaseNo)) {
					System.out.println("Lease was deleted succsfully!");
				} else
					System.out.println("Sorry, Lease was not deleted succsfully!");
				break;

			case 3:
				System.out.println("\n");
				System.out.println("******************* 3- Search for a lease *******************");
				System.out.println("Enter property's lease ID which you want to search about");
				int LeaseID = input.nextInt();
				if (users[1].searchLease(LeaseID) != null) {
					System.out.println("Lease was found!");
					System.out.println(users[1].searchLease(LeaseID));}
				else
					System.out.println("Sorry, Lease is not found!");
				break;

			case 4:
				System.out.println("\n");
				System.out.println("******************* 4- add a property for rent *******************");
				System.out.println("Complete following information");

				System.out.print("City: ");
				String city = input.next();

				System.out.print("Region: ");
				String Region = input.next();

				System.out.print("District: ");
				String District = input.next();

				System.out.print("Street: ");
				String Street = input.next();

				System.out.print("Area in meters: ");
				Double Area = input.nextDouble();

				System.out.println("Do you want to add a shop or an apartment for rent?");
				System.out.println("Enter 1 for a shop and 2 for an apartment");
				int propertyKind = input.nextInt();

				if (propertyKind == 1) {
					Property property1 = new Shop(users[1].getName(), users[1].getID(), city, Region, District, Street,
							Area);
					users[1].addProperty(property1);
				} else if (propertyKind == 2) {
					System.out.print("Enter number of rooms: ");
					int numOfRooms = input.nextInt();
					Property property1 = new Apartment(users[1].getName(), users[1].getID(), city, Region, District,
							Street, Area, numOfRooms);
					users[1].addProperty(property1);
				}

				else
					System.out.println("Invalid input");
				break;

			case 5:
				System.out.println("\n");
				System.out.println("******************* 5- Cancel a property *******************");
				System.out.println("Enter property ID");
				int propertyID2 = input.nextInt();
				if (users[1].removeProperty(propertyID2))
					System.out.println("property was deleted succsfully!");
				else
					System.out.println("Sorry, property was not deleted succsfully!");
				break;

			case 6:
				System.out.println("\n");
				System.out.println("******************* 6- Search for a property *******************");
				System.out.println("Enter property's ID which you want to search about");
				int propertyID3 = input.nextInt();
				if (users[1].findProperty(propertyID3) != null) {
					System.out.println("property was found!");
					System.out.println(users[1].findProperty(propertyID3));}
				else
					System.out.println("Sorry, property was not found!");
				break;

			case 7:
				System.out.println("\n");
				System.out.println("******************* 7- Show my information *******************");
				System.out.println(users[1].toString());

				break;

			case 8:
				System.out.println("\n");
				System.out.println("******************* 8- Exit *******************");
				System.out.println("See you later!");

				break;
			}// End switch

		} // End while
		while (choice != 8);
	}// End main

	public static Property wantedProperty(int propertyId) {
		for (int i = 0; i < numOfusers; i++)
			if (users[i].findProperty(propertyId) != null && users[i].findProperty(propertyId).isRented() == false)
				return users[i].findProperty(propertyId);
		return null;
	}// End method

}// End class
