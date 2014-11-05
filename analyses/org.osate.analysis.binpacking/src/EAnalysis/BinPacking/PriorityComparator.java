package EAnalysis.BinPacking;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * This comparator order based on lower priority number goes first
 */
public class PriorityComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		FixedPriorityProcessingLoad p1 = (FixedPriorityProcessingLoad) o2;
		FixedPriorityProcessingLoad p2 = (FixedPriorityProcessingLoad) o1;

		if (p1.getUniqueID() == p2.getUniqueID())
			return 0;

		if (p1.getPriority() < p2.getPriority())
			return 1;
		else if (p1.getPriority() > p2.getPriority())
			return -1;
		else
			return (int) (p1.getUniqueID() - p2.getUniqueID());
	}

	public boolean equals(Object o) {
		return (o.getClass().equals(getClass()));
	}

	// test
	public static void main(String args[]) {
		FixedPrioritySoftwareNode t1 = new FixedPrioritySoftwareNode(1, 10, 10, 10, "t1");
		FixedPrioritySoftwareNode t2 = new FixedPrioritySoftwareNode(2, 10, 10, 10, "t2");

		TreeSet<FixedPrioritySoftwareNode> set = new TreeSet<FixedPrioritySoftwareNode>(new PriorityComparator());

		set.add(t1);
		set.add(t2);

		for (FixedPrioritySoftwareNode t : set) {
			System.out.println(t.name);
		}
	}
}