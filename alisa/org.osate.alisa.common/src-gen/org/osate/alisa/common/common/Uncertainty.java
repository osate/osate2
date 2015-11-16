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
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getCostimpact <em>Costimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getScheduleimpact <em>Scheduleimpact</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getFamiliarity <em>Familiarity</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getTimecriticality <em>Timecriticality</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getRiskindex <em>Riskindex</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getMaturityindex <em>Maturityindex</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getUncertainty()
 * @model
 * @generated
 */
public interface Uncertainty extends EObject
{
  /**
   * Returns the value of the '<em><b>Volatility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Volatility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volatility</em>' attribute.
   * @see #setVolatility(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Volatility()
   * @model
   * @generated
   */
  String getVolatility();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volatility</em>' attribute.
   * @see #getVolatility()
   * @generated
   */
  void setVolatility(String value);

  /**
   * Returns the value of the '<em><b>Costimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Costimpact</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Costimpact</em>' attribute.
   * @see #setCostimpact(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Costimpact()
   * @model
   * @generated
   */
  String getCostimpact();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getCostimpact <em>Costimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Costimpact</em>' attribute.
   * @see #getCostimpact()
   * @generated
   */
  void setCostimpact(String value);

  /**
   * Returns the value of the '<em><b>Scheduleimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scheduleimpact</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scheduleimpact</em>' attribute.
   * @see #setScheduleimpact(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Scheduleimpact()
   * @model
   * @generated
   */
  String getScheduleimpact();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getScheduleimpact <em>Scheduleimpact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scheduleimpact</em>' attribute.
   * @see #getScheduleimpact()
   * @generated
   */
  void setScheduleimpact(String value);

  /**
   * Returns the value of the '<em><b>Familiarity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Familiarity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Familiarity</em>' attribute.
   * @see #setFamiliarity(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Familiarity()
   * @model
   * @generated
   */
  String getFamiliarity();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getFamiliarity <em>Familiarity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Familiarity</em>' attribute.
   * @see #getFamiliarity()
   * @generated
   */
  void setFamiliarity(String value);

  /**
   * Returns the value of the '<em><b>Timecriticality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timecriticality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timecriticality</em>' attribute.
   * @see #setTimecriticality(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Timecriticality()
   * @model
   * @generated
   */
  String getTimecriticality();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getTimecriticality <em>Timecriticality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timecriticality</em>' attribute.
   * @see #getTimecriticality()
   * @generated
   */
  void setTimecriticality(String value);

  /**
   * Returns the value of the '<em><b>Riskindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Riskindex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Riskindex</em>' attribute.
   * @see #setRiskindex(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Riskindex()
   * @model
   * @generated
   */
  String getRiskindex();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getRiskindex <em>Riskindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Riskindex</em>' attribute.
   * @see #getRiskindex()
   * @generated
   */
  void setRiskindex(String value);

  /**
   * Returns the value of the '<em><b>Maturityindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maturityindex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maturityindex</em>' attribute.
   * @see #setMaturityindex(String)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Maturityindex()
   * @model
   * @generated
   */
  String getMaturityindex();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getMaturityindex <em>Maturityindex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maturityindex</em>' attribute.
   * @see #getMaturityindex()
   * @generated
   */
  void setMaturityindex(String value);

} // Uncertainty
