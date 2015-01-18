/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

import org.osate.alisa.common.common.Description;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contractual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement()
 * @model
 * @generated
 */
public interface ContractualElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(NamedElement)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Target()
   * @model
   * @generated
   */
  NamedElement getTarget();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(NamedElement value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rationale</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rationale</em>' attribute.
   * @see #setRationale(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getContractualElement_Rationale()
   * @model
   * @generated
   */
  String getRationale();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' attribute.
   * @see #getRationale()
   * @generated
   */
  void setRationale(String value);

} // ContractualElement
