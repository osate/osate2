/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: ModeInstance.java,v 1.6 2010-05-12 20:09:22 lwrage Exp $
 */
package org.osate.aadl2.instance;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Mode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions <em>Src Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getDstModeTransitions <em>Dst Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getMode <em>Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getParents <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance()
 * @model
 * @generated
 */
public interface ModeInstance extends InstanceObject {
	/**
	 * Returns the value of the '<em><b>Src Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Mode Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_SrcModeTransition()
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getSource
	 * @model opposite="source" ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getSrcModeTransitions();

	/**
	 * Returns the value of the '<em><b>Dst Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Mode Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_DstModeTransition()
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getDestination
	 * @model opposite="destination" ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getDstModeTransitions();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' reference.
	 * @see #setMode(Mode)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Mode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#getMode <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' reference.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Derived()
	 * @model default="false" dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Parent()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeInstance> getParents();

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Initial()
	 * @model default="false" dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInitial();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#isInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #isInitial()
	 * @generated
	 */
	void setInitial(boolean value);

} // ModeInstance
