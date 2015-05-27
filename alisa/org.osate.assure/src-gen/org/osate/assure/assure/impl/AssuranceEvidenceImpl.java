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

import org.osate.aadl2.ComponentClassifier;

import org.osate.aadl2.instance.InstanceObject;

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
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getSubAssuranceEvidence <em>Sub Assurance Evidence</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl#getClaimResult <em>Claim Result</em>}</li>
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
  protected ComponentClassifier target;

  /**
   * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstance()
   * @generated
   * @ordered
   */
  protected InstanceObject instance;

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
   * The cached value of the '{@link #getSubAssuranceEvidence() <em>Sub Assurance Evidence</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubAssuranceEvidence()
   * @generated
   * @ordered
   */
  protected EList<AssuranceEvidence> subAssuranceEvidence;

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
  public ComponentClassifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentClassifier)eResolveProxy(oldTarget);
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
  public ComponentClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ComponentClassifier newTarget)
  {
    ComponentClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceObject getInstance()
  {
    if (instance != null && instance.eIsProxy())
    {
      InternalEObject oldInstance = (InternalEObject)instance;
      instance = (InstanceObject)eResolveProxy(oldInstance);
      if (instance != oldInstance)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.ASSURANCE_EVIDENCE__INSTANCE, oldInstance, instance));
      }
    }
    return instance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceObject basicGetInstance()
  {
    return instance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstance(InstanceObject newInstance)
  {
    InstanceObject oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURANCE_EVIDENCE__INSTANCE, oldInstance, instance));
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
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return ((InternalEList<?>)getSubAssuranceEvidence()).basicRemove(otherEnd, msgs);
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return ((InternalEList<?>)getClaimResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.ASSURANCE_EVIDENCE__INSTANCE:
        if (resolve) return getInstance();
        return basicGetInstance();
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        return getMessage();
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return getSubAssuranceEvidence();
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return getClaimResult();
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
        setTarget((ComponentClassifier)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__INSTANCE:
        setInstance((InstanceObject)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        setMessage((String)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        getSubAssuranceEvidence().clear();
        getSubAssuranceEvidence().addAll((Collection<? extends AssuranceEvidence>)newValue);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        getClaimResult().clear();
        getClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
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
        setTarget((ComponentClassifier)null);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__INSTANCE:
        setInstance((InstanceObject)null);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        getSubAssuranceEvidence().clear();
        return;
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        getClaimResult().clear();
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
      case AssurePackage.ASSURANCE_EVIDENCE__INSTANCE:
        return instance != null;
      case AssurePackage.ASSURANCE_EVIDENCE__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case AssurePackage.ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE:
        return subAssuranceEvidence != null && !subAssuranceEvidence.isEmpty();
      case AssurePackage.ASSURANCE_EVIDENCE__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
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
