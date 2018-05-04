package org.osate.analysis.scheduling;

import java.util.Vector;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 */
public class ARC {
	// data fields
	private int ARCID;
	private Vector processList;
	private int coordinate;

	// trivial constructor
	public ARC() {
	}

	public ARC(int id) {
		ARCID = id;
		processList = new Vector();
	}

	public void setARCID(int id) {
		ARCID = id;
	}

	public int getARCID() {
		return ARCID;
	}

	public Vector getProcessList() {
		return processList;
	}

	public int getNumberOfProcesses() {
		return processList.size();
	}

	public void setCoordinate(int position) {
		coordinate = position;
	}

	public int getCoordinate() {
		return coordinate;
	}

}
