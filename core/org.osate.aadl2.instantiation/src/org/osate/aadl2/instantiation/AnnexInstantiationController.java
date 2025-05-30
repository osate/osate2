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
package org.osate.aadl2.instantiation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.annexsupport.AnnexInstantiator;
import org.osate.annexsupport.AnnexInstantiatorRegistry;
import org.osate.annexsupport.AnnexRegistry;

/**
 * @since 1.1
 */
public class AnnexInstantiationController extends ForAllElement {

	private AnnexInstantiatorRegistry registry = (AnnexInstantiatorRegistry) AnnexRegistry
			.getRegistry(AnnexRegistry.ANNEX_INSTANTIATOR_EXT_ID);

	private Set<String> allAnnexes = new HashSet<String>();

	private AnalysisErrorReporterManager errorManager;

	AnnexInstantiationController(AnalysisErrorReporterManager errorManager) {
		super();
		this.errorManager = errorManager;
	}

	void instantiateAllAnnexes(ComponentInstance root) {
		processPostOrderComponentInstance(root);
		for (String annexName : allAnnexes) {
			AnnexInstantiator instantiator = registry.getAnnexInstantiator(annexName);

			if (instantiator != null) {
				if (root instanceof SystemInstance si) {
					instantiator.instantiateAnnex(si, annexName, errorManager);
				} else {
					instantiator.instantiateAnnex(root, annexName, errorManager);
				}
			}
		}

	}

	@Override
	protected void action(Element obj) {
		ComponentInstance instance = (ComponentInstance) obj;
		Set<String> annexes = new HashSet<String>();

		if (InstanceUtil.getComponentImplementation(instance, 0, null) != null) {
			final EList<Classifier> classifiers = InstanceUtil.getComponentImplementation(instance, 0, null)
					.getSelfPlusAllExtended();
			for (Classifier classifier : classifiers) {
				for (AnnexSubclause annexSubclause : classifier.getOwnedAnnexSubclauses()) {
					annexes.add(annexSubclause.getName());
				}
			}
		}
		if (InstanceUtil.getComponentType(instance, 0, null) != null) {
			final EList<Classifier> classifiers = InstanceUtil.getComponentType(instance, 0, null)
					.getSelfPlusAllExtended();
			for (Classifier classifier : classifiers) {
				for (AnnexSubclause annexSubclause : classifier.getOwnedAnnexSubclauses()) {
					annexes.add(annexSubclause.getName());
				}
			}
		}
		// instantiate each annex
		for (String annexName : annexes) {
			AnnexInstantiator instantiator = registry.getAnnexInstantiator(annexName);

			if (instantiator != null) {
				instantiator.instantiateAnnex(instance, annexName, errorManager);
			}
			allAnnexes.add(annexName);
		}
	}

	@Override
	protected boolean suchThat(Element obj) {
		return true;
	}
}