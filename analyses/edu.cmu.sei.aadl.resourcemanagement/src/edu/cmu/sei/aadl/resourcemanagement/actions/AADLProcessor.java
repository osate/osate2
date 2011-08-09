/* Created on Oct 18, 2004
 */
package edu.cmu.sei.aadl.resourcemanagement.actions;

import java.util.List;

import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.NetInterface;
import EAnalysis.BinPacking.Processor;
import EAnalysis.BinPacking.Scheduler;
import edu.cmu.sei.aadl.aadl2.EnumerationValue;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.aadl2.properties.PropertyNotPresentException;
import edu.cmu.sei.osate.workspace.names.standard.AadlProject;
import edu.cmu.sei.timeweaver.binpacking.rma.RMASchedulerNew;

/**
 * Processor representing an AADL Processor instance. Instances are created
 * using the <code>static</code> factory method
 * {@link #createInstance(ComponentInstance)}.
 *
 * @author aarong
 */
public final class AADLProcessor extends Processor {
	// 10 picoseconds
	public static final double DEFAULT_CYCLE_TIME = 1.0e-12;

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
		super("PROTOTYPE", new EDFScheduler(new BandwidthComparator()), 1/DEFAULT_CYCLE_TIME);
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
		super(proc.getName(), sched, cyclesPerSecond, new NetInterface[]{new NetInterface(new AADLBus(1000.0))});
		setSemanticObject(proc);

		// Not worrying about site architecture
		this.powerRequirement = 0.0;
		this.spaceRequirement = 0.0;
	}

	/** Get the AADL processor component instance represented by this object. */
	public ComponentInstance getProcessor() {
		return (ComponentInstance) getSemanticObject();
	}

	public static AADLProcessor createInstance(final ComponentInstance proc, BinpackProperties properties) {
		return createInstance(proc,1, properties);
	}

	public static AADLProcessor createInstance(final ComponentInstance proc, int processorMultiplier, BinpackProperties properties) {
		final Scheduler scheduler = getScheduler(proc, properties);
		if (scheduler != null) {
			double cycleTimeSecs = getCycleTime(proc, properties);
			double doubleMultiplier = processorMultiplier * 1.0;
			final double cyclesPerSecond = (1.0 / cycleTimeSecs) * doubleMultiplier; //* processorMultiplier;
			return new AADLProcessor(proc, scheduler, cyclesPerSecond);
		} else {
			return null;
		}
	}

	private static Scheduler getScheduler(final ComponentInstance proc, BinpackProperties properties) {
		final List sList;
		try
		{
			sList = properties.getSchedulingProtocol(proc);
		}
		catch (PropertyNotPresentException e)
		{
			// No scheduler specified, use EDF
			return new EDFScheduler(new BandwidthComparator());
		}
		if (sList.isEmpty()) {
			// No scheduler specified, use EDF
			return new EDFScheduler(new BandwidthComparator());
		} else {
			// Use the first scheduler in the list
			final EnumerationValue schVal = (EnumerationValue) sList.get(0);
			final String schName = schVal.getLiteral().getName();
			if (schName.equals(AadlProject.EDF_LITERAL)) {
				return new EDFScheduler(new BandwidthComparator());
			} else if (schName.equals(AadlProject.RMS_LITERAL)) {
				return new RMASchedulerNew();
			} else {
				return null;
			}
		}
	}

	private static double getCycleTime(final ComponentInstance proc, BinpackProperties properties) {
		return properties.getCycleTime(proc, DEFAULT_CYCLE_TIME);
	}
}