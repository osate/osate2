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

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Represents a single copied diagram element with an optional copied business object.
 *
 */
public class CopiedDiagramElement {
	private final DiagramElement diagramElement; // A copy of a diagram element
	private final Object originalBo; // The business object referenced by the original diagram element
	private final Object copiedBo;
	private final EStructuralFeature containingFeature;
	private final Point absolutePosition;

	/**
	 *
	 * @param diagramElement a copy of a diagram element. Expected to have id and business objects of it and its children set to null.
	 * @param originalBo the business object referenced by the original diagram element
	 * @param copiedBo a copy of the business object.
	 * @param containingFeature
	 * @param position
	 */
	public CopiedDiagramElement(final DiagramElement diagramElement, final Object originalBo, final Object copiedBo,
			final EStructuralFeature containingFeature,
			final Point absolutePosition) {
		this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		this.originalBo = Objects.requireNonNull(originalBo, "originalBo must nto be null");

		this.copiedBo = copiedBo;
		this.containingFeature = containingFeature;

		if(copiedBo instanceof EObject) {
			Objects.requireNonNull(containingFeature, "containingFeature  must not be null");
		}

		this.absolutePosition = absolutePosition;
	}

	/**
	 * Constructor for copying a diagram element without a business object.
	 * @param diagramElement
	 * @param absolutePosition
	 */
	public CopiedDiagramElement(final DiagramElement diagramElement, final Object originalBo,
			final Point absolutePosition) {
		this(diagramElement, originalBo, null, null, absolutePosition);
	}

	public DiagramElement getDiagramElement() {
		return diagramElement;
	}

	public Object getOriginalBo() {
		return originalBo;
	}

	public Object getCopiedBusinessObject() {
		return copiedBo;
	}

	/**
	 * Get the feature the contained the original business object
	 * @return
	 */
	public EStructuralFeature getContainingFeature() {
		return containingFeature;
	}

	/**
	 * @return the absolute position of the copied diagram element or null if the position was not copied.
	 */
	public Point getAbsolutePosition() {
		return absolutePosition;
	}
}