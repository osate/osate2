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
package org.osate.ge.internal.ui.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.ClipboardService;
import org.osate.ge.internal.services.ClipboardService.Clipboard;
import org.osate.ge.internal.ui.editor.actions.CopiedDiagramElement;
import org.osate.ge.internal.ui.editor.actions.CopiedDiagramElements;
import org.osate.ge.internal.ui.editor.actions.CopyAndPasteUtil;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

public class CopyDiagramElementsHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();

		// Require that at least one element be selected
		if (!selectedDiagramElements.isEmpty()) {
			// Require that they all have the same parent.
			final DiagramNode searchParent = selectedDiagramElements.get(0).getParent();
			enabled = selectedDiagramElements.stream().allMatch(de -> de.getParent() == searchParent);
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get clipboard. The clipboard service stores the clipboard weakly but this handler does not need to
		// because the paste action stores a strong reference to the clipboard. This isn't stored in a field by
		// the constructor because the handler is not instantiated for each editor.
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		final Clipboard clipboard = Objects
				.requireNonNull(context.get(ClipboardService.class), "Unable to get clipboard service")
				.getClipboard();
		final ReferenceBuilderService refBuilder = Objects
				.requireNonNull(context.get(ReferenceBuilderService.class), "Unable to get reference builder service");

		final List<CopiedDiagramElement> copiedElements = new ArrayList<>();

		for (final DiagramElement de : AgeHandlerUtil.getSelectedDiagramElements()) {
			final DiagramElement copiedElement = CopyAndPasteUtil.copyDiagramElement(de, null,
					de.getRelativeReference(), refBuilder);
			final Point position = CopyAndPasteUtil.getPositionToCopy(de);
			copiedElements.add(
					new CopiedDiagramElement(copiedElement, de.getBusinessObject(), position));
		}

		clipboard.setContents(new CopiedDiagramElements(ImmutableList.copyOf(copiedElements)));

		return null;
	}

}
