/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.verify.verify.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VerifyFactoryImpl extends EFactoryImpl implements VerifyFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VerifyFactory init()
  {
    try
    {
      VerifyFactory theVerifyFactory = (VerifyFactory)EPackage.Registry.INSTANCE.getEFactory(VerifyPackage.eNS_URI);
      if (theVerifyFactory != null)
      {
        return theVerifyFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new VerifyFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerifyFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case VerifyPackage.VERIFICATION_MODEL: return createVerificationModel();
      case VerifyPackage.VERIFICATION_FOLDER: return createVerificationFolder();
      case VerifyPackage.VERIFICATION_CONTAINER: return createVerificationContainer();
      case VerifyPackage.VERIFICATION_ACTIVITY: return createVerificationActivity();
      case VerifyPackage.VERIFICATION_ASSUMPTION: return createVerificationAssumption();
      case VerifyPackage.ASSURANCE_PLAN: return createAssurancePlan();
      case VerifyPackage.ARGUMENT_EXPR: return createArgumentExpr();
      case VerifyPackage.ARGUMENT_REFERENCE: return createArgumentReference();
      case VerifyPackage.VERIFICATION_METHOD: return createVerificationMethod();
      case VerifyPackage.BINARY_EXPR: return createBinaryExpr();
      case VerifyPackage.REF_EXPR: return createRefExpr();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationModel createVerificationModel()
  {
    VerificationModelImpl verificationModel = new VerificationModelImpl();
    return verificationModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationFolder createVerificationFolder()
  {
    VerificationFolderImpl verificationFolder = new VerificationFolderImpl();
    return verificationFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationContainer createVerificationContainer()
  {
    VerificationContainerImpl verificationContainer = new VerificationContainerImpl();
    return verificationContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity createVerificationActivity()
  {
    VerificationActivityImpl verificationActivity = new VerificationActivityImpl();
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationAssumption createVerificationAssumption()
  {
    VerificationAssumptionImpl verificationAssumption = new VerificationAssumptionImpl();
    return verificationAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurancePlan createAssurancePlan()
  {
    AssurancePlanImpl assurancePlan = new AssurancePlanImpl();
    return assurancePlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentExpr createArgumentExpr()
  {
    ArgumentExprImpl argumentExpr = new ArgumentExprImpl();
    return argumentExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentReference createArgumentReference()
  {
    ArgumentReferenceImpl argumentReference = new ArgumentReferenceImpl();
    return argumentReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod createVerificationMethod()
  {
    VerificationMethodImpl verificationMethod = new VerificationMethodImpl();
    return verificationMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryExpr createBinaryExpr()
  {
    BinaryExprImpl binaryExpr = new BinaryExprImpl();
    return binaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefExpr createRefExpr()
  {
    RefExprImpl refExpr = new RefExprImpl();
    return refExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerifyPackage getVerifyPackage()
  {
    return (VerifyPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static VerifyPackage getPackage()
  {
    return VerifyPackage.eINSTANCE;
  }

} //VerifyFactoryImpl
