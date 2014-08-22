package org.osate.ge.services;

import org.osate.aadl2.NamedElement;

/**
 * Service for performing refactoring operations such as rename on elements. Updates both the AADL model as well as diagram references.
 * @author philip.alldredge
 *
 */
public interface RefactoringService {
	void renameElement(NamedElement ne, final String newName);
}
