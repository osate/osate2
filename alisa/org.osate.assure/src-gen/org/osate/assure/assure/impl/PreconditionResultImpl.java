/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationResult;

import org.osate.verify.verify.VerificationPrecondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precondition Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreconditionResultImpl extends EvidenceResultImpl implements PreconditionResult
{
  /**
   * The cached value of the '{@link #getVerificationActivity() <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivity()
   * @generated
   * @ordered
   */
  protected VerificationPrecondition verificationActivity;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected VerificationResult status;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PreconditionResultImpl()
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
    return AssurePackage.Literals.PRECONDITION_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPrecondition getVerificationActivity()
  {
    if (verificationActivity != null && verificationActivity.eIsProxy())
    {
      InternalEObject oldVerificationActivity = (InternalEObject)verificationActivity;
      verificationActivity = (VerificationPrecondition)eResolveProxy(oldVerificationActivity);
      if (verificationActivity != oldVerificationActivity)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
      }
    }
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPrecondition basicGetVerificationActivity()
  {
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationActivity(VerificationPrecondition newVerificationActivity)
  {
    VerificationPrecondition oldVerificationActivity = verificationActivity;
    verificationActivity = newVerificationActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResult getStatus()
  {
    return status;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatus(VerificationResult newStatus, NotificationChain msgs)
  {
    VerificationResult oldStatus = status;
    status = newStatus;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__STATUS, oldStatus, newStatus);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatus(VerificationResult newStatus)
  {
    if (newStatus != status)
    {
      NotificationChain msgs = null;
      if (status != null)
        msgs = ((InternalEObject)status).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.PRECONDITION_RESULT__STATUS, null, msgs);
      if (newStatus != null)
        msgs = ((InternalEObject)newStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.PRECONDITION_RESULT__STATUS, null, msgs);
      msgs = basicSetStatus(newStatus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__STATUS, newStatus, newStatus));
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
      case AssurePackage.PRECONDITION_RESULT__STATUS:
        return basicSetStatus(null, msgs);
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
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY:
        if (resolve) return getVerificationActivity();
        return basicGetVerificationActivity();
      case AssurePackage.PRECONDITION_RESULT__STATUS:
        return getStatus();
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
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationPrecondition)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__STATUS:
        setStatus((VerificationResult)newValue);
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
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationPrecondition)null);
        return;
      case AssurePackage.PRECONDITION_RESULT__STATUS:
        setStatus((VerificationResult)null);
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
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_ACTIVITY:
        return verificationActivity != null;
      case AssurePackage.PRECONDITION_RESULT__STATUS:
        return status != null;
    }
    return super.eIsSet(featureID);
  }

} //PreconditionResultImpl
