/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.ConstantValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.ConstantDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.ConstantDeclImpl#getConstantvalue <em>Constantvalue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantDeclImpl extends MinimalEObjectImpl.Container implements ConstantDecl
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstantvalue() <em>Constantvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstantvalue()
   * @generated
   * @ordered
   */
  protected ConstantValue constantvalue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantDeclImpl()
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
    return CommonPackage.Literals.CONSTANT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSTANT_DECL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantValue getConstantvalue()
  {
    return constantvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstantvalue(ConstantValue newConstantvalue, NotificationChain msgs)
  {
    ConstantValue oldConstantvalue = constantvalue;
    constantvalue = newConstantvalue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.CONSTANT_DECL__CONSTANTVALUE, oldConstantvalue, newConstantvalue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstantvalue(ConstantValue newConstantvalue)
  {
    if (newConstantvalue != constantvalue)
    {
      NotificationChain msgs = null;
      if (constantvalue != null)
        msgs = ((InternalEObject)constantvalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.CONSTANT_DECL__CONSTANTVALUE, null, msgs);
      if (newConstantvalue != null)
        msgs = ((InternalEObject)newConstantvalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.CONSTANT_DECL__CONSTANTVALUE, null, msgs);
      msgs = basicSetConstantvalue(newConstantvalue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.CONSTANT_DECL__CONSTANTVALUE, newConstantvalue, newConstantvalue));
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
      case CommonPackage.CONSTANT_DECL__CONSTANTVALUE:
        return basicSetConstantvalue(null, msgs);
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
      case CommonPackage.CONSTANT_DECL__NAME:
        return getName();
      case CommonPackage.CONSTANT_DECL__CONSTANTVALUE:
        return getConstantvalue();
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
      case CommonPackage.CONSTANT_DECL__NAME:
        setName((String)newValue);
        return;
      case CommonPackage.CONSTANT_DECL__CONSTANTVALUE:
        setConstantvalue((ConstantValue)newValue);
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
      case CommonPackage.CONSTANT_DECL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CommonPackage.CONSTANT_DECL__CONSTANTVALUE:
        setConstantvalue((ConstantValue)null);
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
      case CommonPackage.CONSTANT_DECL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CommonPackage.CONSTANT_DECL__CONSTANTVALUE:
        return constantvalue != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ConstantDeclImpl
