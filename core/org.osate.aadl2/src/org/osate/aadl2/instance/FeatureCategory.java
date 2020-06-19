/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Feature Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.InstancePackage#getFeatureCategory()
 * @model
 * @generated
 */
public enum FeatureCategory implements Enumerator {
	/**
	 * The '<em><b>Data Port</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_PORT_VALUE
	 * @generated NOT
	 * @ordered
	 */
	DATA_PORT(0, "Data Port", "dataPort"),
	/**
	* The '<em><b>Event Port</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #EVENT_PORT_VALUE
	* @generated NOT
	* @ordered
	*/
	EVENT_PORT(1, "Event Port", "eventPort"),
	/**
	* The '<em><b>Event Data Port</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #EVENT_DATA_PORT_VALUE
	* @generated NOT
	* @ordered
	*/
	EVENT_DATA_PORT(2, "Event Data Port", "eventDataPort"),
	/**
	* The '<em><b>Parameter</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #PARAMETER_VALUE
	* @generated NOT
	* @ordered
	*/
	PARAMETER(3, "Parameter", "parameter"),

	/**
	 * The '<em><b>Bus Access</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUS_ACCESS_VALUE
	 * @generated NOT
	 * @ordered
	 */
	BUS_ACCESS(4, "Bus Access", "busAccess"),
	/**
	* The '<em><b>Data Access</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #DATA_ACCESS_VALUE
	* @generated NOT
	* @ordered
	*/
	DATA_ACCESS(5, "Data Access", "dataAccess"),
	/**
	* The '<em><b>Subprogram Access</b></em>' literal object.
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @see #SUBPROGRAM_ACCESS_VALUE
	* @generated NOT
	* @ordered
	*/
	SUBPROGRAM_ACCESS(6, "Subprogram Access", "subprogramAccess"),
	/**
	* The '<em><b>Subprogram Group Access</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #SUBPROGRAM_GROUP_ACCESS_VALUE
	* @generated NOT
	* @ordered
	*/
	SUBPROGRAM_GROUP_ACCESS(7, "Subprogram Group Access", "subprogramGroupAccess"),
	/**
	* The '<em><b>Feature Group</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #FEATURE_GROUP_VALUE
	* @generated NOT
	* @ordered
	*/
	FEATURE_GROUP(8, "Feature Group", "featureGroup"),
	/**
	* The '<em><b>Abstract Feature</b></em>' literal object.
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	* @see #ABSTRACT_FEATURE_VALUE
	* @generated NOT
	* @ordered
	*/
	ABSTRACT_FEATURE(9, "Abstract Feature", "abstractFeature");

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
	private static final FeatureCategory[] VALUES_ARRAY = new FeatureCategory[] { DATA_PORT, EVENT_PORT,
			EVENT_DATA_PORT, PARAMETER, BUS_ACCESS, DATA_ACCESS, SUBPROGRAM_ACCESS, SUBPROGRAM_GROUP_ACCESS,
			FEATURE_GROUP, ABSTRACT_FEATURE, };

	/**
	 * A public read-only list of all the '<em><b>Feature Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FeatureCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Feature Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureCategory result = VALUES_ARRAY[i];
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
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureCategory result = VALUES_ARRAY[i];
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
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FeatureCategory get(int value) {
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
	private FeatureCategory(int value, String name, String literal) {
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
	public String toString() {
		return literal;
	}

	/**
	 * @since 2.0
	 */
	public boolean isAccess() {
		return value == BUS_ACCESS_VALUE || value == DATA_ACCESS_VALUE || value == SUBPROGRAM_ACCESS_VALUE
				|| value == SUBPROGRAM_GROUP_ACCESS_VALUE;
	}

} // FeatureCategory
