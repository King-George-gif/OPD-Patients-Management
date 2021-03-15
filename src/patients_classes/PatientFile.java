package patients_classes;

import java.time.LocalDate;

public class PatientFile {
	private String vitalsSection;
	private String diagnosisSection;
	private String prescriptionSection;
	private String labOrdedSection;
	private String labReportSection;
	private int folder_id;
	private LocalDate dateCreated;
	
	PatientFile(int folder_id){
		this.dateCreated = LocalDate.now();
		this.folder_id = folder_id;
	}
	
	public void writeToVitalsSection(String notes) {
		this.vitalsSection = notes;
	}
	public String viewVitalsSection() {
		return this.vitalsSection;
	}
	public void writeToDiagnosisSection(String notes) {
		this.diagnosisSection = notes;
	}
	public String vewDiagnosisSection() {
		return this.diagnosisSection;
	}
	public void orderLabs(String labs) {
		this.labOrdedSection = labs;
	}
	public String viewLabsOrdered() {
		return this.labOrdedSection;
	}
	public void addToPrescriptionSection(String notes) {
		this.prescriptionSection = notes;
	}
	public String viewPrescriptionSection() {
		return this.prescriptionSection;
	}
	public void writeToLabReportSection(String notes) {
		this.labReportSection = notes;
	}
	public String viewLabReportsSection() {
		return this.labReportSection;
	}
	public LocalDate getDateFileWasCreated() {
		return this.dateCreated;
	}
	public int getFolderId() {
		return this.folder_id;
	}

}
