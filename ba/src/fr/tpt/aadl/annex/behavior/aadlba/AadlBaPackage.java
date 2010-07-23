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
public interface AadlBaPackage extends EPackage
{
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
   String eNS_URI = "http:///AADLBA";

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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl <em>Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElement()
    * @generated
    */
   int ELEMENT = 0;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT__BA_REFERENCED_ENTITY = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT__AADL_REFERENCED_ENTITY = Aadl2Package.ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl <em>Comment</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CommentImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getComment()
    * @generated
    */
   int COMMENT = 1;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMENT__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMENT__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl <em>Named Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NamedElementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNamedElement()
    * @generated
    */
   int NAMED_ELEMENT = 2;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT__NAMESPACE = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Named Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl <em>Namespace</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNamespace()
    * @generated
    */
   int NAMESPACE = 3;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__OWNER = NAMED_ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

   /**
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

   /**
    * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__OWNED_MEMBER = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Member</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE__MEMBER = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Namespace</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GlobalNamespaceImpl <em>Global Namespace</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GlobalNamespaceImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGlobalNamespace()
    * @generated
    */
   int GLOBAL_NAMESPACE = 4;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__OWNED_ELEMENT = NAMESPACE__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__OWNER = NAMESPACE__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__BA_REFERENCED_ENTITY = NAMESPACE__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__AADL_REFERENCED_ENTITY = NAMESPACE__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__NAME = NAMESPACE__NAME;

   /**
    * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__QUALIFIED_NAME = NAMESPACE__QUALIFIED_NAME;

   /**
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__NAMESPACE = NAMESPACE__NAMESPACE;

   /**
    * The feature id for the '<em><b>Owned Member</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__OWNED_MEMBER = NAMESPACE__OWNED_MEMBER;

   /**
    * The feature id for the '<em><b>Member</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE__MEMBER = NAMESPACE__MEMBER;

   /**
    * The number of structural features of the '<em>Global Namespace</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLOBAL_NAMESPACE_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnex()
    * @generated
    */
   int BEHAVIOR_ANNEX = 5;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Variables</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX__VARIABLES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>States</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX__STATES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX__TRANSITIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 4;

   /**
    * The number of structural features of the '<em>Behavior Annex</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ANNEX_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 5;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl <em>Unique Component Classifier Reference</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UniqueComponentClassifierReferenceImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUniqueComponentClassifierReference()
    * @generated
    */
   int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = 6;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int UNIQUE_COMPONENT_CLASSIFIER_REFERENCE__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariable()
    * @generated
    */
   int BEHAVIOR_VARIABLE = 7;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_VARIABLE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_VARIABLE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Persistent</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_VARIABLE__PERSISTENT = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Behavior Variable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_VARIABLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorState()
    * @generated
    */
   int BEHAVIOR_STATE = 8;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_STATE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_STATE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Behavior State Identifiers</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS = ELEMENT_FEATURE_COUNT + 0;

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
   int BEHAVIOR_TRANSITION = 9;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Source State Identifiers</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Behavior Condition Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Behavior Transition Priority</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Destination State Identifier</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Transition Identifier</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>Timeout</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION__TIMEOUT = ELEMENT_FEATURE_COUNT + 6;

   /**
    * The number of structural features of the '<em>Behavior Transition</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TRANSITION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 7;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorConditionImpl <em>Behavior Condition</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorConditionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
    * @generated
    */
   int BEHAVIOR_CONDITION = 10;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_CONDITION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_CONDITION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Behavior Condition</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_CONDITION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl <em>Declarator</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDeclarator()
    * @generated
    */
   int DECLARATOR = 11;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__OWNER = NAMED_ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

   /**
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

   /**
    * The feature id for the '<em><b>Array Sizes</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR__ARRAY_SIZES = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Declarator</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DECLARATOR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArraySizeImpl <em>Array Size</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ArraySizeImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getArraySize()
    * @generated
    */
   int ARRAY_SIZE = 12;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Integer Value Constant</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE__INTEGER_VALUE_CONSTANT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Array Size</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_SIZE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchCondition()
    * @generated
    */
   int DISPATCH_CONDITION = 13;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION__BA_REFERENCED_ENTITY = BEHAVIOR_CONDITION__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION__AADL_REFERENCED_ENTITY = BEHAVIOR_CONDITION__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Has Frozen Ports</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION__HAS_FROZEN_PORTS = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>The Dispatch Logical Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION = BEHAVIOR_CONDITION_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Frozen Ports</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION__FROZEN_PORTS = BEHAVIOR_CONDITION_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Dispatch Condition</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl <em>Dispatch Logical Expression</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchLogicalExpression()
    * @generated
    */
   int DISPATCH_LOGICAL_EXPRESSION = 14;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Dispatch Triggers</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Or Expression</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>And Expression</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Xor Expression</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Stop</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION__STOP = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The number of structural features of the '<em>Dispatch Logical Expression</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_LOGICAL_EXPRESSION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl <em>Dispatch Trigger</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTrigger()
    * @generated
    */
   int DISPATCH_TRIGGER = 15;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>The Dispatch Logical Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>The Behavior Time</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__THE_BEHAVIOR_TIME = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Identifier Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__IDENTIFIER_OWNED = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Dispatch Triggers</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__DISPATCH_TRIGGERS = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Numeral Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__NUMERAL_OWNED = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Value Constant Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>Not</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__NOT = ELEMENT_FEATURE_COUNT + 6;

   /**
    * The feature id for the '<em><b>Timeout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__TIMEOUT = ELEMENT_FEATURE_COUNT + 7;

   /**
    * The feature id for the '<em><b>Others</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OTHERS = ELEMENT_FEATURE_COUNT + 8;

   /**
    * The feature id for the '<em><b>Or More</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OR_MORE = ELEMENT_FEATURE_COUNT + 9;

   /**
    * The feature id for the '<em><b>Or Less</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER__OR_LESS = ELEMENT_FEATURE_COUNT + 10;

   /**
    * The number of structural features of the '<em>Dispatch Trigger</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DISPATCH_TRIGGER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 11;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl <em>Behavior Actions</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
    * @generated
    */
   int BEHAVIOR_ACTIONS = 16;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Behavior Action</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS__BEHAVIOR_ACTION = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Sequence</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS__SEQUENCE = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Set</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS__SET = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Behavior Actions</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTIONS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl <em>Behavior Action</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
    * @generated
    */
   int BEHAVIOR_ACTION = 17;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Basic Action Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__BASIC_ACTION_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Cond Statement Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__COND_STATEMENT_OWNED = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Basic Action</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__BASIC_ACTION = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>If</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__IF = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>For</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__FOR = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>While</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__WHILE = ELEMENT_FEATURE_COUNT + 6;

   /**
    * The feature id for the '<em><b>Do Until</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__DO_UNTIL = ELEMENT_FEATURE_COUNT + 7;

   /**
    * The feature id for the '<em><b>Timeout</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION__TIMEOUT = ELEMENT_FEATURE_COUNT + 8;

   /**
    * The number of structural features of the '<em>Behavior Action</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_ACTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 9;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CondStatementImpl <em>Cond Statement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CondStatementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
    * @generated
    */
   int COND_STATEMENT = 18;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Cond Statement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COND_STATEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BasicActionImpl <em>Basic Action</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BasicActionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
    * @generated
    */
   int BASIC_ACTION = 19;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Basic Action</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BASIC_ACTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl <em>If Statement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIfStatement()
    * @generated
    */
   int IF_STATEMENT = 20;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Has Else</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__HAS_ELSE = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Value Expression Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__VALUE_EXPRESSION_OWNED = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>If Statement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IF_STATEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl <em>For Or For All Statement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getForOrForAllStatement()
    * @generated
    */
   int FOR_OR_FOR_ALL_STATEMENT = 21;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__OWNER = NAMED_ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

