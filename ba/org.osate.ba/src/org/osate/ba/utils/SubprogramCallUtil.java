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
package org.osate.ba.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.ba.aadlba.CalledSubprogramHolder;

/** Shared, read-only signature lookup for translation and validation of BA calls.
 * @since 9.0*/
public final class SubprogramCallUtil {
	private SubprogramCallUtil() {
	}

	/** Resolves accesses, subcomponents and prototypes in their enclosing group context. */
	public static SubprogramClassifier getClassifier(CalledSubprogramHolder holder, ComponentClassifier owner) {
		if (holder == null || holder.getElement() == null) {
			return null;
		}
		Classifier context = owner;
		for (var group : holder.getGroupHolders()) {
			var classifier = AadlBaUtils.getClassifier(group.getElement(), context);
			if (classifier != null) {
				context = classifier;
			}
		}
		var element = holder.getElement();
		var classifier = element instanceof SubprogramClassifier subprogram ? subprogram
				: AadlBaUtils.getClassifier(element, context);
		return classifier instanceof SubprogramClassifier subprogram ? subprogram : null;
	}

	/**
	 * Includes every feature, in declaration order, with refinements retaining their inherited position.
	 * Does not bind prototypes by mutating features in the source classifier.
	 */
	public static List<Feature> getFormals(SubprogramClassifier classifier) {
		if (classifier == null) {
			return List.of();
		}
		var type = classifier instanceof ComponentImplementation implementation ? implementation.getType()
				: (ComponentType) classifier;
		var features = new LinkedHashMap<String, Feature>();
		var ancestors = type.getSelfPlusAllExtended();
		for (var ancestor : new ArrayList<>(ancestors).reversed()) {
			// getOwnedFeatures is a derived union grouped by feature kind, not by source order.
			var declared = new ArrayList<>(((ComponentType) ancestor).getOwnedFeatures());
			declared.sort(Comparator.comparingInt(feature -> {
				var node = NodeModelUtils.findActualNodeFor(feature);
				return node == null ? Integer.MAX_VALUE : node.getOffset();
			}));
			for (var feature : declared) {
				features.put(feature.getName().toLowerCase(Locale.ROOT), feature);
			}
		}
		return List.copyOf(features.values());
	}
}
