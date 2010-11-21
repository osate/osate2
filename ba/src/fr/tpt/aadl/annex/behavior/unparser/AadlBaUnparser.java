package fr.tpt.aadl.annex.behavior.unparser;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.FeatureMap;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.parsesupport.AObject;
import edu.cmu.sei.aadl.modelsupport.AadlConstants;
import edu.cmu.sei.aadl.modelsupport.UnparseText;
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
import fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger;
import fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue;
import fr.tpt.aadl.annex.behavior.aadlba.StringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
import fr.tpt.aadl.annex.behavior.aadlba.WhileStatement;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch;

public class AadlBaUnparser {

	/**
	 * Aadlba switch which overrides methods to process unparsing
	 */
	protected AadlBaSwitch<String> aadlbaSwitch = null;

	/**
	 * Indentation position
	 */
	private String startIndent = "";

	/**
	 * Root of the current annexsubclause unparsed
	 */
	private AnnexSubclause rootAnnex = null;

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
		this.rootAnnex = root;
		this.startIndent = indent;
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
	 * Unparse curly (property) list
	 */
	public void processCurlyList(EList list) {
		// process property associations
		if (list != null && !list.isEmpty()) {
			aadlbaText.addOutputNewline(" {");
			aadlbaText.incrementIndent();
			processEList(list);
			aadlbaText.addOutput("}");
			aadlbaText.decrementIndent();
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
	 * Does processing of list as optional section without separators
	 * 
	 * @param list
	 *            to be processed
	 * @param sectionName
	 *            section
	 * @param emptyOption
	 *            shown with section name if empty list
	 */
	public void processOptionalSection(EList list, String sectionName,
			String emptyOption) {
		if (list == null)
			return;
		if (!list.isEmpty()) {
			aadlbaText.addOutputNewline(sectionName);
			aadlbaText.incrementIndent();
			this.processEList(list);
			aadlbaText.decrementIndent();
		} else if (emptyOption != null && emptyOption.length() > 0) {
			aadlbaText.addOutputNewline(sectionName + " " + emptyOption);
		}
	}

	/**
	 * Does processing of list as section without separators
	 * 
	 * @param list
	 *            to be processed
	 * @param sectionName
	 *            section
	 * @param emptyOption
	 *            shown with section name if empty list
	 */
	public void processSection(EList list, String sectionName,
			String emptyOption) {
		if (list == null)
			return;
		aadlbaText.addOutput(sectionName);
		if (!list.isEmpty()) {
			aadlbaText.addOutputNewline("");
			aadlbaText.incrementIndent();
			this.processEList(list);
			aadlbaText.decrementIndent();
		} else if (emptyOption != null) {
			aadlbaText.addOutputNewline(" " + emptyOption);
		}
	}

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
				if (!object.getVariables().isEmpty()) {
					aadlbaText.addOutputNewline("variables");
					aadlbaText.incrementIndent();
					processEList(object.getVariables());
					aadlbaText.decrementIndent();
				}
				if (!object.getStates().isEmpty()) {
					aadlbaText.addOutputNewline("states");
					aadlbaText.incrementIndent();
					processEList(object.getStates());
					aadlbaText.decrementIndent();
				}
				if (!object.getTransitions().isEmpty()) {
					aadlbaText.addOutputNewline("transitions");
					aadlbaText.incrementIndent();
					processEList(object.getTransitions());
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
				aadlbaText.addOutputNewline(";");
				return DONE;
			}

			/**
			 * Unparse declarators
			 */
			public String caseDeclarator(Declarator object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getName());
				processEList(object.getArraySizes());
				return DONE;
			}

			/**
			 * Unparse arraysize
			 */
			public String caseArraySize(ArraySize object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("[");
				process(object.getIntegerValueConstant());
				aadlbaText.addOutput("]");
				return DONE;
			}

			/**
			 * Unparse NumericLiteral
			 */
			public String caseNumericLiteral(NumericLiteral object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getNumValue());
				return DONE;
			}

