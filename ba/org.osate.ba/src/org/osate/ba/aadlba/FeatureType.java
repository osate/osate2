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
 * A representation of the literals of the enumeration '<em><b>Feature Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage#getFeatureType()
 * @model
 * @generated
 */
public enum FeatureType implements Enumerator
{
  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(0, "NONE", "unknown aadl classifier"),

  /**
   * The '<em><b>IN DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_DATA_PORT(1, "IN_DATA_PORT", "in data port"),

  /**
   * The '<em><b>OUT DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  OUT_DATA_PORT(2, "OUT_DATA_PORT", "out data port"),

  /**
   * The '<em><b>IN OUT DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_DATA_PORT(3, "IN_OUT_DATA_PORT", "inout data port"),

  /**
   * The '<em><b>IN EVENT PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_EVENT_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_EVENT_PORT(4, "IN_EVENT_PORT", "in event port"),

  /**
   * The '<em><b>OUT EVENT PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_PORT_VALUE
   * @generated
   * @ordered
   */
  OUT_EVENT_PORT(5, "OUT_EVENT_PORT", "out event port"),

  /**
   * The '<em><b>IN OUT EVENT PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_EVENT_PORT(6, "IN_OUT_EVENT_PORT", "inout event port"),

  /**
   * The '<em><b>IN EVENT DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_EVENT_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_EVENT_DATA_PORT(7, "IN_EVENT_DATA_PORT", "in event data port"),

  /**
   * The '<em><b>OUT EVENT DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  OUT_EVENT_DATA_PORT(8, "OUT_EVENT_DATA_PORT", "out event data port"),

  /**
   * The '<em><b>IN OUT EVENT DATA PORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_DATA_PORT_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_EVENT_DATA_PORT(9, "IN_OUT_EVENT_DATA_PORT", "inout event data port"),

  /**
   * The '<em><b>PROVIDES SUBPROGRAM ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_ACCESS_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_SUBPROGRAM_ACCESS(10, "PROVIDES_SUBPROGRAM_ACCESS", "provides subprogram access"),

  /**
   * The '<em><b>REQUIRES SUBPROGRAM ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_ACCESS_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_SUBPROGRAM_ACCESS(11, "REQUIRES_SUBPROGRAM_ACCESS", "requires subprogram access"),

  /**
   * The '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_GROUP_ACCESS_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_SUBPROGRAM_GROUP_ACCESS(12, "PROVIDES_SUBPROGRAM_GROUP_ACCESS", "provides subprogram group access"),

  /**
   * The '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_GROUP_ACCESS_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_SUBPROGRAM_GROUP_ACCESS(13, "REQUIRES_SUBPROGRAM_GROUP_ACCESS", "requires subprogram group access"),

  /**
   * The '<em><b>SUBPROGRAM SUBCOMPONENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_SUBCOMPONENT_VALUE
   * @generated
   * @ordered
   */
  SUBPROGRAM_SUBCOMPONENT(14, "SUBPROGRAM_SUBCOMPONENT", "subprogram subcomponent"),

  /**
   * The '<em><b>SUBPROGRAM CLASSIFIER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_CLASSIFIER_VALUE
   * @generated
   * @ordered
   */
  SUBPROGRAM_CLASSIFIER(15, "SUBPROGRAM_CLASSIFIER", "subprogram classifier"),

  /**
   * The '<em><b>SUBPROGRAM PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  SUBPROGRAM_PROTOTYPE(16, "SUBPROGRAM_PROTOTYPE", "subprogram prototype"),

  /**
   * The '<em><b>COMPONENT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  COMPONENT_PROTOTYPE(17, "COMPONENT_PROTOTYPE", "component prototype"),

  /**
   * The '<em><b>COMPONENT PROTOTYPE BINDING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROTOTYPE_BINDING_VALUE
   * @generated
   * @ordered
   */
  COMPONENT_PROTOTYPE_BINDING(18, "COMPONENT_PROTOTYPE_BINDING", "component prototype binding"),

  /**
   * The '<em><b>FEATURE PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  FEATURE_PROTOTYPE(19, "FEATURE_PROTOTYPE", "feature prototype"),

  /**
   * The '<em><b>FEATURE PROTOTYPE BINDING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_PROTOTYPE_BINDING_VALUE
   * @generated
   * @ordered
   */
  FEATURE_PROTOTYPE_BINDING(20, "FEATURE_PROTOTYPE_BINDING", "feature prototype binding"),

  /**
   * The '<em><b>FEATURE GROUP PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  FEATURE_GROUP_PROTOTYPE(21, "FEATURE_GROUP_PROTOTYPE", "feature group prototytpe"),

  /**
   * The '<em><b>FEATURE GROUP PROTOTYPE BINDING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP_PROTOTYPE_BINDING_VALUE
   * @generated
   * @ordered
   */
  FEATURE_GROUP_PROTOTYPE_BINDING(22, "FEATURE_GROUP_PROTOTYPE_BINDING", "feature group prototype binding"),

