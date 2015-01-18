/**
 */
package org.osate.assure.assure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.Classifier;

import org.osate.aadl2.instance.InstanceObject;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.HazardResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getInstanceURI <em>Instance URI</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getSubCaseResult <em>Sub Case Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getHazardResult <em>Hazard Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseResultImpl extends AggregateResultImpl implements CaseResult
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Classifier target;

  /**
   * The cached value of the '{@link #getInstanceURI() <em>Instance URI</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceURI()
   * @generated
   * @ordered
   */
  protected InstanceObject instanceURI;

  /**
   * The default value of the '{@link #getPassCount() <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassCount()
   * @generated
   * @ordered
   */
  protected static final int PASS_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPassCount() <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassCount()
   * @generated
   * @ordered
   */
  protected int passCount = PASS_COUNT_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubCaseResult() <em>Sub Case Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubCaseResult()
   * @generated
   * @ordered
   */
  protected EList<CaseResult> subCaseResult;

  /**
   * The cached value of the '{@link #getClaimResult() <em>Claim Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaimResult()
   * @generated
   * @ordered
   */
  protected EList<ClaimResult> claimResult;

  /**
   * The cached value of the '{@link #getHazardResult() <em>Hazard Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHazardResult()
   * @generated
   * @ordered
   */
  protected EList<HazardResult> hazardResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CaseResultImpl()
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
    return AssurePackage.Literals.CASE_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Classifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.CASE_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Classifier newTarget)
  {
    Classifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceObject getInstanceURI()
  {
    if (instanceURI != null && instanceURI.eIsProxy())
    {
      InternalEObject oldInstanceURI = (InternalEObject)instanceURI;
      instanceURI = (InstanceObject)eResolveProxy(oldInstanceURI);
      if (instanceURI != oldInstanceURI)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.CASE_RESULT__INSTANCE_URI, oldInstanceURI, instanceURI));
      }
    }
    return instanceURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceObject basicGetInstanceURI()
  {
    return instanceURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstanceURI(InstanceObject newInstanceURI)
  {
    InstanceObject oldInstanceURI = instanceURI;
    instanceURI = newInstanceURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__INSTANCE_URI, oldInstanceURI, instanceURI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPassCount()
  {
    return passCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPassCount(int newPassCount)
  {
    int oldPassCount = passCount;
    passCount = newPassCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__PASS_COUNT, oldPassCount, passCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CaseResult> getSubCaseResult()
  {
    if (subCaseResult == null)
    {
      subCaseResult = new EObjectContainmentEList<CaseResult>(CaseResult.class, this, AssurePackage.CASE_RESULT__SUB_CASE_RESULT);
    }
    return subCaseResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClaimResult> getClaimResult()
  {
    if (claimResult == null)
    {
      claimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.CASE_RESULT__CLAIM_RESULT);
    }
    return claimResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<HazardResult> getHazardResult()
  {
    if (hazardResult == null)
    {
      hazardResult = new EObjectContainmentEList<HazardResult>(HazardResult.class, this, AssurePackage.CASE_RESULT__HAZARD_RESULT);
    }
    return hazardResult;
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
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return ((InternalEList<?>)getSubCaseResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return ((InternalEList<?>)getClaimResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return ((InternalEList<?>)getHazardResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.CASE_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.CASE_RESULT__INSTANCE_URI:
        if (resolve) return getInstanceURI();
        return basicGetInstanceURI();
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        return getPassCount();
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return getSubCaseResult();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return getClaimResult();
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return getHazardResult();
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
      case AssurePackage.CASE_RESULT__TARGET:
        setTarget((Classifier)newValue);
        return;
      case AssurePackage.CASE_RESULT__INSTANCE_URI:
        setInstanceURI((InstanceObject)newValue);
        return;
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        setPassCount((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        getSubCaseResult().addAll((Collection<? extends CaseResult>)newValue);
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
        getClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
        return;
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        getHazardResult().clear();
        getHazardResult().addAll((Collection<? extends HazardResult>)newValue);
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
      case AssurePackage.CASE_RESULT__TARGET:
        setTarget((Classifier)null);
        return;
      case AssurePackage.CASE_RESULT__INSTANCE_URI:
        setInstanceURI((InstanceObject)null);
        return;
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        setPassCount(PASS_COUNT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
        return;
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        getHazardResult().clear();
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
      case AssurePackage.CASE_RESULT__TARGET:
        return target != null;
      case AssurePackage.CASE_RESULT__INSTANCE_URI:
        return instanceURI != null;
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        return passCount != PASS_COUNT_EDEFAULT;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return subCaseResult != null && !subCaseResult.isEmpty();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return hazardResult != null && !hazardResult.isEmpty();
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (passCount: ");
    result.append(passCount);
    result.append(')');
    return result.toString();
  }

} //CaseResultImpl
