package org.osate.aadl2.contrib.util;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.memory.MemoryProperties;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.pluginsupport.properties.PropertyUtils;

/**
 * @since 1.1
 */
public final class AadlContribUtils {
	private AadlContribUtils() {
		// empty
	}

	public static double getDataSize(final NamedElement ne, final SizeUnits unit) {
		return getDataSize(ne, unit, 0);
	}

	private static double getDataSize(final NamedElement ne, final SizeUnits unit, final int nesting) {
		final double elementSize = PropertyUtils.getScaled(MemoryProperties::getDataSize, ne, unit)
				.orElseGet(() -> PropertyUtils.getScaled(MemoryProperties::getSourceDataSize, ne, unit).orElse(0.0));
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
}
