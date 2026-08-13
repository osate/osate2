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

import java.util.ArrayList;
import java.util.List;

/**
 * Structured identity of a semantic connection path, used to suppress redundant
 * enumeration work.
 *
 * <p>
 * Every field is a stable key, so two runs of the same declarative model in
 * different resource sets produce equal keys for the same path. Object identity
 * would report every path as different and suppression would never fire.
 * </p>
 *
 * <p>
 * Display names are not part of identity and must not become part of it. A name is
 * built only from the container-relative source and destination paths, so two
 * distinct semantic paths that share an endpoint pair share a name; keying on names
 * would collapse them. Name formatting stays exactly where it is, in
 * materialization.
 * </p>
 *
 * <p>
 * The key must not collapse the two legal orientations of a bidirectional pair,
 * which the baseline materializes as two connection instances. It does not: the two
 * orientations differ in endpoint pair, in declaration order, in context order, and
 * in every reverse flag, and any one of those differences is enough. The feature
 * path keys carry the remaining expansion identity that the endpoints do not, which
 * is what keeps two paths that reach into the same feature group by different routes
 * distinct.
 * </p>
 *
 * @param containerKey the component instance that will contain the connection
 * @param sourceKey the ultimate source
 * @param destinationKey the ultimate destination
 * @param declarationKeys the traversed declarations, in traversal order
 * @param contextKeys the context of each traversed declaration, in the same order
 * @param reverseFlags the orientation of each traversed declaration, in the same
 *            order
 * @param featurePathKeys the source and destination feature chains of each segment,
 *            in the same order
 */
public record SemanticConnectionKey(String containerKey, String sourceKey, String destinationKey,
		List<String> declarationKeys, List<String> contextKeys, List<Boolean> reverseFlags,
		List<String> featurePathKeys) {

	public SemanticConnectionKey {
		declarationKeys = List.copyOf(declarationKeys);
		contextKeys = List.copyOf(contextKeys);
		reverseFlags = List.copyOf(reverseFlags);
		featurePathKeys = List.copyOf(featurePathKeys);
	}

	/** The identity of {@code path}. */
	public static SemanticConnectionKey of(SemanticConnectionPath path) {
		List<String> declarations = new ArrayList<>();
		List<String> contexts = new ArrayList<>();
		List<Boolean> reverseFlags = new ArrayList<>();
		List<String> featurePaths = new ArrayList<>();
		for (ResolvedSegment segment : path.segments()) {
			declarations.add(PathKeys.declarative(segment.declaration()));
			contexts.add(PathKeys.instance(segment.context()));
			reverseFlags.add(segment.reverse());
			featurePaths.add(segment.sourcePath().key() + "->" + segment.destinationPath().key());
		}
		return new SemanticConnectionKey(PathKeys.instance(path.container()), PathKeys.instance(path.source()),
				PathKeys.instance(path.destination()), declarations, contexts, reverseFlags, featurePaths);
	}
}
