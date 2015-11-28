/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
import org.osate.alisa.workbench.alisa.ModelPlan;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getAssure <em>Assure</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getAssureSubsystems <em>Assure Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#isAssureAll <em>Assure All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getAssumeSubsystems <em>Assume Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#isAssumeAll <em>Assume All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelPlanImpl extends MinimalEObjectImpl.Container implements ModelPlan
{
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
  protected ModelPlanImpl()
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
    return AlisaPackage.Literals.MODEL_PLAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentImplementation)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.MODEL_PLAN__TARGET, oldTarget, target));
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
  public void setTarget(ComponentImplementation newTarget)
  {
    ComponentImplementation oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.MODEL_PLAN__TARGET, oldTarget, target));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlisaPackage.MODEL_PLAN__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.MODEL_PLAN__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.MODEL_PLAN__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.MODEL_PLAN__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationPlan> getAssure()
  {
    if (assure == null)
    {
      assure = new EObjectResolvingEList<VerificationPlan>(VerificationPlan.class, this, AlisaPackage.MODEL_PLAN__ASSURE);
    }
    return assure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Subcomponent> getAssureSubsystems()
  {
    if (assureSubsystems == null)
    {
      assureSubsystems = new EObjectResolvingEList<Subcomponent>(Subcomponent.class, this, AlisaPackage.MODEL_PLAN__ASSURE_SUBSYSTEMS);
    }
    return assureSubsystems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAssureAll()
  {
    return assureAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssureAll(boolean newAssureAll)
  {
    boolean oldAssureAll = assureAll;
    assureAll = newAssureAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.MODEL_PLAN__ASSURE_ALL, oldAssureAll, assureAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Subcomponent> getAssumeSubsystems()
  {
    if (assumeSubsystems == null)
    {
      assumeSubsystems = new EObjectResolvingEList<Subcomponent>(Subcomponent.class, this, AlisaPackage.MODEL_PLAN__ASSUME_SUBSYSTEMS);
    }
    return assumeSubsystems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAssumeAll()
  {
    return assumeAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssumeAll(boolean newAssumeAll)
  {
    boolean oldAssumeAll = assumeAll;
    assumeAll = newAssumeAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.MODEL_PLAN__ASSUME_ALL, oldAssumeAll, assumeAll));
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
      issues = new EDataTypeEList<String>(String.class, this, AlisaPackage.MODEL_PLAN__ISSUES);
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
      case AlisaPackage.MODEL_PLAN__DESCRIPTION:
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
      case AlisaPackage.MODEL_PLAN__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AlisaPackage.MODEL_PLAN__DESCRIPTION:
        return getDescription();
      case AlisaPackage.MODEL_PLAN__ASSURE:
        return getAssure();
      case AlisaPackage.MODEL_PLAN__ASSURE_SUBSYSTEMS:
        return getAssureSubsystems();
      case AlisaPackage.MODEL_PLAN__ASSURE_ALL:
        return isAssureAll();
      case AlisaPackage.MODEL_PLAN__ASSUME_SUBSYSTEMS:
        return getAssumeSubsystems();
      case AlisaPackage.MODEL_PLAN__ASSUME_ALL:
        return isAssumeAll();
      case AlisaPackage.MODEL_PLAN__ISSUES:
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
      case AlisaPackage.MODEL_PLAN__TARGET:
        setTarget((ComponentImplementation)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE:
        getAssure().clear();
        getAssure().addAll((Collection<? extends VerificationPlan>)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE_SUBSYSTEMS:
        getAssureSubsystems().clear();
        getAssureSubsystems().addAll((Collection<? extends Subcomponent>)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE_ALL:
        setAssureAll((Boolean)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ASSUME_SUBSYSTEMS:
        getAssumeSubsystems().clear();
        getAssumeSubsystems().addAll((Collection<? extends Subcomponent>)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ASSUME_ALL:
        setAssumeAll((Boolean)newValue);
        return;
      case AlisaPackage.MODEL_PLAN__ISSUES:
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
      case AlisaPackage.MODEL_PLAN__TARGET:
        setTarget((ComponentImplementation)null);
        return;
      case AlisaPackage.MODEL_PLAN__DESCRIPTION:
        setDescription((Description)null);
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE:
        getAssure().clear();
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE_SUBSYSTEMS:
        getAssureSubsystems().clear();
        return;
      case AlisaPackage.MODEL_PLAN__ASSURE_ALL:
        setAssureAll(ASSURE_ALL_EDEFAULT);
        return;
      case AlisaPackage.MODEL_PLAN__ASSUME_SUBSYSTEMS:
        getAssumeSubsystems().clear();
        return;
      case AlisaPackage.MODEL_PLAN__ASSUME_ALL:
        setAssumeAll(ASSUME_ALL_EDEFAULT);
        return;
      case AlisaPackage.MODEL_PLAN__ISSUES:
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
      case AlisaPackage.MODEL_PLAN__TARGET:
        return target != null;
      case AlisaPackage.MODEL_PLAN__DESCRIPTION:
        return description != null;
      case AlisaPackage.MODEL_PLAN__ASSURE:
        return assure != null && !assure.isEmpty();
      case AlisaPackage.MODEL_PLAN__ASSURE_SUBSYSTEMS:
        return assureSubsystems != null && !assureSubsystems.isEmpty();
      case AlisaPackage.MODEL_PLAN__ASSURE_ALL:
        return assureAll != ASSURE_ALL_EDEFAULT;
      case AlisaPackage.MODEL_PLAN__ASSUME_SUBSYSTEMS:
        return assumeSubsystems != null && !assumeSubsystems.isEmpty();
      case AlisaPackage.MODEL_PLAN__ASSUME_ALL:
        return assumeAll != ASSUME_ALL_EDEFAULT;
      case AlisaPackage.MODEL_PLAN__ISSUES:
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
    result.append(" (assureAll: ");
    result.append(assureAll);
    result.append(", assumeAll: ");
    result.append(assumeAll);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //ModelPlanImpl
