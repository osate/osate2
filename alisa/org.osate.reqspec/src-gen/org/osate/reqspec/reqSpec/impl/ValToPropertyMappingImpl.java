/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XVariableDeclaration;

import org.osate.aadl2.Property;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ValToPropertyMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Val To Property Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ValToPropertyMappingImpl#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ValToPropertyMappingImpl#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValToPropertyMappingImpl extends MinimalEObjectImpl.Container implements ValToPropertyMapping
{
  /**
   * The cached value of the '{@link #getConstant() <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstant()
   * @generated
   * @ordered
   */
  protected XVariableDeclaration constant;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValToPropertyMappingImpl()
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
    return ReqSpecPackage.Literals.VAL_TO_PROPERTY_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XVariableDeclaration getConstant()
  {
    if (constant != null && constant.eIsProxy())
    {
      InternalEObject oldConstant = (InternalEObject)constant;
      constant = (XVariableDeclaration)eResolveProxy(oldConstant);
      if (constant != oldConstant)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT, oldConstant, constant));
      }
    }
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XVariableDeclaration basicGetConstant()
  {
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstant(XVariableDeclaration newConstant)
  {
    XVariableDeclaration oldConstant = constant;
    constant = newConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT, oldConstant, constant));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY, oldProperty, property));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY, oldProperty, property));
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
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT:
        if (resolve) return getConstant();
        return basicGetConstant();
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT:
        setConstant((XVariableDeclaration)newValue);
        return;
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY:
        setProperty((Property)newValue);
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
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT:
        setConstant((XVariableDeclaration)null);
        return;
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY:
        setProperty((Property)null);
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
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__CONSTANT:
        return constant != null;
      case ReqSpecPackage.VAL_TO_PROPERTY_MAPPING__PROPERTY:
        return property != null;
    }
    return super.eIsSet(featureID);
  }

} //ValToPropertyMappingImpl
