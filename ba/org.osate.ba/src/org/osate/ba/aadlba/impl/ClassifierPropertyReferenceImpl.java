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

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.aadl2.Classifier ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.ClassifierPropertyReference ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Property Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.ClassifierPropertyReferenceImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifierPropertyReferenceImpl extends PropertyReferenceImpl implements ClassifierPropertyReference
{
  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected Classifier classifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifierPropertyReferenceImpl()
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
    return AadlBaPackage.Literals.CLASSIFIER_PROPERTY_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Classifier getClassifier()
  {
    if (classifier != null && ((EObject)classifier).eIsProxy())
    {
      InternalEObject oldClassifier = (InternalEObject)classifier;
      classifier = (Classifier)eResolveProxy(oldClassifier);
      if (classifier != oldClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER, oldClassifier, classifier));
      }
    }
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier basicGetClassifier()
  {
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setClassifier(Classifier newClassifier)
  {
    Classifier oldClassifier = classifier;
    classifier = newClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER, oldClassifier, classifier));
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
      case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER:
        if (resolve) return getClassifier();
        return basicGetClassifier();
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
      case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER:
        setClassifier((Classifier)newValue);
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
      case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER:
        setClassifier((Classifier)null);
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
      case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER:
        return classifier != null;
    }
    return super.eIsSet(featureID);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //ClassifierPropertyReferenceImpl
