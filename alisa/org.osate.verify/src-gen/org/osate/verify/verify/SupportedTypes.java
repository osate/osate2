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
   * The '<em><b>ASSERTIONEXCEPTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSERTIONEXCEPTION_VALUE
   * @generated
   * @ordered
   */
  ASSERTIONEXCEPTION(2, "ASSERTIONEXCEPTION", "assertionexception"),

  /**
   * The '<em><b>MULTIMARKER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIMARKER_VALUE
   * @generated
   * @ordered
   */
  MULTIMARKER(3, "MULTIMARKER", "multimarker"),

  /**
   * The '<em><b>OWNMULTIMARKER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OWNMULTIMARKER_VALUE
   * @generated
   * @ordered
   */
  OWNMULTIMARKER(4, "OWNMULTIMARKER", "ownmultimarker"),

  /**
   * The '<em><b>MULTIDIAGNOSTICS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIDIAGNOSTICS_VALUE
   * @generated
   * @ordered
   */
  MULTIDIAGNOSTICS(5, "MULTIDIAGNOSTICS", "multidiagnostics"),

  /**
   * The '<em><b>RESULTREPORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESULTREPORT_VALUE
   * @generated
   * @ordered
   */
  RESULTREPORT(6, "RESULTREPORT", "resultreport"),

  /**
   * The '<em><b>RESOLUTEPROVE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESOLUTEPROVE_VALUE
   * @generated
   * @ordered
   */
  RESOLUTEPROVE(7, "RESOLUTEPROVE", "resoluteprove"),

  /**
   * The '<em><b>MANUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MANUAL_VALUE
   * @generated
   * @ordered
   */
  MANUAL(8, "MANUAL", "manual");

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
   * The '<em><b>ASSERTIONEXCEPTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ASSERTIONEXCEPTION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSERTIONEXCEPTION
   * @model literal="assertionexception"
   * @generated
   * @ordered
   */
  public static final int ASSERTIONEXCEPTION_VALUE = 2;

  /**
   * The '<em><b>MULTIMARKER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTIMARKER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIMARKER
   * @model literal="multimarker"
   * @generated
   * @ordered
   */
  public static final int MULTIMARKER_VALUE = 3;

  /**
   * The '<em><b>OWNMULTIMARKER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OWNMULTIMARKER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OWNMULTIMARKER
   * @model literal="ownmultimarker"
   * @generated
   * @ordered
   */
  public static final int OWNMULTIMARKER_VALUE = 4;

  /**
   * The '<em><b>MULTIDIAGNOSTICS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTIDIAGNOSTICS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIDIAGNOSTICS
   * @model literal="multidiagnostics"
   * @generated
   * @ordered
   */
  public static final int MULTIDIAGNOSTICS_VALUE = 5;

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
  public static final int RESULTREPORT_VALUE = 6;

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
  public static final int RESOLUTEPROVE_VALUE = 7;

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
  public static final int MANUAL_VALUE = 8;

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
      ASSERTIONEXCEPTION,
      MULTIMARKER,
      OWNMULTIMARKER,
      MULTIDIAGNOSTICS,
      RESULTREPORT,
      RESOLUTEPROVE,
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
      case SINGLEPREDICATE_VALUE: return SINGLEPREDICATE;
      case SINGLEANALYSIS_VALUE: return SINGLEANALYSIS;
      case ASSERTIONEXCEPTION_VALUE: return ASSERTIONEXCEPTION;
      case MULTIMARKER_VALUE: return MULTIMARKER;
      case OWNMULTIMARKER_VALUE: return OWNMULTIMARKER;
      case MULTIDIAGNOSTICS_VALUE: return MULTIDIAGNOSTICS;
      case RESULTREPORT_VALUE: return RESULTREPORT;
      case RESOLUTEPROVE_VALUE: return RESOLUTEPROVE;
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
