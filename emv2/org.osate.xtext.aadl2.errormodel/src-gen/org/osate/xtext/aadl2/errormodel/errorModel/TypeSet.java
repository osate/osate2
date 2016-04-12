/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet#getTypeTokens <em>Type Tokens</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet#getAliasedType <em>Aliased Type</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeSet()
 * @model
 * @generated
 */
public interface TypeSet extends ErrorTypes {
	/**
	 * Returns the value of the '<em><b>Type Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeToken}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Tokens</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeSet_TypeTokens()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeToken> getTypeTokens();

	/**
	 * Returns the value of the '<em><b>Aliased Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aliased Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliased Type</em>' reference.
	 * @see #setAliasedType(TypeSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTypeSet_AliasedType()
	 * @model
	 * @generated
	 */
	TypeSet getAliasedType();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet#getAliasedType <em>Aliased Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aliased Type</em>' reference.
	 * @see #getAliasedType()
	 * @generated
	 */
	void setAliasedType(TypeSet value);

} // TypeSet
