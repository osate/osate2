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
package org.osate.ge.internal.ui.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.ClipboardService;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

public class CopyAction extends ActionStackAction {
	private final ClipboardService.Clipboard clipboard;
	private final ReferenceBuilderService referenceBuilder;

	public CopyAction(final IWorkbenchPart part) {
		super(part);
		setId(ActionFactory.COPY.getId());
		setText("Copy");

		// Get clipboard
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		this.clipboard = Objects.requireNonNull(context.get(ClipboardService.class), "Unable to get clipboard service")
				.getClipboard();
		this.referenceBuilder = Objects.requireNonNull(context.get(ReferenceBuilderService.class),
				"Unable to get reference builder");
	}

	@Override
	public void run() {
		final List<CopiedDiagramElement> copiedElements = new ArrayList<>();

		for (final DiagramElement de : getElementsToCopy()) {
			final DiagramElement copiedElement = CopyAndPasteUtil.copyDiagramElement(de, null,
					de.getRelativeReference(),
					referenceBuilder);
			final Object bo = de.getBusinessObject();
			final Point position = CopyAndPasteUtil.getPositionToCopy(de);
			if (bo instanceof EObject) {
				final EObject boEObj = (EObject) de.getBusinessObject();
				copiedElements.add(
						new CopiedDiagramElement(copiedElement, de.getBusinessObject(), EcoreUtil.copy(boEObj),
								boEObj.eContainingFeature(), position));
			} else if (bo instanceof EmbeddedBusinessObject) {
				// Don't need to copy object again because it was copied as part of copying the diagram element.
				copiedElements.add(new CopiedDiagramElement(copiedElement, de.getBusinessObject(),
						copiedElement.getBusinessObject(), null, position));
			} else {
				throw new RuntimeException("Unsupported case: " + bo);
			}
		}

		clipboard.setContents(new CopiedDiagramElements(ImmutableList.copyOf(copiedElements)));
	}

	@Override
	protected boolean calculateEnabled() {
		return !getElementsToCopy().isEmpty();
	}

	/**
	 *
	 * @return the diagram elements to copy. An empty list of one or more of the selected elements is invalid.
	 */
	private static List<DiagramElement> getElementsToCopy() {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		return isValid(selectedDiagramElements) ? selectedDiagramElements : Collections.emptyList();
	}

	private static boolean isValid(final Collection<DiagramElement> diagramElements) {
		// Verify that all objects are EMF objects which are owned by a containing feature which may contain many values.
		if (!allBusinessObjectsAreCopyable(diagramElements)) {
			return false;
		}

		// None of the selected diagram elements are descendants of any others.
		if (anyAreAncestors(diagramElements)) {
			return false;
		}

		return true;
	}

	/**
	 * Returns true if all business object are copyable. A business object is copyable if it is an embedded business object or
	 * if it is an EObject contained in a many feature.
	 * @param diagramElements
	 * @return
	 */
	private static boolean allBusinessObjectsAreCopyable(final Collection<DiagramElement> diagramElements) {
		return diagramElements.stream().map(DiagramElement::getBusinessObject).allMatch(bo -> {
			if (bo instanceof EmbeddedBusinessObject) {
				return true;
			}

			if (!(bo instanceof EObject)) {
				return false;
			}

			final EObject eObj = (EObject) bo;
			final EStructuralFeature containgFeature = eObj.eContainingFeature();
			return containgFeature != null && containgFeature.isMany();
		});
	}

	/**
	 * Returns true if any of the specified elements are ancestors/descendants of any other element in the specified collection;
	 * @param diagramElements
	 * @return
	 */
	private static boolean anyAreAncestors(final Collection<DiagramElement> diagramElements) {
		for (final DiagramElement tmp : diagramElements) {
			for (DiagramNode ancestor = tmp.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
				if (diagramElements.contains(ancestor)) {
					return true;
				}
			}
		}

		return false;
	}
}
