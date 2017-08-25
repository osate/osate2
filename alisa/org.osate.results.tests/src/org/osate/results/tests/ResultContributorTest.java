/**
 */
package org.osate.results.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.results.ResultContributor;
import org.osate.results.ResultsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultContributorTest extends TestCase {

	/**
	 * The fixture for this Result Contributor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultContributor fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResultContributorTest.class);
	}

	/**
	 * Constructs a new Result Contributor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultContributorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Result Contributor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ResultContributor fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Result Contributor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultContributor getFixture() {
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
		setFixture(ResultsFactory.eINSTANCE.createResultContributor());
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

} //ResultContributorTest
