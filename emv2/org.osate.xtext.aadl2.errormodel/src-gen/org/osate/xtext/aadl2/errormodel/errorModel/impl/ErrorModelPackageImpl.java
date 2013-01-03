/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.EBSMUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnections;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TokenTypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTokenTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;

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
  private EClass errorModelGrammarRootEClass = null;

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
  private EClass typeTokenTransformationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass elementTypeTransformationEClass = null;

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
  private EClass tokenTypeMappingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass elementTypeMappingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass errorPropagationsEClass = null;

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
  private EClass errorBehaviorStateOrTypeSetEClass = null;

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
  private EClass observablePropagationConnectionsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass observablePropagationConnectionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass qualifiedObservableErrorPropagationPointEClass = null;

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
  private EClass connectionTransformationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass ebsmUseContextEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass typeUseContextEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass componentErrorBehaviorEClass = null;

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
  private EClass compositeErrorBehaviorEClass = null;

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
  private EClass subcomponentElementEClass = null;

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
  private EClass sOrExpressionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sAndExpressionEClass = null;

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
		ErrorModelPackageImpl theErrorModelPackage = (ErrorModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ErrorModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ErrorModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
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
  public EClass getErrorModelGrammarRoot()
  {
		return errorModelGrammarRootEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelGrammarRoot_Eml()
  {
		return (EReference)errorModelGrammarRootEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelGrammarRoot_Emsc()
  {
		return (EReference)errorModelGrammarRootEClass.getEStructuralFeatures().get(1);
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
  public EReference getErrorModelSubclause_UseBehavior()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_Propagation()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_ComponentBehavior()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_CompositeBehavior()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_ObservablePropagationConnections()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_ConnectionTransformation()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelSubclause_Properties()
  {
		return (EReference)errorModelSubclauseEClass.getEStructuralFeatures().get(6);
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
  public EReference getErrorModelLibrary_Extends()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelLibrary_Types()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelLibrary_Properties()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelLibrary_Behaviors()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelLibrary_Mappings()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorModelLibrary_Transformations()
  {
		return (EReference)errorModelLibraryEClass.getEStructuralFeatures().get(5);
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
	public EReference getErrorType_SubType() {
		return (EReference)errorTypeEClass.getEStructuralFeatures().get(2);
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
  public EReference getTypeSet_ElementType()
  {
		return (EReference)typeSetEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTypeSet_Reference()
  {
		return (EReference)typeSetEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTypeSet_AliasedType()
  {
		return (EReference)typeSetEClass.getEStructuralFeatures().get(2);
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
  public EClass getTypeTokenTransformation()
  {
		return typeTokenTransformationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTypeTokenTransformation_Source()
  {
		return (EReference)typeTokenTransformationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTypeTokenTransformation_Contributor()
  {
		return (EReference)typeTokenTransformationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTypeTokenTransformation_Target()
  {
		return (EReference)typeTokenTransformationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getElementTypeTransformation()
  {
		return elementTypeTransformationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementTypeTransformation_Source()
  {
		return (EReference)elementTypeTransformationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementTypeTransformation_Contributor()
  {
		return (EReference)elementTypeTransformationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementTypeTransformation_Target()
  {
		return (EReference)elementTypeTransformationEClass.getEStructuralFeatures().get(2);
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
  public EClass getTokenTypeMapping()
  {
		return tokenTypeMappingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTokenTypeMapping_Source()
  {
		return (EReference)tokenTypeMappingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTokenTypeMapping_Target()
  {
		return (EReference)tokenTypeMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getElementTypeMapping()
  {
		return elementTypeMappingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementTypeMapping_Source()
  {
		return (EReference)elementTypeMappingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementTypeMapping_Target()
  {
		return (EReference)elementTypeMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getErrorPropagations()
  {
		return errorPropagationsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagations_UseTypes()
  {
		return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagations_UseBehavior()
  {
		return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagations_Propagations()
  {
		return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagations_Flows()
  {
		return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagations_Properties()
  {
		return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(4);
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
  public EAttribute getErrorPropagation_Observable()
  {
		return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getErrorPropagation_Kind()
  {
		return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagation_Feature()
  {
		return (EReference)errorPropagationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getErrorPropagation_Not()
  {
		return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getErrorPropagation_Direction()
  {
		return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPropagation_TypeSet()
  {
		return (EReference)errorPropagationEClass.getEStructuralFeatures().get(5);
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
  public EClass getErrorSource()
  {
		return errorSourceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorSource_Outgoing()
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
  public EClass getErrorBehaviorStateOrTypeSet()
  {
		return errorBehaviorStateOrTypeSetEClass;
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
  public EReference getErrorPath_Outgoing()
  {
		return (EReference)errorPathEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getErrorPath_All()
  {
		return (EAttribute)errorPathEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPath_TargetToken()
  {
		return (EReference)errorPathEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorPath_TypeMappingSet()
  {
		return (EReference)errorPathEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getObservablePropagationConnections()
  {
		return observablePropagationConnectionsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getObservablePropagationConnections_Connection()
  {
		return (EReference)observablePropagationConnectionsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getObservablePropagationConnection()
  {
		return observablePropagationConnectionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getObservablePropagationConnection_Source()
  {
		return (EReference)observablePropagationConnectionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getObservablePropagationConnection_Target()
  {
		return (EReference)observablePropagationConnectionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getQualifiedObservableErrorPropagationPoint()
  {
		return qualifiedObservableErrorPropagationPointEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQualifiedObservableErrorPropagationPoint_Subcomponent()
  {
		return (EReference)qualifiedObservableErrorPropagationPointEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQualifiedObservableErrorPropagationPoint_ObservablePoint()
  {
		return (EReference)qualifiedObservableErrorPropagationPointEClass.getEStructuralFeatures().get(1);
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
  public EReference getErrorBehaviorStateMachine_Extends()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_UseTypes()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_UseTransformation()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_Events()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_States()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_Transitions()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorBehaviorStateMachine_Properties()
  {
		return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(6);
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
  public EAttribute getErrorBehaviorEvent_Condition()
  {
		return (EAttribute)errorBehaviorEventEClass.getEStructuralFeatures().get(0);
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
  public EClass getRepairEvent()
  {
		return repairEventEClass;
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
  public EAttribute getErrorBehaviorTransition_All()
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
  public EAttribute getErrorBehaviorTransition_Mask()
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
  public EAttribute getTransitionBranch_Mask()
  {
		return (EAttribute)transitionBranchEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTransitionBranch_Value()
  {
		return (EAttribute)transitionBranchEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getConnectionTransformation()
  {
		return connectionTransformationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConnectionTransformation_TypeTransformationSet()
  {
		return (EReference)connectionTransformationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getEBSMUseContext()
  {
		return ebsmUseContextEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTypeUseContext()
  {
		return typeUseContextEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getComponentErrorBehavior()
  {
		return componentErrorBehaviorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_UseTypes()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_UseBehavior()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_UseTransformation()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_Events()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_Transitions()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_OutgoingPropagationConditions()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_ErrorDetections()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_ErrorStateToModeMappings()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getComponentErrorBehavior_Properties()
  {
		return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(8);
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
  public EReference getConditionElement_Incoming()
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
  public EReference getConditionElement_Subcomponents()
  {
		return (EReference)conditionElementEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConditionElement_Reference()
  {
		return (EReference)conditionElementEClass.getEStructuralFeatures().get(3);
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
  public EAttribute getOutgoingPropagationCondition_Name()
  {
		return (EAttribute)outgoingPropagationConditionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutgoingPropagationCondition_State()
  {
		return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutgoingPropagationCondition_TypeTokenConstraint()
  {
		return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOutgoingPropagationCondition_All()
  {
		return (EAttribute)outgoingPropagationConditionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutgoingPropagationCondition_Condition()
  {
		return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutgoingPropagationCondition_Outgoing()
  {
		return (EReference)outgoingPropagationConditionEClass.getEStructuralFeatures().get(5);
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
  public EAttribute getOutgoingPropagationCondition_Mask()
  {
		return (EAttribute)outgoingPropagationConditionEClass.getEStructuralFeatures().get(7);
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
  public EAttribute getErrorDetection_All()
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
  public EReference getErrorDetection_InternalDetectionPort()
  {
		return (EReference)errorDetectionEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorDetection_DetectionReportingPort()
  {
		return (EReference)errorDetectionEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getErrorDetection_ErrorCode()
  {
		return (EReference)errorDetectionEClass.getEStructuralFeatures().get(6);
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
  public EReference getErrorStateToModeMapping_MappedModes()
  {
		return (EReference)errorStateToModeMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCompositeErrorBehavior()
  {
		return compositeErrorBehaviorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCompositeErrorBehavior_UseTypes()
  {
		return (EReference)compositeErrorBehaviorEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCompositeErrorBehavior_UseBehavior()
  {
		return (EReference)compositeErrorBehaviorEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCompositeErrorBehavior_States()
  {
		return (EReference)compositeErrorBehaviorEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCompositeErrorBehavior_Properties()
  {
		return (EReference)compositeErrorBehaviorEClass.getEStructuralFeatures().get(3);
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
  public EClass getSOrExpression()
  {
		return sOrExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSOrExpression_Operands()
  {
		return (EReference)sOrExpressionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSAndExpression()
  {
		return sAndExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSAndExpression_Operands()
  {
		return (EReference)sAndExpressionEClass.getEStructuralFeatures().get(0);
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
		errorModelGrammarRootEClass = createEClass(ERROR_MODEL_GRAMMAR_ROOT);
		createEReference(errorModelGrammarRootEClass, ERROR_MODEL_GRAMMAR_ROOT__EML);
		createEReference(errorModelGrammarRootEClass, ERROR_MODEL_GRAMMAR_ROOT__EMSC);

		errorModelSubclauseEClass = createEClass(ERROR_MODEL_SUBCLAUSE);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__PROPAGATION);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__COMPONENT_BEHAVIOR);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__COMPOSITE_BEHAVIOR);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__OBSERVABLE_PROPAGATION_CONNECTIONS);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__CONNECTION_TRANSFORMATION);
		createEReference(errorModelSubclauseEClass, ERROR_MODEL_SUBCLAUSE__PROPERTIES);

		errorModelLibraryEClass = createEClass(ERROR_MODEL_LIBRARY);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__EXTENDS);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__TYPES);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__PROPERTIES);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__BEHAVIORS);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__MAPPINGS);
		createEReference(errorModelLibraryEClass, ERROR_MODEL_LIBRARY__TRANSFORMATIONS);

		errorTypesEClass = createEClass(ERROR_TYPES);

		errorTypeEClass = createEClass(ERROR_TYPE);
		createEReference(errorTypeEClass, ERROR_TYPE__SUPER_TYPE);
		createEReference(errorTypeEClass, ERROR_TYPE__ALIASED_TYPE);
		createEReference(errorTypeEClass, ERROR_TYPE__SUB_TYPE);

		typeSetEClass = createEClass(TYPE_SET);
		createEReference(typeSetEClass, TYPE_SET__ELEMENT_TYPE);
		createEReference(typeSetEClass, TYPE_SET__REFERENCE);
		createEReference(typeSetEClass, TYPE_SET__ALIASED_TYPE);

		typeTokenEClass = createEClass(TYPE_TOKEN);
		createEReference(typeTokenEClass, TYPE_TOKEN__TYPE);

		typeTransformationSetEClass = createEClass(TYPE_TRANSFORMATION_SET);
		createEReference(typeTransformationSetEClass, TYPE_TRANSFORMATION_SET__USE_TYPES);
		createEReference(typeTransformationSetEClass, TYPE_TRANSFORMATION_SET__TRANSFORMATION);

		typeTransformationEClass = createEClass(TYPE_TRANSFORMATION);

		typeTokenTransformationEClass = createEClass(TYPE_TOKEN_TRANSFORMATION);
		createEReference(typeTokenTransformationEClass, TYPE_TOKEN_TRANSFORMATION__SOURCE);
		createEReference(typeTokenTransformationEClass, TYPE_TOKEN_TRANSFORMATION__CONTRIBUTOR);
		createEReference(typeTokenTransformationEClass, TYPE_TOKEN_TRANSFORMATION__TARGET);

		elementTypeTransformationEClass = createEClass(ELEMENT_TYPE_TRANSFORMATION);
		createEReference(elementTypeTransformationEClass, ELEMENT_TYPE_TRANSFORMATION__SOURCE);
		createEReference(elementTypeTransformationEClass, ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR);
		createEReference(elementTypeTransformationEClass, ELEMENT_TYPE_TRANSFORMATION__TARGET);

		typeMappingSetEClass = createEClass(TYPE_MAPPING_SET);
		createEReference(typeMappingSetEClass, TYPE_MAPPING_SET__USE_TYPES);
		createEReference(typeMappingSetEClass, TYPE_MAPPING_SET__MAPPING);

		typeMappingEClass = createEClass(TYPE_MAPPING);

		tokenTypeMappingEClass = createEClass(TOKEN_TYPE_MAPPING);
		createEReference(tokenTypeMappingEClass, TOKEN_TYPE_MAPPING__SOURCE);
		createEReference(tokenTypeMappingEClass, TOKEN_TYPE_MAPPING__TARGET);

		elementTypeMappingEClass = createEClass(ELEMENT_TYPE_MAPPING);
		createEReference(elementTypeMappingEClass, ELEMENT_TYPE_MAPPING__SOURCE);
		createEReference(elementTypeMappingEClass, ELEMENT_TYPE_MAPPING__TARGET);

		errorPropagationsEClass = createEClass(ERROR_PROPAGATIONS);
		createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__USE_TYPES);
		createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__USE_BEHAVIOR);
		createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__PROPAGATIONS);
		createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__FLOWS);
		createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__PROPERTIES);

		errorPropagationEClass = createEClass(ERROR_PROPAGATION);
		createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__OBSERVABLE);
		createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__KIND);
		createEReference(errorPropagationEClass, ERROR_PROPAGATION__FEATURE);
		createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__NOT);
		createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__DIRECTION);
		createEReference(errorPropagationEClass, ERROR_PROPAGATION__TYPE_SET);

		errorFlowEClass = createEClass(ERROR_FLOW);
		createEReference(errorFlowEClass, ERROR_FLOW__TYPE_TOKEN_CONSTRAINT);

		errorSourceEClass = createEClass(ERROR_SOURCE);
		createEReference(errorSourceEClass, ERROR_SOURCE__OUTGOING);
		createEAttribute(errorSourceEClass, ERROR_SOURCE__ALL);
		createEReference(errorSourceEClass, ERROR_SOURCE__FAILURE_MODE_REFERENCE);
		createEReference(errorSourceEClass, ERROR_SOURCE__FAILURE_MODE_TYPE);

		errorBehaviorStateOrTypeSetEClass = createEClass(ERROR_BEHAVIOR_STATE_OR_TYPE_SET);

		errorSinkEClass = createEClass(ERROR_SINK);
		createEReference(errorSinkEClass, ERROR_SINK__INCOMING);

		errorPathEClass = createEClass(ERROR_PATH);
		createEReference(errorPathEClass, ERROR_PATH__INCOMING);
		createEReference(errorPathEClass, ERROR_PATH__OUTGOING);
		createEAttribute(errorPathEClass, ERROR_PATH__ALL);
		createEReference(errorPathEClass, ERROR_PATH__TARGET_TOKEN);
		createEReference(errorPathEClass, ERROR_PATH__TYPE_MAPPING_SET);

		observablePropagationConnectionsEClass = createEClass(OBSERVABLE_PROPAGATION_CONNECTIONS);
		createEReference(observablePropagationConnectionsEClass, OBSERVABLE_PROPAGATION_CONNECTIONS__CONNECTION);

		observablePropagationConnectionEClass = createEClass(OBSERVABLE_PROPAGATION_CONNECTION);
		createEReference(observablePropagationConnectionEClass, OBSERVABLE_PROPAGATION_CONNECTION__SOURCE);
		createEReference(observablePropagationConnectionEClass, OBSERVABLE_PROPAGATION_CONNECTION__TARGET);

		qualifiedObservableErrorPropagationPointEClass = createEClass(QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT);
		createEReference(qualifiedObservableErrorPropagationPointEClass, QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT);
		createEReference(qualifiedObservableErrorPropagationPointEClass, QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT);

		errorBehaviorStateMachineEClass = createEClass(ERROR_BEHAVIOR_STATE_MACHINE);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__EVENTS);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__STATES);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS);
		createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES);

		errorBehaviorEventEClass = createEClass(ERROR_BEHAVIOR_EVENT);
		createEAttribute(errorBehaviorEventEClass, ERROR_BEHAVIOR_EVENT__CONDITION);

		errorEventEClass = createEClass(ERROR_EVENT);
		createEReference(errorEventEClass, ERROR_EVENT__TYPE_SET);

		repairEventEClass = createEClass(REPAIR_EVENT);

		recoverEventEClass = createEClass(RECOVER_EVENT);

		errorBehaviorStateEClass = createEClass(ERROR_BEHAVIOR_STATE);
		createEAttribute(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__INTIAL);
		createEReference(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__TYPE_SET);

		errorBehaviorTransitionEClass = createEClass(ERROR_BEHAVIOR_TRANSITION);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__SOURCE);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT);
		createEAttribute(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__ALL);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__CONDITION);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TARGET);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN);
		createEAttribute(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__MASK);
		createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES);

		transitionBranchEClass = createEClass(TRANSITION_BRANCH);
		createEReference(transitionBranchEClass, TRANSITION_BRANCH__TARGET);
		createEReference(transitionBranchEClass, TRANSITION_BRANCH__TARGET_TOKEN);
		createEAttribute(transitionBranchEClass, TRANSITION_BRANCH__MASK);
		createEAttribute(transitionBranchEClass, TRANSITION_BRANCH__VALUE);

		connectionTransformationEClass = createEClass(CONNECTION_TRANSFORMATION);
		createEReference(connectionTransformationEClass, CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET);

		ebsmUseContextEClass = createEClass(EBSM_USE_CONTEXT);

		typeUseContextEClass = createEClass(TYPE_USE_CONTEXT);

		componentErrorBehaviorEClass = createEClass(COMPONENT_ERROR_BEHAVIOR);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__USE_TYPES);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__USE_BEHAVIOR);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__USE_TRANSFORMATION);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__EVENTS);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__TRANSITIONS);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__OUTGOING_PROPAGATION_CONDITIONS);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__ERROR_DETECTIONS);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__ERROR_STATE_TO_MODE_MAPPINGS);
		createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__PROPERTIES);

		conditionExpressionEClass = createEClass(CONDITION_EXPRESSION);

		ormoreExpressionEClass = createEClass(ORMORE_EXPRESSION);
		createEAttribute(ormoreExpressionEClass, ORMORE_EXPRESSION__COUNT);
		createEReference(ormoreExpressionEClass, ORMORE_EXPRESSION__OPERANDS);

		orlessExpressionEClass = createEClass(ORLESS_EXPRESSION);
		createEAttribute(orlessExpressionEClass, ORLESS_EXPRESSION__COUNT);
		createEReference(orlessExpressionEClass, ORLESS_EXPRESSION__OPERANDS);

		conditionElementEClass = createEClass(CONDITION_ELEMENT);
		createEReference(conditionElementEClass, CONDITION_ELEMENT__INCOMING);
		createEReference(conditionElementEClass, CONDITION_ELEMENT__CONSTRAINT);
		createEReference(conditionElementEClass, CONDITION_ELEMENT__SUBCOMPONENTS);
		createEReference(conditionElementEClass, CONDITION_ELEMENT__REFERENCE);

		eventOrPropagationEClass = createEClass(EVENT_OR_PROPAGATION);

		outgoingPropagationConditionEClass = createEClass(OUTGOING_PROPAGATION_CONDITION);
		createEAttribute(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__NAME);
		createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__STATE);
		createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT);
		createEAttribute(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__ALL);
		createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__CONDITION);
		createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__OUTGOING);
		createEReference(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN);
		createEAttribute(outgoingPropagationConditionEClass, OUTGOING_PROPAGATION_CONDITION__MASK);

		errorDetectionEClass = createEClass(ERROR_DETECTION);
		createEReference(errorDetectionEClass, ERROR_DETECTION__STATE);
		createEReference(errorDetectionEClass, ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT);
		createEAttribute(errorDetectionEClass, ERROR_DETECTION__ALL);
		createEReference(errorDetectionEClass, ERROR_DETECTION__CONDITION);
		createEReference(errorDetectionEClass, ERROR_DETECTION__INTERNAL_DETECTION_PORT);
		createEReference(errorDetectionEClass, ERROR_DETECTION__DETECTION_REPORTING_PORT);
		createEReference(errorDetectionEClass, ERROR_DETECTION__ERROR_CODE);

		errorCodeValueEClass = createEClass(ERROR_CODE_VALUE);
		createEAttribute(errorCodeValueEClass, ERROR_CODE_VALUE__INT_VALUE);
		createEReference(errorCodeValueEClass, ERROR_CODE_VALUE__CONSTANT);
		createEAttribute(errorCodeValueEClass, ERROR_CODE_VALUE__ENUM_LITERAL);

		errorStateToModeMappingEClass = createEClass(ERROR_STATE_TO_MODE_MAPPING);
		createEReference(errorStateToModeMappingEClass, ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE);
		createEReference(errorStateToModeMappingEClass, ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES);

		compositeErrorBehaviorEClass = createEClass(COMPOSITE_ERROR_BEHAVIOR);
		createEReference(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__USE_TYPES);
		createEReference(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__USE_BEHAVIOR);
		createEReference(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__STATES);
		createEReference(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__PROPERTIES);

		compositeStateEClass = createEClass(COMPOSITE_STATE);
		createEReference(compositeStateEClass, COMPOSITE_STATE__CONDITION);
		createEAttribute(compositeStateEClass, COMPOSITE_STATE__OTHERS);
		createEReference(compositeStateEClass, COMPOSITE_STATE__STATE);
		createEReference(compositeStateEClass, COMPOSITE_STATE__TYPED_TOKEN);

		subcomponentElementEClass = createEClass(SUBCOMPONENT_ELEMENT);
		createEReference(subcomponentElementEClass, SUBCOMPONENT_ELEMENT__SUBCOMPONENT);

		orExpressionEClass = createEClass(OR_EXPRESSION);
		createEReference(orExpressionEClass, OR_EXPRESSION__OPERANDS);

		andExpressionEClass = createEClass(AND_EXPRESSION);
		createEReference(andExpressionEClass, AND_EXPRESSION__OPERANDS);

		sOrExpressionEClass = createEClass(SOR_EXPRESSION);
		createEReference(sOrExpressionEClass, SOR_EXPRESSION__OPERANDS);

		sAndExpressionEClass = createEClass(SAND_EXPRESSION);
		createEReference(sAndExpressionEClass, SAND_EXPRESSION__OPERANDS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		errorModelSubclauseEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
		errorModelLibraryEClass.getESuperTypes().add(theAadl2Package.getAnnexLibrary());
		errorTypesEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorTypeEClass.getESuperTypes().add(this.getErrorTypes());
		typeSetEClass.getESuperTypes().add(this.getErrorTypes());
		typeSetEClass.getESuperTypes().add(this.getErrorBehaviorStateOrTypeSet());
		typeTokenEClass.getESuperTypes().add(theAadl2Package.getElement());
		typeTransformationSetEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		typeTransformationSetEClass.getESuperTypes().add(this.getTypeUseContext());
		typeTransformationEClass.getESuperTypes().add(theAadl2Package.getElement());
		typeTokenTransformationEClass.getESuperTypes().add(this.getTypeTransformation());
		elementTypeTransformationEClass.getESuperTypes().add(this.getTypeTransformation());
		typeMappingSetEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		typeMappingSetEClass.getESuperTypes().add(this.getTypeUseContext());
		typeMappingEClass.getESuperTypes().add(theAadl2Package.getElement());
		tokenTypeMappingEClass.getESuperTypes().add(this.getTypeMapping());
		elementTypeMappingEClass.getESuperTypes().add(this.getTypeMapping());
		errorPropagationsEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorPropagationsEClass.getESuperTypes().add(this.getEBSMUseContext());
		errorPropagationEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorPropagationEClass.getESuperTypes().add(this.getEventOrPropagation());
		errorFlowEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorSourceEClass.getESuperTypes().add(this.getErrorFlow());
		errorSinkEClass.getESuperTypes().add(this.getErrorFlow());
		errorPathEClass.getESuperTypes().add(this.getErrorFlow());
		observablePropagationConnectionsEClass.getESuperTypes().add(theAadl2Package.getElement());
		observablePropagationConnectionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		qualifiedObservableErrorPropagationPointEClass.getESuperTypes().add(theAadl2Package.getElement());
		errorBehaviorStateMachineEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorBehaviorStateMachineEClass.getESuperTypes().add(this.getTypeUseContext());
		errorBehaviorEventEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorBehaviorEventEClass.getESuperTypes().add(this.getEventOrPropagation());
		errorEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
		repairEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
		recoverEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
		errorBehaviorStateEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		errorBehaviorStateEClass.getESuperTypes().add(this.getErrorBehaviorStateOrTypeSet());
		errorBehaviorTransitionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		transitionBranchEClass.getESuperTypes().add(theAadl2Package.getElement());
		connectionTransformationEClass.getESuperTypes().add(theAadl2Package.getElement());
		ebsmUseContextEClass.getESuperTypes().add(this.getTypeUseContext());
		componentErrorBehaviorEClass.getESuperTypes().add(theAadl2Package.getElement());
		componentErrorBehaviorEClass.getESuperTypes().add(this.getEBSMUseContext());
		conditionExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
		ormoreExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
		ormoreExpressionEClass.getESuperTypes().add(this.getConditionExpression());
		orlessExpressionEClass.getESuperTypes().add(theAadl2Package.getElement());
		orlessExpressionEClass.getESuperTypes().add(this.getConditionExpression());
		conditionElementEClass.getESuperTypes().add(theAadl2Package.getElement());
		conditionElementEClass.getESuperTypes().add(this.getConditionExpression());
		outgoingPropagationConditionEClass.getESuperTypes().add(theAadl2Package.getElement());
		errorDetectionEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
		compositeErrorBehaviorEClass.getESuperTypes().add(theAadl2Package.getElement());
		compositeErrorBehaviorEClass.getESuperTypes().add(this.getEBSMUseContext());
		compositeStateEClass.getESuperTypes().add(theAadl2Package.getElement());
		orExpressionEClass.getESuperTypes().add(this.getConditionExpression());
		andExpressionEClass.getESuperTypes().add(this.getConditionExpression());
		sOrExpressionEClass.getESuperTypes().add(this.getConditionExpression());
		sAndExpressionEClass.getESuperTypes().add(this.getConditionExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(errorModelGrammarRootEClass, ErrorModelGrammarRoot.class, "ErrorModelGrammarRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorModelGrammarRoot_Eml(), this.getErrorModelLibrary(), null, "eml", null, 0, 1, ErrorModelGrammarRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelGrammarRoot_Emsc(), this.getErrorModelSubclause(), null, "emsc", null, 0, 1, ErrorModelGrammarRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorModelSubclauseEClass, ErrorModelSubclause.class, "ErrorModelSubclause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorModelSubclause_UseBehavior(), this.getErrorBehaviorStateMachine(), null, "useBehavior", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_Propagation(), this.getErrorPropagations(), null, "propagation", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_ComponentBehavior(), this.getComponentErrorBehavior(), null, "componentBehavior", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_CompositeBehavior(), this.getCompositeErrorBehavior(), null, "compositeBehavior", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_ObservablePropagationConnections(), this.getObservablePropagationConnections(), null, "observablePropagationConnections", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_ConnectionTransformation(), this.getConnectionTransformation(), null, "connectionTransformation", null, 0, 1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelSubclause_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, ErrorModelSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorModelLibraryEClass, ErrorModelLibrary.class, "ErrorModelLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorModelLibrary_Extends(), this.getErrorModelLibrary(), null, "extends", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelLibrary_Types(), this.getErrorTypes(), null, "types", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelLibrary_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelLibrary_Behaviors(), this.getErrorBehaviorStateMachine(), null, "behaviors", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelLibrary_Mappings(), this.getTypeMappingSet(), null, "mappings", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorModelLibrary_Transformations(), this.getTypeTransformationSet(), null, "transformations", null, 0, -1, ErrorModelLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorTypesEClass, ErrorTypes.class, "ErrorTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorTypeEClass, ErrorType.class, "ErrorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorType_SuperType(), this.getErrorType(), this.getErrorType_SubType(), "superType", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorType_AliasedType(), this.getErrorType(), null, "aliasedType", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorType_SubType(), this.getErrorType(), this.getErrorType_SuperType(), "subType", null, 0, -1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSetEClass, TypeSet.class, "TypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeSet_ElementType(), this.getTypeToken(), null, "elementType", null, 0, -1, TypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeSet_Reference(), this.getTypeSet(), null, "reference", null, 0, 1, TypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeSet_AliasedType(), this.getTypeSet(), null, "aliasedType", null, 0, 1, TypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTokenEClass, TypeToken.class, "TypeToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeToken_Type(), this.getErrorType(), null, "type", null, 0, -1, TypeToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTransformationSetEClass, TypeTransformationSet.class, "TypeTransformationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeTransformationSet_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, TypeTransformationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeTransformationSet_Transformation(), this.getTypeTransformation(), null, "transformation", null, 0, -1, TypeTransformationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTransformationEClass, TypeTransformation.class, "TypeTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeTokenTransformationEClass, TypeTokenTransformation.class, "TypeTokenTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeTokenTransformation_Source(), this.getTypeSet(), null, "source", null, 0, 1, TypeTokenTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeTokenTransformation_Contributor(), this.getTypeSet(), null, "contributor", null, 0, 1, TypeTokenTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeTokenTransformation_Target(), this.getTypeToken(), null, "target", null, 0, 1, TypeTokenTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeTransformationEClass, ElementTypeTransformation.class, "ElementTypeTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypeTransformation_Source(), this.getErrorType(), null, "source", null, 0, 1, ElementTypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeTransformation_Contributor(), this.getErrorType(), null, "contributor", null, 0, 1, ElementTypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeTransformation_Target(), this.getErrorType(), null, "target", null, 0, 1, ElementTypeTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeMappingSetEClass, TypeMappingSet.class, "TypeMappingSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeMappingSet_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, TypeMappingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeMappingSet_Mapping(), this.getTypeMapping(), null, "mapping", null, 0, -1, TypeMappingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeMappingEClass, TypeMapping.class, "TypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tokenTypeMappingEClass, TokenTypeMapping.class, "TokenTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTokenTypeMapping_Source(), this.getTypeSet(), null, "source", null, 0, 1, TokenTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTokenTypeMapping_Target(), this.getTypeToken(), null, "target", null, 0, 1, TokenTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeMappingEClass, ElementTypeMapping.class, "ElementTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypeMapping_Source(), this.getErrorType(), null, "source", null, 0, 1, ElementTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeMapping_Target(), this.getErrorType(), null, "target", null, 0, 1, ElementTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPropagationsEClass, ErrorPropagations.class, "ErrorPropagations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorPropagations_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagations_UseBehavior(), this.getErrorBehaviorStateMachine(), null, "useBehavior", null, 0, 1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagations_Propagations(), this.getErrorPropagation(), null, "propagations", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagations_Flows(), this.getErrorFlow(), null, "flows", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagations_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPropagationEClass, ErrorPropagation.class, "ErrorPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorPropagation_Observable(), ecorePackage.getEBoolean(), "observable", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPropagation_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagation_Feature(), theAadl2Package.getFeature(), null, "feature", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPropagation_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPropagation_Direction(), theAadl2Package.getDirectionType(), "direction", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagation_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorFlowEClass, ErrorFlow.class, "ErrorFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorFlow_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorSourceEClass, ErrorSource.class, "ErrorSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorSource_Outgoing(), this.getErrorPropagation(), null, "outgoing", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorSource_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSource_FailureModeReference(), this.getErrorBehaviorStateOrTypeSet(), null, "failureModeReference", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSource_FailureModeType(), this.getTypeSet(), null, "failureModeType", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorBehaviorStateOrTypeSetEClass, ErrorBehaviorStateOrTypeSet.class, "ErrorBehaviorStateOrTypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorSinkEClass, ErrorSink.class, "ErrorSink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorSink_Incoming(), this.getErrorPropagation(), null, "incoming", null, 0, 1, ErrorSink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPathEClass, ErrorPath.class, "ErrorPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorPath_Incoming(), this.getErrorPropagation(), null, "incoming", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPath_Outgoing(), this.getErrorPropagation(), null, "outgoing", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPath_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPath_TargetToken(), this.getTypeToken(), null, "targetToken", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPath_TypeMappingSet(), this.getTypeMappingSet(), null, "typeMappingSet", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observablePropagationConnectionsEClass, ObservablePropagationConnections.class, "ObservablePropagationConnections", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservablePropagationConnections_Connection(), this.getObservablePropagationConnection(), null, "connection", null, 0, -1, ObservablePropagationConnections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observablePropagationConnectionEClass, ObservablePropagationConnection.class, "ObservablePropagationConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservablePropagationConnection_Source(), this.getQualifiedObservableErrorPropagationPoint(), null, "source", null, 0, 1, ObservablePropagationConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObservablePropagationConnection_Target(), this.getQualifiedObservableErrorPropagationPoint(), null, "target", null, 0, 1, ObservablePropagationConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedObservableErrorPropagationPointEClass, QualifiedObservableErrorPropagationPoint.class, "QualifiedObservableErrorPropagationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedObservableErrorPropagationPoint_Subcomponent(), theAadl2Package.getSubcomponent(), null, "subcomponent", null, 0, 1, QualifiedObservableErrorPropagationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedObservableErrorPropagationPoint_ObservablePoint(), this.getErrorPropagation(), null, "observablePoint", null, 0, 1, QualifiedObservableErrorPropagationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorBehaviorStateMachineEClass, ErrorBehaviorStateMachine.class, "ErrorBehaviorStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorBehaviorStateMachine_Extends(), this.getErrorBehaviorStateMachine(), null, "extends", null, 0, 1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_UseTransformation(), this.getTypeTransformationSet(), null, "useTransformation", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_States(), this.getErrorBehaviorState(), null, "states", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_Transitions(), this.getErrorBehaviorTransition(), null, "transitions", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorStateMachine_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorBehaviorEventEClass, ErrorBehaviorEvent.class, "ErrorBehaviorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorBehaviorEvent_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, ErrorBehaviorEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorEventEClass, ErrorEvent.class, "ErrorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorEvent_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repairEventEClass, RepairEvent.class, "RepairEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recoverEventEClass, RecoverEvent.class, "RecoverEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorBehaviorStateEClass, ErrorBehaviorState.class, "ErrorBehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorBehaviorState_Intial(), ecorePackage.getEBoolean(), "intial", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorState_TypeSet(), this.getTypeSet(), null, "typeSet", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorBehaviorTransitionEClass, ErrorBehaviorTransition.class, "ErrorBehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorBehaviorTransition_Source(), this.getErrorBehaviorState(), null, "source", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorTransition_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorBehaviorTransition_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorTransition_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorTransition_Target(), this.getErrorBehaviorState(), null, "target", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorTransition_TargetToken(), this.getTypeToken(), null, "targetToken", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorBehaviorTransition_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorBehaviorTransition_DestinationBranches(), this.getTransitionBranch(), null, "destinationBranches", null, 0, -1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionBranchEClass, TransitionBranch.class, "TransitionBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionBranch_Target(), this.getErrorBehaviorState(), null, "target", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionBranch_TargetToken(), this.getTypeToken(), null, "targetToken", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionBranch_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionBranch_Value(), ecorePackage.getEString(), "value", null, 0, 1, TransitionBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionTransformationEClass, ConnectionTransformation.class, "ConnectionTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionTransformation_TypeTransformationSet(), this.getTypeTransformationSet(), null, "typeTransformationSet", null, 0, 1, ConnectionTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ebsmUseContextEClass, EBSMUseContext.class, "EBSMUseContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeUseContextEClass, TypeUseContext.class, "TypeUseContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentErrorBehaviorEClass, ComponentErrorBehavior.class, "ComponentErrorBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentErrorBehavior_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_UseBehavior(), this.getErrorBehaviorStateMachine(), null, "useBehavior", null, 0, 1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_UseTransformation(), this.getTypeTransformationSet(), null, "useTransformation", null, 0, 1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_Transitions(), this.getErrorBehaviorTransition(), null, "transitions", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_OutgoingPropagationConditions(), this.getOutgoingPropagationCondition(), null, "outgoingPropagationConditions", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_ErrorDetections(), this.getErrorDetection(), null, "errorDetections", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_ErrorStateToModeMappings(), this.getErrorStateToModeMapping(), null, "errorStateToModeMappings", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentErrorBehavior_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionExpressionEClass, ConditionExpression.class, "ConditionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ormoreExpressionEClass, OrmoreExpression.class, "OrmoreExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrmoreExpression_Count(), theAadl2Package.getInteger(), "count", null, 0, 1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrmoreExpression_Operands(), this.getConditionElement(), null, "operands", null, 0, -1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orlessExpressionEClass, OrlessExpression.class, "OrlessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrlessExpression_Count(), theAadl2Package.getInteger(), "count", null, 0, 1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrlessExpression_Operands(), this.getConditionElement(), null, "operands", null, 0, -1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionElementEClass, ConditionElement.class, "ConditionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionElement_Incoming(), this.getEventOrPropagation(), null, "incoming", null, 0, 1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionElement_Constraint(), this.getTypeSet(), null, "constraint", null, 0, 1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionElement_Subcomponents(), this.getSubcomponentElement(), null, "subcomponents", null, 0, -1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionElement_Reference(), this.getErrorBehaviorState(), null, "reference", null, 0, 1, ConditionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventOrPropagationEClass, EventOrPropagation.class, "EventOrPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outgoingPropagationConditionEClass, OutgoingPropagationCondition.class, "OutgoingPropagationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutgoingPropagationCondition_Name(), ecorePackage.getEString(), "name", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationCondition_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationCondition_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutgoingPropagationCondition_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationCondition_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationCondition_Outgoing(), this.getErrorPropagation(), null, "outgoing", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationCondition_TypeToken(), this.getTypeToken(), null, "typeToken", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutgoingPropagationCondition_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, OutgoingPropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorDetectionEClass, ErrorDetection.class, "ErrorDetection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorDetection_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetection_TypeTokenConstraint(), this.getTypeSet(), null, "typeTokenConstraint", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorDetection_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetection_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetection_InternalDetectionPort(), theAadl2Package.getInternalEvent(), null, "internalDetectionPort", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetection_DetectionReportingPort(), theAadl2Package.getPort(), null, "detectionReportingPort", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetection_ErrorCode(), this.getErrorCodeValue(), null, "errorCode", null, 0, 1, ErrorDetection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorCodeValueEClass, ErrorCodeValue.class, "ErrorCodeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorCodeValue_IntValue(), ecorePackage.getEString(), "intValue", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorCodeValue_Constant(), theAadl2Package.getPropertyConstant(), null, "constant", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorCodeValue_EnumLiteral(), ecorePackage.getEString(), "enumLiteral", null, 0, 1, ErrorCodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorStateToModeMappingEClass, ErrorStateToModeMapping.class, "ErrorStateToModeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorStateToModeMapping_ErrorState(), this.getErrorBehaviorState(), null, "errorState", null, 0, 1, ErrorStateToModeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorStateToModeMapping_MappedModes(), theAadl2Package.getMode(), null, "mappedModes", null, 0, -1, ErrorStateToModeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeErrorBehaviorEClass, CompositeErrorBehavior.class, "CompositeErrorBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeErrorBehavior_UseTypes(), this.getErrorModelLibrary(), null, "useTypes", null, 0, -1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeErrorBehavior_UseBehavior(), this.getErrorBehaviorStateMachine(), null, "useBehavior", null, 0, 1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeErrorBehavior_States(), this.getCompositeState(), null, "states", null, 0, -1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeErrorBehavior_Properties(), theAadl2Package.getPropertyAssociation(), null, "properties", null, 0, -1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeStateEClass, CompositeState.class, "CompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeState_Condition(), this.getConditionExpression(), null, "condition", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeState_Others(), ecorePackage.getEBoolean(), "others", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeState_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeState_TypedToken(), this.getTypeToken(), null, "typedToken", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subcomponentElementEClass, SubcomponentElement.class, "SubcomponentElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubcomponentElement_Subcomponent(), theAadl2Package.getSubcomponent(), null, "subcomponent", null, 0, 1, SubcomponentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sOrExpressionEClass, SOrExpression.class, "SOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOrExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, SOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sAndExpressionEClass, SAndExpression.class, "SAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAndExpression_Operands(), this.getConditionExpression(), null, "operands", null, 0, -1, SAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ErrorModelPackageImpl
