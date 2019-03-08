/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.ClaimArg;
import com.rockwellcollins.atc.resolute.resolute.ClaimTextVar;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim Arg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClaimArgImpl extends ClaimTextImpl implements ClaimArg
{
  /**
   * The cached value of the '{@link #getArg() <em>Arg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg()
   * @generated
   * @ordered
   */
  protected ClaimTextVar arg;

  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected UnitLiteral unit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClaimArgImpl()
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
    return ResolutePackage.Literals.CLAIM_ARG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClaimTextVar getArg()
  {
    if (arg != null && arg.eIsProxy())
    {
      InternalEObject oldArg = (InternalEObject)arg;
      arg = (ClaimTextVar)eResolveProxy(oldArg);
      if (arg != oldArg)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResolutePackage.CLAIM_ARG__ARG, oldArg, arg));
      }
    }
    return arg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClaimTextVar basicGetArg()
  {
    return arg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg(ClaimTextVar newArg)
  {
    ClaimTextVar oldArg = arg;
    arg = newArg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.CLAIM_ARG__ARG, oldArg, arg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitLiteral getUnit()
  {
    if (unit != null && ((EObject)unit).eIsProxy())
    {
      InternalEObject oldUnit = (InternalEObject)unit;
      unit = (UnitLiteral)eResolveProxy(oldUnit);
      if (unit != oldUnit)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResolutePackage.CLAIM_ARG__UNIT, oldUnit, unit));
      }
    }
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitLiteral basicGetUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(UnitLiteral newUnit)
  {
    UnitLiteral oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.CLAIM_ARG__UNIT, oldUnit, unit));
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
      case ResolutePackage.CLAIM_ARG__ARG:
        if (resolve) return getArg();
        return basicGetArg();
      case ResolutePackage.CLAIM_ARG__UNIT:
        if (resolve) return getUnit();
        return basicGetUnit();
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
      case ResolutePackage.CLAIM_ARG__ARG:
        setArg((ClaimTextVar)newValue);
        return;
      case ResolutePackage.CLAIM_ARG__UNIT:
        setUnit((UnitLiteral)newValue);
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
      case ResolutePackage.CLAIM_ARG__ARG:
        setArg((ClaimTextVar)null);
        return;
      case ResolutePackage.CLAIM_ARG__UNIT:
        setUnit((UnitLiteral)null);
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
      case ResolutePackage.CLAIM_ARG__ARG:
        return arg != null;
      case ResolutePackage.CLAIM_ARG__UNIT:
        return unit != null;
    }
    return super.eIsSet(featureID);
  }

} //ClaimArgImpl
