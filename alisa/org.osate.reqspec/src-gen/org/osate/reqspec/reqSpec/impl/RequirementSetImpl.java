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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.ReqRoot;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl#getImportConstants <em>Import Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl#getStakeholderGoals <em>Stakeholder Goals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementSetImpl extends ReqRootImpl implements RequirementSet
{
  /**
   * The cached value of the '{@link #getImportConstants() <em>Import Constants</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportConstants()
   * @generated
   * @ordered
   */
  protected EList<GlobalConstants> importConstants;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<ValDeclaration> constants;

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
   * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirements()
   * @generated
   * @ordered
   */
  protected EList<Requirement> requirements;

  /**
   * The cached value of the '{@link #getStakeholderGoals() <em>Stakeholder Goals</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStakeholderGoals()
   * @generated
   * @ordered
   */
  protected EList<ReqRoot> stakeholderGoals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RequirementSetImpl()
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
    return ReqSpecPackage.Literals.REQUIREMENT_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<GlobalConstants> getImportConstants()
  {
    if (importConstants == null)
    {
      importConstants = new EObjectResolvingEList<GlobalConstants>(GlobalConstants.class, this, ReqSpecPackage.REQUIREMENT_SET__IMPORT_CONSTANTS);
    }
    return importConstants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ValDeclaration> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ValDeclaration>(ValDeclaration.class, this, ReqSpecPackage.REQUIREMENT_SET__CONSTANTS);
    }
    return constants;
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
      computes = new EObjectContainmentEList<AVariableDeclaration>(AVariableDeclaration.class, this, ReqSpecPackage.REQUIREMENT_SET__COMPUTES);
    }
    return computes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Requirement> getRequirements()
  {
    if (requirements == null)
    {
      requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS);
    }
    return requirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ReqRoot> getStakeholderGoals()
  {
    if (stakeholderGoals == null)
    {
      stakeholderGoals = new EObjectResolvingEList<ReqRoot>(ReqRoot.class, this, ReqSpecPackage.REQUIREMENT_SET__STAKEHOLDER_GOALS);
    }
    return stakeholderGoals;
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
      case ReqSpecPackage.REQUIREMENT_SET__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQUIREMENT_SET__COMPUTES:
        return ((InternalEList<?>)getComputes()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS:
        return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.REQUIREMENT_SET__IMPORT_CONSTANTS:
        return getImportConstants();
      case ReqSpecPackage.REQUIREMENT_SET__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.REQUIREMENT_SET__COMPUTES:
        return getComputes();
      case ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS:
        return getRequirements();
      case ReqSpecPackage.REQUIREMENT_SET__STAKEHOLDER_GOALS:
        return getStakeholderGoals();
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
      case ReqSpecPackage.REQUIREMENT_SET__IMPORT_CONSTANTS:
        getImportConstants().clear();
        getImportConstants().addAll((Collection<? extends GlobalConstants>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT_SET__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ValDeclaration>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT_SET__COMPUTES:
        getComputes().clear();
        getComputes().addAll((Collection<? extends AVariableDeclaration>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS:
        getRequirements().clear();
        getRequirements().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT_SET__STAKEHOLDER_GOALS:
        getStakeholderGoals().clear();
        getStakeholderGoals().addAll((Collection<? extends ReqRoot>)newValue);
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
      case ReqSpecPackage.REQUIREMENT_SET__IMPORT_CONSTANTS:
        getImportConstants().clear();
        return;
      case ReqSpecPackage.REQUIREMENT_SET__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.REQUIREMENT_SET__COMPUTES:
        getComputes().clear();
        return;
      case ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS:
        getRequirements().clear();
        return;
      case ReqSpecPackage.REQUIREMENT_SET__STAKEHOLDER_GOALS:
        getStakeholderGoals().clear();
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
      case ReqSpecPackage.REQUIREMENT_SET__IMPORT_CONSTANTS:
        return importConstants != null && !importConstants.isEmpty();
      case ReqSpecPackage.REQUIREMENT_SET__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.REQUIREMENT_SET__COMPUTES:
        return computes != null && !computes.isEmpty();
      case ReqSpecPackage.REQUIREMENT_SET__REQUIREMENTS:
        return requirements != null && !requirements.isEmpty();
      case ReqSpecPackage.REQUIREMENT_SET__STAKEHOLDER_GOALS:
        return stakeholderGoals != null && !stakeholderGoals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RequirementSetImpl
