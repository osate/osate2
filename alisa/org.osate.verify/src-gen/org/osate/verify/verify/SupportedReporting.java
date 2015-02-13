/**
 */
package org.osate.verify.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Supported Reporting</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.verify.verify.VerifyPackage#getSupportedReporting()
 * @model
 * @generated
 */
public enum SupportedReporting implements Enumerator
{
  /**
   * The '<em><b>MARKER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MARKER_VALUE
   * @generated
   * @ordered
   */
  MARKER(0, "MARKER", "marker"),

  /**
   * The '<em><b>ERRORMARKER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ERRORMARKER_VALUE
   * @generated
   * @ordered
   */
  ERRORMARKER(1, "ERRORMARKER", "errormarker"),

  /**
   * The '<em><b>DIAGNOSTICS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIAGNOSTICS_VALUE
   * @generated
   * @ordered
   */
  DIAGNOSTICS(2, "DIAGNOSTICS", "diagnostics"),

  /**
   * The '<em><b>ASSERTEXCEPTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSERTEXCEPTION_VALUE
   * @generated
   * @ordered
   */
  ASSERTEXCEPTION(3, "ASSERTEXCEPTION", "assertexception"),

  /**
   * The '<em><b>RESULTREPORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESULTREPORT_VALUE
   * @generated
   * @ordered
   */
  RESULTREPORT(4, "RESULTREPORT", "resultreport");

  /**
   * The '<em><b>MARKER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MARKER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MARKER
   * @model literal="marker"
   * @generated
   * @ordered
   */
  public static final int MARKER_VALUE = 0;

  /**
   * The '<em><b>ERRORMARKER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ERRORMARKER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ERRORMARKER
   * @model literal="errormarker"
   * @generated
   * @ordered
   */
  public static final int ERRORMARKER_VALUE = 1;

  /**
   * The '<em><b>DIAGNOSTICS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DIAGNOSTICS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIAGNOSTICS
   * @model literal="diagnostics"
   * @generated
   * @ordered
   */
  public static final int DIAGNOSTICS_VALUE = 2;

  /**
   * The '<em><b>ASSERTEXCEPTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ASSERTEXCEPTION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSERTEXCEPTION
   * @model literal="assertexception"
   * @generated
   * @ordered
   */
  public static final int ASSERTEXCEPTION_VALUE = 3;

  /**
   * The '<em><b>RESULTREPORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESULTREPORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESULTREPORT
   * @model literal="resultreport"
   * @generated
   * @ordered
   */
  public static final int RESULTREPORT_VALUE = 4;

  /**
   * An array of all the '<em><b>Supported Reporting</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SupportedReporting[] VALUES_ARRAY =
    new SupportedReporting[]
    {
      MARKER,
      ERRORMARKER,
      DIAGNOSTICS,
      ASSERTEXCEPTION,
      RESULTREPORT,
    };

  /**
   * A public read-only list of all the '<em><b>Supported Reporting</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SupportedReporting> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Supported Reporting</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedReporting get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SupportedReporting result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Supported Reporting</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedReporting getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SupportedReporting result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Supported Reporting</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SupportedReporting get(int value)
  {
    switch (value)
    {
      case MARKER_VALUE: return MARKER;
      case ERRORMARKER_VALUE: return ERRORMARKER;
      case DIAGNOSTICS_VALUE: return DIAGNOSTICS;
      case ASSERTEXCEPTION_VALUE: return ASSERTEXCEPTION;
      case RESULTREPORT_VALUE: return RESULTREPORT;
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
  private SupportedReporting(int value, String name, String literal)
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
  
} //SupportedReporting
