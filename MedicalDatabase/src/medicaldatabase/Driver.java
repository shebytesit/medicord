package medicaldatabase;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Importdb database = new Importdb();
		GUI myGUI = new GUI(database);
		Importdb.createAccount("patient","kgalarny","aiaiai");
		Importdb.createAccount("patient","jason89s","troller");
		Importdb.createAccount("patient","pyro","indy");
		Importdb.createAccount("doctor","udon","noodles");
		Importdb.createAccount("doctor","darkhorse","feisley");
		Importdb.createAccount("doctor","blarghedy","creeper");
		
//		Importdb.setPatientProfile("p201", "kalena", "dob", "female", "allergies", "currentMedication", "history", "contact");
		
		
		//Importdb.setDoctorProfile("d203", "dasd", "hospital", "specialization", "gender");
		
		//Importdb.getUserInfo("d203");
		
		//Importdb.makeAppointment("1", "d3", "p1", "reason", "date");
		
	}

}
