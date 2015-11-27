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
package org.osate.results.results.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.ResultIssue;

import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getResultData <em>Result Data</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultContributorImpl extends MinimalEObjectImpl.Container implements ResultContributor
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected EObject target;

  /**
   * The cached value of the '{@link #getResultData() <em>Result Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultData()
   * @generated
   * @ordered
   */
  protected EList<ResultData> resultData;

  /**
   * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssues()
   * @generated
   * @ordered
   */
  protected EList<ResultIssue> issues;

  /**
   * The cached value of the '{@link #getSubcontributor() <em>Subcontributor</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcontributor()
   * @generated
   * @ordered
   */
  protected EList<ResultContributor> subcontributor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultContributorImpl()
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
    return ResultsPackage.Literals.RESULT_CONTRIBUTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_CONTRIBUTOR__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(EObject newTarget)
  {
    EObject oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_CONTRIBUTOR__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultData> getResultData()
  {
    if (resultData == null)
    {
      resultData = new EObjectContainmentEList<ResultData>(ResultData.class, this, ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA);
    }
    return resultData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultIssue> getIssues()
  {
    if (issues == null)
    {
      issues = new EObjectContainmentEList<ResultIssue>(ResultIssue.class, this, ResultsPackage.RESULT_CONTRIBUTOR__ISSUES);
    }
    return issues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultContributor> getSubcontributor()
  {
    if (subcontributor == null)
    {
      subcontributor = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);
    }
    return subcontributor;
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
      case ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA:
        return ((InternalEList<?>)getResultData()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
        return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return ((InternalEList<?>)getSubcontributor()).basicRemove(otherEnd, msgs);
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
      case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA:
        return getResultData();
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
        return getIssues();
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return getSubcontributor();
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
      case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
        setTarget((EObject)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA:
        getResultData().clear();
        getResultData().addAll((Collection<? extends ResultData>)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
        getIssues().clear();
        getIssues().addAll((Collection<? extends ResultIssue>)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        getSubcontributor().clear();
        getSubcontributor().addAll((Collection<? extends ResultContributor>)newValue);
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
      case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
        setTarget((EObject)null);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA:
        getResultData().clear();
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
        getIssues().clear();
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        getSubcontributor().clear();
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
      case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
        return target != null;
      case ResultsPackage.RESULT_CONTRIBUTOR__RESULT_DATA:
        return resultData != null && !resultData.isEmpty();
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
        return issues != null && !issues.isEmpty();
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return subcontributor != null && !subcontributor.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ResultContributorImpl
