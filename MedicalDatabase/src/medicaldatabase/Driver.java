package GUI;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		importdb database = new importdb();
		GUI myGUI = new GUI(database);
		importdb.createAccount("patient","kgalarny","aiaiai");
		importdb.createAccount("patient","jason89s","troller");
		importdb.createAccount("patient","pyro","indy");
		importdb.createAccount("doctor","udon","noodles");
		importdb.createAccount("doctor","darkhorse","feisley");
		importdb.createAccount("doctor","blarghedy","creeper");
		
//		importdb.setPatientProfile("p201", "kalena", "dob", "female", "allergies", "currentMedication", "history", "contact");
		
		
		//importdb.setDoctorProfile("d203", "dasd", "hospital", "specialization", "gender");
		
		//importdb.getUserInfo("d203");
		
		//importdb.makeAppointment("1", "d3", "p1", "reason", "date");
		
	}

}
