/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Connection;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Error Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource()
 * @model
 * @generated
 */
public interface ConnectionErrorSource extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Connection</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection</em>' reference.
   * @see #setConnection(Connection)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_Connection()
   * @model
   * @generated
   */
  Connection getConnection();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getConnection <em>Connection</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connection</em>' reference.
   * @see #getConnection()
   * @generated
   */
  void setConnection(Connection value);

  /**
   * Returns the value of the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' attribute.
   * @see #setAll(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_All()
   * @model
   * @generated
   */
  boolean isAll();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#isAll <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All</em>' attribute.
   * @see #isAll()
   * @generated
   */
  void setAll(boolean value);

  /**
   * Returns the value of the '<em><b>Type Token Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Token Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Token Constraint</em>' containment reference.
   * @see #setTypeTokenConstraint(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_TypeTokenConstraint()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypeTokenConstraint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getTypeTokenConstraint <em>Type Token Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Token Constraint</em>' containment reference.
   * @see #getTypeTokenConstraint()
   * @generated
   */
  void setTypeTokenConstraint(TypeSet value);

  /**
   * Returns the value of the '<em><b>Failure Mode Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure Mode Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Mode Type</em>' containment reference.
   * @see #setFailureModeType(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_FailureModeType()
   * @model containment="true"
   * @generated
   */
  TypeSet getFailureModeType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getFailureModeType <em>Failure Mode Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Mode Type</em>' containment reference.
   * @see #getFailureModeType()
   * @generated
   */
  void setFailureModeType(TypeSet value);

  /**
   * Returns the value of the '<em><b>Failure Mode Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure Mode Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure Mode Description</em>' attribute.
   * @see #setFailureModeDescription(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_FailureModeDescription()
   * @model
   * @generated
   */
  String getFailureModeDescription();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getFailureModeDescription <em>Failure Mode Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure Mode Description</em>' attribute.
   * @see #getFailureModeDescription()
   * @generated
   */
  void setFailureModeDescription(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' attribute.
   * @see #setCondition(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConnectionErrorSource_Condition()
   * @model
   * @generated
   */
  String getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource#getCondition <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' attribute.
   * @see #getCondition()
   * @generated
   */
  void setCondition(String value);

} // ConnectionErrorSource
