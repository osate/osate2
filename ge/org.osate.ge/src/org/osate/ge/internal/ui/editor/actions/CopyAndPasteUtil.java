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
