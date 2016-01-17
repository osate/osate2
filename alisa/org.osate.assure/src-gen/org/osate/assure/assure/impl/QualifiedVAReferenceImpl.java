/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.QualifiedVAReference;

import org.osate.reqspec.reqSpec.Requirement;

import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified VA Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl#getVerificationPlan <em>Verification Plan</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl#getClaim <em>Claim</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl#getVerificationActivity <em>Verification Activity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedVAReferenceImpl extends MinimalEObjectImpl.Container implements QualifiedVAReference
{
  /**
   * The cached value of the '{@link #getVerificationPlan() <em>Verification Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationPlan()
   * @generated
   * @ordered
   */
  protected VerificationPlan verificationPlan;

  /**
   * The cached value of the '{@link #getClaim() <em>Claim</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaim()
   * @generated
   * @ordered
   */
  protected Requirement claim;

  /**
   * The cached value of the '{@link #getVerificationActivity() <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivity()
   * @generated
   * @ordered
   */
  protected VerificationActivity verificationActivity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedVAReferenceImpl()
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
    return AssurePackage.Literals.QUALIFIED_VA_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPlan getVerificationPlan()
  {
    if (verificationPlan != null && verificationPlan.eIsProxy())
    {
      InternalEObject oldVerificationPlan = (InternalEObject)verificationPlan;
      verificationPlan = (VerificationPlan)eResolveProxy(oldVerificationPlan);
      if (verificationPlan != oldVerificationPlan)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN, oldVerificationPlan, verificationPlan));
      }
    }
    return verificationPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPlan basicGetVerificationPlan()
  {
    return verificationPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationPlan(VerificationPlan newVerificationPlan)
  {
    VerificationPlan oldVerificationPlan = verificationPlan;
    verificationPlan = newVerificationPlan;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN, oldVerificationPlan, verificationPlan));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement getClaim()
  {
    if (claim != null && claim.eIsProxy())
    {
      InternalEObject oldClaim = (InternalEObject)claim;
      claim = (Requirement)eResolveProxy(oldClaim);
      if (claim != oldClaim)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM, oldClaim, claim));
      }
    }
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement basicGetClaim()
  {
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClaim(Requirement newClaim)
  {
    Requirement oldClaim = claim;
    claim = newClaim;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM, oldClaim, claim));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity getVerificationActivity()
  {
    if (verificationActivity != null && verificationActivity.eIsProxy())
    {
      InternalEObject oldVerificationActivity = (InternalEObject)verificationActivity;
      verificationActivity = (VerificationActivity)eResolveProxy(oldVerificationActivity);
      if (verificationActivity != oldVerificationActivity)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
      }
    }
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity basicGetVerificationActivity()
  {
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationActivity(VerificationActivity newVerificationActivity)
  {
    VerificationActivity oldVerificationActivity = verificationActivity;
    verificationActivity = newVerificationActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
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
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN:
        if (resolve) return getVerificationPlan();
        return basicGetVerificationPlan();
      case AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM:
        if (resolve) return getClaim();
        return basicGetClaim();
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
        if (resolve) return getVerificationActivity();
        return basicGetVerificationActivity();
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
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN:
        setVerificationPlan((VerificationPlan)newValue);
        return;
      case AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM:
        setClaim((Requirement)newValue);
        return;
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)newValue);
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
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN:
        setVerificationPlan((VerificationPlan)null);
        return;
      case AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM:
        setClaim((Requirement)null);
        return;
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)null);
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
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN:
        return verificationPlan != null;
      case AssurePackage.QUALIFIED_VA_REFERENCE__CLAIM:
        return claim != null;
      case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
        return verificationActivity != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedVAReferenceImpl
