/**
 */
package org.osate.verify.verify.impl;

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

import org.osate.aadl2.ComponentClassifier;

import org.osate.alisa.common.common.Description;

import org.osate.verify.verify.Claim;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerifyPackage;
import org.osate.verify.verify.WeightedClaim;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getClaim <em>Claim</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getWeightedClaim <em>Weighted Claim</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationPlanImpl#getRationale <em>Rationale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationPlanImpl extends MinimalEObjectImpl.Container implements VerificationPlan
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
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getClaim() <em>Claim</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaim()
   * @generated
   * @ordered
   */
  protected EList<Claim> claim;

  /**
   * The cached value of the '{@link #getWeightedClaim() <em>Weighted Claim</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeightedClaim()
   * @generated
   * @ordered
   */
  protected EList<WeightedClaim> weightedClaim;

  /**
   * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected static final String RATIONALE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected String rationale = RATIONALE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationPlanImpl()
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
    return VerifyPackage.Literals.VERIFICATION_PLAN;
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__NAME, oldName, name));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_PLAN__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs)
  {
    Description oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_PLAN__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_PLAN__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Claim> getClaim()
  {
    if (claim == null)
    {
      claim = new EObjectContainmentEList<Claim>(Claim.class, this, VerifyPackage.VERIFICATION_PLAN__CLAIM);
    }
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<WeightedClaim> getWeightedClaim()
  {
    if (weightedClaim == null)
    {
      weightedClaim = new EObjectContainmentEList<WeightedClaim>(WeightedClaim.class, this, VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM);
    }
    return weightedClaim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRationale()
  {
    return rationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRationale(String newRationale)
  {
    String oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_PLAN__RATIONALE, oldRationale, rationale));
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
      case VerifyPackage.VERIFICATION_PLAN__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case VerifyPackage.VERIFICATION_PLAN__CLAIM:
        return ((InternalEList<?>)getClaim()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM:
        return ((InternalEList<?>)getWeightedClaim()).basicRemove(otherEnd, msgs);
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
      case VerifyPackage.VERIFICATION_PLAN__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_PLAN__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case VerifyPackage.VERIFICATION_PLAN__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_PLAN__DESCRIPTION:
        return getDescription();
      case VerifyPackage.VERIFICATION_PLAN__CLAIM:
        return getClaim();
      case VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM:
        return getWeightedClaim();
      case VerifyPackage.VERIFICATION_PLAN__RATIONALE:
        return getRationale();
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
      case VerifyPackage.VERIFICATION_PLAN__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__TARGET:
        setTarget((ComponentClassifier)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__CLAIM:
        getClaim().clear();
        getClaim().addAll((Collection<? extends Claim>)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM:
        getWeightedClaim().clear();
        getWeightedClaim().addAll((Collection<? extends WeightedClaim>)newValue);
        return;
      case VerifyPackage.VERIFICATION_PLAN__RATIONALE:
        setRationale((String)newValue);
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
      case VerifyPackage.VERIFICATION_PLAN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_PLAN__TARGET:
        setTarget((ComponentClassifier)null);
        return;
      case VerifyPackage.VERIFICATION_PLAN__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_PLAN__DESCRIPTION:
        setDescription((Description)null);
        return;
      case VerifyPackage.VERIFICATION_PLAN__CLAIM:
        getClaim().clear();
        return;
      case VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM:
        getWeightedClaim().clear();
        return;
      case VerifyPackage.VERIFICATION_PLAN__RATIONALE:
        setRationale(RATIONALE_EDEFAULT);
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
      case VerifyPackage.VERIFICATION_PLAN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_PLAN__TARGET:
        return target != null;
      case VerifyPackage.VERIFICATION_PLAN__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_PLAN__DESCRIPTION:
        return description != null;
      case VerifyPackage.VERIFICATION_PLAN__CLAIM:
        return claim != null && !claim.isEmpty();
      case VerifyPackage.VERIFICATION_PLAN__WEIGHTED_CLAIM:
        return weightedClaim != null && !weightedClaim.isEmpty();
      case VerifyPackage.VERIFICATION_PLAN__RATIONALE:
        return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
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
    result.append(", title: ");
    result.append(title);
    result.append(", rationale: ");
    result.append(rationale);
    result.append(')');
    return result.toString();
  }

} //VerificationPlanImpl
