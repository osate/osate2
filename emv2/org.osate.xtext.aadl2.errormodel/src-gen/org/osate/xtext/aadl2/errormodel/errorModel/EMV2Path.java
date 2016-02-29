/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getContainmentPath <em>Containment Path</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getEmv2PropagationKind <em>Emv2 Propagation Kind</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getEmv2Target <em>Emv2 Target</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path()
 * @model
 * @generated
 */
public interface EMV2Path extends EObject, Element
{
  /**
   * Returns the value of the '<em><b>Containment Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Containment Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containment Path</em>' containment reference.
   * @see #setContainmentPath(ContainedNamedElement)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_ContainmentPath()
   * @model containment="true"
   * @generated
   */
  ContainedNamedElement getContainmentPath();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getContainmentPath <em>Containment Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Containment Path</em>' containment reference.
   * @see #getContainmentPath()
   * @generated
   */
  void setContainmentPath(ContainedNamedElement value);

  /**
   * Returns the value of the '<em><b>Emv2 Propagation Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emv2 Propagation Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Emv2 Propagation Kind</em>' attribute.
   * @see #setEmv2PropagationKind(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_Emv2PropagationKind()
   * @model
   * @generated
   */
  String getEmv2PropagationKind();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getEmv2PropagationKind <em>Emv2 Propagation Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Emv2 Propagation Kind</em>' attribute.
   * @see #getEmv2PropagationKind()
   * @generated
   */
  void setEmv2PropagationKind(String value);

  /**
   * Returns the value of the '<em><b>Error Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Type</em>' reference.
   * @see #setErrorType(ErrorTypes)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_ErrorType()
   * @model
   * @generated
   */
  ErrorTypes getErrorType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getErrorType <em>Error Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Type</em>' reference.
   * @see #getErrorType()
   * @generated
   */
  void setErrorType(ErrorTypes value);

  /**
   * Returns the value of the '<em><b>Emv2 Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emv2 Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Emv2 Target</em>' containment reference.
   * @see #setEmv2Target(EMV2PathElement)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2Path_Emv2Target()
   * @model containment="true"
   * @generated
   */
  EMV2PathElement getEmv2Target();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path#getEmv2Target <em>Emv2 Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Emv2 Target</em>' containment reference.
   * @see #getEmv2Target()
   * @generated
   */
  void setEmv2Target(EMV2PathElement value);

} // EMV2Path
