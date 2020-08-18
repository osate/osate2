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
package org.osate.ge.ba;

import java.util.List;
import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.ba.util.BaUtil;
import org.osate.ge.referencehandling.CreateReferenceResolverFactoryContext;
import org.osate.ge.referencehandling.ReferenceResolver;
import org.osate.ge.referencehandling.ReferenceResolverFactory;
import org.osate.ge.referencehandling.ResolveContext;

import com.google.common.primitives.Longs;

public class BehaviorAnnexReferenceResolver implements ReferenceResolver {
	public static class Factory implements ReferenceResolverFactory {
		@Override
		public ReferenceResolver create(final CreateReferenceResolverFactoryContext ctx) {
			return new BehaviorAnnexReferenceResolver();
		}
	}

	private final static String ANNEX_SUBCLAUSE_TYPE = "annex_subclause";

	@Override
	public Optional<Object> resolve(final ResolveContext ctx) {
		final List<String> ref = ctx.getReference().getSegments();
		if (ref.size() < 4) {
			return Optional.empty();
		}

		// Check that the type is BA
		final String type = ref.get(0);
		if (!type.equals(ANNEX_SUBCLAUSE_TYPE)) {
			return Optional.empty();
		}

		// Retrieve the referenced object
		final Object ref1 = ctx.getReferenceResolutionService()
				.resolve(CanonicalBusinessObjectReference.decode(ref.get(1)));
		if (!(ref1 instanceof Classifier)) {
			return Optional.empty();
		}

		// Check that the ref is for BA Specification
		final String name = ref.get(2);
		if (!BaUtil.ANNEX_NAME.equalsIgnoreCase(name)) {
			return Optional.empty();
		}

		// Check that index is valid
		final Long index = Longs.tryParse(ref.get(3));
		if (index != null && index >= 0) {
			final Classifier classifier = (Classifier) ref1;
			return getBehaviorAnnexByQualifiedName(classifier, ref.get(2), index);
		}

		return Optional.empty();
	}

	private Optional<Object> getBehaviorAnnexByQualifiedName(final Classifier classifier,
			final String annexSubclauseName,
			final Long index) {
		return classifier.getSelfPlusAllExtended().stream().sequential()
				.flatMap(c -> c.getOwnedAnnexSubclauses().stream().sequential())
				.filter(as -> annexSubclauseName.equalsIgnoreCase(as.getName())).skip(index)
				.findFirst()
				.map(as -> ((DefaultAnnexSubclause) as).getParsedAnnexSubclause());
	}
}