   /**
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

   /**
    * The feature id for the '<em><b>Data Unique Cmt Class Ref</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Element Values Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = NAMED_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>For All</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = NAMED_ELEMENT_FEATURE_COUNT + 3;

   /**
    * The number of structural features of the '<em>For Or For All Statement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FOR_OR_FOR_ALL_STATEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileStatementImpl <em>While Statement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileStatementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileStatement()
    * @generated
    */
   int WHILE_STATEMENT = 22;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__OWNER = COND_STATEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__BA_REFERENCED_ENTITY = COND_STATEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__AADL_REFERENCED_ENTITY = COND_STATEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Value Expression Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__VALUE_EXPRESSION_OWNED = COND_STATEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT__BEHAVIOR_ACTIONS_OWNED = COND_STATEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>While Statement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int WHILE_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DoUntilStatementImpl <em>Do Until Statement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DoUntilStatementImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDoUntilStatement()
    * @generated
    */
   int DO_UNTIL_STATEMENT = 23;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__OWNER = COND_STATEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__BA_REFERENCED_ENTITY = COND_STATEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__AADL_REFERENCED_ENTITY = COND_STATEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = COND_STATEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Value Expression Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT__VALUE_EXPRESSION_OWNED = COND_STATEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Do Until Statement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DO_UNTIL_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementValuesImpl <em>Element Values</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElementValuesImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
    * @generated
    */
   int ELEMENT_VALUES = 24;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT_VALUES__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT_VALUES__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Element Values</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ELEMENT_VALUES_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAssignmentAction()
    * @generated
    */
   int ASSIGNMENT_ACTION = 25;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ASSIGNMENT_ACTION__BA_REFERENCED_ENTITY = BASIC_ACTION__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ASSIGNMENT_ACTION__AADL_REFERENCED_ENTITY = BASIC_ACTION__AADL_REFERENCED_ENTITY;

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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl <em>Communication Action</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
    * @generated
    */
   int COMMUNICATION_ACTION = 26;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__BA_REFERENCED_ENTITY = BASIC_ACTION__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__AADL_REFERENCED_ENTITY = BASIC_ACTION__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Action Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__ACTION_TYPE = BASIC_ACTION_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Elt Name Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__ELT_NAME_OWNED = BASIC_ACTION_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Subpgm Param List Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED = BASIC_ACTION_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Has Value Expression</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION = BASIC_ACTION_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Has Target</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__HAS_TARGET = BASIC_ACTION_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Value Expr Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__VALUE_EXPR_OWNED = BASIC_ACTION_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>Tar Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__TAR_OWNED = BASIC_ACTION_FEATURE_COUNT + 6;

   /**
    * The feature id for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = BASIC_ACTION_FEATURE_COUNT + 7;

   /**
    * The feature id for the '<em><b>Catch Timeout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__CATCH_TIMEOUT = BASIC_ACTION_FEATURE_COUNT + 8;

   /**
    * The feature id for the '<em><b>All</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION__ALL = BASIC_ACTION_FEATURE_COUNT + 9;

   /**
    * The number of structural features of the '<em>Communication Action</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int COMMUNICATION_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 10;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramParameterListImpl <em>Subprogram Parameter List</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramParameterListImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramParameterList()
    * @generated
    */
   int SUBPROGRAM_PARAMETER_LIST = 27;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Parameter List</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Subprogram Parameter List</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SUBPROGRAM_PARAMETER_LIST_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl <em>Timed Action</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimedAction()
    * @generated
    */
   int TIMED_ACTION = 28;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TIMED_ACTION__BA_REFERENCED_ENTITY = BASIC_ACTION__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TIMED_ACTION__AADL_REFERENCED_ENTITY = BASIC_ACTION__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Behavior Times Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TIMED_ACTION__BEHAVIOR_TIMES_OWNED = BASIC_ACTION_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Computation</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TIMED_ACTION__COMPUTATION = BASIC_ACTION_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Timed Action</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TIMED_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterLabelImpl <em>Parameter Label</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterLabelImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
    * @generated
    */
   int PARAMETER_LABEL = 30;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PARAMETER_LABEL__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PARAMETER_LABEL__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Parameter Label</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PARAMETER_LABEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl <em>Target</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTarget()
    * @generated
    */
   int TARGET = 29;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TARGET__BA_REFERENCED_ENTITY = PARAMETER_LABEL__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TARGET__AADL_REFERENCED_ENTITY = PARAMETER_LABEL__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Element Name Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TARGET__ELEMENT_NAME_OWNED = PARAMETER_LABEL_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Data Component Reference Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TARGET__DATA_COMPONENT_REFERENCE_OWNED = PARAMETER_LABEL_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Target</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TARGET_FEATURE_COUNT = PARAMETER_LABEL_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl <em>Data Component Reference</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataComponentReference()
    * @generated
    */
   int DATA_COMPONENT_REFERENCE = 31;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Elements Name Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Data Component Reference</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int DATA_COMPONENT_REFERENCE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl <em>Name</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getName_()
    * @generated
    */
   int NAME = 32;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__OWNED_ELEMENT = NAMED_ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__OWNER = NAMED_ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__NAME = NAMED_ELEMENT__NAME;

   /**
    * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

   /**
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

   /**
    * The feature id for the '<em><b>Array Index List Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__ARRAY_INDEX_LIST_OWNED = NAMED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Identifier</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME__IDENTIFIER = NAMED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Name</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NAME_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArrayIndexImpl <em>Array Index</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ArrayIndexImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getArrayIndex()
    * @generated
    */
   int ARRAY_INDEX = 33;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Integer Value Variable Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Array Index</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARRAY_INDEX_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueImpl <em>Value</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
    * @generated
    */
   int VALUE = 34;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Value</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl <em>Value Variable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
    * @generated
    */
   int VALUE_VARIABLE = 35;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__BA_REFERENCED_ENTITY = VALUE__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__AADL_REFERENCED_ENTITY = VALUE__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Data Component Reference Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED = VALUE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Interrogation</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__INTERROGATION = VALUE_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Count</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__COUNT = VALUE_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Fresh</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__FRESH = VALUE_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Has Data Cpt Ref</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__HAS_DATA_CPT_REF = VALUE_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Element Name Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE__ELEMENT_NAME_OWNED = VALUE_FEATURE_COUNT + 5;

   /**
    * The number of structural features of the '<em>Value Variable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 6;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueConstantImpl <em>Value Constant</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueConstantImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueConstant()
    * @generated
    */
   int VALUE_CONSTANT = 36;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_CONSTANT__BA_REFERENCED_ENTITY = VALUE__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_CONSTANT__AADL_REFERENCED_ENTITY = VALUE__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Value Constant</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_CONSTANT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueExpression()
    * @generated
    */
   int VALUE_EXPRESSION = 37;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION__BA_REFERENCED_ENTITY = VALUE__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION__AADL_REFERENCED_ENTITY = VALUE__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Relations Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION__RELATIONS_OWNED = VALUE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Logical Operators Owned</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED = VALUE_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Has Logical Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR = VALUE_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Value Expression</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VALUE_EXPRESSION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl <em>Relation</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelation()
    * @generated
    */
   int RELATION = 38;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RELATION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RELATION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Has Relational Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RELATION__HAS_RELATIONAL_OPERATOR = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The number of structural features of the '<em>Relation</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int RELATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl <em>Simple Expression</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSimpleExpression()
    * @generated
    */
   int SIMPLE_EXPRESSION = 39;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Terms Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__TERMS_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Unary Adding Operator Owned</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Has Unary Adding Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Binary Adding Operator Owned</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Has Binary Adding Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR = ELEMENT_FEATURE_COUNT + 4;

