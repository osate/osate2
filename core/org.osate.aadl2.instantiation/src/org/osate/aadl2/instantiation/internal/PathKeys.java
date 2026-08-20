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
package org.osate.aadl2.instantiation.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

/**
 * Stable keys for the internal path model.
 *
 * <p>
 * Path identity may never rest on Java or EMF object identity. The same
 * declarative model instantiated twice lives in two resource sets, so identity
 * comparison would report every path as different, and enumeration suppression
 * would stop working. Every key here is derived only from values that survive a
 * reload: root names with the fragments that locate an element inside their
 * resource, instance object paths, metaclasses, feature categories, and array
 * indices.
 * </p>
 *
 * <p>
 * These rules match the ones the characterization tests use to describe
 * materialized connections, which is what lets an enumerated path be matched
 * against the connection instance it becomes.
 * </p>
 */
public final class PathKeys {
	/** Rendered in place of a key whose subject is {@code null}. */
	public static final String NULL_KEY = "<null>";

	private PathKeys() {
	}

	/**
	 * Key for a declarative element: the identity of the resource that holds it, and the
	 * fragment that locates it inside that resource.
	 */
	public static String declarative(EObject element) {
		if (element == null) {
			return NULL_KEY;
		}
		var uri = EcoreUtil.getURI(element);
		if (uri == null) {
			return NULL_KEY;
		}
		return resourceKey(element, uri) + "#" + uri.fragment();
	}

	/**
	 * Identity of the resource that holds a declarative element.
	 *
	 * <p>
	 * The leading URI segments are dropped, because they differ between runs that load the
	 * same model from different locations. The last segment alone is not an identity: two
	 * projects may hold files of the same name, and keying both to the same string would let
	 * a legitimate continuation be suppressed as a cycle, or a distinct path be discarded as
	 * a duplicate. The qualified name of the root — the AADL package or property set —
	 * distinguishes them and does not depend on where the model was loaded from. A root
	 * without a name is not an AADL package, and keeps the whole location, which is unique
	 * by construction.
	 * </p>
	 */
	private static String resourceKey(EObject element, URI uri) {
		var root = EcoreUtil.getRootContainer(element);
		var rootName = root instanceof NamedElement named ? named.getName() : null;
		if (rootName == null || rootName.isEmpty()) {
			return uri.trimFragment().toString();
		}
		return rootName + '/' + (uri.segmentCount() == 0 ? uri.toString() : uri.lastSegment());
	}

	/**
	 * Key for an instance object: its instance path, its metaclass, and, for feature
	 * instances, the category and array index that the path alone does not always
	 * distinguish.
	 */
	public static String instance(InstanceObject object) {
		if (object == null) {
			return NULL_KEY;
		}
		var key = object.getInstanceObjectPath() + "|" + object.eClass().getName();
		return object instanceof FeatureInstance feature
				? key + "|" + feature.getCategory() + "|" + feature.getIndex()
				: key;
	}

	/** Key for an object that may be either declarative or an instance object. */
	public static String any(EObject object) {
		if (object == null) {
			return NULL_KEY;
		}
		return object instanceof InstanceObject instanceObject ? instance(instanceObject) : declarative(object);
	}

	/** Sort values by stable keys that are each computed once. */
	static <T> List<T> sortedByStableKey(Collection<T> values, Function<T, String> key) {
		return values.stream()
				.map(value -> Map.entry(key.apply(value), value))
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.toList();
	}

	/** Sort already-keyed values by a stable rendering of their keys. */
	static <K, T> List<T> sortedByStableKey(Map<K, T> values, Function<K, String> key) {
		return sortedByStableKey(values.entrySet(), entry -> key.apply(entry.getKey())).stream()
				.map(Map.Entry::getValue)
				.toList();
	}
}
