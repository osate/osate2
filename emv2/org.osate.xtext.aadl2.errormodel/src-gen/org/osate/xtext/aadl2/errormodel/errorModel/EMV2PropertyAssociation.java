/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Property Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getEmv2Path <em>Emv2 Path</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getAppliesTo <em>Applies To</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation()
 * @model
 * @generated
 */
public interface EMV2PropertyAssociation extends EObject
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(Property)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_Property()
   * @model
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

  /**
   * Returns the value of the '<em><b>Owned Value</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ModalPropertyValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Value</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_OwnedValue()
   * @model containment="true"
   * @generated
   */
  EList<ModalPropertyValue> getOwnedValue();

  /**
   * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ContainedNamedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applies To</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applies To</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_AppliesTo()
   * @model containment="true"
   * @generated
   */
  EList<ContainedNamedElement> getAppliesTo();

  /**
   * Returns the value of the '<em><b>Emv2 Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emv2 Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Emv2 Path</em>' containment reference.
   * @see #setEmv2Path(EMV2Path)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_Emv2Path()
   * @model containment="true"
   * @generated
   */
  EMV2Path getEmv2Path();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getEmv2Path <em>Emv2 Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Emv2 Path</em>' containment reference.
   * @see #getEmv2Path()
   * @generated
   */
  void setEmv2Path(EMV2Path value);

  /**
   * Returns the value of the '<em><b>Owned Value</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ModalPropertyValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>From package AADLProperties::Associations.</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Owned Value</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_OwnedValue()
   * @model containment="true" required="true" ordered="false"
   * @generated
   */
  EList<ModalPropertyValue> getOwnedValue();

  /**
   * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ContainedNamedElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>From package AADLProperties::Associations.</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Applies To</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_AppliesTo()
   * @model containment="true" ordered="false"
   * @generated
   */
  EList<ContainedNamedElement> getAppliesTo();

  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>From package AADLProperties::Associations.</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(Property)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_Property()
   * @model required="true" ordered="false"
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

  /**
   * Returns the value of the '<em><b>Owned Value</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ModalPropertyValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>From package AADLProperties::Associations.</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Owned Value</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_OwnedValue()
   * @model containment="true" required="true" ordered="false"
   * @generated
   */
  EList<ModalPropertyValue> getOwnedValue();

  /**
   * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.ContainedNamedElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>From package AADLProperties::Associations.</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Applies To</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_AppliesTo()
   * @model containment="true" ordered="false"
   * @generated
   */
  EList<ContainedNamedElement> getAppliesTo();

} // EMV2PropertyAssociation
