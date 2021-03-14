package staff_classes;

public class Staff {
	private String firstname;
	private String lastname;
	private int id;
	private boolean availabity = false;
	
	Staff( String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	public String getLastName() {
		return this.lastname;
	}

	public void changeAvailabity() {
		this.availabity = !this.availabity;
	}
	public boolean getAvailability() {
		return this.availabity;
	}
	public int getId() {
		return this.id;
	}

}
