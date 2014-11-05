package EAnalysis.BinPacking;

/**
 * 
 * @author dionisio
 *
 * This RMS scheduler assigns priority number assuming that larger number
 * encodes higher priority
 * 
 * The comparator used is the DecreasingPriorityComparator that follows this rule
 */
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class RMScheduler extends BaseScheduler {

	TreeSet<ProcessingLoad> taskSet = new TreeSet<ProcessingLoad>(new IncreasingPeriodComparator());

	TreeSet<FixedPriorityProcessingLoad> decreasingPriorityTaskset = new TreeSet<FixedPriorityProcessingLoad>(
			new DecreasingPriorityComparator());

	// double currentCapacity = 0;

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
			if (p instanceof CompositeSoftNode) {
				CompositeSoftNode composite = (CompositeSoftNode) p;
				for (Iterator iter = composite.getBasicComponents().iterator(); iter.hasNext();) {
					FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) iter.next();
					l.setPriority(topPriority--);
					decreasingPriorityTaskset.add(l);
				}
			} else {
				FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) p;
				l.setPriority(topPriority--);
				decreasingPriorityTaskset.add(l);
			}
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
			if (p instanceof CompositeSoftNode) {
				CompositeSoftNode composite = (CompositeSoftNode) p;
				for (Iterator iter = composite.getBasicComponents().iterator(); iter.hasNext();) {
					FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) iter.next();
					l.setPriority(topPriority--);
					decreasingPriorityTaskset.add(l);
				}
			} else {
				FixedPriorityProcessingLoad l = (FixedPriorityProcessingLoad) p;
				l.setPriority(topPriority--);
				decreasingPriorityTaskset.add(l);
			}
		}

		// transform cycles per second to cycles per millisecond
		FixedPriorityResponseTimeTester tester = new FixedPriorityResponseTimeTester(decreasingPriorityTaskset,
				(long) (getHardwareNode().getCyclesPerSecond()));

		boolean schedulable = tester.isTasksetSchedulable();

		if (!schedulable) {
			taskSet.remove(n);
		} else {
			double additionalCapacity = n.getBandwidth() / node.cyclesPerSecond;
			currentCapacity = currentCapacity + additionalCapacity;
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
		System.out.println("RMSCheduler.currentCapacity:" + currentCapacity);
		return (1.0 - currentCapacity);
	}

	public long getAvailableCyclesPerSecond() {
		return ((long) node.cyclesPerSecond) - currentLoadCyclesPerSecond;
	}

	/**
	 * calculate whether the task set is schedulable or not
	 * 
	 * @param taskSet
	 *            task set is assumed to be ordered by decreasing order of period length.
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

	public RMScheduler() {
	}

	public void cloneTo(Scheduler from, Scheduler to) {
		((RMScheduler) to).taskSet = new TreeSet(((RMScheduler) from).taskSet.comparator());
	}

	public RMScheduler(Comparator comparator) {
		taskSet = new TreeSet(comparator);
	}

	// tester
	public static void main(String args[]) {
		// two test. One should be schedulable the other should not
		// HardwareNode(Scheduler s, double cyclesPerSec)
		HardwareNode n = new HardwareNode(new RMScheduler(), 1000000000);
		// SoftwareNode(long cycles, long period, long deadline, String name)
		FixedPrioritySoftwareNode t0 = new FixedPrioritySoftwareNode(41000000, 100000000, 100000000, "t0");
		FixedPrioritySoftwareNode t1 = new FixedPrioritySoftwareNode(59000000, 141000000, 141000000, "t1");

		boolean feasible = n.addIfFeasible(t0);
		feasible &= n.addIfFeasible(t1);

		System.out.println("Should be feasible. Feasible = " + feasible + " capacity: " + n.getAvailableCapacity());

		t0 = new FixedPrioritySoftwareNode(42000000, 100000000, 100000000, "t0");
		t1 = new FixedPrioritySoftwareNode(59000000, 141000000, 141000000, "t1");

		HardwareNode n1 = new HardwareNode(new RMScheduler(), 1000000000);

		feasible = n1.addIfFeasible(t0);
		feasible &= n1.addIfFeasible(t1);

		System.out
				.println("Should not be feasible. Feasible = " + feasible + " capacity: " + n1.getAvailableCapacity());
	}
}
