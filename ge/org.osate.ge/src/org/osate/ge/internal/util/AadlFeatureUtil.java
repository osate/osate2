package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;

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
	private static LinkedHashMap<EClass, String> featureTypeToCreateMethodNameMap = new LinkedHashMap<EClass, String>();
	/**
	 * Populate the map that contains the feature type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		
		// Regular Features
		featureTypeToCreateMethodNameMap.put(p.getAbstractFeature(), "createOwnedAbstractFeature");
		featureTypeToCreateMethodNameMap.put(p.getBusAccess(), "createOwnedBusAccess");
		featureTypeToCreateMethodNameMap.put(p.getDataAccess(), "createOwnedDataAccess");
		featureTypeToCreateMethodNameMap.put(p.getDataPort(), "createOwnedDataPort");
		featureTypeToCreateMethodNameMap.put(p.getEventDataPort(), "createOwnedEventDataPort");
		featureTypeToCreateMethodNameMap.put(p.getEventPort(), "createOwnedEventPort");
		featureTypeToCreateMethodNameMap.put(p.getFeatureGroup(), "createOwnedFeatureGroup");
		featureTypeToCreateMethodNameMap.put(p.getParameter(), "createOwnedParameter");
		featureTypeToCreateMethodNameMap.put(p.getSubprogramAccess(), "createOwnedSubprogramAccess");
		featureTypeToCreateMethodNameMap.put(p.getSubprogramGroupAccess(), "createOwnedSubprogramGroupAccess");
		
		// Internal Features
		featureTypeToCreateMethodNameMap.put(p.getEventSource(), "createOwnedEventSource");
		featureTypeToCreateMethodNameMap.put(p.getEventDataSource(), "createOwnedEventDataSource");
		
		// Processor Features
		featureTypeToCreateMethodNameMap.put(p.getSubprogramProxy(), "createOwnedSubprogramProxy");
		featureTypeToCreateMethodNameMap.put(p.getPortProxy(), "createOwnedPortProxy");
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
