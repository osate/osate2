/**
 */
package org.osate.alisa2.model.safe2.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.alisa2.model.safe2.ControlAction;
import org.osate.alisa2.model.safe2.Safe2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Control Action</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ControlActionTest extends TestCase {

	/**
	 * The fixture for this Control Action test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlAction fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ControlActionTest.class);
	}

	/**
	 * Constructs a new Control Action test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlActionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Control Action test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ControlAction fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Control Action test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlAction getFixture() {
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
		setFixture(Safe2Factory.eINSTANCE.createControlAction());
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

} //ControlActionTest
