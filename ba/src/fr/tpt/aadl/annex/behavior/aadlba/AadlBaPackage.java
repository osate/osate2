/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory
 * @model kind="package"
 * @generated
 */
public interface AadlBaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "aadlba";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://eve.enst.fr/svn/aadl-eclipse-dev/aadlba/trunk/fr.tpt.aadl.annex.behavior/aadlba";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "aadlba";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AadlBaPackage eINSTANCE = fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnex()
	 * @generated
	 */
	int BEHAVIOR_ANNEX = 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__OWNED_ELEMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__OWNER = Aadl2Package.ANNEX_SUBCLAUSE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__OWNED_COMMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__NAME = Aadl2Package.ANNEX_SUBCLAUSE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__QUALIFIED_NAME = Aadl2Package.ANNEX_SUBCLAUSE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__NAMESPACE = Aadl2Package.ANNEX_SUBCLAUSE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Modes And Transitions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__MODES_AND_TRANSITIONS = Aadl2Package.ANNEX_SUBCLAUSE__MODES_AND_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__IN_MODE = Aadl2Package.ANNEX_SUBCLAUSE__IN_MODE;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__BA_REF = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__AADL_REF = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behavior Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Behavior States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__BEHAVIOR_STATES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Behavior Annex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ANNEX_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNER = Aadl2Package.ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__BA_REF = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__AADL_REF = Aadl2Package.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
	 * @generated
	 */
	int BEHAVIOR_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Behavior Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_CONDITION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorState()
	 * @generated
	 */
	int BEHAVIOR_STATE = 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__IDENTIFIERS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__INITIAL = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__COMPLETE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__FINAL = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Behavior State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTransition()
	 * @generated
	 */
	int BEHAVIOR_TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Transition Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source State Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behavior Condition Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination State Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior Action Block Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Behavior Transition Priority</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Behavior Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariable()
	 * @generated
	 */
	int BEHAVIOR_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Local Variable Declarators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__LOCAL_VARIABLE_DECLARATORS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_VARIABLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 5;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BODY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl <em>Declarator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDeclarator()
	 * @generated
	 */
	int DECLARATOR = 6;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__IDENTIFIER_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Sizes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR__ARRAY_SIZES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Declarator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
	 * @generated
	 */
	int EXECUTE_CONDITION = 8;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION__OWNED_ELEMENT = BEHAVIOR_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION__OWNER = BEHAVIOR_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION__OWNED_COMMENT = BEHAVIOR_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION__BA_REF = BEHAVIOR_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION__AADL_REF = BEHAVIOR_CONDITION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Execute Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 9;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__ID = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__QUALIFIED_NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAMESPACE_SEPARATOR = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAMESPACE = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl <em>Otherwise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getOtherwise()
	 * @generated
	 */
	int OTHERWISE = 11;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE__OWNED_ELEMENT = EXECUTE_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE__OWNER = EXECUTE_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE__OWNED_COMMENT = EXECUTE_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE__BA_REF = EXECUTE_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE__AADL_REF = EXECUTE_CONDITION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Otherwise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERWISE_FEATURE_COUNT = EXECUTE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimeoutCatchImpl <em>Timeout Catch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimeoutCatchImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimeoutCatch()
	 * @generated
	 */
	int TIMEOUT_CATCH = 12;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH__OWNED_ELEMENT = EXECUTE_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH__OWNER = EXECUTE_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH__OWNED_COMMENT = EXECUTE_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH__BA_REF = EXECUTE_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH__AADL_REF = EXECUTE_CONDITION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Timeout Catch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMEOUT_CATCH_FEATURE_COUNT = EXECUTE_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl <em>Unique Component Classifier Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUniqueComponentClassifierReference()
	 * @generated
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__OWNER = NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__BA_REF = NAMED_ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__AADL_REF = NAMED_ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__NAMESPACE_SEPARATOR = NAMED_ELEMENT__NAMESPACE_SEPARATOR;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Unique Component Classifier Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerCondition()
	 * @generated
	 */
	int DISPATCH_TRIGGER_CONDITION = 17;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Dispatch Trigger Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl <em>Completion Relative Timeout Condition And Catch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCompletionRelativeTimeoutConditionAndCatch()
	 * @generated
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH = 14;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__OWNER = DISPATCH_TRIGGER_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__BA_REF = DISPATCH_TRIGGER_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__AADL_REF = DISPATCH_TRIGGER_CONDITION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Integer Value Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Completion Relative Timeout Condition And Catch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchCondition()
	 * @generated
	 */
	int DISPATCH_CONDITION = 15;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__OWNED_ELEMENT = BEHAVIOR_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__OWNER = BEHAVIOR_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__OWNED_COMMENT = BEHAVIOR_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__BA_REF = BEHAVIOR_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__AADL_REF = BEHAVIOR_CONDITION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Dispatch Trigger Condition Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frozen Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION__FROZEN_PORTS = BEHAVIOR_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dispatch Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchConjunction()
	 * @generated
	 */
	int DISPATCH_CONJUNCTION = 16;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Dispatch Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dispatch Conjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_CONJUNCTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl <em>Dispatch Trigger Condition Stop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerConditionStop()
	 * @generated
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP = 18;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP__OWNER = DISPATCH_TRIGGER_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP__BA_REF = DISPATCH_TRIGGER_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP__AADL_REF = DISPATCH_TRIGGER_CONDITION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Dispatch Trigger Condition Stop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_CONDITION_STOP_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerLogicalExpression()
	 * @generated
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__OWNER = DISPATCH_TRIGGER_CONDITION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__BA_REF = DISPATCH_TRIGGER_CONDITION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__AADL_REF = DISPATCH_TRIGGER_CONDITION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Dispatch Conjunctions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dispatch Trigger Logical Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TRIGGER_LOGICAL_EXPRESSION_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
	 * @generated
	 */
	int BEHAVIOR_ACTIONS = 25;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Behavior Actions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTIONS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
	 * @generated
	 */
	int BEHAVIOR_ACTION = 22;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION__OWNED_ELEMENT = BEHAVIOR_ACTIONS__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION__OWNER = BEHAVIOR_ACTIONS__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION__OWNED_COMMENT = BEHAVIOR_ACTIONS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION__BA_REF = BEHAVIOR_ACTIONS__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION__AADL_REF = BEHAVIOR_ACTIONS__AADL_REF;

	/**
	 * The number of structural features of the '<em>Behavior Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
	 * @generated
	 */
	int BASIC_ACTION = 21;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION__OWNED_ELEMENT = BEHAVIOR_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION__OWNER = BEHAVIOR_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION__OWNED_COMMENT = BEHAVIOR_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION__BA_REF = BEHAVIOR_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION__AADL_REF = BEHAVIOR_ACTION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Basic Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ACTION_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAssignmentAction()
	 * @generated
	 */
	int ASSIGNMENT_ACTION = 20;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__OWNER = BASIC_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__BA_REF = BASIC_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__AADL_REF = BASIC_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Target Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__TARGET_OWNED = BASIC_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED = BASIC_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION__ANY = BASIC_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionBlock()
	 * @generated
	 */
	int BEHAVIOR_ACTION_BLOCK = 23;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavior Time Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Action Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_BLOCK_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionCollection()
	 * @generated
	 */
	int BEHAVIOR_ACTION_COLLECTION = 24;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT = BEHAVIOR_ACTIONS__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__OWNER = BEHAVIOR_ACTIONS__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT = BEHAVIOR_ACTIONS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__BA_REF = BEHAVIOR_ACTIONS__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__AADL_REF = BEHAVIOR_ACTIONS__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior Action Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSequence()
	 * @generated
	 */
	int BEHAVIOR_ACTION_SEQUENCE = 26;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__OWNED_ELEMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__OWNER = BEHAVIOR_ACTION_COLLECTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__OWNED_COMMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__BA_REF = BEHAVIOR_ACTION_COLLECTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__AADL_REF = BEHAVIOR_ACTION_COLLECTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE__BEHAVIOR_ACTIONS = BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS;

	/**
	 * The number of structural features of the '<em>Behavior Action Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SEQUENCE_FEATURE_COUNT = BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSet()
	 * @generated
	 */
	int BEHAVIOR_ACTION_SET = 27;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__OWNED_ELEMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__OWNER = BEHAVIOR_ACTION_COLLECTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__OWNED_COMMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__BA_REF = BEHAVIOR_ACTION_COLLECTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__AADL_REF = BEHAVIOR_ACTION_COLLECTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET__BEHAVIOR_ACTIONS = BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS;

	/**
	 * The number of structural features of the '<em>Behavior Action Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_ACTION_SET_FEATURE_COUNT = BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
	 * @generated
	 */
	int COMMUNICATION_ACTION = 28;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION__OWNER = BASIC_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION__BA_REF = BASIC_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION__AADL_REF = BASIC_ACTION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Communication Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
	 * @generated
	 */
	int COND_STATEMENT = 29;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT__OWNED_ELEMENT = BEHAVIOR_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT__OWNER = BEHAVIOR_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT__OWNED_COMMENT = BEHAVIOR_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT__BA_REF = BEHAVIOR_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT__AADL_REF = BEHAVIOR_ACTION__AADL_REF;

	/**
	 * The number of structural features of the '<em>Cond Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
	 * @generated
	 */
	int ELEMENT_VALUES = 31;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Element Values</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUES_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl <em>Data Component Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataComponentReference()
	 * @generated
	 */
	int DATA_COMPONENT_REFERENCE = 30;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__OWNED_ELEMENT = ELEMENT_VALUES__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__OWNER = ELEMENT_VALUES__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__OWNED_COMMENT = ELEMENT_VALUES__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__BA_REF = ELEMENT_VALUES__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__AADL_REF = ELEMENT_VALUES__AADL_REF;

	/**
	 * The feature id for the '<em><b>Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE__NAMES = ELEMENT_VALUES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Component Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_COMPONENT_REFERENCE_FEATURE_COUNT = ELEMENT_VALUES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLoopStatement()
	 * @generated
	 */
	int LOOP_STATEMENT = 35;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__OWNER = COND_STATEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__BA_REF = COND_STATEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__AADL_REF = COND_STATEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED = COND_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl <em>For Or For All Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getForOrForAllStatement()
	 * @generated
	 */
	int FOR_OR_FOR_ALL_STATEMENT = 32;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__OWNED_ELEMENT = LOOP_STATEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__OWNER = LOOP_STATEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__OWNED_COMMENT = LOOP_STATEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__BA_REF = LOOP_STATEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__AADL_REF = LOOP_STATEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED;

	/**
	 * The feature id for the '<em><b>Element Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER = LOOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = LOOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Values Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED = LOOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>For All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = LOOP_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>For Or For All Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OR_FOR_ALL_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 33;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNER = COND_STATEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__BA_REF = COND_STATEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__AADL_REF = COND_STATEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Has Else</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__HAS_ELSE = COND_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Value Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS = COND_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED = COND_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl <em>Shared Data Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSharedDataAction()
	 * @generated
	 */
	int SHARED_DATA_ACTION = 41;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__OWNER = COMMUNICATION_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__BA_REF = COMMUNICATION_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__AADL_REF = COMMUNICATION_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Data Access Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION__DATA_ACCESS_NAME = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shared Data Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl <em>Lock Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLockAction()
	 * @generated
	 */
	int LOCK_ACTION = 34;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__OWNED_ELEMENT = SHARED_DATA_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__OWNER = SHARED_DATA_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__OWNED_COMMENT = SHARED_DATA_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__BA_REF = SHARED_DATA_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__AADL_REF = SHARED_DATA_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Data Access Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION__DATA_ACCESS_NAME = SHARED_DATA_ACTION__DATA_ACCESS_NAME;

	/**
	 * The number of structural features of the '<em>Lock Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCK_ACTION_FEATURE_COUNT = SHARED_DATA_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl <em>Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getName_()
	 * @generated
	 */
	int NAME = 36;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__OWNED_ELEMENT = ELEMENT_VALUES__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__OWNER = ELEMENT_VALUES__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__OWNED_COMMENT = ELEMENT_VALUES__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__BA_REF = ELEMENT_VALUES__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__AADL_REF = ELEMENT_VALUES__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__IDENTIFIER_OWNED = ELEMENT_VALUES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__ARRAY_INDEXES = ELEMENT_VALUES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_FEATURE_COUNT = ELEMENT_VALUES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
	 * @generated
	 */
	int PARAMETER_LABEL = 37;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Parameter Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LABEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl <em>Port Dequeue Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueAction()
	 * @generated
	 */
	int PORT_DEQUEUE_ACTION = 38;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__OWNER = COMMUNICATION_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__BA_REF = COMMUNICATION_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__AADL_REF = COMMUNICATION_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__PORT_NAME = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION__TARGET_OWNED = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Dequeue Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl <em>Port Freeze Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreezeAction()
	 * @generated
	 */
	int PORT_FREEZE_ACTION = 39;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__OWNER = COMMUNICATION_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__BA_REF = COMMUNICATION_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__AADL_REF = COMMUNICATION_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__IDENTIFIER_OWNED = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION__ARRAY_INDEXES = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Freeze Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FREEZE_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl <em>Port Send Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortSendAction()
	 * @generated
	 */
	int PORT_SEND_ACTION = 40;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__OWNER = COMMUNICATION_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__BA_REF = COMMUNICATION_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__AADL_REF = COMMUNICATION_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__PORT_NAME = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Send Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SEND_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl <em>Subprogram Call Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramCallAction()
	 * @generated
	 */
	int SUBPROGRAM_CALL_ACTION = 42;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__OWNER = COMMUNICATION_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__BA_REF = COMMUNICATION_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__AADL_REF = COMMUNICATION_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Subprogram Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subprogram Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Subprogram Call Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPROGRAM_CALL_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 43;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__OWNED_ELEMENT = PARAMETER_LABEL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__OWNER = PARAMETER_LABEL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__OWNED_COMMENT = PARAMETER_LABEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__BA_REF = PARAMETER_LABEL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__AADL_REF = PARAMETER_LABEL__AADL_REF;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = PARAMETER_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl <em>Timed Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimedAction()
	 * @generated
	 */
	int TIMED_ACTION = 44;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__OWNER = BASIC_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__BA_REF = BASIC_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__AADL_REF = BASIC_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Lower Behavior Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__LOWER_BEHAVIOR_TIME = BASIC_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Behavior Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION__UPPER_BEHAVIOR_TIME = BASIC_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl <em>Unlock Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnlockAction()
	 * @generated
	 */
	int UNLOCK_ACTION = 45;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__OWNED_ELEMENT = SHARED_DATA_ACTION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__OWNER = SHARED_DATA_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__OWNED_COMMENT = SHARED_DATA_ACTION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__BA_REF = SHARED_DATA_ACTION__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__AADL_REF = SHARED_DATA_ACTION__AADL_REF;

	/**
	 * The feature id for the '<em><b>Data Access Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION__DATA_ACCESS_NAME = SHARED_DATA_ACTION__DATA_ACCESS_NAME;

	/**
	 * The number of structural features of the '<em>Unlock Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLOCK_ACTION_FEATURE_COUNT = SHARED_DATA_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl <em>While Or Do Until Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileOrDoUntilStatement()
	 * @generated
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__OWNED_ELEMENT = LOOP_STATEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__OWNER = LOOP_STATEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__OWNED_COMMENT = LOOP_STATEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__BA_REF = LOOP_STATEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__AADL_REF = LOOP_STATEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED;

	/**
	 * The feature id for the '<em><b>Logical Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION = LOOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Do Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL = LOOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Or Do Until Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OR_DO_UNTIL_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTime()
	 * @generated
	 */
	int BEHAVIOR_TIME = 47;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Integer Value Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__INTEGER_VALUE_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME__UNIT_IDENTIFIER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TIME_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Value
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 68;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueConstant()
	 * @generated
	 */
	int VALUE_CONSTANT = 69;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT__OWNER = VALUE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT__OWNED_COMMENT = VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT__BA_REF = VALUE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT__AADL_REF = VALUE__AADL_REF;

	/**
	 * The number of structural features of the '<em>Value Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CONSTANT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 55;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__OWNER = VALUE_CONSTANT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__BA_REF = VALUE_CONSTANT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__AADL_REF = VALUE_CONSTANT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 48;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__OWNER = LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__BA_REF = LITERAL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__AADL_REF = LITERAL__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl <em>Factor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFactor()
	 * @generated
	 */
	int FACTOR = 49;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__VALUE_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Sd Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__VALUE_SD_OWNED = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Binary Numeric Operator Owned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__BINARY_NUMERIC_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unary Numeric Operator Owned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__UNARY_NUMERIC_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unary Boolean Operator Owned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Factor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 57;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__OWNER = LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__BA_REF = LITERAL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__AADL_REF = LITERAL__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__VALUE_STRING = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerLiteralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 50;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__OWNED_ELEMENT = NUMERIC_LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__OWNER = NUMERIC_LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__OWNED_COMMENT = NUMERIC_LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__BA_REF = NUMERIC_LITERAL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__AADL_REF = NUMERIC_LITERAL__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE_STRING = NUMERIC_LITERAL__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__BASE = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerRange()
	 * @generated
	 */
	int INTEGER_RANGE = 51;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__OWNED_ELEMENT = ELEMENT_VALUES__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__OWNER = ELEMENT_VALUES__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__OWNED_COMMENT = ELEMENT_VALUES__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__BA_REF = ELEMENT_VALUES__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__AADL_REF = ELEMENT_VALUES__AADL_REF;

	/**
	 * The feature id for the '<em><b>Lower Integer Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__LOWER_INTEGER_VALUE = ELEMENT_VALUES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Integer Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__UPPER_INTEGER_VALUE = ELEMENT_VALUES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_FEATURE_COUNT = ELEMENT_VALUES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
	 * @generated
	 */
	int INTEGER_VALUE = 52;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The number of structural features of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueConstant()
	 * @generated
	 */
	int INTEGER_VALUE_CONSTANT = 53;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT__OWNED_ELEMENT = INTEGER_VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT__OWNER = INTEGER_VALUE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT__OWNED_COMMENT = INTEGER_VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT__BA_REF = INTEGER_VALUE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT__AADL_REF = INTEGER_VALUE__AADL_REF;

	/**
	 * The number of structural features of the '<em>Integer Value Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_CONSTANT_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueVariable()
	 * @generated
	 */
	int INTEGER_VALUE_VARIABLE = 54;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE__OWNED_ELEMENT = INTEGER_VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE__OWNER = INTEGER_VALUE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE__OWNED_COMMENT = INTEGER_VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE__BA_REF = INTEGER_VALUE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE__AADL_REF = INTEGER_VALUE__AADL_REF;

	/**
	 * The number of structural features of the '<em>Integer Value Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_VARIABLE_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl <em>Numeral</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumeral()
	 * @generated
	 */
	int NUMERAL = 56;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__VALUE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl <em>Property Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPropertyConstant()
	 * @generated
	 */
	int PROPERTY_CONSTANT = 58;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__OWNER = NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__BA_REF = NAMED_ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__AADL_REF = NAMED_ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__NAMESPACE_SEPARATOR = NAMED_ELEMENT__NAMESPACE_SEPARATOR;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Property Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONSTANT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyValueImpl <em>Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyValueImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPropertyValue()
	 * @generated
	 */
	int PROPERTY_VALUE = 59;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__OWNER = NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__BA_REF = NAMED_ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__AADL_REF = NAMED_ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__NAMESPACE_SEPARATOR = NAMED_ELEMENT__NAMESPACE_SEPARATOR;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
	 * @generated
	 */
	int VALUE_VARIABLE = 71;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE__OWNER = VALUE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE__OWNED_COMMENT = VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE__BA_REF = VALUE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE__AADL_REF = VALUE__AADL_REF;

	/**
	 * The number of structural features of the '<em>Value Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl <em>Port Count Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortCountValue()
	 * @generated
	 */
	int PORT_COUNT_VALUE = 60;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__OWNED_ELEMENT = VALUE_VARIABLE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__OWNER = VALUE_VARIABLE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__OWNED_COMMENT = VALUE_VARIABLE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__BA_REF = VALUE_VARIABLE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__AADL_REF = VALUE_VARIABLE__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__IDENTIFIER_OWNED = VALUE_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE__ARRAY_INDEXES = VALUE_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Count Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_COUNT_VALUE_FEATURE_COUNT = VALUE_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl <em>Port Dequeue Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueValue()
	 * @generated
	 */
	int PORT_DEQUEUE_VALUE = 61;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__OWNED_ELEMENT = VALUE_VARIABLE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__OWNER = VALUE_VARIABLE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__OWNED_COMMENT = VALUE_VARIABLE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__BA_REF = VALUE_VARIABLE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__AADL_REF = VALUE_VARIABLE__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__IDENTIFIER_OWNED = VALUE_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE__ARRAY_INDEXES = VALUE_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Dequeue Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_DEQUEUE_VALUE_FEATURE_COUNT = VALUE_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl <em>Port Fresh Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreshValue()
	 * @generated
	 */
	int PORT_FRESH_VALUE = 62;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__OWNED_ELEMENT = VALUE_VARIABLE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__OWNER = VALUE_VARIABLE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__OWNED_COMMENT = VALUE_VARIABLE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__BA_REF = VALUE_VARIABLE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__AADL_REF = VALUE_VARIABLE__AADL_REF;

	/**
	 * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__IDENTIFIER_OWNED = VALUE_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE__ARRAY_INDEXES = VALUE_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Fresh Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FRESH_VALUE_FEATURE_COUNT = VALUE_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RealLiteralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 63;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__OWNED_ELEMENT = NUMERIC_LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__OWNER = NUMERIC_LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__OWNED_COMMENT = NUMERIC_LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__BA_REF = NUMERIC_LITERAL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__AADL_REF = NUMERIC_LITERAL__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__VALUE_STRING = NUMERIC_LITERAL__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 64;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Simple Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SIMPLE_EXPRESSION_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Expression Sd Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SIMPLE_EXPRESSION_SD_OWNED = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relational Operator Owned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__RELATIONAL_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl <em>Simple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSimpleExpression()
	 * @generated
	 */
	int SIMPLE_EXPRESSION = 65;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Unary Adding Operator Owned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__TERMS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Binary Adding Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Simple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 66;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__OWNER = LITERAL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__BA_REF = LITERAL__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__AADL_REF = LITERAL__AADL_REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 67;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OWNER = ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__BA_REF = ELEMENT__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__AADL_REF = ELEMENT__AADL_REF;

	/**
	 * The feature id for the '<em><b>Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__FACTORS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplying Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__MULTIPLYING_OPERATORS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueExpression()
	 * @generated
	 */
	int VALUE_EXPRESSION = 70;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__OWNER = VALUE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__OWNED_COMMENT = VALUE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Ba Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__BA_REF = VALUE__BA_REF;

	/**
	 * The feature id for the '<em><b>Aadl Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__AADL_REF = VALUE__AADL_REF;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__RELATIONS = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION__LOGICAL_OPERATORS = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_EXPRESSION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 73;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType <em>Behavior Annex Feature Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnexFeatureType()
	 * @generated
	 */
	int BEHAVIOR_ANNEX_FEATURE_TYPE = 72;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryAddingOperator()
	 * @generated
	 */
	int BINARY_ADDING_OPERATOR = 74;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
	 * @generated
	 */
	int BINARY_NUMERIC_OPERATOR = 75;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataRepresentation()
	 * @generated
	 */
	int DATA_REPRESENTATION = 76;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLogicalOperator()
	 * @generated
	 */
	int LOGICAL_OPERATOR = 77;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getMultiplyingOperator()
	 * @generated
	 */
	int MULTIPLYING_OPERATOR = 78;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 79;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
	 * @generated
	 */
	int UNARY_ADDING_OPERATOR = 80;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
	 * @generated
	 */
	int UNARY_BOOLEAN_OPERATOR = 81;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryNumericOperator()
	 * @generated
	 */
	int UNARY_NUMERIC_OPERATOR = 82;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 83;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 84;

	/**
	 * The meta object id for the '<em>Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getReal()
	 * @generated
	 */
	int REAL = 85;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getString()
	 * @generated
	 */
	int STRING = 86;

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex <em>Behavior Annex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Annex</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex
	 * @generated
	 */
	EClass getBehaviorAnnex();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorVariables <em>Behavior Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Variables</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorVariables()
	 * @see #getBehaviorAnnex()
	 * @generated
	 */
	EReference getBehaviorAnnex_BehaviorVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorStates <em>Behavior States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior States</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorStates()
	 * @see #getBehaviorAnnex()
	 * @generated
	 */
	EReference getBehaviorAnnex_BehaviorStates();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorTransitions <em>Behavior Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Transitions</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorTransitions()
	 * @see #getBehaviorAnnex()
	 * @generated
	 */
	EReference getBehaviorAnnex_BehaviorTransitions();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Condition</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
	 * @generated
	 */
	EClass getBehaviorCondition();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState <em>Behavior State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior State</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState
	 * @generated
	 */
	EClass getBehaviorState();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getIdentifiers <em>Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifiers</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getIdentifiers()
	 * @see #getBehaviorState()
	 * @generated
	 */
	EReference getBehaviorState_Identifiers();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial()
	 * @see #getBehaviorState()
	 * @generated
	 */
	EAttribute getBehaviorState_Initial();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete()
	 * @see #getBehaviorState()
	 * @generated
	 */
	EAttribute getBehaviorState_Complete();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal()
	 * @see #getBehaviorState()
	 * @generated
	 */
	EAttribute getBehaviorState_Final();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Transition</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition
	 * @generated
	 */
	EClass getBehaviorTransition();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier <em>Transition Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transition Identifier</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_TransitionIdentifier();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source State Identifiers</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_SourceStateIdentifiers();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Condition Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_BehaviorConditionOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier <em>Destination State Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination State Identifier</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_DestinationStateIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionBlockOwned <em>Behavior Action Block Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Action Block Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionBlockOwned()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_BehaviorActionBlockOwned();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior Transition Priority</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_BehaviorTransitionPriority();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable <em>Behavior Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Variable</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable
	 * @generated
	 */
	EClass getBehaviorVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getLocalVariableDeclarators <em>Local Variable Declarators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Variable Declarators</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getLocalVariableDeclarators()
	 * @see #getBehaviorVariable()
	 * @generated
	 */
	EReference getBehaviorVariable_LocalVariableDeclarators();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Unique Component Classifier Reference</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataUniqueComponentClassifierReference()
	 * @see #getBehaviorVariable()
	 * @generated
	 */
	EReference getBehaviorVariable_DataUniqueComponentClassifierReference();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Comment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Comment#getBody()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Body();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declarator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator
	 * @generated
	 */
	EClass getDeclarator();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getIdentifierOwned <em>Identifier Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator#getIdentifierOwned()
	 * @see #getDeclarator()
	 * @generated
	 */
	EReference getDeclarator_IdentifierOwned();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes <em>Array Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Sizes</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes()
	 * @see #getDeclarator()
	 * @generated
	 */
	EReference getDeclarator_ArraySizes();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaRef <em>Ba Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ba Ref</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Element#getBaRef()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_BaRef();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlRef <em>Aadl Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Aadl Ref</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlRef()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_AadlRef();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Condition</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
	 * @generated
	 */
	EClass getExecuteCondition();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Identifier#getId()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Id();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespaceSeparator <em>Namespace Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace Separator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespaceSeparator()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_NamespaceSeparator();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Namespace();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Otherwise <em>Otherwise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Otherwise</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Otherwise
	 * @generated
	 */
	EClass getOtherwise();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch <em>Timeout Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timeout Catch</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch
	 * @generated
	 */
	EClass getTimeoutCatch();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference <em>Unique Component Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Component Classifier Reference</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference
	 * @generated
	 */
	EClass getUniqueComponentClassifierReference();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch <em>Completion Relative Timeout Condition And Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Relative Timeout Condition And Catch</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch
	 * @generated
	 */
	EClass getCompletionRelativeTimeoutConditionAndCatch();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition <em>Dispatch Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Condition</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition
	 * @generated
	 */
	EClass getDispatchCondition();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getDispatchTriggerConditionOwned <em>Dispatch Trigger Condition Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dispatch Trigger Condition Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getDispatchTriggerConditionOwned()
	 * @see #getDispatchCondition()
	 * @generated
	 */
	EReference getDispatchCondition_DispatchTriggerConditionOwned();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Frozen Ports</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts()
	 * @see #getDispatchCondition()
	 * @generated
	 */
	EReference getDispatchCondition_FrozenPorts();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction <em>Dispatch Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Conjunction</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction
	 * @generated
	 */
	EClass getDispatchConjunction();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dispatch Triggers</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers()
	 * @see #getDispatchConjunction()
	 * @generated
	 */
	EReference getDispatchConjunction_DispatchTriggers();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Trigger Condition</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
	 * @generated
	 */
	EClass getDispatchTriggerCondition();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop <em>Dispatch Trigger Condition Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Trigger Condition Stop</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop
	 * @generated
	 */
	EClass getDispatchTriggerConditionStop();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Trigger Logical Expression</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression
	 * @generated
	 */
	EClass getDispatchTriggerLogicalExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions <em>Dispatch Conjunctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dispatch Conjunctions</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions()
	 * @see #getDispatchTriggerLogicalExpression()
	 * @generated
	 */
	EReference getDispatchTriggerLogicalExpression_DispatchConjunctions();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction <em>Assignment Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction
	 * @generated
	 */
	EClass getAssignmentAction();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTargetOwned <em>Target Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTargetOwned()
	 * @see #getAssignmentAction()
	 * @generated
	 */
	EReference getAssignmentAction_TargetOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpressionOwned <em>Value Expression Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpressionOwned()
	 * @see #getAssignmentAction()
	 * @generated
	 */
	EReference getAssignmentAction_ValueExpressionOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#isAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Any</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#isAny()
	 * @see #getAssignmentAction()
	 * @generated
	 */
	EAttribute getAssignmentAction_Any();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
	 * @generated
	 */
	EClass getBasicAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
	 * @generated
	 */
	EClass getBehaviorAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock <em>Behavior Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Action Block</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock
	 * @generated
	 */
	EClass getBehaviorActionBlock();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorActionsOwned()
	 * @see #getBehaviorActionBlock()
	 * @generated
	 */
	EReference getBehaviorActionBlock_BehaviorActionsOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorTimeOwned <em>Behavior Time Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Time Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorTimeOwned()
	 * @see #getBehaviorActionBlock()
	 * @generated
	 */
	EReference getBehaviorActionBlock_BehaviorTimeOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Action Collection</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
	 * @generated
	 */
	EClass getBehaviorActionCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getBehaviorActions <em>Behavior Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Actions</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getBehaviorActions()
	 * @see #getBehaviorActionCollection()
	 * @generated
	 */
	EReference getBehaviorActionCollection_BehaviorActions();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Actions</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
	 * @generated
	 */
	EClass getBehaviorActions();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Action Sequence</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence
	 * @generated
	 */
	EClass getBehaviorActionSequence();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet <em>Behavior Action Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Action Set</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet
	 * @generated
	 */
	EClass getBehaviorActionSet();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
	 * @generated
	 */
	EClass getCommunicationAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cond Statement</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
	 * @generated
	 */
	EClass getCondStatement();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Component Reference</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference
	 * @generated
	 */
	EClass getDataComponentReference();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Names</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getNames()
	 * @see #getDataComponentReference()
	 * @generated
	 */
	EReference getDataComponentReference_Names();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Values</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
	 * @generated
	 */
	EClass getElementValues();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Or For All Statement</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement
	 * @generated
	 */
	EClass getForOrForAllStatement();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementIdentifier <em>Element Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Identifier</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementIdentifier()
	 * @see #getForOrForAllStatement()
	 * @generated
	 */
	EReference getForOrForAllStatement_ElementIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Unique Component Classifier Reference</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueComponentClassifierReference()
	 * @see #getForOrForAllStatement()
	 * @generated
	 */
	EReference getForOrForAllStatement_DataUniqueComponentClassifierReference();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned <em>Element Values Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Values Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned()
	 * @see #getForOrForAllStatement()
	 * @generated
	 */
	EReference getForOrForAllStatement_ElementValuesOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For All</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll()
	 * @see #getForOrForAllStatement()
	 * @generated
	 */
	EAttribute getForOrForAllStatement_ForAll();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse <em>Has Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Else</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse()
	 * @see #getIfStatement()
	 * @generated
	 */
	EAttribute getIfStatement_HasElse();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpressions <em>Logical Value Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Logical Value Expressions</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpressions()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_LogicalValueExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Actions Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_BehaviorActionsOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.LockAction <em>Lock Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lock Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LockAction
	 * @generated
	 */
	EClass getLockAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement <em>Loop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Statement</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LoopStatement
	 * @generated
	 */
	EClass getLoopStatement();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LoopStatement#getBehaviorActionsOwned()
	 * @see #getLoopStatement()
	 * @generated
	 */
	EReference getLoopStatement_BehaviorActionsOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Name
	 * @generated
	 */
	EClass getName_();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifierOwned <em>Identifier Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifierOwned()
	 * @see #getName_()
	 * @generated
	 */
	EReference getName_IdentifierOwned();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexes <em>Array Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Indexes</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexes()
	 * @see #getName_()
	 * @generated
	 */
	EReference getName_ArrayIndexes();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Label</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
	 * @generated
	 */
	EClass getParameterLabel();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction <em>Port Dequeue Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Dequeue Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction
	 * @generated
	 */
	EClass getPortDequeueAction();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName <em>Port Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Port Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName()
	 * @see #getPortDequeueAction()
	 * @generated
	 */
	EReference getPortDequeueAction_PortName();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned <em>Target Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned()
	 * @see #getPortDequeueAction()
	 * @generated
	 */
	EReference getPortDequeueAction_TargetOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction <em>Port Freeze Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Freeze Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction
	 * @generated
	 */
	EClass getPortFreezeAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction <em>Port Send Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Send Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction
	 * @generated
	 */
	EClass getPortSendAction();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPortName <em>Port Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Port Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPortName()
	 * @see #getPortSendAction()
	 * @generated
	 */
	EReference getPortSendAction_PortName();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpressionOwned <em>Value Expression Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpressionOwned()
	 * @see #getPortSendAction()
	 * @generated
	 */
	EReference getPortSendAction_ValueExpressionOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction <em>Shared Data Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Data Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction
	 * @generated
	 */
	EClass getSharedDataAction();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName <em>Data Access Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Access Name</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName()
	 * @see #getSharedDataAction()
	 * @generated
	 */
	EReference getSharedDataAction_DataAccessName();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction <em>Subprogram Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subprogram Call Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction
	 * @generated
	 */
	EClass getSubprogramCallAction();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramNames <em>Subprogram Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subprogram Names</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramNames()
	 * @see #getSubprogramCallAction()
	 * @generated
	 */
	EReference getSubprogramCallAction_SubprogramNames();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramReference <em>Subprogram Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subprogram Reference</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogramReference()
	 * @see #getSubprogramCallAction()
	 * @generated
	 */
	EReference getSubprogramCallAction_SubprogramReference();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Labels</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels()
	 * @see #getSubprogramCallAction()
	 * @generated
	 */
	EReference getSubprogramCallAction_ParameterLabels();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction <em>Timed Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction
	 * @generated
	 */
	EClass getTimedAction();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime <em>Lower Behavior Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Behavior Time</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime()
	 * @see #getTimedAction()
	 * @generated
	 */
	EReference getTimedAction_LowerBehaviorTime();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperBehaviorTime <em>Upper Behavior Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Behavior Time</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperBehaviorTime()
	 * @see #getTimedAction()
	 * @generated
	 */
	EReference getTimedAction_UpperBehaviorTime();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.UnlockAction <em>Unlock Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlock Action</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnlockAction
	 * @generated
	 */
	EClass getUnlockAction();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement <em>While Or Do Until Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Or Do Until Statement</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement
	 * @generated
	 */
	EClass getWhileOrDoUntilStatement();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression <em>Logical Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Logical Value Expression</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression()
	 * @see #getWhileOrDoUntilStatement()
	 * @generated
	 */
	EReference getWhileOrDoUntilStatement_LogicalValueExpression();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil <em>Do Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Do Until</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil()
	 * @see #getWhileOrDoUntilStatement()
	 * @generated
	 */
	EAttribute getWhileOrDoUntilStatement_DoUntil();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime <em>Behavior Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Time</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime
	 * @generated
	 */
	EClass getBehaviorTime();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValueOwned <em>Integer Value Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Integer Value Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValueOwned()
	 * @see #getBehaviorTime()
	 * @generated
	 */
	EReference getBehaviorTime_IntegerValueOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier <em>Unit Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Identifier</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier()
	 * @see #getBehaviorTime()
	 * @generated
	 */
	EReference getBehaviorTime_UnitIdentifier();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Factor</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor
	 * @generated
	 */
	EClass getFactor();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueOwned <em>Value Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueOwned()
	 * @see #getFactor()
	 * @generated
	 */
	EReference getFactor_ValueOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueSdOwned <em>Value Sd Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Sd Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueSdOwned()
	 * @see #getFactor()
	 * @generated
	 */
	EReference getFactor_ValueSdOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binary Numeric Operator Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned()
	 * @see #getFactor()
	 * @generated
	 */
	EAttribute getFactor_BinaryNumericOperatorOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unary Numeric Operator Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned()
	 * @see #getFactor()
	 * @generated
	 */
	EAttribute getFactor_UnaryNumericOperatorOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unary Boolean Operator Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned()
	 * @see #getFactor()
	 * @generated
	 */
	EAttribute getFactor_UnaryBooleanOperatorOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getBase()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Base();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange <em>Integer Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Range</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange
	 * @generated
	 */
	EClass getIntegerRange();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Integer Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue()
	 * @see #getIntegerRange()
	 * @generated
	 */
	EReference getIntegerRange_LowerIntegerValue();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Integer Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue()
	 * @see #getIntegerRange()
	 * @generated
	 */
	EReference getIntegerRange_UpperIntegerValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value Constant</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
	 * @generated
	 */
	EClass getIntegerValueConstant();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value Variable</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
	 * @generated
	 */
	EClass getIntegerValueVariable();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral <em>Numeral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeral</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Numeral
	 * @generated
	 */
	EClass getNumeral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Numeral#getValue()
	 * @see #getNumeral()
	 * @generated
	 */
	EAttribute getNumeral_Value();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getValueString <em>Value String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value String</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getValueString()
	 * @see #getNumericLiteral()
	 * @generated
	 */
	EAttribute getNumericLiteral_ValueString();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant <em>Property Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Constant</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant
	 * @generated
	 */
	EClass getPropertyConstant();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PropertyValue
	 * @generated
	 */
	EClass getPropertyValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortCountValue <em>Port Count Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Count Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortCountValue
	 * @generated
	 */
	EClass getPortCountValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue <em>Port Dequeue Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Dequeue Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue
	 * @generated
	 */
	EClass getPortDequeueValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue <em>Port Fresh Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Fresh Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue
	 * @generated
	 */
	EClass getPortFreshValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.RealLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RealLiteral#getValue()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned <em>Simple Expression Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Expression Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_SimpleExpressionOwned();

	/**
	 * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Expression Sd Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_SimpleExpressionSdOwned();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relational Operator Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_RelationalOperatorOwned();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression <em>Simple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Expression</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression
	 * @generated
	 */
	EClass getSimpleExpression();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unary Adding Operator Owned</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned()
	 * @see #getSimpleExpression()
	 * @generated
	 */
	EAttribute getSimpleExpression_UnaryAddingOperatorOwned();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms()
	 * @see #getSimpleExpression()
	 * @generated
	 */
	EReference getSimpleExpression_Terms();

	/**
	 * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Binary Adding Operators</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators()
	 * @see #getSimpleExpression()
	 * @generated
	 */
	EAttribute getSimpleExpression_BinaryAddingOperators();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors <em>Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Factors</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Factors();

	/**
	 * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multiplying Operators</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_MultiplyingOperators();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Constant</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
	 * @generated
	 */
	EClass getValueConstant();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Expression</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression
	 * @generated
	 */
	EClass getValueExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations()
	 * @see #getValueExpression()
	 * @generated
	 */
	EReference getValueExpression_Relations();

	/**
	 * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Logical Operators</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators()
	 * @see #getValueExpression()
	 * @generated
	 */
	EAttribute getValueExpression_LogicalOperators();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Variable</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
	 * @generated
	 */
	EClass getValueVariable();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Type</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
	 * @generated
	 */
	EEnum getFeatureType();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType <em>Behavior Annex Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Behavior Annex Feature Type</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType
	 * @generated
	 */
	EEnum getBehaviorAnnexFeatureType();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Adding Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
	 * @generated
	 */
	EEnum getBinaryAddingOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Numeric Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
	 * @generated
	 */
	EEnum getBinaryNumericOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Representation</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
	 * @generated
	 */
	EEnum getDataRepresentation();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
	 * @generated
	 */
	EEnum getLogicalOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplying Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
	 * @generated
	 */
	EEnum getMultiplyingOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Adding Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @generated
	 */
	EEnum getUnaryAddingOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Boolean Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
	 * @generated
	 */
	EEnum getUnaryBooleanOperator();

	/**
	 * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Numeric Operator</em>'.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
	 * @generated
	 */
	EEnum getUnaryNumericOperator();

	/**
	 * Returns the meta object for data type '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @model instanceClass="boolean"
	 *        annotation="http://www.topcased.org/documentation documentation='A Boolean type is used for logical expression, consisting of the predefined values true and false.'"
	 * @generated
	 */
	EDataType getBoolean();

	/**
	 * Returns the meta object for data type '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @model instanceClass="int"
	 *        annotation="http://www.topcased.org/documentation documentation='An integer is a primitive type representing integer values.'"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '<em>Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real</em>'.
	 * @model instanceClass="double"
	 *        annotation="http://www.topcased.org/documentation documentation='A real is a primitive type representing real numeric values.'"
	 * @generated
	 */
	EDataType getReal();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        annotation="http://www.topcased.org/documentation documentation='A string is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters.'"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AadlBaFactory getAadlBaFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnex()
		 * @generated
		 */
		EClass BEHAVIOR_ANNEX = eINSTANCE.getBehaviorAnnex();
		/**
		 * The meta object literal for the '<em><b>Behavior Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES = eINSTANCE.getBehaviorAnnex_BehaviorVariables();
		/**
		 * The meta object literal for the '<em><b>Behavior States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ANNEX__BEHAVIOR_STATES = eINSTANCE.getBehaviorAnnex_BehaviorStates();
		/**
		 * The meta object literal for the '<em><b>Behavior Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS = eINSTANCE.getBehaviorAnnex_BehaviorTransitions();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
		 * @generated
		 */
		EClass BEHAVIOR_CONDITION = eINSTANCE.getBehaviorCondition();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorState()
		 * @generated
		 */
		EClass BEHAVIOR_STATE = eINSTANCE.getBehaviorState();
		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_STATE__IDENTIFIERS = eINSTANCE.getBehaviorState_Identifiers();
		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_STATE__INITIAL = eINSTANCE.getBehaviorState_Initial();
		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_STATE__COMPLETE = eINSTANCE.getBehaviorState_Complete();
		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR_STATE__FINAL = eINSTANCE.getBehaviorState_Final();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTransition()
		 * @generated
		 */
		EClass BEHAVIOR_TRANSITION = eINSTANCE.getBehaviorTransition();
		/**
		 * The meta object literal for the '<em><b>Transition Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER = eINSTANCE.getBehaviorTransition_TransitionIdentifier();
		/**
		 * The meta object literal for the '<em><b>Source State Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS = eINSTANCE.getBehaviorTransition_SourceStateIdentifiers();
		/**
		 * The meta object literal for the '<em><b>Behavior Condition Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED = eINSTANCE.getBehaviorTransition_BehaviorConditionOwned();
		/**
		 * The meta object literal for the '<em><b>Destination State Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER = eINSTANCE.getBehaviorTransition_DestinationStateIdentifier();
		/**
		 * The meta object literal for the '<em><b>Behavior Action Block Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED = eINSTANCE.getBehaviorTransition_BehaviorActionBlockOwned();
		/**
		 * The meta object literal for the '<em><b>Behavior Transition Priority</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY = eINSTANCE.getBehaviorTransition_BehaviorTransitionPriority();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariable()
		 * @generated
		 */
		EClass BEHAVIOR_VARIABLE = eINSTANCE.getBehaviorVariable();
		/**
		 * The meta object literal for the '<em><b>Local Variable Declarators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_VARIABLE__LOCAL_VARIABLE_DECLARATORS = eINSTANCE.getBehaviorVariable_LocalVariableDeclarators();
		/**
		 * The meta object literal for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_VARIABLE__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = eINSTANCE.getBehaviorVariable_DataUniqueComponentClassifierReference();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();
		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__BODY = eINSTANCE.getComment_Body();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl <em>Declarator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDeclarator()
		 * @generated
		 */
		EClass DECLARATOR = eINSTANCE.getDeclarator();
		/**
		 * The meta object literal for the '<em><b>Identifier Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATOR__IDENTIFIER_OWNED = eINSTANCE.getDeclarator_IdentifierOwned();
		/**
		 * The meta object literal for the '<em><b>Array Sizes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATOR__ARRAY_SIZES = eINSTANCE.getDeclarator_ArraySizes();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();
		/**
		 * The meta object literal for the '<em><b>Ba Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__BA_REF = eINSTANCE.getElement_BaRef();
		/**
		 * The meta object literal for the '<em><b>Aadl Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__AADL_REF = eINSTANCE.getElement_AadlRef();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
		 * @generated
		 */
		EClass EXECUTE_CONDITION = eINSTANCE.getExecuteCondition();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER__ID = eINSTANCE.getIdentifier_Id();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();
		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__QUALIFIED_NAME = eINSTANCE.getNamedElement_QualifiedName();
		/**
		 * The meta object literal for the '<em><b>Namespace Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAMESPACE_SEPARATOR = eINSTANCE.getNamedElement_NamespaceSeparator();
		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAMESPACE = eINSTANCE.getNamedElement_Namespace();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl <em>Otherwise</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getOtherwise()
		 * @generated
		 */
		EClass OTHERWISE = eINSTANCE.getOtherwise();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimeoutCatchImpl <em>Timeout Catch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimeoutCatchImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimeoutCatch()
		 * @generated
		 */
		EClass TIMEOUT_CATCH = eINSTANCE.getTimeoutCatch();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl <em>Unique Component Classifier Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUniqueComponentClassifierReference()
		 * @generated
		 */
		EClass UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = eINSTANCE.getUniqueComponentClassifierReference();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl <em>Completion Relative Timeout Condition And Catch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCompletionRelativeTimeoutConditionAndCatch()
		 * @generated
		 */
		EClass COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH = eINSTANCE.getCompletionRelativeTimeoutConditionAndCatch();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchCondition()
		 * @generated
		 */
		EClass DISPATCH_CONDITION = eINSTANCE.getDispatchCondition();
		/**
		 * The meta object literal for the '<em><b>Dispatch Trigger Condition Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED = eINSTANCE.getDispatchCondition_DispatchTriggerConditionOwned();
		/**
		 * The meta object literal for the '<em><b>Frozen Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_CONDITION__FROZEN_PORTS = eINSTANCE.getDispatchCondition_FrozenPorts();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchConjunction()
		 * @generated
		 */
		EClass DISPATCH_CONJUNCTION = eINSTANCE.getDispatchConjunction();
		/**
		 * The meta object literal for the '<em><b>Dispatch Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS = eINSTANCE.getDispatchConjunction_DispatchTriggers();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerCondition()
		 * @generated
		 */
		EClass DISPATCH_TRIGGER_CONDITION = eINSTANCE.getDispatchTriggerCondition();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl <em>Dispatch Trigger Condition Stop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerConditionStop()
		 * @generated
		 */
		EClass DISPATCH_TRIGGER_CONDITION_STOP = eINSTANCE.getDispatchTriggerConditionStop();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerLogicalExpression()
		 * @generated
		 */
		EClass DISPATCH_TRIGGER_LOGICAL_EXPRESSION = eINSTANCE.getDispatchTriggerLogicalExpression();
		/**
		 * The meta object literal for the '<em><b>Dispatch Conjunctions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS = eINSTANCE.getDispatchTriggerLogicalExpression_DispatchConjunctions();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAssignmentAction()
		 * @generated
		 */
		EClass ASSIGNMENT_ACTION = eINSTANCE.getAssignmentAction();
		/**
		 * The meta object literal for the '<em><b>Target Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_ACTION__TARGET_OWNED = eINSTANCE.getAssignmentAction_TargetOwned();
		/**
		 * The meta object literal for the '<em><b>Value Expression Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED = eINSTANCE.getAssignmentAction_ValueExpressionOwned();
		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_ACTION__ANY = eINSTANCE.getAssignmentAction_Any();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
		 * @generated
		 */
		EClass BASIC_ACTION = eINSTANCE.getBasicAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
		 * @generated
		 */
		EClass BEHAVIOR_ACTION = eINSTANCE.getBehaviorAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionBlock()
		 * @generated
		 */
		EClass BEHAVIOR_ACTION_BLOCK = eINSTANCE.getBehaviorActionBlock();
		/**
		 * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getBehaviorActionBlock_BehaviorActionsOwned();
		/**
		 * The meta object literal for the '<em><b>Behavior Time Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED = eINSTANCE.getBehaviorActionBlock_BehaviorTimeOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionCollection()
		 * @generated
		 */
		EClass BEHAVIOR_ACTION_COLLECTION = eINSTANCE.getBehaviorActionCollection();
		/**
		 * The meta object literal for the '<em><b>Behavior Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS = eINSTANCE.getBehaviorActionCollection_BehaviorActions();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
		 * @generated
		 */
		EClass BEHAVIOR_ACTIONS = eINSTANCE.getBehaviorActions();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSequence()
		 * @generated
		 */
		EClass BEHAVIOR_ACTION_SEQUENCE = eINSTANCE.getBehaviorActionSequence();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSet()
		 * @generated
		 */
		EClass BEHAVIOR_ACTION_SET = eINSTANCE.getBehaviorActionSet();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
		 * @generated
		 */
		EClass COMMUNICATION_ACTION = eINSTANCE.getCommunicationAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
		 * @generated
		 */
		EClass COND_STATEMENT = eINSTANCE.getCondStatement();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl <em>Data Component Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataComponentReference()
		 * @generated
		 */
		EClass DATA_COMPONENT_REFERENCE = eINSTANCE.getDataComponentReference();
		/**
		 * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_COMPONENT_REFERENCE__NAMES = eINSTANCE.getDataComponentReference_Names();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
		 * @generated
		 */
		EClass ELEMENT_VALUES = eINSTANCE.getElementValues();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl <em>For Or For All Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getForOrForAllStatement()
		 * @generated
		 */
		EClass FOR_OR_FOR_ALL_STATEMENT = eINSTANCE.getForOrForAllStatement();
		/**
		 * The meta object literal for the '<em><b>Element Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER = eINSTANCE.getForOrForAllStatement_ElementIdentifier();
		/**
		 * The meta object literal for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = eINSTANCE.getForOrForAllStatement_DataUniqueComponentClassifierReference();
		/**
		 * The meta object literal for the '<em><b>Element Values Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED = eINSTANCE.getForOrForAllStatement_ElementValuesOwned();
		/**
		 * The meta object literal for the '<em><b>For All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = eINSTANCE.getForOrForAllStatement_ForAll();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();
		/**
		 * The meta object literal for the '<em><b>Has Else</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_STATEMENT__HAS_ELSE = eINSTANCE.getIfStatement_HasElse();
		/**
		 * The meta object literal for the '<em><b>Logical Value Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS = eINSTANCE.getIfStatement_LogicalValueExpressions();
		/**
		 * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getIfStatement_BehaviorActionsOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl <em>Lock Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLockAction()
		 * @generated
		 */
		EClass LOCK_ACTION = eINSTANCE.getLockAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLoopStatement()
		 * @generated
		 */
		EClass LOOP_STATEMENT = eINSTANCE.getLoopStatement();
		/**
		 * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getLoopStatement_BehaviorActionsOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl <em>Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getName_()
		 * @generated
		 */
		EClass NAME = eINSTANCE.getName_();
		/**
		 * The meta object literal for the '<em><b>Identifier Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME__IDENTIFIER_OWNED = eINSTANCE.getName_IdentifierOwned();
		/**
		 * The meta object literal for the '<em><b>Array Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME__ARRAY_INDEXES = eINSTANCE.getName_ArrayIndexes();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
		 * @generated
		 */
		EClass PARAMETER_LABEL = eINSTANCE.getParameterLabel();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl <em>Port Dequeue Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueAction()
		 * @generated
		 */
		EClass PORT_DEQUEUE_ACTION = eINSTANCE.getPortDequeueAction();
		/**
		 * The meta object literal for the '<em><b>Port Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_DEQUEUE_ACTION__PORT_NAME = eINSTANCE.getPortDequeueAction_PortName();
		/**
		 * The meta object literal for the '<em><b>Target Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_DEQUEUE_ACTION__TARGET_OWNED = eINSTANCE.getPortDequeueAction_TargetOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl <em>Port Freeze Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreezeAction()
		 * @generated
		 */
		EClass PORT_FREEZE_ACTION = eINSTANCE.getPortFreezeAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl <em>Port Send Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortSendAction()
		 * @generated
		 */
		EClass PORT_SEND_ACTION = eINSTANCE.getPortSendAction();
		/**
		 * The meta object literal for the '<em><b>Port Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SEND_ACTION__PORT_NAME = eINSTANCE.getPortSendAction_PortName();
		/**
		 * The meta object literal for the '<em><b>Value Expression Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED = eINSTANCE.getPortSendAction_ValueExpressionOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl <em>Shared Data Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSharedDataAction()
		 * @generated
		 */
		EClass SHARED_DATA_ACTION = eINSTANCE.getSharedDataAction();
		/**
		 * The meta object literal for the '<em><b>Data Access Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_DATA_ACTION__DATA_ACCESS_NAME = eINSTANCE.getSharedDataAction_DataAccessName();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl <em>Subprogram Call Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramCallAction()
		 * @generated
		 */
		EClass SUBPROGRAM_CALL_ACTION = eINSTANCE.getSubprogramCallAction();
		/**
		 * The meta object literal for the '<em><b>Subprogram Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES = eINSTANCE.getSubprogramCallAction_SubprogramNames();
		/**
		 * The meta object literal for the '<em><b>Subprogram Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE = eINSTANCE.getSubprogramCallAction_SubprogramReference();
		/**
		 * The meta object literal for the '<em><b>Parameter Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS = eINSTANCE.getSubprogramCallAction_ParameterLabels();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl <em>Timed Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimedAction()
		 * @generated
		 */
		EClass TIMED_ACTION = eINSTANCE.getTimedAction();
		/**
		 * The meta object literal for the '<em><b>Lower Behavior Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_ACTION__LOWER_BEHAVIOR_TIME = eINSTANCE.getTimedAction_LowerBehaviorTime();
		/**
		 * The meta object literal for the '<em><b>Upper Behavior Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_ACTION__UPPER_BEHAVIOR_TIME = eINSTANCE.getTimedAction_UpperBehaviorTime();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl <em>Unlock Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnlockAction()
		 * @generated
		 */
		EClass UNLOCK_ACTION = eINSTANCE.getUnlockAction();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl <em>While Or Do Until Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileOrDoUntilStatement()
		 * @generated
		 */
		EClass WHILE_OR_DO_UNTIL_STATEMENT = eINSTANCE.getWhileOrDoUntilStatement();
		/**
		 * The meta object literal for the '<em><b>Logical Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION = eINSTANCE.getWhileOrDoUntilStatement_LogicalValueExpression();
		/**
		 * The meta object literal for the '<em><b>Do Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL = eINSTANCE.getWhileOrDoUntilStatement_DoUntil();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTime()
		 * @generated
		 */
		EClass BEHAVIOR_TIME = eINSTANCE.getBehaviorTime();
		/**
		 * The meta object literal for the '<em><b>Integer Value Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TIME__INTEGER_VALUE_OWNED = eINSTANCE.getBehaviorTime_IntegerValueOwned();
		/**
		 * The meta object literal for the '<em><b>Unit Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TIME__UNIT_IDENTIFIER = eINSTANCE.getBehaviorTime_UnitIdentifier();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl <em>Factor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFactor()
		 * @generated
		 */
		EClass FACTOR = eINSTANCE.getFactor();
		/**
		 * The meta object literal for the '<em><b>Value Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__VALUE_OWNED = eINSTANCE.getFactor_ValueOwned();
		/**
		 * The meta object literal for the '<em><b>Value Sd Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__VALUE_SD_OWNED = eINSTANCE.getFactor_ValueSdOwned();
		/**
		 * The meta object literal for the '<em><b>Binary Numeric Operator Owned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACTOR__BINARY_NUMERIC_OPERATOR_OWNED = eINSTANCE.getFactor_BinaryNumericOperatorOwned();
		/**
		 * The meta object literal for the '<em><b>Unary Numeric Operator Owned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACTOR__UNARY_NUMERIC_OPERATOR_OWNED = eINSTANCE.getFactor_UnaryNumericOperatorOwned();
		/**
		 * The meta object literal for the '<em><b>Unary Boolean Operator Owned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED = eINSTANCE.getFactor_UnaryBooleanOperatorOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerLiteralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();
		/**
		 * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__BASE = eINSTANCE.getIntegerLiteral_Base();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerRange()
		 * @generated
		 */
		EClass INTEGER_RANGE = eINSTANCE.getIntegerRange();
		/**
		 * The meta object literal for the '<em><b>Lower Integer Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_RANGE__LOWER_INTEGER_VALUE = eINSTANCE.getIntegerRange_LowerIntegerValue();
		/**
		 * The meta object literal for the '<em><b>Upper Integer Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_RANGE__UPPER_INTEGER_VALUE = eINSTANCE.getIntegerRange_UpperIntegerValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
		 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueConstant()
		 * @generated
		 */
		EClass INTEGER_VALUE_CONSTANT = eINSTANCE.getIntegerValueConstant();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueVariable()
		 * @generated
		 */
		EClass INTEGER_VALUE_VARIABLE = eINSTANCE.getIntegerValueVariable();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl <em>Numeral</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumeral()
		 * @generated
		 */
		EClass NUMERAL = eINSTANCE.getNumeral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERAL__VALUE = eINSTANCE.getNumeral_Value();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();
		/**
		 * The meta object literal for the '<em><b>Value String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL__VALUE_STRING = eINSTANCE.getNumericLiteral_ValueString();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl <em>Property Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPropertyConstant()
		 * @generated
		 */
		EClass PROPERTY_CONSTANT = eINSTANCE.getPropertyConstant();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyValueImpl <em>Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyValueImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPropertyValue()
		 * @generated
		 */
		EClass PROPERTY_VALUE = eINSTANCE.getPropertyValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl <em>Port Count Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortCountValue()
		 * @generated
		 */
		EClass PORT_COUNT_VALUE = eINSTANCE.getPortCountValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl <em>Port Dequeue Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueValue()
		 * @generated
		 */
		EClass PORT_DEQUEUE_VALUE = eINSTANCE.getPortDequeueValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl <em>Port Fresh Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreshValue()
		 * @generated
		 */
		EClass PORT_FRESH_VALUE = eINSTANCE.getPortFreshValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RealLiteralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRealLiteral()
		 * @generated
		 */
		EClass REAL_LITERAL = eINSTANCE.getRealLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();
		/**
		 * The meta object literal for the '<em><b>Simple Expression Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SIMPLE_EXPRESSION_OWNED = eINSTANCE.getRelation_SimpleExpressionOwned();
		/**
		 * The meta object literal for the '<em><b>Simple Expression Sd Owned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SIMPLE_EXPRESSION_SD_OWNED = eINSTANCE.getRelation_SimpleExpressionSdOwned();
		/**
		 * The meta object literal for the '<em><b>Relational Operator Owned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__RELATIONAL_OPERATOR_OWNED = eINSTANCE.getRelation_RelationalOperatorOwned();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl <em>Simple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSimpleExpression()
		 * @generated
		 */
		EClass SIMPLE_EXPRESSION = eINSTANCE.getSimpleExpression();
		/**
		 * The meta object literal for the '<em><b>Unary Adding Operator Owned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED = eINSTANCE.getSimpleExpression_UnaryAddingOperatorOwned();
		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_EXPRESSION__TERMS = eINSTANCE.getSimpleExpression_Terms();
		/**
		 * The meta object literal for the '<em><b>Binary Adding Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS = eINSTANCE.getSimpleExpression_BinaryAddingOperators();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();
		/**
		 * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__FACTORS = eINSTANCE.getTerm_Factors();
		/**
		 * The meta object literal for the '<em><b>Multiplying Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__MULTIPLYING_OPERATORS = eINSTANCE.getTerm_MultiplyingOperators();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.Value
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueConstant()
		 * @generated
		 */
		EClass VALUE_CONSTANT = eINSTANCE.getValueConstant();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueExpression()
		 * @generated
		 */
		EClass VALUE_EXPRESSION = eINSTANCE.getValueExpression();
		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_EXPRESSION__RELATIONS = eINSTANCE.getValueExpression_Relations();
		/**
		 * The meta object literal for the '<em><b>Logical Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_EXPRESSION__LOGICAL_OPERATORS = eINSTANCE.getValueExpression_LogicalOperators();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
		 * @generated
		 */
		EClass VALUE_VARIABLE = eINSTANCE.getValueVariable();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeatureType()
		 * @generated
		 */
		EEnum FEATURE_TYPE = eINSTANCE.getFeatureType();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType <em>Behavior Annex Feature Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnexFeatureType
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnexFeatureType()
		 * @generated
		 */
		EEnum BEHAVIOR_ANNEX_FEATURE_TYPE = eINSTANCE.getBehaviorAnnexFeatureType();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryAddingOperator()
		 * @generated
		 */
		EEnum BINARY_ADDING_OPERATOR = eINSTANCE.getBinaryAddingOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
		 * @generated
		 */
		EEnum BINARY_NUMERIC_OPERATOR = eINSTANCE.getBinaryNumericOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataRepresentation()
		 * @generated
		 */
		EEnum DATA_REPRESENTATION = eINSTANCE.getDataRepresentation();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLogicalOperator()
		 * @generated
		 */
		EEnum LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getMultiplyingOperator()
		 * @generated
		 */
		EEnum MULTIPLYING_OPERATOR = eINSTANCE.getMultiplyingOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
		 * @generated
		 */
		EEnum UNARY_ADDING_OPERATOR = eINSTANCE.getUnaryAddingOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
		 * @generated
		 */
		EEnum UNARY_BOOLEAN_OPERATOR = eINSTANCE.getUnaryBooleanOperator();
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryNumericOperator()
		 * @generated
		 */
		EEnum UNARY_NUMERIC_OPERATOR = eINSTANCE.getUnaryNumericOperator();
		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();
		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();
		/**
		 * The meta object literal for the '<em>Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getReal()
		 * @generated
		 */
		EDataType REAL = eINSTANCE.getReal();
		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

	}

} //AadlBaPackage