  /**
   * The '<em><b>PROVIDES DATA ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_DATA_ACCESS_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_DATA_ACCESS(23, "PROVIDES_DATA_ACCESS", "provides data access"),

  /**
   * The '<em><b>REQUIRES DATA ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_DATA_ACCESS_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_DATA_ACCESS(24, "REQUIRES_DATA_ACCESS", "requires data access"),

  /**
   * The '<em><b>DATA SUBCOMPONENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATA_SUBCOMPONENT_VALUE
   * @generated
   * @ordered
   */
  DATA_SUBCOMPONENT(25, "DATA_SUBCOMPONENT", "data subcomponent"),

  /**
   * The '<em><b>DATA CLASSIFIER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATA_CLASSIFIER_VALUE
   * @generated
   * @ordered
   */
  DATA_CLASSIFIER(26, "DATA_CLASSIFIER", "data classifier"),

  /**
   * The '<em><b>IN PARAMETER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_PARAMETER_VALUE
   * @generated
   * @ordered
   */
  IN_PARAMETER(27, "IN_PARAMETER", "in parameter"),

  /**
   * The '<em><b>OUT PARAMETER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_PARAMETER_VALUE
   * @generated
   * @ordered
   */
  OUT_PARAMETER(28, "OUT_PARAMETER", "out parameter"),

  /**
   * The '<em><b>IN OUT PARAMETER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_PARAMETER_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_PARAMETER(29, "IN_OUT_PARAMETER", "in out parameter"),

  /**
   * The '<em><b>PROPERTY CONSTANT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROPERTY_CONSTANT_VALUE
   * @generated
   * @ordered
   */
  PROPERTY_CONSTANT(30, "PROPERTY_CONSTANT", "property constant"),

  /**
   * The '<em><b>PROPERTY VALUE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROPERTY_VALUE_VALUE
   * @generated
   * @ordered
   */
  PROPERTY_VALUE(31, "PROPERTY_VALUE", "property value"),

  /**
   * The '<em><b>PROVIDES BUS ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_BUS_ACCESS_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_BUS_ACCESS(32, "PROVIDES_BUS_ACCESS", "provides bus access"),

  /**
   * The '<em><b>REQUIRES BUS ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_BUS_ACCESS_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_BUS_ACCESS(33, "REQUIRES_BUS_ACCESS", "requires bus access"),

  /**
   * The '<em><b>FEATURE GROUP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP_VALUE
   * @generated
   * @ordered
   */
  FEATURE_GROUP(34, "FEATURE_GROUP", "feature group"),

  /**
   * The '<em><b>CLASSIFIER VALUE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLASSIFIER_VALUE_VALUE
   * @generated
   * @ordered
   */
  CLASSIFIER_VALUE(35, "CLASSIFIER_VALUE", "classifier value"),

  /**
   * The '<em><b>ABSTRACT FEATURE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACT_FEATURE_VALUE
   * @generated
   * @ordered
   */
  ABSTRACT_FEATURE(36, "ABSTRACT_FEATURE", "abstract feature"),

  /**
   * The '<em><b>IN FEATURE PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_FEATURE_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_FEATURE_PROTOTYPE(37, "IN_FEATURE_PROTOTYPE", "in feature prototype"),

  /**
   * The '<em><b>OUT FEATURE PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_FEATURE_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  OUT_FEATURE_PROTOTYPE(38, "OUT_FEATURE_PROTOTYPE", "out feature prototype"),

  /**
   * The '<em><b>IN OUT FEATURE PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_FEATURE_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_FEATURE_PROTOTYPE(39, "IN_OUT_FEATURE_PROTOTYPE", "in out feature prototype"),

  /**
   * The '<em><b>THREAD GROUP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #THREAD_GROUP_VALUE
   * @generated
   * @ordered
   */
  THREAD_GROUP(40, "THREAD_GROUP", "thread group"),

  /**
   * The '<em><b>SUBPROGRAM GROUP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_GROUP_VALUE
   * @generated
   * @ordered
   */
  SUBPROGRAM_GROUP(41, "SUBPROGRAM_GROUP", "subprogram group"),

