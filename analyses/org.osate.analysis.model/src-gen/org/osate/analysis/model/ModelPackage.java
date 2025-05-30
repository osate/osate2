/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 * 
 */
package org.osate.analysis.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.osate.analysis.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://osate.org/analysis/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.osate.analysis.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.analysis.model.impl.AnalysisElementImpl <em>Analysis Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.model.impl.AnalysisElementImpl
	 * @see org.osate.analysis.model.impl.ModelPackageImpl#getAnalysisElement()
	 * @generated
	 */
	int ANALYSIS_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Analysis Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ELEMENT___IS_LEAF = 0;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN = 1;

	/**
	 * The number of operations of the '<em>Analysis Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ELEMENT_OPERATION_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.osate.analysis.model.AnalysisElement <em>Analysis Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis Element</em>'.
	 * @see org.osate.analysis.model.AnalysisElement
	 * @generated
	 */
	EClass getAnalysisElement();

	/**
	 * Returns the meta object for the '{@link org.osate.analysis.model.AnalysisElement#isLeaf() <em>Is Leaf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Leaf</em>' operation.
	 * @see org.osate.analysis.model.AnalysisElement#isLeaf()
	 * @generated
	 */
	EOperation getAnalysisElement__IsLeaf();

	/**
	 * Returns the meta object for the '{@link org.osate.analysis.model.AnalysisElement#getOrderedChildren() <em>Get Ordered Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Ordered Children</em>' operation.
	 * @see org.osate.analysis.model.AnalysisElement#getOrderedChildren()
	 * @generated
	 */
	EOperation getAnalysisElement__GetOrderedChildren();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.osate.analysis.model.impl.AnalysisElementImpl <em>Analysis Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.model.impl.AnalysisElementImpl
		 * @see org.osate.analysis.model.impl.ModelPackageImpl#getAnalysisElement()
		 * @generated
		 */
		EClass ANALYSIS_ELEMENT = eINSTANCE.getAnalysisElement();

		/**
		 * The meta object literal for the '<em><b>Is Leaf</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANALYSIS_ELEMENT___IS_LEAF = eINSTANCE.getAnalysisElement__IsLeaf();

		/**
		 * The meta object literal for the '<em><b>Get Ordered Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN = eINSTANCE.getAnalysisElement__GetOrderedChildren();

	}

} //ModelPackage
