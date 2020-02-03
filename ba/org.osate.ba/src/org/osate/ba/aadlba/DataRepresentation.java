/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Representation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage#getDataRepresentation()
 * @model
 * @generated
 */
public enum DataRepresentation implements Enumerator
{
  /**
   * The '<em><b>Unknown</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNKNOWN_VALUE
   * @generated
   * @ordered
   */
  UNKNOWN(0, "Unknown", "unknown"),

  /**
   * The '<em><b>Array</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ARRAY_VALUE
   * @generated
   * @ordered
   */
  ARRAY(1, "Array", "array"),

  /**
   * The '<em><b>Boolean</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOOLEAN_VALUE
   * @generated
   * @ordered
   */
  BOOLEAN(2, "Boolean", "standard boolean"),

  /**
   * The '<em><b>Character</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHARACTER_VALUE
   * @generated
   * @ordered
   */
  CHARACTER(3, "Character", "standard character"),

  /**
   * The '<em><b>Enum</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ENUM_VALUE
   * @generated
   * @ordered
   */
  ENUM(4, "Enum", "enumeration"),

  /**
   * The '<em><b>Fixed</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FIXED_VALUE
   * @generated
   * @ordered
   */
  FIXED(5, "Fixed", "fixed point real"),

  /**
   * The '<em><b>Float</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOAT_VALUE
   * @generated
   * @ordered
   */
  FLOAT(6, "Float", "universal real"),

  /**
   * The '<em><b>Integer</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTEGER_VALUE
   * @generated
   * @ordered
   */
  INTEGER(7, "Integer", "universal integer"),

  /**
   * The '<em><b>String</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STRING_VALUE
   * @generated
   * @ordered
   */
  STRING(8, "String", "standard string"),

  /**
   * The '<em><b>Struct</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STRUCT_VALUE
   * @generated
   * @ordered
   */
  STRUCT(9, "Struct", "structure"),

  /**
   * The '<em><b>Union</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNION_VALUE
   * @generated
   * @ordered
   */
  UNION(10, "Union", "union"), /**
   * The '<em><b>ENUM LITERAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ENUM_LITERAL_VALUE
   * @generated
   * @ordered
   */
  ENUM_LITERAL(11, "ENUM_LITERAL", "enumeration literal");

  /**
   * The '<em><b>Unknown</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNKNOWN
   * @model name="Unknown" literal="unknown"
   * @generated
   * @ordered
   */
  public static final int UNKNOWN_VALUE = 0;

  /**
   * The '<em><b>Array</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Array</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ARRAY
   * @model name="Array" literal="array"
   * @generated
   * @ordered
   */
  public static final int ARRAY_VALUE = 1;

  /**
   * The '<em><b>Boolean</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOOLEAN
   * @model name="Boolean" literal="standard boolean"
   * @generated
   * @ordered
   */
  public static final int BOOLEAN_VALUE = 2;

  /**
   * The '<em><b>Character</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Character</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CHARACTER
   * @model name="Character" literal="standard character"
   * @generated
   * @ordered
   */
  public static final int CHARACTER_VALUE = 3;

  /**
   * The '<em><b>Enum</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Enum</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ENUM
   * @model name="Enum" literal="enumeration"
   * @generated
   * @ordered
   */
  public static final int ENUM_VALUE = 4;

  /**
   * The '<em><b>Fixed</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Fixed</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FIXED
   * @model name="Fixed" literal="fixed point real"
   * @generated
   * @ordered
   */
  public static final int FIXED_VALUE = 5;

  /**
   * The '<em><b>Float</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Float</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FLOAT
   * @model name="Float" literal="universal real"
   * @generated
   * @ordered
   */
  public static final int FLOAT_VALUE = 6;

  /**
   * The '<em><b>Integer</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Integer</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTEGER
   * @model name="Integer" literal="universal integer"
   * @generated
   * @ordered
   */
  public static final int INTEGER_VALUE = 7;

  /**
   * The '<em><b>String</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STRING
   * @model name="String" literal="standard string"
   * @generated
   * @ordered
   */
  public static final int STRING_VALUE = 8;

  /**
   * The '<em><b>Struct</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Struct</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STRUCT
   * @model name="Struct" literal="structure"
   * @generated
   * @ordered
   */
  public static final int STRUCT_VALUE = 9;

  /**
   * The '<em><b>Union</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Union</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNION
   * @model name="Union" literal="union"
   * @generated
   * @ordered
   */
  public static final int UNION_VALUE = 10;

  /**
   * The '<em><b>ENUM LITERAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ENUM LITERAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ENUM_LITERAL
   * @model literal="enumeration literal"
   * @generated
   * @ordered
   */
  public static final int ENUM_LITERAL_VALUE = 11;

  /**
   * An array of all the '<em><b>Data Representation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final DataRepresentation[] VALUES_ARRAY =
    new DataRepresentation[]
    {
      UNKNOWN,
      ARRAY,
      BOOLEAN,
      CHARACTER,
      ENUM,
      FIXED,
      FLOAT,
      INTEGER,
      STRING,
      STRUCT,
      UNION,
      ENUM_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>Data Representation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<DataRepresentation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Data Representation</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static DataRepresentation get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      DataRepresentation result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Data Representation</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static DataRepresentation getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      DataRepresentation result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Data Representation</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static DataRepresentation get(int value)
  {
    switch (value)
    {
      case UNKNOWN_VALUE: return UNKNOWN;
      case ARRAY_VALUE: return ARRAY;
      case BOOLEAN_VALUE: return BOOLEAN;
      case CHARACTER_VALUE: return CHARACTER;
      case ENUM_VALUE: return ENUM;
      case FIXED_VALUE: return FIXED;
      case FLOAT_VALUE: return FLOAT;
      case INTEGER_VALUE: return INTEGER;
      case STRING_VALUE: return STRING;
      case STRUCT_VALUE: return STRUCT;
      case UNION_VALUE: return UNION;
      case ENUM_LITERAL_VALUE: return ENUM_LITERAL;
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
  private DataRepresentation(int value, String name, String literal)
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
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  
} //DataRepresentation
