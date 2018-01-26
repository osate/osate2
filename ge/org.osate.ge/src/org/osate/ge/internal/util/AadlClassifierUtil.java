package org.osate.ge.internal.util;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.query.Queryable;

public class AadlClassifierUtil {
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

	public static EClass getComponentTypeEClass(final ComponentCategory cc) {
		Objects.requireNonNull(cc, "cc must not be null");

		final Aadl2Package p = Aadl2Package.eINSTANCE;

		switch (cc) {
		case ABSTRACT:
			return p.getAbstractType();

		case BUS:
			return p.getBusType();

		case DATA:
			return p.getDataType();

		case DEVICE:
			return p.getDeviceType();

		case MEMORY:
			return p.getMemoryType();

		case PROCESS:
			return p.getProcessType();

		case PROCESSOR:
			return p.getProcessorType();

		case SUBPROGRAM:
			return p.getSubprogramType();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupType();

		case SYSTEM:
			return p.getSystemType();

		case THREAD:
			return p.getThreadType();

		case THREAD_GROUP:
			return p.getThreadGroupType();

		case VIRTUAL_BUS:
			return p.getVirtualBusType();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorType();

		default:
			throw new RuntimeException("Unexpected category: " + cc);

		}
	}

	public static EClass getComponentImplementationEClass(final ComponentCategory cc) {
		Objects.requireNonNull(cc, "cc must not be null");

		final Aadl2Package p = Aadl2Package.eINSTANCE;

		switch (cc) {
		case ABSTRACT:
			return p.getAbstractImplementation();

		case BUS:
			return p.getBusImplementation();

		case DATA:
			return p.getDataImplementation();

		case DEVICE:
			return p.getDeviceImplementation();

		case MEMORY:
			return p.getMemoryImplementation();

		case PROCESS:
			return p.getProcessImplementation();

		case PROCESSOR:
			return p.getProcessorImplementation();

		case SUBPROGRAM:
			return p.getSubprogramImplementation();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupImplementation();

		case SYSTEM:
			return p.getSystemImplementation();

		case THREAD:
			return p.getThreadImplementation();

		case THREAD_GROUP:
			return p.getThreadGroupImplementation();

		case VIRTUAL_BUS:
			return p.getVirtualBusImplementation();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorImplementation();

		default:
			throw new RuntimeException("Unexpected category: " + cc);

		}
	}
}
