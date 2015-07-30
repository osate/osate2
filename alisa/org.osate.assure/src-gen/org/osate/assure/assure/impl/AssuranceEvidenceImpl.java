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

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.workbench.alisa.AssurancePlan;

import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Evidence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getTargetSystem <em>Target System</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getSubAssuranceEvidence <em>Sub Assurance Evidence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssuranceEvidenceImpl extends AssureResultImpl implements AssuranceEvidence
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected AssurancePlan target;

  /**
   * The cached value of the '{@link #getTargetSystem() <em>Target System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetSystem()
   * @generated
   * @ordered
   */
  protected ComponentImplementation targetSystem;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

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
   * The cached value of the '{@link #getSubAssuranceEvidence() <em>Sub Assurance Evidence</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubAssuranceEvidence()
   * @generated
   * @ordered
   */
  protected EList<AssuranceEvidence> subAssuranceEvidence;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssuranceEvidenceImpl()
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
    return AssurePackage.Literals.ASSURANCE_EVIDENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (AssurancePlan)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.ASSURANCE_EVIDENCE__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(AssurancePlan newTarget)
  {
    AssurancePlan oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation getTargetSystem()
  {
    if (targetSystem != null && ((EObject)targetSystem).eIsProxy())
    {
      InternalEObject oldTargetSystem = (InternalEObject)targetSystem;
      targetSystem = (ComponentImplementation)eResolveProxy(oldTargetSystem);
      if (targetSystem != oldTargetSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM, oldTargetSystem, targetSystem));
      }
    }
    return targetSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation basicGetTargetSystem()
  {
    return targetSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetSystem(ComponentImplementation newTargetSystem)
  {
    ComponentImplementation oldTargetSystem = targetSystem;
    targetSystem = newTargetSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM, oldTargetSystem, targetSystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage)
  {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__MESSAGE, oldMessage, message));
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
      claimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT);
    }
    return claimResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssuranceEvidence> getSubAssuranceEvidence()
  {
    if (subAssuranceEvidence == null)
    {
      subAssuranceEvidence = new EObjectContainmentEList<AssuranceEvidence>(AssuranceEvidence.class, this, AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE);
    }
    return subAssuranceEvidence;
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
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return ((InternalEList<?>)getClaimResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return ((InternalEList<?>)getSubAssuranceEvidence()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.ASSURANCE_EVIDENCE__NAME:
        return getName();
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM:
        if (resolve) return getTargetSystem();
        return basicGetTargetSystem();
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        return getMessage();
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return getClaimResult();
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return getSubAssuranceEvidence();
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
      case AssurePackage.ASSURANCE_EVIDENCE__NAME:
        setName((String)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET:
        setTarget((AssurancePlan)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM:
        setTargetSystem((ComponentImplementation)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        setMessage((String)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        getClaimResult().clear();
        getClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        getSubAssuranceEvidence().clear();
        getSubAssuranceEvidence().addAll((Collection<? extends AssuranceEvidence>)newValue);
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
      case AssurePackage.ASSURANCE_EVIDENCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET:
        setTarget((AssurancePlan)null);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM:
        setTargetSystem((ComponentImplementation)null);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        getClaimResult().clear();
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        getSubAssuranceEvidence().clear();
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
      case AssurePackage.ASSURANCE_EVIDENCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET:
        return target != null;
      case AssurePackage.ASSURANCE_EVIDENCE__TARGET_SYSTEM:
        return targetSystem != null;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return subAssuranceEvidence != null && !subAssuranceEvidence.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", message: ");
    result.append(message);
    result.append(')');
    return result.toString();
  }

} //AssuranceEvidenceImpl
