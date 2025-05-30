/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.aadl2.contrib.util;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.memory.AccessRights;
import org.osate.aadl2.contrib.memory.MemoryProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.pluginsupport.properties.PropertyUtils;

/**
 * @since 1.1
 */
// XXX: Where to put this???
public final class AadlContribUtils {
	private AadlContribUtils() {
		// empty
	}

	private static final Set<ComponentCategory> hasSize = EnumSet.of(ComponentCategory.DATA,
			ComponentCategory.SUBPROGRAM, ComponentCategory.THREAD, ComponentCategory.THREAD_GROUP,
			ComponentCategory.PROCESS, ComponentCategory.SYSTEM, ComponentCategory.PROCESSOR,
			ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS,
			ComponentCategory.DEVICE, ComponentCategory.ABSTRACT);

	public static double getDataSize(final ComponentClassifier ne, final SizeUnits unit) {
		return hasSize.contains(ne.getCategory()) ? getDataSize(ne, unit, 0) : 0;
	}

	public static double getDataSize(final ComponentInstance ne, final SizeUnits unit) {
		return hasSize.contains(ne.getCategory()) ? getDataSize(ne, unit, 0) : 0;
	}

	public static double getDataSize(final FeatureInstance ne, final SizeUnits unit) {
		return getDataSize(ne, unit, 0);
	}

	private static double getDataSize(final NamedElement ne, final SizeUnits unit, final int nesting) {
		final double elementSize = PropertyUtils.getScaled(MemoryProperties::getDataSize, ne, unit)
				.orElseGet(() -> {
					final ComponentCategory cc = ne instanceof ComponentClassifier ? ((ComponentClassifier) ne).getCategory()
							: (ne instanceof ComponentInstance ? ((ComponentInstance) ne).getCategory() : null);
					if (cc != ComponentCategory.BUS && cc != ComponentCategory.VIRTUAL_BUS) {
						return PropertyUtils.getScaled(MemoryProperties::getSourceDataSize, ne, unit).orElse(0.0);
					} else {
						return 0.0;
					}
				});
		final long multiplier = ne instanceof DataSubcomponent ? AadlUtil.getMultiplicity(ne) : 1;
		if (elementSize != 0.0) {
			return elementSize * multiplier;
		} else {
			if ((nesting <= 10) && (ne instanceof DataSubcomponent || ne instanceof DataImplementation)) {
				// mult is one or the array size of the data subcomponent.
				return sumElementsDataSize(ne, unit, nesting + 1) * multiplier;
			} else {
				return 0.0;
			}
		}
	}

	public static double sumElementsDataSize(final NamedElement ne, final SizeUnits unit) {
		return sumElementsDataSize(ne, unit, 0);
	}

	private static double sumElementsDataSize(final NamedElement ne, final SizeUnits unit, final int nesting) {
		double res = 0.0;
		Classifier cl = null;
		if (ne instanceof Classifier) {
			cl = (Classifier) ne;
		} else if (ne instanceof FeatureInstance) {
			cl = ((FeatureInstance) ne).getFeature().getAllClassifier();
		} else if (ne instanceof Feature) {
			cl = ((Feature) ne).getClassifier();
		} else if (ne instanceof DataSubcomponent) {
			cl = ((DataSubcomponent) ne).getClassifier();
		}
		if (cl != null) {
			if (cl instanceof FeatureGroupType) {
				EList<Feature> fl = ((FeatureGroupType) cl).getAllFeatures();
				for (Feature f : fl) {
					res = res + getDataSize(f, unit, nesting);
				}
			} else if (cl instanceof DataImplementation) {
				for (Subcomponent ds : ((DataImplementation) cl).getAllSubcomponents()) {
					if (!AadlUtil.isSameOrExtends(cl, ds.getAllClassifier())) {
						res = res + getDataSize(ds, unit, nesting);
					}
				}
			}
		}
		return res;
	}

	/*
	 * Taken from the old MemoryProperties.getInverseDirection(). The originally version also doesn't work right for byMethod.
	 */
	public static AccessRights getInverseDirection(final AccessRights access) {
		if (access == AccessRights.READ_WRITE) {
			return access;
		} else if (access == AccessRights.READ_ONLY) {
			return AccessRights.WRITE_ONLY;
		} else {
			return AccessRights.READ_ONLY;
		}
	}
}
