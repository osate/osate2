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
package org.osate.xtext.aadl2.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.scoping.Aadl2ReferenceScopeProvider;

import com.google.inject.Inject;

public class Aadl2LinkingService extends DefaultLinkingService {
	private DefaultLinkingService defaultLinkingService;

	@Inject
	private void configureDefaultLinkingService(DefaultLinkingService linkingService,
			Aadl2ReferenceScopeProvider scopeProvider) {
		linkingService.setScopeProvider(scopeProvider);
		defaultLinkingService = linkingService;
	}

	@Inject
	IResourceScopeCache linkingCache;

	AnnexLinkingServiceRegistry annexlinkingserviceregistry;

	protected void Aadl2linkingService() {
		initAnnexLinkingServiceRegistry();
	}

	protected void initAnnexLinkingServiceRegistry() {
		if (annexlinkingserviceregistry == null) {
			annexlinkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		}
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		List<EObject> result;

		result = linkingCache.get(node, context.eResource(), () -> doGetLinkedObjects(context, reference, node));
		return result;
	}

	private List<EObject> doGetLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		NamedElement annex = AadlUtil.getContainingAnnex(context);
		if (annex != null && !(reference == Aadl2Package.eINSTANCE.getModalElement_InMode())) {
			String annexName = annex.getName();
			if (annexName != null) {
				if (annexlinkingserviceregistry == null) {
					initAnnexLinkingServiceRegistry();
				}
				if (annexlinkingserviceregistry != null) {
					AnnexLinkingService linkingservice = annexlinkingserviceregistry.getAnnexLinkingService(annexName);
					if (linkingservice != null) {
						return linkingservice.resolveAnnexReference(annexName, context, reference, node);
					}
				}
			}
			return Collections.<EObject> emptyList();
		}

		return defaultLinkingService.getLinkedObjects(context, reference, node);
	}
}
