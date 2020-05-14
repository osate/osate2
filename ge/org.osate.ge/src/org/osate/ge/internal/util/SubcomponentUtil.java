/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DeviceSubcomponentType;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.MemorySubcomponentType;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessSubcomponentType;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorSubcomponentType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemSubcomponentType;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponentType;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadSubcomponentType;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualBusSubcomponentType;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponentType;

public class SubcomponentUtil {
	private static final Map<EClass, String> subcomponentTypeToCreateMethodNameMap = createSubcomponentTypeToMethodMap();

	/**
	 * Returns an unmodifiable map that contains the subcomponent type to create method name mapping
	 */
	private static Map<EClass,String> createSubcomponentTypeToMethodMap() {
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		map.put(p.getAbstractSubcomponent(), "createOwnedAbstractSubcomponent");
		map.put(p.getBusSubcomponent(), "createOwnedBusSubcomponent");
		map.put(p.getDataSubcomponent(), "createOwnedDataSubcomponent");
		map.put(p.getDeviceSubcomponent(), "createOwnedDeviceSubcomponent");
		map.put(p.getMemorySubcomponent(), "createOwnedMemorySubcomponent");
		map.put(p.getProcessSubcomponent(), "createOwnedProcessSubcomponent");
		map.put(p.getProcessorSubcomponent(), "createOwnedProcessorSubcomponent");
		map.put(p.getSubprogramSubcomponent(), "createOwnedSubprogramSubcomponent");
		map.put(p.getSubprogramGroupSubcomponent(), "createOwnedSubprogramGroupSubcomponent");
		map.put(p.getSystemSubcomponent(), "createOwnedSystemSubcomponent");
		map.put(p.getThreadSubcomponent(), "createOwnedThreadSubcomponent");
		map.put(p.getThreadGroupSubcomponent(), "createOwnedThreadGroupSubcomponent");
		map.put(p.getVirtualBusSubcomponent(), "createOwnedVirtualBusSubcomponent");
		map.put(p.getVirtualProcessorSubcomponent(), "createOwnedVirtualProcessorSubcomponent");

		return Collections.unmodifiableMap(map);
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

	public static void setClassifier(final Subcomponent sc, final SubcomponentType selectedSubcomponentType) {
		// Import as necessary
		if (selectedSubcomponentType != null) {
			// Import its package if necessary
			final AadlPackage pkg = (AadlPackage) sc.getElementRoot();
			if (selectedSubcomponentType instanceof ComponentClassifier
					&& selectedSubcomponentType.getNamespace() != null && pkg != null) {
				final PackageSection section = pkg.getPublicSection();
				final AadlPackage selectedClassifierPkg = (AadlPackage) selectedSubcomponentType.getNamespace()
						.getOwner();
				if (selectedClassifierPkg != null && pkg != selectedClassifierPkg) {
					AadlImportsUtil.addImportIfNeeded(section, selectedClassifierPkg);
				}
			}
		}

		if (sc instanceof SystemSubcomponent) {
			((SystemSubcomponent) sc).setSystemSubcomponentType((SystemSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent) sc)
			.setAbstractSubcomponentType((AbstractSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ThreadGroupSubcomponent) {
			((ThreadGroupSubcomponent) sc)
			.setThreadGroupSubcomponentType((ThreadGroupSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ThreadSubcomponent) {
			((ThreadSubcomponent) sc).setThreadSubcomponentType((ThreadSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof SubprogramSubcomponent) {
			((SubprogramSubcomponent) sc)
			.setSubprogramSubcomponentType((SubprogramSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof SubprogramGroupSubcomponent) {
			((SubprogramGroupSubcomponent) sc)
			.setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof DataSubcomponent) {
			((DataSubcomponent) sc).setDataSubcomponentType((DataSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof AbstractSubcomponent) {
			((AbstractSubcomponent) sc)
			.setAbstractSubcomponentType((AbstractSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof VirtualBusSubcomponent) {
			((VirtualBusSubcomponent) sc)
			.setVirtualBusSubcomponentType((VirtualBusSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof VirtualProcessorSubcomponent) {
			((VirtualProcessorSubcomponent) sc)
			.setVirtualProcessorSubcomponentType((VirtualProcessorSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof BusSubcomponent) {
			((BusSubcomponent) sc).setBusSubcomponentType((BusSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ProcessSubcomponent) {
			((ProcessSubcomponent) sc).setProcessSubcomponentType((ProcessSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof ProcessorSubcomponent) {
			((ProcessorSubcomponent) sc)
			.setProcessorSubcomponentType((ProcessorSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof DeviceSubcomponent) {
			((DeviceSubcomponent) sc).setDeviceSubcomponentType((DeviceSubcomponentType) selectedSubcomponentType);
		} else if (sc instanceof MemorySubcomponent) {
			((MemorySubcomponent) sc).setMemorySubcomponentType((MemorySubcomponentType) selectedSubcomponentType);
		} else {
			throw new RuntimeException("Unexpected type: " + sc.getClass().getName());
		}
	}
}
