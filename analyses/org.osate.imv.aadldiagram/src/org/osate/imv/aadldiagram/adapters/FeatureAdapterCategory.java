/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.adapters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum FeatureAdapterCategory {
	/**
	 * The '<em><b>Data Port</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_PORT_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_PORT(0, "dataPort", "dataPort"), /**
											* The '<em><b>Event Port</b></em>' literal object.
											* <!-- begin-user-doc -->
											* <!-- end-user-doc -->
											* @see #EVENT_PORT_VALUE
											* @generated
											* @ordered
											*/
	EVENT_PORT(1, "eventPort", "eventPort"), /**
												* The '<em><b>Event Data Port</b></em>' literal object.
												* <!-- begin-user-doc -->
												* <!-- end-user-doc -->
												* @see #EVENT_DATA_PORT_VALUE
												* @generated
												* @ordered
												*/
	EVENT_DATA_PORT(2, "eventDataPort", "eventDataPort"), /**
															* The '<em><b>Parameter</b></em>' literal object.
															* <!-- begin-user-doc -->
															* <!-- end-user-doc -->
															* @see #PARAMETER_VALUE
															* @generated
															* @ordered
															*/
	PARAMETER(3, "parameter", "parameter"),

	/**
	 * The '<em><b>Bus Access</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUS_ACCESS_VALUE
	 * @generated
	 * @ordered
	 */
	BUS_ACCESS(4, "busAccess", "busAccess"), /**
												* The '<em><b>Data Access</b></em>' literal object.
												* <!-- begin-user-doc -->
												* <!-- end-user-doc -->
												* @see #DATA_ACCESS_VALUE
												* @generated
												* @ordered
												*/
	DATA_ACCESS(5, "dataAccess", "dataAccess"), /**
												* The '<em><b>Subprogram Access</b></em>' literal object.
												* <!-- begin-user-doc -->
												* <!-- end-user-doc -->
												* @see #SUBPROGRAM_ACCESS_VALUE
												* @generated
												* @ordered
												*/
	SUBPROGRAM_ACCESS(6, "subprogramAccess", "subprogramAccess"), /**
																	* The '<em><b>Subprogram Group Access</b></em>' literal object.
																	* <!-- begin-user-doc -->
																	* <!-- end-user-doc -->
																	* @see #SUBPROGRAM_GROUP_ACCESS_VALUE
																	* @generated
																	* @ordered
																	*/
	SUBPROGRAM_GROUP_ACCESS(7, "subprogramGroupAccess", "subprogramGroupAccess"), /**
																					* The '<em><b>Feature Group</b></em>' literal object.
																					* <!-- begin-user-doc -->
																					* <!-- end-user-doc -->
																					* @see #FEATURE_GROUP_VALUE
																					* @generated
																					* @ordered
																					*/
	FEATURE_GROUP(8, "featureGroup", "featureGroup"), /**
														* The '<em><b>Abstract Feature</b></em>' literal object.
														* <!-- begin-user-doc -->
														* <!-- end-user-doc -->
														* @see #ABSTRACT_FEATURE_VALUE
														* @generated
														* @ordered
														*/
	ABSTRACT_FEATURE(9, "abstractFeature", "abstractFeature");

	/**
	 * The '<em><b>Data Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data Port</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_PORT
	 * @model name="dataPort"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_PORT_VALUE = 0;

	/**
	 * The '<em><b>Event Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Event Port</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVENT_PORT
	 * @model name="eventPort"
	 * @generated
	 * @ordered
	 */
	public static final int EVENT_PORT_VALUE = 1;

	/**
	 * The '<em><b>Event Data Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Event Data Port</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVENT_DATA_PORT
	 * @model name="eventDataPort"
	 * @generated
	 * @ordered
	 */
	public static final int EVENT_DATA_PORT_VALUE = 2;

	/**
	 * The '<em><b>Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETER
	 * @model name="parameter"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_VALUE = 3;

	/**
	 * The '<em><b>Bus Access</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bus Access</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUS_ACCESS
	 * @model name="busAccess"
	 * @generated
	 * @ordered
	 */
	public static final int BUS_ACCESS_VALUE = 4;

	/**
	 * The '<em><b>Data Access</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data Access</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_ACCESS
	 * @model name="dataAccess"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_ACCESS_VALUE = 5;

	/**
	 * The '<em><b>Subprogram Access</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subprogram Access</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM_ACCESS
	 * @model name="subprogramAccess"
	 * @generated
	 * @ordered
	 */
	public static final int SUBPROGRAM_ACCESS_VALUE = 6;

	/**
	 * The '<em><b>Subprogram Group Access</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Subprogram Group Access</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM_GROUP_ACCESS
	 * @model name="subprogramGroupAccess"
	 * @generated
	 * @ordered
	 */
	public static final int SUBPROGRAM_GROUP_ACCESS_VALUE = 7;

	/**
	 * The '<em><b>Feature Group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Feature Group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEATURE_GROUP
	 * @model name="featureGroup"
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_GROUP_VALUE = 8;

	/**
	 * The '<em><b>Abstract Feature</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Abstract Feature</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_FEATURE
	 * @model name="abstractFeature"
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_FEATURE_VALUE = 9;

	/**
	 * An array of all the '<em><b>Feature Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FeatureAdapterCategory[] VALUES_ARRAY = new FeatureAdapterCategory[] { DATA_PORT, EVENT_PORT,
			EVENT_DATA_PORT, PARAMETER, BUS_ACCESS, DATA_ACCESS, SUBPROGRAM_ACCESS, SUBPROGRAM_GROUP_ACCESS,
			FEATURE_GROUP, ABSTRACT_FEATURE, };

	/**
	 * A public read-only list of all the '<em><b>Feature Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FeatureAdapterCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Feature Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureAdapterCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureAdapterCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureAdapterCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureAdapterCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureAdapterCategory get(int value) {
		switch (value) {
		case DATA_PORT_VALUE:
			return DATA_PORT;
		case EVENT_PORT_VALUE:
			return EVENT_PORT;
		case EVENT_DATA_PORT_VALUE:
			return EVENT_DATA_PORT;
		case PARAMETER_VALUE:
			return PARAMETER;
		case BUS_ACCESS_VALUE:
			return BUS_ACCESS;
		case DATA_ACCESS_VALUE:
			return DATA_ACCESS;
		case SUBPROGRAM_ACCESS_VALUE:
			return SUBPROGRAM_ACCESS;
		case SUBPROGRAM_GROUP_ACCESS_VALUE:
			return SUBPROGRAM_GROUP_ACCESS;
		case FEATURE_GROUP_VALUE:
			return FEATURE_GROUP;
		case ABSTRACT_FEATURE_VALUE:
			return ABSTRACT_FEATURE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FeatureAdapterCategory(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //FeatureCategory
