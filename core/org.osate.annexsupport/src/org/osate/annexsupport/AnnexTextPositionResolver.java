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
package org.osate.annexsupport;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface AnnexTextPositionResolver {
	TextPositionInfo resolveElementAt(EObject annexRoot, int offset);

	TextPositionInfo resolveCrossReferencedElementAt(EObject annexRoot, int offset);

	/**
	 * Reports symbolic references not represented by structural EMF cross-references. Each position contains the
	 * source-model target declaration and the absolute document offset and length of the reference token.
	 * Implementations must honor cancellation and must not report unresolved references or declarations.
	 * Return {@link AnnexReferencePosition} instances to also support semantic reference search and navigation.
	 *
	 * @since 5.0
	 */
	default void collectReferencePositions(EObject annexRoot, Consumer<TextPositionInfo> acceptor,
			IProgressMonitor monitor) {
	}

	/**
	 * Reports annex elements whose structural references also refer to a selected declaration. The caller retains
	 * the actual reference metadata and searches only its requested scope. Implementations must honor cancellation.
	 *
	 * @since 5.0
	 */
	default void collectRelatedReferenceTargets(EObject annexRoot, Predicate<EObject> isTarget,
			Consumer<EObject> acceptor, IProgressMonitor monitor) {
	}

	/**
	 * Returns the token representing a selected declaration inside an annex reference, or null for the ordinary
	 * feature-based text region. This can distinguish segments of a qualified reference to a related annex element.
	 *
	 * @since 5.0
	 */
	default TextPositionInfo getReferencePosition(EObject source, EReference reference, int index, EObject target) {
		return null;
	}
}
