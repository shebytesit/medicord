package GUI;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		importdb database = new importdb();
		GUI myGUI = new GUI(database);
		database.createPatient(201,"kgalarny","aiaiai");
		database.createPatient(202,"jason89s","troller");
		database.createPatient(203,"pyro","indy");
		database.createPatient(204,"udon","noodles");
		database.createPatient(205,"darkhorse","feisley");
		database.createPatient(206,"blarghedy","creeper");
	}

}
