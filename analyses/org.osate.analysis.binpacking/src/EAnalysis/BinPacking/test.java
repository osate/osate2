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

public class test {
	public static void main(String args[]) {
		long[] moduleSizes = new long[1000];
		int numSize = 0;

		long procSize = 4000000000l;
		long nextSize = procSize / 2;
		long difference = (procSize / 4) - 1;
		while (((procSize % difference) == 0) && ((procSize % (nextSize - difference)) == 0))
			difference--;
		moduleSizes[0] = (procSize / 2) - difference;
		while (difference > 20) {
			long nextDifference = (difference / 2) - 1;
			while (((procSize % nextDifference) == 0) && ((procSize % (difference - nextDifference)) == 0))
				nextDifference--;
			moduleSizes[++numSize] = difference - nextDifference;
			difference = nextDifference;
		}

		nextSize = difference;
		while (nextSize > 1) {
			nextSize = 0;
			while ((procSize % difference) == 0) {
				difference--;
				nextSize++;
			}
			moduleSizes[++numSize] = difference;
		}
		if (nextSize != 0)
			moduleSizes[++numSize] = nextSize;

		System.out.println("Sizes");
		long sum = 0;
		for (int i = 0; i <= numSize; i++) {
			System.out.println("\t size[" + i + "] = " + moduleSizes[i]);
			sum += moduleSizes[i];
		}
		System.out.println("sum(" + sum + ") sum*2(" + (sum * 2) + ")");
	}
}