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

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
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

	/**
	 * Returns a component classifier for a specified business object. Only component implementations and subcomponents are supported.
	 * @param bo
	 * @return
	 */
	public static Optional<ComponentClassifier> getComponentClassifier(final Object bo) {
		final ComponentClassifier ci;

		if (bo instanceof Queryable) {
			return getComponentClassifier(((Queryable) bo).getBusinessObject());
		} else if (bo instanceof ComponentImplementation) {
			ci = (ComponentImplementation) bo;
		} else if (bo instanceof Subcomponent) {
			final ComponentClassifier scClassifier = ((Subcomponent) bo).getAllClassifier();
			ci = scClassifier instanceof ComponentClassifier ? scClassifier : null;
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

	private static EClass componentCategoryToClassifierEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case SYSTEM:
			return p.getSystemClassifier();

		case PROCESS:
			return p.getProcessClassifier();

		case THREAD_GROUP:
			return p.getThreadGroupClassifier();

		case THREAD:
			return p.getThreadClassifier();

		case SUBPROGRAM:
			return p.getSubprogramClassifier();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupClassifier();

		case DATA:
			return p.getDataClassifier();

		case ABSTRACT:
			return p.getAbstractClassifier();

		case VIRTUAL_BUS:
			return p.getVirtualBusClassifier();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorClassifier();

		case BUS:
			return p.getBusClassifier();

		case PROCESSOR:
			return p.getProcessorClassifier();

		case DEVICE:
			return p.getDeviceClassifier();

		case MEMORY:
			return p.getMemoryClassifier();

		default:
			throw new RuntimeException("Unexpected category: " + category);
		}
	}

	/**
	 * Return a set of IEObjectDescriptions for classifiers that would be valid "base" classifier for a new classifier of the specified component category.
	 * A "base" classifier is one that will be implemented or extended.
	 */
	public static Set<IEObjectDescription> getValidBaseClassifierDescriptions(final IProject project,
			final ComponentCategory componentCategory, boolean includeImplementations) {
		final EClass classifierClass = componentCategoryToClassifierEClass(componentCategory);
		final Set<IEObjectDescription> objectDescriptions = new HashSet<IEObjectDescription>();
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project,
				Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier())) {
			// Add objects that have are either types or implementations of the same category as the classifier type
			if (classifierClass.isSuperTypeOf(desc.getEClass()) && (includeImplementations || !Aadl2Factory.eINSTANCE
					.getAadl2Package().getComponentImplementation().isSuperTypeOf(desc.getEClass()))) {
				objectDescriptions.add(desc);
			}
		}

		return objectDescriptions;
	}

}
