/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.assure.assure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssureFactoryImpl extends EFactoryImpl implements AssureFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssureFactory init()
  {
    try
    {
      AssureFactory theAssureFactory = (AssureFactory)EPackage.Registry.INSTANCE.getEFactory(AssurePackage.eNS_URI);
      if (theAssureFactory != null)
      {
        return theAssureFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AssureFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssureFactoryImpl()
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
      case AssurePackage.CASE_RESULT: return createCaseResult();
      case AssurePackage.CLAIM_RESULT: return createClaimResult();
      case AssurePackage.ASSUMPTION_RESULT: return createAssumptionResult();
      case AssurePackage.PRECONDITION_RESULT: return createPreconditionResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT: return createVerificationActivityResult();
      case AssurePackage.ASSURE_RESULT: return createAssureResult();
      case AssurePackage.VERIFICATION_EXPR: return createVerificationExpr();
      case AssurePackage.FAIL_THEN_RESULT: return createFailThenResult();
      case AssurePackage.AND_THEN_RESULT: return createAndThenResult();
      case AssurePackage.VERIFICATION_RESULT: return createVerificationResult();
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
      case AssurePackage.VERIFICATION_RESULT_STATE:
        return createVerificationResultStateFromString(eDataType, initialValue);
      case AssurePackage.VERIFICATION_EXECUTION_STATE:
        return createVerificationExecutionStateFromString(eDataType, initialValue);
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
      case AssurePackage.VERIFICATION_RESULT_STATE:
        return convertVerificationResultStateToString(eDataType, instanceValue);
      case AssurePackage.VERIFICATION_EXECUTION_STATE:
        return convertVerificationExecutionStateToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseResult createCaseResult()
  {
    CaseResultImpl caseResult = new CaseResultImpl();
    return caseResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClaimResult createClaimResult()
  {
    ClaimResultImpl claimResult = new ClaimResultImpl();
    return claimResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssumptionResult createAssumptionResult()
  {
    AssumptionResultImpl assumptionResult = new AssumptionResultImpl();
    return assumptionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreconditionResult createPreconditionResult()
  {
    PreconditionResultImpl preconditionResult = new PreconditionResultImpl();
    return preconditionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivityResult createVerificationActivityResult()
  {
    VerificationActivityResultImpl verificationActivityResult = new VerificationActivityResultImpl();
    return verificationActivityResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssureResult createAssureResult()
  {
    AssureResultImpl assureResult = new AssureResultImpl();
    return assureResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationExpr createVerificationExpr()
  {
    VerificationExprImpl verificationExpr = new VerificationExprImpl();
    return verificationExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailThenResult createFailThenResult()
  {
    FailThenResultImpl failThenResult = new FailThenResultImpl();
    return failThenResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndThenResult createAndThenResult()
  {
    AndThenResultImpl andThenResult = new AndThenResultImpl();
    return andThenResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResult createVerificationResult()
  {
    VerificationResultImpl verificationResult = new VerificationResultImpl();
    return verificationResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResultState createVerificationResultStateFromString(EDataType eDataType, String initialValue)
  {
    VerificationResultState result = VerificationResultState.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVerificationResultStateToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationExecutionState createVerificationExecutionStateFromString(EDataType eDataType, String initialValue)
  {
    VerificationExecutionState result = VerificationExecutionState.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVerificationExecutionStateToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssurePackage getAssurePackage()
  {
    return (AssurePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AssurePackage getPackage()
  {
    return AssurePackage.eINSTANCE;
  }

} //AssureFactoryImpl