  /**
   * The '<em><b>SUBPROGRAM GROUP PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_GROUP_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  SUBPROGRAM_GROUP_PROTOTYPE(42, "SUBPROGRAM_GROUP_PROTOTYPE", "subprogram group prototype"),

  /**
   * The '<em><b>THREAD PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #THREAD_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  THREAD_PROTOTYPE(43, "THREAD_PROTOTYPE", "thread prototype"),

  /**
   * The '<em><b>THREAD GROUP PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #THREAD_GROUP_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  THREAD_GROUP_PROTOTYPE(44, "THREAD_GROUP_PROTOTYPE", "thread group prototype"),

  /**
   * The '<em><b>IN DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_DATA_PORT_PROTOTYPE(45, "IN_DATA_PORT_PROTOTYPE", "in data port prototype"),

  /**
   * The '<em><b>OUT DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  OUT_DATA_PORT_PROTOTYPE(46, "OUT_DATA_PORT_PROTOTYPE", "out data port prototype"),

  /**
   * The '<em><b>IN OUT DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_DATA_PORT_PROTOTYPE(47, "IN_OUT_DATA_PORT_PROTOTYPE", "inout data port prototype"),

  /**
   * The '<em><b>IN EVENT PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_EVENT_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_EVENT_PORT_PROTOTYPE(48, "IN_EVENT_PORT_PROTOTYPE", "in event port prototype"),

  /**
   * The '<em><b>OUT EVENT PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  OUT_EVENT_PORT_PROTOTYPE(49, "OUT_EVENT_PORT_PROTOTYPE", "out event port prototype"),

  /**
   * The '<em><b>IN OUT EVENT PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_EVENT_PORT_PROTOTYPE(50, "IN_OUT_EVENT_PORT_PROTOTYPE", "inout event port prototype"),

  /**
   * The '<em><b>IN EVENT DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_EVENT_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_EVENT_DATA_PORT_PROTOTYPE(51, "IN_EVENT_DATA_PORT_PROTOTYPE", "in event data port prototype"),

  /**
   * The '<em><b>OUT EVENT DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  OUT_EVENT_DATA_PORT_PROTOTYPE(52, "OUT_EVENT_DATA_PORT_PROTOTYPE", "out event data port prototype"),

  /**
   * The '<em><b>IN OUT EVENT DATA PORT PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  IN_OUT_EVENT_DATA_PORT_PROTOTYPE(53, "IN_OUT_EVENT_DATA_PORT_PROTOTYPE", "inout event data port prototype"),

  /**
   * The '<em><b>PROVIDES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE(54, "PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE", "provides subprogram access prototype"),

  /**
   * The '<em><b>REQUIRES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE(55, "REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE", "requires subprogram access prototype"),

  /**
   * The '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE(56, "PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE", "provides subprogram group access prototype"),

  /**
   * The '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE(57, "REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE", "requires subprogram group access prototype"),

  /**
   * The '<em><b>PROVIDES DATA ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_DATA_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_DATA_ACCESS_PROTOTYPE(58, "PROVIDES_DATA_ACCESS_PROTOTYPE", "provides data access prototype"),

  /**
   * The '<em><b>REQUIRES DATA ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_DATA_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_DATA_ACCESS_PROTOTYPE(59, "REQUIRES_DATA_ACCESS_PROTOTYPE", "requires data access prototype"),

  /**
   * The '<em><b>PROVIDES BUS ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROVIDES_BUS_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  PROVIDES_BUS_ACCESS_PROTOTYPE(60, "PROVIDES_BUS_ACCESS_PROTOTYPE", "provides bus access prototype"),

  /**
   * The '<em><b>REQUIRES BUS ACCESS PROTOTYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_BUS_ACCESS_PROTOTYPE_VALUE
   * @generated
   * @ordered
   */
  REQUIRES_BUS_ACCESS_PROTOTYPE(61, "REQUIRES_BUS_ACCESS_PROTOTYPE", "requires bus access prototype"), /**
   * The '<em><b>SYSTEM SUBCOMPONENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SYSTEM_SUBCOMPONENT_VALUE
   * @generated
   * @ordered
   */
  SYSTEM_SUBCOMPONENT(62, "SYSTEM_SUBCOMPONENT", "system subcomponent"), /**
   * The '<em><b>PROCESSOR CLASSIFIER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROCESSOR_CLASSIFIER_VALUE
   * @generated
   * @ordered
   */
  PROCESSOR_CLASSIFIER(63, "PROCESSOR_CLASSIFIER", "processor classifier"), /**
   * The '<em><b>PROCESS CLASSIFIER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROCESS_CLASSIFIER_VALUE
   * @generated
   * @ordered
   */
  PROCESS_CLASSIFIER(64, "PROCESS_CLASSIFIER", "process classifier");

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model literal="unknown aadl classifier"
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 0;

  /**
   * The '<em><b>IN DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_DATA_PORT
   * @model literal="in data port"
   * @generated
   * @ordered
   */
  public static final int IN_DATA_PORT_VALUE = 1;

  /**
   * The '<em><b>OUT DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_DATA_PORT
   * @model literal="out data port"
   * @generated
   * @ordered
   */
  public static final int OUT_DATA_PORT_VALUE = 2;

  /**
   * The '<em><b>IN OUT DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_DATA_PORT
   * @model literal="inout data port"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_DATA_PORT_VALUE = 3;

  /**
   * The '<em><b>IN EVENT PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN EVENT PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_EVENT_PORT
   * @model literal="in event port"
   * @generated
   * @ordered
   */
  public static final int IN_EVENT_PORT_VALUE = 4;

  /**
   * The '<em><b>OUT EVENT PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT EVENT PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_PORT
   * @model literal="out event port"
   * @generated
   * @ordered
   */
  public static final int OUT_EVENT_PORT_VALUE = 5;

