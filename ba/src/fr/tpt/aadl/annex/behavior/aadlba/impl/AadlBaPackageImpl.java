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
import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex;
import fr.tpt.aadl.annex.behavior.aadlba.ArraySize;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter;
import fr.tpt.aadl.annex.behavior.aadlba.Comment;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger;
import fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Element;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.NamedElement;
import fr.tpt.aadl.annex.behavior.aadlba.Namespace;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.StringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
import fr.tpt.aadl.annex.behavior.aadlba.Value;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.WhileStatement;

import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaValidator;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaPackageImpl extends EPackageImpl implements AadlBaPackage
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass elementEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass commentEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass namedElementEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass namespaceEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass globalNamespaceEClass = null;

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
   private EClass uniqueComponentClassifierReferenceEClass = null;

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
   private EClass behaviorStateEClass = null;

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
   private EClass behaviorConditionEClass = null;

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
   private EClass arraySizeEClass = null;

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
   private EClass dispatchLogicalExpressionEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass dispatchTriggerEClass = null;

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
   private EClass behaviorActionEClass = null;

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
   private EClass basicActionEClass = null;

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
   private EClass forOrForAllStatementEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass whileStatementEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass doUntilStatementEClass = null;

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
   private EClass assignmentActionEClass = null;

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
   private EClass subprogramParameterListEClass = null;

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
   private EClass targetEClass = null;

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
   private EClass dataComponentReferenceEClass = null;

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
   private EClass arrayIndexEClass = null;

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
   private EClass valueVariableEClass = null;

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
   private EClass relationEClass = null;

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
   private EClass termEClass = null;

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
   private EClass behaviorTimeEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass propertyConstantEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass propertyValueEClass = null;

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
   private EClass numericLiteralEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass booleanLiteralEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass stringLiteralEClass = null;

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
   private EClass executeConditionEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EEnum commActionParameterEEnum = null;

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
   private EEnum relationalOperatorEEnum = null;

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
   private EEnum unaryAddingOperatorEEnum = null;

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
   private EEnum binaryNumericOperatorEEnum = null;

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
   private EEnum unaryBooleanOperatorEEnum = null;

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
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EDataType booleanEDataType = null;

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
   private AadlBaPackageImpl()
   {
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
   public static AadlBaPackage init()
   {
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

      // Register package validator
      EValidator.Registry.INSTANCE.put
         (theAadlBaPackage, 
          new EValidator.Descriptor()
          {
             public EValidator getEValidator()
             {
                return AadlBaValidator.INSTANCE;
             }
          });

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
   public EClass getElement()
   {
      return elementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getElement_BaReferencedEntity()
   {
      return (EReference)elementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getElement_AadlReferencedEntity()
   {
      return (EReference)elementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getComment()
   {
      return commentEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getComment_Body()
   {
      return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNamedElement()
   {
      return namedElementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getNamedElement_Name()
   {
      return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getNamedElement_QualifiedName()
   {
      return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getNamedElement_Namespace()
   {
      return (EReference)namedElementEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNamespace()
   {
      return namespaceEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getNamespace_OwnedMember()
   {
      return (EReference)namespaceEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getNamespace_Member()
   {
      return (EReference)namespaceEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getGlobalNamespace()
   {
      return globalNamespaceEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorAnnex()
   {
      return behaviorAnnexEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAnnex_Variables()
   {
      return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAnnex_States()
   {
      return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAnnex_Transitions()
   {
      return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getUniqueComponentClassifierReference()
   {
      return uniqueComponentClassifierReferenceEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorVariable()
   {
      return behaviorVariableEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorVariable_LocalVariableDeclarators()
   {
      return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorVariable_DataUniqueComponentClassifierReference()
   {
      return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorVariable_Persistent()
   {
      return (EAttribute)behaviorVariableEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorState()
   {
      return behaviorStateEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorState_BehaviorStateIdentifiers()
   {
      return (EReference)behaviorStateEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorState_Initial()
   {
      return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorState_Complete()
   {
      return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorState_Final()
   {
      return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorTransition()
   {
      return behaviorTransitionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_SourceStateIdentifiers()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_BehaviorActionsOwned()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_BehaviorConditionOwned()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_BehaviorTransitionPriority()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_DestinationStateIdentifier()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_TransitionIdentifier()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTransition_Timeout()
   {
      return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorCondition()
   {
      return behaviorConditionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDeclarator()
   {
      return declaratorEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDeclarator_ArraySizes()
   {
      return (EReference)declaratorEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getArraySize()
   {
      return arraySizeEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getArraySize_IntegerValueConstant()
   {
      return (EReference)arraySizeEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDispatchCondition()
   {
      return dispatchConditionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchCondition_HasFrozenPorts()
   {
      return (EAttribute)dispatchConditionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchCondition_TheDispatchLogicalExpression()
   {
      return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchCondition_FrozenPorts()
   {
      return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDispatchLogicalExpression()
   {
      return dispatchLogicalExpressionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchLogicalExpression_DispatchTriggers()
   {
      return (EReference)dispatchLogicalExpressionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchLogicalExpression_OrExpression()
   {
      return (EAttribute)dispatchLogicalExpressionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchLogicalExpression_AndExpression()
   {
      return (EAttribute)dispatchLogicalExpressionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchLogicalExpression_XorExpression()
   {
      return (EAttribute)dispatchLogicalExpressionEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchLogicalExpression_Stop()
   {
      return (EAttribute)dispatchLogicalExpressionEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDispatchTrigger()
   {
      return dispatchTriggerEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_TheDispatchLogicalExpression()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_TheBehaviorTime()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_IdentifierOwned()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_DispatchTriggers()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_NumeralOwned()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDispatchTrigger_ValueConstantOwned()
   {
      return (EReference)dispatchTriggerEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchTrigger_Not()
   {
      return (EAttribute)dispatchTriggerEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchTrigger_Timeout()
   {
      return (EAttribute)dispatchTriggerEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchTrigger_Others()
   {
      return (EAttribute)dispatchTriggerEClass.getEStructuralFeatures().get(8);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchTrigger_OrMore()
   {
      return (EAttribute)dispatchTriggerEClass.getEStructuralFeatures().get(9);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getDispatchTrigger_OrLess()
   {
      return (EAttribute)dispatchTriggerEClass.getEStructuralFeatures().get(10);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorActions()
   {
      return behaviorActionsEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorActions_BehaviorAction()
   {
      return (EReference)behaviorActionsEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorActions_Sequence()
   {
      return (EAttribute)behaviorActionsEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorActions_Set()
   {
      return (EAttribute)behaviorActionsEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorAction()
   {
      return behaviorActionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAction_BasicActionOwned()
   {
      return (EReference)behaviorActionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAction_BehaviorActionsOwned()
   {
      return (EReference)behaviorActionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAction_CondStatementOwned()
   {
      return (EReference)behaviorActionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorAction_BasicAction()
   {
      return (EAttribute)behaviorActionEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorAction_If()
   {
      return (EAttribute)behaviorActionEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorAction_For()
   {
      return (EAttribute)behaviorActionEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorAction_While()
   {
      return (EAttribute)behaviorActionEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorAction_DoUntil()
   {
      return (EAttribute)behaviorActionEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorAction_Timeout()
   {
      return (EReference)behaviorActionEClass.getEStructuralFeatures().get(8);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getCondStatement()
   {
      return condStatementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBasicAction()
   {
      return basicActionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getIfStatement()
   {
      return ifStatementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getIfStatement_HasElse()
   {
      return (EAttribute)ifStatementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getIfStatement_ValueExpressionOwned()
   {
      return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getIfStatement_BehaviorActionsOwned()
   {
      return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getForOrForAllStatement()
   {
      return forOrForAllStatementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getForOrForAllStatement_DataUniqueCmtClassRef()
   {
      return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getForOrForAllStatement_ElementValuesOwned()
   {
      return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getForOrForAllStatement_BehaviorActionsOwned()
   {
      return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getForOrForAllStatement_ForAll()
   {
      return (EAttribute)forOrForAllStatementEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getWhileStatement()
   {
      return whileStatementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getWhileStatement_ValueExpressionOwned()
   {
      return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getWhileStatement_BehaviorActionsOwned()
   {
      return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDoUntilStatement()
   {
      return doUntilStatementEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDoUntilStatement_BehaviorActionsOwned()
   {
      return (EReference)doUntilStatementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDoUntilStatement_ValueExpressionOwned()
   {
      return (EReference)doUntilStatementEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getElementValues()
   {
      return elementValuesEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getAssignmentAction()
   {
      return assignmentActionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getAssignmentAction_TargetOwned()
   {
      return (EReference)assignmentActionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getAssignmentAction_ValueExpressionOwned()
   {
      return (EReference)assignmentActionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getAssignmentAction_Any()
   {
      return (EAttribute)assignmentActionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getCommunicationAction()
   {
      return communicationActionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCommunicationAction_ActionType()
   {
      return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCommunicationAction_EltNameOwned()
   {
      return (EReference)communicationActionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCommunicationAction_SubpgmParamListOwned()
   {
      return (EReference)communicationActionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCommunicationAction_HasValueExpression()
   {
      return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCommunicationAction_HasTarget()
   {
      return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCommunicationAction_ValueExprOwned()
   {
      return (EReference)communicationActionEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCommunicationAction_TarOwned()
   {
      return (EReference)communicationActionEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getCommunicationAction_DataUniqueComponentClassifierReference()
   {
      return (EReference)communicationActionEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCommunicationAction_CatchTimeout()
   {
      return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(8);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getCommunicationAction_All()
   {
      return (EAttribute)communicationActionEClass.getEStructuralFeatures().get(9);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getSubprogramParameterList()
   {
      return subprogramParameterListEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getSubprogramParameterList_ParameterList()
   {
      return (EReference)subprogramParameterListEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTimedAction()
   {
      return timedActionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTimedAction_BehaviorTimesOwned()
   {
      return (EReference)timedActionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTimedAction_Computation()
   {
      return (EAttribute)timedActionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTarget()
   {
      return targetEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTarget_ElementNameOwned()
   {
      return (EReference)targetEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTarget_DataComponentReferenceOwned()
   {
      return (EReference)targetEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getParameterLabel()
   {
      return parameterLabelEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getDataComponentReference()
   {
      return dataComponentReferenceEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getDataComponentReference_ElementsNameOwned()
   {
      return (EReference)dataComponentReferenceEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getName_()
   {
      return nameEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getName_ArrayIndexListOwned()
   {
      return (EReference)nameEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getName_Identifier()
   {
      return (EReference)nameEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getArrayIndex()
   {
      return arrayIndexEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getArrayIndex_IntegerValueVariableOwned()
   {
      return (EReference)arrayIndexEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getValue()
   {
      return valueEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getValueVariable()
   {
      return valueVariableEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getValueVariable_DataComponentReferenceOwned()
   {
      return (EReference)valueVariableEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueVariable_Interrogation()
   {
      return (EAttribute)valueVariableEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueVariable_Count()
   {
      return (EAttribute)valueVariableEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueVariable_Fresh()
   {
      return (EAttribute)valueVariableEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueVariable_HasDataCptRef()
   {
      return (EAttribute)valueVariableEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getValueVariable_ElementNameOwned()
   {
      return (EReference)valueVariableEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getValueConstant()
   {
      return valueConstantEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getValueExpression()
   {
      return valueExpressionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getValueExpression_RelationsOwned()
   {
      return (EReference)valueExpressionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueExpression_LogicalOperatorsOwned()
   {
      return (EAttribute)valueExpressionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getValueExpression_HasLogicalOperator()
   {
      return (EAttribute)valueExpressionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getRelation()
   {
      return relationEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRelation_SimpleExpressionOwned()
   {
      return (EReference)relationEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getRelation_SimpleExpressionSdOwned()
   {
      return (EReference)relationEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getRelation_RelationalOperatorOwned()
   {
      return (EAttribute)relationEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getRelation_HasRelationalOperator()
   {
      return (EAttribute)relationEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getSimpleExpression()
   {
      return simpleExpressionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getSimpleExpression_TermsOwned()
   {
      return (EReference)simpleExpressionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getSimpleExpression_UnaryAddingOperatorOwned()
   {
      return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getSimpleExpression_HasUnaryAddingOperator()
   {
      return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getSimpleExpression_BinaryAddingOperatorOwned()
   {
      return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getSimpleExpression_HasBinaryAddingOperator()
   {
      return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTerm()
   {
      return termEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getTerm_FactorsOwned()
   {
      return (EReference)termEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTerm_HasMultiplyingOperator()
   {
      return (EAttribute)termEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getTerm_MultiplyingOperatorsOwned()
   {
      return (EAttribute)termEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getFactor()
   {
      return factorEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getFactor_ValueOwned()
   {
      return (EReference)factorEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getFactor_ValueSdOwned()
   {
      return (EReference)factorEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_BinaryNumericOperatorOwned()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_UnaryNumericOperatorOwned()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_UnaryBooleanOperatorOwned()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_HasBinaryNumericOperator()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_HasUnaryNumericOperator()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getFactor_HasUnaryBooleanOperator()
   {
      return (EAttribute)factorEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getIntegerRange()
   {
      return integerRangeEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getIntegerRange_LowerIntegerValue()
   {
      return (EReference)integerRangeEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getIntegerRange_UpperIntegerValue()
   {
      return (EReference)integerRangeEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getIntegerValue()
   {
      return integerValueEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBehaviorTime()
   {
      return behaviorTimeEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBehaviorTime_IntegerValueOwned()
   {
      return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBehaviorTime_UnitIdentifier()
   {
      return (EAttribute)behaviorTimeEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getPropertyConstant()
   {
      return propertyConstantEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getPropertyValue()
   {
      return propertyValueEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getIdentifier()
   {
      return identifierEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getIdentifier_Id()
   {
      return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNumericLiteral()
   {
      return numericLiteralEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getNumericLiteral_NumValue()
   {
      return (EAttribute)numericLiteralEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBooleanLiteral()
   {
      return booleanLiteralEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getBooleanLiteral_BoolValue()
   {
      return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getStringLiteral()
   {
      return stringLiteralEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getStringLiteral_StringValue()
   {
      return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNumeral()
   {
      return numeralEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getNumeral_NumeralValue()
   {
      return (EAttribute)numeralEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getExecuteCondition()
   {
      return executeConditionEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getExecuteCondition_ValueExpression()
   {
      return (EReference)executeConditionEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getExecuteCondition_CatchTimeout()
   {
      return (EAttribute)executeConditionEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getCommActionParameter()
   {
      return commActionParameterEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getLogicalOperator()
   {
      return logicalOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getRelationalOperator()
   {
      return relationalOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getBinaryAddingOperator()
   {
      return binaryAddingOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getUnaryAddingOperator()
   {
      return unaryAddingOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getMultiplyingOperator()
   {
      return multiplyingOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getBinaryNumericOperator()
   {
      return binaryNumericOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getUnaryNumericOperator()
   {
      return unaryNumericOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EEnum getUnaryBooleanOperator()
   {
      return unaryBooleanOperatorEEnum;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EDataType getInteger()
   {
      return integerEDataType;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EDataType getReal()
   {
      return realEDataType;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EDataType getString()
   {
      return stringEDataType;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EDataType getBoolean()
   {
      return booleanEDataType;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public AadlBaFactory getAadlBaFactory()
   {
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
   public void createPackageContents()
   {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      elementEClass = createEClass(ELEMENT);
      createEReference(elementEClass, ELEMENT__BA_REFERENCED_ENTITY);
      createEReference(elementEClass, ELEMENT__AADL_REFERENCED_ENTITY);

      commentEClass = createEClass(COMMENT);
      createEAttribute(commentEClass, COMMENT__BODY);

      namedElementEClass = createEClass(NAMED_ELEMENT);
      createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
      createEAttribute(namedElementEClass, NAMED_ELEMENT__QUALIFIED_NAME);
      createEReference(namedElementEClass, NAMED_ELEMENT__NAMESPACE);

      namespaceEClass = createEClass(NAMESPACE);
      createEReference(namespaceEClass, NAMESPACE__OWNED_MEMBER);
      createEReference(namespaceEClass, NAMESPACE__MEMBER);

      globalNamespaceEClass = createEClass(GLOBAL_NAMESPACE);

      behaviorAnnexEClass = createEClass(BEHAVIOR_ANNEX);
      createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__VARIABLES);
      createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__STATES);
      createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__TRANSITIONS);

      uniqueComponentClassifierReferenceEClass = createEClass(UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);

      behaviorVariableEClass = createEClass(BEHAVIOR_VARIABLE);
      createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__LOCAL_VARIABLE_DECLARATORS);
      createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);
      createEAttribute(behaviorVariableEClass, BEHAVIOR_VARIABLE__PERSISTENT);

      behaviorStateEClass = createEClass(BEHAVIOR_STATE);
      createEReference(behaviorStateEClass, BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS);
      createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__INITIAL);
      createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__COMPLETE);
      createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__FINAL);

      behaviorTransitionEClass = createEClass(BEHAVIOR_TRANSITION);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER);
      createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__TIMEOUT);

      behaviorConditionEClass = createEClass(BEHAVIOR_CONDITION);

      declaratorEClass = createEClass(DECLARATOR);
      createEReference(declaratorEClass, DECLARATOR__ARRAY_SIZES);

      arraySizeEClass = createEClass(ARRAY_SIZE);
      createEReference(arraySizeEClass, ARRAY_SIZE__INTEGER_VALUE_CONSTANT);

      dispatchConditionEClass = createEClass(DISPATCH_CONDITION);
      createEAttribute(dispatchConditionEClass, DISPATCH_CONDITION__HAS_FROZEN_PORTS);
      createEReference(dispatchConditionEClass, DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION);
      createEReference(dispatchConditionEClass, DISPATCH_CONDITION__FROZEN_PORTS);

      dispatchLogicalExpressionEClass = createEClass(DISPATCH_LOGICAL_EXPRESSION);
      createEReference(dispatchLogicalExpressionEClass, DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS);
      createEAttribute(dispatchLogicalExpressionEClass, DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION);
      createEAttribute(dispatchLogicalExpressionEClass, DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION);
      createEAttribute(dispatchLogicalExpressionEClass, DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION);
      createEAttribute(dispatchLogicalExpressionEClass, DISPATCH_LOGICAL_EXPRESSION__STOP);

      dispatchTriggerEClass = createEClass(DISPATCH_TRIGGER);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__THE_BEHAVIOR_TIME);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__IDENTIFIER_OWNED);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__DISPATCH_TRIGGERS);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__NUMERAL_OWNED);
      createEReference(dispatchTriggerEClass, DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED);
      createEAttribute(dispatchTriggerEClass, DISPATCH_TRIGGER__NOT);
      createEAttribute(dispatchTriggerEClass, DISPATCH_TRIGGER__TIMEOUT);
      createEAttribute(dispatchTriggerEClass, DISPATCH_TRIGGER__OTHERS);
      createEAttribute(dispatchTriggerEClass, DISPATCH_TRIGGER__OR_MORE);
      createEAttribute(dispatchTriggerEClass, DISPATCH_TRIGGER__OR_LESS);

      behaviorActionsEClass = createEClass(BEHAVIOR_ACTIONS);
      createEReference(behaviorActionsEClass, BEHAVIOR_ACTIONS__BEHAVIOR_ACTION);
      createEAttribute(behaviorActionsEClass, BEHAVIOR_ACTIONS__SEQUENCE);
      createEAttribute(behaviorActionsEClass, BEHAVIOR_ACTIONS__SET);

      behaviorActionEClass = createEClass(BEHAVIOR_ACTION);
      createEReference(behaviorActionEClass, BEHAVIOR_ACTION__BASIC_ACTION_OWNED);
      createEReference(behaviorActionEClass, BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED);
      createEReference(behaviorActionEClass, BEHAVIOR_ACTION__COND_STATEMENT_OWNED);
      createEAttribute(behaviorActionEClass, BEHAVIOR_ACTION__BASIC_ACTION);
      createEAttribute(behaviorActionEClass, BEHAVIOR_ACTION__IF);
      createEAttribute(behaviorActionEClass, BEHAVIOR_ACTION__FOR);
      createEAttribute(behaviorActionEClass, BEHAVIOR_ACTION__WHILE);
      createEAttribute(behaviorActionEClass, BEHAVIOR_ACTION__DO_UNTIL);
      createEReference(behaviorActionEClass, BEHAVIOR_ACTION__TIMEOUT);

      condStatementEClass = createEClass(COND_STATEMENT);

      basicActionEClass = createEClass(BASIC_ACTION);

      ifStatementEClass = createEClass(IF_STATEMENT);
      createEAttribute(ifStatementEClass, IF_STATEMENT__HAS_ELSE);
      createEReference(ifStatementEClass, IF_STATEMENT__VALUE_EXPRESSION_OWNED);
      createEReference(ifStatementEClass, IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

      forOrForAllStatementEClass = createEClass(FOR_OR_FOR_ALL_STATEMENT);
      createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF);
      createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED);
      createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED);
      createEAttribute(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__FOR_ALL);

      whileStatementEClass = createEClass(WHILE_STATEMENT);
      createEReference(whileStatementEClass, WHILE_STATEMENT__VALUE_EXPRESSION_OWNED);
      createEReference(whileStatementEClass, WHILE_STATEMENT__BEHAVIOR_ACTIONS_OWNED);

      doUntilStatementEClass = createEClass(DO_UNTIL_STATEMENT);
      createEReference(doUntilStatementEClass, DO_UNTIL_STATEMENT__BEHAVIOR_ACTIONS_OWNED);
      createEReference(doUntilStatementEClass, DO_UNTIL_STATEMENT__VALUE_EXPRESSION_OWNED);

      elementValuesEClass = createEClass(ELEMENT_VALUES);

      assignmentActionEClass = createEClass(ASSIGNMENT_ACTION);
      createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__TARGET_OWNED);
      createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED);
      createEAttribute(assignmentActionEClass, ASSIGNMENT_ACTION__ANY);

      communicationActionEClass = createEClass(COMMUNICATION_ACTION);
      createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__ACTION_TYPE);
      createEReference(communicationActionEClass, COMMUNICATION_ACTION__ELT_NAME_OWNED);
      createEReference(communicationActionEClass, COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED);
      createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION);
      createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__HAS_TARGET);
      createEReference(communicationActionEClass, COMMUNICATION_ACTION__VALUE_EXPR_OWNED);
      createEReference(communicationActionEClass, COMMUNICATION_ACTION__TAR_OWNED);
      createEReference(communicationActionEClass, COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE);
      createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__CATCH_TIMEOUT);
      createEAttribute(communicationActionEClass, COMMUNICATION_ACTION__ALL);

      subprogramParameterListEClass = createEClass(SUBPROGRAM_PARAMETER_LIST);
      createEReference(subprogramParameterListEClass, SUBPROGRAM_PARAMETER_LIST__PARAMETER_LIST);

      timedActionEClass = createEClass(TIMED_ACTION);
      createEReference(timedActionEClass, TIMED_ACTION__BEHAVIOR_TIMES_OWNED);
      createEAttribute(timedActionEClass, TIMED_ACTION__COMPUTATION);

      targetEClass = createEClass(TARGET);
      createEReference(targetEClass, TARGET__ELEMENT_NAME_OWNED);
      createEReference(targetEClass, TARGET__DATA_COMPONENT_REFERENCE_OWNED);

      parameterLabelEClass = createEClass(PARAMETER_LABEL);

      dataComponentReferenceEClass = createEClass(DATA_COMPONENT_REFERENCE);
      createEReference(dataComponentReferenceEClass, DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED);

      nameEClass = createEClass(NAME);
      createEReference(nameEClass, NAME__ARRAY_INDEX_LIST_OWNED);
      createEReference(nameEClass, NAME__IDENTIFIER);

      arrayIndexEClass = createEClass(ARRAY_INDEX);
      createEReference(arrayIndexEClass, ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED);

      valueEClass = createEClass(VALUE);

      valueVariableEClass = createEClass(VALUE_VARIABLE);
      createEReference(valueVariableEClass, VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED);
      createEAttribute(valueVariableEClass, VALUE_VARIABLE__INTERROGATION);
      createEAttribute(valueVariableEClass, VALUE_VARIABLE__COUNT);
      createEAttribute(valueVariableEClass, VALUE_VARIABLE__FRESH);
      createEAttribute(valueVariableEClass, VALUE_VARIABLE__HAS_DATA_CPT_REF);
      createEReference(valueVariableEClass, VALUE_VARIABLE__ELEMENT_NAME_OWNED);

      valueConstantEClass = createEClass(VALUE_CONSTANT);

      valueExpressionEClass = createEClass(VALUE_EXPRESSION);
      createEReference(valueExpressionEClass, VALUE_EXPRESSION__RELATIONS_OWNED);
      createEAttribute(valueExpressionEClass, VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED);
      createEAttribute(valueExpressionEClass, VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR);

      relationEClass = createEClass(RELATION);
      createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_OWNED);
      createEReference(relationEClass, RELATION__SIMPLE_EXPRESSION_SD_OWNED);
      createEAttribute(relationEClass, RELATION__RELATIONAL_OPERATOR_OWNED);
      createEAttribute(relationEClass, RELATION__HAS_RELATIONAL_OPERATOR);

      simpleExpressionEClass = createEClass(SIMPLE_EXPRESSION);
      createEReference(simpleExpressionEClass, SIMPLE_EXPRESSION__TERMS_OWNED);
      createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED);
      createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR);
      createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED);
      createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR);

      termEClass = createEClass(TERM);
      createEReference(termEClass, TERM__FACTORS_OWNED);
      createEAttribute(termEClass, TERM__HAS_MULTIPLYING_OPERATOR);
      createEAttribute(termEClass, TERM__MULTIPLYING_OPERATORS_OWNED);

      factorEClass = createEClass(FACTOR);
      createEReference(factorEClass, FACTOR__VALUE_OWNED);
      createEReference(factorEClass, FACTOR__VALUE_SD_OWNED);
      createEAttribute(factorEClass, FACTOR__BINARY_NUMERIC_OPERATOR_OWNED);
      createEAttribute(factorEClass, FACTOR__UNARY_NUMERIC_OPERATOR_OWNED);
      createEAttribute(factorEClass, FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED);
      createEAttribute(factorEClass, FACTOR__HAS_BINARY_NUMERIC_OPERATOR);
      createEAttribute(factorEClass, FACTOR__HAS_UNARY_NUMERIC_OPERATOR);
      createEAttribute(factorEClass, FACTOR__HAS_UNARY_BOOLEAN_OPERATOR);

      integerRangeEClass = createEClass(INTEGER_RANGE);
      createEReference(integerRangeEClass, INTEGER_RANGE__LOWER_INTEGER_VALUE);
      createEReference(integerRangeEClass, INTEGER_RANGE__UPPER_INTEGER_VALUE);

      integerValueEClass = createEClass(INTEGER_VALUE);

      behaviorTimeEClass = createEClass(BEHAVIOR_TIME);
      createEReference(behaviorTimeEClass, BEHAVIOR_TIME__INTEGER_VALUE_OWNED);
      createEAttribute(behaviorTimeEClass, BEHAVIOR_TIME__UNIT_IDENTIFIER);

      propertyConstantEClass = createEClass(PROPERTY_CONSTANT);

      propertyValueEClass = createEClass(PROPERTY_VALUE);

      identifierEClass = createEClass(IDENTIFIER);
      createEAttribute(identifierEClass, IDENTIFIER__ID);

      numericLiteralEClass = createEClass(NUMERIC_LITERAL);
      createEAttribute(numericLiteralEClass, NUMERIC_LITERAL__NUM_VALUE);

      booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
      createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__BOOL_VALUE);

      stringLiteralEClass = createEClass(STRING_LITERAL);
      createEAttribute(stringLiteralEClass, STRING_LITERAL__STRING_VALUE);

      numeralEClass = createEClass(NUMERAL);
      createEAttribute(numeralEClass, NUMERAL__NUMERAL_VALUE);

      executeConditionEClass = createEClass(EXECUTE_CONDITION);
      createEReference(executeConditionEClass, EXECUTE_CONDITION__VALUE_EXPRESSION);
      createEAttribute(executeConditionEClass, EXECUTE_CONDITION__CATCH_TIMEOUT);

      // Create enums
      commActionParameterEEnum = createEEnum(COMM_ACTION_PARAMETER);
      logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
      relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
      binaryAddingOperatorEEnum = createEEnum(BINARY_ADDING_OPERATOR);
      unaryAddingOperatorEEnum = createEEnum(UNARY_ADDING_OPERATOR);
      multiplyingOperatorEEnum = createEEnum(MULTIPLYING_OPERATOR);
      binaryNumericOperatorEEnum = createEEnum(BINARY_NUMERIC_OPERATOR);
      unaryNumericOperatorEEnum = createEEnum(UNARY_NUMERIC_OPERATOR);
      unaryBooleanOperatorEEnum = createEEnum(UNARY_BOOLEAN_OPERATOR);

      // Create data types
      integerEDataType = createEDataType(INTEGER);
      realEDataType = createEDataType(REAL);
      stringEDataType = createEDataType(STRING);
      booleanEDataType = createEDataType(BOOLEAN);
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
      elementEClass.getESuperTypes().add(theAadl2Package.getElement());
      commentEClass.getESuperTypes().add(this.getElement());
      namedElementEClass.getESuperTypes().add(this.getElement());
      namespaceEClass.getESuperTypes().add(this.getNamedElement());
      globalNamespaceEClass.getESuperTypes().add(this.getNamespace());
      behaviorAnnexEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
      behaviorAnnexEClass.getESuperTypes().add(this.getElement());
      uniqueComponentClassifierReferenceEClass.getESuperTypes().add(this.getNamedElement());
      behaviorVariableEClass.getESuperTypes().add(this.getElement());
      behaviorStateEClass.getESuperTypes().add(this.getElement());
      behaviorTransitionEClass.getESuperTypes().add(this.getElement());
      behaviorConditionEClass.getESuperTypes().add(this.getElement());
      declaratorEClass.getESuperTypes().add(this.getNamedElement());
      arraySizeEClass.getESuperTypes().add(this.getElement());
      dispatchConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
      dispatchLogicalExpressionEClass.getESuperTypes().add(this.getElement());
      dispatchTriggerEClass.getESuperTypes().add(this.getElement());
      behaviorActionsEClass.getESuperTypes().add(this.getElement());
      behaviorActionEClass.getESuperTypes().add(this.getElement());
      condStatementEClass.getESuperTypes().add(this.getElement());
      basicActionEClass.getESuperTypes().add(this.getElement());
      ifStatementEClass.getESuperTypes().add(this.getElement());
      ifStatementEClass.getESuperTypes().add(this.getCondStatement());
      forOrForAllStatementEClass.getESuperTypes().add(this.getNamedElement());
      forOrForAllStatementEClass.getESuperTypes().add(this.getCondStatement());
      whileStatementEClass.getESuperTypes().add(this.getCondStatement());
      doUntilStatementEClass.getESuperTypes().add(this.getCondStatement());
      elementValuesEClass.getESuperTypes().add(this.getElement());
      assignmentActionEClass.getESuperTypes().add(this.getBasicAction());
      communicationActionEClass.getESuperTypes().add(this.getBasicAction());
      subprogramParameterListEClass.getESuperTypes().add(this.getElement());
      timedActionEClass.getESuperTypes().add(this.getBasicAction());
      targetEClass.getESuperTypes().add(this.getParameterLabel());
      parameterLabelEClass.getESuperTypes().add(this.getElement());
      dataComponentReferenceEClass.getESuperTypes().add(this.getElement());
      dataComponentReferenceEClass.getESuperTypes().add(this.getElementValues());
      nameEClass.getESuperTypes().add(this.getNamedElement());
      nameEClass.getESuperTypes().add(this.getElementValues());
      arrayIndexEClass.getESuperTypes().add(this.getElement());
      valueEClass.getESuperTypes().add(this.getElement());
      valueVariableEClass.getESuperTypes().add(this.getValue());
      valueVariableEClass.getESuperTypes().add(this.getIntegerValue());
      valueConstantEClass.getESuperTypes().add(this.getValue());
      valueConstantEClass.getESuperTypes().add(this.getIntegerValue());
      valueExpressionEClass.getESuperTypes().add(this.getValue());
      valueExpressionEClass.getESuperTypes().add(this.getParameterLabel());
      relationEClass.getESuperTypes().add(this.getElement());
      simpleExpressionEClass.getESuperTypes().add(this.getElement());
      termEClass.getESuperTypes().add(this.getElement());
      factorEClass.getESuperTypes().add(this.getElement());
      integerRangeEClass.getESuperTypes().add(this.getElement());
      integerRangeEClass.getESuperTypes().add(this.getElementValues());
      integerValueEClass.getESuperTypes().add(this.getElement());
      behaviorTimeEClass.getESuperTypes().add(this.getElement());
      propertyConstantEClass.getESuperTypes().add(this.getNamedElement());
      propertyConstantEClass.getESuperTypes().add(this.getValueConstant());
      propertyValueEClass.getESuperTypes().add(this.getNamedElement());
      propertyValueEClass.getESuperTypes().add(this.getValueConstant());
      identifierEClass.getESuperTypes().add(this.getElement());
      numericLiteralEClass.getESuperTypes().add(this.getValueConstant());
      booleanLiteralEClass.getESuperTypes().add(this.getValueConstant());
      stringLiteralEClass.getESuperTypes().add(this.getValueConstant());
      numeralEClass.getESuperTypes().add(this.getElement());
      executeConditionEClass.getESuperTypes().add(this.getBehaviorCondition());

      // Initialize classes and features; add operations and parameters
      initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getElement_BaReferencedEntity(), this.getElement(), null, "BaReferencedEntity", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getElement_AadlReferencedEntity(), theAadl2Package.getElement(), null, "AadlReferencedEntity", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getComment_Body(), this.getString(), "body", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

      initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNamedElement_Name(), this.getString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
      initEAttribute(getNamedElement_QualifiedName(), this.getString(), "qualifiedName", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
      initEReference(getNamedElement_Namespace(), this.getNamespace(), this.getNamespace_OwnedMember(), "namespace", null, 0, 1, NamedElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

      EOperation op = addEOperation(namedElementEClass, ecorePackage.getEBoolean(), "has_no_qualified_name", 0, 1, IS_UNIQUE, IS_ORDERED);
      addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
      EGenericType g1 = createEGenericType(ecorePackage.getEMap());
      EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

      op = addEOperation(namedElementEClass, ecorePackage.getEBoolean(), "has_qualified_name", 0, 1, IS_UNIQUE, IS_ORDERED);
      addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
      g1 = createEGenericType(ecorePackage.getEMap());
      g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

      addEOperation(namedElementEClass, this.getNamespace(), "allNamespaces", 0, -1, IS_UNIQUE, IS_ORDERED);

      op = addEOperation(namedElementEClass, this.getBoolean(), "isDistinguishableFrom", 1, 1, IS_UNIQUE, !IS_ORDERED);
      addEParameter(op, this.getNamedElement(), "n", 1, 1, IS_UNIQUE, !IS_ORDERED);
      addEParameter(op, this.getNamespace(), "ns", 1, 1, IS_UNIQUE, !IS_ORDERED);

      addEOperation(namedElementEClass, this.getString(), "separator", 1, 1, IS_UNIQUE, !IS_ORDERED);

      initEClass(namespaceEClass, Namespace.class, "Namespace", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getNamespace_OwnedMember(), this.getNamedElement(), this.getNamedElement_Namespace(), "ownedMember", null, 0, -1, Namespace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
      initEReference(getNamespace_Member(), this.getNamedElement(), null, "member", null, 0, -1, Namespace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

      op = addEOperation(namespaceEClass, ecorePackage.getEBoolean(), "members_distinguishable", 0, 1, IS_UNIQUE, IS_ORDERED);
      addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
      g1 = createEGenericType(ecorePackage.getEMap());
      g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      g2 = createEGenericType(ecorePackage.getEJavaObject());
      g1.getETypeArguments().add(g2);
      addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

      op = addEOperation(namespaceEClass, this.getString(), "getNamesOfMember", 0, -1, IS_UNIQUE, !IS_ORDERED);
      addEParameter(op, this.getNamedElement(), "element", 1, 1, IS_UNIQUE, !IS_ORDERED);

      addEOperation(namespaceEClass, this.getBoolean(), "membersAreDistinguishable", 1, 1, IS_UNIQUE, !IS_ORDERED);

      initEClass(globalNamespaceEClass, GlobalNamespace.class, "GlobalNamespace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(behaviorAnnexEClass, BehaviorAnnex.class, "BehaviorAnnex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorAnnex_Variables(), this.getBehaviorVariable(), null, "Variables", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorAnnex_States(), this.getBehaviorState(), null, "States", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorAnnex_Transitions(), this.getBehaviorTransition(), null, "Transitions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(uniqueComponentClassifierReferenceEClass, UniqueComponentClassifierReference.class, "UniqueComponentClassifierReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(behaviorVariableEClass, BehaviorVariable.class, "BehaviorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorVariable_LocalVariableDeclarators(), this.getDeclarator(), null, "LocalVariableDeclarators", null, 1, -1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorVariable_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "DataUniqueComponentClassifierReference", null, 1, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorVariable_Persistent(), this.getBoolean(), "Persistent", "False", 0, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(behaviorStateEClass, BehaviorState.class, "BehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorState_BehaviorStateIdentifiers(), this.getIdentifier(), null, "BehaviorStateIdentifiers", null, 1, -1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorState_Initial(), this.getBoolean(), "Initial", "False", 0, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorState_Complete(), this.getBoolean(), "Complete", "False", 0, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorState_Final(), this.getBoolean(), "Final", "False", 0, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(behaviorTransitionEClass, BehaviorTransition.class, "BehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorTransition_SourceStateIdentifiers(), this.getIdentifier(), null, "SourceStateIdentifiers", null, 0, -1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_BehaviorConditionOwned(), this.getBehaviorCondition(), null, "BehaviorConditionOwned", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_BehaviorTransitionPriority(), this.getNumeral(), null, "BehaviorTransitionPriority", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_DestinationStateIdentifier(), this.getIdentifier(), null, "DestinationStateIdentifier", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_TransitionIdentifier(), this.getIdentifier(), null, "TransitionIdentifier", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorTransition_Timeout(), this.getBehaviorTime(), null, "Timeout", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(behaviorConditionEClass, BehaviorCondition.class, "BehaviorCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(declaratorEClass, Declarator.class, "Declarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getDeclarator_ArraySizes(), this.getArraySize(), null, "ArraySizes", null, 0, -1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(arraySizeEClass, ArraySize.class, "ArraySize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getArraySize_IntegerValueConstant(), this.getValueConstant(), null, "IntegerValueConstant", null, 0, 1, ArraySize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(dispatchConditionEClass, DispatchCondition.class, "DispatchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getDispatchCondition_HasFrozenPorts(), this.getBoolean(), "hasFrozenPorts", "False", 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchCondition_TheDispatchLogicalExpression(), this.getDispatchLogicalExpression(), null, "TheDispatchLogicalExpression", null, 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchCondition_FrozenPorts(), this.getIdentifier(), null, "FrozenPorts", null, 0, -1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(dispatchLogicalExpressionEClass, DispatchLogicalExpression.class, "DispatchLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getDispatchLogicalExpression_DispatchTriggers(), this.getDispatchTrigger(), null, "DispatchTriggers", null, 0, -1, DispatchLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchLogicalExpression_OrExpression(), this.getBoolean(), "OrExpression", "False", 0, 1, DispatchLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchLogicalExpression_AndExpression(), this.getBoolean(), "AndExpression", "False", 0, 1, DispatchLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchLogicalExpression_XorExpression(), this.getBoolean(), "XorExpression", "False", 0, 1, DispatchLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchLogicalExpression_Stop(), this.getBoolean(), "Stop", "False", 0, 1, DispatchLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(dispatchTriggerEClass, DispatchTrigger.class, "DispatchTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getDispatchTrigger_TheDispatchLogicalExpression(), this.getDispatchLogicalExpression(), null, "TheDispatchLogicalExpression", null, 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchTrigger_TheBehaviorTime(), this.getBehaviorTime(), null, "TheBehaviorTime", null, 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchTrigger_IdentifierOwned(), this.getIdentifier(), null, "IdentifierOwned", null, 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchTrigger_DispatchTriggers(), this.getDispatchTrigger(), null, "DispatchTriggers", null, 0, -1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchTrigger_NumeralOwned(), this.getNumeral(), null, "NumeralOwned", null, 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDispatchTrigger_ValueConstantOwned(), this.getValueConstant(), null, "ValueConstantOwned", null, 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchTrigger_Not(), this.getBoolean(), "Not", "False", 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchTrigger_Timeout(), this.getBoolean(), "Timeout", "False", 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchTrigger_Others(), this.getBoolean(), "Others", "False", 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchTrigger_OrMore(), this.getBoolean(), "OrMore", "False", 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getDispatchTrigger_OrLess(), this.getBoolean(), "OrLess", "False", 0, 1, DispatchTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(behaviorActionsEClass, BehaviorActions.class, "BehaviorActions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorActions_BehaviorAction(), this.getBehaviorAction(), null, "BehaviorAction", null, 0, -1, BehaviorActions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorActions_Sequence(), this.getBoolean(), "Sequence", "false", 0, 1, BehaviorActions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorActions_Set(), this.getBoolean(), "Set", "false", 0, 1, BehaviorActions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(behaviorActionEClass, BehaviorAction.class, "BehaviorAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorAction_BasicActionOwned(), this.getBasicAction(), null, "BasicActionOwned", null, 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorAction_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorAction_CondStatementOwned(), this.getCondStatement(), null, "CondStatementOwned", null, 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorAction_BasicAction(), this.getBoolean(), "BasicAction", "False", 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorAction_If(), this.getBoolean(), "If", "False", 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorAction_For(), this.getBoolean(), "For", "False", 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorAction_While(), this.getBoolean(), "While", "False", 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorAction_DoUntil(), this.getBoolean(), "DoUntil", "False", 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBehaviorAction_Timeout(), this.getBehaviorTime(), null, "Timeout", null, 0, 1, BehaviorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(condStatementEClass, CondStatement.class, "CondStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(basicActionEClass, BasicAction.class, "BasicAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getIfStatement_HasElse(), this.getBoolean(), "hasElse", "False", 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getIfStatement_ValueExpressionOwned(), this.getValueExpression(), null, "ValueExpressionOwned", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getIfStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(forOrForAllStatementEClass, ForOrForAllStatement.class, "ForOrForAllStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getForOrForAllStatement_DataUniqueCmtClassRef(), this.getUniqueComponentClassifierReference(), null, "DataUniqueCmtClassRef", null, 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getForOrForAllStatement_ElementValuesOwned(), this.getElementValues(), null, "ElementValuesOwned", null, 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getForOrForAllStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getForOrForAllStatement_ForAll(), this.getBoolean(), "ForAll", "False", 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getWhileStatement_ValueExpressionOwned(), this.getValueExpression(), null, "ValueExpressionOwned", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getWhileStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(doUntilStatementEClass, DoUntilStatement.class, "DoUntilStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getDoUntilStatement_BehaviorActionsOwned(), this.getBehaviorActions(), null, "BehaviorActionsOwned", null, 0, 1, DoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDoUntilStatement_ValueExpressionOwned(), this.getValueExpression(), null, "ValueExpressionOwned", null, 0, 1, DoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(elementValuesEClass, ElementValues.class, "ElementValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(assignmentActionEClass, AssignmentAction.class, "AssignmentAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getAssignmentAction_TargetOwned(), this.getTarget(), null, "TargetOwned", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getAssignmentAction_ValueExpressionOwned(), this.getValueExpression(), null, "ValueExpressionOwned", null, 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getAssignmentAction_Any(), this.getBoolean(), "Any", "False", 0, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(communicationActionEClass, CommunicationAction.class, "CommunicationAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getCommunicationAction_ActionType(), this.getCommActionParameter(), "ActionType", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCommunicationAction_EltNameOwned(), this.getName_(), null, "EltNameOwned", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCommunicationAction_SubpgmParamListOwned(), this.getSubprogramParameterList(), null, "SubpgmParamListOwned", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getCommunicationAction_HasValueExpression(), this.getBoolean(), "hasValueExpression", "False", 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getCommunicationAction_HasTarget(), this.getBoolean(), "hasTarget", "False", 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCommunicationAction_ValueExprOwned(), this.getValueExpression(), null, "ValueExprOwned", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCommunicationAction_TarOwned(), this.getTarget(), null, "TarOwned", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getCommunicationAction_DataUniqueComponentClassifierReference(), this.getUniqueComponentClassifierReference(), null, "DataUniqueComponentClassifierReference", null, 1, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getCommunicationAction_CatchTimeout(), this.getBoolean(), "CatchTimeout", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getCommunicationAction_All(), this.getBoolean(), "All", null, 0, 1, CommunicationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(subprogramParameterListEClass, SubprogramParameterList.class, "SubprogramParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getSubprogramParameterList_ParameterList(), this.getParameterLabel(), null, "ParameterList", null, 0, -1, SubprogramParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(timedActionEClass, TimedAction.class, "TimedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getTimedAction_BehaviorTimesOwned(), this.getBehaviorTime(), null, "BehaviorTimesOwned", null, 0, -1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getTimedAction_Computation(), this.getBoolean(), "Computation", "False", 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getTarget_ElementNameOwned(), this.getName_(), null, "ElementNameOwned", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getTarget_DataComponentReferenceOwned(), this.getDataComponentReference(), null, "DataComponentReferenceOwned", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(parameterLabelEClass, ParameterLabel.class, "ParameterLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(dataComponentReferenceEClass, DataComponentReference.class, "DataComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getDataComponentReference_ElementsNameOwned(), this.getName_(), null, "ElementsNameOwned", null, 0, -1, DataComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getName_ArrayIndexListOwned(), this.getArrayIndex(), null, "ArrayIndexListOwned", null, 0, -1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getName_Identifier(), this.getIdentifier(), null, "Identifier", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(arrayIndexEClass, ArrayIndex.class, "ArrayIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getArrayIndex_IntegerValueVariableOwned(), this.getValueVariable(), null, "IntegerValueVariableOwned", null, 0, 1, ArrayIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(valueVariableEClass, ValueVariable.class, "ValueVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getValueVariable_DataComponentReferenceOwned(), this.getDataComponentReference(), null, "DataComponentReferenceOwned", null, 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueVariable_Interrogation(), this.getBoolean(), "Interrogation", "False", 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueVariable_Count(), this.getBoolean(), "Count", "False", 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueVariable_Fresh(), this.getBoolean(), "Fresh", "False", 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueVariable_HasDataCptRef(), this.getBoolean(), "hasDataCptRef", "False", 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getValueVariable_ElementNameOwned(), this.getName_(), null, "ElementNameOwned", null, 0, 1, ValueVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(valueConstantEClass, ValueConstant.class, "ValueConstant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(valueExpressionEClass, ValueExpression.class, "ValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getValueExpression_RelationsOwned(), this.getRelation(), null, "RelationsOwned", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueExpression_LogicalOperatorsOwned(), this.getLogicalOperator(), "LogicalOperatorsOwned", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getValueExpression_HasLogicalOperator(), this.getBoolean(), "hasLogicalOperator", "False", 0, 1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRelation_SimpleExpressionOwned(), this.getSimpleExpression(), null, "SimpleExpressionOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRelation_SimpleExpressionSdOwned(), this.getSimpleExpression(), null, "SimpleExpressionSdOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getRelation_RelationalOperatorOwned(), this.getRelationalOperator(), "RelationalOperatorOwned", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getRelation_HasRelationalOperator(), this.getBoolean(), "hasRelationalOperator", "False", 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(simpleExpressionEClass, SimpleExpression.class, "SimpleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getSimpleExpression_TermsOwned(), this.getTerm(), null, "TermsOwned", null, 0, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getSimpleExpression_UnaryAddingOperatorOwned(), this.getUnaryAddingOperator(), "UnaryAddingOperatorOwned", null, 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getSimpleExpression_HasUnaryAddingOperator(), this.getBoolean(), "hasUnaryAddingOperator", "False", 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getSimpleExpression_BinaryAddingOperatorOwned(), this.getBinaryAddingOperator(), "BinaryAddingOperatorOwned", null, 0, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getSimpleExpression_HasBinaryAddingOperator(), this.getBoolean(), "hasBinaryAddingOperator", "False", 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getTerm_FactorsOwned(), this.getFactor(), null, "FactorsOwned", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getTerm_HasMultiplyingOperator(), this.getBoolean(), "hasMultiplyingOperator", "False", 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getTerm_MultiplyingOperatorsOwned(), this.getMultiplyingOperator(), "MultiplyingOperatorsOwned", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(factorEClass, Factor.class, "Factor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getFactor_ValueOwned(), this.getValue(), null, "ValueOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getFactor_ValueSdOwned(), this.getValue(), null, "ValueSdOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_BinaryNumericOperatorOwned(), this.getBinaryNumericOperator(), "BinaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_UnaryNumericOperatorOwned(), this.getUnaryNumericOperator(), "UnaryNumericOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_UnaryBooleanOperatorOwned(), this.getUnaryBooleanOperator(), "UnaryBooleanOperatorOwned", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_HasBinaryNumericOperator(), this.getBoolean(), "hasBinaryNumericOperator", "False", 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_HasUnaryNumericOperator(), this.getBoolean(), "hasUnaryNumericOperator", "False", 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getFactor_HasUnaryBooleanOperator(), this.getBoolean(), "hasUnaryBooleanOperator", "False", 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(integerRangeEClass, IntegerRange.class, "IntegerRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getIntegerRange_LowerIntegerValue(), this.getIntegerValue(), null, "LowerIntegerValue", null, 0, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getIntegerRange_UpperIntegerValue(), this.getIntegerValue(), null, "UpperIntegerValue", null, 0, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(behaviorTimeEClass, BehaviorTime.class, "BehaviorTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBehaviorTime_IntegerValueOwned(), this.getIntegerValue(), null, "IntegerValueOwned", null, 0, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getBehaviorTime_UnitIdentifier(), this.getString(), "UnitIdentifier", null, 0, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(propertyConstantEClass, PropertyConstant.class, "PropertyConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(propertyValueEClass, PropertyValue.class, "PropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getIdentifier_Id(), this.getString(), "Id", "", 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNumericLiteral_NumValue(), this.getString(), "NumValue", "", 0, 1, NumericLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getBooleanLiteral_BoolValue(), this.getBoolean(), "BoolValue", "false", 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getStringLiteral_StringValue(), this.getString(), "StringValue", "", 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(numeralEClass, Numeral.class, "Numeral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNumeral_NumeralValue(), this.getInteger(), "NumeralValue", "-1", 0, 1, Numeral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(executeConditionEClass, ExecuteCondition.class, "ExecuteCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getExecuteCondition_ValueExpression(), this.getValueExpression(), null, "ValueExpression", null, 0, 1, ExecuteCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getExecuteCondition_CatchTimeout(), this.getBoolean(), "CatchTimeout", null, 0, 1, ExecuteCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Initialize enums and add enum literals
      initEEnum(commActionParameterEEnum, CommActionParameter.class, "CommActionParameter");
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.NONE);
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.EXCLAMATION);
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.LEFT_LEFT);
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.INTERROGATION);
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.EXCLAMATION_LEFT);
      addEEnumLiteral(commActionParameterEEnum, CommActionParameter.EXCLAMATION_RIGHT);

      initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
      addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
      addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);
      addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.XOR);

      initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUAL);
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_OR_EQUAL_THAN);
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
      addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_OR_EQUAL_THAN);

      initEEnum(binaryAddingOperatorEEnum, BinaryAddingOperator.class, "BinaryAddingOperator");
      addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.PLUS);
      addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.MINUS);

      initEEnum(unaryAddingOperatorEEnum, UnaryAddingOperator.class, "UnaryAddingOperator");
      addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.PLUS);
      addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.MINUS);

      initEEnum(multiplyingOperatorEEnum, MultiplyingOperator.class, "MultiplyingOperator");
      addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MULTIPLY);
      addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.DIVIDE);
      addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MOD);
      addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.REM);

      initEEnum(binaryNumericOperatorEEnum, BinaryNumericOperator.class, "BinaryNumericOperator");
      addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.MULTIPLY_MULTIPLY);

      initEEnum(unaryNumericOperatorEEnum, UnaryNumericOperator.class, "UnaryNumericOperator");
      addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.ABS);

      initEEnum(unaryBooleanOperatorEEnum, UnaryBooleanOperator.class, "UnaryBooleanOperator");
      addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NOT);

      // Initialize data types
      initEDataType(integerEDataType, int.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
      initEDataType(realEDataType, double.class, "Real", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
      initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
      initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

      // Create resource
      createResource(eNS_URI);

      // Create annotations
      // http://www.topcased.org/documentation
      createDocumentationAnnotations();
      // http://www.eclipse.org/uml2/1.1.0/GenModel
      createGenModel_1Annotations();
      // subsets
      createSubsetsAnnotations();
      // union
      createUnionAnnotations();
   }

   /**
    * Initializes the annotations for <b>http://www.topcased.org/documentation</b>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void createDocumentationAnnotations()
   {
      String source = "http://www.topcased.org/documentation";		
      addAnnotation
        (integerEDataType, 
         source, 
         new String[] 
         {
          "documentation", "An integer is a primitive type representing integer values."
         });		
      addAnnotation
        (realEDataType, 
         source, 
         new String[] 
         {
          "documentation", "A real is a primitive type representing real numeric values."
         });		
      addAnnotation
        (stringEDataType, 
         source, 
         new String[] 
         {
          "documentation", "A string is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters."
         });		
      addAnnotation
        (booleanEDataType, 
         source, 
         new String[] 
         {
          "documentation", "A Boolean type is used for logical expression, consisting of the predefined values true and false."
         });					
      addAnnotation
        (getComment_Body(), 
         source, 
         new String[] 
         {
          "documentation", "Specifies a string that is the comment"
         });																		
      addAnnotation
        (getNamedElement_Name(), 
         source, 
         new String[] 
         {
          "documentation", "The name of the NamedElement."
         });			
      addAnnotation
        (getNamedElement_Namespace(), 
         source, 
         new String[] 
         {
          "documentation", "Specifies the namespace that owns the NamedElement."
         });														
      addAnnotation
        (getNamespace_OwnedMember(), 
         source, 
         new String[] 
         {
          "documentation", "A collection of NamedElements owned by the Namespace."
         });				
      addAnnotation
        (getNamespace_Member(), 
         source, 
         new String[] 
         {
          "documentation", "A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance."
         });	
   }

   /**
    * Initializes the annotations for <b>http://www.eclipse.org/uml2/1.1.0/GenModel</b>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void createGenModel_1Annotations()
   {
      String source = "http://www.eclipse.org/uml2/1.1.0/GenModel";											
      addAnnotation
        (namedElementEClass.getEOperations().get(0), 
         source, 
         new String[] 
         {
          "body", "(self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()"
         });					
      addAnnotation
        (namedElementEClass.getEOperations().get(1), 
         source, 
         new String[] 
         {
          "body", "(self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) \r\nimplies \r\nself.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))"
         });						
      addAnnotation
        (namedElementEClass.getEOperations().get(2), 
         source, 
         new String[] 
         {
          "body", "if self.namespace->isEmpty() then \r\n  Sequence{}\r\nelse\r\n  self.namespace.allNamespaces()->prepend(self.namespace)\r\nendif"
         });			
      addAnnotation
        (namedElementEClass.getEOperations().get(3), 
         source, 
         new String[] 
         {
          "body", "if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then\r\n  ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()\r\nelse\r\n  true\r\nendif"
         });			
      addAnnotation
        (namedElementEClass.getEOperations().get(4), 
         source, 
         new String[] 
         {
          "body", "\'.\'"
         });							
      addAnnotation
        (namespaceEClass.getEOperations().get(0), 
         source, 
         new String[] 
         {
          "body", "membersAreDistinguishable()"
         });						
      addAnnotation
        (namespaceEClass.getEOperations().get(1), 
         source, 
         new String[] 
         {
          "body", "if member->includes(element) then\r\n  Set{}->including(element.name)\r\nelse\r\n  Set{}\r\nendif"
         });			
      addAnnotation
        (namespaceEClass.getEOperations().get(2), 
         source, 
         new String[] 
         {
          "body", "self.member->forAll( memb | self.member->excluding(memb)->forAll(other | memb.isDistinguishableFrom(other, self)))"
         });								
   }

   /**
    * Initializes the annotations for <b>subsets</b>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void createSubsetsAnnotations()
   {
      String source = "subsets";																																							
      addAnnotation
        (getNamespace_OwnedMember(), 
         source, 
         new String[] 
         {
         },
         new URI[] 
         {
          URI.createURI(eNS_URI).appendFragment("//Namespace/member")
         });						
   }

   /**
    * Initializes the annotations for <b>union</b>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void createUnionAnnotations()
   {
      String source = "union";																																								
      addAnnotation
        (getNamespace_OwnedMember(), 
         source, 
         new String[] 
         {
         });				
      addAnnotation
        (getNamespace_Member(), 
         source, 
         new String[] 
         {
         });		
   }

} //AadlBaPackageImpl
