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
