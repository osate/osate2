package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

public class SubcomponentUtil {
	private static final LinkedHashMap<EClass, String> subcomponentTypeToCreateMethodNameMap = new LinkedHashMap<EClass, String>();
	
	/**
	 * Populate the map that contains the subcomponent type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		subcomponentTypeToCreateMethodNameMap.put(p.getAbstractSubcomponent(), "createOwnedAbstractSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getBusSubcomponent(), "createOwnedBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDataSubcomponent(), "createOwnedDataSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDeviceSubcomponent(), "createOwnedDeviceSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getMemorySubcomponent(), "createOwnedMemorySubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessSubcomponent(), "createOwnedProcessSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessorSubcomponent(), "createOwnedProcessorSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramSubcomponent(), "createOwnedSubprogramSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramGroupSubcomponent(), "createOwnedSubprogramGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSystemSubcomponent(), "createOwnedSystemSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadSubcomponent(), "createOwnedThreadSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadGroupSubcomponent(), "createOwnedThreadGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualBusSubcomponent(), "createOwnedVirtualBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualProcessorSubcomponent(), "createOwnedVirtualProcessorSubcomponent");
	}
	
	public static Collection<EClass> getSubcomponentTypes() {
		return subcomponentTypeToCreateMethodNameMap.keySet();
	}
	
	/**
	 * Returns whether the specified component implementation supports subcomponents of the specified type
	 * @param subcomponentOwner
	 * @param subcomponentClass
	 * @return
	 */
	public static boolean canContainSubcomponentType(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		return getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass) != null;
	}
	
	private static Method getSubcomponentCreateMethod(final ComponentImplementation subcomponentOwner, final EClass subcomponentType) {
		// Determine the method name of the type of subcomponent
		final String methodName = subcomponentTypeToCreateMethodNameMap.get(subcomponentType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = subcomponentOwner.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
	public static Subcomponent createSubcomponent(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		try {
			return (Subcomponent)getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass).invoke(subcomponentOwner);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
