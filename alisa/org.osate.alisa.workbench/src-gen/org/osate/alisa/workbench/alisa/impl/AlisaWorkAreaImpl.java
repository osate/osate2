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
package org.osate.alisa.workbench.alisa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AssurancePlan;

import org.osate.categories.categories.CategoryFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlisaWorkAreaImpl extends MinimalEObjectImpl.Container implements AlisaWorkArea
{
  /**
   * The cached value of the '{@link #getPlan() <em>Plan</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan()
   * @generated
   * @ordered
   */
  protected AssurancePlan plan;

  /**
   * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTasks()
   * @generated
   * @ordered
   */
  protected EList<CategoryFilter> tasks;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlisaWorkAreaImpl()
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
    return AlisaPackage.Literals.ALISA_WORK_AREA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan getPlan()
  {
    return plan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPlan(AssurancePlan newPlan, NotificationChain msgs)
  {
    AssurancePlan oldPlan = plan;
    plan = newPlan;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlisaPackage.ALISA_WORK_AREA__PLAN, oldPlan, newPlan);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlan(AssurancePlan newPlan)
  {
    if (newPlan != plan)
    {
      NotificationChain msgs = null;
      if (plan != null)
        msgs = ((InternalEObject)plan).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ALISA_WORK_AREA__PLAN, null, msgs);
      if (newPlan != null)
        msgs = ((InternalEObject)newPlan).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ALISA_WORK_AREA__PLAN, null, msgs);
      msgs = basicSetPlan(newPlan, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ALISA_WORK_AREA__PLAN, newPlan, newPlan));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CategoryFilter> getTasks()
  {
    if (tasks == null)
    {
      tasks = new EObjectContainmentEList<CategoryFilter>(CategoryFilter.class, this, AlisaPackage.ALISA_WORK_AREA__TASKS);
    }
    return tasks;
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
      case AlisaPackage.ALISA_WORK_AREA__PLAN:
        return basicSetPlan(null, msgs);
      case AlisaPackage.ALISA_WORK_AREA__TASKS:
        return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
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
      case AlisaPackage.ALISA_WORK_AREA__PLAN:
        return getPlan();
      case AlisaPackage.ALISA_WORK_AREA__TASKS:
        return getTasks();
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
      case AlisaPackage.ALISA_WORK_AREA__PLAN:
        setPlan((AssurancePlan)newValue);
        return;
      case AlisaPackage.ALISA_WORK_AREA__TASKS:
        getTasks().clear();
        getTasks().addAll((Collection<? extends CategoryFilter>)newValue);
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
      case AlisaPackage.ALISA_WORK_AREA__PLAN:
        setPlan((AssurancePlan)null);
        return;
      case AlisaPackage.ALISA_WORK_AREA__TASKS:
        getTasks().clear();
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
      case AlisaPackage.ALISA_WORK_AREA__PLAN:
        return plan != null;
      case AlisaPackage.ALISA_WORK_AREA__TASKS:
        return tasks != null && !tasks.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AlisaWorkAreaImpl
