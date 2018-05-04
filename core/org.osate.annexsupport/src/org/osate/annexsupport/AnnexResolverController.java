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
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;

/**
 * @author lwrage
 * @version $Id: AnnexResolverController.java,v 1.12 2010-03-17 20:49:13 jseibel Exp $
 */
public class AnnexResolverController extends ForAllElement {
	/**
	 * A key is an annex name, a value is a list of annex libraries and
	 * subclauses in the workspace.
	 */
	private Map<String, List<Element>> allLists = new HashMap<String, List<Element>>();

	public AnnexResolverController(final AnalysisErrorReporterManager errMgr) {
		super(PROCESS_PRE_ORDER_ALL, errMgr);
	}

	public void resolveAllAnnexes(Set<Resource> resources) {
		Iterator<Entry<String, List<Element>>> iter;

		AnnexResolverRegistry registry = (AnnexResolverRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_RESOLVER_EXT_ID);
		for (Resource res : resources) {
			EList<EObject> rc = res.getContents();
			if (!rc.isEmpty()) {
				Element o = (Element) res.getContents().get(0);
				if (o instanceof AadlPackage) {
					processPreOrderAll(o);
				}
			}
		}

		iter = allLists.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<?, ?> entry = iter.next();
			String annexName = (String) entry.getKey();
			List<?> annexElements = (List<?>) entry.getValue();
			AnnexResolver resolver = registry.getAnnexResolver(annexName);

			if (resolver != null && annexElements != null) {
				resolver.resolveAnnex(annexName, annexElements, getErrorManager());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void action(Element obj) {
		String annexName = ((NamedElement) obj).getName();
		List<Element> annexList = allLists.get(annexName);

		if (annexList == null) {
			annexList = new LinkedList<Element>();
			allLists.put(annexName, annexList);
		}
		annexList.add(obj);
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected boolean suchThat(Element obj) {
		return obj instanceof AnnexLibrary || obj instanceof AnnexSubclause;
	}
}
