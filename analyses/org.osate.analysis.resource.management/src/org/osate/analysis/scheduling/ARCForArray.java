package org.osate.analysis.scheduling;

//import acmeLib.*;
//import acmeLib.core.container.*;

import java.util.Vector;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 */
public class ARCForArray {
	// data fields
	private int numberOfProcesses;
	private double phaseOffsetUpdate;
	private Vector processIncluded;
	private int coordinate;

	// trivial constructor
	public ARCForArray() {
	}

	public ARCForArray(int number) {
		numberOfProcesses = 0;
		processIncluded = new Vector(number);

	}

	public RuntimeProcess getProcess(int index) {
		return ((RuntimeProcess) processIncluded.elementAt(index));
	}

	// to make some sufficated, you have to throw some exception!
	public void addProcess(int index, RuntimeProcess newComing) {
		numberOfProcesses++;
		processIncluded.insertElementAt(newComing, index);
	}

	public void setProcess(int index, RuntimeProcess newComing) {
		processIncluded.setElementAt(newComing, index);
	}

	public int getNumberOfProcesses() {
		return numberOfProcesses;
	}

	public void setPhaseOffsetUpdate(double phase) {
		phaseOffsetUpdate = phase;
	}

	public double getPhaseOffsetUpdate() {
		return phaseOffsetUpdate;
	}

	public void setCoordinate(int position) {
		coordinate = position;
	}

	public int getCoordinate() {
		return coordinate;
	}

}
