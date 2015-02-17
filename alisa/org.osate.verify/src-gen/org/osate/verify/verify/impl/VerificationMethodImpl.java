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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.VerificationCategory;

import org.osate.reqspec.reqSpec.Requirement;

import org.osate.verify.verify.SupportedReporting;
import org.osate.verify.verify.SupportedScopes;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getReporting <em>Reporting</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getMethodPath <em>Method Path</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationMethodImpl extends MinimalEObjectImpl.Container implements VerificationMethod
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
   * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirement()
   * @generated
   * @ordered
   */
  protected Requirement requirement;

  /**
   * The default value of the '{@link #getMethodType() <em>Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodType()
   * @generated
   * @ordered
   */
  protected static final SupportedTypes METHOD_TYPE_EDEFAULT = SupportedTypes.ANALYSIS;

  /**
   * The cached value of the '{@link #getMethodType() <em>Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodType()
   * @generated
   * @ordered
   */
  protected SupportedTypes methodType = METHOD_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected static final SupportedScopes SCOPE_EDEFAULT = SupportedScopes.SELF;

  /**
   * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected SupportedScopes scope = SCOPE_EDEFAULT;

  /**
   * The default value of the '{@link #getReporting() <em>Reporting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReporting()
   * @generated
   * @ordered
   */
  protected static final SupportedReporting REPORTING_EDEFAULT = SupportedReporting.MARKER;

  /**
   * The cached value of the '{@link #getReporting() <em>Reporting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReporting()
   * @generated
   * @ordered
   */
  protected SupportedReporting reporting = REPORTING_EDEFAULT;

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
   * The default value of the '{@link #getMethodPath() <em>Method Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodPath()
   * @generated
   * @ordered
   */
  protected static final String METHOD_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMethodPath() <em>Method Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodPath()
   * @generated
   * @ordered
   */
  protected String methodPath = METHOD_PATH_EDEFAULT;

  /**
   * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditions()
   * @generated
   * @ordered
   */
  protected EList<VerificationCondition> conditions;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected VerificationCategory category;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationMethodImpl()
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
    return VerifyPackage.Literals.VERIFICATION_METHOD;
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__TITLE, oldTitle, title));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_METHOD__REQUIREMENT, oldRequirement, requirement));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__REQUIREMENT, oldRequirement, requirement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SupportedTypes getMethodType()
  {
    return methodType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodType(SupportedTypes newMethodType)
  {
    SupportedTypes oldMethodType = methodType;
    methodType = newMethodType == null ? METHOD_TYPE_EDEFAULT : newMethodType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE, oldMethodType, methodType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SupportedScopes getScope()
  {
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScope(SupportedScopes newScope)
  {
    SupportedScopes oldScope = scope;
    scope = newScope == null ? SCOPE_EDEFAULT : newScope;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__SCOPE, oldScope, scope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SupportedReporting getReporting()
  {
    return reporting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReporting(SupportedReporting newReporting)
  {
    SupportedReporting oldReporting = reporting;
    reporting = newReporting == null ? REPORTING_EDEFAULT : newReporting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__REPORTING, oldReporting, reporting));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMethodPath()
  {
    return methodPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodPath(String newMethodPath)
  {
    String oldMethodPath = methodPath;
    methodPath = newMethodPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_PATH, oldMethodPath, methodPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationCondition> getConditions()
  {
    if (conditions == null)
    {
      conditions = new EObjectContainmentEList<VerificationCondition>(VerificationCondition.class, this, VerifyPackage.VERIFICATION_METHOD__CONDITIONS);
    }
    return conditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory getCategory()
  {
    if (category != null && category.eIsProxy())
    {
      InternalEObject oldCategory = (InternalEObject)category;
      category = (VerificationCategory)eResolveProxy(oldCategory);
      if (category != oldCategory)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_METHOD__CATEGORY, oldCategory, category));
      }
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory basicGetCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(VerificationCategory newCategory)
  {
    VerificationCategory oldCategory = category;
    category = newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__CATEGORY, oldCategory, category));
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
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__CONDITIONS:
        return ((InternalEList<?>)getConditions()).basicRemove(otherEnd, msgs);
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_METHOD__REQUIREMENT:
        if (resolve) return getRequirement();
        return basicGetRequirement();
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        return getMethodType();
      case VerifyPackage.VERIFICATION_METHOD__SCOPE:
        return getScope();
      case VerifyPackage.VERIFICATION_METHOD__REPORTING:
        return getReporting();
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return getDescription();
      case VerifyPackage.VERIFICATION_METHOD__METHOD_PATH:
        return getMethodPath();
      case VerifyPackage.VERIFICATION_METHOD__CONDITIONS:
        return getConditions();
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        if (resolve) return getCategory();
        return basicGetCategory();
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__REQUIREMENT:
        setRequirement((Requirement)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        setMethodType((SupportedTypes)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__SCOPE:
        setScope((SupportedScopes)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__REPORTING:
        setReporting((SupportedReporting)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_PATH:
        setMethodPath((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CONDITIONS:
        getConditions().clear();
        getConditions().addAll((Collection<? extends VerificationCondition>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        setCategory((VerificationCategory)newValue);
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__REQUIREMENT:
        setRequirement((Requirement)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        setMethodType(METHOD_TYPE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__SCOPE:
        setScope(SCOPE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__REPORTING:
        setReporting(REPORTING_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_PATH:
        setMethodPath(METHOD_PATH_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CONDITIONS:
        getConditions().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        setCategory((VerificationCategory)null);
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_METHOD__REQUIREMENT:
        return requirement != null;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        return methodType != METHOD_TYPE_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__SCOPE:
        return scope != SCOPE_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__REPORTING:
        return reporting != REPORTING_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return description != null;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_PATH:
        return METHOD_PATH_EDEFAULT == null ? methodPath != null : !METHOD_PATH_EDEFAULT.equals(methodPath);
      case VerifyPackage.VERIFICATION_METHOD__CONDITIONS:
        return conditions != null && !conditions.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        return category != null;
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
    result.append(", methodType: ");
    result.append(methodType);
    result.append(", scope: ");
    result.append(scope);
    result.append(", reporting: ");
    result.append(reporting);
    result.append(", methodPath: ");
    result.append(methodPath);
    result.append(')');
    return result.toString();
  }

} //VerificationMethodImpl
