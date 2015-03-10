/**
 */
package org.osate.verify.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Supported Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.verify.verify.VerifyPackage#getSupportedTypes()
 * @model
 * @generated
 */
public enum SupportedTypes implements Enumerator
{
  /**
   * The '<em><b>ANALYSIS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANALYSIS_VALUE
   * @generated
   * @ordered
   */
  ANALYSIS(0, "ANALYSIS", "analysis"),

  /**
   * The '<em><b>PREDICATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PREDICATE_VALUE
   * @generated
   * @ordered
   */
  PREDICATE(1, "PREDICATE", "predicate"),

  /**
   * The '<em><b>COMPUTE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPUTE_VALUE
   * @generated
   * @ordered
   */
  COMPUTE(2, "COMPUTE", "compute"),

  /**
   * The '<em><b>RESOLUTEPROVE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESOLUTEPROVE_VALUE
   * @generated
   * @ordered
   */
  RESOLUTEPROVE(3, "RESOLUTEPROVE", "resoluteprove"),

  /**
   * The '<em><b>RESOLUTECOMPUTE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESOLUTECOMPUTE_VALUE
   * @generated
   * @ordered
   */
  RESOLUTECOMPUTE(4, "RESOLUTECOMPUTE", "resolutecompute"),

  /**
   * The '<em><b>RESOLUTEPREDICATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESOLUTEPREDICATE_VALUE
   * @generated
   * @ordered
   */
  RESOLUTEPREDICATE(5, "RESOLUTEPREDICATE", "resolutepredicate"),

  /**
   * The '<em><b>MANUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MANUAL_VALUE
   * @generated
   * @ordered
   */
  MANUAL(6, "MANUAL", "manual");

  /**
   * The '<em><b>ANALYSIS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ANALYSIS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANALYSIS
   * @model literal="analysis"
   * @generated
   * @ordered
   */
  public static final int ANALYSIS_VALUE = 0;

  /**
   * The '<em><b>PREDICATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PREDICATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PREDICATE
   * @model literal="predicate"
   * @generated
   * @ordered
   */
  public static final int PREDICATE_VALUE = 1;

  /**
   * The '<em><b>COMPUTE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPUTE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPUTE
   * @model literal="compute"
   * @generated
   * @ordered
   */
  public static final int COMPUTE_VALUE = 2;

  /**
   * The '<em><b>RESOLUTEPROVE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESOLUTEPROVE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESOLUTEPROVE
   * @model literal="resoluteprove"
   * @generated
   * @ordered
   */
  public static final int RESOLUTEPROVE_VALUE = 3;

  /**
   * The '<em><b>RESOLUTECOMPUTE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESOLUTECOMPUTE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESOLUTECOMPUTE
   * @model literal="resolutecompute"
   * @generated
   * @ordered
   */
  public static final int RESOLUTECOMPUTE_VALUE = 4;

  /**
   * The '<em><b>RESOLUTEPREDICATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESOLUTEPREDICATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESOLUTEPREDICATE
   * @model literal="resolutepredicate"
   * @generated
   * @ordered
   */
  public static final int RESOLUTEPREDICATE_VALUE = 5;

  /**
   * The '<em><b>MANUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MANUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MANUAL
   * @model literal="manual"
   * @generated
   * @ordered
   */
  public static final int MANUAL_VALUE = 6;

  /**
   * An array of all the '<em><b>Supported Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SupportedTypes[] VALUES_ARRAY =
    new SupportedTypes[]
    {
      ANALYSIS,
      PREDICATE,
      COMPUTE,
      RESOLUTEPROVE,
      RESOLUTECOMPUTE,
      RESOLUTEPREDICATE,
      MANUAL,
    };

  /**
   * A public read-only list of all the '<em><b>Supported Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SupportedTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Supported Types</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedTypes get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SupportedTypes result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Supported Types</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedTypes getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SupportedTypes result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Supported Types</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedTypes get(int value)
  {
    switch (value)
    {
      case ANALYSIS_VALUE: return ANALYSIS;
      case PREDICATE_VALUE: return PREDICATE;
      case COMPUTE_VALUE: return COMPUTE;
      case RESOLUTEPROVE_VALUE: return RESOLUTEPROVE;
      case RESOLUTECOMPUTE_VALUE: return RESOLUTECOMPUTE;
      case RESOLUTEPREDICATE_VALUE: return RESOLUTEPREDICATE;
      case MANUAL_VALUE: return MANUAL;
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
  private SupportedTypes(int value, String name, String literal)
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
  
} //SupportedTypes
