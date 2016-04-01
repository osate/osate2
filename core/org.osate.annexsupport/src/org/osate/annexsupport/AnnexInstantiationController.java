/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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