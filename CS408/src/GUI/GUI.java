package GUI;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.sql.ResultSetMetaData;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.sql.RowSetEvent;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
//////

import javax.swing.table.AbstractTableModel;

import java.awt.GridLayout;
import java.awt.GridLayout;

public class GUI implements ActionListener{

	private JButton cancelButton;   //???
	private JLabel userLabel,passwordLabel; //???    
	
    //private boolean DEBUG = false;
    private JTable table;
    private JFrame frame;    //(the frame) shown by GUI
    private JPanel mainPanel;//,gridPanel,menuPanel,innerMenuPanel,sidePanel,otherPanel 
    private JPanel sidePanel,inPanel;
    private JComboBox cBox;
    private String[] userOptions = {"Patient","Doctor"};  

	private JButton loginButton,aButton,bButton,cButton,dButton,a1Button,a2Button,b1Button,b2Button,c1Button,c2Button,d1Button,d2Button,e1Button,e2Button;
	private JTextField userTextField,passwordTextField;  
	private Integer messageID;
	private Integer evalID;
	private String kID;
	private importdb database;

	/**
	 * constructor that creates the frame and the main portion of the graphical user interface
	 */
	public GUI(importdb database)
	{
			this.database = database;
			messageID = 1;
			evalID = 1;
			kID = new String();
			login();
	}
	
