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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

/**
 * Perform RMA.  Based on code from package
 * <code>rapt.QAplugins.performance</code> in the ArchE
 * project. 
 * 
 * @author cshelton
 * @author aarong
 */
public class RMA {
	/** Default EPSILON value for scheduling fixed-point */
	public static final double DEFAULT_EPSILON = 0.0000000000001;

	Vector taskList = null; // List of task objects
	Vector subTaskList = null; // List of subtask facts
	Hashtable taskFactList = null;
	Hashtable latencyList = null; // Calculated latencies for each task
	Hashtable spareCapacityList = null; // Calculated spare capacities for each task

	/** The tasks to be scheduled, sorted by priority. */
	private PER_TaskObj[] tasks;

	/**
	 * The completion times for the processes. Indexes correspond to the
	 * processes in {@link #tasks}.  Unschedulable tasks have a completion
	 * time of {@link Double#POSITIVE_INFINITY}.
	 */
	private double[] completionTime;

	/**
	 * The total utilization of the schedule. Value is undefined if the tasks
	 * are not schedulable.
	 */
	private double totalUtilization = 0.0;

	/**
	 * Create a new analysis instance.
	 * 
	 * @param taskSet
	 *            The set of {@link PER_TaskObj}instances to schedule.
	 */
	public RMA(final Set taskSet) {
		// Init the tasks
		tasks = new PER_TaskObj[taskSet.size()];
		taskSet.toArray(tasks);
		Arrays.sort(tasks, new PER_TaskComparatorByPriority());

		// Init the completion times
		completionTime = new double[tasks.length];
		for (int i = 0; i < tasks.length; i++) {
			completionTime[i] = Double.POSITIVE_INFINITY;
		}
	}

	/**
	 * Create a new analysis instance
	 * 
	 * @param taskArray
	 *            the set of {@link PER_TaskObj} instances to schedule, sorted
	 *            by priority.
	 */
	public RMA(final PER_TaskObj[] taskArray) {
		// Init the tasks
		tasks = new PER_TaskObj[taskArray.length];
		System.arraycopy(taskArray, 0, tasks, 0, taskArray.length);

		// Init the completion times
		completionTime = new double[tasks.length];
		for (int i = 0; i < tasks.length; i++) {
			completionTime[i] = Double.POSITIVE_INFINITY;
		}
	}

	/**
	 * Get the total utilization of the tasks.  This value is 
	 * undefined if the tasks aren't scheduable.
	 */
	public double getUtilization() {
		return totalUtilization;
	}

	/**
	 * Get the completion time of a task.  If the task isn't scheduable
	 * then the value is {@link Double#POSITIVE_INFINITY}.
	 * @exception IllegalArgumentException Thrown if the given task isn't
	 * part of the task set.
	 */
	public double getCompletionTime(final PER_TaskObj task) {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == task) {
				return completionTime[i];
			}
		}
		throw new IllegalArgumentException("Task not part of task set");
	}

	public boolean solve() {
		return solve(DEFAULT_EPSILON);
	}

	public boolean solve(final double epsilon) {
		// try to add each task one-by-one
		boolean schedulable = true;
		for (int taskToSchedule = 0; taskToSchedule < tasks.length && schedulable; taskToSchedule++) {
			totalUtilization += tasks[taskToSchedule].getUtilization();
			if (totalUtilization <= 1.0) {
				final double latency = calculateLatency(tasks, taskToSchedule, epsilon, -1);
				if (latency <= tasks[taskToSchedule].getDeadline()) {
					completionTime[taskToSchedule] = latency;
				} else {
					schedulable = false;
				}
			} else {
				schedulable = false;
			}
		}
		return schedulable;
	}

	private double calculateLatency(final PER_TaskObj[] taskArray, final int taskIndex, final double epsilon,
			final double initialApprox) {
		double Lnext = 0, Lcurrent = 0, Ci, Ti;
		double Ecurrent = 0, Emax = 0;
		double taskBlockingTime, taskExecTime, taskPeriod, taskDeadline, startVal;
		int k = 0;
		List<Double> responseTimes = new ArrayList<Double>();
		boolean pastDeadline = false;

		taskBlockingTime = taskArray[taskIndex].getBlockingTime();
		taskExecTime = taskArray[taskIndex].getExecutionTime();
		taskPeriod = taskArray[taskIndex].getPeriod();
		taskDeadline = taskArray[taskIndex].getDeadline();

		// Only set the initial value if the initialApprox variable is negative
		if (initialApprox < 0) {
			// Set first approximation equal to the task's blocking time
			startVal = taskBlockingTime;

			// Add the execution time of the task and all tasks with higher
			// priority
			for (int i = 0; i < taskIndex; i++) {
				startVal += taskArray[i].getExecutionTime();
			}
		} else {
			startVal = initialApprox;
		}

		while (Ecurrent > taskPeriod || k == 0) {
			k++; // Increment Counter

			Lnext = startVal + (k * taskExecTime);
			Lcurrent = -1;

			// Iterate with the latency calculation until the current
			// approximation equals the next one
			while (Math.abs(Lcurrent - Lnext) > epsilon) {
				Lcurrent = Lnext;
				Lnext = taskBlockingTime + (k * taskExecTime);

				for (int i = 0; i < taskIndex; i++) {
					Ci = taskArray[i].getExecutionTime();
					Ti = taskArray[i].getPeriod();
					Lnext += Math.ceil(Lcurrent / Ti) * Ci;
				}

				// if (Lnext > (((k - 1) * taskPeriod) + taskDeadline)) {
				// System.out.println("Algorithm terminated: Lnext = " + Lnext +
				// " Deadline = " + (((k - 1) * taskExecTime) + taskDeadline));
				// pastDeadline = true;
				// break;
				// }
			}

			Ecurrent = Lnext - taskPeriod * (k - 1);
			// System.out.println("Ecurrent = " + Ecurrent);
			if (pastDeadline == true) {
				break;
			}
			responseTimes.add(new Double(Ecurrent));
		}

		if (pastDeadline == true) {
			Emax = Ecurrent;
		} else {
			ListIterator responseIter = responseTimes.listIterator();
			while (responseIter.hasNext()) {
				Ecurrent = ((Double) responseIter.next()).doubleValue();
				if (Ecurrent > Emax) {
					Emax = Ecurrent;
				}
			}
		}

		return Emax;
	}
}
