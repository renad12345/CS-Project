import java.util.Arrays;

public class User {
	private int id ;
	private String name;
	private String phone;
	private int numOfLease ; 
	private int numOfproperty;
	Lease leases [] ;
	Property properties [] ;
	public User(int id, String name, String phone, int numOfLease, int numOfproperty, int Lsize , 
			int psize) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.numOfLease = numOfLease;
		this.numOfproperty = numOfproperty;
		leases = new Lease [Lsize];
		properties = new Property [psize];			
	}
	
	
	public boolean addLease ( Lease L) {
		if (numOfLease<Lease.length)
		{
			leases[numOfLease++]=new Lease(L)
			 return true;	
		}
		return false;	
		
	}
	
	public Lease SearchLease(String LNo ) {
		for(int i = 0 ;i < numOfLease ; i++)
		if(leases[i].getleaseNo().equals(LNo))
		return leases[i] ; 
	
		
		return null ;
			
	}
	
	
	
	public boolean  removeLease ( String leaseId) {
		
		for(int i = 0 ;i < numOfLease ; i++)
			if(leases[i].getleaseNo().equals(leaseId)) {
				
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
	if (properties.length < numOfproperty )
	{
	if (p instanceof Shop  )
		properties[numOfproperty++]=new Shop ((Shop) p)	
		else 
	if (p instanceof Apartment  )
    properties[numOfproperty++]=new Apartment ((Apartment) p)		
		
		
	
	return true ;	
	}
	return false ;	
		
	}
	
	
	
	
public boolean  removeproperty ( String propertyId) {
		
		for(int i = 0 ;i < numOfproperty ; i++)
			if(properties[i].getPropertyNum().equals(propertyId)) {
				
				for(int j = i ; j < numOfproperty -1 ; j++) 
					properties[j] = properties[j+1] ;
				numOfproperty-- ;
				properties[numOfproperty ]= null;	
				
				return true;
			}
		return false;	
		
	}
	
	public Property findProperty( String propertynum) {
		for(int i = 0 ; i < numOfproperty ; i++)
			if(properties[i].propertyNum.euqals(propertynum) )
			
			return properties[i]; 
		
			return null ; 
			}
		
	
	public boolean availableproperties() {
	
		for(int i = 0 ; i < numOfproperty ; i++)
		if (rented())	
		return false;
		
		return true; 
		
	}


	public int getId() {
		return id;
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
		return numOfproperty;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", numOfLease=" + numOfLease
				+ ", numOfproperty=" + numOfproperty + ", leases=" + Arrays.toString(leases) + ", properties="
				+ Arrays.toString(properties) + "]";
	}


	
	
	
	
	
	
	
	
}