  /**
   * The '<em><b>IN OUT EVENT PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT EVENT PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_PORT
   * @model literal="inout event port"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_EVENT_PORT_VALUE = 6;

  /**
   * The '<em><b>IN EVENT DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN EVENT DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_EVENT_DATA_PORT
   * @model literal="in event data port"
   * @generated
   * @ordered
   */
  public static final int IN_EVENT_DATA_PORT_VALUE = 7;

  /**
   * The '<em><b>OUT EVENT DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT EVENT DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_DATA_PORT
   * @model literal="out event data port"
   * @generated
   * @ordered
   */
  public static final int OUT_EVENT_DATA_PORT_VALUE = 8;

  /**
   * The '<em><b>IN OUT EVENT DATA PORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT EVENT DATA PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_DATA_PORT
   * @model literal="inout event data port"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_EVENT_DATA_PORT_VALUE = 9;

  /**
   * The '<em><b>PROVIDES SUBPROGRAM ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES SUBPROGRAM ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_ACCESS
   * @model literal="provides subprogram access"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_SUBPROGRAM_ACCESS_VALUE = 10;

  /**
   * The '<em><b>REQUIRES SUBPROGRAM ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES SUBPROGRAM ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_ACCESS
   * @model literal="requires subprogram access"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_SUBPROGRAM_ACCESS_VALUE = 11;

  /**
   * The '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_GROUP_ACCESS
   * @model literal="provides subprogram group access"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_SUBPROGRAM_GROUP_ACCESS_VALUE = 12;

  /**
   * The '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_GROUP_ACCESS
   * @model literal="requires subprogram group access"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_SUBPROGRAM_GROUP_ACCESS_VALUE = 13;

  /**
   * The '<em><b>SUBPROGRAM SUBCOMPONENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBPROGRAM SUBCOMPONENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_SUBCOMPONENT
   * @model literal="subprogram subcomponent"
   * @generated
   * @ordered
   */
  public static final int SUBPROGRAM_SUBCOMPONENT_VALUE = 14;

  /**
   * The '<em><b>SUBPROGRAM CLASSIFIER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBPROGRAM CLASSIFIER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_CLASSIFIER
   * @model literal="subprogram classifier"
   * @generated
   * @ordered
   */
  public static final int SUBPROGRAM_CLASSIFIER_VALUE = 15;

  /**
   * The '<em><b>SUBPROGRAM PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBPROGRAM PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_PROTOTYPE
   * @model literal="subprogram prototype"
   * @generated
   * @ordered
   */
  public static final int SUBPROGRAM_PROTOTYPE_VALUE = 16;

  /**
   * The '<em><b>COMPONENT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPONENT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROTOTYPE
   * @model literal="component prototype"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_PROTOTYPE_VALUE = 17;

  /**
   * The '<em><b>COMPONENT PROTOTYPE BINDING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPONENT PROTOTYPE BINDING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROTOTYPE_BINDING
   * @model literal="component prototype binding"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_PROTOTYPE_BINDING_VALUE = 18;

  /**
   * The '<em><b>FEATURE PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEATURE PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEATURE_PROTOTYPE
   * @model literal="feature prototype"
   * @generated
   * @ordered
   */
  public static final int FEATURE_PROTOTYPE_VALUE = 19;

  /**
   * The '<em><b>FEATURE PROTOTYPE BINDING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEATURE PROTOTYPE BINDING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEATURE_PROTOTYPE_BINDING
   * @model literal="feature prototype binding"
   * @generated
   * @ordered
   */
  public static final int FEATURE_PROTOTYPE_BINDING_VALUE = 20;

  /**
   * The '<em><b>FEATURE GROUP PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEATURE GROUP PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP_PROTOTYPE
   * @model literal="feature group prototytpe"
   * @generated
   * @ordered
   */
  public static final int FEATURE_GROUP_PROTOTYPE_VALUE = 21;

  /**
   * The '<em><b>FEATURE GROUP PROTOTYPE BINDING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEATURE GROUP PROTOTYPE BINDING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP_PROTOTYPE_BINDING
   * @model literal="feature group prototype binding"
   * @generated
   * @ordered
   */
  public static final int FEATURE_GROUP_PROTOTYPE_BINDING_VALUE = 22;

  /**
   * The '<em><b>PROVIDES DATA ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES DATA ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_DATA_ACCESS
   * @model literal="provides data access"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_DATA_ACCESS_VALUE = 23;

  /**
   * The '<em><b>REQUIRES DATA ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES DATA ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_DATA_ACCESS
   * @model literal="requires data access"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_DATA_ACCESS_VALUE = 24;

  /**
   * The '<em><b>DATA SUBCOMPONENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATA SUBCOMPONENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATA_SUBCOMPONENT
   * @model literal="data subcomponent"
   * @generated
   * @ordered
   */
  public static final int DATA_SUBCOMPONENT_VALUE = 25;

