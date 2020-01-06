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

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.BaseScheduler;
import EAnalysis.BinPacking.CompositeSoftNode;
import EAnalysis.BinPacking.HardwareNode;
import EAnalysis.BinPacking.ProcessingLoad;
import EAnalysis.BinPacking.Scheduler;
import EAnalysis.BinPacking.SoftwareNode;

/**
 * Processor scheduler for rate-monotonic analysis.  This version uses
 * scheduling code that I (aarong) wrote.  Not completely sure if it
 * works correctly.
 * 
 * @author aarong
 */
public final class RMASchedulerNew extends BaseScheduler {
	/** Singleton comparator of rates */
	private static final Comparator RATE_ORDER = new RateOrderComparator();

	/** The node we are scheduling for */
	private HardwareNode node;
	/** The current tasks on the node, sorted by period (i.e., rate) */
	/*
	 * Why does this need to be a sorted set?? Cheat here for now. Problem:
	 * I assume the intent is that the tasks should be sorted in priority
	 * order, but I cannot get the period from a CompositeSoftwareNode, so
	 * my ordering gets all screwed up.
	 */
	private final TreeSet compTasks = new TreeSet(new BandwidthComparator());

	/** The utilization of the given task set on the associated processor */
	private double utilization;

	/**
	 * Comparator for sorting the tasks by their rate.
	 */
	private static class RateOrderComparator implements Comparator {
		public int compare(final Object o1, final Object o2) {
			final ProcessingLoad pl1 = (ProcessingLoad) o1;
			final ProcessingLoad pl2 = (ProcessingLoad) o2;
			final double period1 = pl1.getPeriod();
			final double period2 = pl2.getPeriod();
			if (period1 == period2) {
				/*
				 * We want to allow items with equal periods. So we
				 * order then by unique id.
				 */
				final int val = (int) (((pl1.getUniqueID() - pl2.getUniqueID()) | 0x4000000000000000L) >> 32);
				return val;
			} else if (period1 < period2) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public RMASchedulerNew() {
		utilization = 0.0;
	}

	public void setHardwareNode(final HardwareNode n) {
		node = n;
	}

	public HardwareNode getHardwareNode() {
		return node;
	}

	/**
	 * Get the utilization for the given task on the processor
	 * associated with this scheduler.
	 */
	private double getUtilization(final ProcessingLoad task) {
		return task.getBandwidth() / node.cyclesPerSecond;
	}

	/**
	 * Get the execution time in nanoseconds for the given task on the processor
	 * associated with this scheduler.
	 */
	private double getComputeTime(final ProcessingLoad task) {
		return (task.getCycles() / node.cyclesPerSecond) * 1000000000.0;
	}

	public boolean canAddToFeasibility(final ProcessingLoad task) {
		/*
		 * Unfortunately the entire set of tasks must be re-evaluated because
		 * I don't think I'm guaranteed anything about the order in which
		 * loads are presented to the scheduler.
		 */
		final Set localCopy = new HashSet(compTasks);
		localCopy.add(task);
		SortedSet temp = flattenAndSortTasks(localCopy);
		return isSchedulableInternal(temp);
	}

	public boolean addIfFeasible(final ProcessingLoad task) {
		if (canAddToFeasibility(task)) {
			compTasks.add(task);
			utilization += getUtilization(task);
			task.setDeployedTo(node);
			return true;
		} else {
			return false;
		}
	}

	public void removeFromFeasibleSet(final ProcessingLoad task) {
		if (compTasks.remove(task)) {
			task.setDeployedTo(null);
			utilization -= getUtilization(task);
		}
	}

	public double getAvailableCapacity() {
		return 1.0 - utilization;
	}

	public boolean isSchedulable(final TreeSet taskSet) {
		// create a new set sorted by the periods of basic components
		return isSchedulableInternal(flattenAndSortTasks(taskSet));
	}

	/**
	 * Determine if the given set of loads is scheduable. This differs from
	 * {@link #isSchedulable(TreeSet)} in that the input set is assumed to be
	 * sorted by priority and to contain only non-composite {@link SoftwareNode}
	 * elements.
	 */
	private boolean isSchedulableInternal(final SortedSet basicNodes) {
		final PER_TaskObj[] tasks = new PER_TaskObj[basicNodes.size()];
		int id = 0;
		for (final Iterator i = basicNodes.iterator(); i.hasNext(); id += 1) {
			final SoftwareNode sn = (SoftwareNode) i.next();
			final PER_TaskObj task = new PER_TaskObj(id, id, getComputeTime(sn), sn.getPeriod(), sn.getDeadline(), 0.0);
			tasks[id] = task;
			System.out.println(task.toString());
		}
		final RMA rma = new RMA(tasks);
		final boolean schedulable = rma.solve();
		for (int i = 0; i < tasks.length; i++) {
			System.out.println("latency[" + i + "] == " + rma.getCompletionTime(tasks[i]));
		}
		return schedulable;
	}

	/**
	 * Given a set of software nodes, return a set of all the basic
	 * software nodes contained in the input set, sorted by period.
	 */
	private SortedSet flattenAndSortTasks(final Set taskSet) {
		final SortedSet basicNodes = new TreeSet(RATE_ORDER);
		for (final Iterator i = taskSet.iterator(); i.hasNext();) {
			final ProcessingLoad load = (ProcessingLoad) i.next();
			if (load instanceof CompositeSoftNode) {
				basicNodes.addAll(((CompositeSoftNode) load).getBasicComponents());
			} else if (load instanceof SoftwareNode) {
				basicNodes.add(load);
			} else {
				throw new IllegalArgumentException("Encounted non-SoftwareNode task: " + load.getClass().getName());
			}
		}
		return basicNodes;
	}

	public TreeSet getTaskSet() {
		return compTasks;
	}

	public void cloneTo(final Scheduler from, final Scheduler to) {
		/*
		 * apparently we don't have to copy of the contents of the
		 * scheduler to the new scheduler. At least the cloneTo()
		 * method in EDFScheduler doesn't do that.
		 */
		((RMASchedulerNew) to).compTasks.clear();
	}

}
