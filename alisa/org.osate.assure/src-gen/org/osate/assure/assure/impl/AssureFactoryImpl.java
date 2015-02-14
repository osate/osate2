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
      case AssurePackage.ASSURANCE_EVIDENCE: return createAssuranceEvidence();
      case AssurePackage.CLAIM_RESULT: return createClaimResult();
      case AssurePackage.VERIFICATION_RESULT: return createVerificationResult();
      case AssurePackage.ASSURE_RESULT: return createAssureResult();
      case AssurePackage.VERIFICATION_EXPR: return createVerificationExpr();
      case AssurePackage.FAIL_THEN_RESULT: return createFailThenResult();
      case AssurePackage.AND_THEN_RESULT: return createAndThenResult();
      case AssurePackage.RESULT_ISSUE: return createResultIssue();
      case AssurePackage.VALIDATION_RESULT: return createValidationResult();
      case AssurePackage.PRECONDITION_RESULT: return createPreconditionResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT: return createVerificationActivityResult();
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
      case AssurePackage.RESULT_ISSUE_TYPE:
        return createResultIssueTypeFromString(eDataType, initialValue);
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
      case AssurePackage.RESULT_ISSUE_TYPE:
        return convertResultIssueTypeToString(eDataType, instanceValue);
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
  public AssuranceEvidence createAssuranceEvidence()
  {
    AssuranceEvidenceImpl assuranceEvidence = new AssuranceEvidenceImpl();
    return assuranceEvidence;
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
  public ResultIssue createResultIssue()
  {
    ResultIssueImpl resultIssue = new ResultIssueImpl();
    return resultIssue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValidationResult createValidationResult()
  {
    ValidationResultImpl validationResult = new ValidationResultImpl();
    return validationResult;
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
  public ResultIssueType createResultIssueTypeFromString(EDataType eDataType, String initialValue)
  {
    ResultIssueType result = ResultIssueType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertResultIssueTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
