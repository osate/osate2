/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime;

import java.util.UUID;

import org.osate.ge.RelativeBusinessObjectReference;

/**
 * Utility class containing members related to copying {@link DiagramElement} instances.
 *
 */
public final class DiagramElementCopyUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private DiagramElementCopyUtil() {
	}

	/**
	 * Interface which assists in copying {@link DiagramElement} instances.
	 * @see DiagramElementCopyUtil#copyWithNewIds
	 */
	public interface CopyHelper {
		/**
		 * Returns the business object for the new diagram element
		 * @param elementBeingCopied the diagram element being copied
		 * @return the business object for the new diagram element
		 */
		Object getBusinessObject(final DiagramElement elementBeingCopied);

		/**
		 * Returns the reference for the new diagram element
		 * @param elementBeingCopied the diagram element being copied
		 * @param newBo the business object for the new diagram element which was returned by {@link CopyHelper#getBusinessObject(DiagramElement)}
		 * @return the reference for the new diagram element
		 */
		RelativeBusinessObjectReference getRelativeReference(final DiagramElement elementBeingCopied,
				final Object newBo);
	}

	/**
	 * Copies an element and descendants and assigns new id's to the diagram element. Does not copy business objects.
	 * Expected to be used as part of the copy and paste process.
	 * @param elementToCopy the diagram element being copied
	 * @param newContainer the parent of the new diagram element
	 * @param copyHelper the helper which provides the business object and relative reference for the new diagram element.
	 * @return the new diagram element
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
		for (final DiagramElement child : elementToCopy.getChildren()) {
			final DiagramElement copyOfChild = copyWithNewIds(child, newElement, copyHelper);
			newElement.getModifiableChildren().add(copyOfChild);
		}

		return newElement;
	}
}
