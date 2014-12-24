/**
 */
package org.osate.assure.assure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Verification Result State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage#getVerificationResultState()
 * @model
 * @generated
 */
public enum VerificationResultState implements Enumerator
{
  /**
   * The '<em><b>PERFORM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PERFORM_VALUE
   * @generated
   * @ordered
   */
  PERFORM(0, "PERFORM", "perform"),

  /**
   * The '<em><b>INPROGRESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INPROGRESS_VALUE
   * @generated
   * @ordered
   */
  INPROGRESS(1, "INPROGRESS", "inprogress"),

  /**
   * The '<em><b>REDO</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REDO_VALUE
   * @generated
   * @ordered
   */
  REDO(2, "REDO", "redo"),

  /**
   * The '<em><b>COMPLETED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPLETED_VALUE
   * @generated
   * @ordered
   */
  COMPLETED(3, "COMPLETED", "completed");

  /**
   * The '<em><b>PERFORM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERFORM</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PERFORM
   * @model literal="perform"
   * @generated
   * @ordered
   */
  public static final int PERFORM_VALUE = 0;

  /**
   * The '<em><b>INPROGRESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INPROGRESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INPROGRESS
   * @model literal="inprogress"
   * @generated
   * @ordered
   */
  public static final int INPROGRESS_VALUE = 1;

  /**
   * The '<em><b>REDO</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REDO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REDO
   * @model literal="redo"
   * @generated
   * @ordered
   */
  public static final int REDO_VALUE = 2;

  /**
   * The '<em><b>COMPLETED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPLETED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPLETED
   * @model literal="completed"
   * @generated
   * @ordered
   */
  public static final int COMPLETED_VALUE = 3;

  /**
   * An array of all the '<em><b>Verification Result State</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final VerificationResultState[] VALUES_ARRAY =
    new VerificationResultState[]
    {
      PERFORM,
      INPROGRESS,
      REDO,
      COMPLETED,
    };

  /**
   * A public read-only list of all the '<em><b>Verification Result State</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<VerificationResultState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Verification Result State</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VerificationResultState get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VerificationResultState result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Verification Result State</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VerificationResultState getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VerificationResultState result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Verification Result State</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VerificationResultState get(int value)
  {
    switch (value)
    {
      case PERFORM_VALUE: return PERFORM;
      case INPROGRESS_VALUE: return INPROGRESS;
      case REDO_VALUE: return REDO;
      case COMPLETED_VALUE: return COMPLETED;
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
  private VerificationResultState(int value, String name, String literal)
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
  
} //VerificationResultState
