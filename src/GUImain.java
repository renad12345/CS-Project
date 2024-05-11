import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUImain  {
	public static User[] users;
	public static int numOfusers;
public static void main(String[] args) throws IOException{
	
	load();
	//Container contentPane = new Container();
	JFrame frame = new JFrame("Tab");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,200);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//tab.setBounds(10,32,511,361);
	
	// ------------------- Tab 1----------------
	JPanel panel1 = new JPanel();
	
	JLabel label = new JLabel("Enter LeaseID " ) ;
  	 label.setBounds(10 , 100, 230, 30  ) ;
  	 panel1.add(label);
  	 
  	 
  	//setSize (700, 600);
	// setResizable (false);
	// setTitle (" search Lease ");
	// setLocation (200, 300);
	// panel1..setLayout(null);

	 JTextField leaseIDField = new JTextField();
	 leaseIDField.setColumns(10);
	 leaseIDField.setBounds(250 , 100 , 190, 30 ) ;
	 panel1.add(leaseIDField);
	 
     JTextArea textArea = new JTextArea();
     textArea.setColumns(15);
     textArea.setRows(8);
     textArea.setBorder(BorderFactory.createLineBorder(Color.blue));
     textArea.setEditable(false);
     textArea.setBounds(110 , 200 , 400 , 200 ) ;
     // textArea.setBounds(250 , 150 , 190 , 30 ) ;
      panel1.add(textArea);

      
     
     
	 JButton  searchButton = new JButton("Search");
       searchButton.setBounds(450, 100 , 150 , 30 ) ;

       searchButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == searchButton) {
	    	        int leaseID = Integer.parseInt(leaseIDField.getText());
	    	        textArea.setText(""); // Clear previous search results
	    	        
	    	        // Loop through users array to find the user who owns the lease
	    	        for (int i = 0; i < PropertyTest.numOfusers; i++) {
	    	            Lease foundLease = PropertyTest.users[i].searchLease(leaseID);
	    	            if (foundLease != null) {
	    	                // Display lease details in the text area
	    	                textArea.append("Lease found:\n");
	    	                textArea.append(foundLease.toString() + "\n");
	    	                return; // Exit the loop if the lease is found
	    	            }
	    	        }
	    	       
	    	        textArea.append("Lease with ID " + leaseID + " was not found.\n");
	    	    }			
		}
	});
       panel1.add(searchButton) ;

      // add(searchButton);
    tabbedPane.addTab("Tab 1", panel1);
    
    
    //------------------ Tab2 ------------------
    JPanel panel2 = new JPanel();

    	label = new JLabel("Enter LeaseID that you want to deleted " ) ;
    	 label.setBounds(10 , 100, 230, 30  ) ;
    	 panel2.add(label);
    	 
    	
    	//setSize (700, 600);
    	// setResizable (false);
    	// setTitle (" delete Lease ");
    	// setLocation (200, 300);
    	 panel2.setLayout(null);
        
    	 JTextField leaseIDField2 = new JTextField();
    	 leaseIDField2.setColumns(10);
    	 leaseIDField2.setBounds(250 , 100 , 190, 30 ) ;
    	 panel2.add(leaseIDField2);
    	 
    	 JTextArea textArea2 = new JTextArea();
         textArea2.setColumns(15);
         textArea2.setRows(8);
         textArea2.setBorder(BorderFactory.createLineBorder(Color.blue));
         textArea2.setEditable(false);
         textArea2.setBounds(110 , 200 , 400 , 200 ) ;
        panel2.add(textArea2);
    	 
    	 JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(450, 100 , 150 , 30 ) ;
        panel2.add(deleteButton) ;
        deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {
	    	        int leaseID = Integer.parseInt(leaseIDField2.getText());
	    	        boolean leaseRemoved = false;
	    	        // Loop through users array to find the user who owns the lease
	    	        for (int i = 0; i < PropertyTest.numOfusers; i++) {
	    	            if (PropertyTest.users[i].removeLease(leaseID)) {
	    	               
	    	                textArea2.append("Lease with ID " + leaseID + " was deleted successfully.\n");
	    	                leaseRemoved = true;
	    	                break; // Exit the loop if the lease was found and deleted
	    	            }
	    	        }
	    	        if (!leaseRemoved) {
	    	              textArea2.append("Lease with ID " + leaseID + " was not found.\n");
	    	        }
	    	    }				
			}
		});
        
      //  add(deleteButton);
        tabbedPane.addTab("Tab 2", panel2);
        frame.add(tabbedPane);
        frame.setVisible(true);
       
        save();
       
         
       
    }
public static void load() throws IOException {
	File usersFile = new File("users.ser");
	
	
	if(usersFile.exists()) {
		FileInputStream usersFileInStream = new FileInputStream(usersFile);
		ObjectInputStream usersObjectStream = new ObjectInputStream(usersFileInStream);
		int usersSize = usersObjectStream.readInt();
		
		int lastPropertyID = usersObjectStream.readInt();
		int lastLeaseID = usersObjectStream.readInt();
		
		Property.setID(lastPropertyID);
		Lease.setID(lastLeaseID);
		
		users = new User[usersSize + 2];

		try {
			while (true) {
				users[numOfusers]=(User)usersObjectStream.readObject();
				numOfusers++;
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		catch (EOFException e) {
			// TODO: handle exception
		}
		usersObjectStream.close();

	}
	else {
		users = new User[1];
	}

}

public static void save() throws IOException {
	File usersFileOut = new File("users.ser");
	FileOutputStream usersFileOutStream = new FileOutputStream(usersFileOut);
	ObjectOutputStream outUsersObjectStream = new ObjectOutputStream(usersFileOutStream);
	
	outUsersObjectStream.writeInt(numOfusers);
	outUsersObjectStream.writeInt(Property.getID());
	outUsersObjectStream.writeInt(Lease.getID());

	
	for(int i = 0; i<numOfusers; i++)
		outUsersObjectStream.writeObject(users[i]);
	outUsersObjectStream.close();
}
  
}
