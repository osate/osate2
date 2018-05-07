/*
 * Created on Sep 25, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
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
