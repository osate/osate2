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
package org.osate.verify.verify.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Property;

import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.TargetType;

import org.osate.categories.categories.Category;

import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.MethodKind;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getFormals <em>Formals</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#isIsPredicate <em>Is Predicate</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#isIsResultReport <em>Is Result Report</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getMethodKind <em>Method Kind</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getValidation <em>Validation</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getCategory <em>Category</em>}</li>
 * </ul>
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
   * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetType()
   * @generated
   * @ordered
   */
  protected static final TargetType TARGET_TYPE_EDEFAULT = TargetType.COMPONENT;

  /**
   * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetType()
   * @generated
   * @ordered
   */
  protected TargetType targetType = TARGET_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFormals() <em>Formals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormals()
   * @generated
   * @ordered
   */
  protected EList<FormalParameter> formals;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Property> properties;

  /**
   * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResults()
   * @generated
   * @ordered
   */
  protected EList<FormalParameter> results;

  /**
   * The default value of the '{@link #isIsPredicate() <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPredicate()
   * @generated
   * @ordered
   */
  protected static final boolean IS_PREDICATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsPredicate() <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPredicate()
   * @generated
   * @ordered
   */
  protected boolean isPredicate = IS_PREDICATE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsResultReport() <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResultReport()
   * @generated
   * @ordered
   */
  protected static final boolean IS_RESULT_REPORT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsResultReport() <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResultReport()
   * @generated
   * @ordered
   */
  protected boolean isResultReport = IS_RESULT_REPORT_EDEFAULT;

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
  protected ComponentClassifier target;

  /**
   * The cached value of the '{@link #getComponentCategory() <em>Component Category</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentCategory()
   * @generated
   * @ordered
   */
  protected EList<ComponentCategory> componentCategory;

  /**
   * The cached value of the '{@link #getMethodKind() <em>Method Kind</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodKind()
   * @generated
   * @ordered
   */
  protected MethodKind methodKind;

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
   * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecondition()
   * @generated
   * @ordered
   */
  protected VerificationCondition precondition;

  /**
   * The cached value of the '{@link #getValidation() <em>Validation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidation()
   * @generated
   * @ordered
   */
  protected VerificationCondition validation;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected EList<Category> category;

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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TargetType getTargetType()
  {
    return targetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTargetType(TargetType newTargetType)
  {
    TargetType oldTargetType = targetType;
    targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__TARGET_TYPE, oldTargetType, targetType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FormalParameter> getFormals()
  {
    if (formals == null)
    {
      formals = new EObjectContainmentEList<FormalParameter>(FormalParameter.class, this, VerifyPackage.VERIFICATION_METHOD__FORMALS);
    }
    return formals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Property> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectResolvingEList<Property>(Property.class, this, VerifyPackage.VERIFICATION_METHOD__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FormalParameter> getResults()
  {
    if (results == null)
    {
      results = new EObjectContainmentEList<FormalParameter>(FormalParameter.class, this, VerifyPackage.VERIFICATION_METHOD__RESULTS);
    }
    return results;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsPredicate()
  {
    return isPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsPredicate(boolean newIsPredicate)
  {
    boolean oldIsPredicate = isPredicate;
    isPredicate = newIsPredicate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE, oldIsPredicate, isPredicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsResultReport()
  {
    return isResultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsResultReport(boolean newIsResultReport)
  {
    boolean oldIsResultReport = isResultReport;
    isResultReport = newIsResultReport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT, oldIsResultReport, isResultReport));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComponentClassifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentClassifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_METHOD__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(ComponentClassifier newTarget)
  {
    ComponentClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ComponentCategory> getComponentCategory()
  {
    if (componentCategory == null)
    {
      componentCategory = new EDataTypeEList<ComponentCategory>(ComponentCategory.class, this, VerifyPackage.VERIFICATION_METHOD__COMPONENT_CATEGORY);
    }
    return componentCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MethodKind getMethodKind()
  {
    return methodKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethodKind(MethodKind newMethodKind, NotificationChain msgs)
  {
    MethodKind oldMethodKind = methodKind;
    methodKind = newMethodKind;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_KIND, oldMethodKind, newMethodKind);
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
  public void setMethodKind(MethodKind newMethodKind)
  {
    if (newMethodKind != methodKind)
    {
      NotificationChain msgs = null;
      if (methodKind != null)
        msgs = ((InternalEObject)methodKind).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__METHOD_KIND, null, msgs);
      if (newMethodKind != null)
        msgs = ((InternalEObject)newMethodKind).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__METHOD_KIND, null, msgs);
      msgs = basicSetMethodKind(newMethodKind, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_KIND, newMethodKind, newMethodKind));
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
  @Override
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
  @Override
  public VerificationCondition getPrecondition()
  {
    return precondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrecondition(VerificationCondition newPrecondition, NotificationChain msgs)
  {
    VerificationCondition oldPrecondition = precondition;
    precondition = newPrecondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__PRECONDITION, oldPrecondition, newPrecondition);
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
  public void setPrecondition(VerificationCondition newPrecondition)
  {
    if (newPrecondition != precondition)
    {
      NotificationChain msgs = null;
      if (precondition != null)
        msgs = ((InternalEObject)precondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__PRECONDITION, null, msgs);
      if (newPrecondition != null)
        msgs = ((InternalEObject)newPrecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__PRECONDITION, null, msgs);
      msgs = basicSetPrecondition(newPrecondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__PRECONDITION, newPrecondition, newPrecondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VerificationCondition getValidation()
  {
    return validation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValidation(VerificationCondition newValidation, NotificationChain msgs)
  {
    VerificationCondition oldValidation = validation;
    validation = newValidation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__VALIDATION, oldValidation, newValidation);
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
  public void setValidation(VerificationCondition newValidation)
  {
    if (newValidation != validation)
    {
      NotificationChain msgs = null;
      if (validation != null)
        msgs = ((InternalEObject)validation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__VALIDATION, null, msgs);
      if (newValidation != null)
        msgs = ((InternalEObject)newValidation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__VALIDATION, null, msgs);
      msgs = basicSetValidation(newValidation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__VALIDATION, newValidation, newValidation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Category> getCategory()
  {
    if (category == null)
    {
      category = new EObjectResolvingEList<Category>(Category.class, this, VerifyPackage.VERIFICATION_METHOD__CATEGORY);
    }
    return category;
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
      case VerifyPackage.VERIFICATION_METHOD__FORMALS:
        return ((InternalEList<?>)getFormals()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_METHOD__RESULTS:
        return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_METHOD__METHOD_KIND:
        return basicSetMethodKind(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__PRECONDITION:
        return basicSetPrecondition(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__VALIDATION:
        return basicSetValidation(null, msgs);
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
      case VerifyPackage.VERIFICATION_METHOD__TARGET_TYPE:
        return getTargetType();
      case VerifyPackage.VERIFICATION_METHOD__FORMALS:
        return getFormals();
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        return getProperties();
      case VerifyPackage.VERIFICATION_METHOD__RESULTS:
        return getResults();
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        return isIsPredicate();
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        return isIsResultReport();
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_METHOD__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case VerifyPackage.VERIFICATION_METHOD__COMPONENT_CATEGORY:
        return getComponentCategory();
      case VerifyPackage.VERIFICATION_METHOD__METHOD_KIND:
        return getMethodKind();
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return getDescription();
      case VerifyPackage.VERIFICATION_METHOD__PRECONDITION:
        return getPrecondition();
      case VerifyPackage.VERIFICATION_METHOD__VALIDATION:
        return getValidation();
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        return getCategory();
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
      case VerifyPackage.VERIFICATION_METHOD__TARGET_TYPE:
        setTargetType((TargetType)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__FORMALS:
        getFormals().clear();
        getFormals().addAll((Collection<? extends FormalParameter>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Property>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__RESULTS:
        getResults().clear();
        getResults().addAll((Collection<? extends FormalParameter>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        setIsPredicate((Boolean)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        setIsResultReport((Boolean)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TARGET:
        setTarget((ComponentClassifier)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        getComponentCategory().addAll((Collection<? extends ComponentCategory>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_KIND:
        setMethodKind((MethodKind)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PRECONDITION:
        setPrecondition((VerificationCondition)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__VALIDATION:
        setValidation((VerificationCondition)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        getCategory().clear();
        getCategory().addAll((Collection<? extends Category>)newValue);
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
      case VerifyPackage.VERIFICATION_METHOD__TARGET_TYPE:
        setTargetType(TARGET_TYPE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__FORMALS:
        getFormals().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        getProperties().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__RESULTS:
        getResults().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        setIsPredicate(IS_PREDICATE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        setIsResultReport(IS_RESULT_REPORT_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TARGET:
        setTarget((ComponentClassifier)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_KIND:
        setMethodKind((MethodKind)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PRECONDITION:
        setPrecondition((VerificationCondition)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__VALIDATION:
        setValidation((VerificationCondition)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        getCategory().clear();
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
      case VerifyPackage.VERIFICATION_METHOD__TARGET_TYPE:
        return targetType != TARGET_TYPE_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__FORMALS:
        return formals != null && !formals.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__RESULTS:
        return results != null && !results.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        return isPredicate != IS_PREDICATE_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        return isResultReport != IS_RESULT_REPORT_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_METHOD__TARGET:
        return target != null;
      case VerifyPackage.VERIFICATION_METHOD__COMPONENT_CATEGORY:
        return componentCategory != null && !componentCategory.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__METHOD_KIND:
        return methodKind != null;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return description != null;
      case VerifyPackage.VERIFICATION_METHOD__PRECONDITION:
        return precondition != null;
      case VerifyPackage.VERIFICATION_METHOD__VALIDATION:
        return validation != null;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        return category != null && !category.isEmpty();
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
    result.append(", targetType: ");
    result.append(targetType);
    result.append(", isPredicate: ");
    result.append(isPredicate);
    result.append(", isResultReport: ");
    result.append(isResultReport);
    result.append(", title: ");
    result.append(title);
    result.append(", componentCategory: ");
    result.append(componentCategory);
    result.append(')');
    return result.toString();
  }

} //VerificationMethodImpl
