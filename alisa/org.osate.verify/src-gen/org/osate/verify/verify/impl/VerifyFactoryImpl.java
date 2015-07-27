/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
      case VerifyPackage.VERIFICATION: return createVerification();
      case VerifyPackage.VERIFICATION_PLAN: return createVerificationPlan();
      case VerifyPackage.CLAIM: return createClaim();
      case VerifyPackage.VERIFICATION_ACTIVITY: return createVerificationActivity();
      case VerifyPackage.VERIFICATION_CONDITION: return createVerificationCondition();
      case VerifyPackage.ARGUMENT_EXPR: return createArgumentExpr();
      case VerifyPackage.VERIFICATION_METHOD_REGISTRY: return createVerificationMethodRegistry();
      case VerifyPackage.VERIFICATION_METHOD: return createVerificationMethod();
      case VerifyPackage.VERIFICATION_VALIDATION: return createVerificationValidation();
      case VerifyPackage.VERIFICATION_PRECONDITION: return createVerificationPrecondition();
      case VerifyPackage.THEN_EXPR: return createThenExpr();
      case VerifyPackage.ELSE_EXPR: return createElseExpr();
      case VerifyPackage.ALL_EXPR: return createAllExpr();
      case VerifyPackage.WHEN_EXPR: return createWhenExpr();
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
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case VerifyPackage.SUPPORTED_TYPES:
        return createSupportedTypesFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case VerifyPackage.SUPPORTED_TYPES:
        return convertSupportedTypesToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Verification createVerification()
  {
    VerificationImpl verification = new VerificationImpl();
    return verification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPlan createVerificationPlan()
  {
    VerificationPlanImpl verificationPlan = new VerificationPlanImpl();
    return verificationPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Claim createClaim()
  {
    ClaimImpl claim = new ClaimImpl();
    return claim;
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
  public VerificationCondition createVerificationCondition()
  {
    VerificationConditionImpl verificationCondition = new VerificationConditionImpl();
    return verificationCondition;
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
  public VerificationMethodRegistry createVerificationMethodRegistry()
  {
    VerificationMethodRegistryImpl verificationMethodRegistry = new VerificationMethodRegistryImpl();
    return verificationMethodRegistry;
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
  public VerificationValidation createVerificationValidation()
  {
    VerificationValidationImpl verificationValidation = new VerificationValidationImpl();
    return verificationValidation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPrecondition createVerificationPrecondition()
  {
    VerificationPreconditionImpl verificationPrecondition = new VerificationPreconditionImpl();
    return verificationPrecondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThenExpr createThenExpr()
  {
    ThenExprImpl thenExpr = new ThenExprImpl();
    return thenExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseExpr createElseExpr()
  {
    ElseExprImpl elseExpr = new ElseExprImpl();
    return elseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AllExpr createAllExpr()
  {
    AllExprImpl allExpr = new AllExprImpl();
    return allExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhenExpr createWhenExpr()
  {
    WhenExprImpl whenExpr = new WhenExprImpl();
    return whenExpr;
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
  public SupportedTypes createSupportedTypesFromString(EDataType eDataType, String initialValue)
  {
    SupportedTypes result = SupportedTypes.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSupportedTypesToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
