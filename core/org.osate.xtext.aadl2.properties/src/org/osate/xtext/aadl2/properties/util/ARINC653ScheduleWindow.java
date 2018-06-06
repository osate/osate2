package org.osate.xtext.aadl2.properties.util;

import org.osate.aadl2.instance.ComponentInstance;

public class ARINC653ScheduleWindow {
	private ComponentInstance partition;
	private double windowTime;
	private boolean processingStart;

	public ARINC653ScheduleWindow(ComponentInstance part, double t, boolean p) {
		this.partition = part;
		windowTime = t;
		processingStart = p;
	}

	public boolean getProcessingStart() {
		return this.processingStart;
	}

	public double getTime() {
		return this.windowTime;
	}

	public ComponentInstance getPartition() {
		return this.partition;
	}

	public void setPartition(ComponentInstance part) {
		this.partition = part;
	}

	public void setProcessingStart(boolean ps) {
		this.processingStart = ps;
	}

	public void setWindowTime(double t) {
		this.windowTime = t;
	}
}
