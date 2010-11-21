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
import fr.tpt.aadl.annex.behavior.aadlba.ArraySize;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
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
				processSection(object.getVariables() , "variables", "");
				processSection(object.getStates() , "states", "");
				processSection(object.getTransitions() , "transitions", "");
				return DONE;
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
		};
	}
}
