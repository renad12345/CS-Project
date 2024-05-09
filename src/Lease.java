import java.io.Serializable;

public class Lease implements Serializable {
	private static int ID = 1;
	private static int leaseID;
	private String tanantName;
	private String tanentID;
	private Property property;
	private int duration;
	private double totalRent;

	public Lease(String tanentName, String tanentID, int duration, Property pro) {
		leaseID = ID++;
		property = pro;

		this.tanantName = tanentName;
		this.tanentID = tanentID;

		this.duration = duration;

		// call calculateTotalRent method to set totalRent
		calculateTotalRent(pro.calculateDailyRent());
		// change renting status for the property that the lease relates to
		property.setRented(true);
		System.out.println("Lease was created succsefully with Lease ID: " + leaseID);

	}

	public Lease(Lease L) {
		leaseID = L.leaseID;

		tanantName = L.tanantName;
		tanentID = L.tanentID;

		duration = L.duration;
		property = L.property;

		totalRent = L.totalRent;

	}

	public void calculateTotalRent(double dailyRent) {
		totalRent = property.dailyRent * duration;
	}

	@Override
	public  String toString() {// n
		return ("\nLease ID: " + leaseID + "\nTenant name: " + tanantName + "\nTanent ID: " + tanentID
				+ "\nDuration in days: " + duration + "\nTotal rent: " + totalRent);
	}

	public static int getLeaseID() {
		return leaseID;
	}

	public Property getProperty() {
		return property;
	}
	
	public static void setID(int iD) {
		ID = iD;
	}
	public static int getID() {
		return ID;
	}

	public String getTanantName() {
		return tanantName;
	}

	public void setTanantName(String tanantName) {
		this.tanantName = tanantName;
	}

	public String getTanentID() {
		return tanentID;
	}

	

	public int getDuration() {
		return duration;
	}

	
	public double getTotalRent() {
		return totalRent;
	}

	
}// End class

