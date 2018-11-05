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
 * $Id: ModeTransitionInstance.java,v 1.6 2010-05-12 20:09:22 lwrage Exp $
 */
package org.osate.aadl2.instance;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ModeTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition <em>Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getTriggers <em>Trigger</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance()
 * @model
 * @generated
 */
public interface ModeTransitionInstance extends ConnectionInstanceEnd, InstanceObject {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeInstance#getDstModeTransitions <em>Dst Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(ModeInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Destination()
	 * @see org.osate.aadl2.instance.ModeInstance#getDstModeTransitions
	 * @model opposite="dstModeTransition" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ModeInstance getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ModeInstance value);

	/**
	 * Returns the value of the '<em><b>Mode Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Transition</em>' reference.
	 * @see #setModeTransition(ModeTransition)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_ModeTransition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ModeTransition getModeTransition();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition <em>Mode Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Transition</em>' reference.
	 * @see #getModeTransition()
	 * @generated
	 */
	void setModeTransition(ModeTransition value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FeatureInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Trigger()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureInstance> getTriggers();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions <em>Src Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ModeInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Source()
	 * @see org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions
	 * @model opposite="srcModeTransition" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ModeInstance getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ModeInstance value);

} // ModeTransitionInstance
