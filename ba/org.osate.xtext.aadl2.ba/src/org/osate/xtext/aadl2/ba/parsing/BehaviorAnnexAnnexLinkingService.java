/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.xtext.aadl2.ba.parsing;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;

import com.google.inject.Inject;
import com.google.inject.Injector;

/** Delegates temporary embedded BA references to the Xtext linker and qualified-name provider. */
public final class BehaviorAnnexAnnexLinkingService implements AnnexLinkingService {
	@Inject
	private DefaultLinkingService linkingService;

	@Inject
	private IQualifiedNameProvider nameProvider;

	public BehaviorAnnexAnnexLinkingService() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy." + BehaviorAnnexStandaloneSetup.FILE_EXTENSION))
				.get(Injector.class);
		injector.injectMembers(this);
	}

	@Override
	public List<EObject> resolveAnnexReference(String annexName, EObject context, EReference reference, INode node) {
		if (!BehaviorAnnexStandaloneSetup.ANNEX_NAME.equalsIgnoreCase(annexName)) {
			return List.of();
		}
		return linkingService.getLinkedObjects(context, reference, node);
	}

	@Override
	public QualifiedName getFullyQualifiedName(EObject object) {
		return nameProvider.getFullyQualifiedName(object);
	}
}
