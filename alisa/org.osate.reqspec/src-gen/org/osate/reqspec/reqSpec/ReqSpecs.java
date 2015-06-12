/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

import org.osate.aadl2.Classifier;

import org.osate.alisa.common.common.Description;

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
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getTargetDescription <em>Target Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getOtherreqspecs <em>Otherreqspecs</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecs#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs()
 * @model
 * @generated
 */
public interface ReqSpecs extends ReqSpecContainer, ReqRoot
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
   * Returns the value of the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Description</em>' attribute.
   * @see #setTargetDescription(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_TargetDescription()
   * @model
   * @generated
   */
  String getTargetDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTargetDescription <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Description</em>' attribute.
   * @see #getTargetDescription()
   * @generated
   */
  void setTargetDescription(String value);

  /**
   * Returns the value of the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global</em>' attribute.
   * @see #setGlobal(boolean)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

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
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecs#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
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
   * Returns the value of the '<em><b>Computes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Computes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Computes</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Computes()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getComputes();

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
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
  EList<Requirement> getContent();

  /**
   * Returns the value of the '<em><b>Doc Reference</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ExternalDocument}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Doc Reference</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Reference</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_DocReference()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDocument> getDocReference();

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecs_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // ReqSpecs
