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