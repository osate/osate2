package EAnalysis.BinPacking;

import java.util.Comparator;

/**
 * This compartor only compares the bandwidth out degree disregarding the
 * deadline of the demand. Therefore, it is not directly applicable for
 * fixed-priority schedulers.
 * 
 * This is a comparator where the natural order is descending. As a result, its
 * use in TreeMap and TreeSet would produce a descending order as well.
 */
public class OutDegreeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		// if (o1.equals(o2))
		// return 0;

		if (((ProcessingLoad) o1).getUniqueID() == ((ProcessingLoad) o2).getUniqueID())
			return 0;

		/* To ensure descending order, swap o1 and o2 */

		SoftwareNode n1 = (SoftwareNode) o2;
		SoftwareNode n2 = (SoftwareNode) o1;
		double difference = n1.getBandwidthOutDegree() - n2.getBandwidthOutDegree();
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
			return (o1.hashCode() - o2.hashCode());
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}