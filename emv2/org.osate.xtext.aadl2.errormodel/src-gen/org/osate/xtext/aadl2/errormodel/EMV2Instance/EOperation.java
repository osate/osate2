/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EOperation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEOperation()
 * @model
 * @generated
 */
public enum EOperation implements Enumerator {
	/**
	 * The '<em><b>ANY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_VALUE
	 * @generated
	 * @ordered
	 */
	ANY(0, "ANY", "any"),

	/**
	 * The '<em><b>ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(1, "ALL", "all"),

	/**
	 * The '<em><b>ONEOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONEOF_VALUE
	 * @generated
	 * @ordered
	 */
	ONEOF(2, "ONEOF", "oneof"),

	/**
	 * The '<em><b>KOFN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KOFN_VALUE
	 * @generated
	 * @ordered
	 */
	KOFN(3, "KOFN", "kofn"),

	/**
	 * The '<em><b>KORMORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORMORE_VALUE
	 * @generated
	 * @ordered
	 */
	KORMORE(4, "KORMORE", "kormore"),

	/**
	 * The '<em><b>KORLESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORLESS_VALUE
	 * @generated
	 * @ordered
	 */
	KORLESS(5, "KORLESS", "korless");

	/**
	 * The '<em><b>ANY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY
	 * @model literal="any"
	 * @generated
	 * @ordered
	 */
	public static final int ANY_VALUE = 0;

	/**
	 * The '<em><b>ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model literal="all"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 1;

	/**
	 * The '<em><b>ONEOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONEOF
	 * @model literal="oneof"
	 * @generated
	 * @ordered
	 */
	public static final int ONEOF_VALUE = 2;

	/**
	 * The '<em><b>KOFN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KOFN
	 * @model literal="kofn"
	 * @generated
	 * @ordered
	 */
	public static final int KOFN_VALUE = 3;

	/**
	 * The '<em><b>KORMORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORMORE
	 * @model literal="kormore"
	 * @generated
	 * @ordered
	 */
	public static final int KORMORE_VALUE = 4;

	/**
	 * The '<em><b>KORLESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORLESS
	 * @model literal="korless"
	 * @generated
	 * @ordered
	 */
	public static final int KORLESS_VALUE = 5;

	/**
	 * An array of all the '<em><b>EOperation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EOperation[] VALUES_ARRAY =
		new EOperation[] {
			ANY,
			ALL,
			ONEOF,
			KOFN,
			KORMORE,
			KORLESS,
		};

	/**
	 * A public read-only list of all the '<em><b>EOperation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EOperation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EOperation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EOperation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOperation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EOperation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOperation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperation get(int value) {
		switch (value) {
			case ANY_VALUE: return ANY;
			case ALL_VALUE: return ALL;
			case ONEOF_VALUE: return ONEOF;
			case KOFN_VALUE: return KOFN;
			case KORMORE_VALUE: return KORMORE;
			case KORLESS_VALUE: return KORLESS;
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
	private EOperation(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	
} //EOperation
