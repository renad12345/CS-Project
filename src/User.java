
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
	
	
	public boolean addLease(Lease L) {
		if (numOfLease<leases.length)
		{
			leases[numOfLease++]=new Lease(L);
			 return true;	
		}
		return false;	
		
	}
	
	public Lease searchLease(int LeaseID) {
		for(int i = 0 ;i < numOfLease ; i++)
		if(leases[i].getLeaseID()== LeaseID )
		return leases[i]; 
	
		
		return null;
			
	}
	
	
	
	public boolean  removeLease (int LeaseID) {
		
		for(int i = 0 ;i < numOfLease ; i++)
			if(leases[i].getLeaseID() == LeaseID) {
				(leases[i].getProperty()).setRented(false);
				for(int j = i ; j < numOfLease -1 ; j++) 
					leases[j] = leases[j+1] ;
				numOfLease-- ;
				leases[numOfLease]= null;	
				
				return true;
				
			}
		return false;	
		
	}
	
	
	
	public boolean addProperty(  Property p ) {
	if (numOfProperty <  properties.length )
	{
	if (p instanceof Shop  )
		properties[numOfProperty++] = new Shop ((Shop) p);
		else 
	if (p instanceof Apartment  )
    properties[numOfProperty++] = new Apartment ((Apartment) p)	;	
		
		
	
	return true ;	
	}
	return false ;	
		
	}
	
	
	
	
public boolean  removeProperty ( int propertyId) {
		
		for(int i = 0 ;i < numOfProperty ; i++)
			if(properties[i].getPropertyID()==propertyId && properties[i].isRented()==false) {
				
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
		
	
	public void availableProperties() {
	
		for(int i = 0 ; i < numOfProperty ; i++)
		if (!(properties[i].isRented())) {
			System.out.println("Owener name: " + properties[i].getOwnerName() + "\n" + properties[i] );	
			System.out.println("\n");}
	}
	
	
	public int availablePropertiesNum() {
		int availablePropertyNum = 0;
		for (int i = 0; i<numOfProperty; i++)
			if (!(properties[i].isRented()))
				availablePropertyNum++;
		return availablePropertyNum;

	}

	@Override
	public String toString() { 
		String propertiesInfo = "\n Properties Information: \n";
		for (int i = 0; i<numOfProperty; i++)
			propertiesInfo += properties[i].toString() + "\n";
		
		String leasesInfo = "\nLeases Information: \n";
		for (int i = 0; i<numOfLease; i++)
			propertiesInfo += leases[i].toString() + "\n";
		
			
		return "User ID: " + ID + "\nname: " + name + "\nphone: " + phone +
				"\nnumber Of leases: " + numOfLease
				+leasesInfo + "\nnumber of properties: " + numOfProperty + propertiesInfo;
	}
	

	public String getName() {
		return name;
	}
	
	public String getID() {
		return ID;
	}
	
	public int getNumOfProperty() {
		return numOfProperty;
	}
	
	
	
}
