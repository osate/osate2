/**
 */
package org.osate.model.analysis;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root model class for analysis-specific model classes.  Contains methods related to traversing/visiting the model.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.osate.model.analysis.AnalysisPackage#getAnalysisElement()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisElement extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Does the model element have children?  This is the same as testing whether the list of children returned by getOrderedChildren is empty.
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the children of the model element.  All children are instances of AnalysisElement, but we leave the return type as list of EObject to avoid being forced to copy the list of children in order to create a list of AnalysisElements.  By default this is the same as eContents().  If you need the children to be returned in a specific order then this method needs to be overridden
	 * <!-- end-model-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<EObject> getOrderedChildren();

} // AnalysisElement
