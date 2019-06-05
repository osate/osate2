/**
 */
package org.osate.expr.expr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.NamedElement;

import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.NamedElementRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.impl.NamedElementRefImpl#isCore <em>Core</em>}</li>
 *   <li>{@link org.osate.expr.expr.impl.NamedElementRefImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedElementRefImpl extends ExpressionImpl implements NamedElementRef
{
  /**
   * The default value of the '{@link #isCore() <em>Core</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCore()
   * @generated
   * @ordered
   */
  protected static final boolean CORE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCore() <em>Core</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCore()
   * @generated
   * @ordered
   */
  protected boolean core = CORE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected NamedElement ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedElementRefImpl()
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
    return ExprPackage.Literals.NAMED_ELEMENT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCore()
  {
    return core;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCore(boolean newCore)
  {
    boolean oldCore = core;
    core = newCore;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.NAMED_ELEMENT_REF__CORE, oldCore, core));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getRef()
  {
    if (ref != null && ((EObject)ref).eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (NamedElement)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.NAMED_ELEMENT_REF__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(NamedElement newRef)
  {
    NamedElement oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.NAMED_ELEMENT_REF__REF, oldRef, ref));
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
      case ExprPackage.NAMED_ELEMENT_REF__CORE:
        return isCore();
      case ExprPackage.NAMED_ELEMENT_REF__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case ExprPackage.NAMED_ELEMENT_REF__CORE:
        setCore((Boolean)newValue);
        return;
      case ExprPackage.NAMED_ELEMENT_REF__REF:
        setRef((NamedElement)newValue);
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
      case ExprPackage.NAMED_ELEMENT_REF__CORE:
        setCore(CORE_EDEFAULT);
        return;
      case ExprPackage.NAMED_ELEMENT_REF__REF:
        setRef((NamedElement)null);
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
      case ExprPackage.NAMED_ELEMENT_REF__CORE:
        return core != CORE_EDEFAULT;
      case ExprPackage.NAMED_ELEMENT_REF__REF:
        return ref != null;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (core: ");
    result.append(core);
    result.append(')');
    return result.toString();
  }

} //NamedElementRefImpl
