import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddpropretyGUI extends JFrame implements ActionListener {
   
   private JLabel CityLabel, RegionLabel, DistreictLabel, gLabel , StreetLabel ,  AreaLabel , roomLabel ;
   private JTextField CityField,  RegionField,  DistreictField , StreetField ,  AreaField , roomField ;
   private JRadioButton ApartmentRadio, ShopRadio;
   private JButton AddButton;
   private ButtonGroup gGroup = new ButtonGroup();
      Container contentPane;
      private User currentUser;
  
   public AddpropretyGUI() {
       setTitle("Add proprety");
       setSize(700, 600);
        setLocation (200, 300);
        setResizable (false);
       // Create a content pane
       contentPane = getContentPane();
       contentPane.setLayout(null);

       CityLabel = new JLabel("City:");
       CityLabel.setBounds(30 , 50 , 150 , 30 ); 
       contentPane.add(CityLabel);
       
       CityField = new JTextField();
      CityField.setBounds(160 , 50 , 150 , 30 ) ;
       CityField.setColumns(10);
       contentPane.add(CityField);

       RegionLabel = new JLabel(" Region:");
       RegionLabel.setBounds(30 , 100 , 150 , 30 );
       contentPane.add( RegionLabel);
       
       RegionField = new JTextField();
       RegionField.setBounds(160 , 100 , 150 , 30 ) ;
       RegionField.setColumns(4);
       contentPane.add(RegionField);

       DistreictLabel = new JLabel("Distreict:");
       DistreictLabel.setBounds(30 ,150 , 150 , 30 );
       contentPane.add(DistreictLabel);
       
       DistreictField = new JTextField();
      DistreictField.setBounds(160 ,150 , 150 , 30 );
       DistreictField.setColumns(10);
       contentPane.add(DistreictField);
       
       StreetLabel = new JLabel(" Street:");
       StreetLabel.setBounds(30 , 200 ,150 , 30 ); 
       contentPane.add( StreetLabel);
       
       StreetField = new JTextField();
       StreetField.setBounds(160 , 200 , 150 , 30 ) ;
       StreetField.setColumns(10);
        contentPane.add( StreetField);
            
        AreaLabel = new JLabel(" Area in meter :");
        AreaLabel.setBounds(30 , 250 ,150 , 30 ); 
        contentPane.add( AreaLabel);
        
        AreaField = new JTextField();
        AreaField.setBounds(160 , 250 , 150 , 30 ) ;
        AreaField.setColumns(10);
         contentPane.add( AreaField);
         

       gLabel = new JLabel("Type:");
       gLabel.setBounds(30 ,300 , 150 , 30 );
       contentPane.add(gLabel);
       
       
       ApartmentRadio = new JRadioButton("Apartment");
       ApartmentRadio.setBounds(140 , 300 , 100 , 30 ) ;
       ApartmentRadio.addActionListener(this);
       contentPane.add(ApartmentRadio );
       
       
      ShopRadio = new JRadioButton("Shop");
       ShopRadio.setBounds(240 , 300 , 100 , 30 ) ;
      ShopRadio.addActionListener(this);
       contentPane.add(ShopRadio );

         
           
       

      
       gGroup.add(ApartmentRadio);
       gGroup.add(ShopRadio);
       
       roomLabel = new JLabel(" number of rooms :");
       roomLabel.setBounds(30 , 350 ,150 , 30 ); 
       contentPane.add( roomLabel);
       
       roomField = new JTextField();
       roomField.setBounds(160 , 350 , 150 , 30 ) ;
       roomField.setColumns(10);
      
       
       contentPane.add( roomField);
       
       AddButton = new JButton("Add");
        AddButton.setBounds(280, 400, 100, 30);
        AddButton.addActionListener(this);
        contentPane.add(AddButton);
    }
        
            
  

   public static void main(String[] args) {
   AddpropretyGUI frame  = new AddpropretyGUI() ;
    frame.setVisible(true);
  
   }
 
   
@Override
public void actionPerformed(ActionEvent e) {
	Property property;
if (e.getSource() == ApartmentRadio) {
	 property = new Apartment(users[1].getName(),users[1].getName(), CityField.getText(), RegionField.getText(), DistreictField.getText(), StreetField.getText(), Integer.parseInt(AreaField.getText()), Integer.parseInt(roomField.getText()));
          roomField.setEditable(true); 
       } else if (e.getSource() == ShopRadio) {
          roomField.setText(""); 
          roomField.setEditable(false); 
          
           
       }
  
       }
   }
//}