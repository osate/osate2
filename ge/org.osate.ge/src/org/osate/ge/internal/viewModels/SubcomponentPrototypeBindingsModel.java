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
package org.osate.ge.internal.viewModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeaturePrototypeActual;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.SubcomponentUtil;
import org.osate.ge.swt.classifiers.PrototypeBindingsModel;

import com.google.common.base.Strings;

/**
 * {@link PrototypeBindingsModel} implementation for editing the classifier and prototype bindings of a subcomponent.
 */
public class SubcomponentPrototypeBindingsModel
extends BusinessObjectSelectionPrototypeBindingsModel {
	public SubcomponentPrototypeBindingsModel(BusinessObjectSelection bos) {
		super(bos);
	}

	@Override
	protected void loadData() {
		final List<Subcomponent> scs = getBusinessObjectSelection().boStream(Subcomponent.class)
				.collect(Collectors.toList());

		// Don't load data if nothing is selected
		if (scs.isEmpty()) {
			return;
		}

		final Subcomponent sc = scs.get(0);

		final Iterator<SubcomponentType> subcomponentTypes = scs.stream()
				.map(SubcomponentPrototypeBindingsModel::getAllSubcomponentType).iterator();

		final SubcomponentType st = subcomponentTypes.next();

		if (scs.size() > 1) {
			// Check whether there are multiple distinct subcomponent types used. If there are, then set the multiple values value and return.
			while (subcomponentTypes.hasNext()) {
				if (st != subcomponentTypes.next()) {
					setMultipleValues(true);
					return;
				}
			}

			// Check if prototype bindings are unique and return and set multipleValues flag if they are not.
			final String bindings = buildComparisonString(sc.getOwnedPrototypeBindings());
			for (int i = 1; i < scs.size(); i++) {
				if (!Objects.equals(bindings, buildComparisonString(scs.get(1).getOwnedPrototypeBindings()))) {
					setMultipleValues(true);
					return;
				}
			}
		}

		PrototypeBindingsModelNode parent = null;
		data(parent).bo = sc;
		setNodeDataClassifier(parent, st);
		loadBindingData(parent, sc.getOwnedPrototypeBindings());
	}

	private static void addQualfiedNameIfNamedElement(final StringBuilder sb, final EObject o) {
		if (o instanceof NamedElement) {
			sb.append(Strings.nullToEmpty(((NamedElement) o).getQualifiedName()));
		}
	}

	private String getPrototypeName(final PrototypeBinding binding) {
		if (binding == null) {
			return "";
		}

		final Prototype prototype = binding.getFormal();
		if (prototype == null) {
			return "";
		}

		return Strings.nullToEmpty(prototype.getName());
	}

	@Override
	public Stream<NamedElementOrDescription> getClassifierOptionsForRoot() {
		// Get options which are valid for all selected subcomponents
		final List<Subcomponent> scs = getBusinessObjectSelection().boStream(Subcomponent.class)
				.collect(Collectors.toList());
		if (scs.isEmpty()) {
			return Stream.empty();
		}

		final Iterator<Subcomponent> it = scs.iterator();
		final Subcomponent sc = it.next();
		final List<Object> potentialFeatureClassifiers = new ArrayList<>(getPotentialSubcomponentTypes(sc));
		while (it.hasNext()) {
			potentialFeatureClassifiers.retainAll(getPotentialSubcomponentTypes(it.next()));
		}

		return getPotentialSubcomponentTypes(sc).stream();
	}

	@Override
	protected Stream<Prototype> getReferenceablePrototypes() {
		// Get prototypes available in the selected subcomponent
		final List<Subcomponent> scs = getBusinessObjectSelection().boStream(Subcomponent.class)
				.collect(Collectors.toList());
		if (scs.isEmpty()) {
			return null;
		}

		final Subcomponent sc = scs.iterator().next();
		return sc.getContainingComponentImpl().getAllPrototypes().stream();
	}

	@Override
	public void flush() {
		// Get any subcomponent. Will be used to resolve selected classifier
		final Subcomponent currentSc = getBusinessObjectSelection().boStream(Subcomponent.class).findFirst()
				.orElse(null);
		if (currentSc == null) {
			throw new RuntimeException("Unable to retrieve subcomponent");
		}

		// Get the actual object.
		final NamedElementOrDescription classifier = getClassifier(null);
		EObject classifierValue = classifier == null ? null
				: classifier.getResolvedValue(getResourceSet());

		if (classifierValue != null && !(classifierValue instanceof SubcomponentType)) {
			throw new RuntimeException("Unexpected value: " + classifierValue);
		}

		final SubcomponentType newSubcomponentType = (SubcomponentType) classifierValue;
		getBusinessObjectSelection().modify(Subcomponent.class, sc -> {
			// Set subcomponent type
			SubcomponentUtil.setClassifier(sc, newSubcomponentType);

			// Update prototype bindings
			sc.getOwnedPrototypeBindings().clear();
			createNewBindings(null, newSubcomponentType, sc, sc.getOwnedPrototypeBindings());
		});
	}

	private static SubcomponentType getAllSubcomponentType(Subcomponent sc) {
		SubcomponentType result;
		do {
			result = sc.getSubcomponentType();
			sc = sc.getRefined();
		} while (sc != null && result == null);

		return result;
	}

	/**
	 * Return a list of EObjectDescriptions and NamedElements for potential classifiers for the specified subcomponent
	 * @return
	 */
	private List<NamedElementOrDescription> getPotentialSubcomponentTypes(final Subcomponent sc) {
		final List<NamedElementOrDescription> subcomponentTypes = new ArrayList<>();

		if (sc.eResource() != null) {
			subcomponentTypes.add(null);

			// Populate the list with valid classifier descriptions
			final EClass subcomponentTypeClass = componentCategoryToSubcomponentTypeEClass(sc.getCategory());
			for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(sc.eResource(),
					subcomponentTypeClass)) {
				subcomponentTypes.add(new NamedElementOrDescription(desc));
			}

			// Add any prototypes that are of the appropriate type
			getReferenceablePrototypes().forEachOrdered(p -> {
				if (subcomponentTypeClass.isInstance(p)) {
					subcomponentTypes.add(new NamedElementOrDescription(p));
				}
			});
		}

		return subcomponentTypes;
	}

	private EClass componentCategoryToSubcomponentTypeEClass(final ComponentCategory category) {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();

		switch (category) {
		case SYSTEM:
			return p.getSystemSubcomponentType();

		case PROCESS:
			return p.getProcessSubcomponentType();

		case THREAD_GROUP:
			return p.getThreadGroupSubcomponentType();

		case THREAD:
			return p.getThreadSubcomponentType();

		case SUBPROGRAM:
			return p.getSubprogramSubcomponentType();

		case SUBPROGRAM_GROUP:
			return p.getSubprogramGroupSubcomponentType();

		case DATA:
			return p.getDataSubcomponentType();

		case ABSTRACT:
			return p.getAbstractSubcomponentType();

		case VIRTUAL_BUS:
			return p.getVirtualBusSubcomponentType();

		case VIRTUAL_PROCESSOR:
			return p.getVirtualProcessorSubcomponentType();

		case BUS:
			return p.getBusSubcomponentType();

		case PROCESSOR:
			return p.getProcessorSubcomponentType();

		case DEVICE:
			return p.getDeviceSubcomponentType();

		case MEMORY:
			return p.getMemorySubcomponentType();

		default:
			throw new RuntimeException("Unexpected category: " + category);
		}
	}

	/**
	 * Builds a string that can be used to compare a list of prototype bindings
	 * @param bindings for which to build a comparison string
	 * @return is the comparison string that was built.
	 */
	private String buildComparisonString(final List<PrototypeBinding> bindings) {
		final StringBuilder sb = new StringBuilder();

		bindings.stream().sorted((b1, b2) -> getPrototypeName(b1).compareToIgnoreCase(getPrototypeName(b2)))
		.forEachOrdered(b -> {
			sb.append(getPrototypeName(b));
			sb.append(':');

			if (b instanceof ComponentPrototypeBinding) {
				final ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) b;
				cpb.getActuals().stream().forEachOrdered(a -> {
					sb.append(a.getCategory());
					sb.append(',');
					addQualfiedNameIfNamedElement(sb, a.getSubcomponentType());
					sb.append('(');
					sb.append(buildComparisonString(a.getBindings()));
					sb.append(')');
				});
			} else if (b instanceof FeatureGroupPrototypeBinding) {
				final FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) b;
				final FeatureGroupPrototypeActual a = fgpb.getActual();
				if (a != null) {
					addQualfiedNameIfNamedElement(sb, a.getFeatureType());
					sb.append('(');
					sb.append(buildComparisonString(a.getBindings()));
					sb.append(')');
				}

			} else if (b instanceof FeaturePrototypeBinding) {
				FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) b;
				final FeaturePrototypeActual a = fpb.getActual();
				if (a instanceof AccessSpecification) {
					final AccessSpecification as = (AccessSpecification) a;
					sb.append(as.getCategory());
					sb.append(',');
					sb.append(as.getKind());
					sb.append(',');
					addQualfiedNameIfNamedElement(sb, as.getClassifier());
				} else if (a instanceof PortSpecification) {
					final PortSpecification ps = (PortSpecification) a;
					sb.append(ps.getCategory());
					sb.append(',');
					sb.append(ps.getDirection());
					sb.append(',');
					addQualfiedNameIfNamedElement(sb, ps.getClassifier());
				} else if (a instanceof FeaturePrototypeReference) {
					final FeaturePrototypeReference r = (FeaturePrototypeReference) a;
					sb.append(r.getDirection());
					sb.append(',');
					addQualfiedNameIfNamedElement(sb, r.getPrototype());
				}
			}

			sb.append(';');
		});

		return sb.toString();
	}
}
