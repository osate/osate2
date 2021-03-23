package org.osate.analysis.flows.internal.utils;

import java.util.Iterator;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.contribution.sei.sei.ProcessorSpeedUnits;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.RealRange;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/* XXX Not sure where to put this yet.
 *
 * Rewritten refuges from GetProperties
 *
 */
public final class AnalysisUtils {
	private AnalysisUtils() {
		// empty
	}

	public static RealRange scaleTimeRange(final RealRange time, final NamedElement ne) {
		ComponentInstance ci = null;
		if (ne instanceof FeatureInstance) {
			ci = ((FeatureInstance) ne).getComponentInstance();
		} else if (ne instanceof ComponentInstance) {
			ci = (ComponentInstance) ne;
		}

		if (ci != null) {
			double scale = getProcessorScalingFactor(ci);
			return new RealRange(time.getMinimum() * scale, time.getMaximum() * scale);
		} else {
			return time;
		}
	}

	/**
	 * calculate the scaling factor from the MIPSCapacity of the two processors.
	 * The default value is 1
	 *
	 * @param thread
	 * @return double scaling factor of processor speed
	 */
	public static double getProcessorScalingFactor(final ComponentInstance thread) {
		double refmipspersec = getReferenceMIPS(thread);
		double mipspersec = getBoundPhysicalProcessorMIPS(thread);
		if (refmipspersec == 0 || mipspersec == 0) {
			return 1;
		}
		return refmipspersec / mipspersec;
	}

	/**
	 * Get the MIPS per sec of the reference processor. First tries to find the
	 * MIPS capacity. It then tries an explicit reference processor. If it finds
	 * it, then it gets the cycle time of that processor.
	 */
	public static double getReferenceMIPS(final ComponentInstance thread) {
		return org.osate.aadl2.contrib.timing.TimingProperties.getReferenceProcessor(thread)
				.map(refProcClassifier -> getMIPSCapacityInMIPS(refProcClassifier, 0.0)).orElse(0.0);
	}

	/**
	 * Get the MIPS per sec of the bound physical processor. The MIPS
	 * capacity of the bound physical processor
	 */
	public static double getBoundPhysicalProcessorMIPS(final ComponentInstance thread) {
		Iterator<ComponentInstance> pcis = InstanceModelUtil.getBoundPhysicalProcessors(thread).iterator();
		if (pcis.hasNext()) {
			return getMIPSCapacityInMIPS(pcis.next(), 0);
		}
		return 0.0;
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		return org.osate.pluginsupport.properties.PropertyUtils
				.getScaled(Sei::getMipscapacity, ne, ProcessorSpeedUnits.MIPS).orElseGet(
						() -> org.osate.pluginsupport.properties.PropertyUtils
								.getScaled(org.osate.aadl2.contrib.timing.TimingProperties::getProcessorCapacity, ne,
										org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits.MIPS)
								.orElse(defaultValue));
	}
}
