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