   /**
    * The number of structural features of the '<em>Simple Expression</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int SIMPLE_EXPRESSION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl <em>Term</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTerm()
    * @generated
    */
   int TERM = 40;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Factors Owned</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM__FACTORS_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Has Multiplying Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM__HAS_MULTIPLYING_OPERATOR = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Multiplying Operators Owned</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM__MULTIPLYING_OPERATORS_OWNED = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>Term</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl <em>Factor</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFactor()
    * @generated
    */
   int FACTOR = 41;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Has Binary Numeric Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR__HAS_BINARY_NUMERIC_OPERATOR = ELEMENT_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>Has Unary Numeric Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR__HAS_UNARY_NUMERIC_OPERATOR = ELEMENT_FEATURE_COUNT + 6;

   /**
    * The feature id for the '<em><b>Has Unary Boolean Operator</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR__HAS_UNARY_BOOLEAN_OPERATOR = ELEMENT_FEATURE_COUNT + 7;

   /**
    * The number of structural features of the '<em>Factor</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FACTOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 8;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerRange()
    * @generated
    */
   int INTEGER_RANGE = 42;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__OWNED_ELEMENT = ELEMENT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__OWNER = ELEMENT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Lower Integer Value</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__LOWER_INTEGER_VALUE = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Upper Integer Value</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE__UPPER_INTEGER_VALUE = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Integer Range</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_RANGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerValueImpl <em>Integer Value</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerValueImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
    * @generated
    */
   int INTEGER_VALUE = 43;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_VALUE__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_VALUE__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The number of structural features of the '<em>Integer Value</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int INTEGER_VALUE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTime()
    * @generated
    */
   int BEHAVIOR_TIME = 44;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TIME__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TIME__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Integer Value Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BEHAVIOR_TIME__INTEGER_VALUE_OWNED = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Unit Identifier</b></em>' attribute.
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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl <em>Property Constant</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PropertyConstantImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPropertyConstant()
    * @generated
    */
   int PROPERTY_CONSTANT = 45;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY_CONSTANT__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY_CONSTANT__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
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
   int PROPERTY_VALUE = 46;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY_VALUE__BA_REFERENCED_ENTITY = NAMED_ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY_VALUE__AADL_REFERENCED_ENTITY = NAMED_ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The feature id for the '<em><b>Namespace</b></em>' container reference.
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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl <em>Identifier</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IdentifierImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIdentifier()
    * @generated
    */
   int IDENTIFIER = 47;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IDENTIFIER__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int IDENTIFIER__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

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
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
    * @generated
    */
   int NUMERIC_LITERAL = 48;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__OWNER = VALUE_CONSTANT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__BA_REFERENCED_ENTITY = VALUE_CONSTANT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__AADL_REFERENCED_ENTITY = VALUE_CONSTANT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Num Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL__NUM_VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Numeric Literal</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERIC_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBooleanLiteral()
    * @generated
    */
   int BOOLEAN_LITERAL = 49;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__OWNER = VALUE_CONSTANT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__BA_REFERENCED_ENTITY = VALUE_CONSTANT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__AADL_REFERENCED_ENTITY = VALUE_CONSTANT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Bool Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL__BOOL_VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Boolean Literal</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BOOLEAN_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl <em>String Literal</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StringLiteralImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStringLiteral()
    * @generated
    */
   int STRING_LITERAL = 50;

   /**
    * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

   /**
    * The feature id for the '<em><b>Owner</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__OWNER = VALUE_CONSTANT__OWNER;

   /**
    * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

   /**
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__BA_REFERENCED_ENTITY = VALUE_CONSTANT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__AADL_REFERENCED_ENTITY = VALUE_CONSTANT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>String Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL__STRING_VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>String Literal</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl <em>Numeral</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumeralImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumeral()
    * @generated
    */
   int NUMERAL = 51;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERAL__BA_REFERENCED_ENTITY = ELEMENT__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERAL__AADL_REFERENCED_ENTITY = ELEMENT__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Numeral Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERAL__NUMERAL_VALUE = ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Numeral</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NUMERAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl <em>Execute Condition</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
    * @generated
    */
   int EXECUTE_CONDITION = 52;

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
    * The feature id for the '<em><b>Ba Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int EXECUTE_CONDITION__BA_REFERENCED_ENTITY = BEHAVIOR_CONDITION__BA_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Aadl Referenced Entity</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int EXECUTE_CONDITION__AADL_REFERENCED_ENTITY = BEHAVIOR_CONDITION__AADL_REFERENCED_ENTITY;

   /**
    * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int EXECUTE_CONDITION__VALUE_EXPRESSION = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Catch Timeout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int EXECUTE_CONDITION__CATCH_TIMEOUT = BEHAVIOR_CONDITION_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Execute Condition</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int EXECUTE_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter <em>Comm Action Parameter</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommActionParameter()
    * @generated
    */
   int COMM_ACTION_PARAMETER = 53;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLogicalOperator()
    * @generated
    */
   int LOGICAL_OPERATOR = 54;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
    * @generated
    */
   int RELATIONAL_OPERATOR = 55;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryAddingOperator()
    * @generated
    */
   int BINARY_ADDING_OPERATOR = 56;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
    * @generated
    */
   int UNARY_ADDING_OPERATOR = 57;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getMultiplyingOperator()
    * @generated
    */
   int MULTIPLYING_OPERATOR = 58;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
    * @generated
    */
   int BINARY_NUMERIC_OPERATOR = 59;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryNumericOperator()
    * @generated
    */
   int UNARY_NUMERIC_OPERATOR = 60;

   /**
    * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
    * @generated
    */
   int UNARY_BOOLEAN_OPERATOR = 61;

   /**
    * The meta object id for the '<em>Integer</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getInteger()
    * @generated
    */
   int INTEGER = 62;

   /**
    * The meta object id for the '<em>Real</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getReal()
    * @generated
    */
   int REAL = 63;

   /**
    * The meta object id for the '<em>String</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see java.lang.String
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getString()
    * @generated
    */
   int STRING = 64;

   /**
    * The meta object id for the '<em>Boolean</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
    * @generated
    */
   int BOOLEAN = 65;


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
    * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getBaReferencedEntity <em>Ba Referenced Entity</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Ba Referenced Entity</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Element#getBaReferencedEntity()
    * @see #getElement()
    * @generated
    */
   EReference getElement_BaReferencedEntity();

