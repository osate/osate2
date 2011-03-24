package fr.tpt.aadl.annex.behavior.unparser;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.FeatureMap;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.parsesupport.AObject;
import edu.cmu.sei.aadl.modelsupport.AadlConstants;
import edu.cmu.sei.aadl.modelsupport.UnparseText;
import fr.tpt.aadl.annex.behavior.aadlba.*;

import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch;

public class AadlBaUnparser {

	/**
	 * Aadlba switch which overrides methods to process unparsing
	 */
	protected AadlBaSwitch<String> aadlbaSwitch = null;

	/**
	 * The unparser buffer
	 */
	private UnparseText aadlbaText;

	/**
	 * 
	 */
	private String DONE = "DONE";

	/**
	 * List of element from the current model
	 */
	protected final EList<Element> resultList = new BasicEList<Element>();

	/**
	 * Inherits from Osate2 (not used for instance)
	 */
	private boolean notCancelled = true;


	/**
	 * Aadlba unparser constructor
	 * @param root : annexsubclause root
	 * @param indent : indentation position
	 */
	public AadlBaUnparser(AnnexSubclause root, String indent) {
		//TODO : FIXME : XXX : set indentation position
		aadlbaText = new UnparseText();
		this.initSwitches();
	}

	public AadlBaUnparser(String indent) {
		//TODO : FIXME : XXX : set indentation position
		aadlbaText = new UnparseText();
		this.initSwitches();
	}
	
	/**
	 * Constructor with default ;
	 */
	public AadlBaUnparser() {
		//TODO : FIXME : XXX : set indentation position
		aadlbaText = new UnparseText();
		this.initSwitches();
	}
	
	/**
	 * Calls the package-specific switch
	 */
	public final String process(Element theElement) {
		/**
		 * This checks to make sure we only invoke doSwitch with non-null
		 * objects This is necessary as some feature retrieval methods may
		 * return null
		 */
		if (theElement == null) {
			return null;
		}
		EClass theEClass = theElement.eClass();
		if (aadlbaSwitch != null && theEClass.eContainer() == AadlBaPackage.eINSTANCE)
			aadlbaSwitch.doSwitch(theElement);
		else 
			System.out.println("process aadlba switch failed");

		return this.getOutput();
	}

	/** 
	 * This method checks notCancelled() after each element in the
	 * list, and terminates the processing if the traversal has been cancelled.
	 */ 
	public final EList<Element> processEList(final EList<? extends Element> list) {
		for (Iterator<? extends Element> it = list.iterator(); notCancelled && it.hasNext();) {
			this.process(it.next());
		}
		return resultList;
	}

	/**
	 * Does processing of list with separators
	 * 
	 * @param list
	 * @param separator
	 */
	@SuppressWarnings("unchecked")
	public void processEList(EList list, String separator) {
		boolean first = true;
		for (Iterator it = list.iterator(); it.hasNext();) {
			if (!first) {
				if (separator == AadlConstants.newlineChar) {
					aadlbaText.addOutputNewline(AadlConstants.emptyString);
				} else {
					aadlbaText.addOutput(separator);
				}
			}
			first = false;
			Object o = it.next();
			if (o instanceof FeatureMap.Entry) {
				o = ((FeatureMap.Entry) o).getValue();
			}
			if (o instanceof AObject)
				this.process((Element) o);
			else if (o instanceof AbstractEnumerator)
				aadlbaText.addOutput(((AbstractEnumerator) o).getName()
						.toLowerCase());
			else
				aadlbaText.addOutput("processEList: oh my, oh my!!");
		}
	}