  /**
   * The '<em><b>DATA CLASSIFIER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATA CLASSIFIER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATA_CLASSIFIER
   * @model literal="data classifier"
   * @generated
   * @ordered
   */
  public static final int DATA_CLASSIFIER_VALUE = 26;

  /**
   * The '<em><b>IN PARAMETER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN PARAMETER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_PARAMETER
   * @model literal="in parameter"
   * @generated
   * @ordered
   */
  public static final int IN_PARAMETER_VALUE = 27;

  /**
   * The '<em><b>OUT PARAMETER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT PARAMETER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_PARAMETER
   * @model literal="out parameter"
   * @generated
   * @ordered
   */
  public static final int OUT_PARAMETER_VALUE = 28;

  /**
   * The '<em><b>IN OUT PARAMETER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT PARAMETER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_PARAMETER
   * @model literal="in out parameter"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_PARAMETER_VALUE = 29;

  /**
   * The '<em><b>PROPERTY CONSTANT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROPERTY CONSTANT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROPERTY_CONSTANT
   * @model literal="property constant"
   * @generated
   * @ordered
   */
  public static final int PROPERTY_CONSTANT_VALUE = 30;

  /**
   * The '<em><b>PROPERTY VALUE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROPERTY VALUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROPERTY_VALUE
   * @model literal="property value"
   * @generated
   * @ordered
   */
  public static final int PROPERTY_VALUE_VALUE = 31;

  /**
   * The '<em><b>PROVIDES BUS ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES BUS ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_BUS_ACCESS
   * @model literal="provides bus access"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_BUS_ACCESS_VALUE = 32;

  /**
   * The '<em><b>REQUIRES BUS ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES BUS ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_BUS_ACCESS
   * @model literal="requires bus access"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_BUS_ACCESS_VALUE = 33;

  /**
   * The '<em><b>FEATURE GROUP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEATURE GROUP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEATURE_GROUP
   * @model literal="feature group"
   * @generated
   * @ordered
   */
  public static final int FEATURE_GROUP_VALUE = 34;

  /**
   * The '<em><b>CLASSIFIER VALUE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CLASSIFIER VALUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLASSIFIER_VALUE
   * @model literal="classifier value"
   * @generated
   * @ordered
   */
  public static final int CLASSIFIER_VALUE_VALUE = 35;

  /**
   * The '<em><b>ABSTRACT FEATURE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ABSTRACT FEATURE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ABSTRACT_FEATURE
   * @model literal="abstract feature"
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_FEATURE_VALUE = 36;

  /**
   * The '<em><b>IN FEATURE PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN FEATURE PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_FEATURE_PROTOTYPE
   * @model literal="in feature prototype"
   * @generated
   * @ordered
   */
  public static final int IN_FEATURE_PROTOTYPE_VALUE = 37;

  /**
   * The '<em><b>OUT FEATURE PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT FEATURE PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_FEATURE_PROTOTYPE
   * @model literal="out feature prototype"
   * @generated
   * @ordered
   */
  public static final int OUT_FEATURE_PROTOTYPE_VALUE = 38;

  /**
   * The '<em><b>IN OUT FEATURE PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT FEATURE PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_FEATURE_PROTOTYPE
   * @model literal="in out feature prototype"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_FEATURE_PROTOTYPE_VALUE = 39;

  /**
   * The '<em><b>THREAD GROUP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THREAD GROUP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #THREAD_GROUP
   * @model literal="thread group"
   * @generated
   * @ordered
   */
  public static final int THREAD_GROUP_VALUE = 40;

  /**
   * The '<em><b>SUBPROGRAM GROUP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBPROGRAM GROUP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_GROUP
   * @model literal="subprogram group"
   * @generated
   * @ordered
   */
  public static final int SUBPROGRAM_GROUP_VALUE = 41;

  /**
   * The '<em><b>SUBPROGRAM GROUP PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBPROGRAM GROUP PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBPROGRAM_GROUP_PROTOTYPE
   * @model literal="subprogram group prototype"
   * @generated
   * @ordered
   */
  public static final int SUBPROGRAM_GROUP_PROTOTYPE_VALUE = 42;

  /**
   * The '<em><b>THREAD PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THREAD PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #THREAD_PROTOTYPE
   * @model literal="thread prototype"
   * @generated
   * @ordered
   */
  public static final int THREAD_PROTOTYPE_VALUE = 43;

  /**
   * The '<em><b>THREAD GROUP PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THREAD GROUP PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #THREAD_GROUP_PROTOTYPE
   * @model literal="thread group prototype"
   * @generated
   * @ordered
   */
  public static final int THREAD_GROUP_PROTOTYPE_VALUE = 44;

  /**
   * The '<em><b>IN DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_DATA_PORT_PROTOTYPE
   * @model literal="in data port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_DATA_PORT_PROTOTYPE_VALUE = 45;

  /**
   * The '<em><b>OUT DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_DATA_PORT_PROTOTYPE
   * @model literal="out data port prototype"
   * @generated
   * @ordered
   */
  public static final int OUT_DATA_PORT_PROTOTYPE_VALUE = 46;

