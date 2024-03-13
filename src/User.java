import java.util.Arrays;

public class User {
	private String ID ;
	private String name;
	private String phone;
	private int numOfLease ; 
	private int numOfProperty;
	Lease leases [] ;
	Property properties [] ;
	
	public User(String ID, String name, String phone, int leasesSize, int propertiesSize) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;

		leases = new Lease [leasesSize];
		properties = new Property [propertiesSize];		
		
		numOfLease = 0;
		numOfProperty = 0;
	}
	
	
	public boolean addLease (Lease L) {
		if (numOfLease<leases.length)
		{
			leases[numOfLease++]=new Lease(L);
			 return true;	
		}
		return false;	
		
	}
	//
	public Lease SearchLease(int LeaseID) {
		for(int i = 0 ;i < numOfLease ; i++)
		if(leases[i].getLeaseID()== LeaseID )
		return leases[i]; 
	
		
		return null;
			
	}
	
	
	
	public boolean  removeLease (int LeaseID) {
		
		for(int i = 0 ;i < numOfLease ; i++)
			if(leases[i].getLeaseID() == LeaseID) {
				
				for(int j = i ; j < numOfLease -1 ; j++) 
					leases[j] = leases[j+1] ;
				numOfLease-- ;
				leases[numOfLease ]= null;	
				
				return true;
			}
		return false;	
		
	}
	
	
	
	
	// 
	public boolean addProperty(  Property p ) {
	if (properties.length < numOfProperty )
	{
	if (p instanceof Shop  )
		properties[numOfProperty++]=new Shop ((Shop) p);
		else 
	if (p instanceof Apartment  )
    properties[numOfProperty++]=new Apartment ((Apartment) p)	;	
		
		
	
	return true ;	
	}
	return false ;	
		
	}
	
	
	
	
public boolean  removeProperty ( int propertyId) {
		
		for(int i = 0 ;i < numOfProperty ; i++)
			if(properties[i].getPropertyID()==propertyId) {
				
				for(int j = i ; j < numOfProperty -1 ; j++) 
					properties[j] = properties[j+1] ;
				numOfProperty-- ;
				properties[numOfProperty ]= null;	
				
				return true;
			}
		return false;	
		
	}
	
	public Property findProperty( int propertyid) {
		for(int i = 0 ; i < numOfProperty ; i++)
			if(properties[i].propertyID ==(propertyid) )
			
			return properties[i]; 
		
			return null ; 
			}
		
	
	public boolean availableProperties() {
	
		for(int i = 0 ; i < numOfProperty ; i++)
		if (Property.rented())	
			
		return false;
		
		return true; 
		
	}


	


	public String getID() {
		return ID;
	}


	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}
	


	public int getNumOfLease() {
		return numOfLease;
	}


	public int getNumOfproperty() {
		return numOfProperty;
	}


	@Override
	public String toString() { //#
		return "User [id=" + ID + ", name=" + name + ", phone=" + phone + ", numOfLease=" + numOfLease
				+ ", numOfproperty=" + numOfProperty + ", leases=" + Arrays.toString(leases) + ", properties="
				+ Arrays.toString(properties) + "]";
	}


	
	
	
	
	
	
	
	
}
