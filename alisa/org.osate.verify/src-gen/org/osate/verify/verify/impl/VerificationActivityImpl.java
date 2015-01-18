/**
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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.SelectionCategory;

import org.osate.reqspec.reqSpec.Requirement;

import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getRationale <em>Rationale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationActivityImpl extends MinimalEObjectImpl.Container implements VerificationActivity
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
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected EList<SelectionCategory> category;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected VerificationMethod method;

  /**
   * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected static final int TIMEOUT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected int timeout = TIMEOUT_EDEFAULT;

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
  protected VerificationActivityImpl()
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
    return VerifyPackage.Literals.VERIFICATION_ACTIVITY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement getRequirement()
  {
    if (requirement != null && requirement.eIsProxy())
    {
      InternalEObject oldRequirement = (InternalEObject)requirement;
      requirement = (Requirement)eResolveProxy(oldRequirement);
      if (requirement != oldRequirement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT, oldRequirement, requirement));
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
  public void setRequirement(Requirement newRequirement)
  {
    Requirement oldRequirement = requirement;
    requirement = newRequirement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT, oldRequirement, requirement));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TITLE, oldTitle, title));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectionCategory> getCategory()
  {
    if (category == null)
    {
      category = new EObjectResolvingEList<SelectionCategory>(SelectionCategory.class, this, VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY);
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod getMethod()
  {
    if (method != null && method.eIsProxy())
    {
      InternalEObject oldMethod = (InternalEObject)method;
      method = (VerificationMethod)eResolveProxy(oldMethod);
      if (method != oldMethod)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
      }
    }
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod basicGetMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(VerificationMethod newMethod)
  {
    VerificationMethod oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTimeout()
  {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeout(int newTimeout)
  {
    int oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, oldTimeout, timeout));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__RATIONALE, oldRationale, rationale));
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
      case VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION:
        return basicSetDescription(null, msgs);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT:
        if (resolve) return getRequirement();
        return basicGetRequirement();
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION:
        return getDescription();
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        return getCategory();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        if (resolve) return getMethod();
        return basicGetMethod();
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return getTimeout();
      case VerifyPackage.VERIFICATION_ACTIVITY__RATIONALE:
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT:
        setRequirement((Requirement)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        getCategory().clear();
        getCategory().addAll((Collection<? extends SelectionCategory>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout((Integer)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__RATIONALE:
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT:
        setRequirement((Requirement)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION:
        setDescription((Description)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        getCategory().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__RATIONALE:
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_ACTIVITY__REQUIREMENT:
        return requirement != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_ACTIVITY__DESCRIPTION:
        return description != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        return category != null && !category.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        return method != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
      case VerifyPackage.VERIFICATION_ACTIVITY__RATIONALE:
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
    result.append(", timeout: ");
    result.append(timeout);
    result.append(", rationale: ");
    result.append(rationale);
    result.append(')');
    return result.toString();
  }

} //VerificationActivityImpl
