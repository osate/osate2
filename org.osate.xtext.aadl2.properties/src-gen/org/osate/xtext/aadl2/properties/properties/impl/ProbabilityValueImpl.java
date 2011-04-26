/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.properties.properties.ProbabilityValue;
import org.osate.xtext.aadl2.properties.properties.PropertiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probability Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl#getDistribution <em>Distribution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbabilityValueImpl extends PropertyExpressionImpl implements ProbabilityValue
{
  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final String NUMBER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected String number = NUMBER_EDEFAULT;

  /**
   * The default value of the '{@link #getDistribution() <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDistribution()
   * @generated
   * @ordered
   */
  protected static final String DISTRIBUTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDistribution() <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDistribution()
   * @generated
   * @ordered
   */
  protected String distribution = DISTRIBUTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProbabilityValueImpl()
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
    return PropertiesPackage.Literals.PROBABILITY_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(String newNumber)
  {
    String oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.PROBABILITY_VALUE__NUMBER, oldNumber, number));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDistribution()
  {
    return distribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDistribution(String newDistribution)
  {
    String oldDistribution = distribution;
    distribution = newDistribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PropertiesPackage.PROBABILITY_VALUE__DISTRIBUTION, oldDistribution, distribution));
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
      case PropertiesPackage.PROBABILITY_VALUE__NUMBER:
        return getNumber();
      case PropertiesPackage.PROBABILITY_VALUE__DISTRIBUTION:
        return getDistribution();
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
      case PropertiesPackage.PROBABILITY_VALUE__NUMBER:
        setNumber((String)newValue);
        return;
      case PropertiesPackage.PROBABILITY_VALUE__DISTRIBUTION:
        setDistribution((String)newValue);
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
      case PropertiesPackage.PROBABILITY_VALUE__NUMBER:
        setNumber(NUMBER_EDEFAULT);
        return;
      case PropertiesPackage.PROBABILITY_VALUE__DISTRIBUTION:
        setDistribution(DISTRIBUTION_EDEFAULT);
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
      case PropertiesPackage.PROBABILITY_VALUE__NUMBER:
        return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
      case PropertiesPackage.PROBABILITY_VALUE__DISTRIBUTION:
        return DISTRIBUTION_EDEFAULT == null ? distribution != null : !DISTRIBUTION_EDEFAULT.equals(distribution);
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
    result.append(" (number: ");
    result.append(number);
    result.append(", distribution: ");
    result.append(distribution);
    result.append(')');
    return result.toString();
  }

} //ProbabilityValueImpl
