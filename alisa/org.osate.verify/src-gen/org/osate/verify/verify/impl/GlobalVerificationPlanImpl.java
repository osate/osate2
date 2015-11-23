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
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.reqspec.reqSpec.GlobalRequirements;

import org.osate.verify.verify.GlobalVerificationPlan;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Verification Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.GlobalVerificationPlanImpl#getRequirementLibrary <em>Requirement Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalVerificationPlanImpl extends VerificationPlanImpl implements GlobalVerificationPlan
{
  /**
   * The cached value of the '{@link #getRequirementLibrary() <em>Requirement Library</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementLibrary()
   * @generated
   * @ordered
   */
  protected GlobalRequirements requirementLibrary;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GlobalVerificationPlanImpl()
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
    return VerifyPackage.Literals.GLOBAL_VERIFICATION_PLAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalRequirements getRequirementLibrary()
  {
    if (requirementLibrary != null && requirementLibrary.eIsProxy())
    {
      InternalEObject oldRequirementLibrary = (InternalEObject)requirementLibrary;
      requirementLibrary = (GlobalRequirements)eResolveProxy(oldRequirementLibrary);
      if (requirementLibrary != oldRequirementLibrary)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY, oldRequirementLibrary, requirementLibrary));
      }
    }
    return requirementLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalRequirements basicGetRequirementLibrary()
  {
    return requirementLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirementLibrary(GlobalRequirements newRequirementLibrary)
  {
    GlobalRequirements oldRequirementLibrary = requirementLibrary;
    requirementLibrary = newRequirementLibrary;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY, oldRequirementLibrary, requirementLibrary));
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
      case VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY:
        if (resolve) return getRequirementLibrary();
        return basicGetRequirementLibrary();
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
      case VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY:
        setRequirementLibrary((GlobalRequirements)newValue);
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
      case VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY:
        setRequirementLibrary((GlobalRequirements)null);
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
      case VerifyPackage.GLOBAL_VERIFICATION_PLAN__REQUIREMENT_LIBRARY:
        return requirementLibrary != null;
    }
    return super.eIsSet(featureID);
  }

} //GlobalVerificationPlanImpl
