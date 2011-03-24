/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlRef <em>Aadl Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends edu.cmu.sei.aadl.aadl2.Element {
	/**
	 * Returns the value of the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ba Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ba Ref</em>' reference.
	 * @see #setBaRef(Element)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement_BaRef()
	 * @model
	 * @generated
	 */
	Element getBaRef();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaRef <em>Ba Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ba Ref</em>' reference.
	 * @see #getBaRef()
	 * @generated
	 */
	void setBaRef(Element value);

	/**
	 * Returns the value of the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aadl Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aadl Ref</em>' reference.
	 * @see #setAadlRef(edu.cmu.sei.aadl.aadl2.Element)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement_AadlRef()
	 * @model
	 * @generated
	 */
	edu.cmu.sei.aadl.aadl2.Element getAadlRef();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlRef <em>Aadl Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aadl Ref</em>' reference.
	 * @see #getAadlRef()
	 * @generated
	 */
	void setAadlRef(edu.cmu.sei.aadl.aadl2.Element value);

} // Element
