package EAnalysis.BinPacking;

import java.util.Comparator;

/**
 * This compartor only compares the bandwidth compression factor
 * 
 * This is a comparator where the natural order is descending. As a result, its
 * use in TreeMap and TreeSet would produce a descending order as well.
 */
public class BandwidthCompressionComparator implements Comparator {
	public int compare(Object o1, Object o2) {

		if (o1 instanceof ProcessingLoad && o2 instanceof ProcessingLoad) {
			ProcessingLoad n1 = (ProcessingLoad) o2;
			ProcessingLoad n2 = (ProcessingLoad) o1;

			if (n1.getUniqueID() == n2.getUniqueID())
				return 0;
		} else {
			if (o1.equals(o2))
				return 0;
		}

		/* To ensure descending order, swap o1 and o2 */

		BandwidthCompressor n1 = (BandwidthCompressor) o1; // o2;
		BandwidthCompressor n2 = (BandwidthCompressor) o2; // o1;
		double difference = n1.getBandwidthCompressionFactor() - n2.getBandwidthCompressionFactor();
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
			if (o1 instanceof ProcessingLoad && o2 instanceof ProcessingLoad) {
				ProcessingLoad l1 = (ProcessingLoad) o2;
				ProcessingLoad l2 = (ProcessingLoad) o1;
				return (int) (l1.getUniqueID() - l2.getUniqueID());
			}

			return (o1.hashCode() - o2.hashCode());
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}