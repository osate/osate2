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

//import acmeLib.*;

//import acmeLib.core.container.*;

/** this whole package is translated from the C++ version. It covers
 *  the scheduling and the sensitivity analyis for a set of processes
 *  bounded to a particular processor.
 *
 *  this file contains the auxillary utilities used in this package.
 *
 *  @author Jun Li
 *  created in May 12, 1999.
 *
 */
public class Auxillary {
	// no data fields

	public static int phaseConversion(RuntimeProcess processj, RuntimeProcess processi) {
		if (compareNotMySelf(processj, processi) == false)
			return processj.getPhaseOffset();

		if ((processj.getPhaseOffset() < processi.getPhaseOffset()) || (processj.getARCID() != processi.getARCID()))
			return processj.getPhaseOffset();
		else
			return (processj.getPhaseOffset() - processj.getPeriod());
	}

	public static int ceiling_1_0(double x) {
		return ((x <= 0) ? 0 : 1);

	}

	public static double ceiling_0(double x) {
		return ((x > 0.0) ? java.lang.Math.ceil(x) : 0.0);
	}

	public static double processInARCContribution(double window, double windowOffset, RuntimeProcess processj,
			RuntimeProcess processi) {
		double result;
		result = (ceiling_0((window + windowOffset - phaseConversion(processj, processi)) / processj.getPeriod())
				- ceiling_1_0(windowOffset - phaseConversion(processj, processi))) * (processj.getExecutionTime());
		return result;
	}

	public static double processOtherThanMySelfContribution(double window, double windowOffsetWithinMySelf,
			double windowOffsetRelativeToMySelf, RuntimeProcess mySelf, ARCForArray ARC) {

		RuntimeProcess processInstance;
		double result = 0;
		int number = ARC.getNumberOfProcesses();

		for (int i = 0; i < number; i++) {
			processInstance = ARC.getProcess(i);

			if ((compareNotMySelf(processInstance, mySelf) != false)
					&& (processInstance.getPriority() > mySelf.getPriority())) {
				if (processInstance.getARCID() == mySelf.getARCID())
					result += processInARCContribution(window, windowOffsetWithinMySelf, processInstance, mySelf);
				else
					result += processInARCContribution(window, windowOffsetRelativeToMySelf, processInstance, mySelf);
			}
		}

		return result;
	}

	public static boolean compareNotMySelf(RuntimeProcess processx, RuntimeProcess mySelf) {
		if ((processx.getARCID() == mySelf.getARCID()) && (processx.getPeriod() == mySelf.getPeriod())
				&& (processx.getDeadline() == mySelf.getDeadline())
				&& (processx.getExecutionTime() == mySelf.getExecutionTime())
				&& (processx.getPriority() == mySelf.getPriority()))
			return false;
		else
			return true;

	}

}