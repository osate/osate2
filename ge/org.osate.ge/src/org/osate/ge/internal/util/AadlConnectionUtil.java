package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;

public class AadlConnectionUtil {
	private final static Map<EClass, String> connectionTypeToMethodNameMap = createConnectionTypeToMethodMap();
	
	/**
	 * Returns an unmodifiable map that contains the connection type to create method name mapping
	 */
	private static Map<EClass,String> createConnectionTypeToMethodMap() {
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		map.put(p.getAccessConnection(), "createOwnedAccessConnection");
		map.put(p.getFeatureConnection(), "createOwnedFeatureConnection");
		map.put(p.getFeatureGroupConnection(), "createOwnedFeatureGroupConnection");
		map.put(p.getParameterConnection(), "createOwnedParameterConnection");
		map.put(p.getPortConnection(), "createOwnedPortConnection");
		
		return Collections.unmodifiableMap(map);
	}
	
	public static Collection<EClass> getConnectionTypes() {
		return connectionTypeToMethodNameMap.keySet();
	}
	
	public static org.osate.aadl2.Connection createConnection(final ComponentImplementation ci, final EClass connectionClass) {
		try {
			return (org.osate.aadl2.Connection)getConnectionCreateMethod(ci, connectionClass).invoke(ci);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Method getConnectionCreateMethod(final ComponentImplementation ci, final EClass connectionType) {
		// Determine the method name for the type of feature
		final String methodName = connectionTypeToMethodNameMap.get(connectionType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = ci.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
}