			/**
			 * Unparser PropertyConstant
			 */
			public String casePropertyConstant(PropertyConstant object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getQualifiedName()+"::"+object.getName());
				return DONE;
			}
			
			/**
			 * Unparser PropertyValue
			 */
			public String casePropertyValue(PropertyValue object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput(object.getQualifiedName()+"::"+object.getName());
				return DONE;
			}

			/**
			 * Unparse uniquecomponentclassifierreference
			 */
			public String caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object) {
				//FIXME : TODO : update location reference
				if (object.getQualifiedName() != null)
					aadlbaText.addOutput(object.getQualifiedName() + ".");
				aadlbaText.addOutput(object.getName());
				return DONE;
			}

			/**
			 * Unparse behaviorstate
			 */
			public String caseBehaviorState(BehaviorState object) {
				//FIXME : TODO : update location reference
				processEList(object.getBehaviorStateIdentifiers(), ", ");
				aadlbaText.addOutput(" : ");
				if (object.isInitial())
					aadlbaText.addOutput("initial ");
				if (object.isComplete())
					aadlbaText.addOutput("complete ");
				if (object.isFinal())
					aadlbaText.addOutput("final ");
				aadlbaText.addOutputNewline("state;");
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
						Integer inum = new Integer(num.getNumeralValue());
						aadlbaText.addOutput(inum.toString());
						aadlbaText.addOutput("]");
					}
					aadlbaText.addOutput(" : ");
				}
				processEList(object.getSourceStateIdentifiers(), ", ");
				aadlbaText.addOutput(" -[");
				process(object.getBehaviorConditionOwned());
				aadlbaText.addOutput("]-> ");
				process(object.getDestinationStateIdentifier());
				if (object.getBehaviorActionsOwned() != null) {
					process(object.getBehaviorActionsOwned());
				}
				return DONE;
			}

			/**
			 * Unparse dispatchcondition
			 */
			public String caseDispatchCondition(DispatchCondition object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("on dispatch");
				if (object.getTheDispatchLogicalExpression() != null)
					process(object.getTheDispatchLogicalExpression());
				if (!object.getFrozenPorts().isEmpty())
					aadlbaText.addOutput(" ");
				processEList(object.getFrozenPorts(), ", ");
				return DONE;
			}

			/**
			 * Unparse dispatchlogicalexpression
			 */
			public String caseDispatchLogicalExpression(DispatchLogicalExpression object) {
				//FIXME : TODO : update location reference
				if (object.isOrExpression())
					processEList(object.getDispatchTriggers(), "or ");
				else if (object.isAndExpression())
					processEList(object.getDispatchTriggers(), "and ");
				else if(object.isXorExpression())
					processEList(object.getDispatchTriggers(), "xor ");
				else if (object.isStop())
					aadlbaText.addOutput("stop");
				else // Only one dispatch trigger case
					processEList(object.getDispatchTriggers());
				return DONE;
			}

			/**
			 * Unparser dispatchtrigger
			 */
			public String caseDispatchTrigger(DispatchTrigger object) {
				//FIXME : TODO : update location reference
				if (object.isNot())
					aadlbaText.addOutput("not");
				if (object.isTimeout()) {
					aadlbaText.addOutput("timeout");
					if (object.getTheBehaviorTime() != null)
						process(object.getTheBehaviorTime());
				}
				else if (object.getNumeralOwned() != null) {
					Integer inum = new Integer(object.getNumeralOwned().getNumeralValue());
					aadlbaText.addOutput(inum.toString());
					if (object.isOrMore())
						aadlbaText.addOutput("ormore");
					if (object.isOrLess())
						aadlbaText.addOutput("orless");
					if (!object.getDispatchTriggers().isEmpty()) {
						aadlbaText.addOutput("(");
						processEList(object.getDispatchTriggers(), ", ");
						aadlbaText.addOutput(")");
					}
				}
				else if (object.getIdentifierOwned() != null) {
					process(object.getIdentifierOwned());
					if (object.isOthers()) {
						aadlbaText.addOutput("(");
						aadlbaText.addOutput("others");
						aadlbaText.addOutput(")");
					}
					else if (object.getValueConstantOwned() != null) {
						aadlbaText.addOutput("(");
						process(object.getValueConstantOwned());
						aadlbaText.addOutput(")");
					}
				}
				else {
					aadlbaText.addOutput("(");
					process(object.getTheDispatchLogicalExpression());
					aadlbaText.addOutput(")");
				}
				return DONE;
			}

			/**
			 * Unparse behavioractions
			 */
			public String caseBehaviorActions(BehaviorActions object) {
				//FIXME : TODO : update location reference
				if (object.isSequence())
					processEList(object.getBehaviorAction(), " ; ");
				else if (object.isSet())
					processEList(object.getBehaviorAction(), " & ");
				else
					processEList(object.getBehaviorAction());
				return DONE;
			}

			/**
			 * Unparse behavioraction
			 */
			public String caseBehaviorAction(BehaviorAction object) {
				//FIXME : TODO : update location reference
				if (object.getBasicActionOwned() != null) {
					process(object.getBasicActionOwned());
				} else if (object.getCondStatementOwned() != null) {
					process(object.getCondStatementOwned());
				} else {
					aadlbaText.addOutputNewline("{");
					aadlbaText.incrementIndent();
					process(object.getBehaviorActionsOwned());
					aadlbaText.decrementIndent();
					aadlbaText.addOutputNewline("}");
				}
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
			 * Unparse target
			 */
			public String caseTarget(Target object) {
				//FIXME : TODO : update location reference
				if (object.getElementNameOwned() != null)
					process(object.getElementNameOwned());
				else
					process(object.getDataComponentReferenceOwned());
				return DONE;
			}

			/**
			 * Unparse name
			 */
			public String caseName(Name object) {
				//FIXME : TODO : update location reference
				process(object.getIdentifier());
				if (!object.getArrayIndexListOwned().isEmpty())
					processEList(object.getArrayIndexListOwned());
				return DONE;
			}

			/**
			 * Unparse arrayindex
			 */
			public String caseArrayIndex(ArrayIndex object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("[");
				process(object.getIntegerValueVariableOwned());
				aadlbaText.addOutput("]");
				return DONE;
			}

			/**
			 * Unparse integervalue
			 */
			public String caseIntegerValue(IntegerValue object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("-- IntegeValue not handle yet");
				return DONE;
			}

			/**
			 * Unparse datacomponentreference
			 */
			public String caseDataComponentReference(DataComponentReference object) {
				//FIXME : TODO : update location reference
				processEList(object.getElementsNameOwned(), ".");
				return DONE;
			}

			/**
			 * Unparse communicationaction
			 */
			public String caseCommunicationAction(CommunicationAction object) {
				//FIXME : TODO : update location reference
				if (object.isCatchTimeout()) {
					aadlbaText.addOutput("catch (timeout)");
				} else if (object.getDataUniqueComponentClassifierReference() != null) {
					process(object.getDataUniqueComponentClassifierReference());
					aadlbaText.addOutput(object.getActionType().getLiteral());
					if (object.isSetSubpgmParamListOwned()) {
						aadlbaText.addOutput("(");
						process(object.getSubpgmParamListOwned());
						aadlbaText.addOutput(")");
					}
				} else if (object.isAll()) {
					aadlbaText.addOutput("*"+object.getActionType().getLiteral());
				} else {
					process(object.getEltNameOwned());
					aadlbaText.addOutput(object.getActionType().getLiteral());
					if (object.isSetSubpgmParamListOwned()) {
						aadlbaText.addOutput("(");
						process(object.getSubpgmParamListOwned());
						aadlbaText.addOutput(")");
					}
					if (object.isHasValueExpression()) {
						aadlbaText.addOutput("(");
						process(object.getValueExprOwned());
						aadlbaText.addOutput(")");
					}
					if (object.isHasTarget()) {
						aadlbaText.addOutput("(");
						process(object.getTarOwned());
						aadlbaText.addOutput(")");
					}
				}
				return DONE;
			}
			
			/**
			 * Unparse subprogramparameterlist
			 */
			public String caseSubprogramParameterList(SubprogramParameterList object) {
				//FIXME : TODO : update location reference
				processEList(object.getParameterList(), ", ");
				return DONE;
			}
			
			/**
			 * Unparse timedaction
			 */
			public String caseTimedAction(TimedAction object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("computation (");
				processEList(object.getBehaviorTimesOwned(), ", ");
				aadlbaText.addOutput(")");
				return DONE;
			}

			/**
			 * Unparse behaviortime
			 */
			public String caseBehaviorTime(BehaviorTime object) {
				//FIXME : TODO : update location reference
				process(object.getIntegerValueOwned());
				if (object.getUnitIdentifier() != null)
					process(object.getUnitIdentifier());
				return DONE;
			}
			
			/**
			 * Unparse ifstatement
			 */
			public String caseIfStatement(IfStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("-- IF statement not handle yet");
				return DONE;
			}

			/**
			 * Unparse fororforallstatement
			 */
			public String caseForOrForAllStatement(ForOrForAllStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("-- For ForAll statement not handle yet");

				return DONE;
			}

			/**
			 * Unparse whilewtatement
			 */
			public String caseWhileStatement(WhileStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("-- While statement not handle yet");

				return DONE;
			}

			/**
			 * Unparse dountilstatement
			 */
			public String caseDoUntilStatement(DoUntilStatement object) {
				//FIXME : TODO : update location reference
				aadlbaText.addOutput("-- Do Until statement not handle yet");

				return DONE;
			}
			
			/**
			 * Integer_Range
			 */
			public String caseIntegerRange(IntegerRange object) {
				//FIXME : TODO : update location reference
				process(object.getLowerIntegerValue());
				aadlbaText.addOutput(" .. ");
				process(object.getUpperIntegerValue());
				return DONE;
			}
			/**
			 * Unparse booelanliteral
			 */
			public String caseBooleanLiteral(BooleanLiteral object) {
				//FIXME : TODO : update location reference
				if (object.isBoolValue())
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
				aadlbaText.addOutput(object.getStringValue());
				return DONE;
			}
			
			/**
			 * Unparse numeral
			 */
			public String caseNumeral(Numeral object) {
				//FIXME : TODO : update location reference
				Integer inum = new Integer(object.getNumeralValue());
				aadlbaText.addOutput(inum.toString());
				return DONE;
			}

		};
	}
}
