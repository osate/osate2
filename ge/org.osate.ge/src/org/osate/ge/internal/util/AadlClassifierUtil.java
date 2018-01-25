package org.osate.ge.internal.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.query.Queryable;

public class AadlClassifierUtil {
	public static Map<EClass, String> getComponentTypes() {
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		map.put(p.getAbstractType(), "createAbstractType");
		map.put(p.getBusType(), "createBusType");
		map.put(p.getDataType(), "createDataType");
		map.put(p.getDeviceType(), "createDeviceType");
		map.put(p.getFeatureGroupType(), "createGroupType");
		map.put(p.getMemoryType(), "createMemoryType");
		map.put(p.getProcessType(), "createProcessType");
		map.put(p.getProcessorType(), "createProcessorType");
		map.put(p.getSubprogramType(), "createSubprogramType");
		map.put(p.getSubprogramGroupType(), "createSubprogramGroupType");
		map.put(p.getSystemType(), "createSystemType");
		map.put(p.getThreadType(), "createThreadType");
		map.put(p.getThreadGroupType(), "createThreadGroupType");
		map.put(p.getVirtualBusType(), "createVirtualBusType");
		map.put(p.getVirtualProcessorType(), "createVirtualProcessorType");
		return map;
	}

	public static Map<EClass, String> getComponentImplementations() {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();
		map.put(p.getAbstractImplementation(), "createAbstractImplementation");
		map.put(p.getBusImplementation(), "createBusImplementation");
		map.put(p.getDataImplementation(), "createDataImplementation");
		map.put(p.getDeviceImplementation(), "createDeviceImplementation");
		map.put(p.getMemoryImplementation(), "createMemoryImplementation");
		map.put(p.getProcessImplementation(), "createProcessImplementation");
		map.put(p.getProcessorImplementation(), "createProcessorImplementation");
		map.put(p.getSubprogramImplementation(), "createSubprogramImplementation");
		map.put(p.getSubprogramGroupImplementation(), "createSubprogramGroupImplementation");
		map.put(p.getSystemImplementation(), "createSystemImplementation");
		map.put(p.getThreadImplementation(), "createThreadImplementation");
		map.put(p.getThreadGroupImplementation(), "createThreadGroupImplementation");
		map.put(p.getVirtualBusImplementation(), "createVirtualBusImplementation");
		map.put(p.getVirtualProcessorImplementation(), "createVirtualProcessorImplementation");
		return map;
	}

	/**
	 * Returns a component implementation for a specified business object. Only component implementations and subcomponents are supported.
	 * @param bo
	 * @return
	 */
	public static Optional<ComponentImplementation> getComponentImplementation(final Object bo) {
		final ComponentImplementation ci;
		if (bo instanceof Queryable) {
			return getComponentImplementation(((Queryable) bo).getBusinessObject());
		} else if (bo instanceof ComponentImplementation) {
			ci = (ComponentImplementation) bo;
		} else if (bo instanceof Subcomponent) {
			final Classifier scClassifier = ((Subcomponent) bo).getAllClassifier();
			ci = scClassifier instanceof ComponentImplementation ? (ComponentImplementation) scClassifier : null;
		} else {
			ci = null;
		}

		return Optional.ofNullable(ci);
	}
}
