/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.core.tests.instantiation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

/**
 * Stable, cross-resource-set normalization for instantiation characterization.
 *
 * <p>
 * Two instantiation runs of the same declarative model use different
 * {@code ResourceSet} objects, so EMF object identity can never be a comparison
 * key. Every key produced here is derived only from values that survive
 * reloading: resource-relative URIs, instance object paths, categories, and
 * array indices.
 * </p>
 */
public final class InstanceKeys {
	/** Rendered in place of a key whose subject is {@code null}. */
	public static final String NULL_KEY = "<null>";

	private InstanceKeys() {
	}

	/**
	 * Key for a declarative element, stable across resource sets.
	 *
	 * <p>
	 * The full platform URI differs between runs that load the model from
	 * different locations, so only the last URI segment and the fragment are
	 * used. Both identify the element unambiguously within a single-file fixture
	 * and remain identical after a reload.
	 * </p>
	 */
	public static String declarative(EObject element) {
		if (element == null) {
			return NULL_KEY;
		}
		URI uri = EcoreUtil.getURI(element);
		if (uri == null) {
			return NULL_KEY;
		}
		String segment = uri.segmentCount() == 0 ? uri.toString() : uri.lastSegment();
		return segment + "#" + uri.fragment();
	}

	/**
	 * Key for an instance object: its instance path, its metaclass, and, for
	 * feature instances, the feature category and array index that the path
	 * alone does not always distinguish.
	 */
	public static String instance(InstanceObject object) {
		if (object == null) {
			return NULL_KEY;
		}
		StringBuilder key = new StringBuilder(object.getInstanceObjectPath());
		key.append('|').append(object.eClass().getName());
		if (object instanceof FeatureInstance feature) {
			key.append('|').append(feature.getCategory()).append('|').append(feature.getIndex());
		}
		return key.toString();
	}

	/**
	 * Key for an arbitrary object appearing inside a normalized value: instance
	 * objects use their instance key, everything else its declarative key.
	 */
	public static String any(EObject object) {
		if (object == null) {
			return NULL_KEY;
		}
		return object instanceof InstanceObject instanceObject ? instance(instanceObject) : declarative(object);
	}

	/**
	 * Structural, cross-resource-stable rendering of a containment tree.
	 *
	 * <p>
	 * Used for property values, where the shape is open-ended. Set, non-derived,
	 * non-transient attributes are rendered by value; contained children are
	 * rendered recursively; cross-references are replaced by {@link #any} keys so
	 * that no object identity leaks into the comparison.
	 * </p>
	 */
	public static String structural(EObject object) {
		StringBuilder rendered = new StringBuilder();
		render(rendered, object);
		return rendered.toString();
	}

	private static void render(StringBuilder rendered, EObject object) {
		if (object == null) {
			rendered.append(NULL_KEY);
			return;
		}
		rendered.append(object.eClass().getName()).append('(');
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (feature.isDerived() || feature.isTransient() || !object.eIsSet(feature)) {
				continue;
			}
			rendered.append(feature.getName()).append('=');
			if (feature instanceof EAttribute) {
				rendered.append(object.eGet(feature));
			} else {
				renderReference(rendered, object, (EReference) feature);
			}
			rendered.append(';');
		}
		rendered.append(')');
	}

	private static void renderReference(StringBuilder rendered, EObject object, EReference reference) {
		Object value = object.eGet(reference);
		if (reference.isMany()) {
			rendered.append('[');
			for (Object element : (List<?>) value) {
				renderTarget(rendered, reference, (EObject) element);
				rendered.append(',');
			}
			rendered.append(']');
		} else {
			renderTarget(rendered, reference, (EObject) value);
		}
	}

	private static void renderTarget(StringBuilder rendered, EReference reference, EObject target) {
		if (reference.isContainment()) {
			render(rendered, target);
		} else {
			rendered.append(any(target));
		}
	}

	/**
	 * Sorted copy of a key collection, so that a set-valued property such as the
	 * system operation modes of a connection instance compares independently of
	 * the order in which the pipeline happened to add them.
	 */
	public static List<String> sorted(List<String> keys) {
		List<String> copy = new ArrayList<>(keys);
		copy.sort(Comparator.naturalOrder());
		return List.copyOf(copy);
	}
}
