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