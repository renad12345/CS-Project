
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

public class SearchLeaseGUI extends JFrame implements ActionListener {
    private JTextField leaseIDField;
    private JButton searchButton;
    private JTextArea textArea;
    private JLabel label ;
    
    public SearchLeaseGUI() {
    	Container contentPane = getContentPane( );
    	
    	label = new JLabel("Enter LeaseID " ) ;
   	 label.setBounds(10 , 100, 230, 30  ) ;
   	 contentPane.add(label);
   	 
   	 
   	setSize (700, 600);
	 setResizable (false);
	 setTitle (" search Lease ");
	 setLocation (200, 300);
	 contentPane.setLayout(null);

   	leaseIDField = new JTextField();
	 leaseIDField.setColumns(10);
	 leaseIDField.setBounds(250 , 100 , 190, 30 ) ;
	 contentPane.add(leaseIDField);
	 
      
        searchButton = new JButton("Search");
        searchButton.setBounds(450, 100 , 150 , 30 ) ;
        searchButton.addActionListener(this);
        add(searchButton);
      
       
    
        contentPane.add(searchButton) ;
        

        textArea = new JTextArea();
        textArea.setColumns(15);
        textArea.setRows(8);
        textArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        textArea.setEditable(false);
        textArea.setBounds(110 , 200 , 400 , 200 ) ;
        contentPane.add(textArea);
        
        setDefaultCloseOperation( EXIT_ON_CLOSE ); 

        setVisible(true);
    }

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

    public static void main(String[] args) {
        new SearchLeaseGUI();
    }
}