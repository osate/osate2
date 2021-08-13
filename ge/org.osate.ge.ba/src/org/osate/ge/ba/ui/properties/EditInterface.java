package org.osate.ge.ba.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * @since 2.0
 */
public interface EditInterface {
	String dialogTitle();
	String dialogMessage();

	boolean isValidModification(final EObject bo, final String newText);

	NamedElement getElementToModify();

	default String getModifiedSource(final String modifiedSrc, final String newText) {
		return modifiedSrc;
	}

	boolean bracketsRequired();
}
