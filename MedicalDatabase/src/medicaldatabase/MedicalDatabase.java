/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package medicaldatabase;
import java.sql.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Seth
 */
public class MedicalDatabase {

   public static void main(String args[])
	{ 
            createdb();
            //login frame=new login();
            //frame.setSize(300,100);
            //frame.setVisible(true);
             //System.exit(0);
                    
	}
	
	private static void createdb()
	{
            try
            {
                Connection conn=getConnection();
                Statement stat= conn.createStatement();
                String[] add = new String[100];

                // If there is an error that no tables exist, comment the following 6 lines out. 
                //String drop = " Drop table PATIENT cascade constraints";
                //String drop1 = "Drop table DOCTOR cascade constraints";
                //String drop2 = "Drop table ACCOUNT cascade constraints";

             //   stat.execute(drop); 
                //stat.execute(drop1); 
               // stat.execute(drop2); 

                //String createPatient="create table PATIENT (id integer, name varchar2(20), primary key (id))";  //add more fields
               // String createDoctor="create table DOCTOR (id integer, name varchar2(20), primary key (id))"; 
               // String createAccount="CREATE TABLE ACCOUNT (type VARCHAR(100), username VARCHAR(100), password VARCHAR(100), id integer, primary key (username))";

               // stat.execute(createPatient);
               // stat.execute(createDoctor);
               // stat.execute(createAccount);

               // System.out.println("Tables created!");

                stat.close();	
                conn.close();
            }
            catch(SQLException ex)
            {
                while(ex!=null)
                {
                    ex.printStackTrace();
                    ex=ex.getNextException();
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
            Properties props =new Properties();
            FileInputStream in= new FileInputStream("jdbc.properties");
            props.load(in);
            in.close();

            String drivers=props.getProperty("connection.driver_class");
            if(drivers!=null) System.setProperty("jdbc.drivers",drivers);
            String url="jdbc:oracle:thin:@claros.cs.purdue.edu:1524:strep";
            String username="cs408t1";
            String password="r4adf4sdff";
            Connection conn = DriverManager.getConnection(url, username,password);
            return conn;
			
	}
	
	public static int signindb(String st, String username, String password)
	{
            int id = 0;
            try
            {
                Connection conn=getConnection();
                Statement stat= conn.createStatement();
                String search;  

                search="Select * from login where username= '" + username + "' and password = '"+ password + "' and type = '" + st + "'";

                ResultSet rs = stat.executeQuery(search);

                   /**while ( rs.next() ) {
                String statu = rs.getString("status"); 
                id = rs.getInt("id");
                                if (statu.equals("Doctor")){
                                return id;
                        }
                        if (statu.equals("Patient")){
                        return id;
                        }    
            }**/

                stat.close();	
                conn.close(); 

            }
            catch(SQLException ex)
            {
                while(ex!=null)
                {
                    ex.printStackTrace();
                    ex=ex.getNextException();
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
            return id;
	}
}

