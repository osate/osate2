/**
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
				if (result == null) result = caseEMV2InstanceObject(emv2AnnexInstance);
				if (result == null) result = caseInstanceObject(emv2AnnexInstance);
				if (result == null) result = caseNamedElement(emv2AnnexInstance);
				if (result == null) result = caseElement(emv2AnnexInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE: {
				StateVariableInstance stateVariableInstance = (StateVariableInstance)theEObject;
				T result = caseStateVariableInstance(stateVariableInstance);
				if (result == null) result = caseEMV2InstanceObject(stateVariableInstance);
				if (result == null) result = caseInstanceObject(stateVariableInstance);
				if (result == null) result = caseNamedElement(stateVariableInstance);
				if (result == null) result = caseElement(stateVariableInstance);
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
				if (result == null) result = caseEMV2InstanceObject(constrainedInstanceObject);
				if (result == null) result = caseLiteral(constrainedInstanceObject);
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
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE: {
				StateSynchronizationInstance stateSynchronizationInstance = (StateSynchronizationInstance)theEObject;
				T result = caseStateSynchronizationInstance(stateSynchronizationInstance);
				if (result == null) result = caseEMV2InstanceObject(stateSynchronizationInstance);
				if (result == null) result = caseInstanceObject(stateSynchronizationInstance);
				if (result == null) result = caseNamedElement(stateSynchronizationInstance);
				if (result == null) result = caseElement(stateSynchronizationInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.BEHAVIOR_INSTANCE: {
				BehaviorInstance behaviorInstance = (BehaviorInstance)theEObject;
				T result = caseBehaviorInstance(behaviorInstance);
				if (result == null) result = caseEMV2InstanceObject(behaviorInstance);
				if (result == null) result = caseInstanceObject(behaviorInstance);
				if (result == null) result = caseNamedElement(behaviorInstance);
				if (result == null) result = caseElement(behaviorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.TYPE_REFERENCE: {
				TypeReference typeReference = (TypeReference)theEObject;
				T result = caseTypeReference(typeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.ECOLLECTION: {
				ECollection eCollection = (ECollection)theEObject;
				T result = caseECollection(eCollection);
				if (result == null) result = caseLiteral(eCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EMV2InstancePackage.MULTI_LITERAL_CONSTRAINT: {
				MultiLiteralConstraint multiLiteralConstraint = (MultiLiteralConstraint)theEObject;
				T result = caseMultiLiteralConstraint(multiLiteralConstraint);
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
	 * Returns the result of interpreting the object as an instance of '<em>State Variable Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Variable Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVariableInstance(StateVariableInstance object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>State Synchronization Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Synchronization Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSynchronizationInstance(StateSynchronizationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorInstance(BehaviorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeReference(TypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECollection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECollection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECollection(ECollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Literal Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Literal Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiLiteralConstraint(MultiLiteralConstraint object) {
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
