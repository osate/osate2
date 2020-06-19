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
package EAnalysis.BinPacking;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class DMScheduler extends BaseScheduler {
	TreeSet<ProcessingLoad> taskSet = new TreeSet<ProcessingLoad>(new IncreasingDeadlineComparator());

	TreeSet<FixedPriorityProcessingLoad> decreasingPriorityTaskset = new TreeSet<FixedPriorityProcessingLoad>(
			new DecreasingPriorityComparator());

	long currentLoadCyclesPerSecond = 0;

	protected HardwareNode node;

	public void setHardwareNode(HardwareNode n) {
		node = n;
	}

	public HardwareNode getHardwareNode() {
		return node;
	}

	/**
	 * Capacity used by the tasks set
	 */
	protected int usedCapacity;

	private double currentCapacity = 0;

	public TreeSet<ProcessingLoad> getTaskSet() {
		return taskSet;
	}

	public boolean canAddToFeasibility(ProcessingLoad n) {
		taskSet.add(n);
		decreasingPriorityTaskset.clear();

		long topPriority = taskSet.size();

		for (ProcessingLoad p : taskSet) {
			FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) p;
			l.setPriority(topPriority--);
			decreasingPriorityTaskset.add(l);
		}

		FixedPriorityResponseTimeTester tester = new FixedPriorityResponseTimeTester(decreasingPriorityTaskset,
				(long) (getHardwareNode().getCyclesPerSecond()));

		boolean schedulable = tester.isTasksetSchedulable();

		taskSet.remove(n);

		return schedulable;
	}

	public boolean addIfFeasible(ProcessingLoad n) {
		taskSet.add(n);
		decreasingPriorityTaskset.clear();

		long topPriority = taskSet.size();

		for (ProcessingLoad p : taskSet) {
			FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) p;
			l.setPriority(topPriority--);
			decreasingPriorityTaskset.add(l);
		}

		FixedPriorityResponseTimeTester tester = new FixedPriorityResponseTimeTester(decreasingPriorityTaskset,
				(long) (getHardwareNode().getCyclesPerSecond()));

		boolean schedulable = tester.isTasksetSchedulable();

		if (!schedulable) {
			taskSet.remove(n);
		} else {
			currentCapacity += n.getBandwidth() / node.cyclesPerSecond;
			currentLoadCyclesPerSecond += n.getCyclesPerSecond();
		}

		return schedulable;
	}

	public void removeFromFeasibleSet(ProcessingLoad n) {
		if (taskSet.contains(n)) {
			taskSet.remove(n);
			n.setDeployedTo(null);
			currentCapacity -= n.getBandwidth() / node.cyclesPerSecond;
			currentLoadCyclesPerSecond -= n.getCyclesPerSecond();
		}
	}

	public double getAvailableCapacity() {
		return (1.0 - currentCapacity);
	}

	public long getAvailableCyclesPerSecond() {
		return ((long) node.cyclesPerSecond) - currentLoadCyclesPerSecond;
	}

	/**
	 * calculate whether the task set is schedulable or not
	 * 
	 * @param taskSet
	 *            task set is assumed to be ordered by decreasing order of deadline length.
	 */

	public boolean isSchedulable(TreeSet tSet) {
		taskSet = tSet;

		decreasingPriorityTaskset.clear();
		decreasingPriorityTaskset.addAll((Collection<? extends FixedPriorityProcessingLoad>) taskSet);

		FixedPriorityResponseTimeTester tester = new FixedPriorityResponseTimeTester(decreasingPriorityTaskset,
				(long) (getHardwareNode().getCyclesPerSecond()));

		boolean schedulable = tester.isTasksetSchedulable();

		return schedulable;
	}

	public DMScheduler() {
	}

	public void cloneTo(Scheduler from, Scheduler to) {
		((DMScheduler) to).taskSet = new TreeSet(((DMScheduler) from).taskSet.comparator());
	}

	public DMScheduler(Comparator comparator) {
		taskSet = new TreeSet(comparator);
	}

	// tester
	public static void main(String args[]) {
		// two test. One should be schedulable the other should not
		// HardwareNode(Scheduler s, double cyclesPerSec)
		HardwareNode n = new HardwareNode(new DMScheduler(), 1000000000);
		// SoftwareNode(long cycles, long period, long deadline, String name)
		FixedPrioritySoftwareNode t0 = new FixedPrioritySoftwareNode(50000000, 100000000, 100000000, "t0");
		FixedPrioritySoftwareNode t1 = new FixedPrioritySoftwareNode(50000000, 200000000, 70000000, "t1");

		boolean feasible = n.addIfFeasible(t0);
		feasible &= n.addIfFeasible(t1);

		System.out.println("Should be feasible. Feasible = " + feasible);

		t0 = new FixedPrioritySoftwareNode(50000000, 100000000, 100000000, "t0");
		t1 = new FixedPrioritySoftwareNode(50000000, 200000000, 30000000, "t1");

		HardwareNode n1 = new HardwareNode(new DMScheduler(), 1000000000);

		feasible = n1.addIfFeasible(t0);
		feasible &= n1.addIfFeasible(t1);

		System.out.println("Should not be feasible. Feasible = " + feasible);
	}

}
