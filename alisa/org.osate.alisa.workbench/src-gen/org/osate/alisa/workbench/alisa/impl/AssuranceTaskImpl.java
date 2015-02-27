/**
 */
package org.osate.alisa.workbench.alisa.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.AssuranceTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getAssurancePlan <em>Assurance Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssuranceTaskImpl extends AssurancePlanImpl implements AssuranceTask
{
  /**
   * The cached value of the '{@link #getAssurancePlan() <em>Assurance Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssurancePlan()
   * @generated
   * @ordered
   */
  protected AssurancePlan assurancePlan;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssuranceTaskImpl()
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
    return AlisaPackage.Literals.ASSURANCE_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan getAssurancePlan()
  {
    if (assurancePlan != null && assurancePlan.eIsProxy())
    {
      InternalEObject oldAssurancePlan = (InternalEObject)assurancePlan;
      assurancePlan = (AssurancePlan)eResolveProxy(oldAssurancePlan);
      if (assurancePlan != oldAssurancePlan)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN, oldAssurancePlan, assurancePlan));
      }
    }
    return assurancePlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan basicGetAssurancePlan()
  {
    return assurancePlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssurancePlan(AssurancePlan newAssurancePlan)
  {
    AssurancePlan oldAssurancePlan = assurancePlan;
    assurancePlan = newAssurancePlan;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN, oldAssurancePlan, assurancePlan));
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
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        if (resolve) return getAssurancePlan();
        return basicGetAssurancePlan();
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
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        setAssurancePlan((AssurancePlan)newValue);
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
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        setAssurancePlan((AssurancePlan)null);
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
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        return assurancePlan != null;
    }
    return super.eIsSet(featureID);
  }

} //AssuranceTaskImpl
