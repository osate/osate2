/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Classifier;

import org.osate.alisa.common.common.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Req Specs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getOtherreqspecs <em>Otherreqspecs</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs()
 * @model
 * @generated
 */
public interface ReqSpecs extends ReqSpec, ReqSpecContainer, ReqRoot
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#getName <em>Name</em>}' attribute.
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTitle <em>Title</em>}' attribute.
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
   * @see #setTarget(Classifier)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Target()
   * @model
   * @generated
   */
  Classifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Classifier value);

  /**
   * Returns the value of the '<em><b>Otherreqspecs</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ReqSpecs}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Otherreqspecs</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Otherreqspecs</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Otherreqspecs()
   * @model
   * @generated
   */
  EList<ReqSpecs> getOtherreqspecs();

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Constants()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getConstants();

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Content()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getContent();

} // ReqSpecs
