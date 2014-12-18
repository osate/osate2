/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ReferencePath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.ReferencePathImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.ReferencePathImpl#getSubpath <em>Subpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencePathImpl extends MinimalEObjectImpl.Container implements ReferencePath
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EObject ref;

  /**
   * The cached value of the '{@link #getSubpath() <em>Subpath</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubpath()
   * @generated
   * @ordered
   */
  protected ReferencePath subpath;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferencePathImpl()
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
    return CommonPackage.Literals.REFERENCE_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.REFERENCE_PATH__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(EObject newRef)
  {
    EObject oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REFERENCE_PATH__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencePath getSubpath()
  {
    return subpath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubpath(ReferencePath newSubpath, NotificationChain msgs)
  {
    ReferencePath oldSubpath = subpath;
    subpath = newSubpath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.REFERENCE_PATH__SUBPATH, oldSubpath, newSubpath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubpath(ReferencePath newSubpath)
  {
    if (newSubpath != subpath)
    {
      NotificationChain msgs = null;
      if (subpath != null)
        msgs = ((InternalEObject)subpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.REFERENCE_PATH__SUBPATH, null, msgs);
      if (newSubpath != null)
        msgs = ((InternalEObject)newSubpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.REFERENCE_PATH__SUBPATH, null, msgs);
      msgs = basicSetSubpath(newSubpath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REFERENCE_PATH__SUBPATH, newSubpath, newSubpath));
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
      case CommonPackage.REFERENCE_PATH__SUBPATH:
        return basicSetSubpath(null, msgs);
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
      case CommonPackage.REFERENCE_PATH__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case CommonPackage.REFERENCE_PATH__SUBPATH:
        return getSubpath();
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
      case CommonPackage.REFERENCE_PATH__REF:
        setRef((EObject)newValue);
        return;
      case CommonPackage.REFERENCE_PATH__SUBPATH:
        setSubpath((ReferencePath)newValue);
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
      case CommonPackage.REFERENCE_PATH__REF:
        setRef((EObject)null);
        return;
      case CommonPackage.REFERENCE_PATH__SUBPATH:
        setSubpath((ReferencePath)null);
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
      case CommonPackage.REFERENCE_PATH__REF:
        return ref != null;
      case CommonPackage.REFERENCE_PATH__SUBPATH:
        return subpath != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferencePathImpl
