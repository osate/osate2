package org.osate.ge.internal.diagram.runtime;

import java.util.UUID;

public class DiagramElementCopyUtil {
	public interface CopyHelper {
		Object getBusinessObject(final DiagramElement elementBeingCopied);

		RelativeBusinessObjectReference getRelativeReference(final DiagramElement elementBeingCopied,
				final Object newBo);
	}

	/**
	 * Copies an element and children and assigns new id's to the diagram element. Does not copy business objects.
	 * Those fields are set to values provided by the specified copy helper.
	 * Expected to be used as part of the copy and paste process.
	 * Because the business object is null, it is expected that the diagram update process will be executed after such
	 * objects are added to the diagram. This will ensure that the business object is set appropriately.
	 * References to business objects are copied, but not the objects themselves.
	 * @param newContainer
	 * @param relativeReference
	 * @return
	 */
	public static DiagramElement copyWithNewIds(final DiagramElement elementToCopy, final DiagramNode newContainer,
			final CopyHelper copyHelper) {
		final Object newBo = copyHelper.getBusinessObject(elementToCopy);
		final RelativeBusinessObjectReference relativeBoRef = copyHelper.getRelativeReference(elementToCopy, newBo);
		final DiagramElement newElement = new DiagramElement(newContainer, newBo,
				elementToCopy.getBusinessObjectHandler(), relativeBoRef, UUID.randomUUID());

		newElement.setCompleteness(elementToCopy.getCompleteness());
		newElement.setLabelName(elementToCopy.getLabelName());
		newElement.setUserInterfaceName(elementToCopy.getUserInterfaceName());
		newElement.setGraphicalConfiguration(elementToCopy.getGraphicalConfiguration());
		newElement.setStyle(elementToCopy.getStyle());
		newElement.setPosition(elementToCopy.getPosition());
		newElement.setSize(elementToCopy.getSize());
		newElement.setDockArea(elementToCopy.getDockArea());
		newElement.setBendpoints(elementToCopy.getBendpoints());
		newElement.setConnectionPrimaryLabelPosition(elementToCopy.getConnectionPrimaryLabelPosition());

		// Copy children
		for (final DiagramElement child : elementToCopy.getDiagramElements()) {
			final DiagramElement copyOfChild = copyWithNewIds(child, newElement, copyHelper);
			newElement.getModifiableDiagramElements().add(copyOfChild);
		}

		return newElement;

	}
}
