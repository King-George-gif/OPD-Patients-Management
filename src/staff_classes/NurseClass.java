package staff_classes;

import java.util.LinkedList;
import java.util.Queue;

public class NurseClass extends Staff{
	public Queue<String> patientsQueue;
	public NurseClass(String firstname, String lastname){
		super(firstname, lastname);
		this.patientsQueue = new LinkedList<String>();
	}
	
	public void addVitalToPatientFile() {
		
	}
	
	public void EditPatientVitalFile() {
		
	}
	
	public void AssignPatientsToDoctor() {
		
	}
	
	public void deQueuePatientQueue()
	{
		if(!this.patientsQueue.isEmpty()) {
			this.patientsQueue.remove();
		}
	}
}
