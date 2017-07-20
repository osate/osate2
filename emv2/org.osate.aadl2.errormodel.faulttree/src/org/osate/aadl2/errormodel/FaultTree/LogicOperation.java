/**
 */
package org.osate.aadl2.errormodel.FaultTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Logic Operation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getLogicOperation()
 * @model
 * @generated
 */
public enum LogicOperation implements Enumerator {
	/**
	 * The '<em><b>Noop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOOP_VALUE
	 * @generated
	 * @ordered
	 */
	NOOP(0, "Noop", "Noop"),

	/**
	 * The '<em><b>Or</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_VALUE
	 * @generated
	 * @ordered
	 */
	OR(1, "Or", "Or"),

	/**
	 * The '<em><b>And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_VALUE
	 * @generated
	 * @ordered
	 */
	AND(2, "And", "And"),

	/**
	 * The '<em><b>Xor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XOR_VALUE
	 * @generated
	 * @ordered
	 */
	XOR(3, "Xor", "Xor"),

	/**
	 * The '<em><b>Priority And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIORITY_AND_VALUE
	 * @generated
	 * @ordered
	 */
	PRIORITY_AND(4, "PriorityAnd", "PriorityAnd"),

	/**
	 * The '<em><b>KOf</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KOF_VALUE
	 * @generated
	 * @ordered
	 */
	KOF(5, "kOf", "kOf"),

	/**
	 * The '<em><b>KOrmore</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORMORE_VALUE
	 * @generated
	 * @ordered
	 */
	KORMORE(6, "kOrmore", "kOrmore"),

	/**
	 * The '<em><b>KOrless</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KORLESS_VALUE
	 * @generated
	 * @ordered
	 */
	KORLESS(7, "kOrless", "kOrless");

	/**
	 * The '<em><b>Noop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOOP
	 * @model name="Noop"
	 * @generated
	 * @ordered
	 */
	public static final int NOOP_VALUE = 0;

	/**
	 * The '<em><b>Or</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Or</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR
	 * @model name="Or"
	 * @generated
	 * @ordered
	 */
	public static final int OR_VALUE = 1;

	/**
	 * The '<em><b>And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>And</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND
	 * @model name="And"
	 * @generated
	 * @ordered
	 */
	public static final int AND_VALUE = 2;

	/**
	 * The '<em><b>Xor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Xor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XOR
	 * @model name="Xor"
	 * @generated
	 * @ordered
	 */
	public static final int XOR_VALUE = 3;

	/**
	 * The '<em><b>Priority And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Priority And</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIORITY_AND
	 * @model name="PriorityAnd"
	 * @generated
	 * @ordered
	 */
	public static final int PRIORITY_AND_VALUE = 4;

	/**
	 * The '<em><b>KOf</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KOf</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KOF
	 * @model name="kOf"
	 * @generated
	 * @ordered
	 */
	public static final int KOF_VALUE = 5;

	/**
	 * The '<em><b>KOrmore</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KOrmore</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KORMORE
	 * @model name="kOrmore"
	 * @generated
	 * @ordered
	 */
	public static final int KORMORE_VALUE = 6;

	/**
	 * The '<em><b>KOrless</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KOrless</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KORLESS
	 * @model name="kOrless"
	 * @generated
	 * @ordered
	 */
	public static final int KORLESS_VALUE = 7;

	/**
	 * An array of all the '<em><b>Logic Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LogicOperation[] VALUES_ARRAY =
		new LogicOperation[] {
			NOOP,
			OR,
			AND,
			XOR,
			PRIORITY_AND,
			KOF,
			KORMORE,
			KORLESS,
		};

	/**
	 * A public read-only list of all the '<em><b>Logic Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LogicOperation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Logic Operation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LogicOperation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LogicOperation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Logic Operation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LogicOperation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LogicOperation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Logic Operation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LogicOperation get(int value) {
		switch (value) {
			case NOOP_VALUE: return NOOP;
			case OR_VALUE: return OR;
			case AND_VALUE: return AND;
			case XOR_VALUE: return XOR;
			case PRIORITY_AND_VALUE: return PRIORITY_AND;
			case KOF_VALUE: return KOF;
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
	private LogicOperation(int value, String name, String literal) {
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
	
} //LogicOperation