   /**
    * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlReferencedEntity <em>Aadl Referenced Entity</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Aadl Referenced Entity</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Element#getAadlReferencedEntity()
    * @see #getElement()
    * @generated
    */
   EReference getElement_AadlReferencedEntity();

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
    * Returns the meta object for the container reference '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the container reference '<em>Namespace</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace()
    * @see #getNamedElement()
    * @generated
    */
   EReference getNamedElement_Namespace();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace <em>Namespace</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Namespace</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Namespace
    * @generated
    */
   EClass getNamespace();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember <em>Owned Member</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Owned Member</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Namespace#getOwnedMember()
    * @see #getNamespace()
    * @generated
    */
   EReference getNamespace_OwnedMember();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace#getMember <em>Member</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Member</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Namespace#getMember()
    * @see #getNamespace()
    * @generated
    */
   EReference getNamespace_Member();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace <em>Global Namespace</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Global Namespace</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace
    * @generated
    */
   EClass getGlobalNamespace();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Variables</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables()
    * @see #getBehaviorAnnex()
    * @generated
    */
   EReference getBehaviorAnnex_Variables();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates <em>States</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>States</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates()
    * @see #getBehaviorAnnex()
    * @generated
    */
   EReference getBehaviorAnnex_States();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Transitions</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions()
    * @see #getBehaviorAnnex()
    * @generated
    */
   EReference getBehaviorAnnex_Transitions();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#isPersistent <em>Persistent</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Persistent</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#isPersistent()
    * @see #getBehaviorVariable()
    * @generated
    */
   EAttribute getBehaviorVariable_Persistent();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getBehaviorStateIdentifiers <em>Behavior State Identifiers</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Behavior State Identifiers</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getBehaviorStateIdentifiers()
    * @see #getBehaviorState()
    * @generated
    */
   EReference getBehaviorState_BehaviorStateIdentifiers();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned()
    * @see #getBehaviorTransition()
    * @generated
    */
   EReference getBehaviorTransition_BehaviorActionsOwned();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Transition Priority</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority()
    * @see #getBehaviorTransition()
    * @generated
    */
   EReference getBehaviorTransition_BehaviorTransitionPriority();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout <em>Timeout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Timeout</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout()
    * @see #getBehaviorTransition()
    * @generated
    */
   EReference getBehaviorTransition_Timeout();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator <em>Declarator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Declarator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator
    * @generated
    */
   EClass getDeclarator();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize <em>Array Size</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Array Size</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ArraySize
    * @generated
    */
   EClass getArraySize();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize#getIntegerValueConstant <em>Integer Value Constant</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Integer Value Constant</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ArraySize#getIntegerValueConstant()
    * @see #getArraySize()
    * @generated
    */
   EReference getArraySize_IntegerValueConstant();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#isHasFrozenPorts <em>Has Frozen Ports</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Frozen Ports</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#isHasFrozenPorts()
    * @see #getDispatchCondition()
    * @generated
    */
   EAttribute getDispatchCondition_HasFrozenPorts();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>The Dispatch Logical Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression()
    * @see #getDispatchCondition()
    * @generated
    */
   EReference getDispatchCondition_TheDispatchLogicalExpression();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression <em>Dispatch Logical Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Dispatch Logical Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression
    * @generated
    */
   EClass getDispatchLogicalExpression();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#getDispatchTriggers <em>Dispatch Triggers</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Dispatch Triggers</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#getDispatchTriggers()
    * @see #getDispatchLogicalExpression()
    * @generated
    */
   EReference getDispatchLogicalExpression_DispatchTriggers();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isOrExpression <em>Or Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Or Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isOrExpression()
    * @see #getDispatchLogicalExpression()
    * @generated
    */
   EAttribute getDispatchLogicalExpression_OrExpression();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isAndExpression <em>And Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>And Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isAndExpression()
    * @see #getDispatchLogicalExpression()
    * @generated
    */
   EAttribute getDispatchLogicalExpression_AndExpression();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isXorExpression <em>Xor Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Xor Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isXorExpression()
    * @see #getDispatchLogicalExpression()
    * @generated
    */
   EAttribute getDispatchLogicalExpression_XorExpression();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isStop <em>Stop</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Stop</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression#isStop()
    * @see #getDispatchLogicalExpression()
    * @generated
    */
   EAttribute getDispatchLogicalExpression_Stop();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Dispatch Trigger</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
    * @generated
    */
   EClass getDispatchTrigger();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>The Dispatch Logical Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheDispatchLogicalExpression()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_TheDispatchLogicalExpression();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime <em>The Behavior Time</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>The Behavior Time</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getTheBehaviorTime()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_TheBehaviorTime();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned <em>Identifier Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Identifier Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getIdentifierOwned()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_IdentifierOwned();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getDispatchTriggers <em>Dispatch Triggers</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Dispatch Triggers</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getDispatchTriggers()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_DispatchTriggers();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned <em>Numeral Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Numeral Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getNumeralOwned()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_NumeralOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned <em>Value Constant Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Value Constant Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#getValueConstantOwned()
    * @see #getDispatchTrigger()
    * @generated
    */
   EReference getDispatchTrigger_ValueConstantOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isNot <em>Not</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Not</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isNot()
    * @see #getDispatchTrigger()
    * @generated
    */
   EAttribute getDispatchTrigger_Not();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isTimeout <em>Timeout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Timeout</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isTimeout()
    * @see #getDispatchTrigger()
    * @generated
    */
   EAttribute getDispatchTrigger_Timeout();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOthers <em>Others</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Others</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOthers()
    * @see #getDispatchTrigger()
    * @generated
    */
   EAttribute getDispatchTrigger_Others();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrMore <em>Or More</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Or More</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrMore()
    * @see #getDispatchTrigger()
    * @generated
    */
   EAttribute getDispatchTrigger_OrMore();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrLess <em>Or Less</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Or Less</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger#isOrLess()
    * @see #getDispatchTrigger()
    * @generated
    */
   EAttribute getDispatchTrigger_OrLess();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#getBehaviorAction <em>Behavior Action</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Behavior Action</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#getBehaviorAction()
    * @see #getBehaviorActions()
    * @generated
    */
   EReference getBehaviorActions_BehaviorAction();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSequence <em>Sequence</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Sequence</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSequence()
    * @see #getBehaviorActions()
    * @generated
    */
   EAttribute getBehaviorActions_Sequence();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSet <em>Set</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Set</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSet()
    * @see #getBehaviorActions()
    * @generated
    */
   EAttribute getBehaviorActions_Set();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBasicActionOwned <em>Basic Action Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Basic Action Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBasicActionOwned()
    * @see #getBehaviorAction()
    * @generated
    */
   EReference getBehaviorAction_BasicActionOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBehaviorActionsOwned()
    * @see #getBehaviorAction()
    * @generated
    */
   EReference getBehaviorAction_BehaviorActionsOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getCondStatementOwned <em>Cond Statement Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Cond Statement Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getCondStatementOwned()
    * @see #getBehaviorAction()
    * @generated
    */
   EReference getBehaviorAction_CondStatementOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBasicAction <em>Basic Action</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Basic Action</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBasicAction()
    * @see #getBehaviorAction()
    * @generated
    */
   EAttribute getBehaviorAction_BasicAction();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isIf <em>If</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>If</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isIf()
    * @see #getBehaviorAction()
    * @generated
    */
   EAttribute getBehaviorAction_If();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isFor <em>For</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>For</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isFor()
    * @see #getBehaviorAction()
    * @generated
    */
   EAttribute getBehaviorAction_For();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isWhile <em>While</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>While</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isWhile()
    * @see #getBehaviorAction()
    * @generated
    */
   EAttribute getBehaviorAction_While();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isDoUntil <em>Do Until</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Do Until</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isDoUntil()
    * @see #getBehaviorAction()
    * @generated
    */
   EAttribute getBehaviorAction_DoUntil();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getTimeout <em>Timeout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Timeout</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getTimeout()
    * @see #getBehaviorAction()
    * @generated
    */
   EReference getBehaviorAction_Timeout();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Basic Action</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
    * @generated
    */
   EClass getBasicAction();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getValueExpressionOwned <em>Value Expression Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Value Expression Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getValueExpressionOwned()
    * @see #getIfStatement()
    * @generated
    */
   EReference getIfStatement_ValueExpressionOwned();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>For Or For All Statement</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement
    * @generated
    */
   EClass getForOrForAllStatement();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueCmtClassRef <em>Data Unique Cmt Class Ref</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Data Unique Cmt Class Ref</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueCmtClassRef()
    * @see #getForOrForAllStatement()
    * @generated
    */
   EReference getForOrForAllStatement_DataUniqueCmtClassRef();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned()
    * @see #getForOrForAllStatement()
    * @generated
    */
   EReference getForOrForAllStatement_BehaviorActionsOwned();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement <em>While Statement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>While Statement</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.WhileStatement
    * @generated
    */
   EClass getWhileStatement();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getValueExpressionOwned <em>Value Expression Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Value Expression Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getValueExpressionOwned()
    * @see #getWhileStatement()
    * @generated
    */
   EReference getWhileStatement_ValueExpressionOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned()
    * @see #getWhileStatement()
    * @generated
    */
   EReference getWhileStatement_BehaviorActionsOwned();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement <em>Do Until Statement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Do Until Statement</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement
    * @generated
    */
   EClass getDoUntilStatement();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Behavior Actions Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement#getBehaviorActionsOwned()
    * @see #getDoUntilStatement()
    * @generated
    */
   EReference getDoUntilStatement_BehaviorActionsOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement#getValueExpressionOwned <em>Value Expression Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Value Expression Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement#getValueExpressionOwned()
    * @see #getDoUntilStatement()
    * @generated
    */
   EReference getDoUntilStatement_ValueExpressionOwned();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Communication Action</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
    * @generated
    */
   EClass getCommunicationAction();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getActionType <em>Action Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Action Type</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getActionType()
    * @see #getCommunicationAction()
    * @generated
    */
   EAttribute getCommunicationAction_ActionType();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getEltNameOwned <em>Elt Name Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Elt Name Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getEltNameOwned()
    * @see #getCommunicationAction()
    * @generated
    */
   EReference getCommunicationAction_EltNameOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Subpgm Param List Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned()
    * @see #getCommunicationAction()
    * @generated
    */
   EReference getCommunicationAction_SubpgmParamListOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasValueExpression <em>Has Value Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Value Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasValueExpression()
    * @see #getCommunicationAction()
    * @generated
    */
   EAttribute getCommunicationAction_HasValueExpression();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasTarget <em>Has Target</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Target</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasTarget()
    * @see #getCommunicationAction()
    * @generated
    */
   EAttribute getCommunicationAction_HasTarget();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getValueExprOwned <em>Value Expr Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Value Expr Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getValueExprOwned()
    * @see #getCommunicationAction()
    * @generated
    */
   EReference getCommunicationAction_ValueExprOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getTarOwned <em>Tar Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Tar Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getTarOwned()
    * @see #getCommunicationAction()
    * @generated
    */
   EReference getCommunicationAction_TarOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Data Unique Component Classifier Reference</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference()
    * @see #getCommunicationAction()
    * @generated
    */
   EReference getCommunicationAction_DataUniqueComponentClassifierReference();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isCatchTimeout <em>Catch Timeout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Catch Timeout</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isCatchTimeout()
    * @see #getCommunicationAction()
    * @generated
    */
   EAttribute getCommunicationAction_CatchTimeout();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isAll <em>All</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>All</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isAll()
    * @see #getCommunicationAction()
    * @generated
    */
   EAttribute getCommunicationAction_All();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList <em>Subprogram Parameter List</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Subprogram Parameter List</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList
    * @generated
    */
   EClass getSubprogramParameterList();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList#getParameterList <em>Parameter List</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Parameter List</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList#getParameterList()
    * @see #getSubprogramParameterList()
    * @generated
    */
   EReference getSubprogramParameterList_ParameterList();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getBehaviorTimesOwned <em>Behavior Times Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Behavior Times Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getBehaviorTimesOwned()
    * @see #getTimedAction()
    * @generated
    */
   EReference getTimedAction_BehaviorTimesOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#isComputation <em>Computation</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Computation</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#isComputation()
    * @see #getTimedAction()
    * @generated
    */
   EAttribute getTimedAction_Computation();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getElementNameOwned <em>Element Name Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Element Name Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Target#getElementNameOwned()
    * @see #getTarget()
    * @generated
    */
   EReference getTarget_ElementNameOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Data Component Reference Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Target#getDataComponentReferenceOwned()
    * @see #getTarget()
    * @generated
    */
   EReference getTarget_DataComponentReferenceOwned();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Data Component Reference</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference
    * @generated
    */
   EClass getDataComponentReference();