	/**
	 * Unparse comment
	 * 
	 * @param obj
	 */
	/*private void processComments(final Element obj) {
		if (obj != null) {
			EList el = obj.getOwnedComments();
			for (Iterator it = el.iterator(); it.hasNext();) {
				String comment = ((Comment) it.next()).getBody();
				if (!comment.startsWith("--") && !comment.startsWith("/*")) {
					comment = "--" + (comment.charAt(0) == ' ' ? "" : " ") + comment;
				} else if (comment.startsWith("/*")) {
					comment = comment.substring(2, comment.length() - 2);
					comment = "--" + (comment.charAt(0) == ' ' ? "" : " ") + comment;
					comment = comment.replaceAll("\n", "\n--");
				}
				aadlbaText.addOutputNewline(comment);
			}
		}
	}*/

	/**
	 * Returns the unparsed output as a single String
	 * 
	 * @return String
	 */
	public String getOutput() {
		return aadlbaText.getParseOutput();
	}

	/**
	 * Specific aadlba switch to unparse components
	 */
	protected void initSwitches() {

		aadlbaSwitch = new AadlBaSwitch<String>() {

			/**
			 * Top-level method to unparse "behavior_specification" 
			 * annexsubclause
			 */
			public String caseAnnexSubclause(AnnexSubclause object) {
				//FIXME : TODO : update location reference
				process((BehaviorAnnex) object);
				return DONE;
			}

			/**
			 * Unparse behaviorannex
			 */
			public String caseBehaviorAnnex(BehaviorAnnex object) {
				//FIXME : TODO : update location reference
				if (object.isSetBehaviorVariables()) {
					aadlbaText.addOutputNewline("variables");
					aadlbaText.incrementIndent();
					processEList(object.getBehaviorVariables());
					aadlbaText.decrementIndent();
				}
				if (object.isSetBehaviorStates()) {
					aadlbaText.addOutputNewline("states");
					aadlbaText.incrementIndent();
					processEList(object.getBehaviorStates());
					aadlbaText.decrementIndent();
				}
				if (object.isSetBehaviorTransitions()) {
					aadlbaText.addOutputNewline("transitions");
					aadlbaText.incrementIndent();
					processEList(object.getBehaviorTransitions());
					aadlbaText.decrementIndent();

				}				return DONE;
			}

			/**
			 * Unparse behaviorvariable
			 */
			public String caseBehaviorVariable(BehaviorVariable object) {
				//FIXME : TODO : update location reference
				processEList(object.getLocalVariableDeclarators(), ", ");
				aadlbaText.addOutput(" : ");
				process(object.getDataUniqueComponentClassifierReference());
				aadlbaText.addOutputNewline(" ;");
				return DONE;
			}

			/**
			 * Unparse declarators
			 */
			public String caseDeclarator(Declarator object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getIdentifierOwned().getId());
				return caseArraySize(object.getArraySizes());
			}

			/**
			 * Unparse arraysize
			 */
			public String caseArraySize(EList<IntegerValueConstant> arraySizes) {
				//FIXME : TODO : update location reference
				for(IntegerValueConstant ivc : arraySizes)
				{
					aadlbaText.addOutput("[");
					process(ivc);
					aadlbaText.addOutput("]");
				}
				return DONE;
			}

			/**
			 * Unparse uniquecomponentclassifierreference
			 */
			public String caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object) {
				return caseNamedElement(object) ;
			}
			
			public String caseNamedElement (NamedElement object)
			{
				aadlbaText.addOutput(object.getQualifiedName() );
				return DONE;
			}

			/**
			 * Unparse behaviorstate
			 */
			public String caseBehaviorState(BehaviorState object) {
				//FIXME : TODO : update location reference
				processEList(object.getIdentifiers(), ", ");
				aadlbaText.addOutput(" : ");
				if (object.isInitial())
					aadlbaText.addOutput("initial ");
				if (object.isComplete())
					aadlbaText.addOutput("complete ");
				if (object.isFinal())
					aadlbaText.addOutput("final ");
				aadlbaText.addOutputNewline("state ;");
				return DONE;
			}

