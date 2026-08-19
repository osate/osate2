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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
 * reload: resource-relative URIs, instance object paths, metaclasses, feature
 * categories, and array indices.
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
	 * Key for a declarative element. Only the last URI segment and the fragment are
	 * used, because the leading segments differ between runs that load the same model
	 * from different locations.
	 */
	public static String declarative(EObject element) {
		if (element == null) {
			return NULL_KEY;
		}
		var uri = EcoreUtil.getURI(element);
		if (uri == null) {
			return NULL_KEY;
		}
		String segment = uri.segmentCount() == 0 ? uri.toString() : uri.lastSegment();
		return segment + "#" + uri.fragment();
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
}
