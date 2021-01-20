/**
 */
package org.osate.analysis.resources.budgets.internal.models.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisPackage#getAnalysisElement()
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
	EList<AnalysisElement> getOrderedChildren();

} // AnalysisElement