  /**
   * The '<em><b>IN OUT DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_DATA_PORT_PROTOTYPE
   * @model literal="inout data port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_DATA_PORT_PROTOTYPE_VALUE = 47;

  /**
   * The '<em><b>IN EVENT PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN EVENT PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_EVENT_PORT_PROTOTYPE
   * @model literal="in event port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_EVENT_PORT_PROTOTYPE_VALUE = 48;

  /**
   * The '<em><b>OUT EVENT PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT EVENT PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_PORT_PROTOTYPE
   * @model literal="out event port prototype"
   * @generated
   * @ordered
   */
  public static final int OUT_EVENT_PORT_PROTOTYPE_VALUE = 49;

  /**
   * The '<em><b>IN OUT EVENT PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT EVENT PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_PORT_PROTOTYPE
   * @model literal="inout event port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_EVENT_PORT_PROTOTYPE_VALUE = 50;

  /**
   * The '<em><b>IN EVENT DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN EVENT DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_EVENT_DATA_PORT_PROTOTYPE
   * @model literal="in event data port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_EVENT_DATA_PORT_PROTOTYPE_VALUE = 51;

  /**
   * The '<em><b>OUT EVENT DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OUT EVENT DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUT_EVENT_DATA_PORT_PROTOTYPE
   * @model literal="out event data port prototype"
   * @generated
   * @ordered
   */
  public static final int OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE = 52;

  /**
   * The '<em><b>IN OUT EVENT DATA PORT PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN OUT EVENT DATA PORT PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT_EVENT_DATA_PORT_PROTOTYPE
   * @model literal="inout event data port prototype"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE = 53;

  /**
   * The '<em><b>PROVIDES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE
   * @model literal="provides subprogram access prototype"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE = 54;

  /**
   * The '<em><b>REQUIRES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES SUBPROGRAM ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE
   * @model literal="requires subprogram access prototype"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE = 55;

  /**
   * The '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE
   * @model literal="provides subprogram group access prototype"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE = 56;

  /**
   * The '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES SUBPROGRAM GROUP ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE
   * @model literal="requires subprogram group access prototype"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE = 57;

  /**
   * The '<em><b>PROVIDES DATA ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES DATA ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_DATA_ACCESS_PROTOTYPE
   * @model literal="provides data access prototype"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_DATA_ACCESS_PROTOTYPE_VALUE = 58;

  /**
   * The '<em><b>REQUIRES DATA ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES DATA ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_DATA_ACCESS_PROTOTYPE
   * @model literal="requires data access prototype"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_DATA_ACCESS_PROTOTYPE_VALUE = 59;

  /**
   * The '<em><b>PROVIDES BUS ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROVIDES BUS ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROVIDES_BUS_ACCESS_PROTOTYPE
   * @model literal="provides bus access prototype"
   * @generated
   * @ordered
   */
  public static final int PROVIDES_BUS_ACCESS_PROTOTYPE_VALUE = 60;

  /**
   * The '<em><b>REQUIRES BUS ACCESS PROTOTYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES BUS ACCESS PROTOTYPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES_BUS_ACCESS_PROTOTYPE
   * @model literal="requires bus access prototype"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_BUS_ACCESS_PROTOTYPE_VALUE = 61;

  /**
   * The '<em><b>SYSTEM SUBCOMPONENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SYSTEM SUBCOMPONENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SYSTEM_SUBCOMPONENT
   * @model literal="system subcomponent"
   * @generated
   * @ordered
   */
  public static final int SYSTEM_SUBCOMPONENT_VALUE = 62;

  /**
   * The '<em><b>PROCESSOR CLASSIFIER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROCESSOR CLASSIFIER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROCESSOR_CLASSIFIER
   * @model literal="processor classifier"
   * @generated
   * @ordered
   */
  public static final int PROCESSOR_CLASSIFIER_VALUE = 63;

  /**
   * The '<em><b>PROCESS CLASSIFIER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROCESS CLASSIFIER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROCESS_CLASSIFIER
   * @model literal="process classifier"
   * @generated
   * @ordered
   */
  public static final int PROCESS_CLASSIFIER_VALUE = 64;

