
import java.time.temporal.ChronoUnit;
import java.util.Date;
public class Lease {
	private String leaseNo;
	private int PropertyId;
	private User tenant;
	private Date startDate;
	private Date endDate;
	private double totalRentAmount;
	
	

	public Lease(String leaseNo, int propertyId, User tenant, Date startDate, Date endDate, int size, ) {
		this.leaseNo = leaseNo;
		PropertyId = propertyId;
		this.tenant = tenant;
		this.startDate = startDate;
		this.endDate = endDate;
		calculateRentAmount();
	}

	public void updateDate(startDate: Date, endDate: Date){
		this.startDate = startDate;
		this.endDate = endDate;
		

	}
	
	public void calculateTotalRentAmount(double dailyRent) {
		long daysBetween =ChronoUnit.DAYS.between(startDate, endDate);
	 calculateRentAmount = dailyRent*daysBetween;
		
		
	}
	

	@Override
	public String toString() {
		return "leaseNo: " + leaseNo + "\nPropertyId: " + 
	PropertyId + "\ntenant: " + tenant + "\nstartDate: "
				+ startDate + "\nendDate: " + endDate + 
				"\ntotalRentAmount: " + totalRentAmount;
	}
	
	
}
