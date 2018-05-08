package org.osate.analysis.scheduling;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 */
public class RuntimeProcess {

	// data fields
	private int period;
	private int deadline;
	private int executionTime;
	private int phaseOffset;
	private int priority;
	private String processor;

	// the name of the process since it is represented as a component.
	private String componentName;

	// associated ARC component name;
	private String ARCName;

	private boolean schedulableOrNot;

	// the numbering started from zero to distinguish different ARCs and
	// normal components. for one normal components, one component name
	// have an ARCID; for the variants inside the idential ARC, they share
	// the same ARCID;
	private int ARCID;

	private double maxResponseTime;
	private double sensitivity;
	private double phaseOffsetUpdate;
	private int coordinate;

	private Object associatedComponent;

	public RuntimeProcess() {
		// for all the attributes, only the ARC name can be null.
		ARCName = null;
		ARCID = -1;
		associatedComponent = null;
	}

	// this is particular to accomodate the process parameters collected from the file reading
	public RuntimeProcess(int pperiod, int pdeadline, int pexectime, int pphaseoffset, int ppriority, int arcid) {
		ARCName = null;
		ARCID = -1;
		period = pperiod;
		deadline = pdeadline;
		executionTime = pexectime;
		phaseOffset = pphaseoffset;
		priority = ppriority;
		ARCID = arcid;
		associatedComponent = null;
	}

	public void setPeriod(int p) {
		period = p;
	}

	public int getPeriod() {
		return period;
	};

	public void setDeadline(int d) {
		deadline = d;
	};

	public int getDeadline() {
		return deadline;
	}

	public void setExecutionTime(int e) {
		executionTime = e;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setPhaseOffset(int p) {
		phaseOffset = p;
	}

	public int getPhaseOffset() {
		return phaseOffset;
	}

	public void setPriority(int p) {
		priority = p;
	}

	public int getPriority() {
		return priority;
	}

	public void setSchedulability(boolean schedulable) {
		schedulableOrNot = schedulable;
	}

	public boolean getSchedulability() {
		return schedulableOrNot;
	}

	public void setProcessorName(String proc) {
		processor = proc;
	}

	public void setComponentName(String name) {
		componentName = name;
	}

	public void setARCName(String id) {
		ARCName = id;
	}

	public String getProcessorName() {
		return processor;
	}

	public String getComponentName() {
		return componentName;
	}

	public String getARCName() {
		return ARCName;
	}

	public void setARCID(int id) {
		ARCID = id;
	}

	public int getARCID() {
		return ARCID;
	}

	public void setMaxResponseTime(double time) {
		maxResponseTime = time;
	}

	public double getMaxResponseTime() {
		return maxResponseTime;
	}

	public void setSensitivity(double time) {
		sensitivity = time;
	}

	public double getSensitivity() {
		return sensitivity;
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

	public void setAssociatedComponent(Object c) {
		associatedComponent = c;
	}

	public Object getAssociatedComponent() {
		return associatedComponent;
	}

}
