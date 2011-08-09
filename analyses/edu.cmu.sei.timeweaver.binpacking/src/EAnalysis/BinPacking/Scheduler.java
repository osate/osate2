package EAnalysis.BinPacking;

import java.util.TreeSet;

/**
 * @author Dionisio de Niz
 */

public interface Scheduler {
	public void setHardwareNode(HardwareNode n);

	public HardwareNode getHardwareNode();

	public boolean addIfFeasible(ProcessingLoad sNode);

	public void removeFromFeasibleSet(ProcessingLoad sNode);

	public double getAvailableCapacity();

	/**
	 * calculate whether the task set is schedulable or not
	 * 
	 * @param taskSet
	 *            task set ordered by non-decreasing order of deadline
	 */
	public boolean isSchedulable(TreeSet taskSet);

	public TreeSet getTaskSet();

	public boolean canAddToFeasibility(ProcessingLoad l);

	public void cloneTo(Scheduler from, Scheduler to);
}