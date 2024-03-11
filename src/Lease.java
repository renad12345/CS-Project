
import java.time.temporal.ChronoUnit;
public static ID = 0;
public class Lease {
	private String leaseID;
	private Date startDate;
	private Date endDate;
	private Property property;
	private String tenentName;
	private String tenentID:
	private double totalRent;
	
	
	
//Constructor
	public Lease(Date startDate, Date endDate, Propertyp property, String tenentName, String tenentID) {
		leaseID = ID++;

		this.startDate = startDate;
		this.endDate = endDate;
		this.property = property;

		
		this.tenentName = tenentName;
		this.tenentID = tenentID;
		
		
		
	}
	//copy Constructor
	public Lease (Lease lease) {
		leaseNo = lease.leaseNo;
		property = lease.property;
		tenentName = lease.tenentName;
		tenentID = lease.tenentID;
		startDate = lease.startDate;
		endDate = lease.endDate;
		totalRent = lease.totalRent;
		
	}
		
		calculateTotalRent(property.getPrice()){
		property.setRented(true);
		System.out.println("Lease was created succsefully with Lease ID: " + leaseNo);
		
	}
	
	
	

	
	public void calculateTotalRent(double dailyRent) {
		long daysBetween =ChronoUnit.DAYS.between(startDate, endDate);
	 calculateRentAmount = dailyRent*daysBetween;
		
		
	}
	

	@Override
	public String toString() {
		return "leaseNo: " + leaseNo + "Property Information:" + property.toString() 
		+ "\ntenent Name: " + tenentName + "\ntenent ID: "+ tenentID +  "\nstartDate: "
				+ startDate + "\nendDate: " + endDate + 
				"\ntotalRentAmount: " + totalRent;
	}
	
	
}
