/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root#getLibrary <em>Library</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root#getSubclauses <em>Subclauses</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Root()
 * @model
 * @generated
 */
public interface EMV2Root extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Library</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Library</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Library</em>' containment reference.
   * @see #setLibrary(ErrorModelLibrary)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Root_Library()
   * @model containment="true"
   * @generated
   */
  ErrorModelLibrary getLibrary();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root#getLibrary <em>Library</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Library</em>' containment reference.
   * @see #getLibrary()
   * @generated
   */
  void setLibrary(ErrorModelLibrary value);

  /**
   * Returns the value of the '<em><b>Subclauses</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subclauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subclauses</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Root_Subclauses()
   * @model containment="true"
   * @generated
   */
  EList<ErrorModelSubclause> getSubclauses();

} // EMV2Root
