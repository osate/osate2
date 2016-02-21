/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Property Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getEMV2PropertyAssociationth <em>EMV2 Property Associationth</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getAppliesTo <em>Applies To</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation()
 * @model
 * @generated
 */
public interface EMV2PropertyAssociation extends EObject, PropertyAssociation
{
  /**
   * Returns the value of the '<em><b>EMV2 Property Associationth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EMV2 Property Associationth</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EMV2 Property Associationth</em>' containment reference.
   * @see #setEMV2PropertyAssociationth(EMV2Path)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getEMV2PropertyAssociation_EMV2PropertyAssociationth()
   * @model containment="true"
   * @generated
   */
  EMV2Path getEMV2PropertyAssociationth();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation#getEMV2PropertyAssociationth <em>EMV2 Property Associationth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EMV2 Property Associationth</em>' containment reference.
   * @see #getEMV2PropertyAssociationth()
   * @generated
   */
  void setEMV2PropertyAssociationth(EMV2Path value);

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