   /**
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getElementsNameOwned <em>Elements Name Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Elements Name Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getElementsNameOwned()
    * @see #getDataComponentReference()
    * @generated
    */
   EReference getDataComponentReference_ElementsNameOwned();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexListOwned <em>Array Index List Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Array Index List Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexListOwned()
    * @see #getName_()
    * @generated
    */
   EReference getName_ArrayIndexListOwned();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifier <em>Identifier</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Identifier</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifier()
    * @see #getName_()
    * @generated
    */
   EReference getName_Identifier();

   /**
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex <em>Array Index</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Array Index</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex
    * @generated
    */
   EClass getArrayIndex();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex#getIntegerValueVariableOwned <em>Integer Value Variable Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Integer Value Variable Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex#getIntegerValueVariableOwned()
    * @see #getArrayIndex()
    * @generated
    */
   EReference getArrayIndex_IntegerValueVariableOwned();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Value Variable</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
    * @generated
    */
   EClass getValueVariable();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Data Component Reference Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getDataComponentReferenceOwned()
    * @see #getValueVariable()
    * @generated
    */
   EReference getValueVariable_DataComponentReferenceOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isInterrogation <em>Interrogation</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Interrogation</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isInterrogation()
    * @see #getValueVariable()
    * @generated
    */
   EAttribute getValueVariable_Interrogation();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isCount <em>Count</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Count</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isCount()
    * @see #getValueVariable()
    * @generated
    */
   EAttribute getValueVariable_Count();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isFresh <em>Fresh</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Fresh</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isFresh()
    * @see #getValueVariable()
    * @generated
    */
   EAttribute getValueVariable_Fresh();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isHasDataCptRef <em>Has Data Cpt Ref</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Data Cpt Ref</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isHasDataCptRef()
    * @see #getValueVariable()
    * @generated
    */
   EAttribute getValueVariable_HasDataCptRef();

   /**
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getElementNameOwned <em>Element Name Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Element Name Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getElementNameOwned()
    * @see #getValueVariable()
    * @generated
    */
   EReference getValueVariable_ElementNameOwned();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelationsOwned <em>Relations Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Relations Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelationsOwned()
    * @see #getValueExpression()
    * @generated
    */
   EReference getValueExpression_RelationsOwned();

   /**
    * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperatorsOwned <em>Logical Operators Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute list '<em>Logical Operators Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperatorsOwned()
    * @see #getValueExpression()
    * @generated
    */
   EAttribute getValueExpression_LogicalOperatorsOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#isHasLogicalOperator <em>Has Logical Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Logical Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#isHasLogicalOperator()
    * @see #getValueExpression()
    * @generated
    */
   EAttribute getValueExpression_HasLogicalOperator();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#isHasRelationalOperator <em>Has Relational Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Relational Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#isHasRelationalOperator()
    * @see #getRelation()
    * @generated
    */
   EAttribute getRelation_HasRelationalOperator();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTermsOwned <em>Terms Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Terms Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTermsOwned()
    * @see #getSimpleExpression()
    * @generated
    */
   EReference getSimpleExpression_TermsOwned();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasUnaryAddingOperator <em>Has Unary Adding Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Unary Adding Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasUnaryAddingOperator()
    * @see #getSimpleExpression()
    * @generated
    */
   EAttribute getSimpleExpression_HasUnaryAddingOperator();

   /**
    * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperatorOwned <em>Binary Adding Operator Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute list '<em>Binary Adding Operator Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperatorOwned()
    * @see #getSimpleExpression()
    * @generated
    */
   EAttribute getSimpleExpression_BinaryAddingOperatorOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasBinaryAddingOperator <em>Has Binary Adding Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Binary Adding Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasBinaryAddingOperator()
    * @see #getSimpleExpression()
    * @generated
    */
   EAttribute getSimpleExpression_HasBinaryAddingOperator();

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
    * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactorsOwned <em>Factors Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Factors Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getFactorsOwned()
    * @see #getTerm()
    * @generated
    */
   EReference getTerm_FactorsOwned();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#isHasMultiplyingOperator <em>Has Multiplying Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Multiplying Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Term#isHasMultiplyingOperator()
    * @see #getTerm()
    * @generated
    */
   EAttribute getTerm_HasMultiplyingOperator();

