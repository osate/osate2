/**
 */
package org.osate.alisa2.model.safe2.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.alisa2.model.safe2.Hazard;
import org.osate.alisa2.model.safe2.Safe2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HazardTest extends TestCase {

	/**
	 * The fixture for this Hazard test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Hazard fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HazardTest.class);
	}

	/**
	 * Constructs a new Hazard test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HazardTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Hazard test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Hazard fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Hazard test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Hazard getFixture() {
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
		setFixture(Safe2Factory.eINSTANCE.createHazard());
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

} //HazardTest
