/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.impl;


import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.CalledSubprogramHolder ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.aadlba.SubprogramHolderProxy ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.SubprogramCallActionImpl#getSubprogram <em>Subprogram</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.SubprogramCallActionImpl#getParameterLabels <em>Parameter Labels</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.SubprogramCallActionImpl#getProxy <em>Proxy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramCallActionImpl extends BehaviorElementImpl implements SubprogramCallAction
{
  /**
   * The cached value of the '{@link #getSubprogram() <em>Subprogram</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubprogram()
   * @generated
   * @ordered
   */
  protected CalledSubprogramHolder subprogram;

  /**
   * The cached value of the '{@link #getParameterLabels() <em>Parameter Labels</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterLabels()
   * @generated
   * @ordered
   */
  protected EList<ParameterLabel> parameterLabels;

  /**
   * The cached value of the '{@link #getProxy() <em>Proxy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProxy()
   * @generated
   * @ordered
   */
  protected SubprogramHolderProxy proxy;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubprogramCallActionImpl()
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
    return AadlBaPackage.Literals.SUBPROGRAM_CALL_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CalledSubprogramHolder getSubprogram()
  {
    return subprogram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubprogram(CalledSubprogramHolder newSubprogram, NotificationChain msgs)
  {
    CalledSubprogramHolder oldSubprogram = subprogram;
    subprogram = newSubprogram;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM, oldSubprogram, newSubprogram);
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
  public void setSubprogram(CalledSubprogramHolder newSubprogram)
  {
    if (newSubprogram != subprogram)
    {
      NotificationChain msgs = null;
      if (subprogram != null)
        msgs = ((InternalEObject)subprogram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM, null, msgs);
      if (newSubprogram != null)
        msgs = ((InternalEObject)newSubprogram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM, null, msgs);
      msgs = basicSetSubprogram(newSubprogram, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM, newSubprogram, newSubprogram));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ParameterLabel> getParameterLabels()
  {
    if (parameterLabels == null)
    {
      parameterLabels = new EObjectContainmentEList.Unsettable<ParameterLabel>(ParameterLabel.class, this, AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS);
    }
    return parameterLabels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetParameterLabels()
  {
    if (parameterLabels != null) ((InternalEList.Unsettable<?>)parameterLabels).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetParameterLabels()
  {
    return parameterLabels != null && ((InternalEList.Unsettable<?>)parameterLabels).isSet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SubprogramHolderProxy getProxy()
  {
    return proxy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProxy(SubprogramHolderProxy newProxy, NotificationChain msgs)
  {
    SubprogramHolderProxy oldProxy = proxy;
    proxy = newProxy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY, oldProxy, newProxy);
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
  public void setProxy(SubprogramHolderProxy newProxy)
  {
    if (newProxy != proxy)
    {
      NotificationChain msgs = null;
      if (proxy != null)
        msgs = ((InternalEObject)proxy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY, null, msgs);
      if (newProxy != null)
        msgs = ((InternalEObject)newProxy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY, null, msgs);
      msgs = basicSetProxy(newProxy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY, newProxy, newProxy));
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
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM:
        return basicSetSubprogram(null, msgs);
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
        return ((InternalEList<?>)getParameterLabels()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY:
        return basicSetProxy(null, msgs);
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
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM:
        return getSubprogram();
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
        return getParameterLabels();
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY:
        return getProxy();
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
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM:
        setSubprogram((CalledSubprogramHolder)newValue);
        return;
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
        getParameterLabels().clear();
        getParameterLabels().addAll((Collection<? extends ParameterLabel>)newValue);
        return;
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY:
        setProxy((SubprogramHolderProxy)newValue);
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
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM:
        setSubprogram((CalledSubprogramHolder)null);
        return;
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
        unsetParameterLabels();
        return;
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY:
        setProxy((SubprogramHolderProxy)null);
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
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM:
        return subprogram != null;
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
        return isSetParameterLabels();
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PROXY:
        return proxy != null;
    }
    return super.eIsSet(featureID);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //SubprogramCallActionImpl
