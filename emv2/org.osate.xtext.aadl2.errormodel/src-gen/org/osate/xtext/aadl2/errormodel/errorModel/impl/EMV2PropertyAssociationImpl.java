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

import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;

import org.osate.aadl2.impl.ElementImpl;

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
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getOwnedValues <em>Owned Values</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PropertyAssociationImpl#getEmv2Path <em>Emv2 Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PropertyAssociationImpl extends ElementImpl implements EMV2PropertyAssociation
{
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
   * The cached value of the '{@link #getOwnedValues() <em>Owned Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedValues()
   * @generated
   * @ordered
   */
  protected EList<ModalPropertyValue> ownedValues;

  /**
   * The cached value of the '{@link #getEmv2Path() <em>Emv2 Path</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2Path()
   * @generated
   * @ordered
   */
  protected EList<EMV2Path> emv2Path;

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
  public EList<ModalPropertyValue> getOwnedValues()
  {
    if (ownedValues == null)
    {
      ownedValues = new EObjectContainmentEList<ModalPropertyValue>(ModalPropertyValue.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES);
    }
    return ownedValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EMV2Path> getEmv2Path()
  {
    if (emv2Path == null)
    {
      emv2Path = new EObjectContainmentEList<EMV2Path>(EMV2Path.class, this, ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH);
    }
    return emv2Path;
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
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES:
        return ((InternalEList<?>)getOwnedValues()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH:
        return ((InternalEList<?>)getEmv2Path()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES:
        return getOwnedValues();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH:
        return getEmv2Path();
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
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES:
        getOwnedValues().clear();
        getOwnedValues().addAll((Collection<? extends ModalPropertyValue>)newValue);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH:
        getEmv2Path().clear();
        getEmv2Path().addAll((Collection<? extends EMV2Path>)newValue);
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
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        setProperty((Property)null);
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES:
        getOwnedValues().clear();
        return;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH:
        getEmv2Path().clear();
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
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__PROPERTY:
        return property != null;
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES:
        return ownedValues != null && !ownedValues.isEmpty();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION__EMV2_PATH:
        return emv2Path != null && !emv2Path.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EMV2PropertyAssociationImpl
