package org.osate.analysis.scheduling;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  this file contains some global values used in this package.
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 *
 */

public class TestScheduling {
	public static void main(String[] args) {

		// System.out.println("the result of 1.3999 is: " + Auxillary.ceiling_0(1.39999));
		// System.out.println(" the result of 2.89 is : " + Auxillary.ceiling_1_0(2.89));
		SimplexTiming analysis = new SimplexTiming();

		// only conduct the tractable analysis
		analysis.setExactOrTractable(true);

		analysis.initilization();
		System.out.println("\t\t finish the initilization...");

		analysis.schedulabilityAnalysis();
		System.out.println("\t\t finish the schedulability analysis...");

		/*
		 * Warning: Jun Li, I don't have time to debug the sensitivity analysis for
		 * the EDCS demo, but definitely it is for the thesis. Based on the translation
		 * from C++ to Java, one of the most subtle ones is the: setElementAt and
		 * insertElementAt inside the java.util.Vector. If you need to override the
		 * existing Vector, use "setElementAt"; if it is the first time to create the
		 * vector, use "insertElementAt"!
		 */
		// analysis.sensitivityAnalysis();
		// System.out.println("\t\t finish the sensitivity analysis...");

		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

}