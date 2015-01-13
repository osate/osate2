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
   * The '<em><b>SINGLEPREDICATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SINGLEPREDICATE_VALUE
   * @generated
   * @ordered
   */
  SINGLEPREDICATE(0, "SINGLEPREDICATE", "singlepredicate"),

  /**
   * The '<em><b>SINGLEANALYSIS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SINGLEANALYSIS_VALUE
   * @generated
   * @ordered
   */
  SINGLEANALYSIS(1, "SINGLEANALYSIS", "singleanalysis"),

  /**
   * The '<em><b>MULTIPREDICATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPREDICATE_VALUE
   * @generated
   * @ordered
   */
  MULTIPREDICATE(2, "MULTIPREDICATE", "multipredicate"),

  /**
   * The '<em><b>MULTIANALYSIS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIANALYSIS_VALUE
   * @generated
   * @ordered
   */
  MULTIANALYSIS(3, "MULTIANALYSIS", "multianalysis");

  /**
   * The '<em><b>SINGLEPREDICATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SINGLEPREDICATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SINGLEPREDICATE
   * @model literal="singlepredicate"
   * @generated
   * @ordered
   */
  public static final int SINGLEPREDICATE_VALUE = 0;

  /**
   * The '<em><b>SINGLEANALYSIS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SINGLEANALYSIS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SINGLEANALYSIS
   * @model literal="singleanalysis"
   * @generated
   * @ordered
   */
  public static final int SINGLEANALYSIS_VALUE = 1;

  /**
   * The '<em><b>MULTIPREDICATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTIPREDICATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPREDICATE
   * @model literal="multipredicate"
   * @generated
   * @ordered
   */
  public static final int MULTIPREDICATE_VALUE = 2;

  /**
   * The '<em><b>MULTIANALYSIS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTIANALYSIS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIANALYSIS
   * @model literal="multianalysis"
   * @generated
   * @ordered
   */
  public static final int MULTIANALYSIS_VALUE = 3;

  /**
   * An array of all the '<em><b>Supported Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SupportedTypes[] VALUES_ARRAY =
    new SupportedTypes[]
    {
      SINGLEPREDICATE,
      SINGLEANALYSIS,
      MULTIPREDICATE,
      MULTIANALYSIS,
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
      case SINGLEPREDICATE_VALUE: return SINGLEPREDICATE;
      case SINGLEANALYSIS_VALUE: return SINGLEANALYSIS;
      case MULTIPREDICATE_VALUE: return MULTIPREDICATE;
      case MULTIANALYSIS_VALUE: return MULTIANALYSIS;
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
