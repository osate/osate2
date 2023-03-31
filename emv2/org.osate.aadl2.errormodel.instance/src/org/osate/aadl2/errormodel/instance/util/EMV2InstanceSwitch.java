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
package org.osate.aadl2.errormodel.instance.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.instance.AbstractTypeSet;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.Branch;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.CompositeConditionExpression;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceObject;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorCodeInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.ModeMappingInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OthersExpression;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineProperties;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.StateSource;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.instance.TransitionDestination;
import org.osate.aadl2.errormodel.instance.TransitionInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.InstanceObject;

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
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE: {
			EMV2AnnexInstance emv2AnnexInstance = (EMV2AnnexInstance) theEObject;
			T result = caseEMV2AnnexInstance(emv2AnnexInstance);
			if (result == null) {
				result = caseAnnexInstance(emv2AnnexInstance);
			}
			if (result == null) {
				result = caseNamedElement(emv2AnnexInstance);
			}
			if (result == null) {
				result = caseElement(emv2AnnexInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.EMV2_INSTANCE_OBJECT: {
			EMV2InstanceObject emv2InstanceObject = (EMV2InstanceObject) theEObject;
			T result = caseEMV2InstanceObject(emv2InstanceObject);
			if (result == null) {
				result = caseInstanceObject(emv2InstanceObject);
			}
			if (result == null) {
				result = caseNamedElement(emv2InstanceObject);
			}
			if (result == null) {
				result = caseElement(emv2InstanceObject);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.STATE_MACHINE_PROPERTIES: {
			StateMachineProperties stateMachineProperties = (StateMachineProperties) theEObject;
			T result = caseStateMachineProperties(stateMachineProperties);
			if (result == null) {
				result = caseEMV2InstanceObject(stateMachineProperties);
			}
			if (result == null) {
				result = caseInstanceObject(stateMachineProperties);
			}
			if (result == null) {
				result = caseNamedElement(stateMachineProperties);
			}
			if (result == null) {
				result = caseElement(stateMachineProperties);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_PROPAGATION_INSTANCE: {
			ErrorPropagationInstance errorPropagationInstance = (ErrorPropagationInstance) theEObject;
			T result = caseErrorPropagationInstance(errorPropagationInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(errorPropagationInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorPropagationInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorPropagationInstance);
			}
			if (result == null) {
				result = caseElement(errorPropagationInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.CONNECTION_END_PROPAGATION: {
			ConnectionEndPropagation connectionEndPropagation = (ConnectionEndPropagation) theEObject;
			T result = caseConnectionEndPropagation(connectionEndPropagation);
			if (result == null) {
				result = caseErrorPropagationInstance(connectionEndPropagation);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(connectionEndPropagation);
			}
			if (result == null) {
				result = caseInstanceObject(connectionEndPropagation);
			}
			if (result == null) {
				result = caseNamedElement(connectionEndPropagation);
			}
			if (result == null) {
				result = caseElement(connectionEndPropagation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.FEATURE_PROPAGATION: {
			FeaturePropagation featurePropagation = (FeaturePropagation) theEObject;
			T result = caseFeaturePropagation(featurePropagation);
			if (result == null) {
				result = caseConnectionEndPropagation(featurePropagation);
			}
			if (result == null) {
				result = caseErrorPropagationInstance(featurePropagation);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(featurePropagation);
			}
			if (result == null) {
				result = caseInstanceObject(featurePropagation);
			}
			if (result == null) {
				result = caseNamedElement(featurePropagation);
			}
			if (result == null) {
				result = caseElement(featurePropagation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ACCESS_PROPAGATION: {
			AccessPropagation accessPropagation = (AccessPropagation) theEObject;
			T result = caseAccessPropagation(accessPropagation);
			if (result == null) {
				result = caseConnectionEndPropagation(accessPropagation);
			}
			if (result == null) {
				result = caseErrorPropagationInstance(accessPropagation);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(accessPropagation);
			}
			if (result == null) {
				result = caseInstanceObject(accessPropagation);
			}
			if (result == null) {
				result = caseNamedElement(accessPropagation);
			}
			if (result == null) {
				result = caseElement(accessPropagation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.POINT_PROPAGATION: {
			PointPropagation pointPropagation = (PointPropagation) theEObject;
			T result = casePointPropagation(pointPropagation);
			if (result == null) {
				result = caseErrorPropagationInstance(pointPropagation);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(pointPropagation);
			}
			if (result == null) {
				result = caseInstanceObject(pointPropagation);
			}
			if (result == null) {
				result = caseNamedElement(pointPropagation);
			}
			if (result == null) {
				result = caseElement(pointPropagation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BINDING_PROPAGATION: {
			BindingPropagation bindingPropagation = (BindingPropagation) theEObject;
			T result = caseBindingPropagation(bindingPropagation);
			if (result == null) {
				result = caseErrorPropagationInstance(bindingPropagation);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(bindingPropagation);
			}
			if (result == null) {
				result = caseInstanceObject(bindingPropagation);
			}
			if (result == null) {
				result = caseNamedElement(bindingPropagation);
			}
			if (result == null) {
				result = caseElement(bindingPropagation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TYPE_SET_ELEMENT: {
			TypeSetElement typeSetElement = (TypeSetElement) theEObject;
			T result = caseTypeSetElement(typeSetElement);
			if (result == null) {
				result = caseEMV2InstanceObject(typeSetElement);
			}
			if (result == null) {
				result = caseInstanceObject(typeSetElement);
			}
			if (result == null) {
				result = caseNamedElement(typeSetElement);
			}
			if (result == null) {
				result = caseElement(typeSetElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TYPE_TOKEN_INSTANCE: {
			TypeTokenInstance typeTokenInstance = (TypeTokenInstance) theEObject;
			T result = caseTypeTokenInstance(typeTokenInstance);
			if (result == null) {
				result = caseTypeSetElement(typeTokenInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(typeTokenInstance);
			}
			if (result == null) {
				result = caseInstanceObject(typeTokenInstance);
			}
			if (result == null) {
				result = caseNamedElement(typeTokenInstance);
			}
			if (result == null) {
				result = caseElement(typeTokenInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TYPE_INSTANCE: {
			TypeInstance typeInstance = (TypeInstance) theEObject;
			T result = caseTypeInstance(typeInstance);
			if (result == null) {
				result = caseTypeTokenInstance(typeInstance);
			}
			if (result == null) {
				result = caseTypeSetElement(typeInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(typeInstance);
			}
			if (result == null) {
				result = caseInstanceObject(typeInstance);
			}
			if (result == null) {
				result = caseNamedElement(typeInstance);
			}
			if (result == null) {
				result = caseElement(typeInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TYPE_PRODUCT_INSTANCE: {
			TypeProductInstance typeProductInstance = (TypeProductInstance) theEObject;
			T result = caseTypeProductInstance(typeProductInstance);
			if (result == null) {
				result = caseTypeTokenInstance(typeProductInstance);
			}
			if (result == null) {
				result = caseTypeSetElement(typeProductInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(typeProductInstance);
			}
			if (result == null) {
				result = caseInstanceObject(typeProductInstance);
			}
			if (result == null) {
				result = caseNamedElement(typeProductInstance);
			}
			if (result == null) {
				result = caseElement(typeProductInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ABSTRACT_TYPE_SET: {
			AbstractTypeSet abstractTypeSet = (AbstractTypeSet) theEObject;
			T result = caseAbstractTypeSet(abstractTypeSet);
			if (result == null) {
				result = caseEMV2InstanceObject(abstractTypeSet);
			}
			if (result == null) {
				result = caseInstanceObject(abstractTypeSet);
			}
			if (result == null) {
				result = caseNamedElement(abstractTypeSet);
			}
			if (result == null) {
				result = caseElement(abstractTypeSet);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TYPE_SET_INSTANCE: {
			TypeSetInstance typeSetInstance = (TypeSetInstance) theEObject;
			T result = caseTypeSetInstance(typeSetInstance);
			if (result == null) {
				result = caseAbstractTypeSet(typeSetInstance);
			}
			if (result == null) {
				result = caseTypeSetElement(typeSetInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(typeSetInstance);
			}
			if (result == null) {
				result = caseInstanceObject(typeSetInstance);
			}
			if (result == null) {
				result = caseNamedElement(typeSetInstance);
			}
			if (result == null) {
				result = caseElement(typeSetInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ANONYMOUS_TYPE_SET: {
			AnonymousTypeSet anonymousTypeSet = (AnonymousTypeSet) theEObject;
			T result = caseAnonymousTypeSet(anonymousTypeSet);
			if (result == null) {
				result = caseAbstractTypeSet(anonymousTypeSet);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(anonymousTypeSet);
			}
			if (result == null) {
				result = caseInstanceObject(anonymousTypeSet);
			}
			if (result == null) {
				result = caseNamedElement(anonymousTypeSet);
			}
			if (result == null) {
				result = caseElement(anonymousTypeSet);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_FLOW_INSTANCE: {
			ErrorFlowInstance errorFlowInstance = (ErrorFlowInstance) theEObject;
			T result = caseErrorFlowInstance(errorFlowInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(errorFlowInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorFlowInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorFlowInstance);
			}
			if (result == null) {
				result = caseElement(errorFlowInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_SOURCE_INSTANCE: {
			ErrorSourceInstance errorSourceInstance = (ErrorSourceInstance) theEObject;
			T result = caseErrorSourceInstance(errorSourceInstance);
			if (result == null) {
				result = caseErrorFlowInstance(errorSourceInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(errorSourceInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorSourceInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorSourceInstance);
			}
			if (result == null) {
				result = caseElement(errorSourceInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_SINK_INSTANCE: {
			ErrorSinkInstance errorSinkInstance = (ErrorSinkInstance) theEObject;
			T result = caseErrorSinkInstance(errorSinkInstance);
			if (result == null) {
				result = caseErrorFlowInstance(errorSinkInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(errorSinkInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorSinkInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorSinkInstance);
			}
			if (result == null) {
				result = caseElement(errorSinkInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_PATH_INSTANCE: {
			ErrorPathInstance errorPathInstance = (ErrorPathInstance) theEObject;
			T result = caseErrorPathInstance(errorPathInstance);
			if (result == null) {
				result = caseErrorFlowInstance(errorPathInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(errorPathInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorPathInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorPathInstance);
			}
			if (result == null) {
				result = caseElement(errorPathInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.PROPAGATION_POINT_INSTANCE: {
			PropagationPointInstance propagationPointInstance = (PropagationPointInstance) theEObject;
			T result = casePropagationPointInstance(propagationPointInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(propagationPointInstance);
			}
			if (result == null) {
				result = caseInstanceObject(propagationPointInstance);
			}
			if (result == null) {
				result = caseNamedElement(propagationPointInstance);
			}
			if (result == null) {
				result = caseElement(propagationPointInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.PROPAGATION_PATH_INSTANCE: {
			PropagationPathInstance propagationPathInstance = (PropagationPathInstance) theEObject;
			T result = casePropagationPathInstance(propagationPathInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(propagationPathInstance);
			}
			if (result == null) {
				result = caseInstanceObject(propagationPathInstance);
			}
			if (result == null) {
				result = caseNamedElement(propagationPathInstance);
			}
			if (result == null) {
				result = caseElement(propagationPathInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.CONNECTION_PATH: {
			ConnectionPath connectionPath = (ConnectionPath) theEObject;
			T result = caseConnectionPath(connectionPath);
			if (result == null) {
				result = casePropagationPathInstance(connectionPath);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(connectionPath);
			}
			if (result == null) {
				result = caseInstanceObject(connectionPath);
			}
			if (result == null) {
				result = caseNamedElement(connectionPath);
			}
			if (result == null) {
				result = caseElement(connectionPath);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BINDING_PATH: {
			BindingPath bindingPath = (BindingPath) theEObject;
			T result = caseBindingPath(bindingPath);
			if (result == null) {
				result = casePropagationPathInstance(bindingPath);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(bindingPath);
			}
			if (result == null) {
				result = caseInstanceObject(bindingPath);
			}
			if (result == null) {
				result = caseNamedElement(bindingPath);
			}
			if (result == null) {
				result = caseElement(bindingPath);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.USER_DEFINED_PATH: {
			UserDefinedPath userDefinedPath = (UserDefinedPath) theEObject;
			T result = caseUserDefinedPath(userDefinedPath);
			if (result == null) {
				result = casePropagationPathInstance(userDefinedPath);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(userDefinedPath);
			}
			if (result == null) {
				result = caseInstanceObject(userDefinedPath);
			}
			if (result == null) {
				result = caseNamedElement(userDefinedPath);
			}
			if (result == null) {
				result = caseElement(userDefinedPath);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.STATE_INSTANCE: {
			StateInstance stateInstance = (StateInstance) theEObject;
			T result = caseStateInstance(stateInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(stateInstance);
			}
			if (result == null) {
				result = caseInstanceObject(stateInstance);
			}
			if (result == null) {
				result = caseNamedElement(stateInstance);
			}
			if (result == null) {
				result = caseElement(stateInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.EVENT_INSTANCE: {
			EventInstance eventInstance = (EventInstance) theEObject;
			T result = caseEventInstance(eventInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(eventInstance);
			}
			if (result == null) {
				result = caseInstanceObject(eventInstance);
			}
			if (result == null) {
				result = caseNamedElement(eventInstance);
			}
			if (result == null) {
				result = caseElement(eventInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_EVENT_INSTANCE: {
			ErrorEventInstance errorEventInstance = (ErrorEventInstance) theEObject;
			T result = caseErrorEventInstance(errorEventInstance);
			if (result == null) {
				result = caseEventInstance(errorEventInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(errorEventInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorEventInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorEventInstance);
			}
			if (result == null) {
				result = caseElement(errorEventInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE: {
			RecoverEventInstance recoverEventInstance = (RecoverEventInstance) theEObject;
			T result = caseRecoverEventInstance(recoverEventInstance);
			if (result == null) {
				result = caseEventInstance(recoverEventInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(recoverEventInstance);
			}
			if (result == null) {
				result = caseInstanceObject(recoverEventInstance);
			}
			if (result == null) {
				result = caseNamedElement(recoverEventInstance);
			}
			if (result == null) {
				result = caseElement(recoverEventInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE: {
			RepairEventInstance repairEventInstance = (RepairEventInstance) theEObject;
			T result = caseRepairEventInstance(repairEventInstance);
			if (result == null) {
				result = caseEventInstance(repairEventInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(repairEventInstance);
			}
			if (result == null) {
				result = caseInstanceObject(repairEventInstance);
			}
			if (result == null) {
				result = caseNamedElement(repairEventInstance);
			}
			if (result == null) {
				result = caseElement(repairEventInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TRANSITION_INSTANCE: {
			TransitionInstance transitionInstance = (TransitionInstance) theEObject;
			T result = caseTransitionInstance(transitionInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(transitionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(transitionInstance);
			}
			if (result == null) {
				result = caseNamedElement(transitionInstance);
			}
			if (result == null) {
				result = caseElement(transitionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.STATE_SOURCE: {
			StateSource stateSource = (StateSource) theEObject;
			T result = caseStateSource(stateSource);
			if (result == null) {
				result = caseEMV2InstanceObject(stateSource);
			}
			if (result == null) {
				result = caseInstanceObject(stateSource);
			}
			if (result == null) {
				result = caseNamedElement(stateSource);
			}
			if (result == null) {
				result = caseElement(stateSource);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.SOURCE_STATE_REFERENCE: {
			SourceStateReference sourceStateReference = (SourceStateReference) theEObject;
			T result = caseSourceStateReference(sourceStateReference);
			if (result == null) {
				result = caseStateSource(sourceStateReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(sourceStateReference);
			}
			if (result == null) {
				result = caseInstanceObject(sourceStateReference);
			}
			if (result == null) {
				result = caseNamedElement(sourceStateReference);
			}
			if (result == null) {
				result = caseElement(sourceStateReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ALL_SOURCES: {
			AllSources allSources = (AllSources) theEObject;
			T result = caseAllSources(allSources);
			if (result == null) {
				result = caseStateSource(allSources);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(allSources);
			}
			if (result == null) {
				result = caseInstanceObject(allSources);
			}
			if (result == null) {
				result = caseNamedElement(allSources);
			}
			if (result == null) {
				result = caseElement(allSources);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.CONDITION_EXPRESSION_INSTANCE: {
			ConditionExpressionInstance conditionExpressionInstance = (ConditionExpressionInstance) theEObject;
			T result = caseConditionExpressionInstance(conditionExpressionInstance);
			if (result == null) {
				result = caseCompositeConditionExpression(conditionExpressionInstance);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(conditionExpressionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(conditionExpressionInstance);
			}
			if (result == null) {
				result = caseNamedElement(conditionExpressionInstance);
			}
			if (result == null) {
				result = caseElement(conditionExpressionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.EVENT_REFERENCE: {
			EventReference eventReference = (EventReference) theEObject;
			T result = caseEventReference(eventReference);
			if (result == null) {
				result = caseConditionExpressionInstance(eventReference);
			}
			if (result == null) {
				result = caseCompositeConditionExpression(eventReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(eventReference);
			}
			if (result == null) {
				result = caseInstanceObject(eventReference);
			}
			if (result == null) {
				result = caseNamedElement(eventReference);
			}
			if (result == null) {
				result = caseElement(eventReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.CONDITION_PROPAGATION_REFERENCE: {
			ConditionPropagationReference conditionPropagationReference = (ConditionPropagationReference) theEObject;
			T result = caseConditionPropagationReference(conditionPropagationReference);
			if (result == null) {
				result = caseConditionExpressionInstance(conditionPropagationReference);
			}
			if (result == null) {
				result = caseCompositeConditionExpression(conditionPropagationReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(conditionPropagationReference);
			}
			if (result == null) {
				result = caseInstanceObject(conditionPropagationReference);
			}
			if (result == null) {
				result = caseNamedElement(conditionPropagationReference);
			}
			if (result == null) {
				result = caseElement(conditionPropagationReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.NO_ERROR_PROPAGATION_REFERENCE: {
			NoErrorPropagationReference noErrorPropagationReference = (NoErrorPropagationReference) theEObject;
			T result = caseNoErrorPropagationReference(noErrorPropagationReference);
			if (result == null) {
				result = caseConditionExpressionInstance(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseOutgoingPropagationConditionDestination(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseCompositeConditionExpression(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseInstanceObject(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseNamedElement(noErrorPropagationReference);
			}
			if (result == null) {
				result = caseElement(noErrorPropagationReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.COUNT_EXPRESSION: {
			CountExpression countExpression = (CountExpression) theEObject;
			T result = caseCountExpression(countExpression);
			if (result == null) {
				result = caseConditionExpressionInstance(countExpression);
			}
			if (result == null) {
				result = caseCompositeConditionExpression(countExpression);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(countExpression);
			}
			if (result == null) {
				result = caseInstanceObject(countExpression);
			}
			if (result == null) {
				result = caseNamedElement(countExpression);
			}
			if (result == null) {
				result = caseElement(countExpression);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.TRANSITION_DESTINATION: {
			TransitionDestination transitionDestination = (TransitionDestination) theEObject;
			T result = caseTransitionDestination(transitionDestination);
			if (result == null) {
				result = caseEMV2InstanceObject(transitionDestination);
			}
			if (result == null) {
				result = caseInstanceObject(transitionDestination);
			}
			if (result == null) {
				result = caseNamedElement(transitionDestination);
			}
			if (result == null) {
				result = caseElement(transitionDestination);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.DESTINATION_STATE_REFERENCE: {
			DestinationStateReference destinationStateReference = (DestinationStateReference) theEObject;
			T result = caseDestinationStateReference(destinationStateReference);
			if (result == null) {
				result = caseTransitionDestination(destinationStateReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(destinationStateReference);
			}
			if (result == null) {
				result = caseInstanceObject(destinationStateReference);
			}
			if (result == null) {
				result = caseNamedElement(destinationStateReference);
			}
			if (result == null) {
				result = caseElement(destinationStateReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.SAME_STATE: {
			SameState sameState = (SameState) theEObject;
			T result = caseSameState(sameState);
			if (result == null) {
				result = caseTransitionDestination(sameState);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(sameState);
			}
			if (result == null) {
				result = caseInstanceObject(sameState);
			}
			if (result == null) {
				result = caseNamedElement(sameState);
			}
			if (result == null) {
				result = caseElement(sameState);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BRANCHES: {
			Branches branches = (Branches) theEObject;
			T result = caseBranches(branches);
			if (result == null) {
				result = caseTransitionDestination(branches);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(branches);
			}
			if (result == null) {
				result = caseInstanceObject(branches);
			}
			if (result == null) {
				result = caseNamedElement(branches);
			}
			if (result == null) {
				result = caseElement(branches);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BRANCH: {
			Branch branch = (Branch) theEObject;
			T result = caseBranch(branch);
			if (result == null) {
				result = caseEMV2InstanceObject(branch);
			}
			if (result == null) {
				result = caseInstanceObject(branch);
			}
			if (result == null) {
				result = caseNamedElement(branch);
			}
			if (result == null) {
				result = caseElement(branch);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BRANCH_STATE_REFERENCE: {
			BranchStateReference branchStateReference = (BranchStateReference) theEObject;
			T result = caseBranchStateReference(branchStateReference);
			if (result == null) {
				result = caseBranch(branchStateReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(branchStateReference);
			}
			if (result == null) {
				result = caseInstanceObject(branchStateReference);
			}
			if (result == null) {
				result = caseNamedElement(branchStateReference);
			}
			if (result == null) {
				result = caseElement(branchStateReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.BRANCH_SAME_STATE: {
			BranchSameState branchSameState = (BranchSameState) theEObject;
			T result = caseBranchSameState(branchSameState);
			if (result == null) {
				result = caseBranch(branchSameState);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(branchSameState);
			}
			if (result == null) {
				result = caseInstanceObject(branchSameState);
			}
			if (result == null) {
				result = caseNamedElement(branchSameState);
			}
			if (result == null) {
				result = caseElement(branchSameState);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE: {
			OutgoingPropagationConditionInstance outgoingPropagationConditionInstance = (OutgoingPropagationConditionInstance) theEObject;
			T result = caseOutgoingPropagationConditionInstance(outgoingPropagationConditionInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(outgoingPropagationConditionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(outgoingPropagationConditionInstance);
			}
			if (result == null) {
				result = caseNamedElement(outgoingPropagationConditionInstance);
			}
			if (result == null) {
				result = caseElement(outgoingPropagationConditionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_DESTINATION: {
			OutgoingPropagationConditionDestination outgoingPropagationConditionDestination = (OutgoingPropagationConditionDestination) theEObject;
			T result = caseOutgoingPropagationConditionDestination(outgoingPropagationConditionDestination);
			if (result == null) {
				result = caseEMV2InstanceObject(outgoingPropagationConditionDestination);
			}
			if (result == null) {
				result = caseInstanceObject(outgoingPropagationConditionDestination);
			}
			if (result == null) {
				result = caseNamedElement(outgoingPropagationConditionDestination);
			}
			if (result == null) {
				result = caseElement(outgoingPropagationConditionDestination);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.DESTINATION_PROPAGATION_REFERENCE: {
			DestinationPropagationReference destinationPropagationReference = (DestinationPropagationReference) theEObject;
			T result = caseDestinationPropagationReference(destinationPropagationReference);
			if (result == null) {
				result = caseOutgoingPropagationConditionDestination(destinationPropagationReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(destinationPropagationReference);
			}
			if (result == null) {
				result = caseInstanceObject(destinationPropagationReference);
			}
			if (result == null) {
				result = caseNamedElement(destinationPropagationReference);
			}
			if (result == null) {
				result = caseElement(destinationPropagationReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ALL_PROPAGATIONS: {
			AllPropagations allPropagations = (AllPropagations) theEObject;
			T result = caseAllPropagations(allPropagations);
			if (result == null) {
				result = caseOutgoingPropagationConditionDestination(allPropagations);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(allPropagations);
			}
			if (result == null) {
				result = caseInstanceObject(allPropagations);
			}
			if (result == null) {
				result = caseNamedElement(allPropagations);
			}
			if (result == null) {
				result = caseElement(allPropagations);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ALL_PROPAGATIONS_NO_ERROR: {
			AllPropagationsNoError allPropagationsNoError = (AllPropagationsNoError) theEObject;
			T result = caseAllPropagationsNoError(allPropagationsNoError);
			if (result == null) {
				result = caseOutgoingPropagationConditionDestination(allPropagationsNoError);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(allPropagationsNoError);
			}
			if (result == null) {
				result = caseInstanceObject(allPropagationsNoError);
			}
			if (result == null) {
				result = caseNamedElement(allPropagationsNoError);
			}
			if (result == null) {
				result = caseElement(allPropagationsNoError);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.DETECTION_INSTANCE: {
			DetectionInstance detectionInstance = (DetectionInstance) theEObject;
			T result = caseDetectionInstance(detectionInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(detectionInstance);
			}
			if (result == null) {
				result = caseInstanceObject(detectionInstance);
			}
			if (result == null) {
				result = caseNamedElement(detectionInstance);
			}
			if (result == null) {
				result = caseElement(detectionInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.ERROR_CODE_INSTANCE: {
			ErrorCodeInstance errorCodeInstance = (ErrorCodeInstance) theEObject;
			T result = caseErrorCodeInstance(errorCodeInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(errorCodeInstance);
			}
			if (result == null) {
				result = caseInstanceObject(errorCodeInstance);
			}
			if (result == null) {
				result = caseNamedElement(errorCodeInstance);
			}
			if (result == null) {
				result = caseElement(errorCodeInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.INTEGER_CODE: {
			IntegerCode integerCode = (IntegerCode) theEObject;
			T result = caseIntegerCode(integerCode);
			if (result == null) {
				result = caseErrorCodeInstance(integerCode);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(integerCode);
			}
			if (result == null) {
				result = caseInstanceObject(integerCode);
			}
			if (result == null) {
				result = caseNamedElement(integerCode);
			}
			if (result == null) {
				result = caseElement(integerCode);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.STRING_CODE: {
			StringCode stringCode = (StringCode) theEObject;
			T result = caseStringCode(stringCode);
			if (result == null) {
				result = caseErrorCodeInstance(stringCode);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(stringCode);
			}
			if (result == null) {
				result = caseInstanceObject(stringCode);
			}
			if (result == null) {
				result = caseNamedElement(stringCode);
			}
			if (result == null) {
				result = caseElement(stringCode);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.CONSTANT_CODE: {
			ConstantCode constantCode = (ConstantCode) theEObject;
			T result = caseConstantCode(constantCode);
			if (result == null) {
				result = caseErrorCodeInstance(constantCode);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(constantCode);
			}
			if (result == null) {
				result = caseInstanceObject(constantCode);
			}
			if (result == null) {
				result = caseNamedElement(constantCode);
			}
			if (result == null) {
				result = caseElement(constantCode);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.MODE_MAPPING_INSTANCE: {
			ModeMappingInstance modeMappingInstance = (ModeMappingInstance) theEObject;
			T result = caseModeMappingInstance(modeMappingInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(modeMappingInstance);
			}
			if (result == null) {
				result = caseInstanceObject(modeMappingInstance);
			}
			if (result == null) {
				result = caseNamedElement(modeMappingInstance);
			}
			if (result == null) {
				result = caseElement(modeMappingInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE: {
			CompositeStateInstance compositeStateInstance = (CompositeStateInstance) theEObject;
			T result = caseCompositeStateInstance(compositeStateInstance);
			if (result == null) {
				result = caseEMV2InstanceObject(compositeStateInstance);
			}
			if (result == null) {
				result = caseInstanceObject(compositeStateInstance);
			}
			if (result == null) {
				result = caseNamedElement(compositeStateInstance);
			}
			if (result == null) {
				result = caseElement(compositeStateInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.COMPOSITE_CONDITION_EXPRESSION: {
			CompositeConditionExpression compositeConditionExpression = (CompositeConditionExpression) theEObject;
			T result = caseCompositeConditionExpression(compositeConditionExpression);
			if (result == null) {
				result = caseEMV2InstanceObject(compositeConditionExpression);
			}
			if (result == null) {
				result = caseInstanceObject(compositeConditionExpression);
			}
			if (result == null) {
				result = caseNamedElement(compositeConditionExpression);
			}
			if (result == null) {
				result = caseElement(compositeConditionExpression);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.OTHERS_EXPRESSION: {
			OthersExpression othersExpression = (OthersExpression) theEObject;
			T result = caseOthersExpression(othersExpression);
			if (result == null) {
				result = caseCompositeConditionExpression(othersExpression);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(othersExpression);
			}
			if (result == null) {
				result = caseInstanceObject(othersExpression);
			}
			if (result == null) {
				result = caseNamedElement(othersExpression);
			}
			if (result == null) {
				result = caseElement(othersExpression);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case EMV2InstancePackage.STATE_REFERENCE: {
			StateReference stateReference = (StateReference) theEObject;
			T result = caseStateReference(stateReference);
			if (result == null) {
				result = caseConditionExpressionInstance(stateReference);
			}
			if (result == null) {
				result = caseCompositeConditionExpression(stateReference);
			}
			if (result == null) {
				result = caseEMV2InstanceObject(stateReference);
			}
			if (result == null) {
				result = caseInstanceObject(stateReference);
			}
			if (result == null) {
				result = caseNamedElement(stateReference);
			}
			if (result == null) {
				result = caseElement(stateReference);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>State Machine Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMachineProperties(StateMachineProperties object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Composite Condition Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Condition Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeConditionExpression(CompositeConditionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Others Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Others Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOthersExpression(OthersExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateReference(StateReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Error Source Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Source Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorSourceInstance(ErrorSourceInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Sink Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Sink Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorSinkInstance(ErrorSinkInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Path Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Path Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorPathInstance(ErrorPathInstance object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Connection Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionPath(ConnectionPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingPath(BindingPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Defined Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Defined Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDefinedPath(UserDefinedPath object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Error Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorEventInstance(ErrorEventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recover Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recover Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecoverEventInstance(RecoverEventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairEventInstance(RepairEventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionInstance(TransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSource(StateSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source State Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceStateReference(SourceStateReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Sources</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Sources</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllSources(AllSources object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Expression Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Expression Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionExpressionInstance(ConditionExpressionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventReference(EventReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Propagation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionPropagationReference(ConditionPropagationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Error Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Error Propagation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoErrorPropagationReference(NoErrorPropagationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Count Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountExpression(CountExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionDestination(TransitionDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Destination State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Destination State Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDestinationStateReference(DestinationStateReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Same State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Same State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSameState(SameState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branches</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branches</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranches(Branches object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranch(Branch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch State Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranchStateReference(BranchStateReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch Same State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch Same State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranchSameState(BranchSameState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutgoingPropagationConditionInstance(OutgoingPropagationConditionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutgoingPropagationConditionDestination(OutgoingPropagationConditionDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Destination Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Destination Propagation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDestinationPropagationReference(DestinationPropagationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Propagations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Propagations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllPropagations(AllPropagations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Propagations No Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Propagations No Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllPropagationsNoError(AllPropagationsNoError object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Detection Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Detection Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDetectionInstance(DetectionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Code Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Code Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorCodeInstance(ErrorCodeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerCode(IntegerCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringCode(StringCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantCode(ConstantCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode Mapping Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode Mapping Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModeMappingInstance(ModeMappingInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Propagation Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Propagation Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorPropagationInstance(ErrorPropagationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection End Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection End Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionEndPropagation(ConnectionEndPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePropagation(FeaturePropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointPropagation(PointPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessPropagation(AccessPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingPropagation(BindingPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Set Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Set Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSetElement(TypeSetElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Token Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Token Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeTokenInstance(TypeTokenInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeInstance(TypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Set Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Set Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSetInstance(TypeSetInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Type Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Type Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousTypeSet(AnonymousTypeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Product Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Product Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeProductInstance(TypeProductInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Type Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Type Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTypeSet(AbstractTypeSet object) {
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

} // EMV2InstanceSwitch
