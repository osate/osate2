/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.internal;

import java.util.List;
import java.util.Optional;

import org.osate.ge.StringUtil;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.referencehandling.GetCanonicalReferenceLabelContext;
import org.osate.ge.referencehandling.GetRelativeReferenceLabelContext;
import org.osate.ge.referencehandling.ReferenceLabelProvider;

public class DeclarativeReferenceLabelProvider implements ReferenceLabelProvider {
	@Override
	public Optional<String> getCanonicalReferenceLabel(final GetCanonicalReferenceLabelContext ctx) {
		return getLabel(ctx.getReference().getSegments());
	}

	@Override
	public Optional<String> getRelativeReferenceLabel(final GetRelativeReferenceLabelContext ctx) {
		return getLabel(ctx.getReference().getSegments());
	}

	private static Optional<String> getLabel(final List<String> segs) {
		if (segs.size() != 1 && segs.size() != 2) {
			return Optional.empty();
		}

		final String tag = segs.get(0);
		if (!DeclarativeReferenceType.isId(tag)) {
			return Optional.empty();
		}

		final String formattedTag = getFormattedTag(tag);
		if(segs.size() == 1) {
			return Optional.of(formattedTag);
		}

		return Optional.of(formattedTag + " " + segs.get(1));
	}

	private static final String getFormattedTag(final String tag) {
		return StringUtil.snakeCaseToTitleCase(tag);
	}
}
