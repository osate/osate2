package EAnalysis.BinPacking;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 
 * @author dionisio
 *
 * We assume that larger priority number means higher priority
 */

public class DecreasingPriorityComparator implements Comparator<FixedPriorityProcessingLoad> {

	public int compare(FixedPriorityProcessingLoad t0, FixedPriorityProcessingLoad t1) {
		if (t0.getUniqueID() == t1.getUniqueID())
			return 0;

		if (t0.getPriority() < t1.getPriority())
			return 1;
		else if (t0.getPriority() > t1.getPriority())
			return -1;
		else
			return (int) (t0.getUniqueID() - t1.getUniqueID());
	}

	// test
	public static void main(String args[]) {
		FixedPrioritySoftwareNode t1 = new FixedPrioritySoftwareNode(1, 10, 10, 10, "t1");
		FixedPrioritySoftwareNode t2 = new FixedPrioritySoftwareNode(2, 10, 10, 10, "t2");

		TreeSet<FixedPrioritySoftwareNode> set = new TreeSet<FixedPrioritySoftwareNode>(
				new DecreasingPriorityComparator());

		set.add(t1);
		set.add(t2);

		for (FixedPrioritySoftwareNode t : set) {
			System.out.println(t.name);
		}
	}

}
