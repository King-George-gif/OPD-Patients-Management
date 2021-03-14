package patients_classes;

public class Patient {
	private int patient_id;
	private String firstname;
	private String lastname;
	private String place_of_residence;
	private java.sql.Date date_of_birth;
	private String sex;
	private String phone_number;
	private String emergency_contact;
	private String relation_with_emergency_contact;
	private String emergency_contact_name;
	
	Patient(String firstname, String lastname, String place_of_residence, java.sql.Date date_of_birth, String sex, 
			String phone_number, String emergency_contact, String relation_with_emergency_contact,
			String emergency_contact_name){
		this.firstname = firstname;
		this.lastname = lastname;
		this.place_of_residence = place_of_residence;
		this.date_of_birth = date_of_birth;
		this.sex = sex;
		this.phone_number = phone_number;
		this.emergency_contact = emergency_contact;
		this.relation_with_emergency_contact = relation_with_emergency_contact;
		this.emergency_contact_name = emergency_contact_name;
	}
	
	public int getPatientId() {
		return this.patient_id;
	}
	public String getPatientFirstName() {
		return this.firstname;
	}
	public void setPatientFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPatientLastName() {
		return this.lastname;
	}
	
	public void setPatientLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getPlaceOfResidence() {
		return this.place_of_residence;
	}
	public void setPlaceOfResidence(String place_of_residence) {
		this.place_of_residence = place_of_residence;
	}
	public java.sql.Date getDateOfBirth(){
		return this.date_of_birth;
	}
	public void setDateOfBirth(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return this.phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmergencyContact() {
		return this.emergency_contact;
	}
	public void setEmergencyContact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	public String getEmergencyContactRelationship() {
		return this.relation_with_emergency_contact;
	}
	public void setEmergencyContactRelationship(String relation_with_emergency_contact) {
		this.relation_with_emergency_contact = relation_with_emergency_contact;
	}
	public String getEmergencyContactName() {
		return this.emergency_contact_name;
	}
	public void setEmergencyContactName(String emergency_contact_name) {
		this.emergency_contact_name = emergency_contact_name;
	}

}
