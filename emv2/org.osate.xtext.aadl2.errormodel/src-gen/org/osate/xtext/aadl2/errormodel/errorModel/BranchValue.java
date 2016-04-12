/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#getRealvalue <em>Realvalue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#getSymboliclabel <em>Symboliclabel</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#isOthers <em>Others</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getBranchValue()
 * @model
 * @generated
 */
public interface BranchValue extends EObject, Element {
	/**
	 * Returns the value of the '<em><b>Realvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realvalue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realvalue</em>' attribute.
	 * @see #setRealvalue(String)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getBranchValue_Realvalue()
	 * @model
	 * @generated
	 */
	String getRealvalue();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#getRealvalue <em>Realvalue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realvalue</em>' attribute.
	 * @see #getRealvalue()
	 * @generated
	 */
	void setRealvalue(String value);

	/**
	 * Returns the value of the '<em><b>Symboliclabel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symboliclabel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symboliclabel</em>' reference.
	 * @see #setSymboliclabel(Property)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getBranchValue_Symboliclabel()
	 * @model
	 * @generated
	 */
	Property getSymboliclabel();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#getSymboliclabel <em>Symboliclabel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symboliclabel</em>' reference.
	 * @see #getSymboliclabel()
	 * @generated
	 */
	void setSymboliclabel(Property value);

	/**
	 * Returns the value of the '<em><b>Others</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Others</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Others</em>' attribute.
	 * @see #setOthers(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getBranchValue_Others()
	 * @model
	 * @generated
	 */
	boolean isOthers();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue#isOthers <em>Others</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Others</em>' attribute.
	 * @see #isOthers()
	 * @generated
	 */
	void setOthers(boolean value);

} // BranchValue
