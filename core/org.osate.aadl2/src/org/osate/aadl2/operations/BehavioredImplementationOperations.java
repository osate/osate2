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
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Behaviored Implementation</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.BehavioredImplementation#subprogramCalls() <em>Subprogram Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehavioredImplementationOperations extends ComponentImplementationOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioredImplementationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get all calls owned by owned call sequences.
	 * @param behavioredImplementation The receiving '<em><b>Behaviored Implementation</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static EList<SubprogramCall> subprogramCalls(BehavioredImplementation behavioredImplementation) {
		EList<SubprogramCall> allCalls = new NonNotifyingEObjectEList<SubprogramCall>(SubprogramCall.class,
				(InternalEObject) behavioredImplementation, Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL) {
			private static final long serialVersionUID = 1L;
		};

		for (SubprogramCallSequence callSequence : behavioredImplementation.getOwnedSubprogramCallSequences()) {
			allCalls.addAll(callSequence.getOwnedSubprogramCalls());
		}
		return allCalls;
	}

} // BehavioredImplementationOperations