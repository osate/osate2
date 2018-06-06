/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
      case AssurePackage.ASSURANCE_CASE_RESULT: return createAssuranceCaseResult();
      case AssurePackage.MODEL_RESULT: return createModelResult();
      case AssurePackage.SUBSYSTEM_RESULT: return createSubsystemResult();
      case AssurePackage.CLAIM_RESULT: return createClaimResult();
      case AssurePackage.VERIFICATION_RESULT: return createVerificationResult();
      case AssurePackage.ASSURE_RESULT: return createAssureResult();
      case AssurePackage.VERIFICATION_EXPR: return createVerificationExpr();
      case AssurePackage.ELSE_RESULT: return createElseResult();
      case AssurePackage.THEN_RESULT: return createThenResult();
      case AssurePackage.METRICS: return createMetrics();
      case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE: return createQualifiedVerificationPlanElementReference();
      case AssurePackage.QUALIFIED_CLAIM_REFERENCE: return createQualifiedClaimReference();
      case AssurePackage.QUALIFIED_VA_REFERENCE: return createQualifiedVAReference();
      case AssurePackage.NESTED_CLAIM_REFERENCE: return createNestedClaimReference();
      case AssurePackage.PRECONDITION_RESULT: return createPreconditionResult();
      case AssurePackage.VALIDATION_RESULT: return createValidationResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT: return createVerificationActivityResult();
      case AssurePackage.PREDICATE_RESULT: return createPredicateResult();
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
      case AssurePackage.ELSE_TYPE:
        return createElseTypeFromString(eDataType, initialValue);
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
      case AssurePackage.ELSE_TYPE:
        return convertElseTypeToString(eDataType, instanceValue);
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
  public AssuranceCaseResult createAssuranceCaseResult()
  {
    AssuranceCaseResultImpl assuranceCaseResult = new AssuranceCaseResultImpl();
    return assuranceCaseResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelResult createModelResult()
  {
    ModelResultImpl modelResult = new ModelResultImpl();
    return modelResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubsystemResult createSubsystemResult()
  {
    SubsystemResultImpl subsystemResult = new SubsystemResultImpl();
    return subsystemResult;
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
  public ElseResult createElseResult()
  {
    ElseResultImpl elseResult = new ElseResultImpl();
    return elseResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThenResult createThenResult()
  {
    ThenResultImpl thenResult = new ThenResultImpl();
    return thenResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Metrics createMetrics()
  {
    MetricsImpl metrics = new MetricsImpl();
    return metrics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedVerificationPlanElementReference createQualifiedVerificationPlanElementReference()
  {
    QualifiedVerificationPlanElementReferenceImpl qualifiedVerificationPlanElementReference = new QualifiedVerificationPlanElementReferenceImpl();
    return qualifiedVerificationPlanElementReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedClaimReference createQualifiedClaimReference()
  {
    QualifiedClaimReferenceImpl qualifiedClaimReference = new QualifiedClaimReferenceImpl();
    return qualifiedClaimReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedVAReference createQualifiedVAReference()
  {
    QualifiedVAReferenceImpl qualifiedVAReference = new QualifiedVAReferenceImpl();
    return qualifiedVAReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedClaimReference createNestedClaimReference()
  {
    NestedClaimReferenceImpl nestedClaimReference = new NestedClaimReferenceImpl();
    return nestedClaimReference;
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
  public PredicateResult createPredicateResult()
  {
    PredicateResultImpl predicateResult = new PredicateResultImpl();
    return predicateResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseType createElseTypeFromString(EDataType eDataType, String initialValue)
  {
    ElseType result = ElseType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertElseTypeToString(EDataType eDataType, Object instanceValue)
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
