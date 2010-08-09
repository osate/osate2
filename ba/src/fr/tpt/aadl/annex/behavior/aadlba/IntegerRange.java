/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerRange()
 * @model
 * @generated
 */
public interface IntegerRange extends Element, ElementValues
{
   /**
	 * Returns the value of the '<em><b>Lower Integer Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Lower Integer Value</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Integer Value</em>' containment reference.
	 * @see #setLowerIntegerValue(IntegerValue)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerRange_LowerIntegerValue()
	 * @model containment="true"
	 * @generated
	 */
   IntegerValue getLowerIntegerValue();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Integer Value</em>' containment reference.
	 * @see #getLowerIntegerValue()
	 * @generated
	 */
   void setLowerIntegerValue(IntegerValue value);

   /**
	 * Returns the value of the '<em><b>Upper Integer Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Upper Integer Value</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Integer Value</em>' containment reference.
	 * @see #setUpperIntegerValue(IntegerValue)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerRange_UpperIntegerValue()
	 * @model containment="true"
	 * @generated
	 */
   IntegerValue getUpperIntegerValue();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Integer Value</em>' containment reference.
	 * @see #getUpperIntegerValue()
	 * @generated
	 */
   void setUpperIntegerValue(IntegerValue value);

} // IntegerRange
