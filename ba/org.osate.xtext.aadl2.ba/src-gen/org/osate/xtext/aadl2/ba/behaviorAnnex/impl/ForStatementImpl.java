/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.ComponentClassifier;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#isFor <em>For</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#isForall <em>Forall</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#getDataClassifier <em>Data Classifier</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStatementImpl extends BehaviorActionImpl implements ForStatement
{
  /**
   * The default value of the '{@link #isFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFor()
   * @generated
   * @ordered
   */
  protected static final boolean FOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFor()
   * @generated
   * @ordered
   */
  protected boolean for_ = FOR_EDEFAULT;

  /**
   * The default value of the '{@link #isForall() <em>Forall</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForall()
   * @generated
   * @ordered
   */
  protected static final boolean FORALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isForall() <em>Forall</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForall()
   * @generated
   * @ordered
   */
  protected boolean forall = FORALL_EDEFAULT;

  /**
   * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected String variable = VARIABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDataClassifier() <em>Data Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataClassifier()
   * @generated
   * @ordered
   */
  protected ComponentClassifier dataClassifier;

  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected ElementValues values;

  /**
   * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActions()
   * @generated
   * @ordered
   */
  protected BehaviorActions actions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForStatementImpl()
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
    return BehaviorAnnexPackage.Literals.FOR_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFor()
  {
    return for_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFor(boolean newFor)
  {
    boolean oldFor = for_;
    for_ = newFor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__FOR, oldFor, for_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isForall()
  {
    return forall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setForall(boolean newForall)
  {
    boolean oldForall = forall;
    forall = newForall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__FORALL, oldForall, forall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVariable(String newVariable)
  {
    String oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE, oldVariable, variable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComponentClassifier getDataClassifier()
  {
    if (dataClassifier != null && ((EObject)dataClassifier).eIsProxy())
    {
      InternalEObject oldDataClassifier = (InternalEObject)dataClassifier;
      dataClassifier = (ComponentClassifier)eResolveProxy(oldDataClassifier);
      if (dataClassifier != oldDataClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
      }
    }
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetDataClassifier()
  {
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDataClassifier(ComponentClassifier newDataClassifier)
  {
    ComponentClassifier oldDataClassifier = dataClassifier;
    dataClassifier = newDataClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElementValues getValues()
  {
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValues(ElementValues newValues, NotificationChain msgs)
  {
    ElementValues oldValues = values;
    values = newValues;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__VALUES, oldValues, newValues);
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
  public void setValues(ElementValues newValues)
  {
    if (newValues != values)
    {
      NotificationChain msgs = null;
      if (values != null)
        msgs = ((InternalEObject)values).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.FOR_STATEMENT__VALUES, null, msgs);
      if (newValues != null)
        msgs = ((InternalEObject)newValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.FOR_STATEMENT__VALUES, null, msgs);
      msgs = basicSetValues(newValues, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__VALUES, newValues, newValues));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions getActions()
  {
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActions(BehaviorActions newActions, NotificationChain msgs)
  {
    BehaviorActions oldActions = actions;
    actions = newActions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS, oldActions, newActions);
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
  public void setActions(BehaviorActions newActions)
  {
    if (newActions != actions)
    {
      NotificationChain msgs = null;
      if (actions != null)
        msgs = ((InternalEObject)actions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS, null, msgs);
      if (newActions != null)
        msgs = ((InternalEObject)newActions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS, null, msgs);
      msgs = basicSetActions(newActions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS, newActions, newActions));
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
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
        return basicSetValues(null, msgs);
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
        return basicSetActions(null, msgs);
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
      case BehaviorAnnexPackage.FOR_STATEMENT__FOR:
        return isFor();
      case BehaviorAnnexPackage.FOR_STATEMENT__FORALL:
        return isForall();
      case BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE:
        return getVariable();
      case BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER:
        if (resolve) return getDataClassifier();
        return basicGetDataClassifier();
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
        return getValues();
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
        return getActions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case BehaviorAnnexPackage.FOR_STATEMENT__FOR:
        setFor((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__FORALL:
        setForall((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE:
        setVariable((String)newValue);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER:
        setDataClassifier((ComponentClassifier)newValue);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
        setValues((ElementValues)newValue);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
        setActions((BehaviorActions)newValue);
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
      case BehaviorAnnexPackage.FOR_STATEMENT__FOR:
        setFor(FOR_EDEFAULT);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__FORALL:
        setForall(FORALL_EDEFAULT);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE:
        setVariable(VARIABLE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER:
        setDataClassifier((ComponentClassifier)null);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
        setValues((ElementValues)null);
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
        setActions((BehaviorActions)null);
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
      case BehaviorAnnexPackage.FOR_STATEMENT__FOR:
        return for_ != FOR_EDEFAULT;
      case BehaviorAnnexPackage.FOR_STATEMENT__FORALL:
        return forall != FORALL_EDEFAULT;
      case BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE:
        return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
      case BehaviorAnnexPackage.FOR_STATEMENT__DATA_CLASSIFIER:
        return dataClassifier != null;
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
        return values != null;
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
        return actions != null;
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
    result.append(" (for: ");
    result.append(for_);
    result.append(", forall: ");
    result.append(forall);
    result.append(", variable: ");
    result.append(variable);
    result.append(')');
    return result.toString();
  }

} //ForStatementImpl
