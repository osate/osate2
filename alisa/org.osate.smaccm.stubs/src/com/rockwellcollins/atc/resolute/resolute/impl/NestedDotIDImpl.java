/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Dot ID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl#getBase <em>Base</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl#getSub <em>Sub</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedDotIDImpl extends MinimalEObjectImpl.Container implements NestedDotID
{
  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected NamedElement base;

  /**
   * The cached value of the '{@link #getSub() <em>Sub</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub()
   * @generated
   * @ordered
   */
  protected NestedDotID sub;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NestedDotIDImpl()
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
    return ResolutePackage.Literals.NESTED_DOT_ID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getBase()
  {
    if (base != null && ((EObject)base).eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (NamedElement)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResolutePackage.NESTED_DOT_ID__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(NamedElement newBase)
  {
    NamedElement oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.NESTED_DOT_ID__BASE, oldBase, base));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedDotID getSub()
  {
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSub(NestedDotID newSub, NotificationChain msgs)
  {
    NestedDotID oldSub = sub;
    sub = newSub;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResolutePackage.NESTED_DOT_ID__SUB, oldSub, newSub);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub(NestedDotID newSub)
  {
    if (newSub != sub)
    {
      NotificationChain msgs = null;
      if (sub != null)
        msgs = ((InternalEObject)sub).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResolutePackage.NESTED_DOT_ID__SUB, null, msgs);
      if (newSub != null)
        msgs = ((InternalEObject)newSub).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResolutePackage.NESTED_DOT_ID__SUB, null, msgs);
      msgs = basicSetSub(newSub, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.NESTED_DOT_ID__SUB, newSub, newSub));
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
      case ResolutePackage.NESTED_DOT_ID__SUB:
        return basicSetSub(null, msgs);
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
      case ResolutePackage.NESTED_DOT_ID__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case ResolutePackage.NESTED_DOT_ID__SUB:
        return getSub();
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
      case ResolutePackage.NESTED_DOT_ID__BASE:
        setBase((NamedElement)newValue);
        return;
      case ResolutePackage.NESTED_DOT_ID__SUB:
        setSub((NestedDotID)newValue);
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
      case ResolutePackage.NESTED_DOT_ID__BASE:
        setBase((NamedElement)null);
        return;
      case ResolutePackage.NESTED_DOT_ID__SUB:
        setSub((NestedDotID)null);
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
      case ResolutePackage.NESTED_DOT_ID__BASE:
        return base != null;
      case ResolutePackage.NESTED_DOT_ID__SUB:
        return sub != null;
    }
    return super.eIsSet(featureID);
  }

} //NestedDotIDImpl
