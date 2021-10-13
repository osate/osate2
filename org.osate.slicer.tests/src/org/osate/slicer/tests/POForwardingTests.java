package org.osate.slicer.tests;

import org.junit.Before;
import org.junit.Test;
import org.osate.slicer.SlicerRepresentation;

public class POForwardingTests {

	SlicerRepresentation tlg;

	final String doctorDocGiveAdvice = "doctor.DocGiveAdvice";
	final String clinicianClinGetAdvice = "clinician.ClinGetAdvice";
	final String clinicianClinViewSpO2 = "clinician.ClinViewSpO2";
	final String clinicianClinTreatment = "clinician.ClinTreatment";
	final String patientPatientTreatment = "patient.PatientTreatment";
	final String patientPatientFingerclip = "patient.PatientFingerclip";
	final String pulseOxPOInSpO2 = "pulseOx.POInSpO2";
	final String pulseOxPOOutSpO2 = "pulseOx.POOutSpO2";
	final String pulseOxSensorInput = "pulseOx.SensorInput";
	final String appLogicLogicSpO2 = "appLogic.LogicSpO2";
	final String appLogicLogicDerivedAlarm = "appLogic.LogicDerivedAlarm";
	final String electronicHealthRecordehrSpO2 = "electronicHealthRecord.ehrSpO2";
	final String appDisplayDispDerivedAlarm = "appDisplay.DispDerivedAlarm";
	final String appDisplayDispSpO2 = "appDisplay.DispSpO2";
	final String appDisplayDispShowSpO2 = "appDisplay.DispShowSpO2";

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation("PulseOx_Forwarding_System_imp_Instance");

		// Build vertices
		tlg.addVertex(doctorDocGiveAdvice);
		tlg.addVertex(clinicianClinGetAdvice);
		tlg.addVertex(clinicianClinViewSpO2);
		tlg.addVertex(clinicianClinTreatment);
		tlg.addVertex(patientPatientTreatment);
		tlg.addVertex(patientPatientFingerclip);
		tlg.addVertex(pulseOxPOOutSpO2);
		tlg.addVertex(pulseOxSensorInput);
		tlg.addVertex(appLogicLogicSpO2);
		tlg.addVertex(appLogicLogicDerivedAlarm);
		tlg.addVertex(electronicHealthRecordehrSpO2);
		tlg.addVertex(appDisplayDispDerivedAlarm);
		tlg.addVertex(appDisplayDispSpO2);
		tlg.addVertex(appDisplayDispShowSpO2);

		// Add intercomponent edges
		tlg.addEdge(doctorDocGiveAdvice, clinicianClinGetAdvice);
		tlg.addEdge(clinicianClinTreatment, patientPatientTreatment);
		tlg.addEdge(patientPatientFingerclip, pulseOxSensorInput);
		tlg.addEdge(pulseOxPOOutSpO2, appLogicLogicSpO2);
		tlg.addEdge(pulseOxPOOutSpO2, appDisplayDispSpO2);
		tlg.addEdge(pulseOxPOOutSpO2, electronicHealthRecordehrSpO2);
		tlg.addEdge(appLogicLogicDerivedAlarm, appDisplayDispDerivedAlarm);
		tlg.addEdge(appDisplayDispSpO2, clinicianClinViewSpO2);

		// Add intracomponent edges
		tlg.addEdge(clinicianClinGetAdvice, clinicianClinTreatment);
		tlg.addEdge(clinicianClinViewSpO2, clinicianClinTreatment);
		tlg.addEdge(patientPatientTreatment, patientPatientFingerclip);
		tlg.addEdge(pulseOxSensorInput, pulseOxPOOutSpO2);
		tlg.addEdge(appLogicLogicSpO2, appLogicLogicDerivedAlarm);
		tlg.addEdge(appDisplayDispDerivedAlarm, appDisplayDispSpO2);
		tlg.addEdge(appDisplayDispSpO2, appDisplayDispSpO2);
	}

	@Test
	public void printGraph() {
		System.out.println(tlg.toString());
	}

	@Test
	public void forwardReachability() {
		System.out.println(tlg.forwardReachability(appLogicLogicDerivedAlarm));
	}

	@Test
	public void backwardReachability() {
		System.out.println(tlg.backwardReachability(electronicHealthRecordehrSpO2));
	}
}
