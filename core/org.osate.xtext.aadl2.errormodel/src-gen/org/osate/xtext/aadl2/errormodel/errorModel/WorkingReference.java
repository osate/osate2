/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Working Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isSelf <em>Self</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isWorking <em>Working</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getWorkingReference()
 * @model
 * @generated
 */
public interface WorkingReference extends TriggerConditionExpression
{
  /**
   * Returns the value of the '<em><b>Binding</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binding</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binding</em>' attribute.
   * @see #setBinding(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getWorkingReference_Binding()
   * @model
   * @generated
   */
  String getBinding();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getBinding <em>Binding</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binding</em>' attribute.
   * @see #getBinding()
   * @generated
   */
  void setBinding(String value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(Feature)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getWorkingReference_Feature()
   * @model
   * @generated
   */
  Feature getFeature();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Self</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self</em>' attribute.
   * @see #setSelf(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getWorkingReference_Self()
   * @model
   * @generated
   */
  boolean isSelf();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isSelf <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self</em>' attribute.
   * @see #isSelf()
   * @generated
   */
  void setSelf(boolean value);

  /**
   * Returns the value of the '<em><b>Working</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Working</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Working</em>' attribute.
   * @see #setWorking(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getWorkingReference_Working()
   * @model
   * @generated
   */
  boolean isWorking();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isWorking <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Working</em>' attribute.
   * @see #isWorking()
   * @generated
   */
  void setWorking(boolean value);

} // WorkingReference
