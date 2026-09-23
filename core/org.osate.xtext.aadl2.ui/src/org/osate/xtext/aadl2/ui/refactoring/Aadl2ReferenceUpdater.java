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
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexTextPositionResolverRegistry;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class Aadl2ReferenceUpdater extends DefaultReferenceUpdater {
	@Inject
	private ILocationInFileProvider locations;

	@Override
	protected EObject resolveReference(EObject source, IReferenceDescription description) {
		if (description.getEReference() != null) {
			return super.resolveReference(source, description);
		}
		if (!(AnnexUtil.getAnnexRoot(source) instanceof NamedElement annex) || annex.getName() == null) {
			return null;
		}
		var region = locations.getSignificantTextRegion(source);
		var registry = (AnnexTextPositionResolverRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_TEXTPOSITIONRESOLVER_EXT_ID);
		var resolver = registry == null ? null : registry.getTextPositionResolver(annex.getName());
		if (region == null || region.getLength() <= 0 || resolver == null) {
			return null;
		}
		var position = resolver.resolveCrossReferencedElementAt(annex, region.getOffset());
		if (position == null || position.getOffset() != region.getOffset() || position.getLength() != region.getLength()) {
			return null;
		}
		var target = position.getModelObject();
		return target != null && !target.eIsProxy()
				&& EcoreUtil2.getPlatformResourceOrNormalizedURI(target).equals(description.getTargetEObjectUri())
						? target : null;
	}

	@Override
	protected void createReferenceUpdate(EObject source, URI sourceResourceURI, EReference reference, int index,
			EObject newTarget, IRefactoringUpdateAcceptor acceptor) {
		if (reference != null) {
			super.createReferenceUpdate(source, sourceResourceURI, reference, index, newTarget, acceptor);
			return;
		}
		var region = locations.getSignificantTextRegion(source);
		var name = SimpleAttributeResolver.NAME_RESOLVER.apply(newTarget);
		if (region == null || region.getLength() <= 0 || name == null || name.isEmpty()) {
			acceptor.getRefactoringStatus().add(RefactoringStatus.ERROR,
					"Cannot update symbolic annex reference.", EcoreUtil2.getPlatformResourceOrNormalizedURI(source));
			return;
		}
		acceptor.accept(sourceResourceURI, new ReplaceEdit(region.getOffset(), region.getLength(), name));
	}
}
