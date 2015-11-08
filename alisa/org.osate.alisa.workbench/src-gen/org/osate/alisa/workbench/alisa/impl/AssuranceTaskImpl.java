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

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getAssurancePlan <em>Assurance Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#isStrictFilter <em>Strict Filter</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl#getIssues <em>Issues</em>}</li>
 * </ul>
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
   * The cached value of the '{@link #getFilter() <em>Filter</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilter()
   * @generated
   * @ordered
   */
  protected EList<Category> filter;

  /**
   * The default value of the '{@link #isStrictFilter() <em>Strict Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictFilter()
   * @generated
   * @ordered
   */
  protected static final boolean STRICT_FILTER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrictFilter() <em>Strict Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrictFilter()
   * @generated
   * @ordered
   */
  protected boolean strictFilter = STRICT_FILTER_EDEFAULT;

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
  public EList<Category> getFilter()
  {
    if (filter == null)
    {
      filter = new EObjectResolvingEList<Category>(Category.class, this, AlisaPackage.ASSURANCE_TASK__FILTER);
    }
    return filter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStrictFilter()
  {
    return strictFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrictFilter(boolean newStrictFilter)
  {
    boolean oldStrictFilter = strictFilter;
    strictFilter = newStrictFilter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_TASK__STRICT_FILTER, oldStrictFilter, strictFilter));
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
      case AlisaPackage.ASSURANCE_TASK__FILTER:
        return getFilter();
      case AlisaPackage.ASSURANCE_TASK__STRICT_FILTER:
        return isStrictFilter();
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
      case AlisaPackage.ASSURANCE_TASK__FILTER:
        getFilter().clear();
        getFilter().addAll((Collection<? extends Category>)newValue);
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_FILTER:
        setStrictFilter((Boolean)newValue);
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
      case AlisaPackage.ASSURANCE_TASK__FILTER:
        getFilter().clear();
        return;
      case AlisaPackage.ASSURANCE_TASK__STRICT_FILTER:
        setStrictFilter(STRICT_FILTER_EDEFAULT);
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
      case AlisaPackage.ASSURANCE_TASK__FILTER:
        return filter != null && !filter.isEmpty();
      case AlisaPackage.ASSURANCE_TASK__STRICT_FILTER:
        return strictFilter != STRICT_FILTER_EDEFAULT;
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
    result.append(", strictFilter: ");
    result.append(strictFilter);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //AssuranceTaskImpl
