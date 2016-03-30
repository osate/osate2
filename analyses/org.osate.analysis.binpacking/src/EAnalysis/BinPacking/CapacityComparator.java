package EAnalysis.BinPacking;

import java.util.Comparator;

public class CapacityComparator implements Comparator {

	public int compare(Object o1, Object o2) {

		if (o1 instanceof HardwareNode && o2 instanceof HardwareNode) {
			if (((HardwareNode) o1).getUniqueID() == ((HardwareNode) o2).getUniqueID())
				return 0;
		} else {
			if (o1.hashCode() == o2.hashCode())
				return 0;
		}

		CapacityProvider n1 = (CapacityProvider) o1;
		CapacityProvider n2 = (CapacityProvider) o2;
		double difference = n1.getAvailableCapacity() - n2.getAvailableCapacity();
		if (difference < 0) {
			return (int) Math.floor(difference);
		} else if (difference > 0) {
			return (int) Math.ceil(difference);
		} else {
			/*
			 * We cheat to enable duplicate entries int the set. Int this case
			 * we break the tie with the hashcode of the objects
			 */
			if (o1 instanceof HardwareNode && o2 instanceof HardwareNode) {
				return (int) (((HardwareNode) o1).getUniqueID() - ((HardwareNode) o2).getUniqueID());
			}

			return o1.hashCode() - o2.hashCode();
		}
	}

	public boolean equals(Object c) {
		return c.getClass().equals(getClass());
	}
}