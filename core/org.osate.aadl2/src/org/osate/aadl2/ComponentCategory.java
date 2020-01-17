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
package org.osate.aadl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Component Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Components.</p>
 * <!-- end-model-doc -->
 * @see org.osate.aadl2.Aadl2Package#getComponentCategory()
 * @model
 * @generated
 */
public enum ComponentCategory implements Enumerator {
	/**
	 * The '<em><b>Abstract</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	ABSTRACT(0, "abstract", "abstract"),

	/**
	 * The '<em><b>Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUS_VALUE
	 * @generated
	 * @ordered
	 */
	BUS(1, "bus", "bus"),

	/**
	 * The '<em><b>Data</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_VALUE
	 * @generated
	 * @ordered
	 */
	DATA(2, "data", "data"),

	/**
	 * The '<em><b>Device</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEVICE_VALUE
	 * @generated
	 * @ordered
	 */
	DEVICE(3, "device", "device"),

	/**
	 * The '<em><b>Memory</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY(4, "memory", "memory"),

	/**
	 * The '<em><b>Process</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESS_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESS(5, "process", "process"),

	/**
	 * The '<em><b>Processor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	PROCESSOR(6, "processor", "processor"),

	/**
	 * The '<em><b>Subprogram</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	SUBPROGRAM(7, "subprogram", "subprogram"),

	/**
	 * The '<em><b>Subprogram Group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM_GROUP_VALUE
	 * @generated NOT
	 * @ordered
	 */
	SUBPROGRAM_GROUP(8, "subprogram group", "subprogram group"),

	/**
	 * The '<em><b>System</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM(9, "system", "system"),

	/**
	 * The '<em><b>Thread</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREAD_VALUE
	 * @generated
	 * @ordered
	 */
	THREAD(10, "thread", "thread"),

	/**
	 * The '<em><b>Thread Group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREAD_GROUP_VALUE
	 * @generated NOT
	 * @ordered
	 */
	THREAD_GROUP(11, "thread group", "thread group"),

	/**
	 * The '<em><b>Virtual Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL_BUS_VALUE
	 * @generated NOT
	 * @ordered
	 */
	VIRTUAL_BUS(12, "virtual bus", "virtual bus"),

	/**
	 * The '<em><b>Virtual Processor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL_PROCESSOR_VALUE
	 * @generated NOT
	 * @ordered
	 */
	VIRTUAL_PROCESSOR(13, "virtual processor", "virtual processor");

	/**
	 * The '<em><b>Abstract</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSTRACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT
	 * @model name="abstract"
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_VALUE = 0;

	/**
	 * The '<em><b>Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUS
	 * @model name="bus"
	 * @generated
	 * @ordered
	 */
	public static final int BUS_VALUE = 1;

	/**
	 * The '<em><b>Data</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA
	 * @model name="data"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_VALUE = 2;

	/**
	 * The '<em><b>Device</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEVICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEVICE
	 * @model name="device"
	 * @generated
	 * @ordered
	 */
	public static final int DEVICE_VALUE = 3;

	/**
	 * The '<em><b>Memory</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEMORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY
	 * @model name="memory"
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_VALUE = 4;

	/**
	 * The '<em><b>Process</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROCESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESS
	 * @model name="process"
	 * @generated
	 * @ordered
	 */
	public static final int PROCESS_VALUE = 5;

	/**
	 * The '<em><b>Processor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCESSOR
	 * @model name="processor"
	 * @generated
	 * @ordered
	 */
	public static final int PROCESSOR_VALUE = 6;

	/**
	 * The '<em><b>Subprogram</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBPROGRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM
	 * @model name="subprogram"
	 * @generated
	 * @ordered
	 */
	public static final int SUBPROGRAM_VALUE = 7;

	/**
	 * The '<em><b>Subprogram Group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBPROGRAM GROUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUBPROGRAM_GROUP
	 * @model name="subprogramGroup"
	 * @generated
	 * @ordered
	 */
	public static final int SUBPROGRAM_GROUP_VALUE = 8;

	/**
	 * The '<em><b>System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYSTEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM
	 * @model name="system"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_VALUE = 9;

	/**
	 * The '<em><b>Thread</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREAD
	 * @model name="thread"
	 * @generated
	 * @ordered
	 */
	public static final int THREAD_VALUE = 10;

	/**
	 * The '<em><b>Thread Group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREAD GROUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREAD_GROUP
	 * @model name="threadGroup"
	 * @generated
	 * @ordered
	 */
	public static final int THREAD_GROUP_VALUE = 11;

	/**
	 * The '<em><b>Virtual Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VIRTUAL BUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL_BUS
	 * @model name="virtualBus"
	 * @generated
	 * @ordered
	 */
	public static final int VIRTUAL_BUS_VALUE = 12;

	/**
	 * The '<em><b>Virtual Processor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VIRTUAL PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VIRTUAL_PROCESSOR
	 * @model name="virtualProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int VIRTUAL_PROCESSOR_VALUE = 13;

	/**
	 * An array of all the '<em><b>Component Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ComponentCategory[] VALUES_ARRAY = new ComponentCategory[] { ABSTRACT, BUS, DATA, DEVICE,
			MEMORY, PROCESS, PROCESSOR, SUBPROGRAM, SUBPROGRAM_GROUP, SYSTEM, THREAD, THREAD_GROUP, VIRTUAL_BUS,
			VIRTUAL_PROCESSOR, };

	/**
	 * A public read-only list of all the '<em><b>Component Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ComponentCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Component Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComponentCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComponentCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Component Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComponentCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComponentCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Component Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComponentCategory get(int value) {
		switch (value) {
		case ABSTRACT_VALUE:
			return ABSTRACT;
		case BUS_VALUE:
			return BUS;
		case DATA_VALUE:
			return DATA;
		case DEVICE_VALUE:
			return DEVICE;
		case MEMORY_VALUE:
			return MEMORY;
		case PROCESS_VALUE:
			return PROCESS;
		case PROCESSOR_VALUE:
			return PROCESSOR;
		case SUBPROGRAM_VALUE:
			return SUBPROGRAM;
		case SUBPROGRAM_GROUP_VALUE:
			return SUBPROGRAM_GROUP;
		case SYSTEM_VALUE:
			return SYSTEM;
		case THREAD_VALUE:
			return THREAD;
		case THREAD_GROUP_VALUE:
			return THREAD_GROUP;
		case VIRTUAL_BUS_VALUE:
			return VIRTUAL_BUS;
		case VIRTUAL_PROCESSOR_VALUE:
			return VIRTUAL_PROCESSOR;
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
	private ComponentCategory(int value, String name, String literal) {
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

} // ComponentCategory
