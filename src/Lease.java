
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Lease {
	public static int ID = 0;
	private int leaseID;
	private Date startDate;
	private Date endDate;
	private Property property;
	private String tenentName;
	private String tenentID;
	private double totalRent;
	
	
	
//Constructor
	public Lease(Date startDate, Date endDate, Property property, String tenentName, String tenentID) {
		leaseID = ID++;

		this.startDate = startDate;
		this.endDate = endDate;
		this.property = property;

		
		this.tenentName = tenentName;
		this.tenentID = tenentID;
		
		calculateTotalRent(property.calculateDailyRent());
		
	}
	//copy Constructor
	public Lease (Lease lease) {
		leaseID = lease.leaseID;
		property = lease.property;
		tenentName = lease.tenentName;
		tenentID = lease.tenentID;
		startDate = lease.startDate;
		endDate = lease.endDate;
		totalRent = lease.totalRent;
		
		//#
		calculateTotalRent(property.calculateDailyRent());
		property.setRented(true);
		System.out.println("Lease was created succsefully with Lease ID: " + leaseID);
		
	}
	
	
	

	
	public void calculateTotalRent(double dailyRent) {
		long daysBetween =ChronoUnit.DAYS.between(startDate, endDate);
		totalRent = dailyRent*daysBetween;
		
		
	}
	

	@Override
	public String toString() {
		return "leaseNo: " + leaseID + "Property Information:" + property.toString() 
		+ "\ntenent Name: " + tenentName + "\ntenent ID: "+ tenentID +  "\nstartDate: "
				+ startDate + "\nendDate: " + endDate + 
				"\ntotalRentAmount: " + totalRent;
	}
	
	public int getLeaseID() {
		return leaseID;
	}
	
}
