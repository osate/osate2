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

package org.osate.ba.declarative ;

import org.eclipse.emf.ecore.EAttribute ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EPackage ;
import org.eclipse.emf.ecore.EReference ;

import org.osate.aadl2.Aadl2Package ;
import org.osate.ba.aadlba.AadlBaPackage ;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.ba.declarative.DeclarativeFactory
 * @model kind="package"
 * @generated
 */
public interface DeclarativePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "declarative" ;

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "https://github.com/osate/osate2-ba.git/declarative" ;

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "declarative" ;

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DeclarativePackage eINSTANCE =
                               org.osate.ba.declarative.impl.DeclarativePackageImpl.init() ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.IdentifierImpl <em>Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.IdentifierImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getIdentifier()
   * @generated
   */
  int IDENTIFIER = 8 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__OWNED_ELEMENT = AadlBaPackage.BEHAVIOR_STATE__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__OWNED_COMMENT = AadlBaPackage.BEHAVIOR_STATE__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__NAME = AadlBaPackage.BEHAVIOR_STATE__NAME ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__QUALIFIED_NAME =
                                 AadlBaPackage.BEHAVIOR_STATE__QUALIFIED_NAME ;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__OWNED_PROPERTY_ASSOCIATION =
                                             AadlBaPackage.BEHAVIOR_STATE__OWNED_PROPERTY_ASSOCIATION ;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__INITIAL = AadlBaPackage.BEHAVIOR_STATE__INITIAL ;

  /**
   * The feature id for the '<em><b>Complete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__COMPLETE = AadlBaPackage.BEHAVIOR_STATE__COMPLETE ;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__FINAL = AadlBaPackage.BEHAVIOR_STATE__FINAL ;

  /**
   * The feature id for the '<em><b>Binded Mode</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__BINDED_MODE = AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE ;

  /**
   * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__INCOMING_TRANSITIONS =
                                       AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS ;

  /**
   * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__OUTGOING_TRANSITIONS =
                                       AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__OSATE_REF = AadlBaPackage.BEHAVIOR_STATE_FEATURE_COUNT + 0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__BA_REF = AadlBaPackage.BEHAVIOR_STATE_FEATURE_COUNT + 1 ;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__ID = AadlBaPackage.BEHAVIOR_STATE_FEATURE_COUNT + 2 ;

  /**
   * The number of structural features of the '<em>Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_FEATURE_COUNT = AadlBaPackage.BEHAVIOR_STATE_FEATURE_COUNT +
                                 3 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.ArrayableIdentifierImpl <em>Arrayable Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.ArrayableIdentifierImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getArrayableIdentifier()
   * @generated
   */
  int ARRAYABLE_IDENTIFIER = 0 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__OWNED_ELEMENT = IDENTIFIER__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__OWNED_COMMENT = IDENTIFIER__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__NAME = IDENTIFIER__NAME ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__QUALIFIED_NAME = IDENTIFIER__QUALIFIED_NAME ;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__OWNED_PROPERTY_ASSOCIATION =
                                                       IDENTIFIER__OWNED_PROPERTY_ASSOCIATION ;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__INITIAL = IDENTIFIER__INITIAL ;

  /**
   * The feature id for the '<em><b>Complete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__COMPLETE = IDENTIFIER__COMPLETE ;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__FINAL = IDENTIFIER__FINAL ;

  /**
   * The feature id for the '<em><b>Binded Mode</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__BINDED_MODE = IDENTIFIER__BINDED_MODE ;

  /**
   * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__INCOMING_TRANSITIONS =
                                                 IDENTIFIER__INCOMING_TRANSITIONS ;

  /**
   * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__OUTGOING_TRANSITIONS =
                                                 IDENTIFIER__OUTGOING_TRANSITIONS ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__OSATE_REF = IDENTIFIER__OSATE_REF ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__BA_REF = IDENTIFIER__BA_REF ;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__ID = IDENTIFIER__ID ;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER__ARRAY_INDEXES = IDENTIFIER_FEATURE_COUNT + 0 ;

  /**
   * The number of structural features of the '<em>Arrayable Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAYABLE_IDENTIFIER_FEATURE_COUNT = IDENTIFIER_FEATURE_COUNT + 1 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.CommActionImpl <em>Comm Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.CommActionImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getCommAction()
   * @generated
   */
  int COMM_ACTION = 1 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__OWNED_ELEMENT =
                                 AadlBaPackage.COMMUNICATION_ACTION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__OWNED_COMMENT =
                                 AadlBaPackage.COMMUNICATION_ACTION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__OSATE_REF =
                             AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                               0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__BA_REF = AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                            1 ;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__PARAMETERS =
                              AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                                2 ;

  /**
   * The feature id for the '<em><b>Port Freeze</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__PORT_FREEZE =
                               AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                                 3 ;

  /**
   * The feature id for the '<em><b>Port Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__PORT_DEQUEUE =
                                AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                                  4 ;

  /**
   * The feature id for the '<em><b>Lock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__LOCK = AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT + 5 ;

  /**
   * The feature id for the '<em><b>Unlock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__UNLOCK = AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                            6 ;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__TARGET = AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                            7 ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__QUALIFIED_NAME =
                                  AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                                    8 ;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION__REFERENCE =
                             AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                               9 ;

  /**
   * The number of structural features of the '<em>Comm Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMM_ACTION_FEATURE_COUNT =
                                AadlBaPackage.COMMUNICATION_ACTION_FEATURE_COUNT +
                                  10 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeArrayDimensionImpl <em>Array Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeArrayDimensionImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeArrayDimension()
   * @generated
   */
  int DECLARATIVE_ARRAY_DIMENSION = 2 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__OWNED_ELEMENT =
                                                 Aadl2Package.ARRAY_DIMENSION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__OWNED_COMMENT =
                                                 Aadl2Package.ARRAY_DIMENSION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__SIZE = Aadl2Package.ARRAY_DIMENSION__SIZE ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__OSATE_REF =
                                             Aadl2Package.ARRAY_DIMENSION_FEATURE_COUNT +
                                               0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__BA_REF =
                                          Aadl2Package.ARRAY_DIMENSION_FEATURE_COUNT +
                                            1 ;

  /**
   * The feature id for the '<em><b>Dimension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION__DIMENSION =
                                             Aadl2Package.ARRAY_DIMENSION_FEATURE_COUNT +
                                               2 ;

  /**
   * The number of structural features of the '<em>Array Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_ARRAY_DIMENSION_FEATURE_COUNT =
                                                Aadl2Package.ARRAY_DIMENSION_FEATURE_COUNT +
                                                  3 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeBehaviorElementImpl <em>Behavior Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeBehaviorElementImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBehaviorElement()
   * @generated
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT = 3 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_ELEMENT =
                                                  AadlBaPackage.BEHAVIOR_ELEMENT__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_COMMENT =
                                                  AadlBaPackage.BEHAVIOR_ELEMENT__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF =
                                              AadlBaPackage.BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF =
                                           AadlBaPackage.BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                             1 ;

  /**
   * The number of structural features of the '<em>Behavior Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT =
                                                 AadlBaPackage.BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                   2 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl <em>Behavior Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBehaviorTransition()
   * @generated
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION = 4 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__OWNED_ELEMENT =
                                                     AadlBaPackage.BEHAVIOR_TRANSITION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__OWNED_COMMENT =
                                                     AadlBaPackage.BEHAVIOR_TRANSITION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__NAME =
                                            AadlBaPackage.BEHAVIOR_TRANSITION__NAME ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__QUALIFIED_NAME =
                                                      AadlBaPackage.BEHAVIOR_TRANSITION__QUALIFIED_NAME ;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__OWNED_PROPERTY_ASSOCIATION =
                                                                  AadlBaPackage.BEHAVIOR_TRANSITION__OWNED_PROPERTY_ASSOCIATION ;

  /**
   * The feature id for the '<em><b>Source State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__SOURCE_STATE =
                                                    AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE ;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__CONDITION =
                                                 AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION ;

  /**
   * The feature id for the '<em><b>Destination State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__DESTINATION_STATE =
                                                         AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE ;

  /**
   * The feature id for the '<em><b>Action Block</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__ACTION_BLOCK =
                                                    AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK ;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__PRIORITY =
                                                AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF =
                                                 AadlBaPackage.BEHAVIOR_TRANSITION_FEATURE_COUNT +
                                                   0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF =
                                              AadlBaPackage.BEHAVIOR_TRANSITION_FEATURE_COUNT +
                                                1 ;

  /**
   * The feature id for the '<em><b>Src States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES =
                                                  AadlBaPackage.BEHAVIOR_TRANSITION_FEATURE_COUNT +
                                                    2 ;

  /**
   * The feature id for the '<em><b>Dest State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE =
                                                  AadlBaPackage.BEHAVIOR_TRANSITION_FEATURE_COUNT +
                                                    3 ;

  /**
   * The number of structural features of the '<em>Behavior Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BEHAVIOR_TRANSITION_FEATURE_COUNT =
                                                    AadlBaPackage.BEHAVIOR_TRANSITION_FEATURE_COUNT +
                                                      4 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyNameImpl <em>Property Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativePropertyNameImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyName()
   * @generated
   */
  int DECLARATIVE_PROPERTY_NAME = 5 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__OWNED_ELEMENT =
                                               DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__OWNED_COMMENT =
                                               DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__OSATE_REF =
                                           DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__BA_REF = DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;

  /**
   * The feature id for the '<em><b>Property Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME =
                                               DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                 0 ;

  /**
   * The feature id for the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__FIELD =
                                       DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                         1 ;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME__INDEXES =
                                         DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                           2 ;

  /**
   * The number of structural features of the '<em>Property Name</em>' class.
   * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_NAME_FEATURE_COUNT =
                                              DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                3 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl <em>Property Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyReference()
   * @generated
   */
  int DECLARATIVE_PROPERTY_REFERENCE = 6 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__OWNED_ELEMENT =
                                                    DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__OWNED_COMMENT =
                                                    DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__OSATE_REF =
                                                DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__BA_REF =
                                             DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME =
                                                     DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                       0 ;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__REFERENCE =
                                                DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                  1 ;

  /**
   * The feature id for the '<em><b>Property Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES =
                                                     DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                       2 ;

  /**
   * The feature id for the '<em><b>Property Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET =
                                                   DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                     3 ;

  /**
   * The number of structural features of the '<em>Property Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_REFERENCE_FEATURE_COUNT =
                                                   DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                     4 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeTimeImpl <em>Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeTimeImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeTime()
   * @generated
   */
  int DECLARATIVE_TIME = 7 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__OWNED_ELEMENT =
                                      AadlBaPackage.BEHAVIOR_TIME__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__OWNED_COMMENT =
                                      AadlBaPackage.BEHAVIOR_TIME__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__INTEGER_VALUE =
                                      AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE ;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__UNIT = AadlBaPackage.BEHAVIOR_TIME__UNIT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__OSATE_REF = AadlBaPackage.BEHAVIOR_TIME_FEATURE_COUNT +
                                    0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__BA_REF = AadlBaPackage.BEHAVIOR_TIME_FEATURE_COUNT + 1 ;

  /**
   * The feature id for the '<em><b>Unit Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME__UNIT_ID = AadlBaPackage.BEHAVIOR_TIME_FEATURE_COUNT +
                                  2 ;

  /**
   * The number of structural features of the '<em>Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_TIME_FEATURE_COUNT =
                                     AadlBaPackage.BEHAVIOR_TIME_FEATURE_COUNT +
                                       3 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.QualifiedNamedElementImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getQualifiedNamedElement()
   * @generated
   */
  int QUALIFIED_NAMED_ELEMENT = 10 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.NamedValueImpl <em>Named Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.NamedValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getNamedValue()
   * @generated
   */
  int NAMED_VALUE = 9 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__OWNED_ELEMENT =
                                 AadlBaPackage.INTEGER_VALUE_VARIABLE__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__OWNED_COMMENT =
                                 AadlBaPackage.INTEGER_VALUE_VARIABLE__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__OSATE_REF =
                             AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                               0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__BA_REF = AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                            1 ;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__REFERENCE =
                             AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                               2 ;

  /**
   * The feature id for the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__DEQUEUE =
                           AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                             3 ;

  /**
   * The feature id for the '<em><b>Fresh</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__FRESH = AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                           4 ;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE__COUNT = AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                           5 ;

  /**
   * The number of structural features of the '<em>Named Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_VALUE_FEATURE_COUNT =
                                AadlBaPackage.INTEGER_VALUE_VARIABLE_FEATURE_COUNT +
                                  6 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_ELEMENT =
                                             Aadl2Package.DATA_CLASSIFIER__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_COMMENT =
                                             Aadl2Package.DATA_CLASSIFIER__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NAME = Aadl2Package.DATA_CLASSIFIER__NAME ;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__QUALIFIED_NAME =
                                              Aadl2Package.DATA_CLASSIFIER__QUALIFIED_NAME ;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION =
                                                          Aadl2Package.DATA_CLASSIFIER__OWNED_PROPERTY_ASSOCIATION ;

  /**
   * The feature id for the '<em><b>Owned Member</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_MEMBER =
                                            Aadl2Package.DATA_CLASSIFIER__OWNED_MEMBER ;

  /**
   * The feature id for the '<em><b>Member</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__MEMBER = Aadl2Package.DATA_CLASSIFIER__MEMBER ;

  /**
   * The feature id for the '<em><b>Classifier Feature</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__CLASSIFIER_FEATURE =
                                                  Aadl2Package.DATA_CLASSIFIER__CLASSIFIER_FEATURE ;

  /**
   * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__INHERITED_MEMBER =
                                                Aadl2Package.DATA_CLASSIFIER__INHERITED_MEMBER ;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__GENERALIZATION =
                                              Aadl2Package.DATA_CLASSIFIER__GENERALIZATION ;

  /**
   * The feature id for the '<em><b>General</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__GENERAL = Aadl2Package.DATA_CLASSIFIER__GENERAL ;

  /**
   * The feature id for the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_ANNEX_SUBCLAUSE =
                                                     Aadl2Package.DATA_CLASSIFIER__OWNED_ANNEX_SUBCLAUSE ;

  /**
   * The feature id for the '<em><b>Owned Prototype</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_PROTOTYPE =
                                               Aadl2Package.DATA_CLASSIFIER__OWNED_PROTOTYPE ;

  /**
   * The feature id for the '<em><b>Owned Prototype Binding</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_PROTOTYPE_BINDING =
                                                       Aadl2Package.DATA_CLASSIFIER__OWNED_PROTOTYPE_BINDING ;

  /**
   * The feature id for the '<em><b>No Prototypes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NO_PROTOTYPES =
                                             Aadl2Package.DATA_CLASSIFIER__NO_PROTOTYPES ;

  /**
   * The feature id for the '<em><b>No Annexes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NO_ANNEXES =
                                          Aadl2Package.DATA_CLASSIFIER__NO_ANNEXES ;

  /**
   * The feature id for the '<em><b>No Properties</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NO_PROPERTIES =
                                             Aadl2Package.DATA_CLASSIFIER__NO_PROPERTIES ;

  /**
   * The feature id for the '<em><b>Owned Mode</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_MODE =
                                          Aadl2Package.DATA_CLASSIFIER__OWNED_MODE ;

  /**
   * The feature id for the '<em><b>Owned Mode Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_MODE_TRANSITION =
                                                     Aadl2Package.DATA_CLASSIFIER__OWNED_MODE_TRANSITION ;

  /**
   * The feature id for the '<em><b>Derived Modes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__DERIVED_MODES =
                                             Aadl2Package.DATA_CLASSIFIER__DERIVED_MODES ;

  /**
   * The feature id for the '<em><b>No Flows</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NO_FLOWS =
                                        Aadl2Package.DATA_CLASSIFIER__NO_FLOWS ;

  /**
   * The feature id for the '<em><b>No Modes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__NO_MODES =
                                        Aadl2Package.DATA_CLASSIFIER__NO_MODES ;

  /**
  	 * The feature id for the '<em><b>Osate Ref</b></em>' reference.
  	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
  	 * @generated
  	 * @ordered
  	 */
  int QUALIFIED_NAMED_ELEMENT__OSATE_REF =
                                         Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                           0 ;

  /**
  	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
  	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
  	 * @generated
  	 * @ordered
  	 */
  int QUALIFIED_NAMED_ELEMENT__BA_REF =
                                      Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                        1 ;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__TYPE =
                                    Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                      2 ;

  /**
   * The feature id for the '<em><b>Referenced Property Type</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE =
                                                        Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                                          3 ;

  /**
   * The feature id for the '<em><b>Owned Property Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE =
                                                   Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                                     4 ;

  /**
   * The feature id for the '<em><b>Property Type</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__PROPERTY_TYPE =
                                             Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                               5 ;

  /**
   * The feature id for the '<em><b>Inherit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__INHERIT =
                                       Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                         6 ;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE =
                                             Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                               7 ;

  /**
   * The feature id for the '<em><b>Applies To Metaclass</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS =
                                                    Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                                      8 ;

  /**
   * The feature id for the '<em><b>Applies To Classifier</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER =
                                                     Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                                       9 ;

  /**
   * The feature id for the '<em><b>Applies To</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__APPLIES_TO =
                                          Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                            10 ;

  /**
   * The feature id for the '<em><b>Empty List Default</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT =
                                                  Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                                    11 ;

  /**
   * The feature id for the '<em><b>Base Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__BASE_UNIT =
                                         Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                           12 ;

  /**
   * The feature id for the '<em><b>Factor</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__FACTOR =
                                      Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                        13 ;

  /**
   * The feature id for the '<em><b>Ba Namespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE =
                                            Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                              14 ;

  /**
   * The feature id for the '<em><b>Ba Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT__BA_NAME =
                                       Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                         15 ;

  /**
   * The number of structural features of the '<em>Qualified Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT =
                                            Aadl2Package.DATA_CLASSIFIER_FEATURE_COUNT +
                                              16 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.ReferenceImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 11 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__OWNED_ELEMENT =
                               AadlBaPackage.ACTUAL_PORT_HOLDER__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__OWNED_COMMENT =
                               AadlBaPackage.ACTUAL_PORT_HOLDER__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ELEMENT = AadlBaPackage.ACTUAL_PORT_HOLDER__ELEMENT ;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ARRAY_INDEXES =
                               AadlBaPackage.ACTUAL_PORT_HOLDER__ARRAY_INDEXES ;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__GROUP_HOLDERS =
                               AadlBaPackage.ACTUAL_PORT_HOLDER__GROUP_HOLDERS ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__OSATE_REF = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT +
                             0 ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__BA_REF = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT + 1 ;

  /**
   * The feature id for the '<em><b>Array Range</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ARRAY_RANGE = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT +
                               2 ;

  /**
   * The feature id for the '<em><b>Named Element</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__NAMED_ELEMENT =
                               AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT +
                                 3 ;

  /**
   * The feature id for the '<em><b>Annex Name</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ANNEX_NAME = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT +
                              4 ;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__PATH = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT + 5 ;

  /**
   * The feature id for the '<em><b>Ids</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__IDS = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT + 6 ;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = AadlBaPackage.ACTUAL_PORT_HOLDER_FEATURE_COUNT +
                                7 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl <em>Property Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyAssociation()
   * @generated
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION = 12 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_ELEMENT =
                                                      DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_COMMENT =
                                                      DECLARATIVE_BEHAVIOR_ELEMENT__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__OSATE_REF =
                                                  DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;

  /**
   * The feature id for the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__BA_REF =
                                               DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY =
                                                 DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                   0 ;

  /**
   * The feature id for the '<em><b>Owned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE =
                                                    DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                      1 ;

  /**
   * The number of structural features of the '<em>Property Association</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_ASSOCIATION_FEATURE_COUNT =
                                                     DECLARATIVE_BEHAVIOR_ELEMENT_FEATURE_COUNT +
                                                       2 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeListValueImpl <em>List Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeListValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeListValue()
   * @generated
   */
  int DECLARATIVE_LIST_VALUE = 13 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeStringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeStringLiteralImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeStringLiteral()
   * @generated
   */
  int DECLARATIVE_STRING_LITERAL = 15 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyExpressionImpl <em>Property Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativePropertyExpressionImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyExpression()
   * @generated
   */
  int DECLARATIVE_PROPERTY_EXPRESSION = 14 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_LIST_VALUE__OWNED_ELEMENT =
                                            Aadl2Package.LIST_VALUE__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_LIST_VALUE__OWNED_COMMENT =
                                            Aadl2Package.LIST_VALUE__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Owned List Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_LIST_VALUE__OWNED_LIST_ELEMENT =
                                                 Aadl2Package.LIST_VALUE__OWNED_LIST_ELEMENT ;

  /**
   * The number of structural features of the '<em>List Value</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_LIST_VALUE_FEATURE_COUNT =
                                           Aadl2Package.LIST_VALUE_FEATURE_COUNT +
                                             0 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_EXPRESSION__OWNED_ELEMENT =
                                                     Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_EXPRESSION__OWNED_COMMENT =
                                                     Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT ;

  /**
   * The number of structural features of the '<em>Property Expression</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_PROPERTY_EXPRESSION_FEATURE_COUNT =
                                                    Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT +
                                                      0 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_STRING_LITERAL__OWNED_ELEMENT =
                                                AadlBaPackage.BEHAVIOR_STRING_LITERAL__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_STRING_LITERAL__OWNED_COMMENT =
                                                AadlBaPackage.BEHAVIOR_STRING_LITERAL__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_STRING_LITERAL__VALUE =
                                        AadlBaPackage.BEHAVIOR_STRING_LITERAL__VALUE ;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_STRING_LITERAL_FEATURE_COUNT =
                                               AadlBaPackage.BEHAVIOR_STRING_LITERAL_FEATURE_COUNT +
                                                 0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeIntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeIntegerLiteralImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeIntegerLiteral()
   * @generated
   */
  int DECLARATIVE_INTEGER_LITERAL = 16 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL__OWNED_ELEMENT =
                                                 AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL__OWNED_COMMENT =
                                                 AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL__UNIT =
                                        AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT ;

  /**
   * The feature id for the '<em><b>Base</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL__BASE =
                                        AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE ;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL__VALUE =
                                         AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE ;

  /**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_INTEGER_LITERAL_FEATURE_COUNT =
                                                AadlBaPackage.BEHAVIOR_INTEGER_LITERAL_FEATURE_COUNT +
                                                  0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeRealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeRealLiteralImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRealLiteral()
   * @generated
   */
  int DECLARATIVE_REAL_LITERAL = 17 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REAL_LITERAL__OWNED_ELEMENT =
                                              AadlBaPackage.BEHAVIOR_REAL_LITERAL__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REAL_LITERAL__OWNED_COMMENT =
                                              AadlBaPackage.BEHAVIOR_REAL_LITERAL__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REAL_LITERAL__UNIT =
                                     AadlBaPackage.BEHAVIOR_REAL_LITERAL__UNIT ;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REAL_LITERAL__VALUE =
                                      AadlBaPackage.BEHAVIOR_REAL_LITERAL__VALUE ;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REAL_LITERAL_FEATURE_COUNT =
                                             AadlBaPackage.BEHAVIOR_REAL_LITERAL_FEATURE_COUNT +
                                               0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeRecordValueImpl <em>Record Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeRecordValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRecordValue()
   * @generated
   */
  int DECLARATIVE_RECORD_VALUE = 18 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RECORD_VALUE__OWNED_ELEMENT =
                                              Aadl2Package.RECORD_VALUE__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RECORD_VALUE__OWNED_COMMENT =
                                              Aadl2Package.RECORD_VALUE__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Owned Field Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RECORD_VALUE__OWNED_FIELD_VALUE =
                                                  Aadl2Package.RECORD_VALUE__OWNED_FIELD_VALUE ;

  /**
   * The number of structural features of the '<em>Record Value</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RECORD_VALUE_FEATURE_COUNT =
                                             Aadl2Package.RECORD_VALUE_FEATURE_COUNT +
                                               0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeBasicPropertyAssociationImpl <em>Basic Property Association</em>}' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeBasicPropertyAssociationImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBasicPropertyAssociation()
   * @generated
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION = 19 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__OWNED_ELEMENT =
                                                            Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__OWNED_COMMENT =
                                                            Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__PROPERTY =
                                                       Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY ;

  /**
   * The feature id for the '<em><b>Owned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE =
                                                          Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE ;

  /**
   * The feature id for the '<em><b>Basic Property Name</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME =
                                                                  Aadl2Package.BASIC_PROPERTY_ASSOCIATION_FEATURE_COUNT +
                                                                    0 ;

  /**
   * The number of structural features of the '<em>Basic Property Association</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BASIC_PROPERTY_ASSOCIATION_FEATURE_COUNT =
                                                           Aadl2Package.BASIC_PROPERTY_ASSOCIATION_FEATURE_COUNT +
                                                             1 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeBooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeBooleanLiteralImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBooleanLiteral()
   * @generated
   */
  int DECLARATIVE_BOOLEAN_LITERAL = 20 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BOOLEAN_LITERAL__OWNED_ELEMENT =
                                                 AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BOOLEAN_LITERAL__OWNED_COMMENT =
                                                 AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BOOLEAN_LITERAL__VALUE =
                                         AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE ;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_BOOLEAN_LITERAL_FEATURE_COUNT =
                                                AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL_FEATURE_COUNT +
                                                  0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeRangeValueImpl <em>Range Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeRangeValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRangeValue()
   * @generated
   */
  int DECLARATIVE_RANGE_VALUE = 21 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE__OWNED_ELEMENT =
                                             Aadl2Package.RANGE_VALUE__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE__OWNED_COMMENT =
                                             Aadl2Package.RANGE_VALUE__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Minimum</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE__MINIMUM = Aadl2Package.RANGE_VALUE__MINIMUM ;

  /**
   * The feature id for the '<em><b>Maximum</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE__MAXIMUM = Aadl2Package.RANGE_VALUE__MAXIMUM ;

  /**
   * The feature id for the '<em><b>Delta</b></em>' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE__DELTA = Aadl2Package.RANGE_VALUE__DELTA ;

  /**
   * The number of structural features of the '<em>Range Value</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_RANGE_VALUE_FEATURE_COUNT =
                                            Aadl2Package.RANGE_VALUE_FEATURE_COUNT +
                                              0 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeReferenceValueImpl <em>Reference Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeReferenceValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeReferenceValue()
   * @generated
   */
  int DECLARATIVE_REFERENCE_VALUE = 22 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REFERENCE_VALUE__OWNED_ELEMENT =
                                                 DECLARATIVE_PROPERTY_EXPRESSION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REFERENCE_VALUE__OWNED_COMMENT =
                                                 DECLARATIVE_PROPERTY_EXPRESSION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REFERENCE_VALUE__REF =
                                       DECLARATIVE_PROPERTY_EXPRESSION_FEATURE_COUNT +
                                         0 ;

  /**
   * The number of structural features of the '<em>Reference Value</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_REFERENCE_VALUE_FEATURE_COUNT =
                                                DECLARATIVE_PROPERTY_EXPRESSION_FEATURE_COUNT +
                                                  1 ;

  /**
   * The meta object id for the '{@link org.osate.ba.declarative.impl.DeclarativeClassifierValueImpl <em>Classifier Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.ba.declarative.impl.DeclarativeClassifierValueImpl
   * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeClassifierValue()
   * @generated
   */
  int DECLARATIVE_CLASSIFIER_VALUE = 23 ;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_CLASSIFIER_VALUE__OWNED_ELEMENT =
                                                  DECLARATIVE_PROPERTY_EXPRESSION__OWNED_ELEMENT ;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_CLASSIFIER_VALUE__OWNED_COMMENT =
                                                  DECLARATIVE_PROPERTY_EXPRESSION__OWNED_COMMENT ;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_CLASSIFIER_VALUE__CLASSIFIER =
                                               DECLARATIVE_PROPERTY_EXPRESSION_FEATURE_COUNT +
                                                 0 ;

  /**
   * The number of structural features of the '<em>Classifier Value</em>' class.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATIVE_CLASSIFIER_VALUE_FEATURE_COUNT =
                                                 DECLARATIVE_PROPERTY_EXPRESSION_FEATURE_COUNT +
                                                   1 ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.ArrayableIdentifier <em>Arrayable Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arrayable Identifier</em>'.
   * @see org.osate.ba.declarative.ArrayableIdentifier
   * @generated
   */
  EClass getArrayableIdentifier() ;

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.ba.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Array Indexes</em>'.
   * @see org.osate.ba.declarative.ArrayableIdentifier#getArrayIndexes()
   * @see #getArrayableIdentifier()
   * @generated
   */
  EReference getArrayableIdentifier_ArrayIndexes() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.CommAction <em>Comm Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comm Action</em>'.
   * @see org.osate.ba.declarative.CommAction
   * @generated
   */
  EClass getCommAction() ;

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.ba.declarative.CommAction#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.osate.ba.declarative.CommAction#getParameters()
   * @see #getCommAction()
   * @generated
   */
  EReference getCommAction_Parameters() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.CommAction#isPortFreeze <em>Port Freeze</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Port Freeze</em>'.
   * @see org.osate.ba.declarative.CommAction#isPortFreeze()
   * @see #getCommAction()
   * @generated
   */
  EAttribute getCommAction_PortFreeze() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.CommAction#isPortDequeue <em>Port Dequeue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Port Dequeue</em>'.
   * @see org.osate.ba.declarative.CommAction#isPortDequeue()
   * @see #getCommAction()
   * @generated
   */
  EAttribute getCommAction_PortDequeue() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.CommAction#isLock <em>Lock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lock</em>'.
   * @see org.osate.ba.declarative.CommAction#isLock()
   * @see #getCommAction()
   * @generated
   */
  EAttribute getCommAction_Lock() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.CommAction#isUnlock <em>Unlock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unlock</em>'.
   * @see org.osate.ba.declarative.CommAction#isUnlock()
   * @see #getCommAction()
   * @generated
   */
  EAttribute getCommAction_Unlock() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.CommAction#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.osate.ba.declarative.CommAction#getTarget()
   * @see #getCommAction()
   * @generated
   */
  EReference getCommAction_Target() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.CommAction#getQualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualified Name</em>'.
   * @see org.osate.ba.declarative.CommAction#getQualifiedName()
   * @see #getCommAction()
   * @generated
   */
  EReference getCommAction_QualifiedName() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.CommAction#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.ba.declarative.CommAction#getReference()
   * @see #getCommAction()
   * @generated
   */
  EReference getCommAction_Reference() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeArrayDimension <em>Array Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Dimension</em>'.
   * @see org.osate.ba.declarative.DeclarativeArrayDimension
   * @generated
   */
  EClass getDeclarativeArrayDimension() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativeArrayDimension#getDimension <em>Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dimension</em>'.
   * @see org.osate.ba.declarative.DeclarativeArrayDimension#getDimension()
   * @see #getDeclarativeArrayDimension()
   * @generated
   */
  EReference getDeclarativeArrayDimension_Dimension() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeBehaviorElement <em>Behavior Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Element</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorElement
   * @generated
   */
  EClass getDeclarativeBehaviorElement() ;

  /**
   * Returns the meta object for the reference '{@link org.osate.ba.declarative.DeclarativeBehaviorElement#getOsateRef <em>Osate Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Osate Ref</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorElement#getOsateRef()
   * @see #getDeclarativeBehaviorElement()
   * @generated
   */
  EReference getDeclarativeBehaviorElement_OsateRef() ;

  /**
   * Returns the meta object for the reference '{@link org.osate.ba.declarative.DeclarativeBehaviorElement#getBaRef <em>Ba Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ba Ref</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorElement#getBaRef()
   * @see #getDeclarativeBehaviorElement()
   * @generated
   */
  EReference getDeclarativeBehaviorElement_BaRef() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeBehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Transition</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorTransition
   * @generated
   */
  EClass getDeclarativeBehaviorTransition() ;

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.ba.declarative.DeclarativeBehaviorTransition#getSrcStates <em>Src States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Src States</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorTransition#getSrcStates()
   * @see #getDeclarativeBehaviorTransition()
   * @generated
   */
  EReference getDeclarativeBehaviorTransition_SrcStates() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativeBehaviorTransition#getDestState <em>Dest State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dest State</em>'.
   * @see org.osate.ba.declarative.DeclarativeBehaviorTransition#getDestState()
   * @see #getDeclarativeBehaviorTransition()
   * @generated
   */
  EReference getDeclarativeBehaviorTransition_DestState() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativePropertyName <em>Property Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Name</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyName
   * @generated
   */
  EClass getDeclarativePropertyName() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativePropertyName#getPropertyName <em>Property Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property Name</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyName#getPropertyName()
   * @see #getDeclarativePropertyName()
   * @generated
   */
  EReference getDeclarativePropertyName_PropertyName() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativePropertyName#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyName#getField()
   * @see #getDeclarativePropertyName()
   * @generated
   */
  EReference getDeclarativePropertyName_Field() ;

  /**
   * Returns the meta object for the reference list '{@link org.osate.ba.declarative.DeclarativePropertyName#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Indexes</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyName#getIndexes()
   * @see #getDeclarativePropertyName()
   * @generated
   */
  EReference getDeclarativePropertyName_Indexes() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativePropertyReference <em>Property Reference</em>}'.
   * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Reference</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyReference
   * @generated
   */
  EClass getDeclarativePropertyReference() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativePropertyReference#getQualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualified Name</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyReference#getQualifiedName()
   * @see #getDeclarativePropertyReference()
   * @generated
   */
  EReference getDeclarativePropertyReference_QualifiedName() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativePropertyReference#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyReference#getReference()
   * @see #getDeclarativePropertyReference()
   * @generated
   */
  EReference getDeclarativePropertyReference_Reference() ;

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.ba.declarative.DeclarativePropertyReference#getPropertyNames <em>Property Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Names</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyReference#getPropertyNames()
   * @see #getDeclarativePropertyReference()
   * @generated
   */
  EReference getDeclarativePropertyReference_PropertyNames() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.DeclarativePropertyReference#isPropertySet <em>Property Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property Set</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyReference#isPropertySet()
   * @see #getDeclarativePropertyReference()
   * @generated
   */
  EAttribute getDeclarativePropertyReference_PropertySet() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time</em>'.
   * @see org.osate.ba.declarative.DeclarativeTime
   * @generated
   */
  EClass getDeclarativeTime() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativeTime#getUnitId <em>Unit Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit Id</em>'.
   * @see org.osate.ba.declarative.DeclarativeTime#getUnitId()
   * @see #getDeclarativeTime()
   * @generated
   */
  EReference getDeclarativeTime_UnitId() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier</em>'.
   * @see org.osate.ba.declarative.Identifier
   * @generated
   */
  EClass getIdentifier() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.Identifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.osate.ba.declarative.Identifier#getId()
   * @see #getIdentifier()
   * @generated
   */
  EAttribute getIdentifier_Id() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.NamedValue <em>Named Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Value</em>'.
   * @see org.osate.ba.declarative.NamedValue
   * @generated
   */
  EClass getNamedValue() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.NamedValue#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.ba.declarative.NamedValue#getReference()
   * @see #getNamedValue()
   * @generated
   */
  EReference getNamedValue_Reference() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.NamedValue#isDequeue <em>Dequeue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dequeue</em>'.
   * @see org.osate.ba.declarative.NamedValue#isDequeue()
   * @see #getNamedValue()
   * @generated
   */
  EAttribute getNamedValue_Dequeue() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.NamedValue#isFresh <em>Fresh</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fresh</em>'.
   * @see org.osate.ba.declarative.NamedValue#isFresh()
   * @see #getNamedValue()
   * @generated
   */
  EAttribute getNamedValue_Fresh() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.NamedValue#isCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.osate.ba.declarative.NamedValue#isCount()
   * @see #getNamedValue()
   * @generated
   */
  EAttribute getNamedValue_Count() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.QualifiedNamedElement <em>Qualified Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Named Element</em>'.
   * @see org.osate.ba.declarative.QualifiedNamedElement
   * @generated
   */
  EClass getQualifiedNamedElement() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.QualifiedNamedElement#getBaNamespace <em>Ba Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ba Namespace</em>'.
   * @see org.osate.ba.declarative.QualifiedNamedElement#getBaNamespace()
   * @see #getQualifiedNamedElement()
   * @generated
   */
  EReference getQualifiedNamedElement_BaNamespace() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.QualifiedNamedElement#getBaName <em>Ba Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ba Name</em>'.
   * @see org.osate.ba.declarative.QualifiedNamedElement#getBaName()
   * @see #getQualifiedNamedElement()
   * @generated
   */
  EReference getQualifiedNamedElement_BaName() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.osate.ba.declarative.Reference
   * @generated
   */
  EClass getReference() ;

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.ba.declarative.Reference#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ids</em>'.
   * @see org.osate.ba.declarative.Reference#getIds()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Ids() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativePropertyAssociation <em>Property Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Association</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyAssociation
   * @generated
   */
  EClass getDeclarativePropertyAssociation() ;

  /**
   * Returns the meta object for the reference '{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyAssociation#getProperty()
   * @see #getDeclarativePropertyAssociation()
   * @generated
   */
  EReference getDeclarativePropertyAssociation_Property() ;

  /**
   * Returns the meta object for the containment reference '{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getOwnedValue <em>Owned Value</em>}'.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Value</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyAssociation#getOwnedValue()
   * @see #getDeclarativePropertyAssociation()
   * @generated
   */
  EReference getDeclarativePropertyAssociation_OwnedValue() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeListValue <em>List Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Value</em>'.
   * @see org.osate.ba.declarative.DeclarativeListValue
   * @generated
   */
  EClass getDeclarativeListValue() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativePropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Expression</em>'.
   * @see org.osate.ba.declarative.DeclarativePropertyExpression
   * @generated
   */
  EClass getDeclarativePropertyExpression() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeStringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.osate.ba.declarative.DeclarativeStringLiteral
   * @generated
   */
  EClass getDeclarativeStringLiteral() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeIntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.osate.ba.declarative.DeclarativeIntegerLiteral
   * @generated
   */
  EClass getDeclarativeIntegerLiteral() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeRealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.osate.ba.declarative.DeclarativeRealLiteral
   * @generated
   */
  EClass getDeclarativeRealLiteral() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeRecordValue <em>Record Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Value</em>'.
   * @see org.osate.ba.declarative.DeclarativeRecordValue
   * @generated
   */
  EClass getDeclarativeRecordValue() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeBasicPropertyAssociation <em>Basic Property Association</em>}'.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Property Association</em>'.
   * @see org.osate.ba.declarative.DeclarativeBasicPropertyAssociation
   * @generated
   */
  EClass getDeclarativeBasicPropertyAssociation() ;

  /**
   * Returns the meta object for the attribute '{@link org.osate.ba.declarative.DeclarativeBasicPropertyAssociation#getBasicPropertyName <em>Basic Property Name</em>}'.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Basic Property Name</em>'.
   * @see org.osate.ba.declarative.DeclarativeBasicPropertyAssociation#getBasicPropertyName()
   * @see #getDeclarativeBasicPropertyAssociation()
   * @generated
   */
  EAttribute getDeclarativeBasicPropertyAssociation_BasicPropertyName() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeBooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.osate.ba.declarative.DeclarativeBooleanLiteral
   * @generated
   */
  EClass getDeclarativeBooleanLiteral() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeRangeValue <em>Range Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Value</em>'.
   * @see org.osate.ba.declarative.DeclarativeRangeValue
   * @generated
   */
  EClass getDeclarativeRangeValue() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeReferenceValue <em>Reference Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Value</em>'.
   * @see org.osate.ba.declarative.DeclarativeReferenceValue
   * @generated
   */
  EClass getDeclarativeReferenceValue() ;

  /**
   * Returns the meta object for the reference '{@link org.osate.ba.declarative.DeclarativeReferenceValue#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.ba.declarative.DeclarativeReferenceValue#getRef()
   * @see #getDeclarativeReferenceValue()
   * @generated
   */
  EReference getDeclarativeReferenceValue_Ref() ;

  /**
   * Returns the meta object for class '{@link org.osate.ba.declarative.DeclarativeClassifierValue <em>Classifier Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Value</em>'.
   * @see org.osate.ba.declarative.DeclarativeClassifierValue
   * @generated
   */
  EClass getDeclarativeClassifierValue() ;

  /**
   * Returns the meta object for the reference '{@link org.osate.ba.declarative.DeclarativeClassifierValue#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classifier</em>'.
   * @see org.osate.ba.declarative.DeclarativeClassifierValue#getClassifier()
   * @see #getDeclarativeClassifierValue()
   * @generated
   */
  EReference getDeclarativeClassifierValue_Classifier() ;

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DeclarativeFactory getDeclarativeFactory() ;

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.ArrayableIdentifierImpl <em>Arrayable Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.ArrayableIdentifierImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getArrayableIdentifier()
     * @generated
     */
    EClass ARRAYABLE_IDENTIFIER = eINSTANCE.getArrayableIdentifier() ;

    /**
     * The meta object literal for the '<em><b>Array Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAYABLE_IDENTIFIER__ARRAY_INDEXES = eINSTANCE
                                                              .getArrayableIdentifier_ArrayIndexes() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.CommActionImpl <em>Comm Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.CommActionImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getCommAction()
     * @generated
     */
    EClass COMM_ACTION = eINSTANCE.getCommAction() ;

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMM_ACTION__PARAMETERS = eINSTANCE.getCommAction_Parameters() ;

    /**
     * The meta object literal for the '<em><b>Port Freeze</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMM_ACTION__PORT_FREEZE = eINSTANCE.getCommAction_PortFreeze() ;

    /**
     * The meta object literal for the '<em><b>Port Dequeue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMM_ACTION__PORT_DEQUEUE = eINSTANCE
                                                    .getCommAction_PortDequeue() ;

    /**
     * The meta object literal for the '<em><b>Lock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMM_ACTION__LOCK = eINSTANCE.getCommAction_Lock() ;

    /**
     * The meta object literal for the '<em><b>Unlock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMM_ACTION__UNLOCK = eINSTANCE.getCommAction_Unlock() ;

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMM_ACTION__TARGET = eINSTANCE.getCommAction_Target() ;

    /**
     * The meta object literal for the '<em><b>Qualified Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMM_ACTION__QUALIFIED_NAME = eINSTANCE
                                                      .getCommAction_QualifiedName() ;

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMM_ACTION__REFERENCE = eINSTANCE.getCommAction_Reference() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeArrayDimensionImpl <em>Array Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeArrayDimensionImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeArrayDimension()
     * @generated
     */
    EClass DECLARATIVE_ARRAY_DIMENSION = eINSTANCE
                                                  .getDeclarativeArrayDimension() ;

    /**
     * The meta object literal for the '<em><b>Dimension</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_ARRAY_DIMENSION__DIMENSION = eINSTANCE
                                                                 .getDeclarativeArrayDimension_Dimension() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeBehaviorElementImpl <em>Behavior Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeBehaviorElementImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBehaviorElement()
     * @generated
     */
    EClass DECLARATIVE_BEHAVIOR_ELEMENT = eINSTANCE
                                                   .getDeclarativeBehaviorElement() ;

    /**
     * The meta object literal for the '<em><b>Osate Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF = eINSTANCE
                                                                  .getDeclarativeBehaviorElement_OsateRef() ;

    /**
     * The meta object literal for the '<em><b>Ba Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF = eINSTANCE
                                                               .getDeclarativeBehaviorElement_BaRef() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl <em>Behavior Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBehaviorTransition()
     * @generated
     */
    EClass DECLARATIVE_BEHAVIOR_TRANSITION = eINSTANCE
                                                      .getDeclarativeBehaviorTransition() ;

    /**
     * The meta object literal for the '<em><b>Src States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES = eINSTANCE
                                                                      .getDeclarativeBehaviorTransition_SrcStates() ;

    /**
     * The meta object literal for the '<em><b>Dest State</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE = eINSTANCE
                                                                      .getDeclarativeBehaviorTransition_DestState() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyNameImpl <em>Property Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativePropertyNameImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyName()
     * @generated
     */
    EClass DECLARATIVE_PROPERTY_NAME = eINSTANCE.getDeclarativePropertyName() ;

    /**
     * The meta object literal for the '<em><b>Property Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME = eINSTANCE
                                                                   .getDeclarativePropertyName_PropertyName() ;

    /**
     * The meta object literal for the '<em><b>Field</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_NAME__FIELD = eINSTANCE
                                                           .getDeclarativePropertyName_Field() ;

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_NAME__INDEXES = eINSTANCE
                                                             .getDeclarativePropertyName_Indexes() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl <em>Property Reference</em>}' class.
     * <!-- begin-user-doc -->
           * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyReference()
     * @generated
     */
    EClass DECLARATIVE_PROPERTY_REFERENCE = eINSTANCE
                                                     .getDeclarativePropertyReference() ;

    /**
     * The meta object literal for the '<em><b>Qualified Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME = eINSTANCE
                                                                         .getDeclarativePropertyReference_QualifiedName() ;

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_REFERENCE__REFERENCE = eINSTANCE
                                                                    .getDeclarativePropertyReference_Reference() ;

    /**
     * The meta object literal for the '<em><b>Property Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES = eINSTANCE
                                                                         .getDeclarativePropertyReference_PropertyNames() ;

    /**
     * The meta object literal for the '<em><b>Property Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET = eINSTANCE
                                                                       .getDeclarativePropertyReference_PropertySet() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeTimeImpl <em>Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeTimeImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeTime()
     * @generated
     */
    EClass DECLARATIVE_TIME = eINSTANCE.getDeclarativeTime() ;

    /**
     * The meta object literal for the '<em><b>Unit Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_TIME__UNIT_ID = eINSTANCE
                                                    .getDeclarativeTime_UnitId() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.IdentifierImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getIdentifier()
     * @generated
     */
    EClass IDENTIFIER = eINSTANCE.getIdentifier() ;

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFIER__ID = eINSTANCE.getIdentifier_Id() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.NamedValueImpl <em>Named Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.NamedValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getNamedValue()
     * @generated
     */
    EClass NAMED_VALUE = eINSTANCE.getNamedValue() ;

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_VALUE__REFERENCE = eINSTANCE.getNamedValue_Reference() ;

    /**
     * The meta object literal for the '<em><b>Dequeue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_VALUE__DEQUEUE = eINSTANCE.getNamedValue_Dequeue() ;

    /**
     * The meta object literal for the '<em><b>Fresh</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_VALUE__FRESH = eINSTANCE.getNamedValue_Fresh() ;

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_VALUE__COUNT = eINSTANCE.getNamedValue_Count() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.QualifiedNamedElementImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getQualifiedNamedElement()
     * @generated
     */
    EClass QUALIFIED_NAMED_ELEMENT = eINSTANCE.getQualifiedNamedElement() ;

    /**
     * The meta object literal for the '<em><b>Ba Namespace</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE = eINSTANCE
                                                                .getQualifiedNamedElement_BaNamespace() ;

    /**
     * The meta object literal for the '<em><b>Ba Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAMED_ELEMENT__BA_NAME = eINSTANCE
                                                           .getQualifiedNamedElement_BaName() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.ReferenceImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference() ;

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__IDS = eINSTANCE.getReference_Ids() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl <em>Property Association</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyAssociation()
     * @generated
     */
    EClass DECLARATIVE_PROPERTY_ASSOCIATION = eINSTANCE
                                                       .getDeclarativePropertyAssociation() ;

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY = eINSTANCE
                                                                     .getDeclarativePropertyAssociation_Property() ;

    /**
     * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE = eINSTANCE
                                                                        .getDeclarativePropertyAssociation_OwnedValue() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeListValueImpl <em>List Value</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeListValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeListValue()
     * @generated
     */
    EClass DECLARATIVE_LIST_VALUE = eINSTANCE.getDeclarativeListValue() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativePropertyExpressionImpl <em>Property Expression</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativePropertyExpressionImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativePropertyExpression()
     * @generated
     */
    EClass DECLARATIVE_PROPERTY_EXPRESSION = eINSTANCE
                                                      .getDeclarativePropertyExpression() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeStringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeStringLiteralImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeStringLiteral()
     * @generated
     */
    EClass DECLARATIVE_STRING_LITERAL = eINSTANCE
                                                 .getDeclarativeStringLiteral() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeIntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeIntegerLiteralImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeIntegerLiteral()
     * @generated
     */
    EClass DECLARATIVE_INTEGER_LITERAL = eINSTANCE
                                                  .getDeclarativeIntegerLiteral() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeRealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeRealLiteralImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRealLiteral()
     * @generated
     */
    EClass DECLARATIVE_REAL_LITERAL = eINSTANCE.getDeclarativeRealLiteral() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeRecordValueImpl <em>Record Value</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeRecordValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRecordValue()
     * @generated
     */
    EClass DECLARATIVE_RECORD_VALUE = eINSTANCE.getDeclarativeRecordValue() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeBasicPropertyAssociationImpl <em>Basic Property Association</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeBasicPropertyAssociationImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBasicPropertyAssociation()
     * @generated
     */
    EClass DECLARATIVE_BASIC_PROPERTY_ASSOCIATION = eINSTANCE
                                                             .getDeclarativeBasicPropertyAssociation() ;

    /**
     * The meta object literal for the '<em><b>Basic Property Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME =
                                                                           eINSTANCE.getDeclarativeBasicPropertyAssociation_BasicPropertyName() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeBooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeBooleanLiteralImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeBooleanLiteral()
     * @generated
     */
    EClass DECLARATIVE_BOOLEAN_LITERAL = eINSTANCE
                                                  .getDeclarativeBooleanLiteral() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeRangeValueImpl <em>Range Value</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeRangeValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeRangeValue()
     * @generated
     */
    EClass DECLARATIVE_RANGE_VALUE = eINSTANCE.getDeclarativeRangeValue() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeReferenceValueImpl <em>Reference Value</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeReferenceValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeReferenceValue()
     * @generated
     */
    EClass DECLARATIVE_REFERENCE_VALUE = eINSTANCE
                                                  .getDeclarativeReferenceValue() ;

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_REFERENCE_VALUE__REF = eINSTANCE
                                                           .getDeclarativeReferenceValue_Ref() ;

    /**
     * The meta object literal for the '{@link org.osate.ba.declarative.impl.DeclarativeClassifierValueImpl <em>Classifier Value</em>}' class.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @see org.osate.ba.declarative.impl.DeclarativeClassifierValueImpl
     * @see org.osate.ba.declarative.impl.DeclarativePackageImpl#getDeclarativeClassifierValue()
     * @generated
     */
    EClass DECLARATIVE_CLASSIFIER_VALUE = eINSTANCE
                                                   .getDeclarativeClassifierValue() ;

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
    	 * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATIVE_CLASSIFIER_VALUE__CLASSIFIER = eINSTANCE
                                                                   .getDeclarativeClassifierValue_Classifier() ;

  }

} //DeclarativePackage
