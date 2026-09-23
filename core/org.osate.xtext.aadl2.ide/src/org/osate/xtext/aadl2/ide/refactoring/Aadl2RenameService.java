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
package org.osate.xtext.aadl2.ide.refactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.PrepareRenameDefaultBehavior;
import org.eclipse.lsp4j.PrepareRenameParams;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either3;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.rename.ChangeConverter2;
import org.eclipse.xtext.ide.server.rename.IRenameService2;
import org.eclipse.xtext.ide.server.rename.RenameService2;
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.ide.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.osate.annexsupport.AnnexUtil;
import org.osate.xtext.aadl2.util.Aadl2ReferencePositionProvider;

import com.google.inject.Inject;

/**
 * Prepares and edits nested annex identifiers without passing annex objects to
 * the AADL partial serializer.
 */
public class Aadl2RenameService extends RenameService2 {
	@Inject
	private Aadl2ReferencePositionProvider positions;
	@Inject
	private Aadl2AnnexRenameSupport annexRenames;

	@Override
	protected EObject getElementWithIdentifierAt(XtextResource resource, int offset) {
		if (offset < 0) {
			return null;
		}
		if (AnnexUtil.findAnnexLeafNode(resource, offset) != null) {
			var position = positions.getAnnexIdentifierAt(resource, offset);
			return position == null ? null : position.getModelObject();
		}
		return super.getElementWithIdentifierAt(resource, offset);
	}

	@Override
	protected Either3<Range, PrepareRenameResult, PrepareRenameDefaultBehavior> doPrepareRename(Resource resource,
			Document document, PrepareRenameParams params, CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		if (resource instanceof XtextResource xtext && AnnexUtil.findAnnexLeafNode(xtext, offset) != null) {
			for (int candidate = offset; candidate >= 0 && candidate >= offset - 1; candidate--) {
				var position = positions.getAnnexIdentifierAt(xtext, candidate);
				if (position != null) {
					return Either3.forFirst(new Range(document.getPosition(position.getOffset()),
							document.getPosition(position.getOffset() + position.getLength())));
				}
			}
			return null;
		}
		return super.doPrepareRename(resource, document, params, cancelIndicator);
	}

	@Override
	protected void applyModifications(EObject element, WorkspaceEdit edit, ServerRefactoringIssueAcceptor issues,
			IRenameService2.Options options, ILanguageServerAccess.Context readContext) {
		var services = getServiceProviderRegistry().getResourceServiceProvider(element.eResource().getURI());
		var serializer = services.get(IChangeSerializer.class);
		var monitor = new CancelIndicatorProgressMonitor(options.getCancelIndicator());
		serializer.setProgressMonitor(monitor);
		var change = new RenameChange(options.getRenameParams().getNewName(), EcoreUtil.getURI(element));
		var context = new RenameContext(List.of(change), element.eResource().getResourceSet(), serializer, issues);
		boolean embedded = annexRenames.addModifications(element, change.getNewName(), context, monitor);
		if (!embedded)
			services.get(IRenameStrategy2.class).applyRename(context);
		var converter = services.get(ChangeConverter2.Factory.class).create(edit, options.getLanguageServerAccess());
		serializer.applyModifications(converter);
	}
}
