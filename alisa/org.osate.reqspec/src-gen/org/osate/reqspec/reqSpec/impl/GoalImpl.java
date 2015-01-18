/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.PredicateExpression;

import org.osate.categories.categories.RequirementCategory;

import org.osate.organization.organization.Stakeholder;

import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getAssert <em>Assert</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getSubgoal <em>Subgoal</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getDecomposesReference <em>Decomposes Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getEvolvesReference <em>Evolves Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getConflictsReference <em>Conflicts Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getStakeholderReference <em>Stakeholder Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getSystemRequirementReference <em>System Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getDocReference <em>Doc Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoalImpl extends ContractualElementImpl implements Goal
{
  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected RequirementCategory category;

  /**
   * The cached value of the '{@link #getAssert() <em>Assert</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssert()
   * @generated
   * @ordered
   */
  protected PredicateExpression assert_;

  /**
   * The cached value of the '{@link #getRefinesReference() <em>Refines Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinesReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> refinesReference;

  /**
   * The cached value of the '{@link #getSubgoal() <em>Subgoal</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubgoal()
   * @generated
   * @ordered
   */
  protected EList<Goal> subgoal;

  /**
   * The cached value of the '{@link #getDecomposesReference() <em>Decomposes Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecomposesReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> decomposesReference;

  /**
   * The cached value of the '{@link #getEvolvesReference() <em>Evolves Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvolvesReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> evolvesReference;

  /**
   * The cached value of the '{@link #getConflictsReference() <em>Conflicts Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConflictsReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> conflictsReference;

  /**
   * The cached value of the '{@link #getStakeholderReference() <em>Stakeholder Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStakeholderReference()
   * @generated
   * @ordered
   */
  protected EList<Stakeholder> stakeholderReference;

  /**
   * The cached value of the '{@link #getStakeholderRequirementReference() <em>Stakeholder Requirement Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStakeholderRequirementReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> stakeholderRequirementReference;

  /**
   * The cached value of the '{@link #getSystemRequirementReference() <em>System Requirement Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemRequirementReference()
   * @generated
   * @ordered
   */
  protected EList<ContractualElement> systemRequirementReference;

  /**
   * The cached value of the '{@link #getDocReference() <em>Doc Reference</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected EList<ExternalDocument> docReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GoalImpl()
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
    return ReqSpecPackage.Literals.GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementCategory getCategory()
  {
    if (category != null && category.eIsProxy())
    {
      InternalEObject oldCategory = (InternalEObject)category;
      category = (RequirementCategory)eResolveProxy(oldCategory);
      if (category != oldCategory)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.GOAL__CATEGORY, oldCategory, category));
      }
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementCategory basicGetCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(RequirementCategory newCategory)
  {
    RequirementCategory oldCategory = category;
    category = newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.GOAL__CATEGORY, oldCategory, category));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PredicateExpression getAssert()
  {
    return assert_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssert(PredicateExpression newAssert, NotificationChain msgs)
  {
    PredicateExpression oldAssert = assert_;
    assert_ = newAssert;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.GOAL__ASSERT, oldAssert, newAssert);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssert(PredicateExpression newAssert)
  {
    if (newAssert != assert_)
    {
      NotificationChain msgs = null;
      if (assert_ != null)
        msgs = ((InternalEObject)assert_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.GOAL__ASSERT, null, msgs);
      if (newAssert != null)
        msgs = ((InternalEObject)newAssert).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.GOAL__ASSERT, null, msgs);
      msgs = basicSetAssert(newAssert, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.GOAL__ASSERT, newAssert, newAssert));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getRefinesReference()
  {
    if (refinesReference == null)
    {
      refinesReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__REFINES_REFERENCE);
    }
    return refinesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getSubgoal()
  {
    if (subgoal == null)
    {
      subgoal = new EObjectContainmentEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__SUBGOAL);
    }
    return subgoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getDecomposesReference()
  {
    if (decomposesReference == null)
    {
      decomposesReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__DECOMPOSES_REFERENCE);
    }
    return decomposesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getEvolvesReference()
  {
    if (evolvesReference == null)
    {
      evolvesReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__EVOLVES_REFERENCE);
    }
    return evolvesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getConflictsReference()
  {
    if (conflictsReference == null)
    {
      conflictsReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__CONFLICTS_REFERENCE);
    }
    return conflictsReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Stakeholder> getStakeholderReference()
  {
    if (stakeholderReference == null)
    {
      stakeholderReference = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE);
    }
    return stakeholderReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getStakeholderRequirementReference()
  {
    if (stakeholderRequirementReference == null)
    {
      stakeholderRequirementReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE);
    }
    return stakeholderRequirementReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContractualElement> getSystemRequirementReference()
  {
    if (systemRequirementReference == null)
    {
      systemRequirementReference = new EObjectResolvingEList<ContractualElement>(ContractualElement.class, this, ReqSpecPackage.GOAL__SYSTEM_REQUIREMENT_REFERENCE);
    }
    return systemRequirementReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalDocument> getDocReference()
  {
    if (docReference == null)
    {
      docReference = new EObjectContainmentEList<ExternalDocument>(ExternalDocument.class, this, ReqSpecPackage.GOAL__DOC_REFERENCE);
    }
    return docReference;
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
      case ReqSpecPackage.GOAL__ASSERT:
        return basicSetAssert(null, msgs);
      case ReqSpecPackage.GOAL__SUBGOAL:
        return ((InternalEList<?>)getSubgoal()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.GOAL__DOC_REFERENCE:
        return ((InternalEList<?>)getDocReference()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.GOAL__CATEGORY:
        if (resolve) return getCategory();
        return basicGetCategory();
      case ReqSpecPackage.GOAL__ASSERT:
        return getAssert();
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return getRefinesReference();
      case ReqSpecPackage.GOAL__SUBGOAL:
        return getSubgoal();
      case ReqSpecPackage.GOAL__DECOMPOSES_REFERENCE:
        return getDecomposesReference();
      case ReqSpecPackage.GOAL__EVOLVES_REFERENCE:
        return getEvolvesReference();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return getConflictsReference();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return getStakeholderReference();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE:
        return getStakeholderRequirementReference();
      case ReqSpecPackage.GOAL__SYSTEM_REQUIREMENT_REFERENCE:
        return getSystemRequirementReference();
      case ReqSpecPackage.GOAL__DOC_REFERENCE:
        return getDocReference();
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
      case ReqSpecPackage.GOAL__CATEGORY:
        setCategory((RequirementCategory)newValue);
        return;
      case ReqSpecPackage.GOAL__ASSERT:
        setAssert((PredicateExpression)newValue);
        return;
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        getRefinesReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__SUBGOAL:
        getSubgoal().clear();
        getSubgoal().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        getDecomposesReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__EVOLVES_REFERENCE:
        getEvolvesReference().clear();
        getEvolvesReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        getConflictsReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
        getStakeholderReference().addAll((Collection<? extends Stakeholder>)newValue);
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE:
        getStakeholderRequirementReference().clear();
        getStakeholderRequirementReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__SYSTEM_REQUIREMENT_REFERENCE:
        getSystemRequirementReference().clear();
        getSystemRequirementReference().addAll((Collection<? extends ContractualElement>)newValue);
        return;
      case ReqSpecPackage.GOAL__DOC_REFERENCE:
        getDocReference().clear();
        getDocReference().addAll((Collection<? extends ExternalDocument>)newValue);
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
      case ReqSpecPackage.GOAL__CATEGORY:
        setCategory((RequirementCategory)null);
        return;
      case ReqSpecPackage.GOAL__ASSERT:
        setAssert((PredicateExpression)null);
        return;
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        return;
      case ReqSpecPackage.GOAL__SUBGOAL:
        getSubgoal().clear();
        return;
      case ReqSpecPackage.GOAL__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        return;
      case ReqSpecPackage.GOAL__EVOLVES_REFERENCE:
        getEvolvesReference().clear();
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE:
        getStakeholderRequirementReference().clear();
        return;
      case ReqSpecPackage.GOAL__SYSTEM_REQUIREMENT_REFERENCE:
        getSystemRequirementReference().clear();
        return;
      case ReqSpecPackage.GOAL__DOC_REFERENCE:
        getDocReference().clear();
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
      case ReqSpecPackage.GOAL__CATEGORY:
        return category != null;
      case ReqSpecPackage.GOAL__ASSERT:
        return assert_ != null;
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return refinesReference != null && !refinesReference.isEmpty();
      case ReqSpecPackage.GOAL__SUBGOAL:
        return subgoal != null && !subgoal.isEmpty();
      case ReqSpecPackage.GOAL__DECOMPOSES_REFERENCE:
        return decomposesReference != null && !decomposesReference.isEmpty();
      case ReqSpecPackage.GOAL__EVOLVES_REFERENCE:
        return evolvesReference != null && !evolvesReference.isEmpty();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return conflictsReference != null && !conflictsReference.isEmpty();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return stakeholderReference != null && !stakeholderReference.isEmpty();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE:
        return stakeholderRequirementReference != null && !stakeholderRequirementReference.isEmpty();
      case ReqSpecPackage.GOAL__SYSTEM_REQUIREMENT_REFERENCE:
        return systemRequirementReference != null && !systemRequirementReference.isEmpty();
      case ReqSpecPackage.GOAL__DOC_REFERENCE:
        return docReference != null && !docReference.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GoalImpl
