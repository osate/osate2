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
 * A representation of the model object '<em><b>Subprogram Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramNames <em>Subprogram Names</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramReference <em>Subprogram Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramCallAction()
 * @model
 * @generated
 */
public interface SubprogramCallAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Subprogram Names</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Name}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subprogram Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subprogram Names</em>' containment reference list.
	 * @see #isSetSubprogramNames()
	 * @see #unsetSubprogramNames()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramCallAction_SubprogramNames()
	 * @model containment="true" unsettable="true" upper="2"
	 * @generated
	 */
	EList<Name> getSubprogramNames();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramNames <em>Subprogram Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubprogramNames()
	 * @see #getSubprogramNames()
	 * @generated
	 */
	void unsetSubprogramNames();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramNames <em>Subprogram Names</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subprogram Names</em>' containment reference list is set.
	 * @see #unsetSubprogramNames()
	 * @see #getSubprogramNames()
	 * @generated
	 */
	boolean isSetSubprogramNames();

	/**
	 * Returns the value of the '<em><b>Subprogram Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subprogram Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subprogram Reference</em>' containment reference.
	 * @see #setSubprogramReference(UniqueComponentClassifierReference)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramCallAction_SubprogramReference()
	 * @model containment="true"
	 * @generated
	 */
	UniqueComponentClassifierReference getSubprogramReference();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramReference <em>Subprogram Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subprogram Reference</em>' containment reference.
	 * @see #getSubprogramReference()
	 * @generated
	 */
	void setSubprogramReference(UniqueComponentClassifierReference value);

	/**
	 * Returns the value of the '<em><b>Parameter Labels</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Labels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Labels</em>' containment reference list.
	 * @see #isSetParameterLabels()
	 * @see #unsetParameterLabels()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramCallAction_ParameterLabels()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<ParameterLabel> getParameterLabels();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameterLabels()
	 * @see #getParameterLabels()
	 * @generated
	 */
	void unsetParameterLabels();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter Labels</em>' containment reference list is set.
	 * @see #unsetParameterLabels()
	 * @see #getParameterLabels()
	 * @generated
	 */
	boolean isSetParameterLabels();

} // SubprogramCallAction