	public void login(){

		//creates a frame and instantiates an instance of TrafficCanvas passing the GUI through it's constructor
		frame = new JFrame("mediConnect");
	
		//create components
		loginButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		cBox = new JComboBox(userOptions);
		cBox.setSelectedIndex(0);
		userTextField = new JTextField(8);
		userLabel = new JLabel("User ID: ");
		passwordTextField = new JTextField(8);
		passwordLabel = new JLabel("Password: ");
	
		//add action listeners
		loginButton.addActionListener(this);
		cancelButton.addActionListener(this);
		cBox.addActionListener(this);
		userTextField.addActionListener(this);
		passwordTextField.addActionListener(this);
	
		//new group layout object, and assoc it with panel
	    GroupLayout layout = new GroupLayout(frame.getContentPane());
	    frame.getContentPane().setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	
	    layout.setHorizontalGroup(layout.createSequentialGroup()
	    	.addGroup(layout.createParallelGroup(LEADING)
	    		.addComponent(userLabel)
	    		.addComponent(passwordLabel))
	        .addGroup(layout.createParallelGroup(LEADING)
	            .addComponent(userTextField)
	            .addComponent(passwordTextField)
	            .addComponent(cBox))
	        .addGroup(layout.createParallelGroup(LEADING)
	            .addComponent(loginButton)
	            .addComponent(cancelButton))
	    );
	   
	    layout.linkSize(SwingConstants.HORIZONTAL, loginButton, cancelButton);
	
	    layout.setVerticalGroup(layout.createSequentialGroup()
	        .addGroup(layout.createParallelGroup(BASELINE)
	            .addComponent(userLabel)
	            .addComponent(userTextField)
	            .addComponent(loginButton))
	        .addGroup(layout.createParallelGroup(BASELINE)
	        	.addComponent(passwordLabel)
	        	.addComponent(passwordTextField)
	            .addComponent(cancelButton))
	        .addComponent(cBox)
	    );
	
	    //sets a default closing operation to the frame, lays out the components again, packs them, and sets the frame so that it is visible to the user
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("mediConnect");
	    frame.validate();
	    frame.pack();
	    frame.setVisible(true);
	//    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();    //gets the source of the ActionEvent and assigns it to Object ob
	    
		if(ob==loginButton)    //source of action: loginButton
		{
	    	String userID = userTextField.getText();
	    	kID = userID;
	    	String password = passwordTextField.getText();

			try {
	    		//open connection and execute query with index selected by cBox
				Connection conn = database.getConnection();
				Statement stmt1 = conn.createStatement();
		    	
				if(cBox.getSelectedIndex()==0){
		    		//student selected
		    		System.out.println(userTextField.getText());
		    		String success = "SELECT COUNT(PATIENT.pname) AS yaycount FROM PATIENT" +
							 " WHERE PATIENT.pid = " + userID + " AND PATIENT.ppass = '" + password + "'";
					ResultSet rsK = stmt1.executeQuery(success);
					
					while (rsK.next()) {
					   int s = rsK.getInt("yaycount");
					   System.out.println(s);
					   if(s == 1){
						   pCreateGUI(userTextField.getText());
					    	//Patient patient = new Patient(this);
					   }
					}
		    	}else {
		    		//doctor selected

		    	}
				stmt1.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");
//		    while (rs.next()) {
//		        int x = rs.getInt("a");
//		        String s = rs.getString("b");
//		        float f = rs.getFloat("c");
//		    }
		
		}
		
	}
	
    private void pCreateGUI(String userID) {
    	
    	frame.setVisible(false);
    	frame = new JFrame("mediConnect [Patient]");
		frame.setLayout(new BorderLayout());

		//create panels
    	mainPanel = new JPanel();
    	JPanel gridPanel = new JPanel();
    	JPanel menuPanel = new JPanel();
    	JPanel innerPanel = new JPanel();

    	//create components
    	aButton = new JButton("View ItemA");
    	bButton = new JButton("View ItemB");
    	cButton = new JButton("View ItemC");
    	dButton = new JButton("View ItemD");
    	JLabel greetLabel = new JLabel();
    	TitledBorder border;    //titled border
    	JLabel aLabel = new JLabel("A: ");
    	JLabel bLabel = new JLabel("B: ");
    	JLabel cLabel = new JLabel("C: ");
    	JLabel dLabel = new JLabel("D: ");
    	 	
    	//add action listeners
    	aButton.addActionListener(this);
    	bButton.addActionListener(this);
    	cButton.addActionListener(this);
    	dButton.addActionListener(this);
    	
    	try {
			Connection conn = database.getConnection();
			Statement stmt1 = conn.createStatement();
	        String selected = "SELECT pname FROM PATIENT" +
								 " WHERE PATIENT.pid = " + userID;  
			ResultSet rsK = stmt1.executeQuery(selected);
			while (rsK.next()) {
				String b = rsK.getString("pname");// ("fname");
				System.out.println(b);
		    	String welcome = new String("Welcome " + b + "!");
		    	greetLabel = new JLabel(welcome);
		    }
			stmt1.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    	//layout
    	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    	gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.LINE_AXIS)); 
    	
    	gridPanel.add(greetLabel);

        GroupLayout layoutMenu = new GroupLayout(innerPanel);
    	innerPanel.setLayout(layoutMenu);
    	layoutMenu.setAutoCreateGaps(true);
        layoutMenu.setAutoCreateContainerGaps(true);

        layoutMenu.setHorizontalGroup(layoutMenu.createSequentialGroup()
        	.addGroup(layoutMenu.createParallelGroup(LEADING)
        		.addComponent(aLabel)
        		.addComponent(bLabel)
        		.addComponent(cLabel)
        		.addComponent(dLabel))
            .addGroup(layoutMenu.createParallelGroup(LEADING)
                .addComponent(aButton)
                .addComponent(bButton)
                .addComponent(cButton)
        		.addComponent(dButton))
        );
        layoutMenu.linkSize(SwingConstants.HORIZONTAL, aButton, bButton, cButton, dButton);

        layoutMenu.setVerticalGroup(layoutMenu.createSequentialGroup()
			.addGroup(layoutMenu.createParallelGroup(BASELINE)
		        .addComponent(aLabel)
		        .addComponent(aButton))
			.addGroup(layoutMenu.createParallelGroup(BASELINE)
	    		.addComponent(bLabel)
	    		.addComponent(bButton))
	    	.addGroup(layoutMenu.createParallelGroup(BASELINE)
	    		.addComponent(cLabel)
	    		.addComponent(cButton))
	    	.addGroup(layoutMenu.createParallelGroup(BASELINE)
	    		.addComponent(dLabel)
                .addComponent(dButton))
        );
        
    	//adding border to create a car panel
    	border = BorderFactory.createTitledBorder(" Available Tools ");
    	innerPanel.setBorder(border);

    	//adding panels to main panel
    	menuPanel.add(innerPanel,BorderLayout.CENTER);
    	mainPanel.add(gridPanel,BorderLayout.NORTH);
    	mainPanel.add(menuPanel,BorderLayout.SOUTH);
     	
    	//adding panels to frame
    	frame.add(mainPanel, BorderLayout.CENTER);
    	
    	//sets a default closing operation to the frame, lays out the components again, packs them, and sets the frame so that it is visible to the user
    	frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.validate();
        frame.pack();
        frame.setVisible(true);
	}
}
