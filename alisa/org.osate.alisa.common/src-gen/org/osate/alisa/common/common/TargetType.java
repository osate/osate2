/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.alisa.common.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Target Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.alisa.common.common.CommonPackage#getTargetType()
 * @model
 * @generated
 */
public enum TargetType implements Enumerator
{
  /**
   * The '<em><b>COMPONENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_VALUE
   * @generated
   * @ordered
   */
  COMPONENT(0, "COMPONENT", "component"),

  /**
   * The '<em><b>FEATURE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_VALUE
   * @generated
   * @ordered
   */
  FEATURE(1, "FEATURE", "feature"),

  /**
   * The '<em><b>CONNECTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONNECTION_VALUE
   * @generated
   * @ordered
   */
  CONNECTION(2, "CONNECTION", "connection"),

  /**
   * The '<em><b>FLOW</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOW_VALUE
   * @generated
   * @ordered
   */
  FLOW(3, "FLOW", "flow"),

  /**
   * The '<em><b>MODE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODE_VALUE
   * @generated
   * @ordered
   */
  MODE(4, "MODE", "mode"),

  /**
   * The '<em><b>ELEMENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT_VALUE
   * @generated
   * @ordered
   */
  ELEMENT(5, "ELEMENT", "element"),

  /**
   * The '<em><b>ROOT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROOT_VALUE
   * @generated
   * @ordered
   */
  ROOT(6, "ROOT", "root");

  /**
   * The '<em><b>COMPONENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT
   * @model literal="component"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_VALUE = 0;

  /**
   * The '<em><b>FEATURE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE
   * @model literal="feature"
   * @generated
   * @ordered
   */
  public static final int FEATURE_VALUE = 1;

  /**
   * The '<em><b>CONNECTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONNECTION
   * @model literal="connection"
   * @generated
   * @ordered
   */
  public static final int CONNECTION_VALUE = 2;

  /**
   * The '<em><b>FLOW</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOW
   * @model literal="flow"
   * @generated
   * @ordered
   */
  public static final int FLOW_VALUE = 3;

  /**
   * The '<em><b>MODE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODE
   * @model literal="mode"
   * @generated
   * @ordered
   */
  public static final int MODE_VALUE = 4;

  /**
   * The '<em><b>ELEMENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ELEMENT
   * @model literal="element"
   * @generated
   * @ordered
   */
  public static final int ELEMENT_VALUE = 5;

  /**
   * The '<em><b>ROOT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROOT
   * @model literal="root"
   * @generated
   * @ordered
   */
  public static final int ROOT_VALUE = 6;

  /**
   * An array of all the '<em><b>Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final TargetType[] VALUES_ARRAY =
    new TargetType[]
    {
      COMPONENT,
      FEATURE,
      CONNECTION,
      FLOW,
      MODE,
      ELEMENT,
      ROOT,
    };

  /**
   * A public read-only list of all the '<em><b>Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<TargetType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TargetType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TargetType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TargetType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TargetType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TargetType get(int value)
  {
    switch (value)
    {
      case COMPONENT_VALUE: return COMPONENT;
      case FEATURE_VALUE: return FEATURE;
      case CONNECTION_VALUE: return CONNECTION;
      case FLOW_VALUE: return FLOW;
      case MODE_VALUE: return MODE;
      case ELEMENT_VALUE: return ELEMENT;
      case ROOT_VALUE: return ROOT;
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
  private TargetType(int value, String name, String literal)
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
  
} //TargetType
