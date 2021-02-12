/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.osate.analysis.model.analysis.AnalysisPackage;

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
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadFactory
 * @model kind="package"
 * @generated
 */
public interface BusloadPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "busload";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://osate.org/analysis/busload";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "busload";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BusloadPackage eINSTANCE = org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadElementImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusloadElement()
	 * @generated
	 */
	int BUSLOAD_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT__LABEL = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT__ACTUAL = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT__BUDGET = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT___IS_LEAF = AnalysisPackage.ANALYSIS_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT___GET_ORDERED_CHILDREN = AnalysisPackage.ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSLOAD_ELEMENT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LABEL = BUSLOAD_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ACTUAL = BUSLOAD_ELEMENT__ACTUAL;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__BUDGET = BUSLOAD_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Connection Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_INSTANCE = BUSLOAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = BUSLOAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION___IS_LEAF = BUSLOAD_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION___GET_ORDERED_CHILDREN = BUSLOAD_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = BUSLOAD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BroadcastImpl <em>Broadcast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BroadcastImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBroadcast()
	 * @generated
	 */
	int BROADCAST = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__LABEL = BUSLOAD_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__ACTUAL = BUSLOAD_ELEMENT__ACTUAL;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__BUDGET = BUSLOAD_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__CONNECTIONS = BUSLOAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__SOURCE = BUSLOAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Broadcast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST_FEATURE_COUNT = BUSLOAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST___IS_LEAF = BUSLOAD_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST___GET_ORDERED_CHILDREN = BUSLOAD_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Broadcast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST_OPERATION_COUNT = BUSLOAD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl <em>Bus Or Virtual Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusOrVirtualBus()
	 * @generated
	 */
	int BUS_OR_VIRTUAL_BUS = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__LABEL = BUSLOAD_ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__ACTUAL = BUSLOAD_ELEMENT__ACTUAL;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__BUDGET = BUSLOAD_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Bound Virtual Buses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES = BUSLOAD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS = BUSLOAD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound Broadcasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS = BUSLOAD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bus Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__BUS_INSTANCE = BUSLOAD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD = BUSLOAD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bus Or Virtual Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS_FEATURE_COUNT = BUSLOAD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS___IS_LEAF = BUSLOAD_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS___GET_ORDERED_CHILDREN = BUSLOAD_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Bus Or Virtual Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OR_VIRTUAL_BUS_OPERATION_COUNT = BUSLOAD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.VirtualBusImpl <em>Virtual Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.VirtualBusImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getVirtualBus()
	 * @generated
	 */
	int VIRTUAL_BUS = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__LABEL = BUS_OR_VIRTUAL_BUS__LABEL;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__ACTUAL = BUS_OR_VIRTUAL_BUS__ACTUAL;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__BUDGET = BUS_OR_VIRTUAL_BUS__BUDGET;

	/**
	 * The feature id for the '<em><b>Bound Virtual Buses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__BOUND_VIRTUAL_BUSES = BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES;

	/**
	 * The feature id for the '<em><b>Bound Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__BOUND_CONNECTIONS = BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Bound Broadcasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__BOUND_BROADCASTS = BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS;

	/**
	 * The feature id for the '<em><b>Bus Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__BUS_INSTANCE = BUS_OR_VIRTUAL_BUS__BUS_INSTANCE;

	/**
	 * The feature id for the '<em><b>Data Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS__DATA_OVERHEAD = BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD;

	/**
	 * The number of structural features of the '<em>Virtual Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS_FEATURE_COUNT = BUS_OR_VIRTUAL_BUS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS___IS_LEAF = BUS_OR_VIRTUAL_BUS___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS___GET_ORDERED_CHILDREN = BUS_OR_VIRTUAL_BUS___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Virtual Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_BUS_OPERATION_COUNT = BUS_OR_VIRTUAL_BUS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusImpl <em>Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBus()
	 * @generated
	 */
	int BUS = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__LABEL = BUS_OR_VIRTUAL_BUS__LABEL;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__ACTUAL = BUS_OR_VIRTUAL_BUS__ACTUAL;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__BUDGET = BUS_OR_VIRTUAL_BUS__BUDGET;

	/**
	 * The feature id for the '<em><b>Bound Virtual Buses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__BOUND_VIRTUAL_BUSES = BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES;

	/**
	 * The feature id for the '<em><b>Bound Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__BOUND_CONNECTIONS = BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Bound Broadcasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__BOUND_BROADCASTS = BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS;

	/**
	 * The feature id for the '<em><b>Bus Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__BUS_INSTANCE = BUS_OR_VIRTUAL_BUS__BUS_INSTANCE;

	/**
	 * The feature id for the '<em><b>Data Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__DATA_OVERHEAD = BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD;

	/**
	 * The number of structural features of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_FEATURE_COUNT = BUS_OR_VIRTUAL_BUS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS___IS_LEAF = BUS_OR_VIRTUAL_BUS___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS___GET_ORDERED_CHILDREN = BUS_OR_VIRTUAL_BUS___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_OPERATION_COUNT = BUS_OR_VIRTUAL_BUS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusLoadModelImpl <em>Bus Load Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusLoadModelImpl
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusLoadModel()
	 * @generated
	 */
	int BUS_LOAD_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Root Buses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_LOAD_MODEL__ROOT_BUSES = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bus Load Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_LOAD_MODEL_FEATURE_COUNT = AnalysisPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_LOAD_MODEL___IS_LEAF = AnalysisPackage.ANALYSIS_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_LOAD_MODEL___GET_ORDERED_CHILDREN = AnalysisPackage.ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Bus Load Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_LOAD_MODEL_OPERATION_COUNT = AnalysisPackage.ANALYSIS_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement
	 * @generated
	 */
	EClass getBusloadElement();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getLabel()
	 * @see #getBusloadElement()
	 * @generated
	 */
	EAttribute getBusloadElement_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getActual()
	 * @see #getBusloadElement()
	 * @generated
	 */
	EAttribute getBusloadElement_Actual();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getBudget <em>Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadElement#getBudget()
	 * @see #getBusloadElement()
	 * @generated
	 */
	EAttribute getBusloadElement_Budget();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resources.budgets.internal.models.busload.Connection#getConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Instance</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Connection#getConnectionInstance()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_ConnectionInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast <em>Broadcast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broadcast</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Broadcast
	 * @generated
	 */
	EClass getBroadcast();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getConnections()
	 * @see #getBroadcast()
	 * @generated
	 */
	EReference getBroadcast_Connections();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getSource()
	 * @see #getBroadcast()
	 * @generated
	 */
	EReference getBroadcast_Source();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus <em>Bus Or Virtual Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Or Virtual Bus</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus
	 * @generated
	 */
	EClass getBusOrVirtualBus();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundBroadcasts <em>Bound Broadcasts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bound Broadcasts</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundBroadcasts()
	 * @see #getBusOrVirtualBus()
	 * @generated
	 */
	EReference getBusOrVirtualBus_BoundBroadcasts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundConnections <em>Bound Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bound Connections</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundConnections()
	 * @see #getBusOrVirtualBus()
	 * @generated
	 */
	EReference getBusOrVirtualBus_BoundConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundVirtualBuses <em>Bound Virtual Buses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bound Virtual Buses</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundVirtualBuses()
	 * @see #getBusOrVirtualBus()
	 * @generated
	 */
	EReference getBusOrVirtualBus_BoundVirtualBuses();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance <em>Bus Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bus Instance</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance()
	 * @see #getBusOrVirtualBus()
	 * @generated
	 */
	EReference getBusOrVirtualBus_BusInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead <em>Data Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Overhead</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead()
	 * @see #getBusOrVirtualBus()
	 * @generated
	 */
	EAttribute getBusOrVirtualBus_DataOverhead();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus <em>Virtual Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Bus</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus
	 * @generated
	 */
	EClass getVirtualBus();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Bus
	 * @generated
	 */
	EClass getBus();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel <em>Bus Load Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Load Model</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel
	 * @generated
	 */
	EClass getBusLoadModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel#getRootBuses <em>Root Buses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Buses</em>'.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel#getRootBuses()
	 * @see #getBusLoadModel()
	 * @generated
	 */
	EReference getBusLoadModel_RootBuses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BusloadFactory getBusloadFactory();

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
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadElementImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusloadElement()
		 * @generated
		 */
		EClass BUSLOAD_ELEMENT = eINSTANCE.getBusloadElement();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSLOAD_ELEMENT__LABEL = eINSTANCE.getBusloadElement_Label();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSLOAD_ELEMENT__ACTUAL = eINSTANCE.getBusloadElement_Actual();

		/**
		 * The meta object literal for the '<em><b>Budget</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSLOAD_ELEMENT__BUDGET = eINSTANCE.getBusloadElement_Budget();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Connection Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__CONNECTION_INSTANCE = eINSTANCE.getConnection_ConnectionInstance();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BroadcastImpl <em>Broadcast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BroadcastImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBroadcast()
		 * @generated
		 */
		EClass BROADCAST = eINSTANCE.getBroadcast();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BROADCAST__CONNECTIONS = eINSTANCE.getBroadcast_Connections();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BROADCAST__SOURCE = eINSTANCE.getBroadcast_Source();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl <em>Bus Or Virtual Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusOrVirtualBus()
		 * @generated
		 */
		EClass BUS_OR_VIRTUAL_BUS = eINSTANCE.getBusOrVirtualBus();

		/**
		 * The meta object literal for the '<em><b>Bound Broadcasts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS = eINSTANCE.getBusOrVirtualBus_BoundBroadcasts();

		/**
		 * The meta object literal for the '<em><b>Bound Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS = eINSTANCE.getBusOrVirtualBus_BoundConnections();

		/**
		 * The meta object literal for the '<em><b>Bound Virtual Buses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES = eINSTANCE.getBusOrVirtualBus_BoundVirtualBuses();

		/**
		 * The meta object literal for the '<em><b>Bus Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_OR_VIRTUAL_BUS__BUS_INSTANCE = eINSTANCE.getBusOrVirtualBus_BusInstance();

		/**
		 * The meta object literal for the '<em><b>Data Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD = eINSTANCE.getBusOrVirtualBus_DataOverhead();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.VirtualBusImpl <em>Virtual Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.VirtualBusImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getVirtualBus()
		 * @generated
		 */
		EClass VIRTUAL_BUS = eINSTANCE.getVirtualBus();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusImpl <em>Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBus()
		 * @generated
		 */
		EClass BUS = eINSTANCE.getBus();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusLoadModelImpl <em>Bus Load Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusLoadModelImpl
		 * @see org.osate.analysis.resources.budgets.internal.models.busload.impl.BusloadPackageImpl#getBusLoadModel()
		 * @generated
		 */
		EClass BUS_LOAD_MODEL = eINSTANCE.getBusLoadModel();

		/**
		 * The meta object literal for the '<em><b>Root Buses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_LOAD_MODEL__ROOT_BUSES = eINSTANCE.getBusLoadModel_RootBuses();

	}

} //BusloadPackage
