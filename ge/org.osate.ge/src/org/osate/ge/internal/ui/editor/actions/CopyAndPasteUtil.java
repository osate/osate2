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

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementCopyUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.services.ReferenceBuilderService;

public class CopyAndPasteUtil {
	public static Point getPositionToCopy(final DiagramElement de) {
		return CopyAndPasteUtil.shouldCopyPosition(de) ? DiagramElementLayoutUtil.getAbsolutePosition(de) : null;
	}

	/**
	 * Returns true if the element is not docked, is moveable, has a position.
	 * @param de
	 * @return
	 */
	private static boolean shouldCopyPosition(final DiagramElement de) {
		return de.getDockArea() == null && DiagramElementPredicates.isMoveable(de) && de.hasPosition();
	}

	/**
	 * Copies an element and children and assigns new id's to the diagram element. Only copies EmbeddedBusinessObject instances.
	 * @param elementToCopy
	 * @param newContainer
	 * @param relativeReference is the relative reference to use for the copy of the top level diagram element. If the top-level diagram element has an embedded business object, this reference will be ignored.
	 * @param refBuilder
	 * @return
	 */
	public static DiagramElement copyDiagramElement(final DiagramElement elementToCopy,
			final DiagramNode newContainer,
			final RelativeBusinessObjectReference relativeReference, final ReferenceBuilderService refBuilder) {
		// Copy helper which handles copying embedded business objects and assigning appropriate relative references.
		final DiagramElementCopyUtil.CopyHelper copyHelper = new DiagramElementCopyUtil.CopyHelper() {
			@Override
			public Object getBusinessObject(final DiagramElement elementBeingCopied) {
				return elementBeingCopied.getBusinessObject() instanceof EmbeddedBusinessObject
						? ((EmbeddedBusinessObject) elementBeingCopied.getBusinessObject()).copy()
								: null;
			}

			@Override
			public RelativeBusinessObjectReference getRelativeReference(DiagramElement elementBeingCopied,
					Object newBo) {
				if (newBo instanceof EmbeddedBusinessObject) {
					return refBuilder.getRelativeReference(newBo);
				} else if (elementBeingCopied == elementToCopy) {
					return relativeReference;
				} else {
					return elementBeingCopied.getRelativeReference();
				}
			}
		};

		return DiagramElementCopyUtil.copyWithNewIds(elementToCopy, newContainer, copyHelper);
	}
}
