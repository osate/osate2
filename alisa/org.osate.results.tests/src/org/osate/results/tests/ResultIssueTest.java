/**
 */
package org.osate.results.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.results.ResultIssue;
import org.osate.results.ResultsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultIssueTest extends TestCase {

	/**
	 * The fixture for this Result Issue test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultIssue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResultIssueTest.class);
	}

	/**
	 * Constructs a new Result Issue test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultIssueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Result Issue test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ResultIssue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Result Issue test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultIssue getFixture() {
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
		setFixture(ResultsFactory.eINSTANCE.createResultIssue());
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

} //ResultIssueTest
