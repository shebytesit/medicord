package medicaldatabase;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Importdb {
        private static Connection con;
	Importdb() {
		
	}
        public static void clearDb(){
            try {
                Connection conn = getConnection();
                Statement stat = conn.createStatement();

                // If there is an error that no tables exist, comment the following
                // 6 lines out.
                String drop = " Drop table PATIENT cascade constraints";
                String drop1 = "Drop table DOCTOR cascade constraints";
                String drop2 = "Drop table ACCOUNT cascade constraints";
                String drop3 = "Drop table APPOINTMENT cascade constraints";
                stat.execute(drop);
                stat.execute(drop1);
                stat.execute(drop2);
                stat.execute(drop3);  
                String createAccount = "CREATE TABLE ACCOUNT (username VARCHAR(100), password VARCHAR(100) not null, id varchar2(20),primary key(username), unique(id))";
                String createPatient = "create table PATIENT (pid varchar2(20), name varchar2(20), dob varchar2(20), gender VARCHAR(100), allergies VARCHAR(100), medication VARCHAR(100), history VARCHAR(100), econtact VARCHAR(100), primary key (pid))";
                String createDoctor = "create table DOCTOR (did varchar2(20), name varchar2(20),gender varchar2(20),hospital varchar2(20),specialization varchar2(20), dPhone varchar2(20), primary key (did) )";
                String createAppointment = "CREATE TABLE APPOINTMENT (aid varchar2(20), dates varchar2(20), did varchar2(20), pid varchar2(20),reason VARCHAR(100),notes VARCHAR(100), primary key (aid))";

                System.out.println(createAppointment);
                stat.execute(createAccount);
                stat.execute(createPatient);
                stat.execute(createDoctor);
                stat.execute(createAppointment);

                System.out.println("Tables created!");

                stat.close();
                
        } catch (SQLException ex) {
                while (ex != null) {
                        ex.printStackTrace();
                        ex = ex.getNextException();
                }
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }

	public static Connection getConnection() throws SQLException, IOException {
                if(con==null){
                    Properties props = new Properties();
                    FileInputStream in = new FileInputStream("jdbc.properties");
                    props.load(in);
                    in.close();

                    String drivers = props.getProperty("connection.driver_class");
                    if (drivers != null)
                            System.setProperty("jdbc.drivers", drivers);
                    String url = "jdbc:oracle:thin:@claros.cs.purdue.edu:1524:strep";
                    String username = "cs408t1";
                    String password = "r4adf4sdff";
                    Connection conn = DriverManager.getConnection(url, username, password);
                    con=conn;
                }
		return con;

	}

	public static String signindb(String username, String password) {
		String id = null;
		try {
			Connection conn = getConnection();
			String search;

			search = "Select * from account where username=? and password =? ";
                        PreparedStatement stat = conn.prepareStatement(search);
                        stat.setString(1, username);
                        stat.setString(2, password);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
				return id;
			}

			stat.close();
			

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public static String createAccount(String type, String name, String password) {
		String id = null;
		try {
			// open connection
			Connection conn = getConnection();
			Statement stmtST = conn.createStatement();
		
			String patientTest = null;
			
			ResultSet rs = stmtST.executeQuery("select count(*) from ACCOUNT"); 
                          
			while (rs.next()) {
				id = Integer.toString(rs.getInt(1));
			}

                        if (type.equals("patient")) {
				id = "p" + id;
                        }
                       if (type.equals("doctor")) {
				id = "d" + id;
                                
			}
                       String query = "select * from account where username =?";
                       PreparedStatement stat = conn.prepareStatement(query);
                       stat.setString(1, name);
                       ResultSet checkUser = stat.executeQuery();
                       if(checkUser.next())
                        {
                            System.out.println("ID IS ??????" + checkUser.getString("id"));
                            if(checkUser.getString("id") != null)
                            return null;
                        }      
                       
                        patientTest = "INSERT INTO  ACCOUNT"
					+ "(id,username,password)" + " VALUES( ?,?,?)";
                        stat.close();
                        stat = conn.prepareStatement(patientTest);
			stat.setString(1,id);
                        stat.setString(2,name);
                        stat.setString(3,password);
                        stat.executeUpdate();
			System.out.println(patientTest); 

                        
			if (type.equals("patient")) {
				patientTest = "INSERT INTO  PATIENT" + "(pid)" + " VALUES(?)";
                        System.out.println(patientTest);

			}
			if (type.equals("doctor")) {
				patientTest = "INSERT INTO  DOCTOR" + "(did)"
				+ " VALUES(?)";
                                
			System.out.println(patientTest);

			}
                        stat = conn.prepareStatement(patientTest);
                        stat.setString(1, id);
			stat.executeUpdate();
			stat.close();
                        stmtST.close();
                        
			
			return id;
			
			//stmtST.close();
			//
		} catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	public static void setPatientProfile(String pid, String name, String dob,
			String gender, String allergies, String currentMedication,
			String history, String econtact) {

		try {
			Connection conn = getConnection();
			
			String profile;

			profile = "update PATIENT set name = ? , dob = ? , gender = ? , allergies = ? , medication = ? , history = ?, econtact = ? where pid = ?";
                        PreparedStatement stat = conn.prepareStatement(profile);
                        stat.setString(1, name);
                        stat.setString(2, dob);
                        stat.setString(3, gender);
                        stat.setString(4, allergies);
                        stat.setString(5, currentMedication);
                        stat.setString(6, history);
                        stat.setString(7, econtact);
                        stat.setString(8, pid);
                        
			System.out.println(profile);
			stat.executeUpdate();

			stat.close();
			

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void setDoctorProfile(String did, String name, String hospital,
			String specialization, String gender, String phone_number) {

		try {
			Connection conn = getConnection();
			String profile;

			profile = "update doctor set name = ? , hospital = ? , gender = ? ,"+
                                " specialization = ? , dPhone = ? where did = ?";
                        PreparedStatement stat = conn.prepareStatement(profile);
                        stat.setString(1, name);
                        stat.setString(2, hospital);
                        stat.setString(3, gender);
                        stat.setString(4, specialization);
                        stat.setString(5, phone_number);
                        stat.setString(6, did);
			System.out.println(profile);
			stat.executeUpdate();

			stat.close();
			

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void makeAppointment( String did, String pid, String reason,
			String date) {
		String aid = null;
		try {
			Connection conn = getConnection();
			PreparedStatement stat = conn.prepareStatement("select count(*) from APPOINTMENT");
 
			ResultSet rs = stat.executeQuery(); 
	

			while (rs.next()) {
				aid = Integer.toString(rs.getInt(1));
			}
			
                        aid = Long.toString(UUID.randomUUID().getMostSignificantBits());
			String apt;
                        
			apt = "INSERT INTO  APPOINTMENT(aid, did, pid, dates, reason)  VALUES( ?,? ,?, ?,?)";
                           
			System.out.println(apt);
			stat = conn.prepareStatement(apt);
                        stat.setString(1, aid);
                        stat.setString(2, did);
                        stat.setString(3, pid);
                        stat.setString(4, date);
                        stat.setString(5, reason);
			System.out.println(apt);
			stat.executeUpdate();
			stat.close();
		
		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// returns results set for doctor or patient given id
	public static ResultSet getUserInfo(String id) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			
			String search = null;
			System.out.println("pid is " + id);

			if (id.substring(0, 1).equals("p")) {
				search = "select * from PATIENT where pid = ?";

			}
			if (id.substring(0, 1).equals("d")) {
				search = "select * from DOCTOR where did = ?";
			}
                        PreparedStatement stat = conn.prepareStatement(search);
                        stat.setString(1, id);
			System.out.println(search);
			rs = stat.executeQuery();
                        
			return rs;

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
 
	public static ResultSet viewAppointments(String id) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String search = null;

			if(id.substring(0,1).equals("p"))
			search = "select * from appointment where pid = '" + id + "'";

			if(id.substring(0,1).equals("d"))
			search = "select * from appointment where did = '" + id + "'";
			
			rs = stat.executeQuery(search);

			return rs;

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
        
         //for appoint
	public static ResultSet getListofDoctorNames(String id) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String search = null;

			if(id.substring(0,1).equals("p"))
			search = "select * from doctor"; 
                        
			rs = stat.executeQuery(search);

			return rs;

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
        
                 
	public static String getName(String id) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			
			String search = null;

			if(id.substring(0,1).equals("d"))
			search = "select name from doctor where did =?";

			if(id.substring(0,1).equals("p"))
			search = "select name from patient where pid =?";
                        PreparedStatement stat = conn.prepareStatement(search);
                        stat.setString(1, id);
			rs = stat.executeQuery();
                        
                        while(rs.next())
                        {
                            String ret = rs.getString(1);
                            stat.close();
                            return ret;
                        }
            	} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
        
        //For appointment info
        public static ResultSet viewAppointment(String id) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			
			String search = null;

			search = "select * from appointment where aid = ?";
			PreparedStatement stat = conn.prepareStatement(search);
                        stat.setString(1, id);
			rs = stat.executeQuery();

			return rs;

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
        
        public static void saveNotes(String id, String notes) {
		try {
			Connection conn = getConnection();
			
			String update = null;

			update = "update appointment set notes = ? where aid = ?";
			PreparedStatement stat = conn.prepareStatement(update);
                        stat.setString(1, notes);
                        stat.setString(2,id);
			stat.executeUpdate();
                        stat.close();

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        }
        
                public static void deleteAppointment(String id) {
		try {
			Connection conn = getConnection();
			
			String update = null;

			update = "delete from appointment where aid = ?";
			PreparedStatement stat = conn.prepareStatement(update);
                        stat.setString(1,id);
			stat.executeUpdate();
                        stat.close();

		} catch (SQLException ex) {
			while (ex != null) {
				ex.printStackTrace();
				ex = ex.getNextException();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        }

}
