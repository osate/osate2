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
package org.osate.ge.ba;

import java.util.stream.Stream;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectProvider;
import org.osate.ge.BusinessObjectProviderContext;
import org.osate.ge.aadl2.GraphicalAnnexUtil;

/**
 * Business object provider which provides behavior annex model elements to the OSATE graphical editor
 */
public class BehaviorAnnexBusinessObjectProvider implements BusinessObjectProvider {
	@Override
	public Stream<?> getChildBusinessObjects(final BusinessObjectProviderContext ctx) {
		final Object bo = ctx.getBusinessObjectContext().getBusinessObject();
		return getChildBusinessObjects(bo);
	}

	/**
	 * Returns {@link BehaviorAnnex} children of the business object
	 */
	private Stream<?> getChildBusinessObjects(final Object bo) {
		if (bo instanceof Classifier) {
			return getBehaviorAnnexes((Classifier) bo);
		} else if (bo instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent) bo;
			return getChildBusinessObjects(sc.getAllClassifier());
		} else if (bo instanceof BehaviorAnnex) {
			final BehaviorAnnex ba = (BehaviorAnnex) bo;
			return Stream.concat(Stream.concat(ba.getTransitions().stream(), ba.getStates().stream()),
					ba.getVariables().stream());
		} else if (bo instanceof BehaviorTransition) {
			final BehaviorTransition bt = (BehaviorTransition) bo;
			final BehaviorCondition bc = bt.getCondition();
			return bc == null ? Stream.empty() : Stream.of(bc);
		}

		return Stream.empty();
	}

	/**
	 * Returns all behavior annexes owned by the classifier
	 */
	private static Stream<BehaviorAnnex> getBehaviorAnnexes(final Classifier c) {
		return GraphicalAnnexUtil.getAllParsedAnnexSubclauses(c, BehaviorAnnexReferenceUtil.ANNEX_NAME,
				BehaviorAnnex.class);
	}
}
