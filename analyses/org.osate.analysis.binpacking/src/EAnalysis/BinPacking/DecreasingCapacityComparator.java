/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package EAnalysis.BinPacking;

import java.util.Comparator;

public class DecreasingCapacityComparator implements Comparator {
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
		double difference = n2.getAvailableCapacity() - n1.getAvailableCapacity();
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