package org.osate.analysis.scheduling;

import java.util.Vector;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  this file is to follow the original C++ context. The reason that I keep it
 *  is that the primitive data structure is not to represent the object, which then
 *  can not be held in the "Vector " structure. And during the data manipulation,
 *  double array is intensively used. 
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 */

public class DoubleArray {

	// data fields
	private int numberOfItems;
	Vector itemList;

	public DoubleArray() {
		numberOfItems = 0;
		itemList = new Vector();
	}

	public int getNumberOfItemsInArray() {
		return numberOfItems;
	}

	public void addItemInArray(double item) {
		itemList.addElement(new Double(item));
		numberOfItems++;
	}

	public double getItemInArray(int i) {
		return (((Double) itemList.elementAt(i)).doubleValue());
	}

	public void removeItems() {
		numberOfItems = 0;
		itemList.removeAllElements();
	}

}