			/**
			 * Unparse identifier
			 */
			public String caseIdentifier(Identifier object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getId());
				return DONE;
			}

			/**
			 * Unparse behaviortransition
			 */
			public String caseBehaviorTransition(BehaviorTransition object) {
				//FIXME : TODO : update location reference
				Identifier tid = object.getTransitionIdentifier();
				Numeral num = object.getBehaviorTransitionPriority();
				if (tid != null) {
					process(tid);
					if (num != null) {// numeral
						aadlbaText.addOutput(" [");
						aadlbaText.addOutput(String.valueOf(num.getValue()));
						aadlbaText.addOutput("]");
					}
					aadlbaText.addOutput(" : ");
				}
				processEList(object.getSourceStateIdentifiers(), ", ");
				aadlbaText.addOutput(" -[");
				process(object.getBehaviorConditionOwned());
				aadlbaText.addOutput("]-> ");
				process(object.getDestinationStateIdentifier());
				if (object.getBehaviorActionBlockOwned() != null) {
				   aadlbaText.addOutput(" ");
				   process(object.getBehaviorActionBlockOwned());
				}
				aadlbaText.addOutputNewline(" ;") ;
				
				return DONE;
			}
			
			public String caseTimeoutCatch(TimeoutCatch object)
			{
				aadlbaText.addOutput("timeout");
				return DONE;
			}
			
			public String caseOtherwise(Otherwise object) {
				aadlbaText.addOutput("otherwise");
				return DONE;
			}

			/**
			 * Unparse dispatchcondition
			 */
			public String caseDispatchCondition(DispatchCondition object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("on dispatch");
				if (object.getDispatchTriggerConditionOwned() != null) {
					aadlbaText.addOutput(" ") ;
					process(object.getDispatchTriggerConditionOwned());
				}
				
				if (object.isSetFrozenPorts()) {
					aadlbaText.addOutput(" frozen ");
					processEList(object.getFrozenPorts(), ", ");
				}
					
				return DONE;
			}

			public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object) {
				aadlbaText.addOutput("stop");
				return DONE;
			}

			public String caseCompletionRelativeTimeoutConditionAndCatch(CompletionRelativeTimeoutConditionAndCatch object) {
				aadlbaText.addOutput("timeout ") ;
				caseBehaviorTime(object) ;				
				return DONE;
			}
			
			public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object) {
				
				processEList(object.getDispatchConjunctions(), " or ") ;
				return DONE;
			}
			
			public String caseDispatchConjunction(DispatchConjunction object) {
				processEList(object.getDispatchTriggers(), " and ");
				return DONE;
			}
			
			public String caseBehaviorActionBlock (BehaviorActionBlock object) {
				aadlbaText.addOutput("{") ;
				process(object.getBehaviorActionsOwned());
				if(object.getBehaviorTimeOwned() != null)
				{
					aadlbaText.addOutput(" timeout ") ;
					process(object.getBehaviorTimeOwned());
				}
				aadlbaText.addOutput("}") ;
				return DONE ;
			}
			
			public String caseBehaviorActionSequence(BehaviorActionSequence object) {
				processEList(object.getBehaviorActions(), " ; ") ;
				return DONE;
			}
			
			public String caseBehaviorActionSet(BehaviorActionSet object) {
				processEList(object.getBehaviorActions(), " & ") ;
				return DONE;
			}
			
			/**
			 * Unparse ifstatement
			 */
			public String caseIfStatement(IfStatement object) {
				//FIXME : TODO : update location reference
				boolean first = true;
				EList<ValueExpression> lve = object.getLogicalValueExpressions();
				EList<BehaviorActions> lba = object.getBehaviorActionsOwned();
				
				for (ValueExpression ve : lve) {
					if (first) {
						first = false;
						aadlbaText.addOutput("if (");
					} else {
						aadlbaText.addOutput("elsif (");
					}
					process(ve);
					aadlbaText.addOutput(") ");
					process(lba.get(lve.indexOf(ve)));
					aadlbaText.addOutputNewline("");
				}
				if (object.isHasElse()) {
					aadlbaText.addOutput("else ");
					process(lba.get(lba.size()-1));
					aadlbaText.addOutputNewline("");
				}
				aadlbaText.addOutputNewline("end if");
				
				return DONE;
			}

			/**
			 * Unparse fororforallstatement
			 */
			public String caseForOrForAllStatement(ForOrForAllStatement object) {
				//FIXME : TODO : update location reference
				if (object.isForAll())
					aadlbaText.addOutput("forall (");
				else
					aadlbaText.addOutput("for (");
				process(object.getElementIdentifier());
    			aadlbaText.addOutput(" : ");
				process(object.getDataUniqueComponentClassifierReference());
				aadlbaText.addOutput(" in ");
				process(object.getElementValuesOwned());
				aadlbaText.addOutputNewline(")");
				aadlbaText.addOutputNewline("{");
				aadlbaText.incrementIndent();
				process(object.getBehaviorActionsOwned());
				aadlbaText.decrementIndent();
				aadlbaText.addOutputNewline("");
				aadlbaText.addOutputNewline("}");				
				return DONE;
			}

			public String caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object) {
				if(object.isDoUntil())
					return caseDoUntilStatement(object) ;
				else
					return caseWhileStatement(object) ;
			}

			/**
			 * Unparse whilestatement
			 */

			public String caseWhileStatement(WhileOrDoUntilStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("while (");
				process(object.getLogicalValueExpression());
				aadlbaText.addOutputNewline(")");
				aadlbaText.addOutputNewline("{");
				aadlbaText.incrementIndent();
				process(object.getBehaviorActionsOwned());
				aadlbaText.decrementIndent();
				aadlbaText.addOutputNewline("");
				aadlbaText.addOutputNewline("}");
				return DONE;	
			}
			
			/**
			 * Unparse dountilstatement
			 */
			public String caseDoUntilStatement(WhileOrDoUntilStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutputNewline("do");
				process(object.getBehaviorActionsOwned());
				aadlbaText.addOutputNewline("");
				aadlbaText.addOutput("until (");
				process(object.getLogicalValueExpression());
				aadlbaText.addOutputNewline(")");
				return DONE;
			}
			
			/**
			 * Unparse integerrange
			 */
			public String caseIntegerRange(IntegerRange object) {
				//FIXME : TODO : update location reference
				process(object.getLowerIntegerValue());
				aadlbaText.addOutput(" .. ");
				process(object.getUpperIntegerValue());
				return DONE;
			}
			
			/**
			 * Unparse timedaction
			 */
			public String caseTimedAction(TimedAction object) {
				aadlbaText.addOutput("computation (") ;
				process(object.getLowerBehaviorTime()) ;
				if(object.getUpperBehaviorTime() != null)
			    {
					aadlbaText.addOutput(" .. ") ;
					process(object.getUpperBehaviorTime()) ;
			    }
				aadlbaText.addOutput(")") ;
				return DONE;
			}
			
			/**
			 * Unparse assignmentaction
			 */
			public String caseAssignmentAction(AssignmentAction object) {
				//FIXME : TODO : update location reference
				process(object.getTargetOwned());
				aadlbaText.addOutput(" := ");
				if (object.isAny())
					aadlbaText.addOutput("any");
				else
					process(object.getValueExpressionOwned());
				return DONE;
			}

			/**
			 * Unparse name
			 */
			public String caseName(Name object) {
				//FIXME : TODO : update location reference
				process(object.getIdentifierOwned());
				if (object.isSetArrayIndexes())
					return caseArrayIndex(object.getArrayIndexes()) ; 
			    else
			    	return DONE;
			}

			/**
			 * Unparse arrayindex
			 */
			public String caseArrayIndex(EList<IntegerValueVariable> object) {
				//FIXME : TODO : update location reference
				for(IntegerValueVariable ivv : object)
				{
					aadlbaText.addOutput("[");
					process(ivv);
					aadlbaText.addOutput("]");
				}
				return DONE;
			}

			/**
			 * Unparse datacomponentreference
			 */
			public String caseDataComponentReference(DataComponentReference object) {
				//FIXME : TODO : update location reference
				processEList(object.getNames(), ".");
				return DONE;
			}

			public String caseSubprogramCallAction(SubprogramCallAction object) {
				if(object.isSetSubprogramNames())
					processEList(object.getSubprogramNames(), ".") ;
				else
					process(object.getSubprogramReference()) ;
				
				aadlbaText.addOutput(" !") ;
				
				if(object.isSetParameterLabels()) {
					aadlbaText.addOutput(" (") ;
					processEList(object.getParameterLabels(), ", ") ;
					aadlbaText.addOutput(")") ;
				}
				return DONE;
			}
			
			public String casePortSendAction(PortSendAction object) {
				process(object.getPortName()) ;
				aadlbaText.addOutput(" !") ;
				
				if(object.getValueExpressionOwned() != null) {
					aadlbaText.addOutput(" (") ;
					process(object.getValueExpressionOwned());
					aadlbaText.addOutput(")") ;
				}
				return DONE;
			}
			
			public String casePortFreezeAction(PortFreezeAction object) {
				return casePortActionOrValue(object, " >>") ;
			}
			
			public String casePortDequeueAction(PortDequeueAction object) {
				process(object.getPortName()) ;
				aadlbaText.addOutput(" ?") ;
				if(object.getTargetOwned() != null)
				{
					aadlbaText.addOutput(" (") ;
					process(object.getTargetOwned()) ;
					aadlbaText.addOutput(")");
				}
				return DONE;
			}
			
			public String caseLockAction(LockAction object) {
				return caseSharedDataAction(object, "!<") ;
			}
			
			public String caseUnlockAction(UnlockAction object) {
				return caseSharedDataAction(object, "!>") ;
			}
			
			public String caseSharedDataAction(SharedDataAction object, String token) {
				if(object.getDataAccessName() != null)
				{
					process(object.getDataAccessName()) ;
					aadlbaText.addOutput(" ") ;
				}
				else
					aadlbaText.addOutput("*") ;
				
				aadlbaText.addOutput(token) ;				
				return DONE;
			}
			
			/**
			 * Unparse behaviortime
			 */
			public String caseBehaviorTime(BehaviorTime object) {
				//FIXME : TODO : update location reference
				process(object.getIntegerValueOwned());
				aadlbaText.addOutput(" ") ;
				process(object.getUnitIdentifier());
				return DONE;
			}
			
			public String casePortDequeueValue(PortDequeueValue object) {
				return casePortActionOrValue(object, " ?") ;
			}
			
			public String casePortCountValue(PortCountValue object) {
				return casePortActionOrValue(object, "' count");
			}
			
			public String casePortFreshValue(PortFreshValue object) {
				return casePortActionOrValue(object, "' fresh");
			}
			
			public String casePortActionOrValue(Name object, String token)
			{
				caseName(object) ;
				aadlbaText.addOutput(token) ;
				return DONE;
			}
			
			/**
			 * Unparse booleanliteral
			 */
			public String caseBooleanLiteral(BooleanLiteral object) {
				//FIXME : TODO : update location reference
				if (object.isValue())
					aadlbaText.addOutput("true");
				else
					aadlbaText.addOutput("false");
				return DONE;
			}
			
			/**
			 * Unparse stringliteral
			 */
			public String caseStringLiteral(StringLiteral object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getValue());
				return DONE;
			}
			
			public String caseRealLiteral(RealLiteral object) {
				aadlbaText.addOutput(String.valueOf(object.getValue())) ;
				return DONE;
			}
			
			public String caseIntegerLiteral(IntegerLiteral object) {
				aadlbaText.addOutput(object.getValueString()) ;
				return DONE;
			}
			
			/**
			 * Unparser PropertyConstant
			 */
			public String casePropertyConstant(PropertyConstant object) {
				return caseNamedElement(object) ;
			}
			
			/**
			 * Unparser PropertyValue
			 */
			public String casePropertyValue(PropertyValue object) {
				return caseNamedElement(object) ;
			}
			
			/**
			 * Unparse valueexpression
			 */
			public String caseValueExpression(ValueExpression object) {
				//FIXME : TODO : update location reference
				Iterator<Relation> itRel = object.getRelations().iterator(); 
				process(itRel.next()) ;
							
				if(object.isSetLogicalOperators()) {
					Iterator<LogicalOperator> itOp = object.getLogicalOperators().iterator();
					while(itRel.hasNext())
					{
						aadlbaText.addOutput(" " + itOp.next().getLiteral() + " ");
						process(itRel.next()) ;
					}
				}
				return DONE;
			}
			
			/**
			 * Unparse relation
			 */
			public String caseRelation(Relation object) {
				//FIXME : TODO : update location reference
				process(object.getSimpleExpressionOwned());
				if (object.getSimpleExpressionSdOwned() != null) {
					aadlbaText.addOutput(" "+object.getRelationalOperatorOwned().getLiteral()+" ");
					process(object.getSimpleExpressionSdOwned());
				} 
				return DONE;
			}
			
			/**
			 * Unparse simpleexpression
			 */
			public String caseSimpleExpression(SimpleExpression object) {
				//FIXME : TODO : update location reference
				if (object.isSetUnaryAddingOperatorOwned())
					aadlbaText.addOutput(object.getUnaryAddingOperatorOwned().getLiteral());
				
				Iterator<Term> itTerm = object.getTerms().iterator() ;
				
				process(itTerm.next()) ;
				
				if(object.isSetBinaryAddingOperators())
				{
					Iterator<BinaryAddingOperator> itOp = object.getBinaryAddingOperators().iterator() ;
					while(itTerm.hasNext())
					{
						aadlbaText.addOutput(" "+itOp.next().getLiteral()+" ");
						process(itTerm.next()) ;
					}
				}
				
				return DONE;
			}
			
			/**
			 * Unparse term
			 */
			public String caseTerm(Term object) {
				//FIXME : TODO : update location reference
				Iterator<Factor> itFact = object.getFactors().iterator() ;
				
				process(itFact.next()) ;
				
				if(object.isSetMultiplyingOperators()) {
					Iterator<MultiplyingOperator> itOp = object.getMultiplyingOperators().iterator() ;
					while(itFact.hasNext()) {
					aadlbaText.addOutput(" " + itOp.next().getLiteral() + " ") ;
					process(itFact.next()) ;
					}
				}
				return DONE;
			}
			
			/**
			 * Unparse factor
			 */
			public String caseFactor(Factor object) {
				//FIXME : TODO : update location reference
				if(object.isSetUnaryNumericOperatorOwned() ||
				   object.isSetUnaryBooleanOperatorOwned()    ) {
					Enumerator e = null ;
					if(object.isSetUnaryNumericOperatorOwned())
						e = object.getUnaryNumericOperatorOwned() ;
					else
						if(object.isSetUnaryBooleanOperatorOwned())
							e = object.getUnaryBooleanOperatorOwned() ;
					
					aadlbaText.addOutput(e.getLiteral() + " ");
				}
				
				if(object.getValueOwned() instanceof ValueExpression)
				{
					aadlbaText.addOutput("(") ;
					process(object.getValueOwned()) ;
					aadlbaText.addOutput(")") ;
				}
				else
				{
					process(object.getValueOwned()) ;
				}
				
				if(object.isSetBinaryNumericOperatorOwned())
				{
					aadlbaText.addOutput(" " + object.getBinaryNumericOperatorOwned().getLiteral() + " ");
					if(object.getValueSdOwned() instanceof ValueExpression)
					{
						aadlbaText.addOutput("(") ;
						process(object.getValueSdOwned()) ;
						aadlbaText.addOutput(")") ;
					}
					else
					{
						process(object.getValueSdOwned()) ;
					}
				}
				return DONE;
			}
		};
	}
}
