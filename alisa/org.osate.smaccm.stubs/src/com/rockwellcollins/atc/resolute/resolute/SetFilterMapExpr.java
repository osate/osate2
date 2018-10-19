/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Filter Map Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getMap <em>Map</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getArgs <em>Args</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getFilter <em>Filter</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetFilterMapExpr()
 * @model
 * @generated
 */
public interface SetFilterMapExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Map</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Map</em>' containment reference.
   * @see #setMap(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetFilterMapExpr_Map()
   * @model containment="true"
   * @generated
   */
  Expr getMap();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getMap <em>Map</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Map</em>' containment reference.
   * @see #getMap()
   * @generated
   */
  void setMap(Expr value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Arg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetFilterMapExpr_Args()
   * @model containment="true"
   * @generated
   */
  EList<Arg> getArgs();

  /**
   * Returns the value of the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' containment reference.
   * @see #setFilter(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetFilterMapExpr_Filter()
   * @model containment="true"
   * @generated
   */
  Expr getFilter();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getFilter <em>Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' containment reference.
   * @see #getFilter()
   * @generated
   */
  void setFilter(Expr value);

} // SetFilterMapExpr
