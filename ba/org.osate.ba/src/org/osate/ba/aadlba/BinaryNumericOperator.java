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
 * A representation of the literals of the enumeration '<em><b>Binary Numeric Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage#getBinaryNumericOperator()
 * @model
 * @generated
 */
public enum BinaryNumericOperator implements Enumerator
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
   * The '<em><b>Multiply Multiply</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLY_MULTIPLY_VALUE
   * @generated
   * @ordered
   */
  MULTIPLY_MULTIPLY(1, "MultiplyMultiply", "**");

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
   * The '<em><b>Multiply Multiply</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Multiply Multiply</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLY_MULTIPLY
   * @model name="MultiplyMultiply" literal="**"
   * @generated
   * @ordered
   */
  public static final int MULTIPLY_MULTIPLY_VALUE = 1;

  /**
   * An array of all the '<em><b>Binary Numeric Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final BinaryNumericOperator[] VALUES_ARRAY =
    new BinaryNumericOperator[]
    {
      NONE,
      MULTIPLY_MULTIPLY,
    };

  /**
   * A public read-only list of all the '<em><b>Binary Numeric Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<BinaryNumericOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Binary Numeric Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BinaryNumericOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BinaryNumericOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Binary Numeric Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BinaryNumericOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BinaryNumericOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Binary Numeric Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BinaryNumericOperator get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case MULTIPLY_MULTIPLY_VALUE: return MULTIPLY_MULTIPLY;
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
  private BinaryNumericOperator(int value, String name, String literal)
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
  
} //BinaryNumericOperator
