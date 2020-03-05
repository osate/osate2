/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
import org.osate.aadl2.Subcomponent;

import org.osate.alisa.common.common.Description;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssurancePlan;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getAssure <em>Assure</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getAssureGlobal <em>Assure Global</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getAssureSubsystems <em>Assure Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#isAssureAll <em>Assure All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getAssumeSubsystems <em>Assume Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#isAssumeAll <em>Assume All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl#getIssues <em>Issues</em>}</li>
 * </ul>
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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ComponentImplementation target;

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
   * The cached value of the '{@link #getAssure() <em>Assure</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssure()
   * @generated
   * @ordered
   */
  protected EList<VerificationPlan> assure;

  /**
   * The cached value of the '{@link #getAssureGlobal() <em>Assure Global</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssureGlobal()
   * @generated
   * @ordered
   */
  protected EList<VerificationPlan> assureGlobal;

  /**
   * The cached value of the '{@link #getAssureSubsystems() <em>Assure Subsystems</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssureSubsystems()
   * @generated
   * @ordered
   */
  protected EList<Subcomponent> assureSubsystems;

  /**
   * The default value of the '{@link #isAssureAll() <em>Assure All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssureAll()
   * @generated
   * @ordered
   */
  protected static final boolean ASSURE_ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAssureAll() <em>Assure All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssureAll()
   * @generated
   * @ordered
   */
  protected boolean assureAll = ASSURE_ALL_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssumeSubsystems() <em>Assume Subsystems</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssumeSubsystems()
   * @generated
   * @ordered
   */
  protected EList<Subcomponent> assumeSubsystems;

  /**
   * The default value of the '{@link #isAssumeAll() <em>Assume All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssumeAll()
   * @generated
   * @ordered
   */
  protected static final boolean ASSUME_ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAssumeAll() <em>Assume All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssumeAll()
   * @generated
   * @ordered
   */
  protected boolean assumeAll = ASSUME_ALL_EDEFAULT;

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
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public ComponentImplementation getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentImplementation)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.ASSURANCE_PLAN__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(ComponentImplementation newTarget)
  {
    ComponentImplementation oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
  public EList<VerificationPlan> getAssure()
  {
    if (assure == null)
    {
      assure = new EObjectResolvingEList<VerificationPlan>(VerificationPlan.class, this, AlisaPackage.ASSURANCE_PLAN__ASSURE);
    }
    return assure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VerificationPlan> getAssureGlobal()
  {
    if (assureGlobal == null)
    {
      assureGlobal = new EObjectResolvingEList<VerificationPlan>(VerificationPlan.class, this, AlisaPackage.ASSURANCE_PLAN__ASSURE_GLOBAL);
    }
    return assureGlobal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Subcomponent> getAssureSubsystems()
  {
    if (assureSubsystems == null)
    {
      assureSubsystems = new EObjectResolvingEList<Subcomponent>(Subcomponent.class, this, AlisaPackage.ASSURANCE_PLAN__ASSURE_SUBSYSTEMS);
    }
    return assureSubsystems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAssureAll()
  {
    return assureAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssureAll(boolean newAssureAll)
  {
    boolean oldAssureAll = assureAll;
    assureAll = newAssureAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__ASSURE_ALL, oldAssureAll, assureAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Subcomponent> getAssumeSubsystems()
  {
    if (assumeSubsystems == null)
    {
      assumeSubsystems = new EObjectResolvingEList<Subcomponent>(Subcomponent.class, this, AlisaPackage.ASSURANCE_PLAN__ASSUME_SUBSYSTEMS);
    }
    return assumeSubsystems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAssumeAll()
  {
    return assumeAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssumeAll(boolean newAssumeAll)
  {
    boolean oldAssumeAll = assumeAll;
    assumeAll = newAssumeAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_PLAN__ASSUME_ALL, oldAssumeAll, assumeAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      case AlisaPackage.ASSURANCE_PLAN__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        return getDescription();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE:
        return getAssure();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_GLOBAL:
        return getAssureGlobal();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_SUBSYSTEMS:
        return getAssureSubsystems();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_ALL:
        return isAssureAll();
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_SUBSYSTEMS:
        return getAssumeSubsystems();
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_ALL:
        return isAssumeAll();
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
      case AlisaPackage.ASSURANCE_PLAN__TARGET:
        setTarget((ComponentImplementation)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE:
        getAssure().clear();
        getAssure().addAll((Collection<? extends VerificationPlan>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_GLOBAL:
        getAssureGlobal().clear();
        getAssureGlobal().addAll((Collection<? extends VerificationPlan>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_SUBSYSTEMS:
        getAssureSubsystems().clear();
        getAssureSubsystems().addAll((Collection<? extends Subcomponent>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_ALL:
        setAssureAll((Boolean)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_SUBSYSTEMS:
        getAssumeSubsystems().clear();
        getAssumeSubsystems().addAll((Collection<? extends Subcomponent>)newValue);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_ALL:
        setAssumeAll((Boolean)newValue);
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
      case AlisaPackage.ASSURANCE_PLAN__TARGET:
        setTarget((ComponentImplementation)null);
        return;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        setDescription((Description)null);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE:
        getAssure().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_GLOBAL:
        getAssureGlobal().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_SUBSYSTEMS:
        getAssureSubsystems().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_ALL:
        setAssureAll(ASSURE_ALL_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_SUBSYSTEMS:
        getAssumeSubsystems().clear();
        return;
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_ALL:
        setAssumeAll(ASSUME_ALL_EDEFAULT);
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
      case AlisaPackage.ASSURANCE_PLAN__TARGET:
        return target != null;
      case AlisaPackage.ASSURANCE_PLAN__DESCRIPTION:
        return description != null;
      case AlisaPackage.ASSURANCE_PLAN__ASSURE:
        return assure != null && !assure.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_GLOBAL:
        return assureGlobal != null && !assureGlobal.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_SUBSYSTEMS:
        return assureSubsystems != null && !assureSubsystems.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__ASSURE_ALL:
        return assureAll != ASSURE_ALL_EDEFAULT;
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_SUBSYSTEMS:
        return assumeSubsystems != null && !assumeSubsystems.isEmpty();
      case AlisaPackage.ASSURANCE_PLAN__ASSUME_ALL:
        return assumeAll != ASSUME_ALL_EDEFAULT;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", title: ");
    result.append(title);
    result.append(", assureAll: ");
    result.append(assureAll);
    result.append(", assumeAll: ");
    result.append(assumeAll);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //AssurancePlanImpl
