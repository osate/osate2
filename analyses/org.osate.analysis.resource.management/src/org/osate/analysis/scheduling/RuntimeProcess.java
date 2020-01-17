/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
