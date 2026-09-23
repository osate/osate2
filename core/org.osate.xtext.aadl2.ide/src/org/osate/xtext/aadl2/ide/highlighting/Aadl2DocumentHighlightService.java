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
package org.osate.xtext.aadl2.ide.highlighting;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.DocumentHighlightParams;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIConverter;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.occurrences.DefaultDocumentHighlightService;
import org.eclipse.xtext.ide.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.ide.util.DocumentHighlightComparator;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.osate.xtext.aadl2.util.Aadl2ReferencePositionProvider;

import com.google.inject.Inject;

/** Highlights semantic annex uses at their individual identifier segments.
 * @since 2.1*/
public class Aadl2DocumentHighlightService extends DefaultDocumentHighlightService {
	@Inject
	private IReferenceFinder references;
	@Inject
	private TargetURIConverter targets;
	@Inject
	private Aadl2ReferencePositionProvider positions;
	@Inject
	private DocumentHighlightComparator comparator;

	@Override
	public List<? extends DocumentHighlight> getDocumentHighlights(Document document, XtextResource resource,
			DocumentHighlightParams params, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getParseResult() == null) {
			return List.of();
		}
		int offset = document.getOffSet(params.getPosition());
		if (offset < 0 || offset >= document.getContents().length()) {
			return List.of();
		}
		var target = offsetHelper.resolveElementAt(resource, offset);
		if (!isDocumentHighlightAvailableFor(target, resource, offset)) {
			return List.of();
		}
		var result = new LinkedHashSet<DocumentHighlight>();
		var monitor = new CancelIndicatorProgressMonitor(cancelIndicator);
		references.findReferences(targets.fromIterable(getTargetURIs(target)), resource,
				new IReferenceFinder.Acceptor() {
					@Override
					public void accept(IReferenceDescription description) {
					}
					@Override
					public void accept(EObject source, URI sourceURI, EReference reference, int index,
							EObject actualTarget, URI targetURI) {
						var region = positions.getReferenceRegion(source, reference, index, target);
						if (region != null && region.getLength() > 0) {
							result.add(textRegionTransformer.apply(document, region, DocumentHighlightKind.Read));
						}
					}
				}, monitor);
		if (target.eResource() == resource) {
			var region = locationInFileProvider.getSignificantTextRegion(target);
			if (region != null && region.getLength() > 0) {
				result.add(textRegionTransformer.apply(document, region, DocumentHighlightKind.Write));
			}
		}
		var sorted = new ArrayList<>(result);
		sorted.sort(comparator);
		return sorted;
	}
}
