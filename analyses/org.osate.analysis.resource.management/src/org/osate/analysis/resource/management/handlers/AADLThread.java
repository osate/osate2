/* Created on Oct 18, 2004
 */
package org.osate.analysis.resource.management.handlers;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import EAnalysis.BinPacking.SoftwareNode;

/**
 * SoftwareNode representing an AADL thread instance. Instances are created
 * using the <code>static</code> factory method
 * {@link #createInstance(ComponentInstance)}.
 *
 * @author aarong
 */
public final class AADLThread extends SoftwareNode {
	public static final long DEFAULT_PERIOD_NANOSECOND = 1L;

	// cycles: cycles per dispatch
	private AADLThread(final ComponentInstance thr, final long cycles, final long period, final long deadline) {
		super(cycles, period, deadline, thr.getName());
		setSemanticObject(thr);
	}

	public static AADLThread createInstance(final ComponentInstance thread) {
		final long period = (long) GetProperties.getPeriodinNS(thread);

		long deadline;
		long cycles = 0;
		try {
			deadline = (long) GetProperties.getDeadlineinNS(thread);
		} catch (PropertyNotPresentException e) {
			deadline = 0;
		}

//		double instructionsperdispatch = GetProperties.getSpecifiedThreadInstructionsinIPD(thread);
//		if (instructionsperdispatch == 0){
//			double mips = GetProperties.getThreadExecutioninMIPS(thread);
//			 if (mips == 0){
//				 mips = GetProperties.getMIPSBudgetInMIPS(thread);
//			 }
//			if (mips > 0){
//				// mips per sec, period in ns. cycles per period => mips / # dispatches * M
//				cycles = (long) (mips * period /1000);
//			}
//		} else {
//			cycles = (long) instructionsperdispatch ;
//		}

		cycles = (long) GetProperties.getThreadExecutionInCycles(thread, Binpack.defaultMIPS);

		return new AADLThread(thread, cycles, period, deadline);
	}

	/** Get the AADL thread component instance represented by this object. */
	public ComponentInstance getThread() {
		return (ComponentInstance) getSemanticObject();
	}

	public String getReport() {
		return "Thread " + this.name + " instructions " + this.cycles + " instr per sec " + this.cyclesPerSecond
				+ " Period " + this.period + " Deadline " + this.deadline;
	}

}