/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Comm Action Parameter</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommActionParameter()
 * @model
 * @generated
 */
public enum CommActionParameter implements Enumerator
{
   /**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
   NONE(0, "None", "None"),

   /**
	 * The '<em><b>Exclamation</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION_VALUE
	 * @generated
	 * @ordered
	 */
   EXCLAMATION(1, "Exclamation", "Exclamation"),

   /**
	 * The '<em><b>Left Left</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #LEFT_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
   LEFT_LEFT(2, "LeftLeft", "LeftLeft"),

   /**
	 * The '<em><b>Interrogation</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #INTERROGATION_VALUE
	 * @generated
	 * @ordered
	 */
   INTERROGATION(3, "Interrogation", "Interrogation"),

   /**
	 * The '<em><b>Exclamation Left</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
   EXCLAMATION_LEFT(4, "ExclamationLeft", "ExclamationLeft"),

   /**
	 * The '<em><b>Exclamation Right</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
   EXCLAMATION_RIGHT(5, "ExclamationRight", "ExclamationRight");

   /**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
   public static final int NONE_VALUE = 0;

   /**
	 * The '<em><b>Exclamation</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Exclamation</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION
	 * @model name="Exclamation"
	 * @generated
	 * @ordered
	 */
   public static final int EXCLAMATION_VALUE = 1;

   /**
	 * The '<em><b>Left Left</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Left Left</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #LEFT_LEFT
	 * @model name="LeftLeft"
	 * @generated
	 * @ordered
	 */
   public static final int LEFT_LEFT_VALUE = 2;

   /**
	 * The '<em><b>Interrogation</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Interrogation</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #INTERROGATION
	 * @model name="Interrogation"
	 * @generated
	 * @ordered
	 */
   public static final int INTERROGATION_VALUE = 3;

   /**
	 * The '<em><b>Exclamation Left</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Exclamation Left</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION_LEFT
	 * @model name="ExclamationLeft"
	 * @generated
	 * @ordered
	 */
   public static final int EXCLAMATION_LEFT_VALUE = 4;

   /**
	 * The '<em><b>Exclamation Right</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Exclamation Right</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #EXCLAMATION_RIGHT
	 * @model name="ExclamationRight"
	 * @generated
	 * @ordered
	 */
   public static final int EXCLAMATION_RIGHT_VALUE = 5;

   /**
	 * An array of all the '<em><b>Comm Action Parameter</b></em>' enumerators.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private static final CommActionParameter[] VALUES_ARRAY =
      new CommActionParameter[] {
			NONE,
			EXCLAMATION,
			LEFT_LEFT,
			INTERROGATION,
			EXCLAMATION_LEFT,
			EXCLAMATION_RIGHT,
		};

   /**
	 * A public read-only list of all the '<em><b>Comm Action Parameter</b></em>' enumerators.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static final List<CommActionParameter> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
	 * Returns the '<em><b>Comm Action Parameter</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static CommActionParameter get(String literal)
   {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommActionParameter result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

   /**
	 * Returns the '<em><b>Comm Action Parameter</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static CommActionParameter getByName(String name)
   {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommActionParameter result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

   /**
	 * Returns the '<em><b>Comm Action Parameter</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static CommActionParameter get(int value)
   {
		switch (value) {
			case NONE_VALUE: return NONE;
			case EXCLAMATION_VALUE: return EXCLAMATION;
			case LEFT_LEFT_VALUE: return LEFT_LEFT;
			case INTERROGATION_VALUE: return INTERROGATION;
			case EXCLAMATION_LEFT_VALUE: return EXCLAMATION_LEFT;
			case EXCLAMATION_RIGHT_VALUE: return EXCLAMATION_RIGHT;
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
   private CommActionParameter(int value, String name, String literal)
   {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public int getValue()
   {
	  return value;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String getName()
   {
	  return name;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String getLiteral()
   {
	  return literal;
	}

   /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String toString()
   {
		return literal;
	}
   
} //CommActionParameter
