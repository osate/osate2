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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.Rationale;

import org.osate.reqspec.reqSpec.Requirement;

import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getActivities <em>Activities</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getAssert <em>Assert</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getSubclaim <em>Subclaim</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ClaimImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClaimImpl extends MinimalEObjectImpl.Container implements Claim
{
  /**
   * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirement()
   * @generated
   * @ordered
   */
  protected Requirement requirement;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivities()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivity> activities;

  /**
   * The cached value of the '{@link #getAssert() <em>Assert</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssert()
   * @generated
   * @ordered
   */
  protected ArgumentExpr assert_;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected Rationale rationale;

  /**
   * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected static final int WEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected int weight = WEIGHT_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubclaim() <em>Subclaim</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubclaim()
   * @generated
   * @ordered
   */
  protected EList<Claim> subclaim;

  /**
   * The cached value of the '{@link #getIssues() <em>Issues</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssues()
   * @generated
   * @ordered
   */
  protected EList<String> issues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClaimImpl()
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
    return VerifyPackage.Literals.CLAIM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Requirement getRequirement()
  {
    if (requirement != null && requirement.eIsProxy())
    {
      InternalEObject oldRequirement = (InternalEObject)requirement;
      requirement = (Requirement)eResolveProxy(oldRequirement);
      if (requirement != oldRequirement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.CLAIM__REQUIREMENT, oldRequirement, requirement));
      }
    }
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement basicGetRequirement()
  {
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRequirement(Requirement newRequirement)
  {
    Requirement oldRequirement = requirement;
    requirement = newRequirement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__REQUIREMENT, oldRequirement, requirement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VerificationActivity> getActivities()
  {
    if (activities == null)
    {
      activities = new EObjectContainmentEList<VerificationActivity>(VerificationActivity.class, this, VerifyPackage.CLAIM__ACTIVITIES);
    }
    return activities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpr getAssert()
  {
    return assert_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssert(ArgumentExpr newAssert, NotificationChain msgs)
  {
    ArgumentExpr oldAssert = assert_;
    assert_ = newAssert;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__ASSERT, oldAssert, newAssert);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssert(ArgumentExpr newAssert)
  {
    if (newAssert != assert_)
    {
      NotificationChain msgs = null;
      if (assert_ != null)
        msgs = ((InternalEObject)assert_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CLAIM__ASSERT, null, msgs);
      if (newAssert != null)
        msgs = ((InternalEObject)newAssert).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CLAIM__ASSERT, null, msgs);
      msgs = basicSetAssert(newAssert, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__ASSERT, newAssert, newAssert));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rationale getRationale()
  {
    return rationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRationale(Rationale newRationale, NotificationChain msgs)
  {
    Rationale oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__RATIONALE, oldRationale, newRationale);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRationale(Rationale newRationale)
  {
    if (newRationale != rationale)
    {
      NotificationChain msgs = null;
      if (rationale != null)
        msgs = ((InternalEObject)rationale).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CLAIM__RATIONALE, null, msgs);
      if (newRationale != null)
        msgs = ((InternalEObject)newRationale).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CLAIM__RATIONALE, null, msgs);
      msgs = basicSetRationale(newRationale, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__RATIONALE, newRationale, newRationale));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getWeight()
  {
    return weight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWeight(int newWeight)
  {
    int oldWeight = weight;
    weight = newWeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CLAIM__WEIGHT, oldWeight, weight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Claim> getSubclaim()
  {
    if (subclaim == null)
    {
      subclaim = new EObjectContainmentEList<Claim>(Claim.class, this, VerifyPackage.CLAIM__SUBCLAIM);
    }
    return subclaim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getIssues()
  {
    if (issues == null)
    {
      issues = new EDataTypeEList<String>(String.class, this, VerifyPackage.CLAIM__ISSUES);
    }
    return issues;
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
      case VerifyPackage.CLAIM__ACTIVITIES:
        return ((InternalEList<?>)getActivities()).basicRemove(otherEnd, msgs);
      case VerifyPackage.CLAIM__ASSERT:
        return basicSetAssert(null, msgs);
      case VerifyPackage.CLAIM__RATIONALE:
        return basicSetRationale(null, msgs);
      case VerifyPackage.CLAIM__SUBCLAIM:
        return ((InternalEList<?>)getSubclaim()).basicRemove(otherEnd, msgs);
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
      case VerifyPackage.CLAIM__REQUIREMENT:
        if (resolve) return getRequirement();
        return basicGetRequirement();
      case VerifyPackage.CLAIM__TITLE:
        return getTitle();
      case VerifyPackage.CLAIM__ACTIVITIES:
        return getActivities();
      case VerifyPackage.CLAIM__ASSERT:
        return getAssert();
      case VerifyPackage.CLAIM__RATIONALE:
        return getRationale();
      case VerifyPackage.CLAIM__WEIGHT:
        return getWeight();
      case VerifyPackage.CLAIM__SUBCLAIM:
        return getSubclaim();
      case VerifyPackage.CLAIM__ISSUES:
        return getIssues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VerifyPackage.CLAIM__REQUIREMENT:
        setRequirement((Requirement)newValue);
        return;
      case VerifyPackage.CLAIM__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.CLAIM__ACTIVITIES:
        getActivities().clear();
        getActivities().addAll((Collection<? extends VerificationActivity>)newValue);
        return;
      case VerifyPackage.CLAIM__ASSERT:
        setAssert((ArgumentExpr)newValue);
        return;
      case VerifyPackage.CLAIM__RATIONALE:
        setRationale((Rationale)newValue);
        return;
      case VerifyPackage.CLAIM__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case VerifyPackage.CLAIM__SUBCLAIM:
        getSubclaim().clear();
        getSubclaim().addAll((Collection<? extends Claim>)newValue);
        return;
      case VerifyPackage.CLAIM__ISSUES:
        getIssues().clear();
        getIssues().addAll((Collection<? extends String>)newValue);
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
      case VerifyPackage.CLAIM__REQUIREMENT:
        setRequirement((Requirement)null);
        return;
      case VerifyPackage.CLAIM__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.CLAIM__ACTIVITIES:
        getActivities().clear();
        return;
      case VerifyPackage.CLAIM__ASSERT:
        setAssert((ArgumentExpr)null);
        return;
      case VerifyPackage.CLAIM__RATIONALE:
        setRationale((Rationale)null);
        return;
      case VerifyPackage.CLAIM__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case VerifyPackage.CLAIM__SUBCLAIM:
        getSubclaim().clear();
        return;
      case VerifyPackage.CLAIM__ISSUES:
        getIssues().clear();
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
      case VerifyPackage.CLAIM__REQUIREMENT:
        return requirement != null;
      case VerifyPackage.CLAIM__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.CLAIM__ACTIVITIES:
        return activities != null && !activities.isEmpty();
      case VerifyPackage.CLAIM__ASSERT:
        return assert_ != null;
      case VerifyPackage.CLAIM__RATIONALE:
        return rationale != null;
      case VerifyPackage.CLAIM__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case VerifyPackage.CLAIM__SUBCLAIM:
        return subclaim != null && !subclaim.isEmpty();
      case VerifyPackage.CLAIM__ISSUES:
        return issues != null && !issues.isEmpty();
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
    result.append(" (title: ");
    result.append(title);
    result.append(", weight: ");
    result.append(weight);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //ClaimImpl
