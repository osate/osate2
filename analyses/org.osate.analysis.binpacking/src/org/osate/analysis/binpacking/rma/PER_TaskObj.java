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
package org.osate.analysis.binpacking.rma;

/**
 * Task object for RMA analysis.  Originally from package
 * <code>rapt.QAplugins.performance</code> in the ArchE
 * project. 
 * 
 * @author cshelton
 */
public class PER_TaskObj {
	private int taskID = -1;

	private int taskPriority = -1;

	private double executionTime = -1;

	private double taskPeriod = -1;

	private double taskDeadline = -1;

	private double blockingTime = -1;

	public PER_TaskObj(int id) {
		taskID = id;
		executionTime = 0;
		blockingTime = 0;
	}

	public PER_TaskObj(int id, int priority, double exec_time, double period, double deadline, double blocking_time) {
		taskID = id;
		taskPriority = priority;
		executionTime = exec_time;
		taskPeriod = period;
		taskDeadline = deadline;
		blockingTime = blocking_time;
	}

	public int getID() {
		return taskID;
	}

	public int getPriority() {
		return taskPriority;
	}

	public double getExecutionTime() {
		return executionTime;
	}

	public double getPeriod() {
		return taskPeriod;
	}

	public double getUtilization() {
		return executionTime / taskPeriod;
	}

	public double getDeadline() {
		return taskDeadline;
	}

	public double getBlockingTime() {
		return blockingTime;
	}

	public void setPriority(int priorityValue) {
		taskPriority = priorityValue;
	}

	public void setExecutionTime(double execTimeValue) {
		executionTime = execTimeValue;
	}

	public void setPeriod(double periodValue) {
		taskPeriod = periodValue;
	}

	public void setDeadline(double deadlineValue) {
		taskDeadline = deadlineValue;
	}

	public void setBlockingTime(double blockingValue) {
		blockingTime = blockingValue;
	}

	public String toString() {
		return new String("Task: ID = " + taskID + " Priority = " + taskPriority + " Execution Time = " + executionTime
				+ " Period = " + taskPeriod + " Deadline = " + taskDeadline);
	}
}