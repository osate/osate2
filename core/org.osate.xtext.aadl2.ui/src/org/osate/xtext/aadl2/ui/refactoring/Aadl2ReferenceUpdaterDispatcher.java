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
package org.osate.xtext.aadl2.ui.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.impl.ReferenceUpdaterDispatcher;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.Inject;

/**
 * Updates live symbolic annex references without treating them as persisted structural index entries.
 */
@SuppressWarnings("restriction")
public class Aadl2ReferenceUpdaterDispatcher extends ReferenceUpdaterDispatcher {
	@Inject
	private IResourceServiceProvider.Registry registry;

	@Inject
	private ILocationInFileProvider locations;

	@Inject
	private IReferenceUpdater referenceUpdater;

	@Override
	protected ReferenceDescriptionAcceptor createFindReferenceAcceptor(IRefactoringUpdateAcceptor updateAcceptor) {
		return new ReferenceDescriptionAcceptor(registry, updateAcceptor.getRefactoringStatus()) {
			@Override
			public void accept(EObject source, URI sourceURI, EReference reference, int index, EObject target,
					URI targetURI) {
				if (reference == null && source != null && sourceURI != null && target != null && !target.eIsProxy()
						&& targetURI != null && AnnexUtil.getAnnexRoot(source) != null) {
					var region = locations.getSignificantTextRegion(source);
					if (region != null && region.getLength() > 0) {
						getReferenceUpdater2ReferenceDescriptions().put(referenceUpdater,
								new DefaultReferenceDescription(EcoreUtil2.getFragmentPathURI(source), targetURI, null,
										-1, null));
						return;
					}
				}
				super.accept(source, sourceURI, reference, index, target, targetURI);
			}
		};
	}
}
