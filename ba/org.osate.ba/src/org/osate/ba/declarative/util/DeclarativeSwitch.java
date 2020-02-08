/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative.util ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.util.Switch ;

import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.BooleanLiteral ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.ContainedNamedElement ;
import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.FeatureClassifier ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.Processor ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.ProcessorSubcomponentType ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.PropertyValue ;
import org.osate.aadl2.RangeValue ;
import org.osate.aadl2.RealLiteral ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.Type ;
import org.osate.aadl2.TypedElement ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.ba.aadlba.ActualPortHolder ;
import org.osate.ba.aadlba.BasicAction ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorBooleanLiteral ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorNamedElement ;
import org.osate.ba.aadlba.BehaviorRealLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorStringLiteral ;
import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.ClassifierFeatureHolder ;
import org.osate.ba.aadlba.CommunicationAction ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DispatchRelativeTimeout ;
import org.osate.ba.aadlba.DispatchTrigger ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.aadlba.ElementHolder ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.FeatureHolder ;
import org.osate.ba.aadlba.GroupableElement ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.Literal ;
import org.osate.ba.aadlba.ModeSwitchTrigger ;
import org.osate.ba.aadlba.NumericLiteral ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.PortHolder ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueConstant ;
import org.osate.ba.aadlba.ValueVariable ;
import org.osate.ba.declarative.* ;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.ba.declarative.DeclarativePackage
 * @generated
 */
