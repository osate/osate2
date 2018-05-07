package EAnalysis.BinPacking;

import java.util.Comparator;

/**
 * This compartor only compares the bandwidth disregarding the deadline of the
 * demand. Therefore, it is not directly applicable for fixed-priority
 * schedulers.
 */
public class BandwidthComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		// if (o1.hashCode() == o2.hashCode())
		// return 0;

		ProcessingLoad n1 = (ProcessingLoad) o2;
		ProcessingLoad n2 = (ProcessingLoad) o1;

		if (n1.getUniqueID() == n2.getUniqueID())
			return 0;

		double difference = n1.getBandwidth() - n2.getBandwidth();
		if (difference < 0) {
			return (int) Math.floor(difference);
		} else if (difference > 0) {
			return (int) Math.ceil(difference);
		} else {
			/*
			 * We will cheat to allow duplicate entries int a set, i.e., we
			 * break the tie arbitrarily. Int this case we break it with the
			 * hash number
			 */
			// return (o1.hashCode() - o2.hashCode());
			return (int) (n1.getUniqueID() - n2.getUniqueID());
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}