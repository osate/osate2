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
package org.osate.aadl2.modelsupport;

import org.eclipse.emf.common.util.EList;

/**
 *
 * Quicksort class provides the ability to define a quicksort method with
 * a condition that is specific to the object type.
 * This is achieved by redefininng the compare(obj1,obj2) method.
 * This method returns -1 if obj1 is less than obj2, 0 if they are equal, and 1 if obj1 is greater than obj2.
 * The default implementation performs a srting comparison of the toString value of each object.
 * @author phf
 */
public class QuickSort {

	private EList theList;

	private int partition(int p, int r) {
		int i = p - 1, j = r + 1;
		while (true) {
			do {
				j--;
			} while (compare(theList.get(j), theList.get(p)) > 0);
			do {
				i++;
			} while (compare(theList.get(i), theList.get(p)) < 0);
			if (i < j) {
				Object temp = theList.get(i);
				theList.set(i, theList.get(j));
				theList.set(j, temp);
			} else {
				return j;
			}
		}
	}

	/**
	 * this is the default implementation of the compare method
	 * It uses the string representation of the two objects to perform the comparison
	 * @param obj1 first object
	 * @param obj2 second object
	 * @return -1 if obj1 < obj2, 0 if equal, 1 if obj1 > obj2.
	 */
	protected int compare(Object obj1, Object obj2) {
		String a = obj1.toString();
		String b = obj2.toString();
		return a.compareTo(b);
	}

	private void doQuickSort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			doQuickSort(p, q);
			doQuickSort(q + 1, r);
		}
	}

	/**
	 * performs a quicksort on the EList according the the compare method
	 * the default compare method compares the striong representations of two objects.
	 * @param el
	 */
	public void quickSort(EList el) {
		if (el.isEmpty()) {
			return;
		}
		theList = el;
		doQuickSort(0, el.size() - 1);
	}

}
