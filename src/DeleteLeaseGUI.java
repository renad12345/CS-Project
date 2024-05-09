
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteLeaseGUI extends JFrame implements ActionListener {
    private JTextField leaseIDField;
    private JButton deleteButton;
    public JTextArea textArea ;
    private JLabel label ;
    public DeleteLeaseGUI() {
    	Container contentPane = getContentPane( );
    	
    	label = new JLabel("Enter LeaseID that you want to deleted " ) ;
    	 label.setBounds(10 , 100, 230, 30  ) ;
    	 contentPane.add(label);
    	 
    	
    	setSize (700, 600);
    	 setResizable (false);
    	 setTitle (" delete Lease ");
    	 setLocation (200, 300);
    	 contentPane.setLayout(null);
        
    	 leaseIDField = new JTextField();
    	 leaseIDField.setColumns(10);
    	 leaseIDField.setBounds(250 , 100 , 190, 30 ) ;
    	 contentPane.add(leaseIDField);
    	 
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(450, 100 , 150 , 30 ) ;
        
        contentPane.add(deleteButton) ;
        deleteButton.addActionListener(this);
        add(deleteButton);
        contentPane.add(deleteButton) ;
        
        
       
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
    	 if (e.getSource() == deleteButton) {
    	        int leaseID = Integer.parseInt(leaseIDField.getText());
    	        boolean leaseRemoved = false;
    	        // Loop through users array to find the user who owns the lease
    	        for (int i = 0; i < PropertyTest.numOfusers; i++) {
    	            if (PropertyTest.users[i].removeLease(leaseID)) {
    	               
    	                textArea.append("Lease with ID " + leaseID + " was deleted successfully.\n");
    	                leaseRemoved = true;
    	                break; // Exit the loop if the lease was found and deleted
    	            }
    	        }
    	        if (!leaseRemoved) {
    	              textArea.append("Lease with ID " + leaseID + " was not found.\n");
    	        }
    	    }
    }

    public static void main(String[] args) {
        new DeleteLeaseGUI();
    }
}