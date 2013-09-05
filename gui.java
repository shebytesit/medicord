import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
public class gui{

public void guiInit(){
	JLabel usr, pass;
	JRadioButton patR, docR;
	ButtonGroup group;
	JButton enter;
	enter=new JButton("Enter");
	JTextField username,password;
	username=new JTextField();
	password=new JTextField();
	usr = new JLabel("Enter a username");
    pass = new JLabel("Enter a password");
	patR=new JRadioButton("Patient");
	docR=new JRadioButton("Doctor");
	group=new ButtonGroup();
	group.add(docR);
	group.add(patR);
	JFrame createAcc;
	createAcc=new JFrame("Create Account");
	JPanel pan;
	pan = new JPanel();
	createAcc.setSize(450, 450);
	pan.setLayout(new GridLayout(4,2,5,5));
	pan.add(usr);
	pan.add(username);
	pan.add(pass);
	pan.add(password);
	pan.add(patR);
	pan.add(docR);
	pan.add(enter);
    createAcc.setBackground(Color.WHITE);
	createAcc.add(pan);
	createAcc.setVisible(true);
	
}

public void login(){
	JLabel usr, pass;
    JButton enter;
	enter=new JButton("Enter");
	JTextField username,password;
	username=new JTextField();
	password=new JTextField();
	usr = new JLabel("Username");
    pass = new JLabel("Password");
	JFrame logIn;
	logIn=new JFrame("Log in");
	JPanel pan;
	pan = new JPanel();
	logIn.setSize(450, 450);
	pan.setLayout(new GridLayout(4,2,5,5));
	
	pan.add(usr);
	pan.add(username);
	pan.add(pass);
	pan.add(password);
	pan.add(enter);
	logIn.setBackground(Color.WHITE);
	logIn.add(pan);
	logIn.setVisible(true);
}


public static void main(String[] args){
	System.out.println("Hello World!");
	gui g = new gui();
	g.guiInit();
	g.login();
}

}
