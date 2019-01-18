/**
 */
package org.osate.alisa2.model.safe2.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Safe2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Accident Level</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccidentLevelTest extends TestCase {

	/**
	 * The fixture for this Accident Level test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccidentLevel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AccidentLevelTest.class);
	}

	/**
	 * Constructs a new Accident Level test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccidentLevelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Accident Level test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AccidentLevel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Accident Level test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccidentLevel getFixture() {
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
		setFixture(Safe2Factory.eINSTANCE.createAccidentLevel());
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

} //AccidentLevelTest
