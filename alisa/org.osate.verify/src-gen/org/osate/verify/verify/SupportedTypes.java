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
   * The '<em><b>ANALYSISPLUGIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANALYSISPLUGIN_VALUE
   * @generated
   * @ordered
   */
  ANALYSISPLUGIN(0, "ANALYSISPLUGIN", "analysisplugin"),

  /**
   * The '<em><b>RESOLUTE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESOLUTE_VALUE
   * @generated
   * @ordered
   */
  RESOLUTE(1, "RESOLUTE", "resolute"),

  /**
   * The '<em><b>JAVA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JAVA_VALUE
   * @generated
   * @ordered
   */
  JAVA(2, "JAVA", "java"),

  /**
   * The '<em><b>MANUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MANUAL_VALUE
   * @generated
   * @ordered
   */
  MANUAL(3, "MANUAL", "manual");

  /**
   * The '<em><b>ANALYSISPLUGIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ANALYSISPLUGIN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANALYSISPLUGIN
   * @model literal="analysisplugin"
   * @generated
   * @ordered
   */
  public static final int ANALYSISPLUGIN_VALUE = 0;

  /**
   * The '<em><b>RESOLUTE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESOLUTE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESOLUTE
   * @model literal="resolute"
   * @generated
   * @ordered
   */
  public static final int RESOLUTE_VALUE = 1;

  /**
   * The '<em><b>JAVA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JAVA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JAVA
   * @model literal="java"
   * @generated
   * @ordered
   */
  public static final int JAVA_VALUE = 2;

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
  public static final int MANUAL_VALUE = 3;

  /**
   * An array of all the '<em><b>Supported Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SupportedTypes[] VALUES_ARRAY =
    new SupportedTypes[]
    {
      ANALYSISPLUGIN,
      RESOLUTE,
      JAVA,
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
      case ANALYSISPLUGIN_VALUE: return ANALYSISPLUGIN;
      case RESOLUTE_VALUE: return RESOLUTE;
      case JAVA_VALUE: return JAVA;
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
