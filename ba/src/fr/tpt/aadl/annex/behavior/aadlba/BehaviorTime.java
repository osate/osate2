/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValueOwned <em>Integer Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier <em>Unit Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime()
 * @model
 * @generated
 */
public interface BehaviorTime extends Element
{
   /**
	 * Returns the value of the '<em><b>Integer Value Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Integer Value Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value Owned</em>' containment reference.
	 * @see #setIntegerValueOwned(IntegerValue)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime_IntegerValueOwned()
	 * @model containment="true"
	 * @generated
	 */
   IntegerValue getIntegerValueOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValueOwned <em>Integer Value Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value Owned</em>' containment reference.
	 * @see #getIntegerValueOwned()
	 * @generated
	 */
   void setIntegerValueOwned(IntegerValue value);

   /**
	 * Returns the value of the '<em><b>Unit Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Unit Identifier</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Identifier</em>' containment reference.
	 * @see #setUnitIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTime_UnitIdentifier()
	 * @model containment="true"
	 * @generated
	 */
   Identifier getUnitIdentifier();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier <em>Unit Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Identifier</em>' containment reference.
	 * @see #getUnitIdentifier()
	 * @generated
	 */
	void setUnitIdentifier(Identifier value);

} // BehaviorTime
