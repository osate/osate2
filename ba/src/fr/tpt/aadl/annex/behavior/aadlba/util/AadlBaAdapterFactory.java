/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.util;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.ModalElement;

import fr.tpt.aadl.annex.behavior.aadlba.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaAdapterFactory extends AdapterFactoryImpl
{
   /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected static AadlBaPackage modelPackage;

   /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public AadlBaAdapterFactory()
   {
		if (modelPackage == null) {
			modelPackage = AadlBaPackage.eINSTANCE;
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
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
   protected AadlBaSwitch<Adapter> modelSwitch =
      new AadlBaSwitch<Adapter>() {
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			@Override
			public Adapter caseGlobalNamespace(GlobalNamespace object) {
				return createGlobalNamespaceAdapter();
			}
			@Override
			public Adapter caseBehaviorAnnex(BehaviorAnnex object) {
				return createBehaviorAnnexAdapter();
			}
			@Override
			public Adapter caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object) {
				return createUniqueComponentClassifierReferenceAdapter();
			}
			@Override
			public Adapter caseBehaviorVariable(BehaviorVariable object) {
				return createBehaviorVariableAdapter();
			}
			@Override
			public Adapter caseBehaviorState(BehaviorState object) {
				return createBehaviorStateAdapter();
			}
			@Override
			public Adapter caseBehaviorTransition(BehaviorTransition object) {
				return createBehaviorTransitionAdapter();
			}
			@Override
			public Adapter caseBehaviorCondition(BehaviorCondition object) {
				return createBehaviorConditionAdapter();
			}
			@Override
			public Adapter caseDeclarator(Declarator object) {
				return createDeclaratorAdapter();
			}
			@Override
			public Adapter caseArraySize(ArraySize object) {
				return createArraySizeAdapter();
			}
			@Override
			public Adapter caseDispatchCondition(DispatchCondition object) {
				return createDispatchConditionAdapter();
			}
			@Override
			public Adapter caseDispatchLogicalExpression(DispatchLogicalExpression object) {
				return createDispatchLogicalExpressionAdapter();
			}
			@Override
			public Adapter caseDispatchTrigger(DispatchTrigger object) {
				return createDispatchTriggerAdapter();
			}
			@Override
			public Adapter caseBehaviorActions(BehaviorActions object) {
				return createBehaviorActionsAdapter();
			}
			@Override
			public Adapter caseBehaviorAction(BehaviorAction object) {
				return createBehaviorActionAdapter();
			}
			@Override
			public Adapter caseCondStatement(CondStatement object) {
				return createCondStatementAdapter();
			}
			@Override
			public Adapter caseBasicAction(BasicAction object) {
				return createBasicActionAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseForOrForAllStatement(ForOrForAllStatement object) {
				return createForOrForAllStatementAdapter();
			}
			@Override
			public Adapter caseWhileStatement(WhileStatement object) {
				return createWhileStatementAdapter();
			}
			@Override
			public Adapter caseDoUntilStatement(DoUntilStatement object) {
				return createDoUntilStatementAdapter();
			}
			@Override
			public Adapter caseElementValues(ElementValues object) {
				return createElementValuesAdapter();
			}
			@Override
			public Adapter caseAssignmentAction(AssignmentAction object) {
				return createAssignmentActionAdapter();
			}
			@Override
			public Adapter caseCommunicationAction(CommunicationAction object) {
				return createCommunicationActionAdapter();
			}
			@Override
			public Adapter caseSubprogramParameterList(SubprogramParameterList object) {
				return createSubprogramParameterListAdapter();
			}
			@Override
			public Adapter caseTimedAction(TimedAction object) {
				return createTimedActionAdapter();
			}
			@Override
			public Adapter caseTarget(Target object) {
				return createTargetAdapter();
			}
			@Override
			public Adapter caseParameterLabel(ParameterLabel object) {
				return createParameterLabelAdapter();
			}
			@Override
			public Adapter caseDataComponentReference(DataComponentReference object) {
				return createDataComponentReferenceAdapter();
			}
			@Override
			public Adapter caseName(Name object) {
				return createNameAdapter();
			}
			@Override
			public Adapter caseArrayIndex(ArrayIndex object) {
				return createArrayIndexAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseValueVariable(ValueVariable object) {
				return createValueVariableAdapter();
			}
			@Override
			public Adapter caseValueConstant(ValueConstant object) {
				return createValueConstantAdapter();
			}
			@Override
			public Adapter caseValueExpression(ValueExpression object) {
				return createValueExpressionAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter caseSimpleExpression(SimpleExpression object) {
				return createSimpleExpressionAdapter();
			}
			@Override
			public Adapter caseTerm(Term object) {
				return createTermAdapter();
			}
			@Override
			public Adapter caseFactor(Factor object) {
				return createFactorAdapter();
			}
			@Override
			public Adapter caseIntegerRange(IntegerRange object) {
				return createIntegerRangeAdapter();
			}
			@Override
			public Adapter caseIntegerValue(IntegerValue object) {
				return createIntegerValueAdapter();
			}
			@Override
			public Adapter caseBehaviorTime(BehaviorTime object) {
				return createBehaviorTimeAdapter();
			}
			@Override
			public Adapter casePropertyConstant(PropertyConstant object) {
				return createPropertyConstantAdapter();
			}
			@Override
			public Adapter casePropertyValue(PropertyValue object) {
				return createPropertyValueAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseNumericLiteral(NumericLiteral object) {
				return createNumericLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseNumeral(Numeral object) {
				return createNumeralAdapter();
			}
			@Override
			public Adapter caseExecuteCondition(ExecuteCondition object) {
				return createExecuteConditionAdapter();
			}
			@Override
			public Adapter caseAadl2_Element(edu.cmu.sei.aadl.aadl2.Element object) {
				return createAadl2_ElementAdapter();
			}
			@Override
			public Adapter caseAadl2_NamedElement(edu.cmu.sei.aadl.aadl2.NamedElement object) {
				return createAadl2_NamedElementAdapter();
			}
			@Override
			public Adapter caseModalElement(ModalElement object) {
				return createModalElementAdapter();
			}
			@Override
			public Adapter caseAnnexSubclause(AnnexSubclause object) {
				return createAnnexSubclauseAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Element
	 * @generated
	 */
   public Adapter createElementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Comment
	 * @generated
	 */
   public Adapter createCommentAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NamedElement
	 * @generated
	 */
   public Adapter createNamedElementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Namespace
	 * @generated
	 */
   public Adapter createNamespaceAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace <em>Global Namespace</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.GlobalNamespace
	 * @generated
	 */
   public Adapter createGlobalNamespaceAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex <em>Behavior Annex</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex
	 * @generated
	 */
   public Adapter createBehaviorAnnexAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference <em>Unique Component Classifier Reference</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference
	 * @generated
	 */
   public Adapter createUniqueComponentClassifierReferenceAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable <em>Behavior Variable</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable
	 * @generated
	 */
   public Adapter createBehaviorVariableAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState <em>Behavior State</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState
	 * @generated
	 */
   public Adapter createBehaviorStateAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition
	 * @generated
	 */
   public Adapter createBehaviorTransitionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
	 * @generated
	 */
   public Adapter createBehaviorConditionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Declarator
	 * @generated
	 */
   public Adapter createDeclaratorAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize <em>Array Size</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ArraySize
	 * @generated
	 */
   public Adapter createArraySizeAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition <em>Dispatch Condition</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition
	 * @generated
	 */
   public Adapter createDispatchConditionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression <em>Dispatch Logical Expression</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression
	 * @generated
	 */
   public Adapter createDispatchLogicalExpressionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
	 * @generated
	 */
   public Adapter createDispatchTriggerAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
	 * @generated
	 */
   public Adapter createBehaviorActionsAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
	 * @generated
	 */
   public Adapter createBehaviorActionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
	 * @generated
	 */
   public Adapter createCondStatementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
	 * @generated
	 */
   public Adapter createBasicActionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement
	 * @generated
	 */
   public Adapter createIfStatementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement
	 * @generated
	 */
   public Adapter createForOrForAllStatementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.WhileStatement
	 * @generated
	 */
   public Adapter createWhileStatementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement <em>Do Until Statement</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement
	 * @generated
	 */
   public Adapter createDoUntilStatementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
	 * @generated
	 */
   public Adapter createElementValuesAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction <em>Assignment Action</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction
	 * @generated
	 */
   public Adapter createAssignmentActionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
	 * @generated
	 */
   public Adapter createCommunicationActionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList <em>Subprogram Parameter List</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList
	 * @generated
	 */
   public Adapter createSubprogramParameterListAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction <em>Timed Action</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction
	 * @generated
	 */
   public Adapter createTimedActionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Target
	 * @generated
	 */
   public Adapter createTargetAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
	 * @generated
	 */
   public Adapter createParameterLabelAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference
	 * @generated
	 */
   public Adapter createDataComponentReferenceAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Name
	 * @generated
	 */
   public Adapter createNameAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex <em>Array Index</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex
	 * @generated
	 */
   public Adapter createArrayIndexAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Value
	 * @generated
	 */
   public Adapter createValueAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
	 * @generated
	 */
   public Adapter createValueVariableAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
	 * @generated
	 */
   public Adapter createValueConstantAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression
	 * @generated
	 */
   public Adapter createValueExpressionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Relation
	 * @generated
	 */
   public Adapter createRelationAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression <em>Simple Expression</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression
	 * @generated
	 */
   public Adapter createSimpleExpressionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Term
	 * @generated
	 */
   public Adapter createTermAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Factor
	 * @generated
	 */
   public Adapter createFactorAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange <em>Integer Range</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange
	 * @generated
	 */
   public Adapter createIntegerRangeAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
	 * @generated
	 */
   public Adapter createIntegerValueAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime <em>Behavior Time</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime
	 * @generated
	 */
   public Adapter createBehaviorTimeAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant <em>Property Constant</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant
	 * @generated
	 */
   public Adapter createPropertyConstantAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.PropertyValue
	 * @generated
	 */
   public Adapter createPropertyValueAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Identifier
	 * @generated
	 */
   public Adapter createIdentifierAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
	 * @generated
	 */
   public Adapter createNumericLiteralAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral
	 * @generated
	 */
   public Adapter createBooleanLiteralAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.StringLiteral
	 * @generated
	 */
   public Adapter createStringLiteralAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral <em>Numeral</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.Numeral
	 * @generated
	 */
   public Adapter createNumeralAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
	 * @generated
	 */
   public Adapter createExecuteConditionAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.Element
	 * @generated
	 */
   public Adapter createAadl2_ElementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.NamedElement
	 * @generated
	 */
   public Adapter createAadl2_NamedElementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.ModalElement <em>Modal Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.ModalElement
	 * @generated
	 */
   public Adapter createModalElementAdapter()
   {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link edu.cmu.sei.aadl.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.cmu.sei.aadl.aadl2.AnnexSubclause
	 * @generated
	 */
   public Adapter createAnnexSubclauseAdapter()
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

} //AadlBaAdapterFactory
