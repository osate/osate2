package EAnalysis.BinPacking;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 
 * @author dionisio
 *
 * We assume that larger priority number means higher priority
 */
public class FixedPriorityResponseTimeTester {

	/*
	 * This taskset is assume to be in decreasing priority order.
	 * This means that we will see larger priority number first.
	 */
	TreeSet<FixedPriorityProcessingLoad> tasksetDecreasingPriority;
	long processorSpeedCyclesPerSecond;

	public FixedPriorityResponseTimeTester(TreeSet<FixedPriorityProcessingLoad> taskset,
			long processorSpeedCyclesPerSecond) {
		this.tasksetDecreasingPriority = taskset;
		this.processorSpeedCyclesPerSecond = processorSpeedCyclesPerSecond;
	}

	long cyclesToNanoseconds(long cycles) {
		return (long) ((double) cycles / ((double) processorSpeedCyclesPerSecond / 1000000000.0));
	}

	public boolean isTasksetSchedulable() {
		boolean ret = true;
		for (Iterator<FixedPriorityProcessingLoad> iter = tasksetDecreasingPriority.iterator(); iter.hasNext();) {
			FixedPriorityProcessingLoad task = iter.next();
			System.out.println("FPTest: task period: " + task.getPeriod() + " wcet: "
					+ cyclesToNanoseconds(task.getCycles()) + " bw: " + task.getBandwidth());
			ret = ret && isTaskSchedulable(task);
		}
		return ret;
	}

	public boolean isTaskSchedulable(FixedPriorityProcessingLoad t) {
		long exectime_ns = cyclesToNanoseconds(t.getCycles());
		long responseTime = exectime_ns;
		long prevResponseTime;
		do {
			prevResponseTime = responseTime;
			responseTime = exectime_ns;
			// add all preemptions
			for (Iterator<FixedPriorityProcessingLoad> iter = tasksetDecreasingPriority.iterator(); iter.hasNext();) {
				FixedPriorityProcessingLoad t1 = iter.next();
				// if we get to t we finish traversing higher-priority tasks
				if (t1.getUniqueID() == t.getUniqueID())
					break;
				long numOfJobs = (long) Math.ceil((double) prevResponseTime / (double) t1.getPeriod());
				responseTime += numOfJobs * cyclesToNanoseconds(t1.getCycles());
			}
			// System.out.println("Response time current: " + responseTime + "prev:" + prevResponseTime);
		} while (responseTime != prevResponseTime && responseTime <= t.getDeadline());
		return (responseTime <= t.getDeadline());
	}

	public static void main(String args[]) {
		// long priority, long cycles, long period,long deadline, String name
		FixedPrioritySoftwareNode t1 = new FixedPrioritySoftwareNode(3, 10000000, 100000000, 100000000);
		FixedPrioritySoftwareNode t2 = new FixedPrioritySoftwareNode(2, 100000000, 200000000, 200000000);
		FixedPrioritySoftwareNode t3 = new FixedPrioritySoftwareNode(1, 300000000, 800000000, 800000000);

		TreeSet<FixedPriorityProcessingLoad> set = new TreeSet<FixedPriorityProcessingLoad>(
				new DecreasingPriorityComparator());

		set.add(t1);
		set.add(t2);
		set.add(t3);

		FixedPriorityResponseTimeTester tester = new FixedPriorityResponseTimeTester(set, 1000000000);

		System.out.println("t1.cycles in nanos:" + tester.cyclesToNanoseconds(t1.getCycles()));
		System.out.println("t2.cycles in nanos:" + tester.cyclesToNanoseconds(t2.getCycles()));
		System.out.println("t3.cycles in nanos:" + tester.cyclesToNanoseconds(t3.getCycles()));

		System.out.println("taskset schedulable = " + tester.isTasksetSchedulable());
	}
}
