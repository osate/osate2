package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.VirtualProcessorImplementation;

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
}
