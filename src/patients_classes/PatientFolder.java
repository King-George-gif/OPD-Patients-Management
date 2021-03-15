package patients_classes;

public class PatientFolder {
	private int folder_id;
	private int patient_id;
	
	PatientFolder(int folder_id, int patient_id){
		this.folder_id = folder_id;
		this.patient_id = patient_id;
	}
	
	public int getPatientId() {
		return this.patient_id;
	}
	public int getFolderId() {
		return this.folder_id;
	}

}
