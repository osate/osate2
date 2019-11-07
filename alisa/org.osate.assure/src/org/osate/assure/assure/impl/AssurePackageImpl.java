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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.NestedClaimReference;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.assure.QualifiedVerificationPlanElementReference;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.organization.organization.OrganizationPackage;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.result.ResultPackage;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssurePackageImpl extends EPackageImpl implements AssurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assuranceCaseResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass claimResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verificationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assureResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verificationExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thenResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedVerificationPlanElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedClaimReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedVAReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedClaimReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preconditionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verificationActivityResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateResultEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.assure.assure.AssurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AssurePackageImpl() {
		super(eNS_URI, AssureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AssurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AssurePackage init() {
		if (isInited) return (AssurePackage)EPackage.Registry.INSTANCE.getEPackage(AssurePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAssurePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AssurePackageImpl theAssurePackage = registeredAssurePackage instanceof AssurePackageImpl ? (AssurePackageImpl)registeredAssurePackage : new AssurePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		Aadl2Package.eINSTANCE.eClass();
		AlisaPackage.eINSTANCE.eClass();
		ReqSpecPackage.eINSTANCE.eClass();
		ResultPackage.eINSTANCE.eClass();
		VerifyPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		CategoriesPackage.eINSTANCE.eClass();
		OrganizationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAssurePackage.createPackageContents();

		// Initialize created meta-data
		theAssurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAssurePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AssurePackage.eNS_URI, theAssurePackage);
		return theAssurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssuranceCaseResult() {
		return assuranceCaseResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssuranceCaseResult_Name() {
		return (EAttribute)assuranceCaseResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssuranceCaseResult_Message() {
		return (EAttribute)assuranceCaseResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssuranceCaseResult_ModelResult() {
		return (EReference)assuranceCaseResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelResult() {
		return modelResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelResult_Plan() {
		return (EReference)modelResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelResult_Target() {
		return (EReference)modelResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModelResult_Message() {
		return (EAttribute)modelResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelResult_ClaimResult() {
		return (EReference)modelResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelResult_SubsystemResult() {
		return (EReference)modelResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelResult_SubAssuranceCase() {
		return (EReference)modelResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubsystemResult() {
		return subsystemResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubsystemResult_TargetSystem() {
		return (EReference)subsystemResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubsystemResult_Message() {
		return (EAttribute)subsystemResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubsystemResult_ClaimResult() {
		return (EReference)subsystemResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubsystemResult_SubsystemResult() {
		return (EReference)subsystemResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClaimResult() {
		return claimResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClaimResult_TargetReference() {
		return (EReference)claimResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClaimResult_ModelElement() {
		return (EReference)claimResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClaimResult_Message() {
		return (EAttribute)claimResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClaimResult_SubClaimResult() {
		return (EReference)claimResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClaimResult_VerificationActivityResult() {
		return (EReference)claimResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClaimResult_PredicateResult() {
		return (EReference)claimResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVerificationResult() {
		return verificationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVerificationResult_Type() {
		return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationResult_Issues() {
		return (EReference)verificationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationResult_Results() {
		return (EReference)verificationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVerificationResult_Message() {
		return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationResult_Analysisresult() {
		return (EReference)verificationResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssureResult() {
		return assureResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssureResult_Metrics() {
		return (EReference)assureResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVerificationExpr() {
		return verificationExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElseResult() {
		return elseResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseResult_First() {
		return (EReference)elseResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseResult_Error() {
		return (EReference)elseResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseResult_Fail() {
		return (EReference)elseResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseResult_Timeout() {
		return (EReference)elseResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElseResult_DidFail() {
		return (EAttribute)elseResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThenResult() {
		return thenResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThenResult_First() {
		return (EReference)thenResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThenResult_Second() {
		return (EReference)thenResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThenResult_DidThenFail() {
		return (EAttribute)thenResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetrics() {
		return metricsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_TbdCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_SuccessCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_FailCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ErrorCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_DidelseCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ThenskipCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_PreconditionfailCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ValidationfailCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_FeaturesCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_FeaturesRequirementsCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_QualityCategoryRequirementsCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_TotalQualityCategoryCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_RequirementsWithoutPlanClaimCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_NoVerificationPlansCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_RequirementsCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ExceptionsCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ReqTargetHasEMV2SubclauseCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_FeaturesRequiringClassifierCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_FeaturesWithRequiredClassifierCount() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_Weight() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetrics_ExecutionTime() {
		return (EAttribute)metricsEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedVerificationPlanElementReference() {
		return qualifiedVerificationPlanElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedVerificationPlanElementReference_VerificationPlan() {
		return (EReference)qualifiedVerificationPlanElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedVerificationPlanElementReference_Requirement() {
		return (EReference)qualifiedVerificationPlanElementReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedClaimReference() {
		return qualifiedClaimReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedVAReference() {
		return qualifiedVAReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedVAReference_VerificationActivity() {
		return (EReference)qualifiedVAReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNestedClaimReference() {
		return nestedClaimReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNestedClaimReference_Requirement() {
		return (EReference)nestedClaimReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNestedClaimReference_Sub() {
		return (EReference)nestedClaimReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPreconditionResult() {
		return preconditionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPreconditionResult_Target() {
		return (EReference)preconditionResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidationResult() {
		return validationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationResult_Target() {
		return (EReference)validationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVerificationActivityResult() {
		return verificationActivityResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationActivityResult_TargetReference() {
		return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationActivityResult_PreconditionResult() {
		return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerificationActivityResult_ValidationResult() {
		return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicateResult() {
		return predicateResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicateResult_TargetReference() {
		return (EReference)predicateResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssureFactory getAssureFactory() {
		return (AssureFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		assuranceCaseResultEClass = createEClass(ASSURANCE_CASE_RESULT);
		createEAttribute(assuranceCaseResultEClass, ASSURANCE_CASE_RESULT__NAME);
		createEAttribute(assuranceCaseResultEClass, ASSURANCE_CASE_RESULT__MESSAGE);
		createEReference(assuranceCaseResultEClass, ASSURANCE_CASE_RESULT__MODEL_RESULT);

		modelResultEClass = createEClass(MODEL_RESULT);
		createEReference(modelResultEClass, MODEL_RESULT__PLAN);
		createEReference(modelResultEClass, MODEL_RESULT__TARGET);
		createEAttribute(modelResultEClass, MODEL_RESULT__MESSAGE);
		createEReference(modelResultEClass, MODEL_RESULT__CLAIM_RESULT);
		createEReference(modelResultEClass, MODEL_RESULT__SUBSYSTEM_RESULT);
		createEReference(modelResultEClass, MODEL_RESULT__SUB_ASSURANCE_CASE);

		subsystemResultEClass = createEClass(SUBSYSTEM_RESULT);
		createEReference(subsystemResultEClass, SUBSYSTEM_RESULT__TARGET_SYSTEM);
		createEAttribute(subsystemResultEClass, SUBSYSTEM_RESULT__MESSAGE);
		createEReference(subsystemResultEClass, SUBSYSTEM_RESULT__CLAIM_RESULT);
		createEReference(subsystemResultEClass, SUBSYSTEM_RESULT__SUBSYSTEM_RESULT);

		claimResultEClass = createEClass(CLAIM_RESULT);
		createEReference(claimResultEClass, CLAIM_RESULT__TARGET_REFERENCE);
		createEReference(claimResultEClass, CLAIM_RESULT__MODEL_ELEMENT);
		createEAttribute(claimResultEClass, CLAIM_RESULT__MESSAGE);
		createEReference(claimResultEClass, CLAIM_RESULT__SUB_CLAIM_RESULT);
		createEReference(claimResultEClass, CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT);
		createEReference(claimResultEClass, CLAIM_RESULT__PREDICATE_RESULT);

		verificationResultEClass = createEClass(VERIFICATION_RESULT);
		createEAttribute(verificationResultEClass, VERIFICATION_RESULT__TYPE);
		createEReference(verificationResultEClass, VERIFICATION_RESULT__ISSUES);
		createEReference(verificationResultEClass, VERIFICATION_RESULT__RESULTS);
		createEAttribute(verificationResultEClass, VERIFICATION_RESULT__MESSAGE);
		createEReference(verificationResultEClass, VERIFICATION_RESULT__ANALYSISRESULT);

		assureResultEClass = createEClass(ASSURE_RESULT);
		createEReference(assureResultEClass, ASSURE_RESULT__METRICS);

		verificationExprEClass = createEClass(VERIFICATION_EXPR);

		elseResultEClass = createEClass(ELSE_RESULT);
		createEReference(elseResultEClass, ELSE_RESULT__FIRST);
		createEReference(elseResultEClass, ELSE_RESULT__ERROR);
		createEReference(elseResultEClass, ELSE_RESULT__FAIL);
		createEReference(elseResultEClass, ELSE_RESULT__TIMEOUT);
		createEAttribute(elseResultEClass, ELSE_RESULT__DID_FAIL);

		thenResultEClass = createEClass(THEN_RESULT);
		createEReference(thenResultEClass, THEN_RESULT__FIRST);
		createEReference(thenResultEClass, THEN_RESULT__SECOND);
		createEAttribute(thenResultEClass, THEN_RESULT__DID_THEN_FAIL);

		metricsEClass = createEClass(METRICS);
		createEAttribute(metricsEClass, METRICS__TBD_COUNT);
		createEAttribute(metricsEClass, METRICS__SUCCESS_COUNT);
		createEAttribute(metricsEClass, METRICS__FAIL_COUNT);
		createEAttribute(metricsEClass, METRICS__ERROR_COUNT);
		createEAttribute(metricsEClass, METRICS__DIDELSE_COUNT);
		createEAttribute(metricsEClass, METRICS__THENSKIP_COUNT);
		createEAttribute(metricsEClass, METRICS__PRECONDITIONFAIL_COUNT);
		createEAttribute(metricsEClass, METRICS__VALIDATIONFAIL_COUNT);
		createEAttribute(metricsEClass, METRICS__FEATURES_COUNT);
		createEAttribute(metricsEClass, METRICS__FEATURES_REQUIREMENTS_COUNT);
		createEAttribute(metricsEClass, METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT);
		createEAttribute(metricsEClass, METRICS__TOTAL_QUALITY_CATEGORY_COUNT);
		createEAttribute(metricsEClass, METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT);
		createEAttribute(metricsEClass, METRICS__NO_VERIFICATION_PLANS_COUNT);
		createEAttribute(metricsEClass, METRICS__REQUIREMENTS_COUNT);
		createEAttribute(metricsEClass, METRICS__EXCEPTIONS_COUNT);
		createEAttribute(metricsEClass, METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT);
		createEAttribute(metricsEClass, METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT);
		createEAttribute(metricsEClass, METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT);
		createEAttribute(metricsEClass, METRICS__WEIGHT);
		createEAttribute(metricsEClass, METRICS__EXECUTION_TIME);

		qualifiedVerificationPlanElementReferenceEClass = createEClass(QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE);
		createEReference(qualifiedVerificationPlanElementReferenceEClass, QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN);
		createEReference(qualifiedVerificationPlanElementReferenceEClass, QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT);

		qualifiedClaimReferenceEClass = createEClass(QUALIFIED_CLAIM_REFERENCE);

		qualifiedVAReferenceEClass = createEClass(QUALIFIED_VA_REFERENCE);
		createEReference(qualifiedVAReferenceEClass, QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY);

		nestedClaimReferenceEClass = createEClass(NESTED_CLAIM_REFERENCE);
		createEReference(nestedClaimReferenceEClass, NESTED_CLAIM_REFERENCE__REQUIREMENT);
		createEReference(nestedClaimReferenceEClass, NESTED_CLAIM_REFERENCE__SUB);

		preconditionResultEClass = createEClass(PRECONDITION_RESULT);
		createEReference(preconditionResultEClass, PRECONDITION_RESULT__TARGET);

		validationResultEClass = createEClass(VALIDATION_RESULT);
		createEReference(validationResultEClass, VALIDATION_RESULT__TARGET);

		verificationActivityResultEClass = createEClass(VERIFICATION_ACTIVITY_RESULT);
		createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__TARGET_REFERENCE);
		createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT);
		createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT);

		predicateResultEClass = createEClass(PREDICATE_RESULT);
		createEReference(predicateResultEClass, PREDICATE_RESULT__TARGET_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		AlisaPackage theAlisaPackage = (AlisaPackage)EPackage.Registry.INSTANCE.getEPackage(AlisaPackage.eNS_URI);
		Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
		ResultPackage theResultPackage = (ResultPackage)EPackage.Registry.INSTANCE.getEPackage(ResultPackage.eNS_URI);
		VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);
		ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assuranceCaseResultEClass.getESuperTypes().add(this.getAssureResult());
		modelResultEClass.getESuperTypes().add(this.getAssureResult());
		subsystemResultEClass.getESuperTypes().add(this.getAssureResult());
		claimResultEClass.getESuperTypes().add(this.getAssureResult());
		verificationResultEClass.getESuperTypes().add(this.getAssureResult());
		verificationResultEClass.getESuperTypes().add(this.getVerificationExpr());
		verificationExprEClass.getESuperTypes().add(this.getAssureResult());
		elseResultEClass.getESuperTypes().add(this.getVerificationExpr());
		thenResultEClass.getESuperTypes().add(this.getVerificationExpr());
		qualifiedClaimReferenceEClass.getESuperTypes().add(this.getQualifiedVerificationPlanElementReference());
		qualifiedVAReferenceEClass.getESuperTypes().add(this.getQualifiedVerificationPlanElementReference());
		preconditionResultEClass.getESuperTypes().add(this.getVerificationResult());
		validationResultEClass.getESuperTypes().add(this.getVerificationResult());
		verificationActivityResultEClass.getESuperTypes().add(this.getVerificationResult());
		predicateResultEClass.getESuperTypes().add(this.getVerificationResult());

		// Initialize classes and features; add operations and parameters
		initEClass(assuranceCaseResultEClass, AssuranceCaseResult.class, "AssuranceCaseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssuranceCaseResult_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssuranceCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssuranceCaseResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssuranceCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssuranceCaseResult_ModelResult(), this.getModelResult(), null, "modelResult", null, 0, -1, AssuranceCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelResultEClass, ModelResult.class, "ModelResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelResult_Plan(), theAlisaPackage.getAssurancePlan(), null, "plan", null, 0, 1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelResult_Target(), theAadl2Package.getComponentImplementation(), null, "target", null, 0, 1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelResult_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelResult_SubsystemResult(), this.getSubsystemResult(), null, "subsystemResult", null, 0, -1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelResult_SubAssuranceCase(), this.getAssuranceCaseResult(), null, "subAssuranceCase", null, 0, -1, ModelResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subsystemResultEClass, SubsystemResult.class, "SubsystemResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemResult_TargetSystem(), theAadl2Package.getSubcomponent(), null, "targetSystem", null, 0, 1, SubsystemResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystemResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, SubsystemResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystemResult_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, SubsystemResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystemResult_SubsystemResult(), this.getSubsystemResult(), null, "subsystemResult", null, 0, -1, SubsystemResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(claimResultEClass, ClaimResult.class, "ClaimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClaimResult_TargetReference(), this.getQualifiedClaimReference(), null, "targetReference", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClaimResult_ModelElement(), theAadl2Package.getNamedElement(), null, "modelElement", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClaimResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClaimResult_SubClaimResult(), this.getClaimResult(), null, "subClaimResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClaimResult_VerificationActivityResult(), this.getVerificationExpr(), null, "verificationActivityResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClaimResult_PredicateResult(), this.getVerificationResult(), null, "predicateResult", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verificationResultEClass, VerificationResult.class, "VerificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVerificationResult_Type(), theResultPackage.getResultType(), "type", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVerificationResult_Issues(), theResultPackage.getDiagnostic(), null, "issues", null, 0, -1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVerificationResult_Results(), theResultPackage.getResult(), null, "results", null, 0, -1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerificationResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVerificationResult_Analysisresult(), theResultPackage.getAnalysisResult(), null, "analysisresult", null, 0, -1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assureResultEClass, AssureResult.class, "AssureResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssureResult_Metrics(), this.getMetrics(), null, "metrics", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verificationExprEClass, VerificationExpr.class, "VerificationExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elseResultEClass, ElseResult.class, "ElseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElseResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseResult_Error(), this.getVerificationExpr(), null, "error", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseResult_Fail(), this.getVerificationExpr(), null, "fail", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseResult_Timeout(), this.getVerificationExpr(), null, "timeout", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElseResult_DidFail(), theResultPackage.getResultType(), "didFail", null, 0, 1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thenResultEClass, ThenResult.class, "ThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThenResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThenResult_Second(), this.getVerificationExpr(), null, "second", null, 0, -1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThenResult_DidThenFail(), theEcorePackage.getEBoolean(), "didThenFail", null, 0, 1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricsEClass, Metrics.class, "Metrics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetrics_TbdCount(), theEcorePackage.getEInt(), "tbdCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_FailCount(), theEcorePackage.getEInt(), "failCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ErrorCount(), theEcorePackage.getEInt(), "errorCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_DidelseCount(), theEcorePackage.getEInt(), "didelseCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ThenskipCount(), theEcorePackage.getEInt(), "thenskipCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_PreconditionfailCount(), theEcorePackage.getEInt(), "preconditionfailCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ValidationfailCount(), theEcorePackage.getEInt(), "validationfailCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_FeaturesCount(), theEcorePackage.getEInt(), "featuresCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_FeaturesRequirementsCount(), theEcorePackage.getEInt(), "featuresRequirementsCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_QualityCategoryRequirementsCount(), theEcorePackage.getEInt(), "qualityCategoryRequirementsCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_TotalQualityCategoryCount(), theEcorePackage.getEInt(), "totalQualityCategoryCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_RequirementsWithoutPlanClaimCount(), theEcorePackage.getEInt(), "requirementsWithoutPlanClaimCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_NoVerificationPlansCount(), theEcorePackage.getEInt(), "noVerificationPlansCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_RequirementsCount(), theEcorePackage.getEInt(), "requirementsCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ExceptionsCount(), theEcorePackage.getEInt(), "exceptionsCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ReqTargetHasEMV2SubclauseCount(), theEcorePackage.getEInt(), "reqTargetHasEMV2SubclauseCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_FeaturesRequiringClassifierCount(), theEcorePackage.getEInt(), "featuresRequiringClassifierCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_FeaturesWithRequiredClassifierCount(), theEcorePackage.getEInt(), "featuresWithRequiredClassifierCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetrics_ExecutionTime(), theAadl2Package.getInteger(), "executionTime", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedVerificationPlanElementReferenceEClass, QualifiedVerificationPlanElementReference.class, "QualifiedVerificationPlanElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedVerificationPlanElementReference_VerificationPlan(), theVerifyPackage.getVerificationPlan(), null, "verificationPlan", null, 0, 1, QualifiedVerificationPlanElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedVerificationPlanElementReference_Requirement(), this.getNestedClaimReference(), null, "requirement", null, 0, 1, QualifiedVerificationPlanElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedClaimReferenceEClass, QualifiedClaimReference.class, "QualifiedClaimReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qualifiedVAReferenceEClass, QualifiedVAReference.class, "QualifiedVAReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedVAReference_VerificationActivity(), theVerifyPackage.getVerificationActivity(), null, "verificationActivity", null, 0, 1, QualifiedVAReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nestedClaimReferenceEClass, NestedClaimReference.class, "NestedClaimReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNestedClaimReference_Requirement(), theReqSpecPackage.getRequirement(), null, "requirement", null, 0, 1, NestedClaimReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNestedClaimReference_Sub(), this.getNestedClaimReference(), null, "sub", null, 0, 1, NestedClaimReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preconditionResultEClass, PreconditionResult.class, "PreconditionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreconditionResult_Target(), theVerifyPackage.getVerificationMethod(), null, "target", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validationResultEClass, ValidationResult.class, "ValidationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidationResult_Target(), theVerifyPackage.getVerificationMethod(), null, "target", null, 0, 1, ValidationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verificationActivityResultEClass, VerificationActivityResult.class, "VerificationActivityResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVerificationActivityResult_TargetReference(), this.getQualifiedVAReference(), null, "targetReference", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVerificationActivityResult_PreconditionResult(), this.getVerificationResult(), null, "preconditionResult", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVerificationActivityResult_ValidationResult(), this.getVerificationResult(), null, "validationResult", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateResultEClass, PredicateResult.class, "PredicateResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicateResult_TargetReference(), this.getQualifiedClaimReference(), null, "targetReference", null, 0, 1, PredicateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AssurePackageImpl
