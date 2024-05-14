import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUImain {
	public static User[] users;
	public static int numOfusers;

	public static void main(String[] args) throws IOException {

		load(); // load users information from file

		users[0] = new User("12341234", "Sara Ahmed", "0509876543");
		Property property = new Apartment(users[0].getName(), users[0].getID(), "Riyadh", "Riyadh", "Alhamra",
				"Almasane", 200, 5);
		users[0].addProperty(property);

		try {

			users[1] = new User("12345678", "User", "0534567890");

			if ((users[1].getID()).length() != 8)
				throw new IdOrPhoneNumberException("ID");

		} catch (IdOrPhoneNumberException e) {
			System.out.println(e);
		}

		JFrame frame = new JFrame("Property Renting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// ------------------- Tab 1----------------
		JPanel panel1 = new JPanel();

		JLabel label = new JLabel("Enter LeaseID ");
		label.setBounds(10, 100, 230, 30);
		panel1.add(label);

		JTextField leaseIDField = new JTextField();
		leaseIDField.setColumns(10);
		leaseIDField.setBounds(250, 100, 190, 30);
		panel1.add(leaseIDField);

		JTextArea textArea = new JTextArea();
		textArea.setColumns(15);
		textArea.setRows(8);
		textArea.setBorder(BorderFactory.createLineBorder(Color.blue));
		textArea.setEditable(false);
		textArea.setBounds(110, 200, 400, 200);
		panel1.add(textArea);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(450, 100, 150, 30);

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == searchButton) {
					int leaseID = Integer.parseInt(leaseIDField.getText());
					textArea.setText(""); // Clear previous search results

					// Loop through users array to find the user who owns the lease
					Lease foundLease = users[1].searchLease(leaseID);
					if (foundLease != null) {
						// Display lease details in the text area
						textArea.append("Lease found:\n");
						textArea.append(foundLease.toString() + "\n");
						return; // Exit the loop if the lease is found
					} else {
						textArea.append("Lease with ID " + leaseID + " was not found.\n");

					}

				}
			}
		});
		panel1.add(searchButton);

		tabbedPane.addTab("SearchLease", panel1);

		// ------------------ Tab2 ------------------
		JPanel panel2 = new JPanel();

		label = new JLabel("Enter LeaseID to deleted ");
		label.setBounds(10, 100, 230, 30);
		panel2.add(label);

		JTextField leaseIDField2 = new JTextField();
		leaseIDField2.setColumns(10);
		leaseIDField2.setBounds(250, 100, 190, 30);
		panel2.add(leaseIDField2);

		JTextArea textArea2 = new JTextArea();
		textArea2.setColumns(15);
		textArea2.setRows(8);
		textArea2.setBorder(BorderFactory.createLineBorder(Color.blue));
		textArea2.setEditable(false);
		textArea2.setBounds(110, 200, 400, 200);
		panel2.add(textArea2);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(450, 100, 150, 30);
		panel2.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {
					int leaseID = Integer.parseInt(leaseIDField2.getText());
					boolean leaseRemoved = false;
					// Loop through users array to find the user who owns the lease
					if (users[1].removeLease(leaseID)) {

						textArea2.append("Lease with ID " + leaseID + " was deleted successfully.\n");
						leaseRemoved = true;
					}

					if (!leaseRemoved) {
						textArea2.append("Lease with ID " + leaseID + " was not found.\n");
					}
				}
			}
		});

		tabbedPane.addTab("DeleteLease", panel2);

		// -----------------Tab4-----------------

		JPanel panel4 = new JPanel();

		JLabel CityLabel = new JLabel("City:");
		CityLabel.setBounds(30, 50, 150, 30);
		panel4.add(CityLabel);

		JTextField CityField = new JTextField();
		CityField.setBounds(160, 50, 150, 30);
		CityField.setColumns(10);
		panel4.add(CityField);

		JLabel RegionLabel = new JLabel(" Region:");
		RegionLabel.setBounds(30, 100, 150, 30);
		panel4.add(RegionLabel);

		JTextField RegionField = new JTextField();
		RegionField.setBounds(160, 100, 150, 30);
		RegionField.setColumns(4);
		panel4.add(RegionField);

		JLabel DistreictLabel = new JLabel("Distreict:");
		DistreictLabel.setBounds(30, 150, 150, 30);
		panel4.add(DistreictLabel);

		JTextField DistreictField = new JTextField();
		DistreictField.setBounds(160, 150, 150, 30);
		DistreictField.setColumns(10);
		panel4.add(DistreictField);

		JLabel StreetLabel = new JLabel(" Street:");
		StreetLabel.setBounds(30, 200, 150, 30);
		panel4.add(StreetLabel);

		JTextField StreetField = new JTextField();
		StreetField.setBounds(160, 200, 150, 30);
		StreetField.setColumns(10);
		panel4.add(StreetField);

		JLabel AreaLabel = new JLabel(" Area in meter :");
		AreaLabel.setBounds(30, 250, 150, 30);
		panel4.add(AreaLabel);
		
		
	JTextField AreaField = new JTextField();


		AreaField.setBounds(160, 250, 150, 30);
		AreaField.setColumns(10);
		panel4.add(AreaField);

		JLabel gLabel = new JLabel("Type:");
		gLabel.setBounds(30, 300, 150, 30);
		panel4.add(gLabel);

		JLabel roomLabel = new JLabel(" number of rooms :");
		roomLabel.setBounds(30, 350, 150, 30);
		panel4.add(roomLabel);

		JTextField roomField = new JTextField();
		roomField.setBounds(160, 350, 150, 30);
		roomField.setColumns(10);

		panel4.add(roomField);

		ButtonGroup gGroup = new ButtonGroup();

		JRadioButton ApartmentRadio = new JRadioButton("Apartment");
		ApartmentRadio.setBounds(140, 300, 100, 30);
		panel4.add(ApartmentRadio);

		JRadioButton ShopRadio = new JRadioButton("Shop");
		ShopRadio.setBounds(240, 300, 100, 30);
		ShopRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				roomField.setText("");
				roomField.setEditable(false);
			}
		});

		panel4.add(ShopRadio);

		gGroup.add(ApartmentRadio);
		gGroup.add(ShopRadio);

		JButton AddButton = new JButton("Add");
		AddButton.setBounds(280, 400, 100, 30);

		AddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Property property2;
				if (e.getSource() == ApartmentRadio) {
					roomField.setEnabled(true);
					property2 = new Apartment(users[1].getName(), users[1].getName(), CityField.getText(),
							RegionField.getText(), DistreictField.getText(), StreetField.getText(),
							Integer.parseInt(AreaField.getText()), Integer.parseInt(roomField.getText()));
				} else {
					roomField.setEnabled(false);

					property2 = new Shop(users[1].getName(), users[1].getName(), CityField.getText(),
							RegionField.getText(), DistreictField.getText(), StreetField.getText(),
							Integer.parseInt(AreaField.getText()));}

				users[1].addProperty(property2);
				JOptionPane.showMessageDialog(null, "property with ID" + property2.getPropertyID() + " was created");
			}
		});

		panel4.add(AddButton);

		frame.add(panel4);

		// ------------------ Tab3 ------------------

		JPanel panel3 = new JPanel();

		JLabel label3 = new JLabel("Enter propertyID ");
		label3.setBounds(10, 100, 230, 30);
		panel3.add(label3);

		JTextField propertyIdField = new JTextField();
		propertyIdField.setColumns(10);
		propertyIdField.setBounds(250, 100, 190, 30);
		panel3.add(propertyIdField);

		
		JTextArea textArea3 = new JTextArea();
		textArea3.setColumns(15);
		textArea3.setRows(8);
		textArea3.setBorder(BorderFactory.createLineBorder(Color.blue));
		textArea3.setEditable(false);
		textArea3.setBounds(110, 200, 400, 200);
		panel3.add(textArea3);

		JButton searchButton3 = new JButton("Search");
		searchButton3.setBounds(450, 100, 150, 30);

		searchButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == searchButton3) {
					int propertyID = Integer.parseInt(propertyIdField.getText());
					textArea.setText(""); // Clear previous search results

					Property foundProperty = users[1].findProperty(propertyID);
					if (foundProperty != null) {
						// Display lease details in the text area
						textArea3.append("property found:\n");
						textArea3.append(foundProperty.toString() + "\n");
					} else {
						textArea3.append("property with ID " + propertyID + " was not found.\n");
					}
				}
			}
		});

		panel3.add(searchButton3);

		tabbedPane.addTab("SearchProperty", panel3);

		tabbedPane.addTab("AddProperty", panel4);

		frame.add(tabbedPane);
		frame.setVisible(true);

		save();

	}

	public static void save() throws IOException {
		File usersFileOut = new File("users.ser");
		FileOutputStream usersFileOutStream = new FileOutputStream(usersFileOut);
		ObjectOutputStream outUsersObjectStream = new ObjectOutputStream(usersFileOutStream);

		outUsersObjectStream.writeInt(numOfusers);
		outUsersObjectStream.writeInt(Property.getID());
		outUsersObjectStream.writeInt(Lease.getID());

		for (int i = 0; i < numOfusers; i++)
			outUsersObjectStream.writeObject(users[i]);
		outUsersObjectStream.close();
	}

	public static void load() throws IOException {
		File usersFile = new File("users.ser");

		FileInputStream usersFileInStream = null;

		if (usersFile.exists()) {
			try {
				usersFileInStream = new FileInputStream(usersFile);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			ObjectInputStream usersObjectStream = new ObjectInputStream(usersFileInStream);
			int usersSize = usersObjectStream.readInt();
			int lastPropertyID = usersObjectStream.readInt();
			int lastLeaseID = usersObjectStream.readInt();

			Property.setID(lastPropertyID);
			Lease.setID(lastLeaseID);

			users = new User[usersSize + 2];
			try {
				while (true) {
					users[numOfusers] = (User) usersObjectStream.readObject();
					numOfusers++;
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (EOFException e) {
			}
			usersObjectStream.close();

		} else {
			users = new User[2];
		}

	}

}
