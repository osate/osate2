/**
 */
package org.osate.assure.assure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Result Issue Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage#getResultIssueType()
 * @model
 * @generated
 */
public enum ResultIssueType implements Enumerator
{
  /**
   * The '<em><b>ERROR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ERROR_VALUE
   * @generated
   * @ordered
   */
  ERROR(0, "ERROR", "error"),

  /**
   * The '<em><b>WARNING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WARNING_VALUE
   * @generated
   * @ordered
   */
  WARNING(1, "WARNING", "warning"),

  /**
   * The '<em><b>SUCCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUCCESS_VALUE
   * @generated
   * @ordered
   */
  SUCCESS(2, "SUCCESS", "success"),

  /**
   * The '<em><b>INFO</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INFO_VALUE
   * @generated
   * @ordered
   */
  INFO(3, "INFO", "info");

  /**
   * The '<em><b>ERROR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ERROR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ERROR
   * @model literal="error"
   * @generated
   * @ordered
   */
  public static final int ERROR_VALUE = 0;

  /**
   * The '<em><b>WARNING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WARNING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WARNING
   * @model literal="warning"
   * @generated
   * @ordered
   */
  public static final int WARNING_VALUE = 1;

  /**
   * The '<em><b>SUCCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUCCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUCCESS
   * @model literal="success"
   * @generated
   * @ordered
   */
  public static final int SUCCESS_VALUE = 2;

  /**
   * The '<em><b>INFO</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INFO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INFO
   * @model literal="info"
   * @generated
   * @ordered
   */
  public static final int INFO_VALUE = 3;

  /**
   * An array of all the '<em><b>Result Issue Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ResultIssueType[] VALUES_ARRAY =
    new ResultIssueType[]
    {
      ERROR,
      WARNING,
      SUCCESS,
      INFO,
    };

  /**
   * A public read-only list of all the '<em><b>Result Issue Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ResultIssueType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Result Issue Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResultIssueType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ResultIssueType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Result Issue Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResultIssueType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ResultIssueType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Result Issue Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResultIssueType get(int value)
  {
    switch (value)
    {
      case ERROR_VALUE: return ERROR;
      case WARNING_VALUE: return WARNING;
      case SUCCESS_VALUE: return SUCCESS;
      case INFO_VALUE: return INFO;
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
  private ResultIssueType(int value, String name, String literal)
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
  
} //ResultIssueType
