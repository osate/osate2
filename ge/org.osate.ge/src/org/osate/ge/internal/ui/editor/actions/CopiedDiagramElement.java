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
	private final EObject copiedBo;
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
	public CopiedDiagramElement(final DiagramElement diagramElement, final Object originalBo, final EObject copiedBo,
			final EStructuralFeature containingFeature,
			final Point absolutePosition) {
		this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		this.originalBo = Objects.requireNonNull(originalBo, "originalBo must nto be null");

		if (copiedBo == null) {
			this.copiedBo = null;
			this.containingFeature = null;
		} else {
			this.copiedBo = copiedBo;
			this.containingFeature = Objects.requireNonNull(containingFeature,
					"containingFeature  must not be null");
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

	public EObject getCopiedBusinessObject() {
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