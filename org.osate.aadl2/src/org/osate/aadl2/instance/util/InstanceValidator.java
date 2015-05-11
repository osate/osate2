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
 */
package org.osate.aadl2.instance.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.InstancePackage
 * @generated
 */
public class InstanceValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final InstanceValidator INSTANCE = new InstanceValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.osate.aadl2.instance"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Aadl2Validator aadl2Validator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceValidator() {
		super();
		aadl2Validator = Aadl2Validator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return InstancePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case InstancePackage.FEATURE_INSTANCE:
			return validateFeatureInstance((FeatureInstance) value, diagnostics, context);
		case InstancePackage.INSTANCE_OBJECT:
			return validateInstanceObject((InstanceObject) value, diagnostics, context);
		case InstancePackage.ANNEX_INSTANCE:
			return validateAnnexInstance((AnnexInstance) value, diagnostics, context);
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE:
			return validatePropertyAssociationInstance((PropertyAssociationInstance) value, diagnostics, context);
		case InstancePackage.CONNECTION_INSTANCE_END:
			return validateConnectionInstanceEnd((ConnectionInstanceEnd) value, diagnostics, context);
		case InstancePackage.CONNECTION_INSTANCE:
			return validateConnectionInstance((ConnectionInstance) value, diagnostics, context);
		case InstancePackage.FLOW_ELEMENT_INSTANCE:
			return validateFlowElementInstance((FlowElementInstance) value, diagnostics, context);
		case InstancePackage.SYSTEM_OPERATION_MODE:
			return validateSystemOperationMode((SystemOperationMode) value, diagnostics, context);
		case InstancePackage.MODE_INSTANCE:
			return validateModeInstance((ModeInstance) value, diagnostics, context);
		case InstancePackage.MODE_TRANSITION_INSTANCE:
			return validateModeTransitionInstance((ModeTransitionInstance) value, diagnostics, context);
		case InstancePackage.CONNECTION_REFERENCE:
			return validateConnectionReference((ConnectionReference) value, diagnostics, context);
		case InstancePackage.COMPONENT_INSTANCE:
			return validateComponentInstance((ComponentInstance) value, diagnostics, context);
		case InstancePackage.FLOW_SPECIFICATION_INSTANCE:
			return validateFlowSpecificationInstance((FlowSpecificationInstance) value, diagnostics, context);
		case InstancePackage.END_TO_END_FLOW_INSTANCE:
			return validateEndToEndFlowInstance((EndToEndFlowInstance) value, diagnostics, context);
		case InstancePackage.SYSTEM_INSTANCE:
			return validateSystemInstance((SystemInstance) value, diagnostics, context);
		case InstancePackage.INSTANCE_REFERENCE_VALUE:
			return validateInstanceReferenceValue((InstanceReferenceValue) value, diagnostics, context);
		case InstancePackage.CONNECTION_KIND:
			return validateConnectionKind((ConnectionKind) value, diagnostics, context);
		case InstancePackage.FEATURE_CATEGORY:
			return validateFeatureCategory((FeatureCategory) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureInstance(FeatureInstance featureInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(featureInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(featureInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(featureInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceObject(InstanceObject instanceObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceObject, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(instanceObject, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(instanceObject, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(instanceObject, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnexInstance(AnnexInstance annexInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(annexInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(annexInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(annexInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(annexInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssociationInstance(PropertyAssociationInstance propertyAssociationInstance,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyAssociationInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(propertyAssociationInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(propertyAssociationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(propertyAssociationInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionInstanceEnd(ConnectionInstanceEnd connectionInstanceEnd,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectionInstanceEnd, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connectionInstanceEnd, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(connectionInstanceEnd, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(connectionInstanceEnd, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(connectionInstanceEnd, diagnostics,
					context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionInstance(ConnectionInstance connectionInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectionInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connectionInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(connectionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(connectionInstance, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(connectionInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowElementInstance(FlowElementInstance flowElementInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowElementInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowElementInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(flowElementInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(flowElementInstance, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(flowElementInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemOperationMode(SystemOperationMode systemOperationMode, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemOperationMode, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemOperationMode, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(systemOperationMode, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(systemOperationMode, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(systemOperationMode, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeInstance(ModeInstance modeInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(modeInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(modeInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModeTransitionInstance(ModeTransitionInstance modeTransitionInstance,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modeTransitionInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modeTransitionInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(modeTransitionInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(modeTransitionInstance, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(modeTransitionInstance, diagnostics,
					context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionReference(ConnectionReference connectionReference, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectionReference, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(connectionReference, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(connectionReference, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(connectionReference, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(connectionReference, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentInstance(ComponentInstance componentInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(componentInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(componentInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator
					.validateNamedElement_has_no_qualified_name(componentInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(componentInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowSpecificationInstance(FlowSpecificationInstance flowSpecificationInstance,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowSpecificationInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(flowSpecificationInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(flowSpecificationInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(flowSpecificationInstance, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(flowSpecificationInstance, diagnostics,
					context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEndToEndFlowInstance(EndToEndFlowInstance endToEndFlowInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(endToEndFlowInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(endToEndFlowInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(endToEndFlowInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(endToEndFlowInstance, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator
					.validateNamedElement_has_qualified_name(endToEndFlowInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemInstance(SystemInstance systemInstance, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(systemInstance, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(systemInstance, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_no_qualified_name(systemInstance, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateNamedElement_has_qualified_name(systemInstance, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceReferenceValue(InstanceReferenceValue instanceReferenceValue,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(instanceReferenceValue, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(instanceReferenceValue, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_not_own_self(instanceReferenceValue, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= aadl2Validator.validateElement_has_owner(instanceReferenceValue, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionKind(ConnectionKind connectionKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCategory(FeatureCategory featureCategory, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private String getRedefinitionDetail(EClass eClass, String featureName, String key) {
		List<EClass> eClasses = new ArrayList<EClass>();
		eClasses.add(eClass);
		eClasses.addAll(eClass.getEAllSuperTypes());
		String redefinitionDetail = null;
		for (Iterator<EClass> eClassesIterator = eClasses.iterator(); redefinitionDetail == null
				&& eClassesIterator.hasNext();) {
			EAnnotation eAnnotation = eClassesIterator.next().getEAnnotation("duplicates"); //$NON-NLS-1$
			if (eAnnotation != null) {
				EAnnotation nestedEAnnotation = eAnnotation.getEAnnotation(featureName);
				if (nestedEAnnotation != null) {
					redefinitionDetail = nestedEAnnotation.getDetails().get(key);
				}
			}
		}
		return redefinitionDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int getLowerBound(EObject eObject, EStructuralFeature eStructuralFeature) {
		try {
			return Integer
					.parseInt(getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "lowerBound")); //$NON-NLS-1$
		} catch (Exception e) {
			return eStructuralFeature.getLowerBound();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int getUpperBound(EObject eObject, EStructuralFeature eStructuralFeature) {
		try {
			return Integer
					.parseInt(getRedefinitionDetail(eObject.eClass(), eStructuralFeature.getName(), "upperBound")); //$NON-NLS-1$
		} catch (Exception e) {
			return eStructuralFeature.getUpperBound();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean isEcoreString(String key) {
		return super.isEcoreString(key) || "_UI_FeatureHasTooFewValues_diagnostic".equals(key) //$NON-NLS-1$
				|| "_UI_FeatureHasTooManyValues_diagnostic".equals(key) //$NON-NLS-1$
				|| "_UI_RequiredFeatureMustBeSet_diagnostic".equals(key); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate_MultiplicityConforms(EObject eObject, EStructuralFeature eStructuralFeature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		if (eStructuralFeature.isMany()) {
			if (FeatureMapUtil.isFeatureMap(eStructuralFeature)
					&& ExtendedMetaData.INSTANCE.isDocumentRoot(eObject.eClass())) {
				result = super.validate_MultiplicityConforms(eObject, eStructuralFeature, diagnostics, context);
			} else {
				int lowerBound = getLowerBound(eObject, eStructuralFeature);
				if (lowerBound > 0) {
					int size = ((List<?>) eObject.eGet(eStructuralFeature)).size();
					if (size < lowerBound) {
						result = false;
						if (diagnostics != null) {
							diagnostics.add(createDiagnostic(Diagnostic.ERROR,
									EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooFewValues_diagnostic", //$NON-NLS-1$
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, lowerBound }, new Object[] {
											eObject, eStructuralFeature }, context));
						}
					}
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0 && size > upperBound) {
						result = false;
						if (diagnostics != null) {
							diagnostics.add(createDiagnostic(Diagnostic.ERROR,
									EObjectValidator.DIAGNOSTIC_SOURCE,
									EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
									"_UI_FeatureHasTooManyValues_diagnostic", //$NON-NLS-1$
									new Object[] { getFeatureLabel(eStructuralFeature, context),
											getObjectLabel(eObject, context), size, upperBound }, new Object[] {
											eObject, eStructuralFeature }, context));
						}
					}
				} else {
					int upperBound = getUpperBound(eObject, eStructuralFeature);
					if (upperBound > 0) {
						int size = ((List<?>) eObject.eGet(eStructuralFeature)).size();
						if (size > upperBound) {
							result = false;
							if (diagnostics != null) {
								diagnostics.add(createDiagnostic(Diagnostic.ERROR,
										EObjectValidator.DIAGNOSTIC_SOURCE,
										EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
										"_UI_FeatureHasTooManyValues_diagnostic", //$NON-NLS-1$
										new Object[] { getFeatureLabel(eStructuralFeature, context),
												getObjectLabel(eObject, context), size, upperBound }, new Object[] {
												eObject, eStructuralFeature }, context));
							}
						}
					}
				}
			}
		} else if (getLowerBound(eObject, eStructuralFeature) >= 1) {
			if (eStructuralFeature.isUnsettable() ? !eObject.eIsSet(eStructuralFeature) : eObject.eGet(
					eStructuralFeature, false) == null) {
				result = false;
				if (diagnostics != null) {
					diagnostics.add(createDiagnostic(
							Diagnostic.ERROR,
							EObjectValidator.DIAGNOSTIC_SOURCE,
							EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS,
							"_UI_RequiredFeatureMustBeSet_diagnostic", //$NON-NLS-1$
							new Object[] { getFeatureLabel(eStructuralFeature, context),
									getObjectLabel(eObject, context) }, new Object[] { eObject, eStructuralFeature },
							context));
				}
			}
		}
		return result;
	}
} // InstanceValidator
