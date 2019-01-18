/**
 */
package org.osate.alisa2.model.safe2.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.osate.alisa2.model.safe2.Safe2Factory;
import org.osate.alisa2.model.safe2.SystemOverview;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>System Overview</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemOverviewTest extends TestCase {

	/**
	 * The fixture for this System Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOverview fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SystemOverviewTest.class);
	}

	/**
	 * Constructs a new System Overview test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOverviewTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this System Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SystemOverview fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this System Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOverview getFixture() {
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
		setFixture(Safe2Factory.eINSTANCE.createSystemOverview());
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

} //SystemOverviewTest
