/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.impl ;

import fr.tpt.aadl.annex.behavior.declarative.* ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.EPackage ;

import org.eclipse.emf.ecore.impl.EFactoryImpl ;

import org.eclipse.emf.ecore.plugin.EcorePlugin ;

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
                  .getEFactory("https://eve.enst.fr/svn/aadl-eclipse-dev/aadlba/trunk/fr.tpt.aadl.annex.behavior/declarative") ;
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
      case DeclarativePackage.DECLARATIVE_TIME :
        return createDeclarativeTime() ;
      case DeclarativePackage.ENUMERATION :
        return createEnumeration() ;
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
  public Enumeration createEnumeration()
  {
    EnumerationImpl enumeration = new EnumerationImpl() ;
    return enumeration ;
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
