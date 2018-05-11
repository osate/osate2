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