   /**
    * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperatorsOwned <em>Multiplying Operators Owned</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute list '<em>Multiplying Operators Owned</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperatorsOwned()
    * @see #getTerm()
    * @generated
    */
   EAttribute getTerm_MultiplyingOperatorsOwned();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasBinaryNumericOperator <em>Has Binary Numeric Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Binary Numeric Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasBinaryNumericOperator()
    * @see #getFactor()
    * @generated
    */
   EAttribute getFactor_HasBinaryNumericOperator();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryNumericOperator <em>Has Unary Numeric Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Unary Numeric Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryNumericOperator()
    * @see #getFactor()
    * @generated
    */
   EAttribute getFactor_HasUnaryNumericOperator();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryBooleanOperator <em>Has Unary Boolean Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Has Unary Boolean Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryBooleanOperator()
    * @see #getFactor()
    * @generated
    */
   EAttribute getFactor_HasUnaryBooleanOperator();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier <em>Unit Identifier</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Unit Identifier</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnitIdentifier()
    * @see #getBehaviorTime()
    * @generated
    */
   EAttribute getBehaviorTime_UnitIdentifier();

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
    * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Numeric Literal</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
    * @generated
    */
   EClass getNumericLiteral();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getNumValue <em>Num Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Num Value</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getNumValue()
    * @see #getNumericLiteral()
    * @generated
    */
   EAttribute getNumericLiteral_NumValue();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isBoolValue <em>Bool Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Bool Value</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isBoolValue()
    * @see #getBooleanLiteral()
    * @generated
    */
   EAttribute getBooleanLiteral_BoolValue();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getStringValue <em>String Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>String Value</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getStringValue()
    * @see #getStringLiteral()
    * @generated
    */
   EAttribute getStringLiteral_StringValue();

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
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral#getNumeralValue <em>Numeral Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Numeral Value</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.Numeral#getNumeralValue()
    * @see #getNumeral()
    * @generated
    */
   EAttribute getNumeral_NumeralValue();

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
    * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#getValueExpression <em>Value Expression</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Value Expression</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#getValueExpression()
    * @see #getExecuteCondition()
    * @generated
    */
   EReference getExecuteCondition_ValueExpression();

   /**
    * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#isCatchTimeout <em>Catch Timeout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Catch Timeout</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#isCatchTimeout()
    * @see #getExecuteCondition()
    * @generated
    */
   EAttribute getExecuteCondition_CatchTimeout();

   /**
    * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter <em>Comm Action Parameter</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Comm Action Parameter</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter
    * @generated
    */
   EEnum getCommActionParameter();

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
    * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Relational Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
    * @generated
    */
   EEnum getRelationalOperator();

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
    * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Unary Adding Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
    * @generated
    */
   EEnum getUnaryAddingOperator();

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
    * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Binary Numeric Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
    * @generated
    */
   EEnum getBinaryNumericOperator();

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
    * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Unary Boolean Operator</em>'.
    * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
    * @generated
    */
   EEnum getUnaryBooleanOperator();

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
   interface Literals
   {
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
       * The meta object literal for the '<em><b>Ba Referenced Entity</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ELEMENT__BA_REFERENCED_ENTITY = eINSTANCE.getElement_BaReferencedEntity();

      /**
       * The meta object literal for the '<em><b>Aadl Referenced Entity</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ELEMENT__AADL_REFERENCED_ENTITY = eINSTANCE.getElement_AadlReferencedEntity();

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
       * The meta object literal for the '<em><b>Namespace</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference NAMED_ELEMENT__NAMESPACE = eINSTANCE.getNamedElement_Namespace();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl <em>Namespace</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNamespace()
       * @generated
       */
      EClass NAMESPACE = eINSTANCE.getNamespace();

      /**
       * The meta object literal for the '<em><b>Owned Member</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference NAMESPACE__OWNED_MEMBER = eINSTANCE.getNamespace_OwnedMember();

      /**
       * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference NAMESPACE__MEMBER = eINSTANCE.getNamespace_Member();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GlobalNamespaceImpl <em>Global Namespace</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GlobalNamespaceImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGlobalNamespace()
       * @generated
       */
      EClass GLOBAL_NAMESPACE = eINSTANCE.getGlobalNamespace();

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
       * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ANNEX__VARIABLES = eINSTANCE.getBehaviorAnnex_Variables();

      /**
       * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ANNEX__STATES = eINSTANCE.getBehaviorAnnex_States();

      /**
       * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ANNEX__TRANSITIONS = eINSTANCE.getBehaviorAnnex_Transitions();

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
       * The meta object literal for the '<em><b>Persistent</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_VARIABLE__PERSISTENT = eINSTANCE.getBehaviorVariable_Persistent();

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
       * The meta object literal for the '<em><b>Behavior State Identifiers</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS = eINSTANCE.getBehaviorState_BehaviorStateIdentifiers();

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
       * The meta object literal for the '<em><b>Source State Identifiers</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS = eINSTANCE.getBehaviorTransition_SourceStateIdentifiers();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getBehaviorTransition_BehaviorActionsOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Condition Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED = eINSTANCE.getBehaviorTransition_BehaviorConditionOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Transition Priority</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY = eINSTANCE.getBehaviorTransition_BehaviorTransitionPriority();

      /**
       * The meta object literal for the '<em><b>Destination State Identifier</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER = eINSTANCE.getBehaviorTransition_DestinationStateIdentifier();

      /**
       * The meta object literal for the '<em><b>Transition Identifier</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER = eINSTANCE.getBehaviorTransition_TransitionIdentifier();

      /**
       * The meta object literal for the '<em><b>Timeout</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_TRANSITION__TIMEOUT = eINSTANCE.getBehaviorTransition_Timeout();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorConditionImpl <em>Behavior Condition</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorConditionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
       * @generated
       */
      EClass BEHAVIOR_CONDITION = eINSTANCE.getBehaviorCondition();

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
       * The meta object literal for the '<em><b>Array Sizes</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DECLARATOR__ARRAY_SIZES = eINSTANCE.getDeclarator_ArraySizes();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArraySizeImpl <em>Array Size</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ArraySizeImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getArraySize()
       * @generated
       */
      EClass ARRAY_SIZE = eINSTANCE.getArraySize();

      /**
       * The meta object literal for the '<em><b>Integer Value Constant</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ARRAY_SIZE__INTEGER_VALUE_CONSTANT = eINSTANCE.getArraySize_IntegerValueConstant();

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
       * The meta object literal for the '<em><b>Has Frozen Ports</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_CONDITION__HAS_FROZEN_PORTS = eINSTANCE.getDispatchCondition_HasFrozenPorts();

      /**
       * The meta object literal for the '<em><b>The Dispatch Logical Expression</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION = eINSTANCE.getDispatchCondition_TheDispatchLogicalExpression();

      /**
       * The meta object literal for the '<em><b>Frozen Ports</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_CONDITION__FROZEN_PORTS = eINSTANCE.getDispatchCondition_FrozenPorts();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl <em>Dispatch Logical Expression</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchLogicalExpression()
       * @generated
       */
      EClass DISPATCH_LOGICAL_EXPRESSION = eINSTANCE.getDispatchLogicalExpression();

      /**
       * The meta object literal for the '<em><b>Dispatch Triggers</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS = eINSTANCE.getDispatchLogicalExpression_DispatchTriggers();

      /**
       * The meta object literal for the '<em><b>Or Expression</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION = eINSTANCE.getDispatchLogicalExpression_OrExpression();

      /**
       * The meta object literal for the '<em><b>And Expression</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION = eINSTANCE.getDispatchLogicalExpression_AndExpression();

      /**
       * The meta object literal for the '<em><b>Xor Expression</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION = eINSTANCE.getDispatchLogicalExpression_XorExpression();

      /**
       * The meta object literal for the '<em><b>Stop</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_LOGICAL_EXPRESSION__STOP = eINSTANCE.getDispatchLogicalExpression_Stop();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl <em>Dispatch Trigger</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTrigger()
       * @generated
       */
      EClass DISPATCH_TRIGGER = eINSTANCE.getDispatchTrigger();

