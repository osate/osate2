/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Modal Path</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.ModalPath#getInModes() <em>Get In Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.ModalPath#getInModeTransitions() <em>Get In Mode Transitions</em>}</li>
 *   <li>{@link org.osate.aadl2.ModalPath#getAllInModeTransitions() <em>Get All In Mode Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModalPathOperations extends ModalElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModalPathOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<Mode> getInModes(ModalPath modalPath) {
		// DONE: implement this method
		EList<Mode> inModes = new NonNotifyingEObjectEList<Mode>(Mode.class, (InternalEObject) modalPath,
				Aadl2Package.MODAL_PATH__IN_MODE);
		for (ModeFeature mf : modalPath.getInModeOrTransitions()) {
			if (mf instanceof Mode) {
				inModes.add((Mode) mf);
			}
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<ModeTransition> getInModeTransitions(ModalPath modalPath) {
		// DONE: implement this method
		EList<ModeTransition> inModeTransitions = new NonNotifyingEObjectEList<ModeTransition>(ModeTransition.class,
				(InternalEObject) modalPath, Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION);
		for (ModeFeature mf : modalPath.getInModeOrTransitions()) {
			if (mf instanceof ModeTransition) {
				inModeTransitions.add((ModeTransition) mf);
			}
		}
		return inModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<ModeTransition> getAllInModeTransitions(ModalPath modalPath) {
		// DONE: implement this method
		EList<ModeTransition> intransitions = null;
		// inmodes will be an empty list (all modes) if we do not find a non-empty list
		while (modalPath != null) {
			intransitions = modalPath.getInModeTransitions();
			// we stop when we find the first occurrence of a non-empty inmodes list
			if (intransitions != null && !intransitions.isEmpty()) {
				return intransitions;
			}
			if (modalPath instanceof RefinableElement) {
				modalPath = (ModalPath) ((RefinableElement) modalPath).getRefinedElement();
			} else {
				modalPath = null;
			}
		}
		return intransitions;
	}

} // ModalPathOperations