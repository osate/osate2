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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaReferencedEntity <em>Ba Referenced Entity</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlReferencedEntity <em>Aadl Referenced Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends edu.cmu.sei.aadl.aadl2.Element
{
   /**
	 * Returns the value of the '<em><b>Ba Referenced Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Ba Referenced Entity</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Ba Referenced Entity</em>' reference.
	 * @see #setBaReferencedEntity(Element)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement_BaReferencedEntity()
	 * @model
	 * @generated
	 */
   Element getBaReferencedEntity();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaReferencedEntity <em>Ba Referenced Entity</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ba Referenced Entity</em>' reference.
	 * @see #getBaReferencedEntity()
	 * @generated
	 */
   void setBaReferencedEntity(Element value);

   /**
	 * Returns the value of the '<em><b>Aadl Referenced Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Aadl Referenced Entity</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Aadl Referenced Entity</em>' reference.
	 * @see #setAadlReferencedEntity(edu.cmu.sei.aadl.aadl2.Element)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getElement_AadlReferencedEntity()
	 * @model
	 * @generated
	 */
   edu.cmu.sei.aadl.aadl2.Element getAadlReferencedEntity();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlReferencedEntity <em>Aadl Referenced Entity</em>}' reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aadl Referenced Entity</em>' reference.
	 * @see #getAadlReferencedEntity()
	 * @generated
	 */
   void setAadlReferencedEntity(edu.cmu.sei.aadl.aadl2.Element value);

} // Element
