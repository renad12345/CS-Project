
 import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
 public class GUI extends JFrame implements ActionListener{
  
  private JButton button ;
  private JLabel label ;
  private JTextField inputLine;
  public JTextArea textArea ;
  private int LeaseID ;
 
 
 
 
 
 public GUI(){
 
 Container contentPane = getContentPane( );
 setSize (700, 600);
 setResizable (false);
 setTitle (" search Lease ");
 setLocation (200, 300);
 contentPane.setLayout(null);
 
 

label = new JLabel("Enter Lease ID " ) ;
 label.setBounds(30 , 100 , 150 , 30 ) ;
 contentPane.add(label);

 inputLine = new JTextField();
 inputLine.setColumns(10);
 inputLine.setBounds(160 , 100 , 150 , 30 ) ;
 contentPane.add(inputLine);
 
 button = new JButton("view info");
 button.setBounds(320 , 100 , 150 , 30 ) ;
 contentPane.add(button) ;
 button.addActionListener(this);
 
 
 textArea = new JTextArea();
 textArea.setColumns(15);
 textArea.setRows(8);
 textArea.setBorder(BorderFactory.createLineBorder(Color.blue));
 textArea.setEditable(false);
 textArea.setBounds(30 , 200 , 400 , 200 ) ;
 contentPane.add(textArea);
 
 setDefaultCloseOperation( EXIT_ON_CLOSE ); 
 setVisible(true);
 }
 public void actionPerformed(ActionEvent event) {
	
	 LeaseID =Integer.parseInt(inputLine.getText());
 
 
 }
 public int getID(){
 return LeaseID;
 }
 
 public boolean IDState(){
 if(LeaseID==0)
 return false;
 return true;
 }
	
	

public static void main(String[] args) {
	GUI frame  = new GUI() ;
 frame.setVisible(true);

}
 }