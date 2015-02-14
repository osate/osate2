/**
 */
package org.osate.assure.assure.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.assure.assure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage
 * @generated
 */
public class AssureAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AssurePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssureAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AssurePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssureSwitch<Adapter> modelSwitch =
    new AssureSwitch<Adapter>()
    {
      @Override
      public Adapter caseAssuranceEvidence(AssuranceEvidence object)
      {
        return createAssuranceEvidenceAdapter();
      }
      @Override
      public Adapter caseClaimResult(ClaimResult object)
      {
        return createClaimResultAdapter();
      }
      @Override
      public Adapter caseVerificationResult(VerificationResult object)
      {
        return createVerificationResultAdapter();
      }
      @Override
      public Adapter caseAssureResult(AssureResult object)
      {
        return createAssureResultAdapter();
      }
      @Override
      public Adapter caseVerificationExpr(VerificationExpr object)
      {
        return createVerificationExprAdapter();
      }
      @Override
      public Adapter caseFailThenResult(FailThenResult object)
      {
        return createFailThenResultAdapter();
      }
      @Override
      public Adapter caseAndThenResult(AndThenResult object)
      {
        return createAndThenResultAdapter();
      }
      @Override
      public Adapter caseResultIssue(ResultIssue object)
      {
        return createResultIssueAdapter();
      }
      @Override
      public Adapter caseValidationResult(ValidationResult object)
      {
        return createValidationResultAdapter();
      }
      @Override
      public Adapter casePreconditionResult(PreconditionResult object)
      {
        return createPreconditionResultAdapter();
      }
      @Override
      public Adapter caseVerificationActivityResult(VerificationActivityResult object)
      {
        return createVerificationActivityResultAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.AssuranceEvidence <em>Assurance Evidence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.AssuranceEvidence
   * @generated
   */
  public Adapter createAssuranceEvidenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.ClaimResult
   * @generated
   */
  public Adapter createClaimResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.VerificationResult
   * @generated
   */
  public Adapter createVerificationResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.AssureResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.AssureResult
   * @generated
   */
  public Adapter createAssureResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationExpr <em>Verification Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.VerificationExpr
   * @generated
   */
  public Adapter createVerificationExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.FailThenResult <em>Fail Then Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.FailThenResult
   * @generated
   */
  public Adapter createFailThenResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.AndThenResult <em>And Then Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.AndThenResult
   * @generated
   */
  public Adapter createAndThenResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ResultIssue <em>Result Issue</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.ResultIssue
   * @generated
   */
  public Adapter createResultIssueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ValidationResult <em>Validation Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.ValidationResult
   * @generated
   */
  public Adapter createValidationResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.PreconditionResult <em>Precondition Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.PreconditionResult
   * @generated
   */
  public Adapter createPreconditionResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.assure.assure.VerificationActivityResult
   * @generated
   */
  public Adapter createVerificationActivityResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AssureAdapterFactory
