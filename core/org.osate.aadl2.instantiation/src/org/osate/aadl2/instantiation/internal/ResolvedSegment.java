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

import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

/**
 * One declarative connection, resolved in one component instance context and in
 * one traversal orientation.
 *
 * <p>
 * A segment is built only once both endpoints resolve, so it never carries a null
 * endpoint. This applies the invariant issue #3017 established for materialized
 * connections one stage earlier: a step that cannot resolve produces a
 * {@link Resolution.Failed} or {@link Resolution.NotApplicable} rather than a
 * segment with holes.
 * </p>
 *
 * @param declaration the traversed connection declaration
 * @param context the component instance the declaration belongs to
 * @param source the endpoint the path enters this segment from
 * @param destination the endpoint the path leaves this segment at
 * @param reverse whether the declaration is traversed opposite its declared
 *            direction, which only a bidirectional declaration allows
 * @param sourcePath the feature chain reached through on the source side
 * @param destinationPath the feature chain reached through on the destination side
 */
public record ResolvedSegment(Connection declaration, ComponentInstance context, ConnectionInstanceEnd source,
		ConnectionInstanceEnd destination, boolean reverse, FeaturePath sourcePath, FeaturePath destinationPath) {

	public ResolvedSegment {
		if (declaration == null) {
			throw new IllegalArgumentException("A resolved segment needs a declaration");
		}
		if (context == null) {
			throw new IllegalArgumentException("A resolved segment needs a context: " + declaration.getQualifiedName());
		}
		if (source == null || destination == null) {
			throw new IllegalArgumentException("A resolved segment needs both endpoints, but "
					+ declaration.getQualifiedName() + " resolved to " + PathKeys.instance(source) + " -> "
					+ PathKeys.instance(destination));
		}
		if (sourcePath == null || destinationPath == null) {
			throw new IllegalArgumentException(
					"A resolved segment needs both feature paths: " + declaration.getQualifiedName());
		}
	}

	/**
	 * Whether this segment crosses between peers, which makes it the pivot of a
	 * complete semantic connection. The predicate is purely declarative and includes
	 * an access connection whose endpoint is a subcomponent.
	 */
	public boolean isAcross() {
		return declaration.isAcross();
	}

	/** Stable identity of the segment. Never uses object identity. */
	public String key() {
		return PathKeys.declarative(declaration) + '@' + PathKeys.instance(context) + (reverse ? "|reverse" : "|forward")
				+ '|' + PathKeys.instance(source) + "->" + PathKeys.instance(destination) + '|' + sourcePath.key() + '|'
				+ destinationPath.key();
	}
}
