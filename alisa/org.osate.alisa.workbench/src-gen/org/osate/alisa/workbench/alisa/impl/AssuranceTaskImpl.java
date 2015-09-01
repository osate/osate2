/**
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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.AssuranceTask;
import org.osate.alisa.workbench.alisa.Description;

import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategory;
import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getAssurancePlan <em>Assurance Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getRequirementFilter <em>Requirement Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#isStrictRequirementCategories <em>Strict Requirement Categories</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getVerificationFilter <em>Verification Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#isStrictVerificationCategories <em>Strict Verification Categories</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getSelectionFilter <em>Selection Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#isStrictSelectionCategories <em>Strict Selection Categories</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssuranceTaskImpl extends MinimalEObjectImpl.Container implements AssuranceTask
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
   * The cached value of the '{@link #getAssurancePlan() <em>Assurance Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssurancePlan()
   * @generated
   * @ordered
   */
  protected AssurancePlan assurancePlan;

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
   * The cached value of the '{@link #getRequirementFilter() <em>Requirement Filter</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementFilter()
   * @generated
   * @ordered
   */
  protected EList<RequirementCategory> requirementFilter;

  /**
   * The default value of the '{@link #isStrictRequirementCategories() <em>Strict Requirement Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictRequirementCategories()
   * @generated
   * @ordered
   */
  protected static final boolean STRICT_REQUIREMENT_CATEGORIES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrictRequirementCategories() <em>Strict Requirement Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictRequirementCategories()
   * @generated
   * @ordered
   */
  protected boolean strictRequirementCategories = STRICT_REQUIREMENT_CATEGORIES_EDEFAULT;

  /**
   * The cached value of the '{@link #getVerificationFilter() <em>Verification Filter</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationFilter()
   * @generated
   * @ordered
   */
  protected EList<VerificationCategory> verificationFilter;

  /**
   * The default value of the '{@link #isStrictVerificationCategories() <em>Strict Verification Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictVerificationCategories()
   * @generated
   * @ordered
   */
  protected static final boolean STRICT_VERIFICATION_CATEGORIES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrictVerificationCategories() <em>Strict Verification Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictVerificationCategories()
   * @generated
   * @ordered
   */
  protected boolean strictVerificationCategories = STRICT_VERIFICATION_CATEGORIES_EDEFAULT;

  /**
   * The cached value of the '{@link #getSelectionFilter() <em>Selection Filter</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectionFilter()
   * @generated
   * @ordered
   */
  protected EList<SelectionCategory> selectionFilter;

  /**
   * The default value of the '{@link #isStrictSelectionCategories() <em>Strict Selection Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictSelectionCategories()
   * @generated
   * @ordered
   */
  protected static final boolean STRICT_SELECTION_CATEGORIES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrictSelectionCategories() <em>Strict Selection Categories</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictSelectionCategories()
   * @generated
   * @ordered
   */
  protected boolean strictSelectionCategories = STRICT_SELECTION_CATEGORIES_EDEFAULT;

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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__TITLE, oldTitle, title));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_TASK__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_TASK__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RequirementCategory> getRequirementFilter()
  {
    if (requirementFilter == null)
    {
      requirementFilter = new EObjectResolvingEList<RequirementCategory>(RequirementCategory.class, this, AlisaPackage.ASSURANCE_TASK__REQUIREMENT_FILTER);
    }
    return requirementFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStrictRequirementCategories()
  {
    return strictRequirementCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrictRequirementCategories(boolean newStrictRequirementCategories)
  {
    boolean oldStrictRequirementCategories = strictRequirementCategories;
    strictRequirementCategories = newStrictRequirementCategories;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__STRICT_REQUIREMENT_CATEGORIES, oldStrictRequirementCategories, strictRequirementCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationCategory> getVerificationFilter()
  {
    if (verificationFilter == null)
    {
      verificationFilter = new EObjectResolvingEList<VerificationCategory>(VerificationCategory.class, this, AlisaPackage.ASSURANCE_TASK__VERIFICATION_FILTER);
    }
    return verificationFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStrictVerificationCategories()
  {
    return strictVerificationCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrictVerificationCategories(boolean newStrictVerificationCategories)
  {
    boolean oldStrictVerificationCategories = strictVerificationCategories;
    strictVerificationCategories = newStrictVerificationCategories;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__STRICT_VERIFICATION_CATEGORIES, oldStrictVerificationCategories, strictVerificationCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectionCategory> getSelectionFilter()
  {
    if (selectionFilter == null)
    {
      selectionFilter = new EObjectResolvingEList<SelectionCategory>(SelectionCategory.class, this, AlisaPackage.ASSURANCE_TASK__SELECTION_FILTER);
    }
    return selectionFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStrictSelectionCategories()
  {
    return strictSelectionCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrictSelectionCategories(boolean newStrictSelectionCategories)
  {
    boolean oldStrictSelectionCategories = strictSelectionCategories;
    strictSelectionCategories = newStrictSelectionCategories;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__STRICT_SELECTION_CATEGORIES, oldStrictSelectionCategories, strictSelectionCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIssues()
  {
    if (issues == null)
    {
      issues = new EDataTypeEList<String>(String.class, this, AlisaPackage.ASSURANCE_TASK__ISSUES);
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
      case AlisaPackage.ASSURANCE_TASK__DESCRIPTION:
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
      case AlisaPackage.ASSURANCE_TASK__NAME:
        return getName();
      case AlisaPackage.ASSURANCE_TASK__TITLE:
        return getTitle();
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        if (resolve) return getAssurancePlan();
        return basicGetAssurancePlan();
      case AlisaPackage.ASSURANCE_TASK__DESCRIPTION:
        return getDescription();
      case AlisaPackage.ASSURANCE_TASK__REQUIREMENT_FILTER:
        return getRequirementFilter();
      case AlisaPackage.ASSURANCE_TASK__STRICT_REQUIREMENT_CATEGORIES:
        return isStrictRequirementCategories();
      case AlisaPackage.ASSURANCE_TASK__VERIFICATION_FILTER:
        return getVerificationFilter();
      case AlisaPackage.ASSURANCE_TASK__STRICT_VERIFICATION_CATEGORIES:
        return isStrictVerificationCategories();
      case AlisaPackage.ASSURANCE_TASK__SELECTION_FILTER:
        return getSelectionFilter();
      case AlisaPackage.ASSURANCE_TASK__STRICT_SELECTION_CATEGORIES:
        return isStrictSelectionCategories();
      case AlisaPackage.ASSURANCE_TASK__ISSUES:
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
      case AlisaPackage.ASSURANCE_TASK__NAME:
        setName((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__TITLE:
        setTitle((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        setAssurancePlan((AssurancePlan)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__REQUIREMENT_FILTER:
        getRequirementFilter().clear();
        getRequirementFilter().addAll((Collection<? extends RequirementCategory>)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_REQUIREMENT_CATEGORIES:
        setStrictRequirementCategories((Boolean)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__VERIFICATION_FILTER:
        getVerificationFilter().clear();
        getVerificationFilter().addAll((Collection<? extends VerificationCategory>)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_VERIFICATION_CATEGORIES:
        setStrictVerificationCategories((Boolean)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__SELECTION_FILTER:
        getSelectionFilter().clear();
        getSelectionFilter().addAll((Collection<? extends SelectionCategory>)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_SELECTION_CATEGORIES:
        setStrictSelectionCategories((Boolean)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__ISSUES:
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
      case AlisaPackage.ASSURANCE_TASK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_TASK__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        setAssurancePlan((AssurancePlan)null);
        return;
      case AlisaPackage.ASSURANCE_TASK__DESCRIPTION:
        setDescription((Description)null);
        return;
      case AlisaPackage.ASSURANCE_TASK__REQUIREMENT_FILTER:
        getRequirementFilter().clear();
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_REQUIREMENT_CATEGORIES:
        setStrictRequirementCategories(STRICT_REQUIREMENT_CATEGORIES_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_TASK__VERIFICATION_FILTER:
        getVerificationFilter().clear();
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_VERIFICATION_CATEGORIES:
        setStrictVerificationCategories(STRICT_VERIFICATION_CATEGORIES_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_TASK__SELECTION_FILTER:
        getSelectionFilter().clear();
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_SELECTION_CATEGORIES:
        setStrictSelectionCategories(STRICT_SELECTION_CATEGORIES_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_TASK__ISSUES:
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
      case AlisaPackage.ASSURANCE_TASK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AlisaPackage.ASSURANCE_TASK__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case AlisaPackage.ASSURANCE_TASK__ASSURANCE_PLAN:
        return assurancePlan != null;
      case AlisaPackage.ASSURANCE_TASK__DESCRIPTION:
        return description != null;
      case AlisaPackage.ASSURANCE_TASK__REQUIREMENT_FILTER:
        return requirementFilter != null && !requirementFilter.isEmpty();
      case AlisaPackage.ASSURANCE_TASK__STRICT_REQUIREMENT_CATEGORIES:
        return strictRequirementCategories != STRICT_REQUIREMENT_CATEGORIES_EDEFAULT;
      case AlisaPackage.ASSURANCE_TASK__VERIFICATION_FILTER:
        return verificationFilter != null && !verificationFilter.isEmpty();
      case AlisaPackage.ASSURANCE_TASK__STRICT_VERIFICATION_CATEGORIES:
        return strictVerificationCategories != STRICT_VERIFICATION_CATEGORIES_EDEFAULT;
      case AlisaPackage.ASSURANCE_TASK__SELECTION_FILTER:
        return selectionFilter != null && !selectionFilter.isEmpty();
      case AlisaPackage.ASSURANCE_TASK__STRICT_SELECTION_CATEGORIES:
        return strictSelectionCategories != STRICT_SELECTION_CATEGORIES_EDEFAULT;
      case AlisaPackage.ASSURANCE_TASK__ISSUES:
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", title: ");
    result.append(title);
    result.append(", strictRequirementCategories: ");
    result.append(strictRequirementCategories);
    result.append(", strictVerificationCategories: ");
    result.append(strictVerificationCategories);
    result.append(", strictSelectionCategories: ");
    result.append(strictSelectionCategories);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //AssuranceTaskImpl
