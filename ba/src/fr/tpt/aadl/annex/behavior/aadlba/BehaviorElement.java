/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import edu.cmu.sei.aadl.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * An element is a constituent of a model. As such, it has the capability of owning other elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement#getAadlRef <em>Aadl Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorElement()
 * @model abstract="true"
 * @generated
 */
public interface BehaviorElement extends Element {
	/**
	 * Returns the value of the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ba Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ba Ref</em>' reference.
	 * @see #setBaRef(BehaviorElement)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorElement_BaRef()
	 * @model
	 * @generated
	 */
	BehaviorElement getBaRef();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement#getBaRef <em>Ba Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ba Ref</em>' reference.
	 * @see #getBaRef()
	 * @generated
	 */
	void setBaRef(BehaviorElement value);

	/**
	 * Returns the value of the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aadl Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aadl Ref</em>' reference.
	 * @see #setAadlRef(Element)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorElement_AadlRef()
	 * @model
	 * @generated
	 */
	Element getAadlRef();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement#getAadlRef <em>Aadl Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aadl Ref</em>' reference.
	 * @see #getAadlRef()
	 * @generated
	 */
	void setAadlRef(Element value);

} // BehaviorElement
