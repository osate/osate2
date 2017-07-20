/**
 */
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphFactory
 * @model kind="package"
 * @generated
 */
public interface PropagationGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PropagationGraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.aadl.info/PropagationGraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PropagationGraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropagationGraphPackage eINSTANCE = org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl <em>Propagation Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationGraph()
	 * @generated
	 */
	int PROPAGATION_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__COMPONENTS = 2;

	/**
	 * The feature id for the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__PROPAGATION_PATHS = 3;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__NODES = 4;

	/**
	 * The number of structural features of the '<em>Propagation Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Propagation Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathImpl <em>Propagation Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationPath()
	 * @generated
	 */
	int PROPAGATION_PATH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path Src</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH__PATH_SRC = 1;

	/**
	 * The feature id for the '<em><b>Path Dst</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH__PATH_DST = 2;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH__HIGHLIGHT = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Propagation Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Propagation Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl <em>Propagation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationNode()
	 * @generated
	 */
	int PROPAGATION_NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_NODE__HIGHLIGHT = 1;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_NODE__COMPONENT_INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Propagation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Propagation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl <em>Propagation Path End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationPathEnd()
	 * @generated
	 */
	int PROPAGATION_PATH_END = 3;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END__INSTANCE_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END__ERROR_PROPAGATION = 1;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END__COMPONENT_INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Propagation Path End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Propagation Path End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationType <em>Propagation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationType
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationType()
	 * @generated
	 */
	int PROPAGATION_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph <em>Propagation Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Graph</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph
	 * @generated
	 */
	EClass getPropagationGraph();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EAttribute getPropagationGraph_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EAttribute getPropagationGraph_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getComponents()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationPaths <em>Propagation Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Paths</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationPaths()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_PropagationPaths();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getNodes()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_Nodes();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath <em>Propagation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Path</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath
	 * @generated
	 */
	EClass getPropagationPath();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getName()
	 * @see #getPropagationPath()
	 * @generated
	 */
	EAttribute getPropagationPath_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getPathSrc <em>Path Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Src</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getPathSrc()
	 * @see #getPropagationPath()
	 * @generated
	 */
	EReference getPropagationPath_PathSrc();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getPathDst <em>Path Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Dst</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getPathDst()
	 * @see #getPropagationPath()
	 * @generated
	 */
	EReference getPropagationPath_PathDst();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#isHighlight()
	 * @see #getPropagationPath()
	 * @generated
	 */
	EAttribute getPropagationPath_Highlight();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPath#getType()
	 * @see #getPropagationPath()
	 * @generated
	 */
	EAttribute getPropagationPath_Type();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode <em>Propagation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Node</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationNode
	 * @generated
	 */
	EClass getPropagationNode();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getName()
	 * @see #getPropagationNode()
	 * @generated
	 */
	EAttribute getPropagationNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#isHighlight()
	 * @see #getPropagationNode()
	 * @generated
	 */
	EAttribute getPropagationNode_Highlight();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Instance</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getComponentInstance()
	 * @see #getPropagationNode()
	 * @generated
	 */
	EReference getPropagationNode_ComponentInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd <em>Propagation Path End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Path End</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd
	 * @generated
	 */
	EClass getPropagationPathEnd();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getInstanceObject <em>Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Object</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getInstanceObject()
	 * @see #getPropagationPathEnd()
	 * @generated
	 */
	EReference getPropagationPathEnd_InstanceObject();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation <em>Error Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation()
	 * @see #getPropagationPathEnd()
	 * @generated
	 */
	EReference getPropagationPathEnd_ErrorPropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Instance</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance()
	 * @see #getPropagationPathEnd()
	 * @generated
	 */
	EReference getPropagationPathEnd_ComponentInstance();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationType <em>Propagation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Propagation Type</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationType
	 * @generated
	 */
	EEnum getPropagationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropagationGraphFactory getPropagationGraphFactory();

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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl <em>Propagation Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphImpl
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationGraph()
		 * @generated
		 */
		EClass PROPAGATION_GRAPH = eINSTANCE.getPropagationGraph();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_GRAPH__NAME = eINSTANCE.getPropagationGraph_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_GRAPH__DESCRIPTION = eINSTANCE.getPropagationGraph_Description();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__COMPONENTS = eINSTANCE.getPropagationGraph_Components();

		/**
		 * The meta object literal for the '<em><b>Propagation Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__PROPAGATION_PATHS = eINSTANCE.getPropagationGraph_PropagationPaths();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__NODES = eINSTANCE.getPropagationGraph_Nodes();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathImpl <em>Propagation Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathImpl
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationPath()
		 * @generated
		 */
		EClass PROPAGATION_PATH = eINSTANCE.getPropagationPath();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_PATH__NAME = eINSTANCE.getPropagationPath_Name();

		/**
		 * The meta object literal for the '<em><b>Path Src</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH__PATH_SRC = eINSTANCE.getPropagationPath_PathSrc();

		/**
		 * The meta object literal for the '<em><b>Path Dst</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH__PATH_DST = eINSTANCE.getPropagationPath_PathDst();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_PATH__HIGHLIGHT = eINSTANCE.getPropagationPath_Highlight();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_PATH__TYPE = eINSTANCE.getPropagationPath_Type();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl <em>Propagation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationNodeImpl
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationNode()
		 * @generated
		 */
		EClass PROPAGATION_NODE = eINSTANCE.getPropagationNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_NODE__NAME = eINSTANCE.getPropagationNode_Name();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_NODE__HIGHLIGHT = eINSTANCE.getPropagationNode_Highlight();

		/**
		 * The meta object literal for the '<em><b>Component Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_NODE__COMPONENT_INSTANCE = eINSTANCE.getPropagationNode_ComponentInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl <em>Propagation Path End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationPathEnd()
		 * @generated
		 */
		EClass PROPAGATION_PATH_END = eINSTANCE.getPropagationPathEnd();

		/**
		 * The meta object literal for the '<em><b>Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_END__INSTANCE_OBJECT = eINSTANCE.getPropagationPathEnd_InstanceObject();

		/**
		 * The meta object literal for the '<em><b>Error Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_END__ERROR_PROPAGATION = eINSTANCE.getPropagationPathEnd_ErrorPropagation();

		/**
		 * The meta object literal for the '<em><b>Component Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_END__COMPONENT_INSTANCE = eINSTANCE.getPropagationPathEnd_ComponentInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationType <em>Propagation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationType
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationType()
		 * @generated
		 */
		EEnum PROPAGATION_TYPE = eINSTANCE.getPropagationType();

	}

} //PropagationGraphPackage
