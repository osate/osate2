/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.aadl2.instance.InstancePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory
 * @model kind="package"
 * @generated
 */
public interface EMV2InstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EMV2Instance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.osate.org/EMV2Instance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EMV2Instance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMV2InstancePackage eINSTANCE = org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
	 * @generated
	 */
	int EMV2_INSTANCE_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_ELEMENT = InstancePackage.INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_COMMENT = InstancePackage.INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__NAME = InstancePackage.INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__QUALIFIED_NAME = InstancePackage.INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION = InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE = InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT_FEATURE_COUNT = InstancePackage.INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT___GET_OWNER = InstancePackage.INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT___GET_NAMESPACE = InstancePackage.INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT___QUALIFIED_NAME = InstancePackage.INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING = InstancePackage.INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT_OPERATION_COUNT = InstancePackage.INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
	 * @generated
	 */
	int EMV2_ANNEX_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_ELEMENT = InstancePackage.INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_COMMENT = InstancePackage.INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__NAME = InstancePackage.INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__QUALIFIED_NAME = InstancePackage.INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_PROPERTY_ASSOCIATION = InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ANNEX_INSTANCE = InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Annex Subclause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE = InstancePackage.INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMV2 Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE_FEATURE_COUNT = InstancePackage.INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE___GET_OWNER = InstancePackage.INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE___GET_NAMESPACE = InstancePackage.INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE___QUALIFIED_NAME = InstancePackage.INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = InstancePackage.INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>EMV2 Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE_OPERATION_COUNT = InstancePackage.INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl <em>State Variable Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateVariableInstance()
	 * @generated
	 */
	int STATE_VARIABLE_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__STATES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE__CURRENT_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State Variable Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>State Variable Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_INSTANCE_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateInstance()
	 * @generated
	 */
	int STATE_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
	 * @generated
	 */
	int CONSTRAINED_INSTANCE_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OUTGOING = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constrained Instance Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>Constrained Instance Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
	 * @generated
	 */
	int STATE_TRANSITION_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__TARGET_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__STATE_TRANSITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>State Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl <em>State Synchronization Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateSynchronizationInstance()
	 * @generated
	 */
	int STATE_SYNCHRONIZATION_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Synchronization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State Synchronization Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>State Synchronization Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SYNCHRONIZATION_INSTANCE_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl <em>Behavior Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getBehaviorInstance()
	 * @generated
	 */
	int BEHAVIOR_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__ACTIONS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sink</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE__SINK = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Behavior Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE___GET_OWNER = EMV2_INSTANCE_OBJECT___GET_OWNER;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE___GET_NAMESPACE = EMV2_INSTANCE_OBJECT___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE___QUALIFIED_NAME = EMV2_INSTANCE_OBJECT___QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Get Property Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE___GET_PROPERTY_VALUES__STRING_STRING = EMV2_INSTANCE_OBJECT___GET_PROPERTY_VALUES__STRING_STRING;

	/**
	 * The number of operations of the '<em>Behavior Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_INSTANCE_OPERATION_COUNT = EMV2_INSTANCE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.LiteralImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 8;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.TypeReferenceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getTypeReference()
	 * @generated
	 */
	int TYPE_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ECollectionImpl <em>ECollection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ECollectionImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getECollection()
	 * @generated
	 */
	int ECOLLECTION = 10;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLLECTION__ELEMENTS = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ECollection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLLECTION_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ECollection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLLECTION_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.MultiLiteralConstraintImpl <em>Multi Literal Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.MultiLiteralConstraintImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getMultiLiteralConstraint()
	 * @generated
	 */
	int MULTI_LITERAL_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LITERAL_CONSTRAINT__OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LITERAL_CONSTRAINT__K = 1;

	/**
	 * The number of structural features of the '<em>Multi Literal Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LITERAL_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Multi Literal Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LITERAL_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEOperation()
	 * @generated
	 */
	int EOPERATION = 12;


	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject
	 * @generated
	 */
	EClass getEMV2InstanceObject();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance <em>EMV2 Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMV2 Annex Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance
	 * @generated
	 */
	EClass getEMV2AnnexInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance <em>State Variable Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Variable Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance
	 * @generated
	 */
	EClass getStateVariableInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getStates()
	 * @see #getStateVariableInstance()
	 * @generated
	 */
	EReference getStateVariableInstance_States();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getCurrentState()
	 * @see #getStateVariableInstance()
	 * @generated
	 */
	EReference getStateVariableInstance_CurrentState();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance <em>State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance
	 * @generated
	 */
	EClass getStateInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject <em>Constrained Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Instance Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject
	 * @generated
	 */
	EClass getConstrainedInstanceObject();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject <em>Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_InstanceObject();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#isOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outgoing</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#isOutgoing()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EAttribute getConstrainedInstanceObject_Outgoing();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance <em>State Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Transition Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance
	 * @generated
	 */
	EClass getStateTransitionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getTargetState()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_TargetState();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getCondition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getStateTransition <em>State Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Transition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getStateTransition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_StateTransition();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance <em>State Synchronization Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Synchronization Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance
	 * @generated
	 */
	EClass getStateSynchronizationInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getTargetState()
	 * @see #getStateSynchronizationInstance()
	 * @generated
	 */
	EReference getStateSynchronizationInstance_TargetState();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getCondition()
	 * @see #getStateSynchronizationInstance()
	 * @generated
	 */
	EReference getStateSynchronizationInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getStateSynchronization <em>State Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Synchronization</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getStateSynchronization()
	 * @see #getStateSynchronizationInstance()
	 * @generated
	 */
	EReference getStateSynchronizationInstance_StateSynchronization();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance <em>Behavior Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance
	 * @generated
	 */
	EClass getBehaviorInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getCondition()
	 * @see #getBehaviorInstance()
	 * @generated
	 */
	EReference getBehaviorInstance_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getActions()
	 * @see #getBehaviorInstance()
	 * @generated
	 */
	EReference getBehaviorInstance_Actions();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSource()
	 * @see #getBehaviorInstance()
	 * @generated
	 */
	EAttribute getBehaviorInstance_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSink <em>Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sink</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSink()
	 * @see #getBehaviorInstance()
	 * @generated
	 */
	EAttribute getBehaviorInstance_Sink();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Reference</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference
	 * @generated
	 */
	EClass getTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference#getType()
	 * @see #getTypeReference()
	 * @generated
	 */
	EReference getTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection <em>ECollection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECollection</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection
	 * @generated
	 */
	EClass getECollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection#getElements()
	 * @see #getECollection()
	 * @generated
	 */
	EReference getECollection_Elements();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint <em>Multi Literal Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Literal Constraint</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint
	 * @generated
	 */
	EClass getMultiLiteralConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getOperator()
	 * @see #getMultiLiteralConstraint()
	 * @generated
	 */
	EAttribute getMultiLiteralConstraint_Operator();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getK()
	 * @see #getMultiLiteralConstraint()
	 * @generated
	 */
	EAttribute getMultiLiteralConstraint_K();

	/**
	 * Returns the meta object for enum '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EOperation</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @generated
	 */
	EEnum getEOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EMV2InstanceFactory getEMV2InstanceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
		 * @generated
		 */
		EClass EMV2_INSTANCE_OBJECT = eINSTANCE.getEMV2InstanceObject();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
		 * @generated
		 */
		EClass EMV2_ANNEX_INSTANCE = eINSTANCE.getEMV2AnnexInstance();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl <em>State Variable Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateVariableInstance()
		 * @generated
		 */
		EClass STATE_VARIABLE_INSTANCE = eINSTANCE.getStateVariableInstance();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_VARIABLE_INSTANCE__STATES = eINSTANCE.getStateVariableInstance_States();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_VARIABLE_INSTANCE__CURRENT_STATE = eINSTANCE.getStateVariableInstance_CurrentState();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateInstance()
		 * @generated
		 */
		EClass STATE_INSTANCE = eINSTANCE.getStateInstance();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
		 * @generated
		 */
		EClass CONSTRAINED_INSTANCE_OBJECT = eINSTANCE.getConstrainedInstanceObject();

		/**
		 * The meta object literal for the '<em><b>Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT = eINSTANCE.getConstrainedInstanceObject_InstanceObject();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT = eINSTANCE.getConstrainedInstanceObject_Constraint();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINED_INSTANCE_OBJECT__OUTGOING = eINSTANCE.getConstrainedInstanceObject_Outgoing();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
		 * @generated
		 */
		EClass STATE_TRANSITION_INSTANCE = eINSTANCE.getStateTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__TARGET_STATE = eINSTANCE.getStateTransitionInstance_TargetState();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__CONDITION = eINSTANCE.getStateTransitionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>State Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__STATE_TRANSITION = eINSTANCE.getStateTransitionInstance_StateTransition();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl <em>State Synchronization Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateSynchronizationInstance()
		 * @generated
		 */
		EClass STATE_SYNCHRONIZATION_INSTANCE = eINSTANCE.getStateSynchronizationInstance();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE = eINSTANCE.getStateSynchronizationInstance_TargetState();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SYNCHRONIZATION_INSTANCE__CONDITION = eINSTANCE.getStateSynchronizationInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>State Synchronization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION = eINSTANCE.getStateSynchronizationInstance_StateSynchronization();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl <em>Behavior Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getBehaviorInstance()
		 * @generated
		 */
		EClass BEHAVIOR_INSTANCE = eINSTANCE.getBehaviorInstance();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_INSTANCE__CONDITION = eINSTANCE.getBehaviorInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_INSTANCE__ACTIONS = eINSTANCE.getBehaviorInstance_Actions();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_INSTANCE__SOURCE = eINSTANCE.getBehaviorInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Sink</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_INSTANCE__SINK = eINSTANCE.getBehaviorInstance_Sink();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.LiteralImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.TypeReferenceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getTypeReference()
		 * @generated
		 */
		EClass TYPE_REFERENCE = eINSTANCE.getTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_REFERENCE__TYPE = eINSTANCE.getTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ECollectionImpl <em>ECollection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ECollectionImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getECollection()
		 * @generated
		 */
		EClass ECOLLECTION = eINSTANCE.getECollection();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECOLLECTION__ELEMENTS = eINSTANCE.getECollection_Elements();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.MultiLiteralConstraintImpl <em>Multi Literal Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.MultiLiteralConstraintImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getMultiLiteralConstraint()
		 * @generated
		 */
		EClass MULTI_LITERAL_CONSTRAINT = eINSTANCE.getMultiLiteralConstraint();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LITERAL_CONSTRAINT__OPERATOR = eINSTANCE.getMultiLiteralConstraint_Operator();

		/**
		 * The meta object literal for the '<em><b>K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LITERAL_CONSTRAINT__K = eINSTANCE.getMultiLiteralConstraint_K();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEOperation()
		 * @generated
		 */
		EEnum EOPERATION = eINSTANCE.getEOperation();

	}

} //EMV2InstancePackage
