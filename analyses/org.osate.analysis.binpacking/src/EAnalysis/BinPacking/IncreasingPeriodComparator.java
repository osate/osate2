/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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

public class IncreasingPeriodComparator implements Comparator<ProcessingLoad> {

	public int compare(ProcessingLoad t0, ProcessingLoad t1) {

		if (t0.getUniqueID() == t1.getUniqueID())
			return 0;
		if (t0.getPeriod() > t1.getPeriod())
			return 1;
		if (t0.getPeriod() < t1.getPeriod())
			return -1;
		else
			return (int) (t0.getUniqueID() - t1.getUniqueID());
	}

	// unit test
	public static void main(String args[]) {
		// SoftwareNode(long cycles, long period, long deadline, String name)
		SoftwareNode t0 = new SoftwareNode(1, 1, 1, "t0");
		SoftwareNode t1 = new SoftwareNode(2, 2, 2, "t1");

		TreeSet<ProcessingLoad> set = new TreeSet<ProcessingLoad>(new IncreasingPeriodComparator());
		set.add(t0);
		set.add(t1);

		for (ProcessingLoad l : set) {
			System.out.println("period: " + l.getPeriod() + " name:" + l.getName());
		}
	}
}
