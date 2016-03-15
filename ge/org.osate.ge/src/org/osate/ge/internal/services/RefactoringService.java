package org.osate.ge.internal.services;

import org.osate.aadl2.NamedElement;

/**
 * Service for performing refactoring operations such as rename on elements. Updates both the AADL model as well as diagram references.
 *
 */
public interface RefactoringService {
	void renameElement(NamedElement ne, final String newName);
}
