package org.osate.xtext.aadl2.ui.propertyview;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;

/**
 * Interface for providing the AADL Property View with a property holder
 * @author philip.alldredge
 *
 */
public interface IAadlPropertySource {
	/**
	 * Retrieves the element that contains the properties to be edited.
	 * @return the named element
	 */
	NamedElement getNamedElement();

	/**
	 * Returns the Xtext document that contains the element
	 * @return the Xtext document
	 */
	IXtextDocument getDocument();
}