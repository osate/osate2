/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.organization.organization.Stakeholder;

import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getConflictsReference <em>Conflicts Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getStakeholderReference <em>Stakeholder Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends ContractualElementImpl implements Goal
{
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
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return getRefinesReference();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return getConflictsReference();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return getStakeholderReference();
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        getRefinesReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        getConflictsReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
        getStakeholderReference().addAll((Collection<? extends Stakeholder>)newValue);
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return refinesReference != null && !refinesReference.isEmpty();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return conflictsReference != null && !conflictsReference.isEmpty();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return stakeholderReference != null && !stakeholderReference.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GoalImpl
