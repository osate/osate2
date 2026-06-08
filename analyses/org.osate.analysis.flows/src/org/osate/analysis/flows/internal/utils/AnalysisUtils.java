/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
