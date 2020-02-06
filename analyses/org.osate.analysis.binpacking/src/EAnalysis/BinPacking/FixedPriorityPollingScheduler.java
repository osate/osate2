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

import java.util.Iterator;
import java.util.TreeSet;

public class FixedPriorityPollingScheduler implements Scheduler {
	TreeSet taskSet;

	protected HardwareNode node;

	public void setHardwareNode(HardwareNode n) {
		node = n;
	}

	public HardwareNode getHardwareNode() {
		return node;
	}

	public FixedPriorityPollingScheduler() {
		taskSet = new TreeSet(new PriorityComparator());
	}

	public boolean addIfFeasible(ProcessingLoad pNode) {
		FixedPriorityProcessingLoad s1Node = (FixedPriorityProcessingLoad) pNode;
		taskSet.add(s1Node);
		System.out.println("addIfFeasible(" + s1Node.getName() + ")");
		for (Iterator iter1 = taskSet.iterator(); iter1.hasNext();) {
			FixedPriorityProcessingLoad sNode = (FixedPriorityProcessingLoad) iter1.next();
			/**
			 * Obtain largest preemption.
			 */
			long largestPreemption = 0;
			for (Iterator iter = taskSet.iterator(); iter.hasNext();) {
				FixedPriorityProcessingLoad p = (FixedPriorityProcessingLoad) iter.next();
				if (p.equals(sNode))
					continue;

				if (sNode.getPriority() <= p.getPriority()) {
					if (((p.getCycles() * 1000000000) / ((long) node.cyclesPerSecond)) > largestPreemption) {
						System.out.println("\t\t Largest preemption from task(" + p.getName() + ")");
						largestPreemption = (p.getCycles() * 1000000000) / ((long) node.cyclesPerSecond);
					}
				}
			}

			System.out.println("\t Largest Preemption = " + largestPreemption);

			long preemptingTasks = 0;
			long largestCompletion = 0;
			long currentCompletion = 0;

			do {
				largestCompletion = currentCompletion;
				System.out.println("Preemption: msg cycles(" + sNode.getCycles() + ") node.cyclesps("
						+ node.cyclesPerSecond + ")");

				// preemption in nanoseconds
				currentCompletion = ((sNode.getCycles() * 1000000000) / ((long) node.cyclesPerSecond))
						+ pollingTimePerTask;
				// largestPreemption+( (sNode.getCycles() * 1000000000)/
				// ((long)node.cyclesPerSecond)) + pollingTimePerTask;
				for (Iterator iter = taskSet.iterator(); iter.hasNext();) {
					long numberOfPreemptions = 0;
					FixedPriorityProcessingLoad p = (FixedPriorityProcessingLoad) iter.next();
					if (p.equals(sNode))
						continue;

					if (p.getPriority() <= sNode.getPriority()) {
						numberOfPreemptions = (long) Math.ceil(((double) largestCompletion) / ((double) p.getPeriod()));
						System.out.println("\t calculating preemption from task(" + p.getName() + ") largestCompletion("
								+ largestCompletion + ") numPreemptions(" + numberOfPreemptions + ")");
						currentCompletion += numberOfPreemptions
								* (((p.getCycles() * 1000000000) / ((long) node.cyclesPerSecond)) + pollingTimePerTask);
					}
				}
			} while ((currentCompletion != largestCompletion) && (largestCompletion <= sNode.getDeadline()));

			System.out.println("\t Task(" + sNode.getName() + ") final Completion = " + largestCompletion + " ns");

			((FixedPrioritySoftwareNode) sNode).setCompletionTime(largestCompletion);
			if (!(largestCompletion <= sNode.getDeadline())) {
				taskSet.remove(s1Node);
				return false;
			}
		}
		return true;
	}

	public void removeFromFeasibleSet(ProcessingLoad sNode) {
	}

	public double getAvailableCapacity() {
		return 1.0;
	}

	/**
	 * This is the time it takes to poll a single task (node) when the task
	 * responds that it has nothing to send. In nanoseconds
	 */
	long pollingTimePerTask = 0;

	public void setPollingTimePerTask(long p) {
		pollingTimePerTask = p;
	}

	public boolean isSchedulable(TreeSet tSet) {
		return false;
	}

	public TreeSet getTaskSet() {
		return null;
	}

	public boolean canAddToFeasibility(ProcessingLoad l) {
		return false;
	}

	public void cloneTo(Scheduler from, Scheduler to) {
	}

	/**
	 * A test
	 */
	public static void main(String[] args) {
		FixedPriorityPollingScheduler scheduler = new FixedPriorityPollingScheduler();
		HardwareNode net = new HardwareNode();
		net.cyclesPerSecond = 1000000000.0;
		scheduler.setHardwareNode(net);

		FixedPrioritySoftwareNode n1 = new FixedPrioritySoftwareNode(1, 10, 100, 100, "one");
		FixedPrioritySoftwareNode n2 = new FixedPrioritySoftwareNode(2, 12, 200, 200, "two");
		FixedPrioritySoftwareNode n3 = new FixedPrioritySoftwareNode(3, 14, 400, 400, "three");
		boolean res = false;
		res = scheduler.addIfFeasible(n1);
		res = scheduler.addIfFeasible(n2);
		res = scheduler.addIfFeasible(n3);
		System.out.println("res = " + res);
	}
}