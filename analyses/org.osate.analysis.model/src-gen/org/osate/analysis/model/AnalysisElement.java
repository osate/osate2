/**
 */
package org.osate.analysis.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.osate.analysis.model.ModelPackage#getAnalysisElement()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisElement extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<EObject> getOrderedChildren();

} // AnalysisElement