      /**
       * The meta object literal for the '<em><b>The Dispatch Logical Expression</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION = eINSTANCE.getDispatchTrigger_TheDispatchLogicalExpression();

      /**
       * The meta object literal for the '<em><b>The Behavior Time</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__THE_BEHAVIOR_TIME = eINSTANCE.getDispatchTrigger_TheBehaviorTime();

      /**
       * The meta object literal for the '<em><b>Identifier Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__IDENTIFIER_OWNED = eINSTANCE.getDispatchTrigger_IdentifierOwned();

      /**
       * The meta object literal for the '<em><b>Dispatch Triggers</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__DISPATCH_TRIGGERS = eINSTANCE.getDispatchTrigger_DispatchTriggers();

      /**
       * The meta object literal for the '<em><b>Numeral Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__NUMERAL_OWNED = eINSTANCE.getDispatchTrigger_NumeralOwned();

      /**
       * The meta object literal for the '<em><b>Value Constant Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED = eINSTANCE.getDispatchTrigger_ValueConstantOwned();

      /**
       * The meta object literal for the '<em><b>Not</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_TRIGGER__NOT = eINSTANCE.getDispatchTrigger_Not();

      /**
       * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_TRIGGER__TIMEOUT = eINSTANCE.getDispatchTrigger_Timeout();

      /**
       * The meta object literal for the '<em><b>Others</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_TRIGGER__OTHERS = eINSTANCE.getDispatchTrigger_Others();

      /**
       * The meta object literal for the '<em><b>Or More</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_TRIGGER__OR_MORE = eINSTANCE.getDispatchTrigger_OrMore();

      /**
       * The meta object literal for the '<em><b>Or Less</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute DISPATCH_TRIGGER__OR_LESS = eINSTANCE.getDispatchTrigger_OrLess();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl <em>Behavior Actions</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
       * @generated
       */
      EClass BEHAVIOR_ACTIONS = eINSTANCE.getBehaviorActions();

      /**
       * The meta object literal for the '<em><b>Behavior Action</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ACTIONS__BEHAVIOR_ACTION = eINSTANCE.getBehaviorActions_BehaviorAction();

      /**
       * The meta object literal for the '<em><b>Sequence</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTIONS__SEQUENCE = eINSTANCE.getBehaviorActions_Sequence();

      /**
       * The meta object literal for the '<em><b>Set</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTIONS__SET = eINSTANCE.getBehaviorActions_Set();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl <em>Behavior Action</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
       * @generated
       */
      EClass BEHAVIOR_ACTION = eINSTANCE.getBehaviorAction();

      /**
       * The meta object literal for the '<em><b>Basic Action Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ACTION__BASIC_ACTION_OWNED = eINSTANCE.getBehaviorAction_BasicActionOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getBehaviorAction_BehaviorActionsOwned();

      /**
       * The meta object literal for the '<em><b>Cond Statement Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ACTION__COND_STATEMENT_OWNED = eINSTANCE.getBehaviorAction_CondStatementOwned();

      /**
       * The meta object literal for the '<em><b>Basic Action</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTION__BASIC_ACTION = eINSTANCE.getBehaviorAction_BasicAction();

      /**
       * The meta object literal for the '<em><b>If</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTION__IF = eINSTANCE.getBehaviorAction_If();

      /**
       * The meta object literal for the '<em><b>For</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTION__FOR = eINSTANCE.getBehaviorAction_For();

      /**
       * The meta object literal for the '<em><b>While</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTION__WHILE = eINSTANCE.getBehaviorAction_While();

      /**
       * The meta object literal for the '<em><b>Do Until</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_ACTION__DO_UNTIL = eINSTANCE.getBehaviorAction_DoUntil();

      /**
       * The meta object literal for the '<em><b>Timeout</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BEHAVIOR_ACTION__TIMEOUT = eINSTANCE.getBehaviorAction_Timeout();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CondStatementImpl <em>Cond Statement</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CondStatementImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
       * @generated
       */
      EClass COND_STATEMENT = eINSTANCE.getCondStatement();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BasicActionImpl <em>Basic Action</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BasicActionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
       * @generated
       */
      EClass BASIC_ACTION = eINSTANCE.getBasicAction();

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
       * The meta object literal for the '<em><b>Value Expression Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference IF_STATEMENT__VALUE_EXPRESSION_OWNED = eINSTANCE.getIfStatement_ValueExpressionOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getIfStatement_BehaviorActionsOwned();

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
       * The meta object literal for the '<em><b>Data Unique Cmt Class Ref</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF = eINSTANCE.getForOrForAllStatement_DataUniqueCmtClassRef();

      /**
       * The meta object literal for the '<em><b>Element Values Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED = eINSTANCE.getForOrForAllStatement_ElementValuesOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getForOrForAllStatement_BehaviorActionsOwned();

      /**
       * The meta object literal for the '<em><b>For All</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = eINSTANCE.getForOrForAllStatement_ForAll();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileStatementImpl <em>While Statement</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileStatementImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileStatement()
       * @generated
       */
      EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

      /**
       * The meta object literal for the '<em><b>Value Expression Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference WHILE_STATEMENT__VALUE_EXPRESSION_OWNED = eINSTANCE.getWhileStatement_ValueExpressionOwned();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference WHILE_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getWhileStatement_BehaviorActionsOwned();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DoUntilStatementImpl <em>Do Until Statement</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DoUntilStatementImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDoUntilStatement()
       * @generated
       */
      EClass DO_UNTIL_STATEMENT = eINSTANCE.getDoUntilStatement();

      /**
       * The meta object literal for the '<em><b>Behavior Actions Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DO_UNTIL_STATEMENT__BEHAVIOR_ACTIONS_OWNED = eINSTANCE.getDoUntilStatement_BehaviorActionsOwned();

      /**
       * The meta object literal for the '<em><b>Value Expression Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DO_UNTIL_STATEMENT__VALUE_EXPRESSION_OWNED = eINSTANCE.getDoUntilStatement_ValueExpressionOwned();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementValuesImpl <em>Element Values</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElementValuesImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
       * @generated
       */
      EClass ELEMENT_VALUES = eINSTANCE.getElementValues();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl <em>Communication Action</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
       * @generated
       */
      EClass COMMUNICATION_ACTION = eINSTANCE.getCommunicationAction();

      /**
       * The meta object literal for the '<em><b>Action Type</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute COMMUNICATION_ACTION__ACTION_TYPE = eINSTANCE.getCommunicationAction_ActionType();

      /**
       * The meta object literal for the '<em><b>Elt Name Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference COMMUNICATION_ACTION__ELT_NAME_OWNED = eINSTANCE.getCommunicationAction_EltNameOwned();

      /**
       * The meta object literal for the '<em><b>Subpgm Param List Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED = eINSTANCE.getCommunicationAction_SubpgmParamListOwned();

      /**
       * The meta object literal for the '<em><b>Has Value Expression</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION = eINSTANCE.getCommunicationAction_HasValueExpression();

      /**
       * The meta object literal for the '<em><b>Has Target</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute COMMUNICATION_ACTION__HAS_TARGET = eINSTANCE.getCommunicationAction_HasTarget();

      /**
       * The meta object literal for the '<em><b>Value Expr Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference COMMUNICATION_ACTION__VALUE_EXPR_OWNED = eINSTANCE.getCommunicationAction_ValueExprOwned();

      /**
       * The meta object literal for the '<em><b>Tar Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference COMMUNICATION_ACTION__TAR_OWNED = eINSTANCE.getCommunicationAction_TarOwned();

      /**
       * The meta object literal for the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE = eINSTANCE.getCommunicationAction_DataUniqueComponentClassifierReference();

      /**
       * The meta object literal for the '<em><b>Catch Timeout</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute COMMUNICATION_ACTION__CATCH_TIMEOUT = eINSTANCE.getCommunicationAction_CatchTimeout();

      /**
       * The meta object literal for the '<em><b>All</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute COMMUNICATION_ACTION__ALL = eINSTANCE.getCommunicationAction_All();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramParameterListImpl <em>Subprogram Parameter List</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramParameterListImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramParameterList()
       * @generated
       */
      EClass SUBPROGRAM_PARAMETER_LIST = eINSTANCE.getSubprogramParameterList();

