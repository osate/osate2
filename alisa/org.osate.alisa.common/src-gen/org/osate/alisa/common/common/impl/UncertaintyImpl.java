/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Uncertainty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getCostimpact <em>Costimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getScheduleimpact <em>Scheduleimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getFamiliarity <em>Familiarity</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getTimecriticality <em>Timecriticality</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getRiskindex <em>Riskindex</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getMaturityindex <em>Maturityindex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UncertaintyImpl extends MinimalEObjectImpl.Container implements Uncertainty
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
   * The default value of the '{@link #getVolatility() <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatility()
   * @generated
   * @ordered
   */
  protected static final int VOLATILITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVolatility() <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatility()
   * @generated
   * @ordered
   */
  protected int volatility = VOLATILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getCostimpact() <em>Costimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostimpact()
   * @generated
   * @ordered
   */
  protected static final int COSTIMPACT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCostimpact() <em>Costimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostimpact()
   * @generated
   * @ordered
   */
  protected int costimpact = COSTIMPACT_EDEFAULT;

  /**
   * The default value of the '{@link #getScheduleimpact() <em>Scheduleimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheduleimpact()
   * @generated
   * @ordered
   */
  protected static final int SCHEDULEIMPACT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getScheduleimpact() <em>Scheduleimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheduleimpact()
   * @generated
   * @ordered
   */
  protected int scheduleimpact = SCHEDULEIMPACT_EDEFAULT;

  /**
   * The default value of the '{@link #getFamiliarity() <em>Familiarity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFamiliarity()
   * @generated
   * @ordered
   */
  protected static final int FAMILIARITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFamiliarity() <em>Familiarity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFamiliarity()
   * @generated
   * @ordered
   */
  protected int familiarity = FAMILIARITY_EDEFAULT;

  /**
   * The default value of the '{@link #getTimecriticality() <em>Timecriticality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimecriticality()
   * @generated
   * @ordered
   */
  protected static final int TIMECRITICALITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTimecriticality() <em>Timecriticality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimecriticality()
   * @generated
   * @ordered
   */
  protected int timecriticality = TIMECRITICALITY_EDEFAULT;

  /**
   * The default value of the '{@link #getRiskindex() <em>Riskindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRiskindex()
   * @generated
   * @ordered
   */
  protected static final int RISKINDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRiskindex() <em>Riskindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRiskindex()
   * @generated
   * @ordered
   */
  protected int riskindex = RISKINDEX_EDEFAULT;

  /**
   * The default value of the '{@link #getMaturityindex() <em>Maturityindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaturityindex()
   * @generated
   * @ordered
   */
  protected static final int MATURITYINDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaturityindex() <em>Maturityindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaturityindex()
   * @generated
   * @ordered
   */
  protected int maturityindex = MATURITYINDEX_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UncertaintyImpl()
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
    return CommonPackage.Literals.UNCERTAINTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVolatility()
  {
    return volatility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolatility(int newVolatility)
  {
    int oldVolatility = volatility;
    volatility = newVolatility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__VOLATILITY, oldVolatility, volatility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCostimpact()
  {
    return costimpact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCostimpact(int newCostimpact)
  {
    int oldCostimpact = costimpact;
    costimpact = newCostimpact;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__COSTIMPACT, oldCostimpact, costimpact));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getScheduleimpact()
  {
    return scheduleimpact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScheduleimpact(int newScheduleimpact)
  {
    int oldScheduleimpact = scheduleimpact;
    scheduleimpact = newScheduleimpact;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__SCHEDULEIMPACT, oldScheduleimpact, scheduleimpact));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFamiliarity()
  {
    return familiarity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFamiliarity(int newFamiliarity)
  {
    int oldFamiliarity = familiarity;
    familiarity = newFamiliarity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__FAMILIARITY, oldFamiliarity, familiarity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTimecriticality()
  {
    return timecriticality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimecriticality(int newTimecriticality)
  {
    int oldTimecriticality = timecriticality;
    timecriticality = newTimecriticality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__TIMECRITICALITY, oldTimecriticality, timecriticality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRiskindex()
  {
    return riskindex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRiskindex(int newRiskindex)
  {
    int oldRiskindex = riskindex;
    riskindex = newRiskindex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__RISKINDEX, oldRiskindex, riskindex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaturityindex()
  {
    return maturityindex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaturityindex(int newMaturityindex)
  {
    int oldMaturityindex = maturityindex;
    maturityindex = newMaturityindex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__MATURITYINDEX, oldMaturityindex, maturityindex));
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
      case CommonPackage.UNCERTAINTY__NAME:
        return getName();
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        return getVolatility();
      case CommonPackage.UNCERTAINTY__COSTIMPACT:
        return getCostimpact();
      case CommonPackage.UNCERTAINTY__SCHEDULEIMPACT:
        return getScheduleimpact();
      case CommonPackage.UNCERTAINTY__FAMILIARITY:
        return getFamiliarity();
      case CommonPackage.UNCERTAINTY__TIMECRITICALITY:
        return getTimecriticality();
      case CommonPackage.UNCERTAINTY__RISKINDEX:
        return getRiskindex();
      case CommonPackage.UNCERTAINTY__MATURITYINDEX:
        return getMaturityindex();
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
      case CommonPackage.UNCERTAINTY__NAME:
        setName((String)newValue);
        return;
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        setVolatility((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__COSTIMPACT:
        setCostimpact((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__SCHEDULEIMPACT:
        setScheduleimpact((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__FAMILIARITY:
        setFamiliarity((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__TIMECRITICALITY:
        setTimecriticality((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__RISKINDEX:
        setRiskindex((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__MATURITYINDEX:
        setMaturityindex((Integer)newValue);
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
      case CommonPackage.UNCERTAINTY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        setVolatility(VOLATILITY_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__COSTIMPACT:
        setCostimpact(COSTIMPACT_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__SCHEDULEIMPACT:
        setScheduleimpact(SCHEDULEIMPACT_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__FAMILIARITY:
        setFamiliarity(FAMILIARITY_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__TIMECRITICALITY:
        setTimecriticality(TIMECRITICALITY_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__RISKINDEX:
        setRiskindex(RISKINDEX_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__MATURITYINDEX:
        setMaturityindex(MATURITYINDEX_EDEFAULT);
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
      case CommonPackage.UNCERTAINTY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        return volatility != VOLATILITY_EDEFAULT;
      case CommonPackage.UNCERTAINTY__COSTIMPACT:
        return costimpact != COSTIMPACT_EDEFAULT;
      case CommonPackage.UNCERTAINTY__SCHEDULEIMPACT:
        return scheduleimpact != SCHEDULEIMPACT_EDEFAULT;
      case CommonPackage.UNCERTAINTY__FAMILIARITY:
        return familiarity != FAMILIARITY_EDEFAULT;
      case CommonPackage.UNCERTAINTY__TIMECRITICALITY:
        return timecriticality != TIMECRITICALITY_EDEFAULT;
      case CommonPackage.UNCERTAINTY__RISKINDEX:
        return riskindex != RISKINDEX_EDEFAULT;
      case CommonPackage.UNCERTAINTY__MATURITYINDEX:
        return maturityindex != MATURITYINDEX_EDEFAULT;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", volatility: ");
    result.append(volatility);
    result.append(", costimpact: ");
    result.append(costimpact);
    result.append(", scheduleimpact: ");
    result.append(scheduleimpact);
    result.append(", familiarity: ");
    result.append(familiarity);
    result.append(", timecriticality: ");
    result.append(timecriticality);
    result.append(", riskindex: ");
    result.append(riskindex);
    result.append(", maturityindex: ");
    result.append(maturityindex);
    result.append(')');
    return result.toString();
  }

} //UncertaintyImpl
