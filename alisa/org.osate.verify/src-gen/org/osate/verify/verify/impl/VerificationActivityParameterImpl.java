/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.ComputeDeclaration;

import org.osate.verify.verify.VerificationActivityParameter;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Activity Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityParameterImpl#getCompute <em>Compute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationActivityParameterImpl extends MinimalEObjectImpl.Container implements VerificationActivityParameter
{
  /**
   * The cached value of the '{@link #getCompute() <em>Compute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompute()
   * @generated
   * @ordered
   */
  protected ComputeDeclaration compute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationActivityParameterImpl()
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
    return VerifyPackage.Literals.VERIFICATION_ACTIVITY_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComputeDeclaration getCompute()
  {
    if (compute != null && compute.eIsProxy())
    {
      InternalEObject oldCompute = (InternalEObject)compute;
      compute = (ComputeDeclaration)eResolveProxy(oldCompute);
      if (compute != oldCompute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE, oldCompute, compute));
      }
    }
    return compute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComputeDeclaration basicGetCompute()
  {
    return compute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompute(ComputeDeclaration newCompute)
  {
    ComputeDeclaration oldCompute = compute;
    compute = newCompute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE, oldCompute, compute));
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
      case VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE:
        if (resolve) return getCompute();
        return basicGetCompute();
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
      case VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE:
        setCompute((ComputeDeclaration)newValue);
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
      case VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE:
        setCompute((ComputeDeclaration)null);
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
      case VerifyPackage.VERIFICATION_ACTIVITY_PARAMETER__COMPUTE:
        return compute != null;
    }
    return super.eIsSet(featureID);
  }

} //VerificationActivityParameterImpl
