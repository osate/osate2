/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
      case VerifyPackage.VERIFICATION: return createVerification();
      case VerifyPackage.VERIFICATION_PLAN: return createVerificationPlan();
      case VerifyPackage.CLAIM: return createClaim();
      case VerifyPackage.ARGUMENT_EXPR: return createArgumentExpr();
      case VerifyPackage.COMPUTE_REF: return createComputeRef();
      case VerifyPackage.VERIFICATION_ACTIVITY: return createVerificationActivity();
      case VerifyPackage.VERIFICATION_CONDITION: return createVerificationCondition();
      case VerifyPackage.VERIFICATION_METHOD_REGISTRY: return createVerificationMethodRegistry();
      case VerifyPackage.FORMAL_PARAMETER: return createFormalParameter();
      case VerifyPackage.VERIFICATION_METHOD: return createVerificationMethod();
      case VerifyPackage.METHOD_KIND: return createMethodKind();
      case VerifyPackage.RESOLUTE_METHOD: return createResoluteMethod();
      case VerifyPackage.JAVA_METHOD: return createJavaMethod();
      case VerifyPackage.PYTHON_METHOD: return createPythonMethod();
      case VerifyPackage.MANUAL_METHOD: return createManualMethod();
      case VerifyPackage.PLUGIN_METHOD: return createPluginMethod();
      case VerifyPackage.AGREE_METHOD: return createAgreeMethod();
      case VerifyPackage.JUNIT4_METHOD: return createJUnit4Method();
      case VerifyPackage.JAVA_PARAMETER: return createJavaParameter();
      case VerifyPackage.THEN_EXPR: return createThenExpr();
      case VerifyPackage.ELSE_EXPR: return createElseExpr();
      case VerifyPackage.ALL_EXPR: return createAllExpr();
      case VerifyPackage.REF_EXPR: return createRefExpr();
      case VerifyPackage.VERIFICATION_VALIDATION: return createVerificationValidation();
      case VerifyPackage.VERIFICATION_PRECONDITION: return createVerificationPrecondition();
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public ComputeRef createComputeRef()
  {
    ComputeRefImpl computeRef = new ComputeRefImpl();
    return computeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public MethodKind createMethodKind()
  {
    MethodKindImpl methodKind = new MethodKindImpl();
    return methodKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResoluteMethod createResoluteMethod()
  {
    ResoluteMethodImpl resoluteMethod = new ResoluteMethodImpl();
    return resoluteMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaMethod createJavaMethod()
  {
    JavaMethodImpl javaMethod = new JavaMethodImpl();
    return javaMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PythonMethod createPythonMethod()
  {
    PythonMethodImpl pythonMethod = new PythonMethodImpl();
    return pythonMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ManualMethod createManualMethod()
  {
    ManualMethodImpl manualMethod = new ManualMethodImpl();
    return manualMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PluginMethod createPluginMethod()
  {
    PluginMethodImpl pluginMethod = new PluginMethodImpl();
    return pluginMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AgreeMethod createAgreeMethod()
  {
    AgreeMethodImpl agreeMethod = new AgreeMethodImpl();
    return agreeMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JUnit4Method createJUnit4Method()
  {
    JUnit4MethodImpl jUnit4Method = new JUnit4MethodImpl();
    return jUnit4Method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaParameter createJavaParameter()
  {
    JavaParameterImpl javaParameter = new JavaParameterImpl();
    return javaParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