      /**
       * The meta object literal for the '<em><b>Parameter List</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST = eINSTANCE.getSubprogramParameterList_ParameterList();

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
       * The meta object literal for the '<em><b>Behavior Times Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TIMED_ACTION__BEHAVIOR_TIMES_OWNED = eINSTANCE.getTimedAction_BehaviorTimesOwned();

      /**
       * The meta object literal for the '<em><b>Computation</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TIMED_ACTION__COMPUTATION = eINSTANCE.getTimedAction_Computation();

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
       * The meta object literal for the '<em><b>Element Name Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TARGET__ELEMENT_NAME_OWNED = eINSTANCE.getTarget_ElementNameOwned();

      /**
       * The meta object literal for the '<em><b>Data Component Reference Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TARGET__DATA_COMPONENT_REFERENCE_OWNED = eINSTANCE.getTarget_DataComponentReferenceOwned();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterLabelImpl <em>Parameter Label</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterLabelImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
       * @generated
       */
      EClass PARAMETER_LABEL = eINSTANCE.getParameterLabel();

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
       * The meta object literal for the '<em><b>Elements Name Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED = eINSTANCE.getDataComponentReference_ElementsNameOwned();

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
       * The meta object literal for the '<em><b>Array Index List Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference NAME__ARRAY_INDEX_LIST_OWNED = eINSTANCE.getName_ArrayIndexListOwned();

      /**
       * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference NAME__IDENTIFIER = eINSTANCE.getName_Identifier();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArrayIndexImpl <em>Array Index</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ArrayIndexImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getArrayIndex()
       * @generated
       */
      EClass ARRAY_INDEX = eINSTANCE.getArrayIndex();

      /**
       * The meta object literal for the '<em><b>Integer Value Variable Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED = eINSTANCE.getArrayIndex_IntegerValueVariableOwned();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueImpl <em>Value</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
       * @generated
       */
      EClass VALUE = eINSTANCE.getValue();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl <em>Value Variable</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
       * @generated
       */
      EClass VALUE_VARIABLE = eINSTANCE.getValueVariable();

      /**
       * The meta object literal for the '<em><b>Data Component Reference Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED = eINSTANCE.getValueVariable_DataComponentReferenceOwned();

      /**
       * The meta object literal for the '<em><b>Interrogation</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_VARIABLE__INTERROGATION = eINSTANCE.getValueVariable_Interrogation();

      /**
       * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_VARIABLE__COUNT = eINSTANCE.getValueVariable_Count();

      /**
       * The meta object literal for the '<em><b>Fresh</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_VARIABLE__FRESH = eINSTANCE.getValueVariable_Fresh();

      /**
       * The meta object literal for the '<em><b>Has Data Cpt Ref</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_VARIABLE__HAS_DATA_CPT_REF = eINSTANCE.getValueVariable_HasDataCptRef();

      /**
       * The meta object literal for the '<em><b>Element Name Owned</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VALUE_VARIABLE__ELEMENT_NAME_OWNED = eINSTANCE.getValueVariable_ElementNameOwned();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueConstantImpl <em>Value Constant</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueConstantImpl
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
       * The meta object literal for the '<em><b>Relations Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VALUE_EXPRESSION__RELATIONS_OWNED = eINSTANCE.getValueExpression_RelationsOwned();

      /**
       * The meta object literal for the '<em><b>Logical Operators Owned</b></em>' attribute list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED = eINSTANCE.getValueExpression_LogicalOperatorsOwned();

      /**
       * The meta object literal for the '<em><b>Has Logical Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR = eINSTANCE.getValueExpression_HasLogicalOperator();

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
       * The meta object literal for the '<em><b>Has Relational Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute RELATION__HAS_RELATIONAL_OPERATOR = eINSTANCE.getRelation_HasRelationalOperator();

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
       * The meta object literal for the '<em><b>Terms Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference SIMPLE_EXPRESSION__TERMS_OWNED = eINSTANCE.getSimpleExpression_TermsOwned();

      /**
       * The meta object literal for the '<em><b>Unary Adding Operator Owned</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED = eINSTANCE.getSimpleExpression_UnaryAddingOperatorOwned();

      /**
       * The meta object literal for the '<em><b>Has Unary Adding Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR = eINSTANCE.getSimpleExpression_HasUnaryAddingOperator();

      /**
       * The meta object literal for the '<em><b>Binary Adding Operator Owned</b></em>' attribute list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED = eINSTANCE.getSimpleExpression_BinaryAddingOperatorOwned();

      /**
       * The meta object literal for the '<em><b>Has Binary Adding Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR = eINSTANCE.getSimpleExpression_HasBinaryAddingOperator();

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
       * The meta object literal for the '<em><b>Factors Owned</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference TERM__FACTORS_OWNED = eINSTANCE.getTerm_FactorsOwned();

      /**
       * The meta object literal for the '<em><b>Has Multiplying Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TERM__HAS_MULTIPLYING_OPERATOR = eINSTANCE.getTerm_HasMultiplyingOperator();

      /**
       * The meta object literal for the '<em><b>Multiplying Operators Owned</b></em>' attribute list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute TERM__MULTIPLYING_OPERATORS_OWNED = eINSTANCE.getTerm_MultiplyingOperatorsOwned();

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
       * The meta object literal for the '<em><b>Has Binary Numeric Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute FACTOR__HAS_BINARY_NUMERIC_OPERATOR = eINSTANCE.getFactor_HasBinaryNumericOperator();

      /**
       * The meta object literal for the '<em><b>Has Unary Numeric Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute FACTOR__HAS_UNARY_NUMERIC_OPERATOR = eINSTANCE.getFactor_HasUnaryNumericOperator();

      /**
       * The meta object literal for the '<em><b>Has Unary Boolean Operator</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute FACTOR__HAS_UNARY_BOOLEAN_OPERATOR = eINSTANCE.getFactor_HasUnaryBooleanOperator();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerValueImpl <em>Integer Value</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerValueImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
       * @generated
       */
      EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

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
       * The meta object literal for the '<em><b>Unit Identifier</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BEHAVIOR_TIME__UNIT_IDENTIFIER = eINSTANCE.getBehaviorTime_UnitIdentifier();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
       * @generated
       */
      EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

      /**
       * The meta object literal for the '<em><b>Num Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute NUMERIC_LITERAL__NUM_VALUE = eINSTANCE.getNumericLiteral_NumValue();

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
       * The meta object literal for the '<em><b>Bool Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute BOOLEAN_LITERAL__BOOL_VALUE = eINSTANCE.getBooleanLiteral_BoolValue();

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
       * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STRING_LITERAL__STRING_VALUE = eINSTANCE.getStringLiteral_StringValue();

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
       * The meta object literal for the '<em><b>Numeral Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute NUMERAL__NUMERAL_VALUE = eINSTANCE.getNumeral_NumeralValue();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl <em>Execute Condition</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
       * @generated
       */
      EClass EXECUTE_CONDITION = eINSTANCE.getExecuteCondition();

      /**
       * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference EXECUTE_CONDITION__VALUE_EXPRESSION = eINSTANCE.getExecuteCondition_ValueExpression();

      /**
       * The meta object literal for the '<em><b>Catch Timeout</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute EXECUTE_CONDITION__CATCH_TIMEOUT = eINSTANCE.getExecuteCondition_CatchTimeout();

      /**
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter <em>Comm Action Parameter</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommActionParameter()
       * @generated
       */
      EEnum COMM_ACTION_PARAMETER = eINSTANCE.getCommActionParameter();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
       * @generated
       */
      EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
       * @generated
       */
      EEnum UNARY_ADDING_OPERATOR = eINSTANCE.getUnaryAddingOperator();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
       * @generated
       */
      EEnum BINARY_NUMERIC_OPERATOR = eINSTANCE.getBinaryNumericOperator();

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
       * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
       * @generated
       */
      EEnum UNARY_BOOLEAN_OPERATOR = eINSTANCE.getUnaryBooleanOperator();

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

      /**
       * The meta object literal for the '<em>Boolean</em>' data type.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
       * @generated
       */
      EDataType BOOLEAN = eINSTANCE.getBoolean();

   }

} //AadlBaPackage
