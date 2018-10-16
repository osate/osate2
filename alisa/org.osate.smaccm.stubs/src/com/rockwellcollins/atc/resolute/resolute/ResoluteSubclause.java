/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause#getProves <em>Proves</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getResoluteSubclause()
 * @model
 * @generated
 */
public interface ResoluteSubclause extends EObject, AnnexSubclause
{
  /**
   * Returns the value of the '<em><b>Proves</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.ProveStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Proves</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proves</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getResoluteSubclause_Proves()
   * @model containment="true"
   * @generated
   */
  EList<ProveStatement> getProves();

} // ResoluteSubclause
