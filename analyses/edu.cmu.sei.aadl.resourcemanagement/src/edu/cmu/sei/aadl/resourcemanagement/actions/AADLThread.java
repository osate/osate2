/* Created on Oct 18, 2004
 */
package edu.cmu.sei.aadl.resourcemanagement.actions;

import EAnalysis.BinPacking.SoftwareNode;
import edu.cmu.sei.aadl.aadl2.ClassifierValue;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.aadl2.properties.PropertyLookupException;
import edu.cmu.sei.aadl.aadl2.properties.PropertyNotPresentException;

/**
 * SoftwareNode representing an AADL thread instance. Instances are created
 * using the <code>static</code> factory method
 * {@link #createInstance(ComponentInstance)}.
 *
 * @author aarong
 */
public final class AADLThread extends SoftwareNode {
	public static final long DEFAULT_PERIOD_NANOSECOND = 1L;

	private AADLThread(final ComponentInstance thr, final long cycles,
			final long period, final long deadline) {
		super(cycles, period, deadline, thr.getName());
		setSemanticObject(thr);
	}
	
	public static AADLThread createInstance(final ComponentInstance thread, final BinpackProperties properties) {
		final long period = (long)properties.getPeriodAsNanoSecond(thread);

		long deadline;
		try
		{
			deadline = (long)properties.getDeadlineAsNanoSecond(thread);
		}
		catch (PropertyNotPresentException e)
		{
			deadline = 0;
		}
		
		double maxComputeTime;
		try
		{
			maxComputeTime = properties.getComputeExecutionTime(thread);
		}
		catch (PropertyNotPresentException e)
		{
			maxComputeTime = 0.0;
		}
		if (maxComputeTime == 0){ // Choose deadline as WCET
			try
			{
				maxComputeTime = properties.getDeadlineAsSecond(thread);
			}
			catch (PropertyNotPresentException e)
			{
				maxComputeTime = 0.0;
			}
		}
	
		final long cycles = (long) (maxComputeTime / getReferenceCycleTime(thread, properties));
	
		return new AADLThread(thread, cycles, period, deadline);
	}

	/** Get the AADL thread component instance represented by this object. */
	public ComponentInstance getThread() {
		return (ComponentInstance) getSemanticObject();
	}
	
	/**
	 * Get the cycle time in seconds of the reference processor.  First
	 * tries to find an explicit reference processor.  If it finds it, then
	 * it gets the cycle time of that processor.  Otherwise it tries to find
	 * an explicit reference_cycle_time value.  Failing that, it returns
	 * a value corresponding to a 1GHz processor.
	 */
	private static double getReferenceCycleTime(final ComponentInstance thread, BinpackProperties properties)
	{
		double defaultval = (properties.referenceCycleTimeExists())?
			 properties.getReferenceCycleTime() : AADLProcessor.DEFAULT_CYCLE_TIME;
			try {
				PropertyValue refProcPV = properties.getReferenceProcessorPropertyValue(thread);
				return properties.getCycleTime(((ClassifierValue)refProcPV).getClassifier(), defaultval);
			} catch (PropertyLookupException e) {
				return defaultval;
			}
	}
}