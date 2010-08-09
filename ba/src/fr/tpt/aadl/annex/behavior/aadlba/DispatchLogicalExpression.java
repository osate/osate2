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
 * A representation of the model object '<em><b>Dispatch Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isOrExpression <em>Or Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isAndExpression <em>And Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isXorExpression <em>Xor Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isStop <em>Stop</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression()
 * @model
 * @generated
 */
public interface DispatchLogicalExpression extends Element
{
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
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression_DispatchTriggers()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<DispatchTrigger> getDispatchTriggers();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
   void unsetDispatchTriggers();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispatch Triggers</em>' containment reference list is set.
	 * @see #unsetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
   boolean isSetDispatchTriggers();

   /**
	 * Returns the value of the '<em><b>Or Expression</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Or Expression</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Or Expression</em>' attribute.
	 * @see #setOrExpression(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression_OrExpression()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isOrExpression();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isOrExpression <em>Or Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Or Expression</em>' attribute.
	 * @see #isOrExpression()
	 * @generated
	 */
   void setOrExpression(boolean value);

   /**
	 * Returns the value of the '<em><b>And Expression</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>And Expression</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>And Expression</em>' attribute.
	 * @see #setAndExpression(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression_AndExpression()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isAndExpression();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isAndExpression <em>And Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>And Expression</em>' attribute.
	 * @see #isAndExpression()
	 * @generated
	 */
   void setAndExpression(boolean value);

   /**
	 * Returns the value of the '<em><b>Xor Expression</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Xor Expression</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Xor Expression</em>' attribute.
	 * @see #setXorExpression(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression_XorExpression()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isXorExpression();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isXorExpression <em>Xor Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xor Expression</em>' attribute.
	 * @see #isXorExpression()
	 * @generated
	 */
   void setXorExpression(boolean value);

   /**
	 * Returns the value of the '<em><b>Stop</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Stop</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop</em>' attribute.
	 * @see #setStop(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchLogicalExpression_Stop()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isStop();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isStop <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop</em>' attribute.
	 * @see #isStop()
	 * @generated
	 */
   void setStop(boolean value);

} // DispatchLogicalExpression
