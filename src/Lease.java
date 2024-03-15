
public class Lease {
	private static int ID = 1;
	private int leaseID;
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
	public String toString() {// n
		return ("\nLease ID: " + leaseID + "\nTenant name: " + tanantName + "\nTanent ID: " + tanentID
				+ "\nDuration in days: " + duration + "\nTotal rent: " + totalRent);
	}

	public int getLeaseID() {
		return leaseID;
	}

	public Property getProperty() {
		return property;
	}
}// End class
