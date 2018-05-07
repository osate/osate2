package EAnalysis.BinPacking;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EDFScheduler extends BaseScheduler {
	TreeSet taskSet;

	double currentCapacity = 0;

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

	public TreeSet getTaskSet() {
		return taskSet;
	}

	public boolean canAddToFeasibility(ProcessingLoad n) {
		return ((currentCapacity + n.getBandwidth() / node.cyclesPerSecond) <= 1.0);
	}

	public boolean addIfFeasible(ProcessingLoad n) {
		if ((currentCapacity + n.getBandwidth() / node.cyclesPerSecond) <= 1.0) {
			// long potentialLoad = 0;
			// potentialLoad += node.cyclesPerSecond;
			// potentialLoad -= currentLoadCyclesPerSecond;
			// potentialLoad -= n.getCyclesPerSecond();

			// if (potentialLoad>=0)
			// {
			taskSet.add(n);
			currentCapacity += n.getBandwidth() / node.cyclesPerSecond;
			currentLoadCyclesPerSecond += n.getCyclesPerSecond();
			n.setDeployedTo(getHardwareNode());
			return true;
		} else {
			// System.out.println("addIfFeasible failed:");
			// System.out.println("\t
			// node.cyclesPerSec("+node.cyclesPerSecond+")");
			// System.out.println("\t module.bandwidth("+n.getBandwidth()+")");
			// System.out.println("\t\t bw/cyclesPerSec ("+ (n.getBandwidth()/
			// node.cyclesPerSecond)+")");
			// System.out.println("\t currentCapacity("+currentCapacity+")");
		}
		return false;
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
	 *            task set ordered by non-decreasing order of deadline
	 */

	public boolean isSchedulable(TreeSet tSet) {
		double capacity = 0.0;
		// long capacity =0;
		for (Iterator iter = tSet.iterator(); iter.hasNext();) {
			SoftwareNode n = (SoftwareNode) iter.next();
			// capacity += n.getCyclesPerSecond();
			capacity += n.getBandwidth() / node.cyclesPerSecond;
			if (capacity > 1.0) // node.cyclesPerSecond)
				return false;
		}
		return true;
	}

	public EDFScheduler() {
	}

	public void cloneTo(Scheduler from, Scheduler to) {
		((EDFScheduler) to).taskSet = new TreeSet(((EDFScheduler) from).taskSet.comparator());
	}

	public EDFScheduler(Comparator comparator) {
		taskSet = new TreeSet(comparator);
	}
}