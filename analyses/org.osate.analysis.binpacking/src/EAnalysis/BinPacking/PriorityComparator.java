package EAnalysis.BinPacking;

import java.util.Comparator;

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
}