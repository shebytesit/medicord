/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medicaldatabase;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Importdb database = new Importdb();
		//GUI myGUI = new GUI(database);
		database.createAccount("patient","kgalarny","aiaiai","p201");
		database.createAccount("patient","jason89s","troller","p202");
		database.createAccount("patient","pyro","indy", "p203");
		database.createAccount("doctor","udon","noodles", "d201");
		database.createAccount("doctor","darkhorse","feisley", "d203");
		database.createAccount("doctor","blarghedy","creeper", "d204");
		database.setPatientProfile("p201", "kalena", "dob", "female", "allergies", "currentMedication", "history", "contact");
		database.setDoctorProfile("d203", "dasd", "hospital", "specialization", "gender");
		//importdb.getUserInfo("d203");
		database.makeAppointment("1", "d203", "p201", "reason", "date");
		
	}

}
