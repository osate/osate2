/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.IfCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelPackageImpl extends EPackageImpl implements ErrorModelPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorModelSubclauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorModelLibraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emv2PropertyAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emv2PathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emv2PathElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorTypesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeTransformationSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeTransformationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMappingSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPropagationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureorPPReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorFlowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorSourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorSinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propagationPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propagationPathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedPropagationPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorStateMachineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass repairEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recoverEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionBranchEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass branchValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ormoreExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orlessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventOrPropagationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outgoingPropagationConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorDetectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorCodeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorStateToModeMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compositeStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedErrorBehaviorStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subcomponentElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emv2RootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass allExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedErrorEventOrPropagationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedErrorPropagationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sConditionElementEClass = null;

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
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ErrorModelPackageImpl()
  {
    super(eNS_URI, ErrorModelFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ErrorModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ErrorModelPackage init()
  {
    if (isInited) return (ErrorModelPackage)EPackage.Registry.INSTANCE.getEPackage(ErrorModelPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredErrorModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ErrorModelPackageImpl theErrorModelPackage = registeredErrorModelPackage instanceof ErrorModelPackageImpl ? (ErrorModelPackageImpl)registeredErrorModelPackage : new ErrorModelPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theErrorModelPackage.createPackageContents();

    // Initialize created meta-data
    theErrorModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theErrorModelPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ErrorModelPackage.eNS_URI, theErrorModelPackage);
    return theErrorModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorModelSubclause()
  {
    return errorModelSubclauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_UseTypes()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_TypeEquivalence()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_TypeMappingSet()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_UseBehavior()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Propagations()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Flows()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_UseTransformation()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Events()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Transitions()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_OutgoingPropagationConditions()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_ErrorDetections()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_ErrorStateToModeMappings()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_States()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_TypeTransformationSet()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_ConnectionErrorSources()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Points()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Paths()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelSubclause_Properties()
  {
    return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorModelLibrary()
  {
    return errorModelLibraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_UseTypes()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Extends()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Types()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Typesets()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Properties()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Behaviors()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Mappings()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorModelLibrary_Transformations()
  {
    return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEMV2PropertyAssociation()
  {
    return emv2PropertyAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PropertyAssociation_Property()
  {
    return (EReference)emv2PropertyAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PropertyAssociation_OwnedValues()
  {
    return (EReference)emv2PropertyAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PropertyAssociation_Emv2Path()
  {
    return (EReference)emv2PropertyAssociationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEMV2Path()
  {
    return emv2PathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2Path_ContainmentPath()
  {
    return (EReference)emv2PathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2Path_Emv2Target()
  {
    return (EReference)emv2PathEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEMV2PathElement()
  {
    return emv2PathElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEMV2PathElement_Emv2PropagationKind()
  {
    return (EAttribute)emv2PathElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PathElement_ErrorType()
  {
    return (EReference)emv2PathElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PathElement_NamedElement()
  {
    return (EReference)emv2PathElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2PathElement_Path()
  {
    return (EReference)emv2PathElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorTypes()
  {
    return errorTypesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorType()
  {
    return errorTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorType_SuperType()
  {
    return (EReference)errorTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorType_AliasedType()
  {
    return (EReference)errorTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSet()
  {
    return typeSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSet_TypeTokens()
  {
    return (EReference)typeSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSet_AliasedType()
  {
    return (EReference)typeSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeToken()
  {
    return typeTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeToken_Type()
  {
    return (EReference)typeTokenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeToken_NoError()
  {
    return (EAttribute)typeTokenEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeTransformationSet()
  {
    return typeTransformationSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeTransformationSet_UseTypes()
  {
    return (EReference)typeTransformationSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeTransformationSet_Transformation()
  {
    return (EReference)typeTransformationSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeTransformation()
  {
    return typeTransformationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeTransformation_Source()
  {
    return (EReference)typeTransformationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeTransformation_AllSources()
  {
    return (EAttribute)typeTransformationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeTransformation_Contributor()
  {
    return (EReference)typeTransformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeTransformation_Target()
  {
    return (EReference)typeTransformationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeMappingSet()
  {
    return typeMappingSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeMappingSet_UseTypes()
  {
    return (EReference)typeMappingSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeMappingSet_Mapping()
  {
    return (EReference)typeMappingSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeMapping()
  {
    return typeMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeMapping_Source()
  {
    return (EReference)typeMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeMapping_Target()
  {
    return (EReference)typeMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPropagation()
  {
    return errorPropagationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Kind()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagation_FeatureorPPRef()
  {
    return (EReference)errorPropagationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Not()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Direction()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagation_TypeSet()
  {
    return (EReference)errorPropagationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureorPPReference()
  {
    return featureorPPReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureorPPReference_FeatureorPP()
  {
    return (EReference)featureorPPReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureorPPReference_Next()
  {
    return (EReference)featureorPPReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorFlow()
  {
    return errorFlowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorFlow_TypeTokenConstraint()
  {
    return (EReference)errorFlowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorFlow_Flowcondition()
  {
    return (EReference)errorFlowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorSource()
  {
    return errorSourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSource_SourceModelElement()
  {
    return (EReference)errorSourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorSource_All()
  {
    return (EAttribute)errorSourceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSource_FailureModeReference()
  {
    return (EReference)errorSourceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSource_FailureModeType()
  {
    return (EReference)errorSourceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorSource_FailureModeDescription()
  {
    return (EAttribute)errorSourceEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorSink()
  {
    return errorSinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSink_Incoming()
  {
    return (EReference)errorSinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorSink_AllIncoming()
  {
    return (EAttribute)errorSinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPath()
  {
    return errorPathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_Incoming()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPath_AllIncoming()
  {
    return (EAttribute)errorPathEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_Outgoing()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPath_AllOutgoing()
  {
    return (EAttribute)errorPathEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_TargetToken()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_TypeMappingSet()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfCondition()
  {
    return ifConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfCondition_Description()
  {
    return (EAttribute)ifConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfCondition_ResoluteFunction()
  {
    return (EReference)ifConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfCondition_JavaMethod()
  {
    return (EAttribute)ifConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropagationPoint()
  {
    return propagationPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropagationPath()
  {
    return propagationPathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationPath_Source()
  {
    return (EReference)propagationPathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationPath_Target()
  {
    return (EReference)propagationPathEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedPropagationPoint()
  {
    return qualifiedPropagationPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedPropagationPoint_Subcomponent()
  {
    return (EReference)qualifiedPropagationPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedPropagationPoint_Next()
  {
    return (EReference)qualifiedPropagationPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedPropagationPoint_PropagationPoint()
  {
    return (EReference)qualifiedPropagationPointEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorStateMachine()
  {
    return errorBehaviorStateMachineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_UseTypes()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_UseTransformation()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Events()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_States()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Transitions()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Properties()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorEvent()
  {
    return errorBehaviorEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorEvent()
  {
    return errorEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorEvent_TypeSet()
  {
    return (EReference)errorEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorEvent_Eventcondition()
  {
    return (EReference)errorEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRepairEvent()
  {
    return repairEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRepairEvent_EventInitiator()
  {
    return (EReference)repairEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecoverEvent()
  {
    return recoverEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecoverEvent_EventInitiator()
  {
    return (EReference)recoverEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecoverEvent_Condition()
  {
    return (EReference)recoverEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorState()
  {
    return errorBehaviorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorState_Intial()
  {
    return (EAttribute)errorBehaviorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorState_TypeSet()
  {
    return (EReference)errorBehaviorStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorTransition()
  {
    return errorBehaviorTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_Source()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_TypeTokenConstraint()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorTransition_AllStates()
  {
    return (EAttribute)errorBehaviorTransitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_Condition()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_Target()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_TargetToken()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorTransition_SteadyState()
  {
    return (EAttribute)errorBehaviorTransitionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_DestinationBranches()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionBranch()
  {
    return transitionBranchEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionBranch_Target()
  {
    return (EReference)transitionBranchEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionBranch_TargetToken()
  {
    return (EReference)transitionBranchEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionBranch_SteadyState()
  {
    return (EAttribute)transitionBranchEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionBranch_Value()
  {
    return (EReference)transitionBranchEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBranchValue()
  {
    return branchValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBranchValue_Realvalue()
  {
    return (EAttribute)branchValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBranchValue_Symboliclabel()
  {
    return (EReference)branchValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBranchValue_Others()
  {
    return (EAttribute)branchValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionExpression()
  {
    return conditionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrmoreExpression()
  {
    return ormoreExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrmoreExpression_Count()
  {
    return (EAttribute)ormoreExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrmoreExpression_Operands()
  {
    return (EReference)ormoreExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrlessExpression()
  {
    return orlessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrlessExpression_Count()
  {
    return (EAttribute)orlessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrlessExpression_Operands()
  {
    return (EReference)orlessExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionElement()
  {
    return conditionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionElement_QualifiedErrorPropagationReference()
  {
    return (EReference)conditionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionElement_Constraint()
  {
    return (EReference)conditionElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventOrPropagation()
  {
    return eventOrPropagationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutgoingPropagationCondition()
  {
    return outgoingPropagationConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingPropagationCondition_State()
  {
    return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingPropagationCondition_TypeTokenConstraint()
  {
    return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOutgoingPropagationCondition_AllStates()
  {
    return (EAttribute)outgoingPropagationConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingPropagationCondition_Condition()
  {
    return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingPropagationCondition_Outgoing()
  {
    return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOutgoingPropagationCondition_AllPropagations()
  {
    return (EAttribute)outgoingPropagationConditionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingPropagationCondition_TypeToken()
  {
    return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorDetection()
  {
    return errorDetectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorDetection_State()
  {
    return (EReference)errorDetectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorDetection_TypeTokenConstraint()
  {
    return (EReference)errorDetectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorDetection_AllStates()
  {
    return (EAttribute)errorDetectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorDetection_Condition()
  {
    return (EReference)errorDetectionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorDetection_DetectionReportingPort()
  {
    return (EReference)errorDetectionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorDetection_ErrorCode()
  {
    return (EReference)errorDetectionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorCodeValue()
  {
    return errorCodeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorCodeValue_IntValue()
  {
    return (EAttribute)errorCodeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorCodeValue_Constant()
  {
    return (EReference)errorCodeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorCodeValue_EnumLiteral()
  {
    return (EAttribute)errorCodeValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorStateToModeMapping()
  {
    return errorStateToModeMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorStateToModeMapping_ErrorState()
  {
    return (EReference)errorStateToModeMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorStateToModeMapping_TypeToken()
  {
    return (EReference)errorStateToModeMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorStateToModeMapping_MappedModes()
  {
    return (EReference)errorStateToModeMappingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompositeState()
  {
    return compositeStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeState_Condition()
  {
    return (EReference)compositeStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCompositeState_Others()
  {
    return (EAttribute)compositeStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeState_State()
  {
    return (EReference)compositeStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeState_TypedToken()
  {
    return (EReference)compositeStateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedErrorBehaviorState()
  {
    return qualifiedErrorBehaviorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedErrorBehaviorState_Subcomponent()
  {
    return (EReference)qualifiedErrorBehaviorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedErrorBehaviorState_Next()
  {
    return (EReference)qualifiedErrorBehaviorStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedErrorBehaviorState_State()
  {
    return (EReference)qualifiedErrorBehaviorStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubcomponentElement()
  {
    return subcomponentElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubcomponentElement_Subcomponent()
  {
    return (EReference)subcomponentElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEMV2Root()
  {
    return emv2RootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2Root_Library()
  {
    return (EReference)emv2RootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMV2Root_Subclauses()
  {
    return (EReference)emv2RootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Operands()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Operands()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAllExpression()
  {
    return allExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAllExpression_Count()
  {
    return (EAttribute)allExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAllExpression_Operands()
  {
    return (EReference)allExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedErrorEventOrPropagation()
  {
    return qualifiedErrorEventOrPropagationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedErrorPropagation()
  {
    return qualifiedErrorPropagationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSConditionElement()
  {
    return sConditionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSConditionElement_QualifiedState()
  {
    return (EReference)sConditionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelFactory getErrorModelFactory()
  {
    return (ErrorModelFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    errorModelSubclauseEClass = createEClass(ERROR_MODEL_SUBCLAUSE);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__USE_TYPES);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__PROPAGATIONS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__FLOWS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__EVENTS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__TRANSITIONS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__STATES);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__POINTS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__PATHS);
    createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__PROPERTIES);

    errorModelLibraryEClass = createEClass(ERROR_MODEL_LIBRARY);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__USE_TYPES);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__EXTENDS);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__TYPES);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__TYPESETS);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__PROPERTIES);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__BEHAVIORS);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__MAPPINGS);
    createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__TRANSFORMATIONS);

    emv2PropertyAssociationEClass = createEClass(EMV2_PROPERTY_ASSOCIATION);
    createEReference(emv2PropertyAssociationEClass, EMV2_PROPERTY_ASSOCIATION__PROPERTY);
    createEReference(emv2PropertyAssociationEClass, EMV2_PROPERTY_ASSOCIATION__OWNED_VALUES);
    createEReference(emv2PropertyAssociationEClass, EMV2_PROPERTY_ASSOCIATION__EMV2_PATH);

    emv2PathEClass = createEClass(EMV2_PATH);
    createEReference(emv2PathEClass, EMV2_PATH__CONTAINMENT_PATH);
    createEReference(emv2PathEClass, EMV2_PATH__EMV2_TARGET);

    emv2PathElementEClass = createEClass(EMV2_PATH_ELEMENT);
    createEAttribute(emv2PathElementEClass, EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND);
    createEReference(emv2PathElementEClass, EMV2_PATH_ELEMENT__ERROR_TYPE);
    createEReference(emv2PathElementEClass, EMV2_PATH_ELEMENT__NAMED_ELEMENT);
    createEReference(emv2PathElementEClass, EMV2_PATH_ELEMENT__PATH);

    errorTypesEClass = createEClass(ERROR_TYPES);

    errorTypeEClass = createEClass(ERROR_TYPE);
    createEReference(errorTypeEClass, ERROR_TYPE__SUPER_TYPE);
    createEReference(errorTypeEClass, ERROR_TYPE__ALIASED_TYPE);

    typeSetEClass = createEClass(TYPE_SET);
    createEReference(typeSetEClass, TYPE_SET__TYPE_TOKENS);
    createEReference(typeSetEClass, TYPE_SET__ALIASED_TYPE);

    typeTokenEClass = createEClass(TYPE_TOKEN);
    createEReference(typeTokenEClass, TYPE_TOKEN__TYPE);
    createEAttribute(typeTokenEClass, TYPE_TOKEN__NO_ERROR);

    typeTransformationSetEClass = createEClass(TYPE_TRANSFORMATION_SET);
    createEReference(typeTransformationSetEClass, TYPE_TRANSFORMATION_SET__USE_TYPES);
    createEReference(typeTransformationSetEClass, TYPE_TRANSFORMATION_SET__TRANSFORMATION);

    typeTransformationEClass = createEClass(TYPE_TRANSFORMATION);
    createEReference(typeTransformationEClass, TYPE_TRANSFORMATION__SOURCE);
    createEAttribute(typeTransformationEClass, TYPE_TRANSFORMATION__ALL_SOURCES);
    createEReference(typeTransformationEClass, TYPE_TRANSFORMATION__CONTRIBUTOR);
    createEReference(typeTransformationEClass, TYPE_TRANSFORMATION__TARGET);

    typeMappingSetEClass = createEClass(TYPE_MAPPING_SET);
    createEReference(typeMappingSetEClass, TYPE_MAPPING_SET__USE_TYPES);
    createEReference(typeMappingSetEClass, TYPE_MAPPING_SET__MAPPING);

    typeMappingEClass = createEClass(TYPE_MAPPING);
    createEReference(typeMappingEClass, TYPE_MAPPING__SOURCE);
    createEReference(typeMappingEClass, TYPE_MAPPING__TARGET);

    errorPropagationEClass = createEClass(ERROR_PROPAGATION);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__KIND);
    createEReference(errorPropagationEClass, ERROR_PROPAGATION__FEATUREOR_PP_REF);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__NOT);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__DIRECTION);
    createEReference(errorPropagationEClass, ERROR_PROPAGATION__TYPE_SET);

    featureorPPReferenceEClass = createEClass(FEATUREOR_PP_REFERENCE);
    createEReference(featureorPPReferenceEClass, FEATUREOR_PP_REFERENCE__FEATUREOR_PP);
    createEReference(featureorPPReferenceEClass, FEATUREOR_PP_REFERENCE__NEXT);

    errorFlowEClass = createEClass(ERROR_FLOW);
    createEReference(errorFlowEClass, ERROR_FLOW__TYPE_TOKEN_CONSTRAINT);
    createEReference(errorFlowEClass, ERROR_FLOW__FLOWCONDITION);

    errorSourceEClass = createEClass(ERROR_SOURCE);
    createEReference(errorSourceEClass, ERROR_SOURCE__SOURCE_MODEL_ELEMENT);
    createEAttribute(errorSourceEClass, ERROR_SOURCE__ALL);
    createEReference(errorSourceEClass, ERROR_SOURCE__FAILURE_MODE_REFERENCE);
    createEReference(errorSourceEClass, ERROR_SOURCE__FAILURE_MODE_TYPE);
    createEAttribute(errorSourceEClass, ERROR_SOURCE__FAILURE_MODE_DESCRIPTION);

    errorSinkEClass = createEClass(ERROR_SINK);
    createEReference(errorSinkEClass, ERROR_SINK__INCOMING);
    createEAttribute(errorSinkEClass, ERROR_SINK__ALL_INCOMING);

    errorPathEClass = createEClass(ERROR_PATH);
    createEReference(errorPathEClass, ERROR_PATH__INCOMING);
    createEAttribute(errorPathEClass, ERROR_PATH__ALL_INCOMING);
    createEReference(errorPathEClass, ERROR_PATH__OUTGOING);
    createEAttribute(errorPathEClass, ERROR_PATH__ALL_OUTGOING);
    createEReference(errorPathEClass, ERROR_PATH__TARGET_TOKEN);
    createEReference(errorPathEClass, ERROR_PATH__TYPE_MAPPING_SET);

    ifConditionEClass = createEClass(IF_CONDITION);
    createEAttribute(ifConditionEClass, IF_CONDITION__DESCRIPTION);
    createEReference(ifConditionEClass, IF_CONDITION__RESOLUTE_FUNCTION);
    createEAttribute(ifConditionEClass, IF_CONDITION__JAVA_METHOD);

    propagationPointEClass = createEClass(PROPAGATION_POINT);

    propagationPathEClass = createEClass(PROPAGATION_PATH);
    createEReference(propagationPathEClass, PROPAGATION_PATH__SOURCE);
    createEReference(propagationPathEClass, PROPAGATION_PATH__TARGET);

    qualifiedPropagationPointEClass = createEClass(QUALIFIED_PROPAGATION_POINT);
    createEReference(qualifiedPropagationPointEClass, QUALIFIED_PROPAGATION_POINT__SUBCOMPONENT);
    createEReference(qualifiedPropagationPointEClass, QUALIFIED_PROPAGATION_POINT__NEXT);
    createEReference(qualifiedPropagationPointEClass, QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT);

    errorBehaviorStateMachineEClass = createEClass(ERROR_BEHAVIOR_STATE_MACHINE);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__EVENTS);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__STATES);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES);

    errorBehaviorEventEClass = createEClass(ERROR_BEHAVIOR_EVENT);

    errorEventEClass = createEClass(ERROR_EVENT);
    createEReference(errorEventEClass, ERROR_EVENT__TYPE_SET);
    createEReference(errorEventEClass, ERROR_EVENT__EVENTCONDITION);

    repairEventEClass = createEClass(REPAIR_EVENT);
    createEReference(repairEventEClass, REPAIR_EVENT__EVENT_INITIATOR);

    recoverEventEClass = createEClass(RECOVER_EVENT);
    createEReference(recoverEventEClass, RECOVER_EVENT__EVENT_INITIATOR);
    createEReference(recoverEventEClass, RECOVER_EVENT__CONDITION);

    errorBehaviorStateEClass = createEClass(ERROR_BEHAVIOR_STATE);
    createEAttribute(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__INTIAL);
    createEReference(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__TYPE_SET);

    errorBehaviorTransitionEClass = createEClass(ERROR_BEHAVIOR_TRANSITION);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__SOURCE);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT);
    createEAttribute(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__ALL_STATES);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__CONDITION);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TARGET);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN);
    createEAttribute(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__STEADY_STATE);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES);

    transitionBranchEClass = createEClass(TRANSITION_BRANCH);
    createEReference(transitionBranchEClass, TRANSITION_BRANCH__TARGET);
    createEReference(transitionBranchEClass, TRANSITION_BRANCH__TARGET_TOKEN);
    createEAttribute(transitionBranchEClass, TRANSITION_BRANCH__STEADY_STATE);
    createEReference(transitionBranchEClass, TRANSITION_BRANCH__VALUE);

    branchValueEClass = createEClass(BRANCH_VALUE);
    createEAttribute(branchValueEClass, BRANCH_VALUE__REALVALUE);
    createEReference(branchValueEClass, BRANCH_VALUE__SYMBOLICLABEL);
    createEAttribute(branchValueEClass, BRANCH_VALUE__OTHERS);

    conditionExpressionEClass = createEClass(CONDITION_EXPRESSION);

    ormoreExpressionEClass = createEClass(ORMORE_EXPRESSION);
    createEAttribute(ormoreExpressionEClass, ORMORE_EXPRESSION__COUNT);
    createEReference(ormoreExpressionEClass, ORMORE_EXPRESSION__OPERANDS);

    orlessExpressionEClass = createEClass(ORLESS_EXPRESSION);
    createEAttribute(orlessExpressionEClass, ORLESS_EXPRESSION__COUNT);
    createEReference(orlessExpressionEClass, ORLESS_EXPRESSION__OPERANDS);

    conditionElementEClass = createEClass(CONDITION_ELEMENT);
    createEReference(conditionElementEClass, CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE);
    createEReference(conditionElementEClass, CONDITION_ELEMENT__CONSTRAINT);

    eventOrPropagationEClass = createEClass(EVENT_OR_PROPAGATION);

    outgoingPropagationConditionEClass = createEClass(OUTGOING_PROPAGATION_CONDITION);
    createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__STATE);
    createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT);
    createEAttribute(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__ALL_STATES);
    createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__CONDITION);
    createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__OUTGOING);
    createEAttribute(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS);
    createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN);

    errorDetectionEClass = createEClass(ERROR_DETECTION);
    createEReference(errorDetectionEClass, ERROR_DETECTION__STATE);
    createEReference(errorDetectionEClass, ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT);
    createEAttribute(errorDetectionEClass, ERROR_DETECTION__ALL_STATES);
    createEReference(errorDetectionEClass, ERROR_DETECTION__CONDITION);
    createEReference(errorDetectionEClass, ERROR_DETECTION__DETECTION_REPORTING_PORT);
    createEReference(errorDetectionEClass, ERROR_DETECTION__ERROR_CODE);

    errorCodeValueEClass = createEClass(ERROR_CODE_VALUE);
    createEAttribute(errorCodeValueEClass, ERROR_CODE_VALUE__INT_VALUE);
    createEReference(errorCodeValueEClass, ERROR_CODE_VALUE__CONSTANT);
    createEAttribute(errorCodeValueEClass, ERROR_CODE_VALUE__ENUM_LITERAL);

    errorStateToModeMappingEClass = createEClass(ERROR_STATE_TO_MODE_MAPPING);
    createEReference(errorStateToModeMappingEClass, ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE);
    createEReference(errorStateToModeMappingEClass, ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN);
    createEReference(errorStateToModeMappingEClass, ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES);

    compositeStateEClass = createEClass(COMPOSITE_STATE);
    createEReference(compositeStateEClass, COMPOSITE_STATE__CONDITION);
    createEAttribute(compositeStateEClass, COMPOSITE_STATE__OTHERS);
    createEReference(compositeStateEClass, COMPOSITE_STATE__STATE);
    createEReference(compositeStateEClass, COMPOSITE_STATE__TYPED_TOKEN);

    qualifiedErrorBehaviorStateEClass = createEClass(QUALIFIED_ERROR_BEHAVIOR_STATE);
    createEReference(qualifiedErrorBehaviorStateEClass, QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT);
    createEReference(qualifiedErrorBehaviorStateEClass, QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT);
    createEReference(qualifiedErrorBehaviorStateEClass, QUALIFIED_ERROR_BEHAVIOR_STATE__STATE);

    subcomponentElementEClass = createEClass(SUBCOMPONENT_ELEMENT);
    createEReference(subcomponentElementEClass, SUBCOMPONENT_ELEMENT__SUBCOMPONENT);

    emv2RootEClass = createEClass(EMV2_ROOT);
    createEReference(emv2RootEClass, EMV2_ROOT__LIBRARY);
    createEReference(emv2RootEClass, EMV2_ROOT__SUBCLAUSES);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__OPERANDS);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__OPERANDS);

    allExpressionEClass = createEClass(ALL_EXPRESSION);
    createEAttribute(allExpressionEClass, ALL_EXPRESSION__COUNT);
    createEReference(allExpressionEClass, ALL_EXPRESSION__OPERANDS);

    qualifiedErrorEventOrPropagationEClass = createEClass(QUALIFIED_ERROR_EVENT_OR_PROPAGATION);

    qualifiedErrorPropagationEClass = createEClass(QUALIFIED_ERROR_PROPAGATION);

    sConditionElementEClass = createEClass(SCONDITION_ELEMENT);
    createEReference(sConditionElementEClass, SCONDITION_ELEMENT__QUALIFIED_STATE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    errorModelSubclauseEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
    errorModelLibraryEClass.getESuperTypes().add(theAadl2Package.getAnnexLibrary());
    emv2PropertyAssociationEClass.getESuperTypes().add(theAadl2Package.getElement());
    emv2PathEClass.getESuperTypes().add(theAadl2Package.getElement());
    emv2PathElementEClass.getESuperTypes().add(theAadl2Package.getElement());
    errorTypesEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorTypeEClass.getESuperTypes().add(this.getErrorTypes());
    typeSetEClass.getESuperTypes().add(this.getErrorTypes());
    typeTokenEClass.getESuperTypes().add(theAadl2Package.getElement());
    typeTransformationSetEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    typeTransformationEClass.getESuperTypes().add(theAadl2Package.getElement());
    typeMappingSetEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    typeMappingEClass.getESuperTypes().add(theAadl2Package.getElement());
    errorPropagationEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorPropagationEClass.getESuperTypes().add(this.getEventOrPropagation());
    featureorPPReferenceEClass.getESuperTypes().add(theAadl2Package.getElement());
    errorFlowEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorSourceEClass.getESuperTypes().add(this.getErrorFlow());
    errorSinkEClass.getESuperTypes().add(this.getErrorFlow());
    errorPathEClass.getESuperTypes().add(this.getErrorFlow());
    propagationPointEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    propagationPathEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    qualifiedPropagationPointEClass.getESuperTypes().add(theAadl2Package.getElement());
    errorBehaviorStateMachineEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorBehaviorEventEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorBehaviorEventEClass.getESuperTypes().add(this.getEventOrPropagation());
    errorEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
    repairEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
    recoverEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
    errorBehaviorStateEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorBehaviorTransitionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    transitionBranchEClass.getESuperTypes().add(theAadl2Package.getElement());
    branchValueEClass.getESuperTypes().add(theAadl2Package.getElement());
    conditionExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
    ormoreExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
    ormoreExpressionEClass.getESuperTypes().add(this.getConditionExpression());
    orlessExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
    orlessExpressionEClass.getESuperTypes().add(this.getConditionExpression());
    conditionElementEClass.getESuperTypes().add(theAadl2Package.getElement());
    conditionElementEClass.getESuperTypes().add(this.getConditionExpression());
    eventOrPropagationEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    outgoingPropagationConditionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorDetectionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    errorCodeValueEClass.getESuperTypes().add(theAadl2Package.getElement());
    errorStateToModeMappingEClass.getESuperTypes().add(theAadl2Package.getElement());
    compositeStateEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    qualifiedErrorBehaviorStateEClass.getESuperTypes().add(theAadl2Package.getElement());
    subcomponentElementEClass.getESuperTypes().add(theAadl2Package.getElement());
    emv2RootEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    orExpressionEClass.getESuperTypes().add(this.getConditionExpression());
    andExpressionEClass.getESuperTypes().add(this.getConditionExpression());
    allExpressionEClass.getESuperTypes().add(this.getConditionExpression());
    qualifiedErrorEventOrPropagationEClass.getESuperTypes().add(this.getEMV2Path());
    qualifiedErrorPropagationEClass.getESuperTypes().add(this.getEMV2Path());
    sConditionElementEClass.getESuperTypes().add(this.getConditionElement());

    // Initialize classes and features; add operations and parameters
    initEClass(errorModelSubclauseEClass, ErrorModelSubclause.class, "ErrorModelSubclause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorModelSubclause_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_TypeEquivalence(), this.getTypeMappingSet(), null, "typeEquivalence", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_TypeMappingSet(), this.getTypeMappingSet(), null, "typeMappingSet", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_UseBehavior(), this.getErrorBehaviorStateMachine(), null, "useBehavior", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Propagations(), this.getErrorPropagation(), null, "propagations", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Flows(), this.getErrorFlow(), null, "flows", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_UseTransformation(), this.getTypeTransformationSet(), null, "useTransformation", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Transitions(), this.getErrorBehaviorTransition(), null, "transitions", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_OutgoingPropagationConditions(), this.getOutgoingPropagationCondition(), null, "outgoingPropagationConditions", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_ErrorDetections(), this.getErrorDetection(), null, "errorDetections", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_ErrorStateToModeMappings(), this.getErrorStateToModeMapping(), null, "errorStateToModeMappings", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_States(), this.getCompositeState(), null, "states", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_TypeTransformationSet(), this.getTypeTransformationSet(), null, "typeTransformationSet", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_ConnectionErrorSources(), this.getErrorSource(), null, "connectionErrorSources", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Points(), this.getPropagationPoint(), null, "points", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Paths(), this.getPropagationPath(), null, "paths", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelSubclause_Properties(), this.getEMV2PropertyAssociation(), null, "properties", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorModelLibraryEClass, ErrorModelLibrary.class, "ErrorModelLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorModelLibrary_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Extends(), this.getErrorModelLibrary(), null, "extends", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Types(), this.getErrorType(), null, "types", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Typesets(), this.getTypeSet(), null, "typesets", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Properties(), this.getEMV2PropertyAssociation(), null, "properties", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Behaviors(), this.getErrorBehaviorStateMachine(), null, "behaviors", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Mappings(), this.getTypeMappingSet(), null, "mappings", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorModelLibrary_Transformations(), this.getTypeTransformationSet(), null, "transformations", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emv2PropertyAssociationEClass, EMV2PropertyAssociation.class, "EMV2PropertyAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEMV2PropertyAssociation_Property(), theAadl2Package.getProperty(), null, "property", null, 0, 1, EMV2PropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2PropertyAssociation_OwnedValues(), theAadl2Package.getModalPropertyValue(), null, "ownedValues", null, 0, -1, EMV2PropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2PropertyAssociation_Emv2Path(), this.getEMV2Path(), null, "emv2Path", null, 0, -1, EMV2PropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emv2PathEClass, EMV2Path.class, "EMV2Path", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEMV2Path_ContainmentPath(), theAadl2Package.getContainmentPathElement(), null, "containmentPath", null, 0, 1, EMV2Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2Path_Emv2Target(), this.getEMV2PathElement(), null, "emv2Target", null, 0, 1, EMV2Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emv2PathElementEClass, EMV2PathElement.class, "EMV2PathElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEMV2PathElement_Emv2PropagationKind(), theEcorePackage.getEString(), "emv2PropagationKind", null, 0, 1, EMV2PathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2PathElement_ErrorType(), this.getErrorTypes(), null, "errorType", null, 0, 1, EMV2PathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2PathElement_NamedElement(), theAadl2Package.getNamedElement(), null, "namedElement", null, 0, 1, EMV2PathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2PathElement_Path(), this.getEMV2PathElement(), null, "path", null, 0, 1, EMV2PathElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorTypesEClass, ErrorTypes.class, "ErrorTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(errorTypeEClass, ErrorType.class, "ErrorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorType_SuperType(), this.getErrorType(), null, "superType", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorType_AliasedType(), this.getErrorType(), null, "aliasedType", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSetEClass, TypeSet.class, "TypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeSet_TypeTokens(), this.getTypeToken(), null, "typeTokens", null, 0, -1, TypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSet_AliasedType(), this.getTypeSet(), null, "aliasedType", null, 0, 1, TypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeTokenEClass, TypeToken.class, "TypeToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeToken_Type(), this.getErrorTypes(), null, "type", null, 0, -1, TypeToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeToken_NoError(), theEcorePackage.getEBoolean(), "noError", null, 0, 1, TypeToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeTransformationSetEClass, TypeTransformationSet.class, "TypeTransformationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeTransformationSet_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, TypeTransformationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeTransformationSet_Transformation(), this.getTypeTransformation(), null, "transformation", null, 0, -1, TypeTransformationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeTransformationEClass, TypeTransformation.class, "TypeTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeTransformation_Source(), this.getTypeSet(), null, "source", null, 0, 1, TypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeTransformation_AllSources(), theEcorePackage.getEBoolean(), "allSources", null, 0, 1, TypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeTransformation_Contributor(), this.getTypeSet(), null, "contributor", null, 0, 1, TypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeTransformation_Target(), this.getTypeSet(), null, "target", null, 0, 1, TypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeMappingSetEClass, TypeMappingSet.class, "TypeMappingSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeMappingSet_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, TypeMappingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeMappingSet_Mapping(), this.getTypeMapping(), null, "mapping", null, 0, -1, TypeMappingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeMappingEClass, TypeMapping.class, "TypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeMapping_Source(), this.getTypeSet(), null, "source", null, 0, 1, TypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeMapping_Target(), this.getTypeSet(), null, "target", null, 0, 1, TypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPropagationEClass, ErrorPropagation.class, "ErrorPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorPropagation_Kind(), theEcorePackage.getEString(), "kind", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagation_FeatureorPPRef(), this.getFeatureorPPReference(), null, "featureorPPRef", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagation_Not(), theEcorePackage.getEBoolean(), "not", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagation_Direction(), theAadl2Package.getDirectionType(), "direction", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagation_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureorPPReferenceEClass, FeatureorPPReference.class, "FeatureorPPReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureorPPReference_FeatureorPP(), theAadl2Package.getNamedElement(), null, "featureorPP", null, 0, 1, FeatureorPPReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureorPPReference_Next(), this.getFeatureorPPReference(), null, "next", null, 0, 1, FeatureorPPReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorFlowEClass, ErrorFlow.class, "ErrorFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorFlow_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorFlow_Flowcondition(), this.getIfCondition(), null, "flowcondition", null, 0, 1, ErrorFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorSourceEClass, ErrorSource.class, "ErrorSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorSource_SourceModelElement(), theAadl2Package.getNamedElement(), null, "sourceModelElement", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorSource_All(), theEcorePackage.getEBoolean(), "all", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorSource_FailureModeReference(), this.getErrorBehaviorState(), null, "failureModeReference", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorSource_FailureModeType(), this.getTypeSet(), null, "failureModeType", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorSource_FailureModeDescription(), theEcorePackage.getEString(), "failureModeDescription", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorSinkEClass, ErrorSink.class, "ErrorSink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorSink_Incoming(), this.getErrorPropagation(), null, "incoming", null, 0, 1, ErrorSink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorSink_AllIncoming(), theEcorePackage.getEBoolean(), "allIncoming", null, 0, 1, ErrorSink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPathEClass, ErrorPath.class, "ErrorPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorPath_Incoming(), this.getErrorPropagation(), null, "incoming", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPath_AllIncoming(), theEcorePackage.getEBoolean(), "allIncoming", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPath_Outgoing(), this.getErrorPropagation(), null, "outgoing", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPath_AllOutgoing(), theEcorePackage.getEBoolean(), "allOutgoing", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPath_TargetToken(), this.getTypeSet(), null, "targetToken", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPath_TypeMappingSet(), this.getTypeMappingSet(), null, "typeMappingSet", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifConditionEClass, IfCondition.class, "IfCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIfCondition_Description(), theEcorePackage.getEString(), "description", null, 0, 1, IfCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfCondition_ResoluteFunction(), theEcorePackage.getEObject(), null, "resoluteFunction", null, 0, 1, IfCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIfCondition_JavaMethod(), theEcorePackage.getEString(), "javaMethod", null, 0, 1, IfCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propagationPointEClass, PropagationPoint.class, "PropagationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propagationPathEClass, PropagationPath.class, "PropagationPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropagationPath_Source(), this.getQualifiedPropagationPoint(), null, "source", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropagationPath_Target(), this.getQualifiedPropagationPoint(), null, "target", null, 0, 1, PropagationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedPropagationPointEClass, QualifiedPropagationPoint.class, "QualifiedPropagationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQualifiedPropagationPoint_Subcomponent(), this.getSubcomponentElement(), null, "subcomponent", null, 0, 1, QualifiedPropagationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedPropagationPoint_Next(), this.getQualifiedPropagationPoint(), null, "next", null, 0, 1, QualifiedPropagationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedPropagationPoint_PropagationPoint(), theAadl2Package.getNamedElement(), null, "propagationPoint", null, 0, 1, QualifiedPropagationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorStateMachineEClass, ErrorBehaviorStateMachine.class, "ErrorBehaviorStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorBehaviorStateMachine_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_UseTransformation(), this.getTypeTransformationSet(), null, "useTransformation", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_States(), this.getErrorBehaviorState(), null, "states", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Transitions(), this.getErrorBehaviorTransition(), null, "transitions", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Properties(), this.getEMV2PropertyAssociation(), null, "properties", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorEventEClass, ErrorBehaviorEvent.class, "ErrorBehaviorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(errorEventEClass, ErrorEvent.class, "ErrorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorEvent_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorEvent_Eventcondition(), this.getIfCondition(), null, "eventcondition", null, 0, 1, ErrorEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(repairEventEClass, RepairEvent.class, "RepairEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRepairEvent_EventInitiator(), theAadl2Package.getNamedElement(), null, "eventInitiator", null, 0, -1, RepairEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recoverEventEClass, RecoverEvent.class, "RecoverEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecoverEvent_EventInitiator(), theAadl2Package.getNamedElement(), null, "eventInitiator", null, 0, -1, RecoverEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecoverEvent_Condition(), this.getIfCondition(), null, "condition", null, 0, 1, RecoverEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorStateEClass, ErrorBehaviorState.class, "ErrorBehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorBehaviorState_Intial(), theEcorePackage.getEBoolean(), "intial", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorState_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorTransitionEClass, ErrorBehaviorTransition.class, "ErrorBehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorBehaviorTransition_Source(), this.getErrorBehaviorState(), null, "source", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorBehaviorTransition_AllStates(), theEcorePackage.getEBoolean(), "allStates", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_Target(), this.getErrorBehaviorState(), null, "target", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_TargetToken(), this.getTypeSet(), null, "targetToken", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorBehaviorTransition_SteadyState(), theEcorePackage.getEBoolean(), "steadyState", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_DestinationBranches(), this.getTransitionBranch(), null, "destinationBranches", null, 0, -1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionBranchEClass, TransitionBranch.class, "TransitionBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionBranch_Target(), this.getErrorBehaviorState(), null, "target", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionBranch_TargetToken(), this.getTypeSet(), null, "targetToken", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionBranch_SteadyState(), theEcorePackage.getEBoolean(), "steadyState", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionBranch_Value(), this.getBranchValue(), null, "value", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(branchValueEClass, BranchValue.class, "BranchValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBranchValue_Realvalue(), theEcorePackage.getEString(), "realvalue", null, 0, 1, BranchValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBranchValue_Symboliclabel(), theAadl2Package.getProperty(), null, "symboliclabel", null, 0, 1, BranchValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBranchValue_Others(), theEcorePackage.getEBoolean(), "others", null, 0, 1, BranchValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionExpressionEClass, ConditionExpression.class, "ConditionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ormoreExpressionEClass, OrmoreExpression.class, "OrmoreExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrmoreExpression_Count(), theAadl2Package.getInteger(), "count", null, 0, 1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrmoreExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orlessExpressionEClass, OrlessExpression.class, "OrlessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrlessExpression_Count(), theAadl2Package.getInteger(), "count", null, 0, 1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrlessExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionElementEClass, ConditionElement.class, "ConditionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionElement_QualifiedErrorPropagationReference(), this.getEMV2Path(), null, "qualifiedErrorPropagationReference", null, 0, 1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionElement_Constraint(), this.getTypeSet(), null, "constraint", null, 0, 1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventOrPropagationEClass, EventOrPropagation.class, "EventOrPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outgoingPropagationConditionEClass, OutgoingPropagationCondition.class, "OutgoingPropagationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutgoingPropagationCondition_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingPropagationCondition_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutgoingPropagationCondition_AllStates(), theEcorePackage.getEBoolean(), "allStates", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingPropagationCondition_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingPropagationCondition_Outgoing(), this.getErrorPropagation(), null, "outgoing", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutgoingPropagationCondition_AllPropagations(), theEcorePackage.getEBoolean(), "allPropagations", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingPropagationCondition_TypeToken(), this.getTypeSet(), null, "typeToken", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorDetectionEClass, ErrorDetection.class, "ErrorDetection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorDetection_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorDetection_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorDetection_AllStates(), theEcorePackage.getEBoolean(), "allStates", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorDetection_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorDetection_DetectionReportingPort(), theAadl2Package.getTriggerPort(), null, "detectionReportingPort", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorDetection_ErrorCode(), this.getErrorCodeValue(), null, "errorCode", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorCodeValueEClass, ErrorCodeValue.class, "ErrorCodeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorCodeValue_IntValue(), theEcorePackage.getEString(), "intValue", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorCodeValue_Constant(), theAadl2Package.getPropertyConstant(), null, "constant", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorCodeValue_EnumLiteral(), theEcorePackage.getEString(), "enumLiteral", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorStateToModeMappingEClass, ErrorStateToModeMapping.class, "ErrorStateToModeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorStateToModeMapping_ErrorState(), this.getErrorBehaviorState(), null, "errorState", null, 0, 1, ErrorStateToModeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorStateToModeMapping_TypeToken(), this.getTypeSet(), null, "typeToken", null, 0, 1, ErrorStateToModeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorStateToModeMapping_MappedModes(), theAadl2Package.getMode(), null, "mappedModes", null, 0, -1, ErrorStateToModeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compositeStateEClass, CompositeState.class, "CompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompositeState_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCompositeState_Others(), theEcorePackage.getEBoolean(), "others", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompositeState_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompositeState_TypedToken(), this.getTypeSet(), null, "typedToken", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedErrorBehaviorStateEClass, QualifiedErrorBehaviorState.class, "QualifiedErrorBehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQualifiedErrorBehaviorState_Subcomponent(), this.getSubcomponentElement(), null, "subcomponent", null, 0, 1, QualifiedErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedErrorBehaviorState_Next(), this.getQualifiedErrorBehaviorState(), null, "next", null, 0, 1, QualifiedErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedErrorBehaviorState_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, QualifiedErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subcomponentElementEClass, SubcomponentElement.class, "SubcomponentElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubcomponentElement_Subcomponent(), theAadl2Package.getSubcomponent(), null, "subcomponent", null, 0, 1, SubcomponentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emv2RootEClass, EMV2Root.class, "EMV2Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEMV2Root_Library(), this.getErrorModelLibrary(), null, "library", null, 0, 1, EMV2Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMV2Root_Subclauses(), this.getErrorModelSubclause(), null, "subclauses", null, 0, -1, EMV2Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(allExpressionEClass, AllExpression.class, "AllExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAllExpression_Count(), theAadl2Package.getInteger(), "count", null, 0, 1, AllExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAllExpression_Operands(), this.getConditionElement(), null, "operands", null, 0, -1, AllExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedErrorEventOrPropagationEClass, QualifiedErrorEventOrPropagation.class, "QualifiedErrorEventOrPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qualifiedErrorPropagationEClass, QualifiedErrorPropagation.class, "QualifiedErrorPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(sConditionElementEClass, SConditionElement.class, "SConditionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSConditionElement_QualifiedState(), this.getQualifiedErrorBehaviorState(), null, "qualifiedState", null, 0, 1, SConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ErrorModelPackageImpl