  /**
   * An array of all the '<em><b>Feature Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final FeatureType[] VALUES_ARRAY =
    new FeatureType[]
    {
      NONE,
      IN_DATA_PORT,
      OUT_DATA_PORT,
      IN_OUT_DATA_PORT,
      IN_EVENT_PORT,
      OUT_EVENT_PORT,
      IN_OUT_EVENT_PORT,
      IN_EVENT_DATA_PORT,
      OUT_EVENT_DATA_PORT,
      IN_OUT_EVENT_DATA_PORT,
      PROVIDES_SUBPROGRAM_ACCESS,
      REQUIRES_SUBPROGRAM_ACCESS,
      PROVIDES_SUBPROGRAM_GROUP_ACCESS,
      REQUIRES_SUBPROGRAM_GROUP_ACCESS,
      SUBPROGRAM_SUBCOMPONENT,
      SUBPROGRAM_CLASSIFIER,
      SUBPROGRAM_PROTOTYPE,
      COMPONENT_PROTOTYPE,
      COMPONENT_PROTOTYPE_BINDING,
      FEATURE_PROTOTYPE,
      FEATURE_PROTOTYPE_BINDING,
      FEATURE_GROUP_PROTOTYPE,
      FEATURE_GROUP_PROTOTYPE_BINDING,
      PROVIDES_DATA_ACCESS,
      REQUIRES_DATA_ACCESS,
      DATA_SUBCOMPONENT,
      DATA_CLASSIFIER,
      IN_PARAMETER,
      OUT_PARAMETER,
      IN_OUT_PARAMETER,
      PROPERTY_CONSTANT,
      PROPERTY_VALUE,
      PROVIDES_BUS_ACCESS,
      REQUIRES_BUS_ACCESS,
      FEATURE_GROUP,
      CLASSIFIER_VALUE,
      ABSTRACT_FEATURE,
      IN_FEATURE_PROTOTYPE,
      OUT_FEATURE_PROTOTYPE,
      IN_OUT_FEATURE_PROTOTYPE,
      THREAD_GROUP,
      SUBPROGRAM_GROUP,
      SUBPROGRAM_GROUP_PROTOTYPE,
      THREAD_PROTOTYPE,
      THREAD_GROUP_PROTOTYPE,
      IN_DATA_PORT_PROTOTYPE,
      OUT_DATA_PORT_PROTOTYPE,
      IN_OUT_DATA_PORT_PROTOTYPE,
      IN_EVENT_PORT_PROTOTYPE,
      OUT_EVENT_PORT_PROTOTYPE,
      IN_OUT_EVENT_PORT_PROTOTYPE,
      IN_EVENT_DATA_PORT_PROTOTYPE,
      OUT_EVENT_DATA_PORT_PROTOTYPE,
      IN_OUT_EVENT_DATA_PORT_PROTOTYPE,
      PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE,
      REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE,
      PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE,
      REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE,
      PROVIDES_DATA_ACCESS_PROTOTYPE,
      REQUIRES_DATA_ACCESS_PROTOTYPE,
      PROVIDES_BUS_ACCESS_PROTOTYPE,
      REQUIRES_BUS_ACCESS_PROTOTYPE,
      SYSTEM_SUBCOMPONENT,
      PROCESSOR_CLASSIFIER,
      PROCESS_CLASSIFIER,
    };

  /**
   * A public read-only list of all the '<em><b>Feature Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<FeatureType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Feature Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FeatureType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FeatureType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Feature Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FeatureType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FeatureType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Feature Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FeatureType get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case IN_DATA_PORT_VALUE: return IN_DATA_PORT;
      case OUT_DATA_PORT_VALUE: return OUT_DATA_PORT;
      case IN_OUT_DATA_PORT_VALUE: return IN_OUT_DATA_PORT;
      case IN_EVENT_PORT_VALUE: return IN_EVENT_PORT;
      case OUT_EVENT_PORT_VALUE: return OUT_EVENT_PORT;
      case IN_OUT_EVENT_PORT_VALUE: return IN_OUT_EVENT_PORT;
      case IN_EVENT_DATA_PORT_VALUE: return IN_EVENT_DATA_PORT;
      case OUT_EVENT_DATA_PORT_VALUE: return OUT_EVENT_DATA_PORT;
      case IN_OUT_EVENT_DATA_PORT_VALUE: return IN_OUT_EVENT_DATA_PORT;
      case PROVIDES_SUBPROGRAM_ACCESS_VALUE: return PROVIDES_SUBPROGRAM_ACCESS;
      case REQUIRES_SUBPROGRAM_ACCESS_VALUE: return REQUIRES_SUBPROGRAM_ACCESS;
      case PROVIDES_SUBPROGRAM_GROUP_ACCESS_VALUE: return PROVIDES_SUBPROGRAM_GROUP_ACCESS;
      case REQUIRES_SUBPROGRAM_GROUP_ACCESS_VALUE: return REQUIRES_SUBPROGRAM_GROUP_ACCESS;
      case SUBPROGRAM_SUBCOMPONENT_VALUE: return SUBPROGRAM_SUBCOMPONENT;
      case SUBPROGRAM_CLASSIFIER_VALUE: return SUBPROGRAM_CLASSIFIER;
      case SUBPROGRAM_PROTOTYPE_VALUE: return SUBPROGRAM_PROTOTYPE;
      case COMPONENT_PROTOTYPE_VALUE: return COMPONENT_PROTOTYPE;
      case COMPONENT_PROTOTYPE_BINDING_VALUE: return COMPONENT_PROTOTYPE_BINDING;
      case FEATURE_PROTOTYPE_VALUE: return FEATURE_PROTOTYPE;
      case FEATURE_PROTOTYPE_BINDING_VALUE: return FEATURE_PROTOTYPE_BINDING;
      case FEATURE_GROUP_PROTOTYPE_VALUE: return FEATURE_GROUP_PROTOTYPE;
      case FEATURE_GROUP_PROTOTYPE_BINDING_VALUE: return FEATURE_GROUP_PROTOTYPE_BINDING;
      case PROVIDES_DATA_ACCESS_VALUE: return PROVIDES_DATA_ACCESS;
      case REQUIRES_DATA_ACCESS_VALUE: return REQUIRES_DATA_ACCESS;
      case DATA_SUBCOMPONENT_VALUE: return DATA_SUBCOMPONENT;
      case DATA_CLASSIFIER_VALUE: return DATA_CLASSIFIER;
      case IN_PARAMETER_VALUE: return IN_PARAMETER;
      case OUT_PARAMETER_VALUE: return OUT_PARAMETER;
      case IN_OUT_PARAMETER_VALUE: return IN_OUT_PARAMETER;
      case PROPERTY_CONSTANT_VALUE: return PROPERTY_CONSTANT;
      case PROPERTY_VALUE_VALUE: return PROPERTY_VALUE;
      case PROVIDES_BUS_ACCESS_VALUE: return PROVIDES_BUS_ACCESS;
      case REQUIRES_BUS_ACCESS_VALUE: return REQUIRES_BUS_ACCESS;
      case FEATURE_GROUP_VALUE: return FEATURE_GROUP;
      case CLASSIFIER_VALUE_VALUE: return CLASSIFIER_VALUE;
      case ABSTRACT_FEATURE_VALUE: return ABSTRACT_FEATURE;
      case IN_FEATURE_PROTOTYPE_VALUE: return IN_FEATURE_PROTOTYPE;
      case OUT_FEATURE_PROTOTYPE_VALUE: return OUT_FEATURE_PROTOTYPE;
      case IN_OUT_FEATURE_PROTOTYPE_VALUE: return IN_OUT_FEATURE_PROTOTYPE;
      case THREAD_GROUP_VALUE: return THREAD_GROUP;
      case SUBPROGRAM_GROUP_VALUE: return SUBPROGRAM_GROUP;
      case SUBPROGRAM_GROUP_PROTOTYPE_VALUE: return SUBPROGRAM_GROUP_PROTOTYPE;
      case THREAD_PROTOTYPE_VALUE: return THREAD_PROTOTYPE;
      case THREAD_GROUP_PROTOTYPE_VALUE: return THREAD_GROUP_PROTOTYPE;
      case IN_DATA_PORT_PROTOTYPE_VALUE: return IN_DATA_PORT_PROTOTYPE;
      case OUT_DATA_PORT_PROTOTYPE_VALUE: return OUT_DATA_PORT_PROTOTYPE;
      case IN_OUT_DATA_PORT_PROTOTYPE_VALUE: return IN_OUT_DATA_PORT_PROTOTYPE;
      case IN_EVENT_PORT_PROTOTYPE_VALUE: return IN_EVENT_PORT_PROTOTYPE;
      case OUT_EVENT_PORT_PROTOTYPE_VALUE: return OUT_EVENT_PORT_PROTOTYPE;
      case IN_OUT_EVENT_PORT_PROTOTYPE_VALUE: return IN_OUT_EVENT_PORT_PROTOTYPE;
      case IN_EVENT_DATA_PORT_PROTOTYPE_VALUE: return IN_EVENT_DATA_PORT_PROTOTYPE;
      case OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE: return OUT_EVENT_DATA_PORT_PROTOTYPE;
      case IN_OUT_EVENT_DATA_PORT_PROTOTYPE_VALUE: return IN_OUT_EVENT_DATA_PORT_PROTOTYPE;
      case PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE: return PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE;
      case REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE_VALUE: return REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE;
      case PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE: return PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE;
      case REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE_VALUE: return REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE;
      case PROVIDES_DATA_ACCESS_PROTOTYPE_VALUE: return PROVIDES_DATA_ACCESS_PROTOTYPE;
      case REQUIRES_DATA_ACCESS_PROTOTYPE_VALUE: return REQUIRES_DATA_ACCESS_PROTOTYPE;
      case PROVIDES_BUS_ACCESS_PROTOTYPE_VALUE: return PROVIDES_BUS_ACCESS_PROTOTYPE;
      case REQUIRES_BUS_ACCESS_PROTOTYPE_VALUE: return REQUIRES_BUS_ACCESS_PROTOTYPE;
      case SYSTEM_SUBCOMPONENT_VALUE: return SYSTEM_SUBCOMPONENT;
      case PROCESSOR_CLASSIFIER_VALUE: return PROCESSOR_CLASSIFIER;
      case PROCESS_CLASSIFIER_VALUE: return PROCESS_CLASSIFIER;
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
  private FeatureType(int value, String name, String literal)
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
  
} //FeatureType
