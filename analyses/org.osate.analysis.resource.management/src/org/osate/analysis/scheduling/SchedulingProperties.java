package org.osate.analysis.scheduling;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.contrib.timing.TimingProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.properties.util.InstanceModelUtil;
import org.osate.contribution.sei.sei.Instructionvolumeunits;
import org.osate.contribution.sei.sei.ProcessorSpeedUnits;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.PropertyUtils;
import org.osate.pluginsupport.properties.RealRange;

/**
 * Methods yanked from the old {@code org.osate.xtext.aadl2.properties.util.GetProperties}
 * that are only relevant to the scheduling algorithms.  Updated to use the new
 * property getter methods.
 *
 * @since 4.1
 */
public final class SchedulingProperties {
	private SchedulingProperties() {
		super();
	}

	/**
	 * compute Execution time for actual processor from instructions per
	 * dispatch; or based on specified execution time
	 *
	 * @param threadinstance
	 *            thread instance
	 * @return double scaled execution time in Sec
	 */
	public static double getThreadExecutioninMilliSec(ComponentInstance threadinstance) {
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		double actualProcMips = getBoundProcessorMIPS(threadinstance);
		if (mipd > 0 && actualProcMips > 0) {
			// adjust from sec to milli sec
			return (mipd / actualProcMips) * 1000;
		}
		return getScaledMaxComputeExecutionTimeinMilliSec(threadinstance);
	}

	/**
	 * compute MIPS for thread based on instructions per dispatch; or based on
	 * specified execution time
	 *
	 * @param threadinstance
	 *            thread instance
	 * @return MIPS or 0.0
	 */
	public static double getThreadExecutioninMIPS(ComponentInstance threadinstance) {
		if (!InstanceModelUtil.isThread(threadinstance)) {
			return 0;
		}
		double mips = getThreadExecutionIPDinMIPS(threadinstance);
		if (mips == 0) {
			double period = getPeriodInSeconds(threadinstance, 0.0);
			double exectimeval = getMaximumComputeExecutionTimeinSec(threadinstance);
			if (exectimeval > 0 && period > 0) {
				double mipspersec = getReferenceMIPS(threadinstance);
				if (mipspersec == 0) {
					mipspersec = getBoundPhysicalProcessorMIPS(threadinstance);
				}
				double time = exectimeval / period;
				mips = time * mipspersec;
			}
		}
		return mips;
	}

	private static double getThreadExecutionIPDinMIPS(ComponentInstance threadinstance) {
		double period = getPeriodInSeconds(threadinstance, 0.0);
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		if (mipd > 0 && period > 0) {
			double mips = mipd / period;
			return mips;
		}
		return 0.0;
	}

	/**
	 * @author: Dionisio de Niz
	 *
	 *          For now we will use MIPS as a representative of cycles per
	 *          second but we will change it to a more meaningful property name
	 *
	 * @param threadInstance
	 * @return execution time in cyles
	 */
	public static double getThreadExecutionInCycles(ComponentInstance threadInstance, double defaultMIPS) {
		double cycles = 0.0;
		double exectimeval = getMaximumComputeExecutionTimeinSec(threadInstance);
		double mipspersec = getReferenceMIPS(threadInstance);
		if (mipspersec == 0) {
			mipspersec = defaultMIPS;
		}
		cycles = exectimeval * (mipspersec * 1e6);
		return cycles;
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

	public static double getScaledMaxComputeExecutionTimeinMilliSec(final NamedElement ne) {
		return scaleTime(PropertyUtils.getScaledRange(
				TimingProperties::getComputeExecutionTime, ne,
				TimeUnits.MS).orElse(RealRange.ZEROED).getMaximum(), ne);
	}

	public static Classifier getReferenceProcessor(final NamedElement ne) {
		return TimingProperties.getReferenceProcessor(ne).orElse(null);
	}

	/**
	 * Get the MIPS per sec of the reference processor. First tries to find the
	 * MIPS capacity. It then tries an explicit reference processor. If it finds
	 * it, then it gets the cycle time of that processor.
	 */
	public static double getReferenceMIPS(final ComponentInstance thread) {
		final Classifier pci = getReferenceProcessor(thread);
		return pci == null ? 0.0 : getMIPSCapacityInMIPS(pci, 0.0);
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		return PropertyUtils.getScaled(Sei::getMipscapacity, ne, ProcessorSpeedUnits.MIPS).
				orElseGet(() -> PropertyUtils.getScaled(
						TimingProperties::getProcessorCapacity, ne,
						org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits.MIPS).orElse(defaultValue));
	}

	public static List<InstanceObject> getActualProcessorBinding(final ComponentInstance io) {
		return DeploymentProperties.getActualProcessorBinding(io).orElse(Collections.emptyList());
	}

	private static double getPeriodInSeconds(final NamedElement ne, final double defaultValue) {
		return PropertyUtils.getScaled(TimingProperties::getPeriod, ne, TimeUnits.SEC)
				.orElse(defaultValue);
	}

	private static double scaleTime(final double time, final NamedElement ne) {
		ComponentInstance ci = null;
		if (ne instanceof FeatureInstance) {
			ci = ((FeatureInstance) ne).getComponentInstance();
		} else if (ne instanceof ComponentInstance) {
			ci = (ComponentInstance) ne;
		}

		if (ci != null) {
			double scale = getProcessorScalingFactor(ci);
			return time * scale;
		} else {
			return time;
		}
	}

	private static double getProcessorScalingFactor(final ComponentInstance thread) {
		double refmipspersec = getReferenceMIPS(thread);
		double mipspersec = getBoundPhysicalProcessorMIPS(thread);
		if (refmipspersec == 0 || mipspersec == 0) {
			return 1;
		}
		return refmipspersec / mipspersec;
	}

	/**
	 * get specified instructions per dispatch as MIPD
	 *
	 * @param ne
	 *            thread component instance
	 * @return double MIPD
	 */
	private static double getSpecifiedThreadInstructionsinMIPD(final NamedElement ne) {
		return PropertyUtils.getScaledRange(Sei::getInstructionsperdispatch, ne, Instructionvolumeunits.MIPD)
				.orElse(RealRange.ZEROED)
				.getMaximum();
	}

	/**
	 * Get the MIPS capacity of the bound processor.
	 */
	private static double getBoundProcessorMIPS(final ComponentInstance thread) {
		final List<InstanceObject> pciList = DeploymentProperties.getActualProcessorBinding(thread)
				.orElse(Collections.emptyList());
		if (pciList.isEmpty()) {
			return 0.0;
		} else {
			return getMIPSCapacityInMIPS(pciList.get(0), 0);
		}
	}

	private static double getMaximumComputeExecutionTimeinSec(final NamedElement ne) {
		return PropertyUtils.getScaledRange(TimingProperties::getComputeExecutionTime, ne, TimeUnits.SEC)
				.orElse(RealRange.ZEROED)
				.getMaximum();
	}
}
