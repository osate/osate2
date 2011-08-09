package EAnalysis.BinPacking;

import java.util.TreeSet;

public abstract class BaseScheduler implements Scheduler, Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract void setHardwareNode(HardwareNode n);

	public abstract HardwareNode getHardwareNode();

	public abstract boolean addIfFeasible(ProcessingLoad sNode);

	public abstract void removeFromFeasibleSet(ProcessingLoad sNode);

	public abstract double getAvailableCapacity();

	/**
	 * calculate whether the task set is schedulable or not
	 * 
	 * @param taskSet
	 *            task set ordered by non-decreasing order of deadline
	 */
	public abstract boolean isSchedulable(TreeSet taskSet);

	public abstract TreeSet getTaskSet();

	public abstract boolean canAddToFeasibility(ProcessingLoad l);

	public abstract void cloneTo(Scheduler from, Scheduler to);
}