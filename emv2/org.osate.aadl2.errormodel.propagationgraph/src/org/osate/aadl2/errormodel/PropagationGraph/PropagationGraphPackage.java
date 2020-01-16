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
	 * The feature id for the '<em><b>Propagation Graph Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS = 3;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__CONNECTIONS = 4;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH__ROOT = 5;

	/**
	 * The number of structural features of the '<em>Propagation Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Propagation Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationGraphPath()
	 * @generated
	 */
	int PROPAGATION_GRAPH_PATH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path Src</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__PATH_SRC = 1;

	/**
	 * The feature id for the '<em><b>Path Dst</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__PATH_DST = 2;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__HIGHLIGHT = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH__CONNECTION = 5;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_GRAPH_PATH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl <em>Propagation Path End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationPathEndImpl
	 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationPathEnd()
	 * @generated
	 */
	int PROPAGATION_PATH_END = 2;

	/**
	 * The feature id for the '<em><b>Connection Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END__CONNECTION_INSTANCE = 0;

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
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END__HIGHLIGHT = 3;

	/**
	 * The number of structural features of the '<em>Propagation Path End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_END_FEATURE_COUNT = 4;

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
	int PROPAGATION_TYPE = 3;


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
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationGraphPaths <em>Propagation Graph Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Graph Paths</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationGraphPaths()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_PropagationGraphPaths();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getConnections()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_Connections();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getRoot()
	 * @see #getPropagationGraph()
	 * @generated
	 */
	EReference getPropagationGraph_Root();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath
	 * @generated
	 */
	EClass getPropagationGraphPath();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getName()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EAttribute getPropagationGraphPath_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getPathSrc <em>Path Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Src</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getPathSrc()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EReference getPropagationGraphPath_PathSrc();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getPathDst <em>Path Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Dst</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getPathDst()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EReference getPropagationGraphPath_PathDst();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#isHighlight()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EAttribute getPropagationGraphPath_Highlight();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getType()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EAttribute getPropagationGraphPath_Type();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath#getConnection()
	 * @see #getPropagationGraphPath()
	 * @generated
	 */
	EReference getPropagationGraphPath_Connection();

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
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Instance</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getConnectionInstance()
	 * @see #getPropagationPathEnd()
	 * @generated
	 */
	EReference getPropagationPathEnd_ConnectionInstance();

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
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#isHighlight()
	 * @see #getPropagationPathEnd()
	 * @generated
	 */
	EAttribute getPropagationPathEnd_Highlight();

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
		 * The meta object literal for the '<em><b>Propagation Graph Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__PROPAGATION_GRAPH_PATHS = eINSTANCE.getPropagationGraph_PropagationGraphPaths();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__CONNECTIONS = eINSTANCE.getPropagationGraph_Connections();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH__ROOT = eINSTANCE.getPropagationGraph_Root();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPathImpl
		 * @see org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphPackageImpl#getPropagationGraphPath()
		 * @generated
		 */
		EClass PROPAGATION_GRAPH_PATH = eINSTANCE.getPropagationGraphPath();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_GRAPH_PATH__NAME = eINSTANCE.getPropagationGraphPath_Name();

		/**
		 * The meta object literal for the '<em><b>Path Src</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH_PATH__PATH_SRC = eINSTANCE.getPropagationGraphPath_PathSrc();

		/**
		 * The meta object literal for the '<em><b>Path Dst</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH_PATH__PATH_DST = eINSTANCE.getPropagationGraphPath_PathDst();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_GRAPH_PATH__HIGHLIGHT = eINSTANCE.getPropagationGraphPath_Highlight();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_GRAPH_PATH__TYPE = eINSTANCE.getPropagationGraphPath_Type();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_GRAPH_PATH__CONNECTION = eINSTANCE.getPropagationGraphPath_Connection();

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
		 * The meta object literal for the '<em><b>Connection Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_END__CONNECTION_INSTANCE = eINSTANCE.getPropagationPathEnd_ConnectionInstance();

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
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPAGATION_PATH_END__HIGHLIGHT = eINSTANCE.getPropagationPathEnd_Highlight();

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
