package org.osate.ge.internal.aadlproperties;

import org.osate.aadl2.PropertyAssociation;

/**
 * A ProcessedPropertyAssociation is a property association which has been processed by the AadlPropertyResolver. whose applied to clause has been processed.
 * For Aadl property associations, each path specified in the applies to clause results in a new ProcessedPropertyAssociation.
 * A ProcessedPropertyAssociation may have unprocessed applied to path elements. Such path elements refer to elements that do not exist in the Queryable tree.
 */
public interface ProcessedPropertyAssociation {
	PropertyAssociation getPropertyAssociation();

	int getPropertyAssociationOwnerAncestorLevel();

	boolean isCompletelyProcessed();

	String getUnprocessedPathDescription();

	boolean hasArrayIndices();

	boolean isBindingSpecific();

	boolean isModal();
}