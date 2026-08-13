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
package org.osate.aadl2.instantiation.testing;

import java.util.List;

/**
 * One candidate semantic connection as it stood immediately before the
 * reverse-order duplicate check decided whether to materialize it.
 *
 * <p>
 * The across-first traversal work has to know whether the candidates that
 * source-first traversal suppresses differ from the ones it keeps in any way that
 * could affect a materialized descriptor. A suppressed candidate is never
 * attached to the model, so it cannot be inspected afterwards; it only exists as
 * an observation like this one.
 * </p>
 *
 * <p>
 * Every field is a stable value rather than an EMF object, so an observation
 * stays valid after its resource set is discarded and can be compared between
 * runs. Instance endpoints are recorded as instance object paths and declarations
 * as element URIs.
 * </p>
 *
 * <p>
 * This is temporary migration support and is removed together with the rest of
 * the characterization facade.
 * </p>
 *
 * @param containerPath instance path of the component that would contain the
 *            connection, or the system instance path when the candidate has no
 *            container yet
 * @param sourcePath instance path of the ultimate source
 * @param destinationPath instance path of the ultimate destination, or
 *            {@code null} when the destination did not resolve
 * @param declarationUris the traversed connection declarations, in traversal
 *            order
 * @param contextPaths instance path of the component context of each traversed
 *            declaration, in the same order
 * @param reverseFlags whether each declaration is traversed opposite its
 *            declared direction, in the same order
 * @param segmentSourcePaths per-segment source endpoint paths, in the same order
 * @param segmentDestinationPaths per-segment destination endpoint paths, in the
 *            same order
 * @param complete whether the candidate had crossed an across segment
 * @param accepted whether the duplicate check let the candidate through
 */
public record DuplicateCandidateObservation(String containerPath, String sourcePath, String destinationPath,
		List<String> declarationUris, List<String> contextPaths, List<Boolean> reverseFlags,
		List<String> segmentSourcePaths, List<String> segmentDestinationPaths, boolean complete, boolean accepted) {

	public DuplicateCandidateObservation {
		declarationUris = List.copyOf(declarationUris);
		contextPaths = List.copyOf(contextPaths);
		reverseFlags = List.copyOf(reverseFlags);
		segmentSourcePaths = List.copyOf(segmentSourcePaths);
		segmentDestinationPaths = List.copyOf(segmentDestinationPaths);
	}
}
