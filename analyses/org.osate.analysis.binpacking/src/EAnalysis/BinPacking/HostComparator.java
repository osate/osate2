package EAnalysis.BinPacking;

import java.util.Comparator;

public class HostComparator implements Comparator {

	public int compare(Object o1, Object o2) {

		if (o1.hashCode() == o2.hashCode()) {
			return 0;
		}

		Location n1 = (Location) o1;
		Location n2 = (Location) o2;
		double difference = n1.getAvailableHostingCapacity() - n2.getAvailableHostingCapacity();
		if (difference < 0) {
			return (int) Math.floor(difference);
		} else if (difference > 0) {
			return (int) Math.ceil(difference);
		} else {
			/*
			 * We cheat to enable duplicate entries int the set. Int this case
			 * we break the tie with the hashcode of the objects
			 */
			return o1.hashCode() - o2.hashCode();
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}