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
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentCategory;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.TargetType;

import org.osate.organization.organization.Stakeholder;

import org.osate.reqspec.reqSpec.ReqPredicate;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getExceptionText <em>Exception Text</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getInheritsReference <em>Inherits Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getDecomposesReference <em>Decomposes Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getDevelopmentStakeholder <em>Development Stakeholder</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getRequirementReference <em>Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getTargetType <em>Target Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementImpl extends ContractualElementImpl implements Requirement
{
  /**
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected ReqPredicate predicate;

  /**
   * The cached value of the '{@link #getException() <em>Exception</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getException()
   * @generated
   * @ordered
   */
  protected EObject exception;

  /**
   * The default value of the '{@link #getExceptionText() <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionText()
   * @generated
   * @ordered
   */
  protected static final String EXCEPTION_TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExceptionText() <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionText()
   * @generated
   * @ordered
   */
  protected String exceptionText = EXCEPTION_TEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getInheritsReference() <em>Inherits Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritsReference()
   * @generated
   * @ordered
   */
  protected Requirement inheritsReference;

  /**
   * The cached value of the '{@link #getComputes() <em>Computes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComputes()
   * @generated
   * @ordered
   */
  protected EList<AVariableDeclaration> computes;

  /**
   * The cached value of the '{@link #getRefinesReference() <em>Refines Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinesReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> refinesReference;

  /**
   * The cached value of the '{@link #getDecomposesReference() <em>Decomposes Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecomposesReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> decomposesReference;

  /**
   * The cached value of the '{@link #getDevelopmentStakeholder() <em>Development Stakeholder</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevelopmentStakeholder()
   * @generated
   * @ordered
   */
  protected EList<Stakeholder> developmentStakeholder;

  /**
   * The cached value of the '{@link #getRequirementReference() <em>Requirement Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> requirementReference;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RequirementImpl()
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
    return ReqSpecPackage.Literals.REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReqPredicate getPredicate()
  {
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPredicate(ReqPredicate newPredicate, NotificationChain msgs)
  {
    ReqPredicate oldPredicate = predicate;
    predicate = newPredicate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__PREDICATE, oldPredicate, newPredicate);
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
  public void setPredicate(ReqPredicate newPredicate)
  {
    if (newPredicate != predicate)
    {
      NotificationChain msgs = null;
      if (predicate != null)
        msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__PREDICATE, null, msgs);
      if (newPredicate != null)
        msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__PREDICATE, null, msgs);
      msgs = basicSetPredicate(newPredicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__PREDICATE, newPredicate, newPredicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getException()
  {
    if (exception != null && exception.eIsProxy())
    {
      InternalEObject oldException = (InternalEObject)exception;
      exception = eResolveProxy(oldException);
      if (exception != oldException)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQUIREMENT__EXCEPTION, oldException, exception));
      }
    }
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetException()
  {
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setException(EObject newException)
  {
    EObject oldException = exception;
    exception = newException;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__EXCEPTION, oldException, exception));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getExceptionText()
  {
    return exceptionText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExceptionText(String newExceptionText)
  {
    String oldExceptionText = exceptionText;
    exceptionText = newExceptionText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT, oldExceptionText, exceptionText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Requirement getInheritsReference()
  {
    if (inheritsReference != null && inheritsReference.eIsProxy())
    {
      InternalEObject oldInheritsReference = (InternalEObject)inheritsReference;
      inheritsReference = (Requirement)eResolveProxy(oldInheritsReference);
      if (inheritsReference != oldInheritsReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE, oldInheritsReference, inheritsReference));
      }
    }
    return inheritsReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement basicGetInheritsReference()
  {
    return inheritsReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInheritsReference(Requirement newInheritsReference)
  {
    Requirement oldInheritsReference = inheritsReference;
    inheritsReference = newInheritsReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE, oldInheritsReference, inheritsReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AVariableDeclaration> getComputes()
  {
    if (computes == null)
    {
      computes = new EObjectContainmentEList<AVariableDeclaration>(AVariableDeclaration.class, this, ReqSpecPackage.REQUIREMENT__COMPUTES);
    }
    return computes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Requirement> getRefinesReference()
  {
    if (refinesReference == null)
    {
      refinesReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE);
    }
    return refinesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Requirement> getDecomposesReference()
  {
    if (decomposesReference == null)
    {
      decomposesReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE);
    }
    return decomposesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Stakeholder> getDevelopmentStakeholder()
  {
    if (developmentStakeholder == null)
    {
      developmentStakeholder = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER);
    }
    return developmentStakeholder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Requirement> getRequirementReference()
  {
    if (requirementReference == null)
    {
      requirementReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__REQUIREMENT_REFERENCE);
    }
    return requirementReference;
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
      componentCategory = new EDataTypeEList<ComponentCategory>(ComponentCategory.class, this, ReqSpecPackage.REQUIREMENT__COMPONENT_CATEGORY);
    }
    return componentCategory;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__TARGET_TYPE, oldTargetType, targetType));
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
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return basicSetPredicate(null, msgs);
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return ((InternalEList<?>)getComputes()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return getPredicate();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        if (resolve) return getException();
        return basicGetException();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return getExceptionText();
      case ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE:
        if (resolve) return getInheritsReference();
        return basicGetInheritsReference();
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return getComputes();
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        return getRefinesReference();
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        return getDecomposesReference();
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        return getDevelopmentStakeholder();
      case ReqSpecPackage.REQUIREMENT__REQUIREMENT_REFERENCE:
        return getRequirementReference();
      case ReqSpecPackage.REQUIREMENT__COMPONENT_CATEGORY:
        return getComponentCategory();
      case ReqSpecPackage.REQUIREMENT__TARGET_TYPE:
        return getTargetType();
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
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        setPredicate((ReqPredicate)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText((String)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE:
        setInheritsReference((Requirement)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        getComputes().clear();
        getComputes().addAll((Collection<? extends AVariableDeclaration>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        getRefinesReference().clear();
        getRefinesReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        getDecomposesReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        getDevelopmentStakeholder().clear();
        getDevelopmentStakeholder().addAll((Collection<? extends Stakeholder>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__REQUIREMENT_REFERENCE:
        getRequirementReference().clear();
        getRequirementReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        getComponentCategory().addAll((Collection<? extends ComponentCategory>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__TARGET_TYPE:
        setTargetType((TargetType)newValue);
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
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        setPredicate((ReqPredicate)null);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)null);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText(EXCEPTION_TEXT_EDEFAULT);
        return;
      case ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE:
        setInheritsReference((Requirement)null);
        return;
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        getComputes().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        getRefinesReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        getDevelopmentStakeholder().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__REQUIREMENT_REFERENCE:
        getRequirementReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__TARGET_TYPE:
        setTargetType(TARGET_TYPE_EDEFAULT);
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
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return predicate != null;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        return exception != null;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return EXCEPTION_TEXT_EDEFAULT == null ? exceptionText != null : !EXCEPTION_TEXT_EDEFAULT.equals(exceptionText);
      case ReqSpecPackage.REQUIREMENT__INHERITS_REFERENCE:
        return inheritsReference != null;
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return computes != null && !computes.isEmpty();
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        return refinesReference != null && !refinesReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        return decomposesReference != null && !decomposesReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        return developmentStakeholder != null && !developmentStakeholder.isEmpty();
      case ReqSpecPackage.REQUIREMENT__REQUIREMENT_REFERENCE:
        return requirementReference != null && !requirementReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__COMPONENT_CATEGORY:
        return componentCategory != null && !componentCategory.isEmpty();
      case ReqSpecPackage.REQUIREMENT__TARGET_TYPE:
        return targetType != TARGET_TYPE_EDEFAULT;
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
    result.append(" (exceptionText: ");
    result.append(exceptionText);
    result.append(", componentCategory: ");
    result.append(componentCategory);
    result.append(", targetType: ");
    result.append(targetType);
    result.append(')');
    return result.toString();
  }

} //RequirementImpl
