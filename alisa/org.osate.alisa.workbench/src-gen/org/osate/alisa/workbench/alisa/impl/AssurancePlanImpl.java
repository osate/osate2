/**
 */
package org.osate.alisa.workbench.alisa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.Description;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getSystem <em>System</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getSubsystemPlans <em>Subsystem Plans</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getVerifiedAssumption <em>Verified Assumption</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssurancePlanImpl extends MinimalEObjectImpl.Container implements AssurancePlan
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
   * The cached value of the '{@link #getSystem() <em>System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystem()
   * @generated
   * @ordered
   */
  protected ComponentImplementation system;

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
   * The cached value of the '{@link #getSubsystemPlans() <em>Subsystem Plans</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubsystemPlans()
   * @generated
   * @ordered
   */
  protected EList<AssurancePlan> subsystemPlans;

  /**
   * The cached value of the '{@link #getVerifiedAssumption() <em>Verified Assumption</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerifiedAssumption()
   * @generated
   * @ordered
   */
  protected EList<AssurancePlan> verifiedAssumption;

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
  protected AssurancePlanImpl()
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
    return AlisaPackage.Literals.ASSURANCE_PLAN;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation getSystem()
  {
    if (system != null && ((EObject)system).eIsProxy())
    {
      InternalEObject oldSystem = (InternalEObject)system;
      system = (ComponentImplementation)eResolveProxy(oldSystem);
      if (system != oldSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.ASSURANCE_PLAN__SYSTEM, oldSystem, system));
      }
    }
    return system;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation basicGetSystem()
  {
    return system;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystem(ComponentImplementation newSystem)
  {
    ComponentImplementation oldSystem = system;
    system = newSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__SYSTEM, oldSystem, system));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_PLAN__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_PLAN__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssurancePlan> getSubsystemPlans()
  {
    if (subsystemPlans == null)
    {
      subsystemPlans = new EObjectResolvingEList<AssurancePlan>(AssurancePlan.class, this, AlisaPackage.ASSURANCE_PLAN__SUBSYSTEM_PLANS);
    }
    return subsystemPlans;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssurancePlan> getVerifiedAssumption()
  {
    if (verifiedAssumption == null)
    {
      verifiedAssumption = new EObjectResolvingEList<AssurancePlan>(AssurancePlan.class, this, AlisaPackage.ASSURANCE_PLAN__VERIFIED_ASSUMPTION);
    }
    return verifiedAssumption;
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
      issues = new EDataTypeEList<String>(String.class, this, AlisaPackage.ASSURANCE_PLAN__ISSUES);
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
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
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
      case AlisaPackage.ASSURANCE_PLAN__NAME:
        return getName();
      case AlisaPackage.ASSURANCE_PLAN__TITLE:
        return getTitle();
      case AlisaPackage.ASSURANCE_PLAN__SYSTEM:
        if (resolve) return getSystem();
        return basicGetSystem();
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        return getDescription();
      case AlisaPackage.ASSURANCE_PLAN__SUBSYSTEM_PLANS:
        return getSubsystemPlans();
      case AlisaPackage.ASSURANCE_PLAN__VERIFIED_ASSUMPTION:
        return getVerifiedAssumption();
      case AlisaPackage.ASSURANCE_PLAN__ISSUES:
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
      case AlisaPackage.ASSURANCE_PLAN__NAME:
        setName((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__TITLE:
        setTitle((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__SYSTEM:
        setSystem((ComponentImplementation)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__SUBSYSTEM_PLANS:
        getSubsystemPlans().clear();
        getSubsystemPlans().addAll((Collection<? extends AssurancePlan>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__VERIFIED_ASSUMPTION:
        getVerifiedAssumption().clear();
        getVerifiedAssumption().addAll((Collection<? extends AssurancePlan>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ISSUES:
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
      case AlisaPackage.ASSURANCE_PLAN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_PLAN__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_PLAN__SYSTEM:
        setSystem((ComponentImplementation)null);
        return;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        setDescription((Description)null);
        return;
      case AlisaPackage.ASSURANCE_PLAN__SUBSYSTEM_PLANS:
        getSubsystemPlans().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__VERIFIED_ASSUMPTION:
        getVerifiedAssumption().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__ISSUES:
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
      case AlisaPackage.ASSURANCE_PLAN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AlisaPackage.ASSURANCE_PLAN__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case AlisaPackage.ASSURANCE_PLAN__SYSTEM:
        return system != null;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        return description != null;
      case AlisaPackage.ASSURANCE_PLAN__SUBSYSTEM_PLANS:
        return subsystemPlans != null && !subsystemPlans.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__VERIFIED_ASSUMPTION:
        return verifiedAssumption != null && !verifiedAssumption.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__ISSUES:
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
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //AssurancePlanImpl
