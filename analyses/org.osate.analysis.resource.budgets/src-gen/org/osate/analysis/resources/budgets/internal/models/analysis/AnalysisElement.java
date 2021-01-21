/**
 */
package org.osate.analysis.resources.budgets.internal.models.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.result.Result;

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
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisPackage#getAnalysisElement()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(Result)
	 * @see org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisPackage#getAnalysisElement_Result()
	 * @model
	 * @generated
	 */
	Result getResult();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Result value);

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
