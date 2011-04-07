/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.FeatureType;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Literal;
import fr.tpt.aadl.annex.behavior.aadlba.LockAction;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.Otherwise;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.PortCountValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortSendAction;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
import fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
import fr.tpt.aadl.annex.behavior.aadlba.UnlockAction;
import fr.tpt.aadl.annex.behavior.aadlba.Value;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaPackageImpl extends EPackageImpl implements AadlBaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorActionSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorAnnexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorBooleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorStringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionRelativeTimeoutConditionAndCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass condStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataComponentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchConjunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerConditionStopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTriggerLogicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forOrForAllStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorIntegerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lockActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numeralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherwiseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portCountValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portDequeueActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portDequeueValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portFreezeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portFreshValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portSendActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorPropertyConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorRealLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedDataActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subprogramCallActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeoutCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueComponentClassifierReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlockActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileOrDoUntilStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum behaviorFeatureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryAddingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryNumericOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataRepresentationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplyingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryAddingOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryBooleanOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryNumericOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType realEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

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
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AadlBaPackageImpl() {
		super(eNS_URI, AadlBaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AadlBaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AadlBaPackage init() {
		if (isInited) return (AadlBaPackage)EPackage.Registry.INSTANCE.getEPackage(AadlBaPackage.eNS_URI);

		// Obtain or create and register package
		AadlBaPackageImpl theAadlBaPackage = (AadlBaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AadlBaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AadlBaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		theAadlBaPackage.createPackageContents();

		// Initialize created meta-data
		theAadlBaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAadlBaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AadlBaPackage.eNS_URI, theAadlBaPackage);
		return theAadlBaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignmentAction() {
		return assignmentActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentAction_TargetOwned() {
		return (EReference)assignmentActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentAction_ValueExpressionOwned() {
		return (EReference)assignmentActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentAction_Any() {
		return (EAttribute)assignmentActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicAction() {
		return basicActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorAction() {
		return behaviorActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionBlock() {
		return behaviorActionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionBlock_BehaviorActionsOwned() {
		return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionBlock_BehaviorTimeOwned() {
		return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionCollection() {
		return behaviorActionCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorActionCollection_BehaviorActions() {
		return (EReference)behaviorActionCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActions() {
		return behaviorActionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionSequence() {
		return behaviorActionSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorActionSet() {
		return behaviorActionSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorAnnex() {
		return behaviorAnnexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorVariables() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorStates() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorAnnex_BehaviorTransitions() {
		return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorCondition() {
		return behaviorConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorElement() {
		return behaviorElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorElement_BaRef() {
		return (EReference)behaviorElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorElement_AadlRef() {
		return (EReference)behaviorElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorNamedElement() {
		return behaviorNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorNamedElement_Name() {
		return (EAttribute)behaviorNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorNamedElement_QualifiedName() {
		return (EAttribute)behaviorNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorNamedElement_NamespaceSeparator() {
		return (EAttribute)behaviorNamedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorNamedElement_Namespace() {
		return (EAttribute)behaviorNamedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorState() {
		return behaviorStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorState_Identifiers() {
		return (EReference)behaviorStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Initial() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Complete() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehaviorState_Final() {
		return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTime() {
		return behaviorTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTime_IntegerValueOwned() {
		return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTime_UnitIdentifier() {
		return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorTransition() {
		return behaviorTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_TransitionIdentifier() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_SourceStateIdentifiers() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorConditionOwned() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_DestinationStateIdentifier() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorActionBlockOwned() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorTransition_BehaviorTransitionPriority() {
		return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorVariable() {
		return behaviorVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorVariable_LocalVariableDeclarators() {
		return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorVariable_DataUniqueComponentClassifierReference() {
		return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorBooleanLiteral() {
		return behaviorBooleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorStringLiteral() {
		return behaviorStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationAction() {
		return communicationActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionRelativeTimeoutConditionAndCatch() {
		return completionRelativeTimeoutConditionAndCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondStatement() {
		return condStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataComponentReference() {
		return dataComponentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataComponentReference_Names() {
		return (EReference)dataComponentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclarator() {
		return declaratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarator_IdentifierOwned() {
		return (EReference)declaratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarator_ArraySizes() {
		return (EReference)declaratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchCondition() {
		return dispatchConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchCondition_DispatchTriggerConditionOwned() {
		return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchCondition_FrozenPorts() {
		return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchConjunction() {
		return dispatchConjunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchConjunction_DispatchTriggers() {
		return (EReference)dispatchConjunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerCondition() {
		return dispatchTriggerConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerConditionStop() {
		return dispatchTriggerConditionStopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatchTriggerLogicalExpression() {
		return dispatchTriggerLogicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatchTriggerLogicalExpression_DispatchConjunctions() {
		return (EReference)dispatchTriggerLogicalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementValues() {
		return elementValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecuteCondition() {
		return executeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFactor() {
		return factorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFactor_ValueOwned() {
		return (EReference)factorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFactor_ValueSdOwned() {
		return (EReference)factorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_BinaryNumericOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_UnaryNumericOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactor_UnaryBooleanOperatorOwned() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForOrForAllStatement() {
		return forOrForAllStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_ElementIdentifier() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_DataUniqueComponentClassifierReference() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForOrForAllStatement_ElementValuesOwned() {
		return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForOrForAllStatement_ForAll() {
		return (EAttribute)forOrForAllStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifier_Id() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfStatement_HasElse() {
		return (EAttribute)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_LogicalValueExpressions() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_BehaviorActionsOwned() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorIntegerLiteral() {
		return behaviorIntegerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerRange() {
		return integerRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerRange_LowerIntegerValue() {
		return (EReference)integerRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerRange_UpperIntegerValue() {
		return (EReference)integerRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValue() {
		return integerValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValueConstant() {
		return integerValueConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValueVariable() {
		return integerValueVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLockAction() {
		return lockActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopStatement() {
		return loopStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopStatement_BehaviorActionsOwned() {
		return (EReference)loopStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getName_() {
		return nameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName_IdentifierOwned() {
		return (EReference)nameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName_ArrayIndexes() {
		return (EReference)nameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumeral() {
		return numeralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumeral_Value() {
		return (EAttribute)numeralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericLiteral() {
		return numericLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherwise() {
		return otherwiseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterLabel() {
		return parameterLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortCountValue() {
		return portCountValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortDequeueAction() {
		return portDequeueActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortDequeueAction_PortName() {
		return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortDequeueAction_TargetOwned() {
		return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortDequeueValue() {
		return portDequeueValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortFreezeAction() {
		return portFreezeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortFreshValue() {
		return portFreshValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortSendAction() {
		return portSendActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortSendAction_PortName() {
		return (EReference)portSendActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortSendAction_ValueExpressionOwned() {
		return (EReference)portSendActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorPropertyConstant() {
		return behaviorPropertyConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorPropertyValue() {
		return behaviorPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorRealLiteral() {
		return behaviorRealLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_SimpleExpressionOwned() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_SimpleExpressionSdOwned() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelation_RelationalOperatorOwned() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSharedDataAction() {
		return sharedDataActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSharedDataAction_DataAccessName() {
		return (EReference)sharedDataActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleExpression() {
		return simpleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExpression_UnaryAddingOperatorOwned() {
		return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExpression_Terms() {
		return (EReference)simpleExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExpression_BinaryAddingOperators() {
		return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubprogramCallAction() {
		return subprogramCallActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_SubprogramNames() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_SubprogramReference() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubprogramCallAction_ParameterLabels() {
		return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Factors() {
		return (EReference)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_MultiplyingOperators() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedAction() {
		return timedActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedAction_LowerBehaviorTime() {
		return (EReference)timedActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedAction_UpperBehaviorTime() {
		return (EReference)timedActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeoutCatch() {
		return timeoutCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueComponentClassifierReference() {
		return uniqueComponentClassifierReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlockAction() {
		return unlockActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstant() {
		return valueConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueExpression() {
		return valueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueExpression_Relations() {
		return (EReference)valueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueExpression_LogicalOperators() {
		return (EAttribute)valueExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueVariable() {
		return valueVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileOrDoUntilStatement() {
		return whileOrDoUntilStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileOrDoUntilStatement_LogicalValueExpression() {
		return (EReference)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhileOrDoUntilStatement_DoUntil() {
		return (EAttribute)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBehaviorFeatureType() {
		return behaviorFeatureTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryAddingOperator() {
		return binaryAddingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryNumericOperator() {
		return binaryNumericOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataRepresentation() {
		return dataRepresentationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureType() {
		return featureTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicalOperator() {
		return logicalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplyingOperator() {
		return multiplyingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationalOperator() {
		return relationalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryAddingOperator() {
		return unaryAddingOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryBooleanOperator() {
		return unaryBooleanOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryNumericOperator() {
		return unaryNumericOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReal() {
		return realEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlBaFactory getAadlBaFactory() {
		return (AadlBaFactory)getEFactoryInstance();
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
		assignmentActionEClass = createEClass(ASSIGNMENT_ACTION);
		createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__TARGET_OWNED);
		createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED);
		createEAttribute(assignmentActionEClass, ASSIGNMENT_ACTION__ANY);

		basicActionEClass = createEClass(BASIC_ACTION);

		behaviorActionEClass = createEClass(BEHAVIOR_ACTION);

		behaviorActionBlockEClass = createEClass(BEHAVIOR_ACTION_BLOCK);
		createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED);
		createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED);

		behaviorActionCollectionEClass = createEClass(BEHAVIOR_ACTION_COLLECTION);
		createEReference(behaviorActionCollectionEClass, BEHAVIOR_ACTION_COLLECTION__BEHAVIOR_ACTIONS);

		behaviorActionsEClass = createEClass(BEHAVIOR_ACTIONS);

		behaviorActionSequenceEClass = createEClass(BEHAVIOR_ACTION_SEQUENCE);

		behaviorActionSetEClass = createEClass(BEHAVIOR_ACTION_SET);

		behaviorAnnexEClass = createEClass(BEHAVIOR_ANNEX);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_STATES);
		createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS);

		behaviorConditionEClass = createEClass(BEHAVIOR_CONDITION);

		behaviorElementEClass = createEClass(BEHAVIOR_ELEMENT);
		createEReference(behaviorElementEClass, BEHAVIOR_ELEMENT__BA_REF);
		createEReference(behaviorElementEClass, BEHAVIOR_ELEMENT__AADL_REF);

		behaviorNamedElementEClass = createEClass(BEHAVIOR_NAMED_ELEMENT);
		createEAttribute(behaviorNamedElementEClass, BEHAVIOR_NAMED_ELEMENT__NAME);
		createEAttribute(behaviorNamedElementEClass, BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME);
		createEAttribute(behaviorNamedElementEClass, BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR);
		createEAttribute(behaviorNamedElementEClass, BEHAVIOR_NAMED_ELEMENT__NAMESPACE);

		behaviorStateEClass = createEClass(BEHAVIOR_STATE);
		createEReference(behaviorStateEClass, BEHAVIOR_STATE__IDENTIFIERS);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__INITIAL);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__COMPLETE);
		createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__FINAL);

		behaviorTimeEClass = createEClass(BEHAVIOR_TIME);
		createEReference(behaviorTimeEClass, BEHAVIOR_TIME__INTEGER_VALUE_OWNED);
		createEReference(behaviorTimeEClass, BEHAVIOR_TIME__UNIT_IDENTIFIER);

		behaviorTransitionEClass = createEClass(BEHAVIOR_TRANSITION);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED);
		createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY);

		behaviorVariableEClass = createEClass(BEHAVIOR_VARIABLE);
		createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__LOCAL_VARIABLE_DECLARATORS);
		createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		behaviorBooleanLiteralEClass = createEClass(BEHAVIOR_BOOLEAN_LITERAL);

		behaviorStringLiteralEClass = createEClass(BEHAVIOR_STRING_LITERAL);

		communicationActionEClass = createEClass(COMMUNICATION_ACTION);

		completionRelativeTimeoutConditionAndCatchEClass = createEClass(COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH);

		condStatementEClass = createEClass(COND_STATEMENT);

		dataComponentReferenceEClass = createEClass(DATA_COMPONENT_REFERENCE);
		createEReference(dataComponentReferenceEClass, DATA_COMPONENT_REFERENCE__NAMES);

		declaratorEClass = createEClass(DECLARATOR);
		createEReference(declaratorEClass, DECLARATOR__IDENTIFIER_OWNED);
		createEReference(declaratorEClass, DECLARATOR__ARRAY_SIZES);

		dispatchConditionEClass = createEClass(DISPATCH_CONDITION);
		createEReference(dispatchConditionEClass, DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION_OWNED);
		createEReference(dispatchConditionEClass, DISPATCH_CONDITION__FROZEN_PORTS);

		dispatchConjunctionEClass = createEClass(DISPATCH_CONJUNCTION);
		createEReference(dispatchConjunctionEClass, DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS);

		dispatchTriggerConditionEClass = createEClass(DISPATCH_TRIGGER_CONDITION);

		dispatchTriggerConditionStopEClass = createEClass(DISPATCH_TRIGGER_CONDITION_STOP);

		dispatchTriggerLogicalExpressionEClass = createEClass(DISPATCH_TRIGGER_LOGICAL_EXPRESSION);
		createEReference(dispatchTriggerLogicalExpressionEClass, DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS);

		elementValuesEClass = createEClass(ELEMENT_VALUES);

		executeConditionEClass = createEClass(EXECUTE_CONDITION);

		factorEClass = createEClass(FACTOR);
		createEReference(factorEClass, FACTOR__VALUE_OWNED);
		createEReference(factorEClass, FACTOR__VALUE_SD_OWNED);
		createEAttribute(factorEClass, FACTOR__BINARY_NUMERIC_OPERATOR_OWNED);
		createEAttribute(factorEClass, FACTOR__UNARY_NUMERIC_OPERATOR_OWNED);
		createEAttribute(factorEClass, FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED);

		forOrForAllStatementEClass = createEClass(FOR_OR_FOR_ALL_STATEMENT);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ELEMENT_IDENTIFIER);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);
		createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED);
		createEAttribute(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__FOR_ALL);

		identifierEClass = createEClass(IDENTIFIER);
		createEAttribute(identifierEClass, IDENTIFIER__ID);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEAttribute(ifStatementEClass, IF_STATEMENT__HAS_ELSE);
		createEReference(ifStatementEClass, IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS);
		createEReference(ifStatementEClass, IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

		behaviorIntegerLiteralEClass = createEClass(BEHAVIOR_INTEGER_LITERAL);

		integerRangeEClass = createEClass(INTEGER_RANGE);
		createEReference(integerRangeEClass, INTEGER_RANGE__LOWER_INTEGER_VALUE);
		createEReference(integerRangeEClass, INTEGER_RANGE__UPPER_INTEGER_VALUE);

		integerValueEClass = createEClass(INTEGER_VALUE);

		integerValueConstantEClass = createEClass(INTEGER_VALUE_CONSTANT);

		integerValueVariableEClass = createEClass(INTEGER_VALUE_VARIABLE);

		literalEClass = createEClass(LITERAL);

		lockActionEClass = createEClass(LOCK_ACTION);

		loopStatementEClass = createEClass(LOOP_STATEMENT);
		createEReference(loopStatementEClass, LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

		nameEClass = createEClass(NAME);
		createEReference(nameEClass, NAME__IDENTIFIER_OWNED);
		createEReference(nameEClass, NAME__ARRAY_INDEXES);

		numeralEClass = createEClass(NUMERAL);
		createEAttribute(numeralEClass, NUMERAL__VALUE);

		numericLiteralEClass = createEClass(NUMERIC_LITERAL);

		otherwiseEClass = createEClass(OTHERWISE);

		parameterLabelEClass = createEClass(PARAMETER_LABEL);

		portCountValueEClass = createEClass(PORT_COUNT_VALUE);

		portDequeueActionEClass = createEClass(PORT_DEQUEUE_ACTION);
		createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__PORT_NAME);
		createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__TARGET_OWNED);

		portDequeueValueEClass = createEClass(PORT_DEQUEUE_VALUE);

		portFreezeActionEClass = createEClass(PORT_FREEZE_ACTION);

		portFreshValueEClass = createEClass(PORT_FRESH_VALUE);

		portSendActionEClass = createEClass(PORT_SEND_ACTION);
		createEReference(portSendActionEClass, PORT_SEND_ACTION__PORT_NAME);
		createEReference(portSendActionEClass, PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED);

		behaviorPropertyConstantEClass = createEClass(BEHAVIOR_PROPERTY_CONSTANT);

		behaviorPropertyValueEClass = createEClass(BEHAVIOR_PROPERTY_VALUE);

		behaviorRealLiteralEClass = createEClass(BEHAVIOR_REAL_LITERAL);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_OWNED);
		createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_SD_OWNED);
		createEAttribute(relationEClass, RELATION__RELATIONAL_OPERATOR_OWNED);

		sharedDataActionEClass = createEClass(SHARED_DATA_ACTION);
		createEReference(sharedDataActionEClass, SHARED_DATA_ACTION__DATA_ACCESS_NAME);

		simpleExpressionEClass = createEClass(SIMPLE_EXPRESSION);
		createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED);
		createEReference(simpleExpressionEClass, SIMPLE_EXPRESSION__TERMS);
		createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS);

		subprogramCallActionEClass = createEClass(SUBPROGRAM_CALL_ACTION);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE);
		createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS);

		targetEClass = createEClass(TARGET);

		termEClass = createEClass(TERM);
		createEReference(termEClass, TERM__FACTORS);
		createEAttribute(termEClass, TERM__MULTIPLYING_OPERATORS);

		timedActionEClass = createEClass(TIMED_ACTION);
		createEReference(timedActionEClass, TIMED_ACTION__LOWER_BEHAVIOR_TIME);
		createEReference(timedActionEClass, TIMED_ACTION__UPPER_BEHAVIOR_TIME);

		timeoutCatchEClass = createEClass(TIMEOUT_CATCH);

		uniqueComponentClassifierReferenceEClass = createEClass(UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		unlockActionEClass = createEClass(UNLOCK_ACTION);

		valueEClass = createEClass(VALUE);

		valueConstantEClass = createEClass(VALUE_CONSTANT);

		valueExpressionEClass = createEClass(VALUE_EXPRESSION);
		createEReference(valueExpressionEClass, VALUE_EXPRESSION__RELATIONS);
		createEAttribute(valueExpressionEClass, VALUE_EXPRESSION__LOGICAL_OPERATORS);

		valueVariableEClass = createEClass(VALUE_VARIABLE);

		whileOrDoUntilStatementEClass = createEClass(WHILE_OR_DO_UNTIL_STATEMENT);
		createEReference(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION);
		createEAttribute(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL);

		// Create enums
		behaviorFeatureTypeEEnum = createEEnum(BEHAVIOR_FEATURE_TYPE);
		binaryAddingOperatorEEnum = createEEnum(BINARY_ADDING_OPERATOR);
		binaryNumericOperatorEEnum = createEEnum(BINARY_NUMERIC_OPERATOR);
		dataRepresentationEEnum = createEEnum(DATA_REPRESENTATION);
		featureTypeEEnum = createEEnum(FEATURE_TYPE);
		logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
		multiplyingOperatorEEnum = createEEnum(MULTIPLYING_OPERATOR);
		relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
		unaryAddingOperatorEEnum = createEEnum(UNARY_ADDING_OPERATOR);
		unaryBooleanOperatorEEnum = createEEnum(UNARY_BOOLEAN_OPERATOR);
		unaryNumericOperatorEEnum = createEEnum(UNARY_NUMERIC_OPERATOR);

		// Create data types
		booleanEDataType = createEDataType(BOOLEAN);
		integerEDataType = createEDataType(INTEGER);
		realEDataType = createEDataType(REAL);
		stringEDataType = createEDataType(STRING);
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
		Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assignmentActionEClass.getESuperTypes().add(this.getBasicAction());
		basicActionEClass.getESuperTypes().add(this.getBehaviorAction());
		behaviorActionEClass.getESuperTypes().add(this.getBehaviorActions());
		behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorAction());
		behaviorActionCollectionEClass.getESuperTypes().add(this.getBehaviorActions());
		behaviorActionsEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorActionSequenceEClass.getESuperTypes().add(this.getBehaviorActionCollection());
		behaviorActionSetEClass.getESuperTypes().add(this.getBehaviorActionCollection());
		behaviorAnnexEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
		behaviorAnnexEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorConditionEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorElementEClass.getESuperTypes().add(theAadl2Package.getElement());
		behaviorNamedElementEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorStateEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorTimeEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorTransitionEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorVariableEClass.getESuperTypes().add(this.getBehaviorElement());
		behaviorBooleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		behaviorBooleanLiteralEClass.getESuperTypes().add(theAadl2Package.getBooleanLiteral());
		behaviorStringLiteralEClass.getESuperTypes().add(this.getLiteral());
		behaviorStringLiteralEClass.getESuperTypes().add(theAadl2Package.getStringLiteral());
		communicationActionEClass.getESuperTypes().add(this.getBasicAction());
		completionRelativeTimeoutConditionAndCatchEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		completionRelativeTimeoutConditionAndCatchEClass.getESuperTypes().add(this.getBehaviorTime());
		condStatementEClass.getESuperTypes().add(this.getBehaviorAction());
		dataComponentReferenceEClass.getESuperTypes().add(this.getElementValues());
		dataComponentReferenceEClass.getESuperTypes().add(this.getTarget());
		dataComponentReferenceEClass.getESuperTypes().add(this.getValueVariable());
		declaratorEClass.getESuperTypes().add(this.getBehaviorElement());
		dispatchConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
		dispatchConjunctionEClass.getESuperTypes().add(this.getBehaviorElement());
		dispatchTriggerConditionEClass.getESuperTypes().add(this.getBehaviorElement());
		dispatchTriggerConditionStopEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		dispatchTriggerLogicalExpressionEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		elementValuesEClass.getESuperTypes().add(this.getBehaviorElement());
		executeConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
		factorEClass.getESuperTypes().add(this.getBehaviorElement());
		forOrForAllStatementEClass.getESuperTypes().add(this.getLoopStatement());
		identifierEClass.getESuperTypes().add(this.getBehaviorElement());
		identifierEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		ifStatementEClass.getESuperTypes().add(this.getCondStatement());
		behaviorIntegerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		behaviorIntegerLiteralEClass.getESuperTypes().add(theAadl2Package.getIntegerLiteral());
		integerRangeEClass.getESuperTypes().add(this.getElementValues());
		integerValueEClass.getESuperTypes().add(this.getBehaviorElement());
		integerValueConstantEClass.getESuperTypes().add(this.getIntegerValue());
		integerValueVariableEClass.getESuperTypes().add(this.getIntegerValue());
		literalEClass.getESuperTypes().add(this.getValueConstant());
		lockActionEClass.getESuperTypes().add(this.getSharedDataAction());
		loopStatementEClass.getESuperTypes().add(this.getCondStatement());
		nameEClass.getESuperTypes().add(this.getElementValues());
		nameEClass.getESuperTypes().add(this.getTarget());
		nameEClass.getESuperTypes().add(this.getValueVariable());
		numeralEClass.getESuperTypes().add(this.getBehaviorElement());
		numericLiteralEClass.getESuperTypes().add(this.getLiteral());
		numericLiteralEClass.getESuperTypes().add(theAadl2Package.getNumberValue());
		otherwiseEClass.getESuperTypes().add(this.getExecuteCondition());
		parameterLabelEClass.getESuperTypes().add(this.getBehaviorElement());
		portCountValueEClass.getESuperTypes().add(this.getValueVariable());
		portCountValueEClass.getESuperTypes().add(this.getName_());
		portDequeueActionEClass.getESuperTypes().add(this.getCommunicationAction());
		portDequeueValueEClass.getESuperTypes().add(this.getValueVariable());
		portDequeueValueEClass.getESuperTypes().add(this.getName_());
		portFreezeActionEClass.getESuperTypes().add(this.getCommunicationAction());
		portFreezeActionEClass.getESuperTypes().add(this.getName_());
		portFreshValueEClass.getESuperTypes().add(this.getValueVariable());
		portFreshValueEClass.getESuperTypes().add(this.getName_());
		portSendActionEClass.getESuperTypes().add(this.getCommunicationAction());
		behaviorPropertyConstantEClass.getESuperTypes().add(this.getBehaviorNamedElement());
		behaviorPropertyConstantEClass.getESuperTypes().add(this.getValueConstant());
		behaviorPropertyValueEClass.getESuperTypes().add(this.getBehaviorNamedElement());
		behaviorPropertyValueEClass.getESuperTypes().add(this.getValueConstant());
		behaviorRealLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		behaviorRealLiteralEClass.getESuperTypes().add(theAadl2Package.getRealLiteral());
		relationEClass.getESuperTypes().add(this.getBehaviorElement());
		sharedDataActionEClass.getESuperTypes().add(this.getCommunicationAction());
		simpleExpressionEClass.getESuperTypes().add(this.getBehaviorElement());
		subprogramCallActionEClass.getESuperTypes().add(this.getCommunicationAction());
		targetEClass.getESuperTypes().add(this.getParameterLabel());
		targetEClass.getESuperTypes().add(this.getBehaviorElement());
		termEClass.getESuperTypes().add(this.getBehaviorElement());
		timedActionEClass.getESuperTypes().add(this.getBasicAction());
		timeoutCatchEClass.getESuperTypes().add(this.getExecuteCondition());
		timeoutCatchEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
		uniqueComponentClassifierReferenceEClass.getESuperTypes().add(this.getBehaviorNamedElement());
		unlockActionEClass.getESuperTypes().add(this.getSharedDataAction());
		valueEClass.getESuperTypes().add(this.getBehaviorElement());
		valueConstantEClass.getESuperTypes().add(this.getValue());
		valueConstantEClass.getESuperTypes().add(this.getIntegerValueConstant());
		valueExpressionEClass.getESuperTypes().add(this.getValue());
		valueExpressionEClass.getESuperTypes().add(this.getParameterLabel());
		valueExpressionEClass.getESuperTypes().add(this.getExecuteCondition());
		valueVariableEClass.getESuperTypes().add(this.getValue());
		valueVariableEClass.getESuperTypes().add(this.getIntegerValueVariable());
		whileOrDoUntilStatementEClass.getESuperTypes().add(this.getLoopStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(assignmentActionEClass, AssignmentAction.class, "AssignmentAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignmentAction_TargetOwned(), this.getTarget(), null, "targetOwned", null, 1, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignmentAction_ValueExpressionOwned(), this.getValueExpression(), null, "valueExpressionOwned", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignmentAction_Any(), this.getBoolean(), "any", "false", 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicActionEClass, BasicAction.class, "BasicAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionEClass, BehaviorAction.class, "BehaviorAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionBlockEClass, BehaviorActionBlock.class, "BehaviorActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorActionBlock_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorActionBlock_BehaviorTimeOwned(), this.getBehaviorTime(), null, "behaviorTimeOwned", null, 0, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorActionCollectionEClass, BehaviorActionCollection.class, "BehaviorActionCollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorActionCollection_BehaviorActions(), this.getBehaviorAction(), null, "behaviorActions", null, 1, -1, BehaviorActionCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorActionsEClass, BehaviorActions.class, "BehaviorActions", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionSequenceEClass, BehaviorActionSequence.class, "BehaviorActionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorActionSetEClass, BehaviorActionSet.class, "BehaviorActionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorAnnexEClass, BehaviorAnnex.class, "BehaviorAnnex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorAnnex_BehaviorVariables(), this.getBehaviorVariable(), null, "behaviorVariables", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorAnnex_BehaviorStates(), this.getBehaviorState(), null, "behaviorStates", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorAnnex_BehaviorTransitions(), this.getBehaviorTransition(), null, "behaviorTransitions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorConditionEClass, BehaviorCondition.class, "BehaviorCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorElementEClass, BehaviorElement.class, "BehaviorElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorElement_BaRef(), this.getBehaviorElement(), null, "baRef", null, 0, 1, BehaviorElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorElement_AadlRef(), theAadl2Package.getElement(), null, "aadlRef", null, 0, 1, BehaviorElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorNamedElementEClass, BehaviorNamedElement.class, "BehaviorNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBehaviorNamedElement_Name(), this.getString(), "name", null, 1, 1, BehaviorNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBehaviorNamedElement_QualifiedName(), this.getString(), "qualifiedName", null, 1, 1, BehaviorNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBehaviorNamedElement_NamespaceSeparator(), this.getString(), "namespaceSeparator", null, 0, 1, BehaviorNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorNamedElement_Namespace(), this.getString(), "namespace", null, 0, 1, BehaviorNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorStateEClass, BehaviorState.class, "BehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorState_Identifiers(), this.getIdentifier(), null, "identifiers", null, 1, -1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Initial(), this.getBoolean(), "initial", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Complete(), this.getBoolean(), "complete", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorState_Final(), this.getBoolean(), "final", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorTimeEClass, BehaviorTime.class, "BehaviorTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTime_IntegerValueOwned(), this.getIntegerValue(), null, "integerValueOwned", null, 1, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTime_UnitIdentifier(), this.getIdentifier(), null, "unitIdentifier", null, 1, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorTransitionEClass, BehaviorTransition.class, "BehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorTransition_TransitionIdentifier(), this.getIdentifier(), null, "transitionIdentifier", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_SourceStateIdentifiers(), this.getIdentifier(), null, "sourceStateIdentifiers", null, 1, -1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorConditionOwned(), this.getBehaviorCondition(), null, "behaviorConditionOwned", null, 1, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_DestinationStateIdentifier(), this.getIdentifier(), null, "destinationStateIdentifier", null, 1, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorActionBlockOwned(), this.getBehaviorActionBlock(), null, "behaviorActionBlockOwned", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorTransition_BehaviorTransitionPriority(), this.getNumeral(), null, "behaviorTransitionPriority", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorVariableEClass, BehaviorVariable.class, "BehaviorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorVariable_LocalVariableDeclarators(), this.getDeclarator(), null, "LocalVariableDeclarators", null, 1, -1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorVariable_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "DataUniqueComponentClassifierReference", null, 1, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorBooleanLiteralEClass, BehaviorBooleanLiteral.class, "BehaviorBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorStringLiteralEClass, BehaviorStringLiteral.class, "BehaviorStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(communicationActionEClass, CommunicationAction.class, "CommunicationAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(completionRelativeTimeoutConditionAndCatchEClass, CompletionRelativeTimeoutConditionAndCatch.class, "CompletionRelativeTimeoutConditionAndCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(condStatementEClass, CondStatement.class, "CondStatement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataComponentReferenceEClass, DataComponentReference.class, "DataComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataComponentReference_Names(), this.getName_(), null, "names", null, 1, -1, DataComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declaratorEClass, Declarator.class, "Declarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclarator_IdentifierOwned(), this.getIdentifier(), null, "identifierOwned", null, 1, 1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeclarator_ArraySizes(), this.getIntegerValueConstant(), null, "arraySizes", null, 0, -1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchConditionEClass, DispatchCondition.class, "DispatchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchCondition_DispatchTriggerConditionOwned(), this.getDispatchTriggerCondition(), null, "dispatchTriggerConditionOwned", null, 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDispatchCondition_FrozenPorts(), this.getIdentifier(), null, "frozenPorts", null, 0, -1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchConjunctionEClass, DispatchConjunction.class, "DispatchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchConjunction_DispatchTriggers(), this.getIdentifier(), null, "dispatchTriggers", null, 1, -1, DispatchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchTriggerConditionEClass, DispatchTriggerCondition.class, "DispatchTriggerCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchTriggerConditionStopEClass, DispatchTriggerConditionStop.class, "DispatchTriggerConditionStop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchTriggerLogicalExpressionEClass, DispatchTriggerLogicalExpression.class, "DispatchTriggerLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchTriggerLogicalExpression_DispatchConjunctions(), this.getDispatchConjunction(), null, "dispatchConjunctions", null, 1, -1, DispatchTriggerLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementValuesEClass, ElementValues.class, "ElementValues", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(executeConditionEClass, ExecuteCondition.class, "ExecuteCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(factorEClass, Factor.class, "Factor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFactor_ValueOwned(), this.getValue(), null, "valueOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFactor_ValueSdOwned(), this.getValue(), null, "valueSdOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_BinaryNumericOperatorOwned(), this.getBinaryNumericOperator(), "binaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_UnaryNumericOperatorOwned(), this.getUnaryNumericOperator(), "unaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactor_UnaryBooleanOperatorOwned(), this.getUnaryBooleanOperator(), "unaryBooleanOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forOrForAllStatementEClass, ForOrForAllStatement.class, "ForOrForAllStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForOrForAllStatement_ElementIdentifier(), this.getIdentifier(), null, "elementIdentifier", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForOrForAllStatement_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "dataUniqueComponentClassifierReference", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForOrForAllStatement_ElementValuesOwned(), this.getElementValues(), null, "elementValuesOwned", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForOrForAllStatement_ForAll(), this.getBoolean(), "forAll", "false", 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifier_Id(), this.getString(), "id", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIfStatement_HasElse(), this.getBoolean(), "hasElse", "false", 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_LogicalValueExpressions(), this.getValueExpression(), null, "logicalValueExpressions", null, 1, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorIntegerLiteralEClass, BehaviorIntegerLiteral.class, "BehaviorIntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerRangeEClass, IntegerRange.class, "IntegerRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegerRange_LowerIntegerValue(), this.getIntegerValue(), null, "lowerIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntegerRange_UpperIntegerValue(), this.getIntegerValue(), null, "upperIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueConstantEClass, IntegerValueConstant.class, "IntegerValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueVariableEClass, IntegerValueVariable.class, "IntegerValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lockActionEClass, LockAction.class, "LockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopStatementEClass, LoopStatement.class, "LoopStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "behaviorActionsOwned", null, 1, 1, LoopStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getName_IdentifierOwned(), this.getIdentifier(), null, "identifierOwned", null, 1, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getName_ArrayIndexes(), this.getIntegerValueVariable(), null, "arrayIndexes", null, 0, -1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numeralEClass, Numeral.class, "Numeral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumeral_Value(), this.getInteger(), "value", null, 0, 1, Numeral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(otherwiseEClass, Otherwise.class, "Otherwise", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterLabelEClass, ParameterLabel.class, "ParameterLabel", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portCountValueEClass, PortCountValue.class, "PortCountValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portDequeueActionEClass, PortDequeueAction.class, "PortDequeueAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortDequeueAction_PortName(), this.getName_(), null, "portName", null, 1, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortDequeueAction_TargetOwned(), this.getTarget(), null, "targetOwned", null, 0, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portDequeueValueEClass, PortDequeueValue.class, "PortDequeueValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portFreezeActionEClass, PortFreezeAction.class, "PortFreezeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portFreshValueEClass, PortFreshValue.class, "PortFreshValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portSendActionEClass, PortSendAction.class, "PortSendAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortSendAction_PortName(), this.getName_(), null, "portName", null, 1, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortSendAction_ValueExpressionOwned(), this.getValueExpression(), null, "valueExpressionOwned", null, 0, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorPropertyConstantEClass, BehaviorPropertyConstant.class, "BehaviorPropertyConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorPropertyValueEClass, BehaviorPropertyValue.class, "BehaviorPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorRealLiteralEClass, BehaviorRealLiteral.class, "BehaviorRealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_SimpleExpressionOwned(), this.getSimpleExpression(), null, "simpleExpressionOwned", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_SimpleExpressionSdOwned(), this.getSimpleExpression(), null, "simpleExpressionSdOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelation_RelationalOperatorOwned(), this.getRelationalOperator(), "relationalOperatorOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sharedDataActionEClass, SharedDataAction.class, "SharedDataAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSharedDataAction_DataAccessName(), this.getName_(), null, "dataAccessName", null, 0, 1, SharedDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleExpressionEClass, SimpleExpression.class, "SimpleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleExpression_UnaryAddingOperatorOwned(), this.getUnaryAddingOperator(), "unaryAddingOperatorOwned", null, 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleExpression_Terms(), this.getTerm(), null, "terms", null, 1, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExpression_BinaryAddingOperators(), this.getBinaryAddingOperator(), "binaryAddingOperators", null, 0, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subprogramCallActionEClass, SubprogramCallAction.class, "SubprogramCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubprogramCallAction_SubprogramNames(), this.getName_(), null, "subprogramNames", null, 0, 2, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubprogramCallAction_SubprogramReference(), this.getUniqueComponentClassifierReference(), null, "subprogramReference", null, 0, 1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubprogramCallAction_ParameterLabels(), this.getParameterLabel(), null, "parameterLabels", null, 0, -1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerm_Factors(), this.getFactor(), null, "factors", null, 1, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_MultiplyingOperators(), this.getMultiplyingOperator(), "multiplyingOperators", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timedActionEClass, TimedAction.class, "TimedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedAction_LowerBehaviorTime(), this.getBehaviorTime(), null, "lowerBehaviorTime", null, 1, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimedAction_UpperBehaviorTime(), this.getBehaviorTime(), null, "upperBehaviorTime", null, 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeoutCatchEClass, TimeoutCatch.class, "TimeoutCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uniqueComponentClassifierReferenceEClass, UniqueComponentClassifierReference.class, "UniqueComponentClassifierReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unlockActionEClass, UnlockAction.class, "UnlockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstantEClass, ValueConstant.class, "ValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueExpressionEClass, ValueExpression.class, "ValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueExpression_Relations(), this.getRelation(), null, "relations", null, 1, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueExpression_LogicalOperators(), this.getLogicalOperator(), "logicalOperators", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueVariableEClass, ValueVariable.class, "ValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileOrDoUntilStatementEClass, WhileOrDoUntilStatement.class, "WhileOrDoUntilStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileOrDoUntilStatement_LogicalValueExpression(), this.getValueExpression(), null, "logicalValueExpression", null, 1, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhileOrDoUntilStatement_DoUntil(), this.getBoolean(), "doUntil", "false", 0, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(behaviorFeatureTypeEEnum, BehaviorFeatureType.class, "BehaviorFeatureType");
		addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.NONE);
		addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.BEHAVIOR_VARIABLE);
		addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

		initEEnum(binaryAddingOperatorEEnum, BinaryAddingOperator.class, "BinaryAddingOperator");
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.NONE);
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.PLUS);
		addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.MINUS);

		initEEnum(binaryNumericOperatorEEnum, BinaryNumericOperator.class, "BinaryNumericOperator");
		addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.NONE);
		addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.MULTIPLY_MULTIPLY);

		initEEnum(dataRepresentationEEnum, DataRepresentation.class, "DataRepresentation");
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.UNKNOWN);
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.INTEGER);
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.FLOAT);
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.CHARACTER);
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.BOOLEAN);
		addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.STRING);

		initEEnum(featureTypeEEnum, FeatureType.class, "FeatureType");
		addEEnumLiteral(featureTypeEEnum, FeatureType.NONE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_DATA_PORT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_SUBCOMPONENT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_CLASSIFIER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_PROTOTYPE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.COMPONENT_PROTOTYPE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.COMPONENT_PROTOTYPE_BINDING);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_PROTOTYPE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_PROTOTYPE_BINDING);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP_PROTOTYPE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP_PROTOTYPE_BINDING);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_DATA_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_DATA_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_SUBCOMPONENT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_CLASSIFIER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_PARAMETER);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_CONSTANT);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_VALUE);
		addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_BUS_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_BUS_ACCESS);
		addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP);
		addEEnumLiteral(featureTypeEEnum, FeatureType.ABSTRACT_FEATURE);

		initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.NONE);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.XOR);

		initEEnum(multiplyingOperatorEEnum, MultiplyingOperator.class, "MultiplyingOperator");
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.NONE);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MULTIPLY);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.DIVIDE);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MOD);
		addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.REM);

		initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NONE);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_OR_EQUAL_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_OR_EQUAL_THAN);

		initEEnum(unaryAddingOperatorEEnum, UnaryAddingOperator.class, "UnaryAddingOperator");
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.NONE);
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.PLUS);
		addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.MINUS);

		initEEnum(unaryBooleanOperatorEEnum, UnaryBooleanOperator.class, "UnaryBooleanOperator");
		addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NONE);
		addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NOT);

		initEEnum(unaryNumericOperatorEEnum, UnaryNumericOperator.class, "UnaryNumericOperator");
		addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.NONE);
		addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.ABS);

		// Initialize data types
		initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, int.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(realEDataType, double.class, "Real", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.topcased.org/documentation
		createDocumentationAnnotations();
		// Documentation
		createDocumentation_1Annotations();
		// documentation
		createDocumentation_2Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.topcased.org/documentation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocumentationAnnotations() {
		String source = "http://www.topcased.org/documentation";					
		addAnnotation
		  (getBehaviorNamedElement_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of the NamedElement."
		   });		
		addAnnotation
		  (booleanEDataType, 
		   source, 
		   new String[] {
			 "documentation", "A Boolean type is used for logical expression, consisting of the predefined values true and false."
		   });		
		addAnnotation
		  (integerEDataType, 
		   source, 
		   new String[] {
			 "documentation", "An integer is a primitive type representing integer values."
		   });			
		addAnnotation
		  (realEDataType, 
		   source, 
		   new String[] {
			 "documentation", "A real is a primitive type representing real numeric values."
		   });		
		addAnnotation
		  (stringEDataType, 
		   source, 
		   new String[] {
			 "documentation", "A string is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters."
		   });	
	}

	/**
	 * Initializes the annotations for <b>Documentation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocumentation_1Annotations() {
		String source = "Documentation";								
		addAnnotation
		  (lockActionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A null data name means that all shared data are locked while in the critical section"
		   });			
	}

	/**
	 * Initializes the annotations for <b>documentation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocumentation_2Annotations() {
		String source = "documentation";											
		addAnnotation
		  (unlockActionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A null data name means that all shared data are unlocked at the end of the critical section"
		   });
	}

} //AadlBaPackageImpl
