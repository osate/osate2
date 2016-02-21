/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;

import org.osate.aadl2.impl.PropertyAssociationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Property Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getEMV2PropertyAssociationth <em>EMV2 Property Associationth</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getAppliesTo <em>Applies To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PropertyAssociationImpl extends PropertyAssociationImpl implements EMV2PropertyAssociation
{
  /**
   * The cached value of the '{@link #getEMV2PropertyAssociationth() <em>EMV2 Property Associationth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEMV2PropertyAssociationth()
   * @generated
   * @ordered
   */
  protected EMV2Path emv2PropertyAssociationth;

  /**
   * The cached value of the '{@link #getOwnedValue() <em>Owned Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedValue()
   * @generated
   * @ordered
   */
  protected EList<ModalPropertyValue> ownedValue;

  /**
   * The cached value of the '{@link #getAppliesTo() <em>Applies To</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliesTo()
   * @generated
   * @ordered
   */
  protected EList<ContainedNamedElement> appliesTo;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The cached value of the '{@link #getOwnedValue() <em>Owned Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedValue()
   * @generated
   * @ordered
   */
  protected EList<ModalPropertyValue> ownedValue;

  /**
   * The cached value of the '{@link #getAppliesTo() <em>Applies To</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliesTo()
   * @generated
   * @ordered
   */
  protected EList<ContainedNamedElement> appliesTo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMV2PropertyAssociationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ErrorModelPackage.Literals.EMV2_PROPERTY_ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2Path getEMV2PropertyAssociationth()
  {
    return emv2PropertyAssociationth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEMV2PropertyAssociationth(EMV2Path newEMV2PropertyAssociationth, NotificationChain msgs)
  {
    EMV2Path oldEMV2PropertyAssociationth = emv2PropertyAssociationth;
    emv2PropertyAssociationth = newEMV2PropertyAssociationth;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH, oldEMV2PropertyAssociationth, newEMV2PropertyAssociationth);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEMV2PropertyAssociationth(EMV2Path newEMV2PropertyAssociationth)
  {
    if (newEMV2PropertyAssociationth != emv2PropertyAssociationth)
    {
      NotificationChain msgs = null;
      if (emv2PropertyAssociationth != null)
        msgs = ((InternalEObject)emv2PropertyAssociationth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH, null, msgs);
      if (newEMV2PropertyAssociationth != null)
        msgs = ((InternalEObject)newEMV2PropertyAssociationth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH, null, msgs);
      msgs = basicSetEMV2PropertyAssociationth(newEMV2PropertyAssociationth, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH, newEMV2PropertyAssociationth, newEMV2PropertyAssociationth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModalPropertyValue> getOwnedValue()
  {
    if (ownedValue == null)
    {
      ownedValue = new EObjectContainmentEList<ModalPropertyValue>(ModalPropertyValue.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE);
    }
    return ownedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContainedNamedElement> getAppliesTo()
  {
    if (appliesTo == null)
    {
      appliesTo = new EObjectContainmentEList<ContainedNamedElement>(ContainedNamedElement.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO);
    }
    return appliesTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getProperty()
  {
    if (property != null && ((EObject)property).eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (Property)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperty(Property newProperty)
  {
    Property oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getProperty()
  {
    if (property != null && ((EObject)property).eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (Property)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperty(Property newProperty)
  {
    Property oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModalPropertyValue> getOwnedValue()
  {
    if (ownedValue == null)
    {
      ownedValue = new EObjectContainmentEList<ModalPropertyValue>(ModalPropertyValue.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE);
    }
    return ownedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContainedNamedElement> getAppliesTo()
  {
    if (appliesTo == null)
    {
      appliesTo = new EObjectContainmentEList<ContainedNamedElement>(ContainedNamedElement.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO);
    }
    return appliesTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH:
        return basicSetEMV2PropertyAssociationth(null, msgs);
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return ((InternalEList<?>)getOwnedValue()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return ((InternalEList<?>)getAppliesTo()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return ((InternalEList<?>)getOwnedValue()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return ((InternalEList<?>)getAppliesTo()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH:
        return getEMV2PropertyAssociationth();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return getOwnedValue();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return getAppliesTo();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return getOwnedValue();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return getAppliesTo();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH:
        setEMV2PropertyAssociationth((EMV2Path)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        getOwnedValue().clear();
        getOwnedValue().addAll((Collection<? extends ModalPropertyValue>)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        getAppliesTo().clear();
        getAppliesTo().addAll((Collection<? extends ContainedNamedElement>)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        getOwnedValue().clear();
        getOwnedValue().addAll((Collection<? extends ModalPropertyValue>)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        getAppliesTo().clear();
        getAppliesTo().addAll((Collection<? extends ContainedNamedElement>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH:
        setEMV2PropertyAssociationth((EMV2Path)null);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        getOwnedValue().clear();
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        getAppliesTo().clear();
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)null);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)null);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        getOwnedValue().clear();
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        getAppliesTo().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PROPERTY_ASSOCIATIONTH:
        return emv2PropertyAssociationth != null;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return ownedValue != null && !ownedValue.isEmpty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return appliesTo != null && !appliesTo.isEmpty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        return property != null;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        return property != null;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUE:
        return ownedValue != null && !ownedValue.isEmpty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__APPLIES_TO:
        return appliesTo != null && !appliesTo.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EMV2PropertyAssociationImpl
