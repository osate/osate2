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

package org.osate.ba.declarative.impl ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.impl.EFactoryImpl ;

import org.eclipse.emf.ecore.plugin.EcorePlugin ;
import org.osate.ba.declarative.* ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarativeFactoryImpl extends EFactoryImpl implements
                                    DeclarativeFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DeclarativeFactory init()
  {
    try
    {
      DeclarativeFactory theDeclarativeFactory =
                                               (DeclarativeFactory) EPackage.Registry.INSTANCE.getEFactory(DeclarativePackage.eNS_URI) ;
      if(theDeclarativeFactory != null)
      {
        return theDeclarativeFactory ;
      }
    }
    catch(Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception) ;
    }
    return new DeclarativeFactoryImpl() ;
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarativeFactoryImpl()
  {
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch ( eClass.getClassifierID() )
    {
      case DeclarativePackage.ARRAYABLE_IDENTIFIER :
        return createArrayableIdentifier() ;
      case DeclarativePackage.COMM_ACTION :
        return createCommAction() ;
      case DeclarativePackage.DECLARATIVE_ARRAY_DIMENSION :
        return createDeclarativeArrayDimension() ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION :
        return createDeclarativeBehaviorTransition() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME :
        return createDeclarativePropertyName() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE :
        return createDeclarativePropertyReference() ;
      case DeclarativePackage.DECLARATIVE_TIME :
        return createDeclarativeTime() ;
      case DeclarativePackage.IDENTIFIER :
        return createIdentifier() ;
      case DeclarativePackage.NAMED_VALUE :
        return createNamedValue() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT :
        return createQualifiedNamedElement() ;
      case DeclarativePackage.REFERENCE :
        return createReference() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION :
        return createDeclarativePropertyAssociation() ;
      case DeclarativePackage.DECLARATIVE_LIST_VALUE :
        return createDeclarativeListValue() ;
      case DeclarativePackage.DECLARATIVE_STRING_LITERAL :
        return createDeclarativeStringLiteral() ;
      case DeclarativePackage.DECLARATIVE_INTEGER_LITERAL :
        return createDeclarativeIntegerLiteral() ;
      case DeclarativePackage.DECLARATIVE_REAL_LITERAL :
        return createDeclarativeRealLiteral() ;
      case DeclarativePackage.DECLARATIVE_RECORD_VALUE :
        return createDeclarativeRecordValue() ;
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION :
        return createDeclarativeBasicPropertyAssociation() ;
      case DeclarativePackage.DECLARATIVE_BOOLEAN_LITERAL :
        return createDeclarativeBooleanLiteral() ;
      case DeclarativePackage.DECLARATIVE_RANGE_VALUE :
        return createDeclarativeRangeValue() ;
      case DeclarativePackage.DECLARATIVE_REFERENCE_VALUE :
        return createDeclarativeReferenceValue() ;
      case DeclarativePackage.DECLARATIVE_CLASSIFIER_VALUE :
        return createDeclarativeClassifierValue() ;
      default :
        throw new IllegalArgumentException("The class '" + eClass.getName() +
                                           "' is not a valid classifier") ;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArrayableIdentifier createArrayableIdentifier()
  {
    ArrayableIdentifierImpl arrayableIdentifier =
                                                new ArrayableIdentifierImpl() ;
    return arrayableIdentifier ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CommAction createCommAction()
  {
    CommActionImpl commAction = new CommActionImpl() ;
    return commAction ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeArrayDimension createDeclarativeArrayDimension()
  {
    DeclarativeArrayDimensionImpl declarativeArrayDimension =
                                                            new DeclarativeArrayDimensionImpl() ;
    return declarativeArrayDimension ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeBehaviorTransition createDeclarativeBehaviorTransition()
  {
    DeclarativeBehaviorTransitionImpl declarativeBehaviorTransition =
                                                                    new DeclarativeBehaviorTransitionImpl() ;
    return declarativeBehaviorTransition ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativePropertyName createDeclarativePropertyName()
  {
    DeclarativePropertyNameImpl declarativePropertyName =
                                                        new DeclarativePropertyNameImpl() ;
    return declarativePropertyName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativePropertyReference createDeclarativePropertyReference()
  {
    DeclarativePropertyReferenceImpl declarativePropertyReference =
                                                                  new DeclarativePropertyReferenceImpl() ;
    return declarativePropertyReference ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeTime createDeclarativeTime()
  {
    DeclarativeTimeImpl declarativeTime = new DeclarativeTimeImpl() ;
    return declarativeTime ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl() ;
    return identifier ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedValue createNamedValue()
  {
    NamedValueImpl namedValue = new NamedValueImpl() ;
    return namedValue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNamedElement createQualifiedNamedElement()
  {
    QualifiedNamedElementImpl qualifiedNamedElement =
                                                    new QualifiedNamedElementImpl() ;
    return qualifiedNamedElement ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl() ;
    return reference ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativePropertyAssociation createDeclarativePropertyAssociation()
  {
    DeclarativePropertyAssociationImpl declarativePropertyAssociation =
                                                                      new DeclarativePropertyAssociationImpl() ;
    return declarativePropertyAssociation ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeListValue createDeclarativeListValue()
  {
    DeclarativeListValueImpl declarativeListValue =
                                                  new DeclarativeListValueImpl() ;
    return declarativeListValue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeStringLiteral createDeclarativeStringLiteral()
  {
    DeclarativeStringLiteralImpl declarativeStringLiteral =
                                                          new DeclarativeStringLiteralImpl() ;
    return declarativeStringLiteral ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeIntegerLiteral createDeclarativeIntegerLiteral()
  {
    DeclarativeIntegerLiteralImpl declarativeIntegerLiteral =
                                                            new DeclarativeIntegerLiteralImpl() ;
    return declarativeIntegerLiteral ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeRealLiteral createDeclarativeRealLiteral()
  {
    DeclarativeRealLiteralImpl declarativeRealLiteral =
                                                      new DeclarativeRealLiteralImpl() ;
    return declarativeRealLiteral ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeRecordValue createDeclarativeRecordValue()
  {
    DeclarativeRecordValueImpl declarativeRecordValue =
                                                      new DeclarativeRecordValueImpl() ;
    return declarativeRecordValue ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeBasicPropertyAssociation
         createDeclarativeBasicPropertyAssociation()
  {
    DeclarativeBasicPropertyAssociationImpl declarativeBasicPropertyAssociation =
                                                                                new DeclarativeBasicPropertyAssociationImpl() ;
    return declarativeBasicPropertyAssociation ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeBooleanLiteral createDeclarativeBooleanLiteral()
  {
    DeclarativeBooleanLiteralImpl declarativeBooleanLiteral =
                                                            new DeclarativeBooleanLiteralImpl() ;
    return declarativeBooleanLiteral ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeRangeValue createDeclarativeRangeValue()
  {
    DeclarativeRangeValueImpl declarativeRangeValue =
                                                    new DeclarativeRangeValueImpl() ;
    return declarativeRangeValue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeReferenceValue createDeclarativeReferenceValue()
  {
    DeclarativeReferenceValueImpl declarativeReferenceValue =
                                                            new DeclarativeReferenceValueImpl() ;
    return declarativeReferenceValue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativeClassifierValue createDeclarativeClassifierValue()
  {
    DeclarativeClassifierValueImpl declarativeClassifierValue =
                                                              new DeclarativeClassifierValueImpl() ;
    return declarativeClassifierValue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativePackage getDeclarativePackage()
  {
    return (DeclarativePackage) getEPackage() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DeclarativePackage getPackage()
  {
    return DeclarativePackage.eINSTANCE ;
  }

} //DeclarativeFactoryImpl
