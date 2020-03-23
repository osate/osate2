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
package org.osate.xtext.aadl2.errormodel.EMV2Instance.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage
 * @generated
 */
public class EMV2InstanceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EMV2InstancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMV2InstanceSwitch() {
		if (modelPackage == null) {
			modelPackage = EMV2InstancePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EMV2InstancePackage.EMV2_INSTANCE_OBJECT: {
				EMV2InstanceObject emv2InstanceObject = (EMV2InstanceObject)theEObject;
				T result = caseEMV2InstanceObject(emv2InstanceObject);
				if (result == null) result = caseInstanceObject(emv2InstanceObject);
				if (result == null) result = caseNamedElement(emv2InstanceObject);
				if (result == null) result = caseElement(emv2InstanceObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE: {
				EMV2AnnexInstance emv2AnnexInstance = (EMV2AnnexInstance)theEObject;
				T result = caseEMV2AnnexInstance(emv2AnnexInstance);
				if (result == null) result = caseAnnexInstance(emv2AnnexInstance);
				if (result == null) result = caseNamedElement(emv2AnnexInstance);
				if (result == null) result = caseElement(emv2AnnexInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.STATE_MACHINE_INSTANCE: {
				StateMachineInstance stateMachineInstance = (StateMachineInstance)theEObject;
				T result = caseStateMachineInstance(stateMachineInstance);
				if (result == null) result = caseEMV2InstanceObject(stateMachineInstance);
				if (result == null) result = caseInstanceObject(stateMachineInstance);
				if (result == null) result = caseNamedElement(stateMachineInstance);
				if (result == null) result = caseElement(stateMachineInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.STATE_INSTANCE: {
				StateInstance stateInstance = (StateInstance)theEObject;
				T result = caseStateInstance(stateInstance);
				if (result == null) result = caseEMV2InstanceObject(stateInstance);
				if (result == null) result = caseInstanceObject(stateInstance);
				if (result == null) result = caseNamedElement(stateInstance);
				if (result == null) result = caseElement(stateInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT: {
				ConstrainedInstanceObject constrainedInstanceObject = (ConstrainedInstanceObject)theEObject;
				T result = caseConstrainedInstanceObject(constrainedInstanceObject);
				if (result == null) result = caseConstraintElement(constrainedInstanceObject);
				if (result == null) result = caseEMV2InstanceObject(constrainedInstanceObject);
				if (result == null) result = caseInstanceObject(constrainedInstanceObject);
				if (result == null) result = caseNamedElement(constrainedInstanceObject);
				if (result == null) result = caseElement(constrainedInstanceObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE: {
				StateTransitionInstance stateTransitionInstance = (StateTransitionInstance)theEObject;
				T result = caseStateTransitionInstance(stateTransitionInstance);
				if (result == null) result = caseEMV2InstanceObject(stateTransitionInstance);
				if (result == null) result = caseInstanceObject(stateTransitionInstance);
				if (result == null) result = caseNamedElement(stateTransitionInstance);
				if (result == null) result = caseElement(stateTransitionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE: {
				CompositeStateInstance compositeStateInstance = (CompositeStateInstance)theEObject;
				T result = caseCompositeStateInstance(compositeStateInstance);
				if (result == null) result = caseEMV2InstanceObject(compositeStateInstance);
				if (result == null) result = caseInstanceObject(compositeStateInstance);
				if (result == null) result = caseNamedElement(compositeStateInstance);
				if (result == null) result = caseElement(compositeStateInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.ERROR_FLOW_INSTANCE: {
				ErrorFlowInstance errorFlowInstance = (ErrorFlowInstance)theEObject;
				T result = caseErrorFlowInstance(errorFlowInstance);
				if (result == null) result = caseEMV2InstanceObject(errorFlowInstance);
				if (result == null) result = caseInstanceObject(errorFlowInstance);
				if (result == null) result = caseNamedElement(errorFlowInstance);
				if (result == null) result = caseElement(errorFlowInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.ERROR_BEHAVIOR_INSTANCE: {
				ErrorBehaviorInstance errorBehaviorInstance = (ErrorBehaviorInstance)theEObject;
				T result = caseErrorBehaviorInstance(errorBehaviorInstance);
				if (result == null) result = caseEMV2InstanceObject(errorBehaviorInstance);
				if (result == null) result = caseInstanceObject(errorBehaviorInstance);
				if (result == null) result = caseNamedElement(errorBehaviorInstance);
				if (result == null) result = caseElement(errorBehaviorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.PROPAGATION_PATH_INSTANCE: {
				PropagationPathInstance propagationPathInstance = (PropagationPathInstance)theEObject;
				T result = casePropagationPathInstance(propagationPathInstance);
				if (result == null) result = caseEMV2InstanceObject(propagationPathInstance);
				if (result == null) result = caseInstanceObject(propagationPathInstance);
				if (result == null) result = caseNamedElement(propagationPathInstance);
				if (result == null) result = caseElement(propagationPathInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.PROPAGATION_POINT_INSTANCE: {
				PropagationPointInstance propagationPointInstance = (PropagationPointInstance)theEObject;
				T result = casePropagationPointInstance(propagationPointInstance);
				if (result == null) result = caseEMV2InstanceObject(propagationPointInstance);
				if (result == null) result = caseInstanceObject(propagationPointInstance);
				if (result == null) result = caseNamedElement(propagationPointInstance);
				if (result == null) result = caseElement(propagationPointInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.EVENT_INSTANCE: {
				EventInstance eventInstance = (EventInstance)theEObject;
				T result = caseEventInstance(eventInstance);
				if (result == null) result = caseEMV2InstanceObject(eventInstance);
				if (result == null) result = caseInstanceObject(eventInstance);
				if (result == null) result = caseNamedElement(eventInstance);
				if (result == null) result = caseElement(eventInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseConstraintElement(constraint);
				if (result == null) result = caseEMV2InstanceObject(constraint);
				if (result == null) result = caseInstanceObject(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseElement(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.CONSTRAINT_ELEMENT: {
				ConstraintElement constraintElement = (ConstraintElement)theEObject;
				T result = caseConstraintElement(constraintElement);
				if (result == null) result = caseEMV2InstanceObject(constraintElement);
				if (result == null) result = caseInstanceObject(constraintElement);
				if (result == null) result = caseNamedElement(constraintElement);
				if (result == null) result = caseElement(constraintElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMV2InstanceObject(EMV2InstanceObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMV2 Annex Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMV2 Annex Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMV2AnnexInstance(EMV2AnnexInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMachineInstance(StateMachineInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateInstance(StateInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constrained Instance Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constrained Instance Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrainedInstanceObject(ConstrainedInstanceObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateTransitionInstance(StateTransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite State Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeStateInstance(CompositeStateInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Flow Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Flow Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorFlowInstance(ErrorFlowInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Behavior Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Behavior Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorBehaviorInstance(ErrorBehaviorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Propagation Path Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Propagation Path Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropagationPathInstance(PropagationPathInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Propagation Point Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Propagation Point Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropagationPointInstance(PropagationPointInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventInstance(EventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintElement(ConstraintElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceObject(InstanceObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annex Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annex Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnexInstance(AnnexInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EMV2InstanceSwitch
