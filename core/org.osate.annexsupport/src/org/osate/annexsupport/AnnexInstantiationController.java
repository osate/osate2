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
package org.osate.annexsupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;

/**
 * @author lwrage
 * @version $Id: AnnexInstantiationController.java,v 1.10 2010-05-04 18:13:49 lwrage Exp $
 */
public class AnnexInstantiationController extends ForAllElement {

	public void instantiateAllAnnexes(ComponentInstance root) {
		processPreOrderComponentInstance(root);
	}

	/*
	 * (non-Javadoc)
	 *
	 *
	 * Efficiency: Recalculates list for each instance, even if same
	 * implementation.
	 */
	@Override
	protected void action(Element obj) {
		ComponentInstance instance = (ComponentInstance) obj;
		AnnexInstantiatorRegistry registry = (AnnexInstantiatorRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_INSTANTIATOR_EXT_ID);
		Map<String, List<AnnexSubclause>> annexMap = new HashMap<String, List<AnnexSubclause>>();

		// group annex subclauses by annex name
		// annex subclauses list ordered following the inheritance chain upwards
		// result in annexMap
		if (InstanceUtil.getComponentImplementation(instance, 0, null) != null) {
			final EList<Classifier> classifiers = InstanceUtil.getComponentImplementation(instance, 0, null)
					.getSelfPlusAllExtended();
			for (final Iterator<Classifier> iter = classifiers.iterator(); iter.hasNext();) {
				final Classifier classifier = iter.next();
				for (Iterator<AnnexSubclause> subclauseIter = classifier.getOwnedAnnexSubclauses()
						.iterator(); subclauseIter.hasNext();) {
					AnnexSubclause annexSubclause = subclauseIter.next();
					String annexName = annexSubclause.getName();

					if (annexMap.get(annexName) == null) {
						annexMap.put(annexName, new LinkedList<AnnexSubclause>());
					}
					annexMap.get(annexName).add(annexSubclause);
				}
			}
		}
		// instantiate each annex
		for (Iterator<Map.Entry<String, List<AnnexSubclause>>> annexIter = annexMap.entrySet().iterator(); annexIter
				.hasNext();) {
			Map.Entry<String, List<AnnexSubclause>> annexEntry = annexIter.next();
			String annexName = annexEntry.getKey();
			List<AnnexSubclause> annexElements = annexEntry.getValue();
			AnnexInstantiator instantiator = registry.getAnnexInstantiator(annexName);

			if (instantiator != null && annexElements != null) {
				instantiator.instantiateAnnex(instance, annexName, annexElements);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected boolean suchThat(Element obj) {
		return true;
	}
}