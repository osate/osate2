package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ge.BusinessObjectContext;

public class AadlFeatureUtil {
	private final static Map<EClass, String> featureTypeToCreateMethodNameMap = createFeatureTypeToCreateMethodMap();

	/**
	 * Returns an unmodifiable map that contains the feature type to create method name mapping
	 */
	private static Map<EClass, String> createFeatureTypeToCreateMethodMap() {
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();

		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		// Regular Features
		map.put(p.getAbstractFeature(), "createOwnedAbstractFeature");
		map.put(p.getBusAccess(), "createOwnedBusAccess");
		map.put(p.getDataAccess(), "createOwnedDataAccess");
		map.put(p.getDataPort(), "createOwnedDataPort");
		map.put(p.getEventDataPort(), "createOwnedEventDataPort");
		map.put(p.getEventPort(), "createOwnedEventPort");
		map.put(p.getFeatureGroup(), "createOwnedFeatureGroup");
		map.put(p.getParameter(), "createOwnedParameter");
		map.put(p.getSubprogramAccess(), "createOwnedSubprogramAccess");
		map.put(p.getSubprogramGroupAccess(), "createOwnedSubprogramGroupAccess");

		// Internal Features
		map.put(p.getEventSource(), "createOwnedEventSource");
		map.put(p.getEventDataSource(), "createOwnedEventDataSource");

		// Processor Features
		map.put(p.getSubprogramProxy(), "createOwnedSubprogramProxy");
		map.put(p.getPortProxy(), "createOwnedPortProxy");

		return Collections.unmodifiableMap(map);
	}

	public static Collection<EClass> getFeatureTypes() {
		return featureTypeToCreateMethodNameMap.keySet();
	}

	public static NamedElement createFeature(final Classifier featureOwner, final EClass featureClass) {
		try {
			return (NamedElement)getFeatureCreateMethod(featureOwner, featureClass).invoke(featureOwner);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean canOwnFeatureType(final Classifier featureOwner, final EClass featureType) {
		return getFeatureCreateMethod(featureOwner, featureType) != null &&
				(!isProcessorFeatureType(featureType) || canOwnProcessorFeatures(featureOwner));
	}

	private static Method getFeatureCreateMethod(final Classifier featureOwner, final EClass featureType) {
		// Determine the method name for the type of feature
		final String methodName = featureTypeToCreateMethodNameMap.get(featureType);
		if(methodName == null) {
			return null;
		}

		// Get the method
		try {
			final Method method = featureOwner.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}

	private static boolean canOwnProcessorFeatures(final Object bo) {
		return bo instanceof SystemImplementation ||
				bo instanceof ProcessImplementation ||
				bo instanceof ThreadGroupImplementation ||
				bo instanceof ThreadImplementation ||
				bo instanceof DeviceImplementation ||
				bo instanceof VirtualProcessorImplementation;
	}

	private static boolean isProcessorFeatureType(final EClass t) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return p.getProcessorFeature().isSuperTypeOf(t);
	}

	/**
	 * Returns all the features owned by the feature group type or the type it extends. It does not return features from the inverse and in the case of refined features,
	 * only returns the refined feature.
	 * @param fgt
	 * @return
	 */
	private static EList<Feature> getAllOwnedFeatures(final FeatureGroupType fgt) {
		final EList<Feature> features = new BasicEList<Feature>();
		FeatureGroupType temp = fgt;
		while(temp != null) {
			boolean wasRefined = false;
			for(final Feature newFeature : temp.getOwnedFeatures()) {
				for(final Feature existingFeature : features) {
					if(existingFeature.getRefined() == newFeature) {
						wasRefined = true;
					}
				}

				if(!wasRefined) {
					features.add(newFeature);
				}
			}
			temp = temp.getExtended();
		}

		return features;
	}

	public static EList<Feature> getAllDeclaredFeatures(final Classifier classifier) {
		if(classifier instanceof FeatureGroupType) {
			return getAllOwnedFeatures((FeatureGroupType)classifier);
		}

		return classifier.getAllFeatures();
	}

	public static EList<Feature> getAllFeatures(final FeatureGroupType fgt) {
		final EList<Feature> owned = getAllOwnedFeatures(fgt);
		final FeatureGroupType inverseFgt = fgt.getInverse();
		if (owned.isEmpty() && !Aadl2Util.isNull(inverseFgt)) {
			return getAllOwnedFeatures(inverseFgt);
		}

		return owned;
	}

	public static boolean isFeatureInverted(final BusinessObjectContext featureBoc) {
		final BusinessObjectContext parent = featureBoc.getParent();
		if(parent == null) {
			return false;
		}

		return isFeatureInvertedByContainer(parent);
	}

	private static boolean isFeatureInvertedByContainer(final BusinessObjectContext featureParentBoc) {
		boolean isInverted = false;

		BusinessObjectContext parent = featureParentBoc;
		while(parent != null) {
			final Object parentBo = parent.getBusinessObject();
			if(parentBo instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)parentBo;
				isInverted ^= fg.isInverse();

				// This feature group type is not necessarily the one that owned the feature... Could be inverse.. Could be refined, etc..
				// Check if the feature group type was implicitly defined via an inverse
				final FeatureGroupType fgt = getFeatureGroupType(parent, fg);
				if(fgt != null && getAllOwnedFeatures(fgt).isEmpty() && !Aadl2Util.isNull(fgt.getInverse())) {
					isInverted = !isInverted;
				}
			}

			parent = parent.getParent();
		}

		return isInverted;
	}

	// Prototype Related Methods
	public static FeatureGroupType getFeatureGroupType(BusinessObjectContext boc, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			return AadlPrototypeUtil.getFeatureGroupType(AadlPrototypeUtil.getPrototypeBindingContext(boc), fg);
		}
	}
}
