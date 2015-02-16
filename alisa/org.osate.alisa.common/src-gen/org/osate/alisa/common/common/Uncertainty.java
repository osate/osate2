/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getCostimpact <em>Costimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getScheduleimpact <em>Scheduleimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getFamiliarity <em>Familiarity</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getTimecriticality <em>Timecriticality</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getRiskindex <em>Riskindex</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getMaturityindex <em>Maturityindex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getUncertainty()
 * @model
 * @generated
 */
public interface Uncertainty extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Volatility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Volatility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volatility</em>' attribute.
   * @see #setVolatility(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Volatility()
   * @model
   * @generated
   */
  int getVolatility();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volatility</em>' attribute.
   * @see #getVolatility()
   * @generated
   */
  void setVolatility(int value);

  /**
   * Returns the value of the '<em><b>Costimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Costimpact</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Costimpact</em>' attribute.
   * @see #setCostimpact(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Costimpact()
   * @model
   * @generated
   */
  int getCostimpact();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getCostimpact <em>Costimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Costimpact</em>' attribute.
   * @see #getCostimpact()
   * @generated
   */
  void setCostimpact(int value);

  /**
   * Returns the value of the '<em><b>Scheduleimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scheduleimpact</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scheduleimpact</em>' attribute.
   * @see #setScheduleimpact(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Scheduleimpact()
   * @model
   * @generated
   */
  int getScheduleimpact();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getScheduleimpact <em>Scheduleimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scheduleimpact</em>' attribute.
   * @see #getScheduleimpact()
   * @generated
   */
  void setScheduleimpact(int value);

  /**
   * Returns the value of the '<em><b>Familiarity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Familiarity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Familiarity</em>' attribute.
   * @see #setFamiliarity(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Familiarity()
   * @model
   * @generated
   */
  int getFamiliarity();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getFamiliarity <em>Familiarity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Familiarity</em>' attribute.
   * @see #getFamiliarity()
   * @generated
   */
  void setFamiliarity(int value);

  /**
   * Returns the value of the '<em><b>Timecriticality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timecriticality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timecriticality</em>' attribute.
   * @see #setTimecriticality(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Timecriticality()
   * @model
   * @generated
   */
  int getTimecriticality();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getTimecriticality <em>Timecriticality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timecriticality</em>' attribute.
   * @see #getTimecriticality()
   * @generated
   */
  void setTimecriticality(int value);

  /**
   * Returns the value of the '<em><b>Riskindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Riskindex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Riskindex</em>' attribute.
   * @see #setRiskindex(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Riskindex()
   * @model
   * @generated
   */
  int getRiskindex();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getRiskindex <em>Riskindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Riskindex</em>' attribute.
   * @see #getRiskindex()
   * @generated
   */
  void setRiskindex(int value);

  /**
   * Returns the value of the '<em><b>Maturityindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maturityindex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maturityindex</em>' attribute.
   * @see #setMaturityindex(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Maturityindex()
   * @model
   * @generated
   */
  int getMaturityindex();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getMaturityindex <em>Maturityindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maturityindex</em>' attribute.
   * @see #getMaturityindex()
   * @generated
   */
  void setMaturityindex(int value);

} // Uncertainty
