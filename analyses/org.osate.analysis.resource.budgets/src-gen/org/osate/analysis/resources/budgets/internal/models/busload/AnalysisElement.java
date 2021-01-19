/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getLabel <em>Label</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getActual <em>Actual</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getBudget <em>Budget</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getAnalysisElement()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getAnalysisElement_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' attribute.
	 * @see #setActual(double)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getAnalysisElement_Actual()
	 * @model
	 * @generated
	 */
	double getActual();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' attribute.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(double value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(double)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getAnalysisElement_Budget()
	 * @model
	 * @generated
	 */
	double getBudget();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(double value);

} // AnalysisElement
