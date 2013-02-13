/* Created on Oct 18, 2004
 */
package org.osate.analysis.resource.management.actions;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.analysis.binpacking.rma.RMASchedulerNew;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.NetInterface;
import EAnalysis.BinPacking.Processor;
import EAnalysis.BinPacking.Scheduler;

/**
 * Processor representing an AADL Processor instance. Instances are created
 * using the <code>static</code> factory method
 * {@link #createInstance(ComponentInstance)}.
 *
 * @author aarong
 */
public final class AADLProcessor extends Processor {

	/**
	 * Public prototype value to use a "template" processor when defining
	 * suitable site guests, etc.
	 */
	public static AADLProcessor PROTOTYPE = new AADLProcessor();

	/**
	 * Create a prototype instances of this processor.  Only to be used to
	 * intialize the {@link #PROTOTYPE} field.
	 */
	private AADLProcessor() {
		super("PROTOTYPE", new EDFScheduler(new BandwidthComparator()), 1/GetProperties.DEFAULT_CYCLE_TIME_IN_SEC);
		// Not worrying about site architecture
		this.powerRequirement = 0.0;
		this.spaceRequirement = 0.0;
	}

	/**
	 * Create a new AADL Processor associated with the given Processor
	 * component instance.
	 * @param proc The Processor component instance.  Cannot be <code>null</code>.
	 * @param sched The scheduler to use.
	 * @param cyclesPerSecond The processor's speed in cycles per second.
	 */
	private AADLProcessor(final ComponentInstance proc, final Scheduler sched,
			final double cyclesPerSecond) {
		super(proc.getName(), sched, cyclesPerSecond, new NetInterface[]{new NetInterface(new AADLBus())});
		setSemanticObject(proc);

		// Not worrying about site architecture
		this.powerRequirement = 0.0;
		this.spaceRequirement = 0.0;
	}

	/** Get the AADL processor component instance represented by this object. */
	public ComponentInstance getProcessor() {
		return (ComponentInstance) getSemanticObject();
	}

	public static AADLProcessor createInstance(final ComponentInstance proc) {
		return createInstance(proc,1);
	}

	public static AADLProcessor createInstance(final ComponentInstance proc, int processorMultiplier) {
		final Scheduler scheduler = getScheduler(proc);
		if (scheduler != null) {
			double cycleTimeSecs = GetProperties.getCycleTimeinSec(proc);
			double doubleMultiplier = processorMultiplier * 1.0;
			final double cyclesPerSecond = (1.0 / cycleTimeSecs) * doubleMultiplier; //* processorMultiplier;
			return new AADLProcessor(proc, scheduler, cyclesPerSecond);
		} else {
			return null;
		}
	}

	private static Scheduler getScheduler(final ComponentInstance proc) {
		final String sched;
		try
		{
			sched = GetProperties.getSchedulingProtocol(proc);
		}
		catch (PropertyNotPresentException e)
		{
			// No scheduler specified, use EDF
			return new EDFScheduler(new BandwidthComparator());
		}
		if (sched == null) {
			// No scheduler specified, use EDF
			return new EDFScheduler(new BandwidthComparator());
		} else {
			// Use the first scheduler in the list
			if (sched.equals(AadlProject.EDF_LITERAL)) {
				return new EDFScheduler(new BandwidthComparator());
			} else if (sched.equals(AadlProject.RMS_LITERAL)) {
				return new RMASchedulerNew();
			} else {
				return null;
			}
		}
	}
}