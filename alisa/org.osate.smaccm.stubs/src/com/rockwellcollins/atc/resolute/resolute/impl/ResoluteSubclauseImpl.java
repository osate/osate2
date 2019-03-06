/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl#getProves <em>Proves</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResoluteSubclauseImpl extends AnnexSubclauseImpl implements ResoluteSubclause
{
  /**
   * The cached value of the '{@link #getProves() <em>Proves</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProves()
   * @generated
   * @ordered
   */
  protected EList<ProveStatement> proves;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResoluteSubclauseImpl()
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
    return ResolutePackage.Literals.RESOLUTE_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProveStatement> getProves()
  {
    if (proves == null)
    {
      proves = new EObjectContainmentEList<ProveStatement>(ProveStatement.class, this, ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES);
    }
    return proves;
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES:
        return ((InternalEList<?>)getProves()).basicRemove(otherEnd, msgs);
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES:
        return getProves();
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES:
        getProves().clear();
        getProves().addAll((Collection<? extends ProveStatement>)newValue);
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES:
        getProves().clear();
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__PROVES:
        return proves != null && !proves.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ResoluteSubclauseImpl
