/**
 */
package org.osate.results.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.results.Results;
import org.osate.results.ResultsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Results</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultsTest extends TestCase {

	/**
	 * The fixture for this Results test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Results fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResultsTest.class);
	}

	/**
	 * Constructs a new Results test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Results test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Results fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Results test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Results getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ResultsFactory.eINSTANCE.createResults());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ResultsTest
