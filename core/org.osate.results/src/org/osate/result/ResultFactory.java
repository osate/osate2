/**
 */
package org.osate.result;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.result.ResultPackage
 * @generated
 */
public interface ResultFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultFactory eINSTANCE = org.osate.result.impl.ResultFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analysis Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis Result</em>'.
	 * @generated
	 */
	AnalysisResult createAnalysisResult();

	/**
	 * Returns a new object of class '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result</em>'.
	 * @generated
	 */
	Result createResult();

	/**
	 * Returns a new object of class '<em>Diagnostic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic</em>'.
	 * @generated
	 */
	Diagnostic createDiagnostic();

	/**
	 * Returns a new object of class '<em>Integer Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Value</em>'.
	 * @generated
	 */
	IntegerValue createIntegerValue();

	/**
	 * Returns a new object of class '<em>Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Value</em>'.
	 * @generated
	 */
	RealValue createRealValue();

	/**
	 * Returns a new object of class '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value</em>'.
	 * @generated
	 */
	StringValue createStringValue();

	/**
	 * Returns a new object of class '<em>Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Value</em>'.
	 * @generated
	 */
	BooleanValue createBooleanValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResultPackage getResultPackage();

} //ResultFactory
