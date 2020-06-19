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
 * A representation of the literals of the enumeration '<em><b>Logical Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage#getLogicalOperator()
 * @model
 * @generated
 */
public enum LogicalOperator implements Enumerator
{
  /**
   * The '<em><b>None</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(0, "None", ""),

  /**
   * The '<em><b>And</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AND_VALUE
   * @generated
   * @ordered
   */
  AND(1, "And", "and"),

  /**
   * The '<em><b>Or</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OR_VALUE
   * @generated
   * @ordered
   */
  OR(2, "Or", "or"),

  /**
   * The '<em><b>Xor</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XOR_VALUE
   * @generated
   * @ordered
   */
  XOR(3, "Xor", "xor");

  /**
   * The '<em><b>None</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model name="None" literal=""
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 0;

  /**
   * The '<em><b>And</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>And</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AND
   * @model name="And" literal="and"
   * @generated
   * @ordered
   */
  public static final int AND_VALUE = 1;

  /**
   * The '<em><b>Or</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Or</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OR
   * @model name="Or" literal="or"
   * @generated
   * @ordered
   */
  public static final int OR_VALUE = 2;

  /**
   * The '<em><b>Xor</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Xor</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XOR
   * @model name="Xor" literal="xor"
   * @generated
   * @ordered
   */
  public static final int XOR_VALUE = 3;

  /**
   * An array of all the '<em><b>Logical Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final LogicalOperator[] VALUES_ARRAY =
    new LogicalOperator[]
    {
      NONE,
      AND,
      OR,
      XOR,
    };

  /**
   * A public read-only list of all the '<em><b>Logical Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<LogicalOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Logical Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LogicalOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LogicalOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Logical Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LogicalOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LogicalOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Logical Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LogicalOperator get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case AND_VALUE: return AND;
      case OR_VALUE: return OR;
      case XOR_VALUE: return XOR;
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
  private LogicalOperator(int value, String name, String literal)
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
  
} //LogicalOperator
