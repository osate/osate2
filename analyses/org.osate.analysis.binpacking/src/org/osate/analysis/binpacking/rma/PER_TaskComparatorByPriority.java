package org.osate.analysis.binpacking.rma;

import java.util.Comparator;

/**
 * Task object for RMA analysis. Originally from package
 * <code>rapt.QAplugins.performance</code> in the ArchE project.
 * 
 * @author cshelton
 */
public class PER_TaskComparatorByPriority implements Comparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub

		int task0Priority = ((PER_TaskObj) arg0).getPriority();
		int task1Priority = ((PER_TaskObj) arg1).getPriority();

		if (task0Priority > task1Priority) {
			return 1;
		} else if (task0Priority < task1Priority) {
			return -1;
		} else {
			return 0;
		}
	}

}