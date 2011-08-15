/* Created on Oct 18, 2004
 */
package edu.cmu.sei.aadl.resourcemanagement.actions;

import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.GetProperties;

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

	private AADLThread(final ComponentInstance thr, final long cycles,
			final long period, final long deadline) {
		super(cycles, period, deadline, thr.getName());
		setSemanticObject(thr);
	}
	
	public static AADLThread createInstance(final ComponentInstance thread) {
		final long period = (long)GetProperties.getPeriodinNS(thread);

		long deadline;
		try
		{
			deadline = (long)GetProperties.getDeadlineinNS(thread);
		}
		catch (PropertyNotPresentException e)
		{
			deadline = 0;
		}
		
		double maxComputeTime;
		try
		{
			maxComputeTime = GetProperties.getComputeExecutionTimeinSec(thread);
		}
		catch (PropertyNotPresentException e)
		{
			maxComputeTime = 0.0;
		}
		if (maxComputeTime == 0){ // Choose deadline as WCET
			try
			{
				maxComputeTime = GetProperties.getDeadlineinSec(thread);
			}
			catch (PropertyNotPresentException e)
			{
				maxComputeTime = 0.0;
			}
		}
	
		final long cycles = (long) (maxComputeTime / GetProperties.getReferenceCycleTimeinSec(thread));
	
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
			try {
				return GetProperties.getReferenceCycleTimeinMS(thread);
			} catch (PropertyLookupException e) {
				return GetProperties.getReferenceCycleTimeConstantinMS(thread);
			}
	}
}