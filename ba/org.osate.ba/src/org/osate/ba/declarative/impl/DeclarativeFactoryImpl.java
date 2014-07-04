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
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
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
            (DeclarativeFactory) EPackage.Registry.INSTANCE
                  .getEFactory(DeclarativePackage.eNS_URI) ;
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
  public ArrayableIdentifier createArrayableIdentifier()
  {
    ArrayableIdentifierImpl arrayableIdentifier = new ArrayableIdentifierImpl() ;
    return arrayableIdentifier ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
