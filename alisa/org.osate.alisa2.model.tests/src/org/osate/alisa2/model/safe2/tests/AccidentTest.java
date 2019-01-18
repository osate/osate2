/**
 */
package org.osate.alisa2.model.safe2.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.Safe2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Accident</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccidentTest extends TestCase {

	/**
	 * The fixture for this Accident test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Accident fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AccidentTest.class);
	}

	/**
	 * Constructs a new Accident test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccidentTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Accident test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Accident fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Accident test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Accident getFixture() {
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
		setFixture(Safe2Factory.eINSTANCE.createAccident());
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

} //AccidentTest
