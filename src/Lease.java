
import java.time.temporal.ChronoUnit;
public class Lease {
	private String leaseNo;
	private int PropertyId;
	private User tenant;
	private Date startDate;
	private Date endDate;
	private double totalRent;
	
	

	public Lease(Date startDate, Date endDate, Propertyp pro) {
		leaseNo = id++;
		PropertyId = pro.getPropertyNum();
		
		this.startDate = startDate;
		this.endDate = endDate;
		
		
		
		calculateTotalRent(dailyRent);
		calculateTotalRent(pro.getPrice());
		pro.setRent(true);
		System.out.println("Lease was created succsefully with Lease Number: " + leaseNo);
		
	}

	
	public void calculateTotalRent(double dailyRent) {
		long daysBetween =ChronoUnit.DAYS.between(startDate, endDate);
	 calculateRentAmount = dailyRent*daysBetween;
		
		
	}
	

	@Override
	public String toString() {
		return "leaseNo: " + leaseNo + "\nPropertyId: " + 
	PropertyId + "\ntenant: " + tenant + "\nstartDate: "
				+ startDate + "\nendDate: " + endDate + 
				"\ntotalRentAmount: " + totalRent;
	}
	
	
}
