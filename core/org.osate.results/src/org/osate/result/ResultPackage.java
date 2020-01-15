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
package org.osate.result;

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
 * @see org.osate.result.ResultFactory
 * @model kind="package"
 * @generated
 */
public interface ResultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "result";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.osate.org/result/Result";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "result";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultPackage eINSTANCE = org.osate.result.impl.ResultPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.result.impl.AnalysisResultImpl <em>Analysis Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.AnalysisResultImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getAnalysisResult()
	 * @generated
	 */
	int ANALYSIS_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Analysis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__MODEL_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__RESULTS = 4;

	/**
	 * The feature id for the '<em><b>Diagnostics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__DIAGNOSTICS = 5;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__RESULT_TYPE = 6;

	/**
	 * The number of structural features of the '<em>Analysis Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Analysis Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ResultImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getResult()
	 * @generated
	 */
	int RESULT = 1;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.DiagnosticImpl <em>Diagnostic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.DiagnosticImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getDiagnostic()
	 * @generated
	 */
	int DIAGNOSTIC = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Diagnostics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__DIAGNOSTICS = 1;

	/**
	 * The feature id for the '<em><b>Sub Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SUB_RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__MODEL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__RESULT_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Diagnostic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__DIAGNOSTIC_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__MODEL_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Diagnostic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Diagnostic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 3;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.IntegerValueImpl <em>Integer Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.IntegerValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getIntegerValue()
	 * @generated
	 */
	int INTEGER_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__UNIT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.RealValueImpl <em>Real Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.RealValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getRealValue()
	 * @generated
	 */
	int REAL_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE__UNIT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.StringValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.BooleanValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.EObjectValueImpl <em>EObject Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.EObjectValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getEObjectValue()
	 * @generated
	 */
	int EOBJECT_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EObject Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ObjectValueImpl <em>Object Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ObjectValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getObjectValue()
	 * @generated
	 */
	int OBJECT_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.DiagnosticType <em>Diagnostic Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.DiagnosticType
	 * @see org.osate.result.impl.ResultPackageImpl#getDiagnosticType()
	 * @generated
	 */
	int DIAGNOSTIC_TYPE = 10;

	/**
	 * The meta object id for the '{@link org.osate.result.ResultType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.ResultType
	 * @see org.osate.result.impl.ResultPackageImpl#getResultType()
	 * @generated
	 */
	int RESULT_TYPE = 11;

	/**
	 * Returns the meta object for class '{@link org.osate.result.AnalysisResult <em>Analysis Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis Result</em>'.
	 * @see org.osate.result.AnalysisResult
	 * @generated
	 */
	EClass getAnalysisResult();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.AnalysisResult#getAnalysis <em>Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis</em>'.
	 * @see org.osate.result.AnalysisResult#getAnalysis()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EAttribute getAnalysisResult_Analysis();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.AnalysisResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.result.AnalysisResult#getMessage()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EAttribute getAnalysisResult_Message();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.AnalysisResult#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.osate.result.AnalysisResult#getModelElement()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EReference getAnalysisResult_ModelElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.AnalysisResult#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.osate.result.AnalysisResult#getParameters()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EReference getAnalysisResult_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.AnalysisResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.osate.result.AnalysisResult#getResults()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EReference getAnalysisResult_Results();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.AnalysisResult#getDiagnostics <em>Diagnostics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagnostics</em>'.
	 * @see org.osate.result.AnalysisResult#getDiagnostics()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EReference getAnalysisResult_Diagnostics();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.AnalysisResult#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see org.osate.result.AnalysisResult#getResultType()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EAttribute getAnalysisResult_ResultType();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.osate.result.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.osate.result.Result#getValues()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getDiagnostics <em>Diagnostics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagnostics</em>'.
	 * @see org.osate.result.Result#getDiagnostics()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Diagnostics();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getSubResults <em>Sub Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Results</em>'.
	 * @see org.osate.result.Result#getSubResults()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_SubResults();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Result#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.result.Result#getMessage()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Message();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.Result#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.osate.result.Result#getModelElement()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_ModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Result#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see org.osate.result.Result#getResultType()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ResultType();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic</em>'.
	 * @see org.osate.result.Diagnostic
	 * @generated
	 */
	EClass getDiagnostic();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Diagnostic#getDiagnosticType <em>Diagnostic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic Type</em>'.
	 * @see org.osate.result.Diagnostic#getDiagnosticType()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_DiagnosticType();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Diagnostic#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.result.Diagnostic#getMessage()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Message();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.Diagnostic#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.osate.result.Diagnostic#getModelElement()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EReference getDiagnostic_ModelElement();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.osate.result.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link org.osate.result.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value</em>'.
	 * @see org.osate.result.IntegerValue
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.IntegerValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.IntegerValue#getValue()
	 * @see #getIntegerValue()
	 * @generated
	 */
	EAttribute getIntegerValue_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.IntegerValue#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.osate.result.IntegerValue#getUnit()
	 * @see #getIntegerValue()
	 * @generated
	 */
	EAttribute getIntegerValue_Unit();

	/**
	 * Returns the meta object for class '{@link org.osate.result.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Value</em>'.
	 * @see org.osate.result.RealValue
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.RealValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.RealValue#getValue()
	 * @see #getRealValue()
	 * @generated
	 */
	EAttribute getRealValue_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.RealValue#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.osate.result.RealValue#getUnit()
	 * @see #getRealValue()
	 * @generated
	 */
	EAttribute getRealValue_Unit();

	/**
	 * Returns the meta object for class '{@link org.osate.result.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.osate.result.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see org.osate.result.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.BooleanValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.BooleanValue#isValue()
	 * @see #getBooleanValue()
	 * @generated
	 */
	EAttribute getBooleanValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.EObjectValue <em>EObject Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Value</em>'.
	 * @see org.osate.result.EObjectValue
	 * @generated
	 */
	EClass getEObjectValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.result.EObjectValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.osate.result.EObjectValue#getValue()
	 * @see #getEObjectValue()
	 * @generated
	 */
	EReference getEObjectValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.ObjectValue <em>Object Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Value</em>'.
	 * @see org.osate.result.ObjectValue
	 * @generated
	 */
	EClass getObjectValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.ObjectValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.ObjectValue#getValue()
	 * @see #getObjectValue()
	 * @generated
	 */
	EAttribute getObjectValue_Value();

	/**
	 * Returns the meta object for enum '{@link org.osate.result.DiagnosticType <em>Diagnostic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Diagnostic Type</em>'.
	 * @see org.osate.result.DiagnosticType
	 * @generated
	 */
	EEnum getDiagnosticType();

	/**
	 * Returns the meta object for enum '{@link org.osate.result.ResultType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.osate.result.ResultType
	 * @generated
	 */
	EEnum getResultType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResultFactory getResultFactory();

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
		 * The meta object literal for the '{@link org.osate.result.impl.AnalysisResultImpl <em>Analysis Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.AnalysisResultImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getAnalysisResult()
		 * @generated
		 */
		EClass ANALYSIS_RESULT = eINSTANCE.getAnalysisResult();

		/**
		 * The meta object literal for the '<em><b>Analysis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_RESULT__ANALYSIS = eINSTANCE.getAnalysisResult_Analysis();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_RESULT__MESSAGE = eINSTANCE.getAnalysisResult_Message();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_RESULT__MODEL_ELEMENT = eINSTANCE.getAnalysisResult_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_RESULT__PARAMETERS = eINSTANCE.getAnalysisResult_Parameters();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_RESULT__RESULTS = eINSTANCE.getAnalysisResult_Results();

		/**
		 * The meta object literal for the '<em><b>Diagnostics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_RESULT__DIAGNOSTICS = eINSTANCE.getAnalysisResult_Diagnostics();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_RESULT__RESULT_TYPE = eINSTANCE.getAnalysisResult_ResultType();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ResultImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getResult()
		 * @generated
		 */
		EClass RESULT = eINSTANCE.getResult();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__VALUES = eINSTANCE.getResult_Values();

		/**
		 * The meta object literal for the '<em><b>Diagnostics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__DIAGNOSTICS = eINSTANCE.getResult_Diagnostics();

		/**
		 * The meta object literal for the '<em><b>Sub Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__SUB_RESULTS = eINSTANCE.getResult_SubResults();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__MESSAGE = eINSTANCE.getResult_Message();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__MODEL_ELEMENT = eINSTANCE.getResult_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__RESULT_TYPE = eINSTANCE.getResult_ResultType();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.DiagnosticImpl <em>Diagnostic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.DiagnosticImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getDiagnostic()
		 * @generated
		 */
		EClass DIAGNOSTIC = eINSTANCE.getDiagnostic();

		/**
		 * The meta object literal for the '<em><b>Diagnostic Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__DIAGNOSTIC_TYPE = eINSTANCE.getDiagnostic_DiagnosticType();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__MESSAGE = eINSTANCE.getDiagnostic_Message();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC__MODEL_ELEMENT = eINSTANCE.getDiagnostic_ModelElement();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.IntegerValueImpl <em>Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.IntegerValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getIntegerValue()
		 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VALUE__UNIT = eINSTANCE.getIntegerValue_Unit();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.RealValueImpl <em>Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.RealValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getRealValue()
		 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_VALUE__VALUE = eINSTANCE.getRealValue_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_VALUE__UNIT = eINSTANCE.getRealValue_Unit();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.StringValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.BooleanValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.EObjectValueImpl <em>EObject Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.EObjectValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getEObjectValue()
		 * @generated
		 */
		EClass EOBJECT_VALUE = eINSTANCE.getEObjectValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_VALUE__VALUE = eINSTANCE.getEObjectValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.ObjectValueImpl <em>Object Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ObjectValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getObjectValue()
		 * @generated
		 */
		EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_VALUE__VALUE = eINSTANCE.getObjectValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.DiagnosticType <em>Diagnostic Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.DiagnosticType
		 * @see org.osate.result.impl.ResultPackageImpl#getDiagnosticType()
		 * @generated
		 */
		EEnum DIAGNOSTIC_TYPE = eINSTANCE.getDiagnosticType();

		/**
		 * The meta object literal for the '{@link org.osate.result.ResultType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.ResultType
		 * @see org.osate.result.impl.ResultPackageImpl#getResultType()
		 * @generated
		 */
		EEnum RESULT_TYPE = eINSTANCE.getResultType();

	}

} //ResultPackage