public class DeclarativeSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DeclarativePackage modelPackage ;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarativeSwitch()
  {
    if(modelPackage == null)
    {
      modelPackage = DeclarativePackage.eINSTANCE ;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage ;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch ( classifierID )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER :
      {
        ArrayableIdentifier arrayableIdentifier =
                                                (ArrayableIdentifier) theEObject ;
        T result = caseArrayableIdentifier(arrayableIdentifier) ;
        if(result == null)
          result = caseIdentifier(arrayableIdentifier) ;
        if(result == null)
          result = caseBehaviorState(arrayableIdentifier) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(arrayableIdentifier) ;
        if(result == null)
          result = caseBehaviorNamedElement(arrayableIdentifier) ;
        if(result == null)
          result = caseNamedElement(arrayableIdentifier) ;
        if(result == null)
          result = caseBehaviorElement(arrayableIdentifier) ;
        if(result == null)
          result = caseElement(arrayableIdentifier) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.COMM_ACTION :
      {
        CommAction commAction = (CommAction) theEObject ;
        T result = caseCommAction(commAction) ;
        if(result == null)
          result = caseCommunicationAction(commAction) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(commAction) ;
        if(result == null)
          result = caseBasicAction(commAction) ;
        if(result == null)
          result = caseBehaviorAction(commAction) ;
        if(result == null)
          result = caseBehaviorActions(commAction) ;
        if(result == null)
          result = caseBehaviorElement(commAction) ;
        if(result == null)
          result = caseElement(commAction) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_ARRAY_DIMENSION :
      {
        DeclarativeArrayDimension declarativeArrayDimension =
                                                            (DeclarativeArrayDimension) theEObject ;
        T result = caseDeclarativeArrayDimension(declarativeArrayDimension) ;
        if(result == null)
          result = caseArrayDimension(declarativeArrayDimension) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(declarativeArrayDimension) ;
        if(result == null)
          result = caseBehaviorElement(declarativeArrayDimension) ;
        if(result == null)
          result = caseElement(declarativeArrayDimension) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT :
      {
        DeclarativeBehaviorElement declarativeBehaviorElement =
                                                              (DeclarativeBehaviorElement) theEObject ;
        T result = caseDeclarativeBehaviorElement(declarativeBehaviorElement) ;
        if(result == null)
          result = caseBehaviorElement(declarativeBehaviorElement) ;
        if(result == null)
          result = caseElement(declarativeBehaviorElement) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION :
      {
        DeclarativeBehaviorTransition declarativeBehaviorTransition =
                                                                    (DeclarativeBehaviorTransition) theEObject ;
        T result = caseDeclarativeBehaviorTransition(
                                                     declarativeBehaviorTransition) ;
        if(result == null)
          result = caseBehaviorTransition(declarativeBehaviorTransition) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(
                                                  declarativeBehaviorTransition) ;
        if(result == null)
          result = caseBehaviorNamedElement(declarativeBehaviorTransition) ;
        if(result == null)
          result = caseNamedElement(declarativeBehaviorTransition) ;
        if(result == null)
          result = caseBehaviorElement(declarativeBehaviorTransition) ;
        if(result == null)
          result = caseElement(declarativeBehaviorTransition) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME :
      {
        DeclarativePropertyName declarativePropertyName =
                                                        (DeclarativePropertyName) theEObject ;
        T result = caseDeclarativePropertyName(declarativePropertyName) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(declarativePropertyName) ;
        if(result == null)
          result = caseBehaviorElement(declarativePropertyName) ;
        if(result == null)
          result = caseElement(declarativePropertyName) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE :
      {
        DeclarativePropertyReference declarativePropertyReference =
                                                                  (DeclarativePropertyReference) theEObject ;
        T result = caseDeclarativePropertyReference(
                                                    declarativePropertyReference) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(
                                                  declarativePropertyReference) ;
        if(result == null)
          result = caseIntegerValueConstant(declarativePropertyReference) ;
        if(result == null)
          result = caseIntegerValue(declarativePropertyReference) ;
        if(result == null)
          result = caseValueConstant(declarativePropertyReference) ;
        if(result == null)
          result = caseElement(declarativePropertyReference) ;
        if(result == null)
          result = caseValue(declarativePropertyReference) ;
        if(result == null)
          result = caseBehaviorElement(declarativePropertyReference) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_TIME :
      {
        DeclarativeTime declarativeTime = (DeclarativeTime) theEObject ;
        T result = caseDeclarativeTime(declarativeTime) ;
        if(result == null)
          result = caseCompletionRelativeTimeout(declarativeTime) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(declarativeTime) ;
        if(result == null)
          result = caseBehaviorTime(declarativeTime) ;
        if(result == null)
          result = caseDispatchRelativeTimeout(declarativeTime) ;
        if(result == null)
          result = caseElement(declarativeTime) ;
        if(result == null)
          result = caseDispatchTriggerCondition(declarativeTime) ;
        if(result == null)
          result = caseBehaviorElement(declarativeTime) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.IDENTIFIER :
      {
        Identifier identifier = (Identifier) theEObject ;
        T result = caseIdentifier(identifier) ;
        if(result == null)
          result = caseBehaviorState(identifier) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(identifier) ;
        if(result == null)
          result = caseBehaviorNamedElement(identifier) ;
        if(result == null)
          result = caseNamedElement(identifier) ;
        if(result == null)
          result = caseBehaviorElement(identifier) ;
        if(result == null)
          result = caseElement(identifier) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.NAMED_VALUE :
      {
        NamedValue namedValue = (NamedValue) theEObject ;
        T result = caseNamedValue(namedValue) ;
        if(result == null)
          result = caseIntegerValueVariable(namedValue) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(namedValue) ;
        if(result == null)
          result = caseIntegerValue(namedValue) ;
        if(result == null)
          result = caseValueVariable(namedValue) ;
        if(result == null)
          result = caseValue(namedValue) ;
        if(result == null)
          result = caseBehaviorElement(namedValue) ;
        if(result == null)
          result = caseElement(namedValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT :
      {
        QualifiedNamedElement qualifiedNamedElement =
                                                    (QualifiedNamedElement) theEObject ;
        T result = caseQualifiedNamedElement(qualifiedNamedElement) ;
        if(result == null)
          result = caseDataClassifier(qualifiedNamedElement) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(qualifiedNamedElement) ;
        if(result == null)
          result = caseIntegerValueConstant(qualifiedNamedElement) ;
        if(result == null)
          result = caseProcessorClassifier(qualifiedNamedElement) ;
        if(result == null)
          result = caseProperty(qualifiedNamedElement) ;
        if(result == null)
          result = caseUnitLiteral(qualifiedNamedElement) ;
        if(result == null)
          result = caseComponentClassifier(qualifiedNamedElement) ;
        if(result == null)
          result = caseData(qualifiedNamedElement) ;
        if(result == null)
          result = caseDataSubcomponentType(qualifiedNamedElement) ;
        if(result == null)
          result = caseValueConstant(qualifiedNamedElement) ;
        if(result == null)
          result = caseValue(qualifiedNamedElement) ;
        if(result == null)
          result = caseIntegerValue(qualifiedNamedElement) ;
        if(result == null)
          result = caseProcessor(qualifiedNamedElement) ;
        if(result == null)
          result = caseProcessorSubcomponentType(qualifiedNamedElement) ;
        if(result == null)
          result = caseBasicProperty(qualifiedNamedElement) ;
        if(result == null)
          result = caseEnumerationLiteral(qualifiedNamedElement) ;
        if(result == null)
          result = caseClassifier(qualifiedNamedElement) ;
        if(result == null)
          result = caseSubcomponentType(qualifiedNamedElement) ;
        if(result == null)
          result = caseFeatureClassifier(qualifiedNamedElement) ;
        if(result == null)
          result = caseBehaviorElement(qualifiedNamedElement) ;
        if(result == null)
          result = caseTypedElement(qualifiedNamedElement) ;
        if(result == null)
          result = caseAbstractNamedValue(qualifiedNamedElement) ;
        if(result == null)
          result = caseNamespace(qualifiedNamedElement) ;
        if(result == null)
          result = caseType(qualifiedNamedElement) ;
        if(result == null)
          result = caseNamedElement(qualifiedNamedElement) ;
        if(result == null)
          result = caseElement(qualifiedNamedElement) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.REFERENCE :
      {
        Reference reference = (Reference) theEObject ;
        T result = caseReference(reference) ;
        if(result == null)
          result = caseActualPortHolder(reference) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(reference) ;
        if(result == null)
          result = caseElementValues(reference) ;
        if(result == null)
          result = caseTarget(reference) ;
        if(result == null)
          result = caseDispatchTriggerCondition(reference) ;
        if(result == null)
          result = caseDispatchTrigger(reference) ;
        if(result == null)
          result = caseModeSwitchTrigger(reference) ;
        if(result == null)
          result = caseContainmentPathElement(reference) ;
        if(result == null)
          result = casePortHolder(reference) ;
        if(result == null)
          result = caseParameterLabel(reference) ;
        if(result == null)
          result = caseIntegerValueVariable(reference) ;
        if(result == null)
          result = caseFeatureHolder(reference) ;
        if(result == null)
          result = caseValueVariable(reference) ;
        if(result == null)
          result = caseValue(reference) ;
        if(result == null)
          result = caseIntegerValue(reference) ;
        if(result == null)
          result = caseClassifierFeatureHolder(reference) ;
        if(result == null)
          result = caseIndexableElement(reference) ;
        if(result == null)
          result = caseGroupableElement(reference) ;
        if(result == null)
          result = caseElementHolder(reference) ;
        if(result == null)
          result = caseBehaviorElement(reference) ;
        if(result == null)
          result = caseElement(reference) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION :
      {
        DeclarativePropertyAssociation declarativePropertyAssociation =
                                                                      (DeclarativePropertyAssociation) theEObject ;
        T result = caseDeclarativePropertyAssociation(
                                                      declarativePropertyAssociation) ;
        if(result == null)
          result = caseDeclarativeBehaviorElement(
                                                  declarativePropertyAssociation) ;
        if(result == null)
          result = caseBehaviorElement(declarativePropertyAssociation) ;
        if(result == null)
          result = caseElement(declarativePropertyAssociation) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_LIST_VALUE :
      {
        DeclarativeListValue declarativeListValue =
                                                  (DeclarativeListValue) theEObject ;
        T result = caseDeclarativeListValue(declarativeListValue) ;
        if(result == null)
          result = caseListValue(declarativeListValue) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(declarativeListValue) ;
        if(result == null)
          result = casePropertyExpression(declarativeListValue) ;
        if(result == null)
          result = caseElement(declarativeListValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_PROPERTY_EXPRESSION :
      {
        DeclarativePropertyExpression declarativePropertyExpression =
                                                                    (DeclarativePropertyExpression) theEObject ;
        T result = caseDeclarativePropertyExpression(
                                                     declarativePropertyExpression) ;
        if(result == null)
          result = casePropertyExpression(declarativePropertyExpression) ;
        if(result == null)
          result = caseElement(declarativePropertyExpression) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_STRING_LITERAL :
      {
        DeclarativeStringLiteral declarativeStringLiteral =
                                                          (DeclarativeStringLiteral) theEObject ;
        T result = caseDeclarativeStringLiteral(declarativeStringLiteral) ;
        if(result == null)
          result = caseBehaviorStringLiteral(declarativeStringLiteral) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(declarativeStringLiteral) ;
        if(result == null)
          result = caseStringLiteral(declarativeStringLiteral) ;
        if(result == null)
          result = caseLiteral(declarativeStringLiteral) ;
        if(result == null)
          result = casePropertyValue(declarativeStringLiteral) ;
        if(result == null)
          result = caseIntegerValueConstant(declarativeStringLiteral) ;
        if(result == null)
          result = casePropertyExpression(declarativeStringLiteral) ;
        if(result == null)
          result = caseValueConstant(declarativeStringLiteral) ;
        if(result == null)
          result = caseValue(declarativeStringLiteral) ;
        if(result == null)
          result = caseIntegerValue(declarativeStringLiteral) ;
        if(result == null)
          result = caseBehaviorElement(declarativeStringLiteral) ;
        if(result == null)
          result = caseElement(declarativeStringLiteral) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_INTEGER_LITERAL :
      {
        DeclarativeIntegerLiteral declarativeIntegerLiteral =
                                                            (DeclarativeIntegerLiteral) theEObject ;
        T result = caseDeclarativeIntegerLiteral(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseBehaviorIntegerLiteral(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(
                                                     declarativeIntegerLiteral) ;
        if(result == null)
          result = caseIntegerLiteral(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseNumericLiteral(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseNumberValue(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseLiteral(declarativeIntegerLiteral) ;
        if(result == null)
          result = casePropertyValue(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseIntegerValueConstant(declarativeIntegerLiteral) ;
        if(result == null)
          result = casePropertyExpression(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseValueConstant(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseValue(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseIntegerValue(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseBehaviorElement(declarativeIntegerLiteral) ;
        if(result == null)
          result = caseElement(declarativeIntegerLiteral) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_REAL_LITERAL :
      {
        DeclarativeRealLiteral declarativeRealLiteral =
                                                      (DeclarativeRealLiteral) theEObject ;
        T result = caseDeclarativeRealLiteral(declarativeRealLiteral) ;
        if(result == null)
          result = caseBehaviorRealLiteral(declarativeRealLiteral) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(declarativeRealLiteral) ;
        if(result == null)
          result = caseRealLiteral(declarativeRealLiteral) ;
        if(result == null)
          result = caseNumericLiteral(declarativeRealLiteral) ;
        if(result == null)
          result = caseNumberValue(declarativeRealLiteral) ;
        if(result == null)
          result = caseLiteral(declarativeRealLiteral) ;
        if(result == null)
          result = casePropertyValue(declarativeRealLiteral) ;
        if(result == null)
          result = caseIntegerValueConstant(declarativeRealLiteral) ;
        if(result == null)
          result = casePropertyExpression(declarativeRealLiteral) ;
        if(result == null)
          result = caseValueConstant(declarativeRealLiteral) ;
        if(result == null)
          result = caseValue(declarativeRealLiteral) ;
        if(result == null)
          result = caseIntegerValue(declarativeRealLiteral) ;
        if(result == null)
          result = caseBehaviorElement(declarativeRealLiteral) ;
        if(result == null)
          result = caseElement(declarativeRealLiteral) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_RECORD_VALUE :
      {
        DeclarativeRecordValue declarativeRecordValue =
                                                      (DeclarativeRecordValue) theEObject ;
        T result = caseDeclarativeRecordValue(declarativeRecordValue) ;
        if(result == null)
          result = caseRecordValue(declarativeRecordValue) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(declarativeRecordValue) ;
        if(result == null)
          result = casePropertyValue(declarativeRecordValue) ;
        if(result == null)
          result = casePropertyExpression(declarativeRecordValue) ;
        if(result == null)
          result = caseElement(declarativeRecordValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION :
      {
        DeclarativeBasicPropertyAssociation declarativeBasicPropertyAssociation =
                                                                                (DeclarativeBasicPropertyAssociation) theEObject ;
        T result = caseDeclarativeBasicPropertyAssociation(
                                                           declarativeBasicPropertyAssociation) ;
        if(result == null)
          result = caseBasicPropertyAssociation(
                                                declarativeBasicPropertyAssociation) ;
        if(result == null)
          result = caseElement(declarativeBasicPropertyAssociation) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_BOOLEAN_LITERAL :
      {
        DeclarativeBooleanLiteral declarativeBooleanLiteral =
                                                            (DeclarativeBooleanLiteral) theEObject ;
        T result = caseDeclarativeBooleanLiteral(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseBehaviorBooleanLiteral(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(
                                                     declarativeBooleanLiteral) ;
        if(result == null)
          result = caseBooleanLiteral(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseLiteral(declarativeBooleanLiteral) ;
        if(result == null)
          result = casePropertyValue(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseIntegerValueConstant(declarativeBooleanLiteral) ;
        if(result == null)
          result = casePropertyExpression(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseValueConstant(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseValue(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseIntegerValue(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseBehaviorElement(declarativeBooleanLiteral) ;
        if(result == null)
          result = caseElement(declarativeBooleanLiteral) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_RANGE_VALUE :
      {
        DeclarativeRangeValue declarativeRangeValue =
                                                    (DeclarativeRangeValue) theEObject ;
        T result = caseDeclarativeRangeValue(declarativeRangeValue) ;
        if(result == null)
          result = caseRangeValue(declarativeRangeValue) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(declarativeRangeValue) ;
        if(result == null)
          result = casePropertyValue(declarativeRangeValue) ;
        if(result == null)
          result = casePropertyExpression(declarativeRangeValue) ;
        if(result == null)
          result = caseElement(declarativeRangeValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_REFERENCE_VALUE :
      {
        DeclarativeReferenceValue declarativeReferenceValue =
                                                            (DeclarativeReferenceValue) theEObject ;
        T result = caseDeclarativeReferenceValue(declarativeReferenceValue) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(
                                                     declarativeReferenceValue) ;
        if(result == null)
          result = casePropertyExpression(declarativeReferenceValue) ;
        if(result == null)
          result = caseElement(declarativeReferenceValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      case DeclarativePackage.DECLARATIVE_CLASSIFIER_VALUE :
      {
        DeclarativeClassifierValue declarativeClassifierValue =
                                                              (DeclarativeClassifierValue) theEObject ;
        T result = caseDeclarativeClassifierValue(declarativeClassifierValue) ;
        if(result == null)
          result = caseDeclarativePropertyExpression(
                                                     declarativeClassifierValue) ;
        if(result == null)
          result = casePropertyExpression(declarativeClassifierValue) ;
        if(result == null)
          result = caseElement(declarativeClassifierValue) ;
        if(result == null)
          result = defaultCase(theEObject) ;
        return result ;
      }
      default :
        return defaultCase(theEObject) ;
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arrayable Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arrayable Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayableIdentifier(ArrayableIdentifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Comm Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comm Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommAction(CommAction object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeArrayDimension(DeclarativeArrayDimension object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeBehaviorElement(DeclarativeBehaviorElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeBehaviorTransition(
                                             DeclarativeBehaviorTransition object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativePropertyName(DeclarativePropertyName object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativePropertyReference(DeclarativePropertyReference object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeTime(DeclarativeTime object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifier(Identifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedValue(NamedValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNamedElement(QualifiedNamedElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReference(Reference object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativePropertyAssociation(
                                              DeclarativePropertyAssociation object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeListValue(DeclarativeListValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativePropertyExpression(
                                             DeclarativePropertyExpression object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeStringLiteral(DeclarativeStringLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeIntegerLiteral(DeclarativeIntegerLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeRealLiteral(DeclarativeRealLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeRecordValue(DeclarativeRecordValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeBasicPropertyAssociation(
                                                   DeclarativeBasicPropertyAssociation object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeBooleanLiteral(DeclarativeBooleanLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeRangeValue(DeclarativeRangeValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeReferenceValue(DeclarativeReferenceValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarativeClassifierValue(DeclarativeClassifierValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorElement(BehaviorElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorNamedElement(BehaviorNamedElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorState(BehaviorState object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Actions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Actions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActions(BehaviorActions object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorAction(BehaviorAction object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicAction(BasicAction object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Communication Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Communication Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommunicationAction(CommunicationAction object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayDimension(ArrayDimension object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorTransition(BehaviorTransition object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorTime(BehaviorTime object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTriggerCondition(DispatchTriggerCondition object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Relative Timeout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchRelativeTimeout(DispatchRelativeTimeout object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Completion Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Completion Relative Timeout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompletionRelativeTimeout(CompletionRelativeTimeout object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamespace(Namespace object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifier(Classifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subcomponent Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subcomponent Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubcomponentType(SubcomponentType object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureClassifier(FeatureClassifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentClassifier(ComponentClassifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseData(Data object)
  {
    return null ;
  }

  /**
  	 * Returns the result of interpreting the object as an instance of '<em>Data Subcomponent Type</em>'.
  	 * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
  	 * @param object the target of the switch.
  	 * @return the result of interpreting the object as an instance of '<em>Data Subcomponent Type</em>'.
  	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
  	 * @generated
  	 */
  public T caseDataSubcomponentType(DataSubcomponentType object)
  {
    return null ;
  }

  /**
  	 * Returns the result of interpreting the object as an instance of '<em>Data Classifier</em>'.
  	 * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
  	 * @param object the target of the switch.
  	 * @return the result of interpreting the object as an instance of '<em>Data Classifier</em>'.
  	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
  	 * @generated
  	 */
  public T caseDataClassifier(DataClassifier object)
  {
    return null ;
  }

  /**
  	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
  	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
  	 * @param object the target of the switch.
  	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
  	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
  	 * @generated
  	 */
  public T caseValue(Value object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueConstant(ValueConstant object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValue(IntegerValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValueConstant(IntegerValueConstant object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Processor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Processor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessor(Processor object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Processor Subcomponent Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Processor Subcomponent Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessorSubcomponentType(ProcessorSubcomponentType object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Processor Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Processor Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessorClassifier(ProcessorClassifier object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedElement(TypedElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Property</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicProperty(BasicProperty object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Named Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Named Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractNamedValue(AbstractNamedValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProperty(Property object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationLiteral(EnumerationLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitLiteral(UnitLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueVariable(ValueVariable object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValueVariable(IntegerValueVariable object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indexable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indexable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexableElement(IndexableElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementHolder(ElementHolder object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Feature Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Feature Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierFeatureHolder(ClassifierFeatureHolder object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Groupable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Groupable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupableElement(GroupableElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureHolder(FeatureHolder object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortHolder(PortHolder object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actual Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actual Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActualPortHolder(ActualPortHolder object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementValues(ElementValues object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterLabel(ParameterLabel object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTarget(Target object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTrigger(DispatchTrigger object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchTrigger(ModeSwitchTrigger object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Containment Path Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Containment Path Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContainmentPathElement(ContainmentPathElement object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyExpression(PropertyExpression object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListValue(ListValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyValue(PropertyValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteral(StringLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior String Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorStringLiteral(BehaviorStringLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberValue(NumberValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteral(IntegerLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericLiteral(NumericLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Integer Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteral(RealLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Real Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorRealLiteral(BehaviorRealLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordValue(RecordValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicPropertyAssociation(BasicPropertyAssociation object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteral(BooleanLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Boolean Literal</em>'.
   * <!-- begin-user-doc -->
  	 * This implementation returns null;
  	 * returning a non-null result will terminate the switch.
  	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeValue(RangeValue object)
  {
    return null ;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null ;
  }

} //DeclarativeSwitch
