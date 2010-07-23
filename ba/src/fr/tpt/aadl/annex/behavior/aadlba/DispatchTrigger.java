/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime <em>The Behavior Time</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned <em>Identifier Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned <em>Numeral Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned <em>Value Constant Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isNot <em>Not</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isTimeout <em>Timeout</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOthers <em>Others</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrMore <em>Or More</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrLess <em>Or Less</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger()
 * @model
 * @generated
 */
public interface DispatchTrigger extends Element
{
   /**
    * Returns the value of the '<em><b>The Dispatch Logical Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>The Dispatch Logical Expression</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>The Dispatch Logical Expression</em>' containment reference.
    * @see #setTheDispatchLogicalExpression(DispatchLogicalExpression)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_TheDispatchLogicalExpression()
    * @model containment="true"
    * @generated
    */
   DispatchLogicalExpression getTheDispatchLogicalExpression();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>The Dispatch Logical Expression</em>' containment reference.
    * @see #getTheDispatchLogicalExpression()
    * @generated
    */
   void setTheDispatchLogicalExpression(DispatchLogicalExpression value);

   /**
    * Returns the value of the '<em><b>The Behavior Time</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>The Behavior Time</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>The Behavior Time</em>' containment reference.
    * @see #isSetTheBehaviorTime()
    * @see #unsetTheBehaviorTime()
    * @see #setTheBehaviorTime(BehaviorTime)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_TheBehaviorTime()
    * @model containment="true" unsettable="true"
    * @generated
    */
   BehaviorTime getTheBehaviorTime();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime <em>The Behavior Time</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>The Behavior Time</em>' containment reference.
    * @see #isSetTheBehaviorTime()
    * @see #unsetTheBehaviorTime()
    * @see #getTheBehaviorTime()
    * @generated
    */
   void setTheBehaviorTime(BehaviorTime value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime <em>The Behavior Time</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetTheBehaviorTime()
    * @see #getTheBehaviorTime()
    * @see #setTheBehaviorTime(BehaviorTime)
    * @generated
    */
   void unsetTheBehaviorTime();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime <em>The Behavior Time</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>The Behavior Time</em>' containment reference is set.
    * @see #unsetTheBehaviorTime()
    * @see #getTheBehaviorTime()
    * @see #setTheBehaviorTime(BehaviorTime)
    * @generated
    */
   boolean isSetTheBehaviorTime();

   /**
    * Returns the value of the '<em><b>Identifier Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Identifier Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Identifier Owned</em>' containment reference.
    * @see #isSetIdentifierOwned()
    * @see #unsetIdentifierOwned()
    * @see #setIdentifierOwned(Identifier)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_IdentifierOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   Identifier getIdentifierOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned <em>Identifier Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Identifier Owned</em>' containment reference.
    * @see #isSetIdentifierOwned()
    * @see #unsetIdentifierOwned()
    * @see #getIdentifierOwned()
    * @generated
    */
   void setIdentifierOwned(Identifier value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned <em>Identifier Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetIdentifierOwned()
    * @see #getIdentifierOwned()
    * @see #setIdentifierOwned(Identifier)
    * @generated
    */
   void unsetIdentifierOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned <em>Identifier Owned</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Identifier Owned</em>' containment reference is set.
    * @see #unsetIdentifierOwned()
    * @see #getIdentifierOwned()
    * @see #setIdentifierOwned(Identifier)
    * @generated
    */
   boolean isSetIdentifierOwned();

   /**
    * Returns the value of the '<em><b>Dispatch Triggers</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Dispatch Triggers</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Dispatch Triggers</em>' containment reference list.
    * @see #isSetDispatchTriggers()
    * @see #unsetDispatchTriggers()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_DispatchTriggers()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<DispatchTrigger> getDispatchTriggers();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetDispatchTriggers()
    * @see #getDispatchTriggers()
    * @generated
    */
   void unsetDispatchTriggers();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Dispatch Triggers</em>' containment reference list is set.
    * @see #unsetDispatchTriggers()
    * @see #getDispatchTriggers()
    * @generated
    */
   boolean isSetDispatchTriggers();

   /**
    * Returns the value of the '<em><b>Numeral Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Numeral Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Numeral Owned</em>' containment reference.
    * @see #isSetNumeralOwned()
    * @see #unsetNumeralOwned()
    * @see #setNumeralOwned(Numeral)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_NumeralOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   Numeral getNumeralOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned <em>Numeral Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Numeral Owned</em>' containment reference.
    * @see #isSetNumeralOwned()
    * @see #unsetNumeralOwned()
    * @see #getNumeralOwned()
    * @generated
    */
   void setNumeralOwned(Numeral value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned <em>Numeral Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetNumeralOwned()
    * @see #getNumeralOwned()
    * @see #setNumeralOwned(Numeral)
    * @generated
    */
   void unsetNumeralOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned <em>Numeral Owned</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Numeral Owned</em>' containment reference is set.
    * @see #unsetNumeralOwned()
    * @see #getNumeralOwned()
    * @see #setNumeralOwned(Numeral)
    * @generated
    */
   boolean isSetNumeralOwned();

   /**
    * Returns the value of the '<em><b>Value Constant Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Constant Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Value Constant Owned</em>' containment reference.
    * @see #isSetValueConstantOwned()
    * @see #unsetValueConstantOwned()
    * @see #setValueConstantOwned(ValueConstant)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_ValueConstantOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   ValueConstant getValueConstantOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned <em>Value Constant Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Value Constant Owned</em>' containment reference.
    * @see #isSetValueConstantOwned()
    * @see #unsetValueConstantOwned()
    * @see #getValueConstantOwned()
    * @generated
    */
   void setValueConstantOwned(ValueConstant value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned <em>Value Constant Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetValueConstantOwned()
    * @see #getValueConstantOwned()
    * @see #setValueConstantOwned(ValueConstant)
    * @generated
    */
   void unsetValueConstantOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned <em>Value Constant Owned</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Value Constant Owned</em>' containment reference is set.
    * @see #unsetValueConstantOwned()
    * @see #getValueConstantOwned()
    * @see #setValueConstantOwned(ValueConstant)
    * @generated
    */
   boolean isSetValueConstantOwned();

   /**
    * Returns the value of the '<em><b>Not</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Not</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Not</em>' attribute.
    * @see #setNot(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_Not()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isNot();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isNot <em>Not</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Not</em>' attribute.
    * @see #isNot()
    * @generated
    */
   void setNot(boolean value);

   /**
    * Returns the value of the '<em><b>Timeout</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Timeout</em>' attribute.
    * @see #setTimeout(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_Timeout()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isTimeout();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isTimeout <em>Timeout</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Timeout</em>' attribute.
    * @see #isTimeout()
    * @generated
    */
   void setTimeout(boolean value);

   /**
    * Returns the value of the '<em><b>Others</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Others</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Others</em>' attribute.
    * @see #setOthers(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_Others()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isOthers();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOthers <em>Others</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Others</em>' attribute.
    * @see #isOthers()
    * @generated
    */
   void setOthers(boolean value);

   /**
    * Returns the value of the '<em><b>Or More</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Or More</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Or More</em>' attribute.
    * @see #setOrMore(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_OrMore()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isOrMore();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrMore <em>Or More</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Or More</em>' attribute.
    * @see #isOrMore()
    * @generated
    */
   void setOrMore(boolean value);

   /**
    * Returns the value of the '<em><b>Or Less</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Or Less</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Or Less</em>' attribute.
    * @see #setOrLess(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTrigger_OrLess()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isOrLess();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrLess <em>Or Less</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Or Less</em>' attribute.
    * @see #isOrLess()
    * @generated
    */
   void setOrLess(boolean value);

} // DispatchTrigger
