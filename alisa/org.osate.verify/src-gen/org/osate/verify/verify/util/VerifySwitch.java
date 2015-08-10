/**
 */
package org.osate.verify.verify.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.verify.verify.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.verify.verify.VerifyPackage
 * @generated
 */
public class VerifySwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VerifyPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerifySwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = VerifyPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case VerifyPackage.VERIFICATION:
      {
        Verification verification = (Verification)theEObject;
        T result = caseVerification(verification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_PLAN:
      {
        VerificationPlan verificationPlan = (VerificationPlan)theEObject;
        T result = caseVerificationPlan(verificationPlan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.CLAIM:
      {
        Claim claim = (Claim)theEObject;
        T result = caseClaim(claim);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_ACTIVITY:
      {
        VerificationActivity verificationActivity = (VerificationActivity)theEObject;
        T result = caseVerificationActivity(verificationActivity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.ARGUMENT_EXPR:
      {
        ArgumentExpr argumentExpr = (ArgumentExpr)theEObject;
        T result = caseArgumentExpr(argumentExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_METHOD_REGISTRY:
      {
        VerificationMethodRegistry verificationMethodRegistry = (VerificationMethodRegistry)theEObject;
        T result = caseVerificationMethodRegistry(verificationMethodRegistry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_METHOD:
      {
        VerificationMethod verificationMethod = (VerificationMethod)theEObject;
        T result = caseVerificationMethod(verificationMethod);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_CONDITION:
      {
        VerificationCondition verificationCondition = (VerificationCondition)theEObject;
        T result = caseVerificationCondition(verificationCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.THEN_EXPR:
      {
        ThenExpr thenExpr = (ThenExpr)theEObject;
        T result = caseThenExpr(thenExpr);
        if (result == null) result = caseArgumentExpr(thenExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.ELSE_EXPR:
      {
        ElseExpr elseExpr = (ElseExpr)theEObject;
        T result = caseElseExpr(elseExpr);
        if (result == null) result = caseArgumentExpr(elseExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.ALL_EXPR:
      {
        AllExpr allExpr = (AllExpr)theEObject;
        T result = caseAllExpr(allExpr);
        if (result == null) result = caseArgumentExpr(allExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.REF_EXPR:
      {
        RefExpr refExpr = (RefExpr)theEObject;
        T result = caseRefExpr(refExpr);
        if (result == null) result = caseArgumentExpr(refExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_VALIDATION:
      {
        VerificationValidation verificationValidation = (VerificationValidation)theEObject;
        T result = caseVerificationValidation(verificationValidation);
        if (result == null) result = caseVerificationCondition(verificationValidation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VerifyPackage.VERIFICATION_PRECONDITION:
      {
        VerificationPrecondition verificationPrecondition = (VerificationPrecondition)theEObject;
        T result = caseVerificationPrecondition(verificationPrecondition);
        if (result == null) result = caseVerificationCondition(verificationPrecondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerification(Verification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Plan</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Plan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationPlan(VerificationPlan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Claim</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Claim</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClaim(Claim object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Activity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Activity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationActivity(VerificationActivity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgumentExpr(ArgumentExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Method Registry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Method Registry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationMethodRegistry(VerificationMethodRegistry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Method</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Method</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationMethod(VerificationMethod object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationCondition(VerificationCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Then Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Then Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThenExpr(ThenExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseExpr(ElseExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>All Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>All Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAllExpr(AllExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefExpr(RefExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Validation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Validation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationValidation(VerificationValidation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Precondition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Precondition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationPrecondition(VerificationPrecondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //VerifySwitch
