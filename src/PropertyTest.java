import java.util.Scanner;
import java.util.Date;
public class PropertyTest {
	static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		
System.out.println("******************* Property Renting *******************");
System.out.println("Welcome Here!");

System.out.println("Please, tell us more about you!");
System.out.println("Full name:");
String name=input.nextLine();

System.out.println("ID number:");
String ID = input.next();

System.out.println("Phone Number:");
String phoneNumber=input.next();

System.out.println("Maximum number of properties you might list to renting");
int propertyNum = input.nextInt();

System.out.println("Maximum number of properties you might rent");
int rentPropertyNum = input.nextInt();

User u1 = new User(name, ID, phoneNumber, propertyNum, rentPropertyNum);

System.out.println("How can I help you? enter one of the following options");
System.out.println("1- Rent a property");
System.out.println("2- Remove a rented property");
System.out.println("3- Search for a rented property");
System.out.println("4- list a property for renting");
System.out.println("5- Remove a property");
System.out.println("6- Search for a property");
System.out.println("7- Exit");
int choice = input.nextInt();

while (choice!=7)
	switch (choice){
	case 1:
		System.out.println("Enter property id");
		String propertyID = input.next();
		System.out.println("Enter start Date");
		
		System.out.println("Enter End Date");
		

	 break;
	
	case 2:
		break;
		
	case 3:
		break;
		
	case 4:
		break;
		
	case 5:
		break;
		
	case 6:
		break;
		
	}


	}

}
