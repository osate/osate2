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
package org.osate.xtext.aadl2.ide;

import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.ide.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.osate.annexsupport.AnnexUtil;
import org.osate.xtext.aadl2.util.Aadl2ReferencePositionProvider;

import com.google.inject.Inject;

/**
 * Preserves the selected target when converting reference-search matches to LSP
 * locations.
 */
public class Aadl2DocumentSymbolService extends DocumentSymbolService {
	@Inject
	private EObjectAtOffsetHelper offsets;
	@Inject
	private IReferenceFinder references;
	@Inject
	private IResourceServiceProvider.Registry registry;
	@Inject
	private Aadl2ReferencePositionProvider positions;

	@Override
	public List<? extends Location> getReferences(Document document, XtextResource resource, ReferenceParams params,
			IReferenceFinder.IResourceAccess access, IResourceDescriptions index, CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		if (!params.getContext().isIncludeDeclaration() || AnnexUtil.findAnnexLeafNode(resource, offset) == null) {
			return super.getReferences(document, resource, params, access, index, cancelIndicator);
		}
		var result = new LinkedHashSet<Location>();
		var identifier = positions.getAnnexIdentifierAt(resource, offset);
		if (identifier != null) {
			doRead(access, EcoreUtil2.getPlatformResourceOrNormalizedURI(identifier.getModelObject()), declaration -> {
				var services = registry.getResourceServiceProvider(declaration.eResource().getURI());
				var location = services.get(DocumentExtensions.class).newLocation(declaration);
				if (location != null) {
					result.add(location);
				}
			});
		}
		result.addAll(getReferences(resource, offset, access, index, cancelIndicator));
		return List.copyOf(result);
	}

	@Override
	public List<? extends Location> getReferences(XtextResource resource, int offset,
			IReferenceFinder.IResourceAccess access, IResourceDescriptions index, CancelIndicator cancelIndicator) {
		var target = offsets.resolveElementAt(resource, offset);
		if (target == null || target.eIsProxy()) {
			return List.of();
		}
		var result = new LinkedHashSet<Location>();
		references.findAllReferences(collectTargetURIs(target), access, index,
				new ReferenceAcceptor(registry, reference -> {
					doRead(access, reference.getSourceEObjectUri(), source -> {
						var region = positions.getReferenceRegion(source, reference.getEReference(),
								reference.getIndexInList(), target);
						if (region != null && region.getLength() > 0) {
							var services = registry.getResourceServiceProvider(source.eResource().getURI());
							var location = services.get(DocumentExtensions.class).newLocation(source.eResource(),
									region);
							if (location != null)
								result.add(location);
						}
					});
				}), new CancelIndicatorProgressMonitor(cancelIndicator));
		return List.copyOf(result);
	}
}
