/**
 */
package org.osate.verify.verify.impl;

import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.verify.verify.ResoluteMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolute Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.ResoluteMethodImpl#getMethodReference <em>Method Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResoluteMethodImpl extends MethodTypeImpl implements ResoluteMethod
{
  /**
   * The cached value of the '{@link #getMethodReference() <em>Method Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodReference()
   * @generated
   * @ordered
   */
  protected FunctionDefinition methodReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResoluteMethodImpl()
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
    return VerifyPackage.Literals.RESOLUTE_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition getMethodReference()
  {
    if (methodReference != null && methodReference.eIsProxy())
    {
      InternalEObject oldMethodReference = (InternalEObject)methodReference;
      methodReference = (FunctionDefinition)eResolveProxy(oldMethodReference);
      if (methodReference != oldMethodReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE, oldMethodReference, methodReference));
      }
    }
    return methodReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition basicGetMethodReference()
  {
    return methodReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodReference(FunctionDefinition newMethodReference)
  {
    FunctionDefinition oldMethodReference = methodReference;
    methodReference = newMethodReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE, oldMethodReference, methodReference));
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
      case VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE:
        if (resolve) return getMethodReference();
        return basicGetMethodReference();
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
      case VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE:
        setMethodReference((FunctionDefinition)newValue);
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
      case VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE:
        setMethodReference((FunctionDefinition)null);
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
      case VerifyPackage.RESOLUTE_METHOD__METHOD_REFERENCE:
        return methodReference != null;
    }
    return super.eIsSet(featureID);
  }

} //ResoluteMethodImpl
