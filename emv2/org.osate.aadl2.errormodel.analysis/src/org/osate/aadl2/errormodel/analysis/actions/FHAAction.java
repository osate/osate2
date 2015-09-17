/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.errormodel.analysis.actions;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public final class FHAAction extends AaxlReadOnlyActionAsJob {

	public static final int REPORT_TYPE_ARP4761 = 1;
	public static final int REPORT_TYPE_MILSTD882 = 2;
	public static final int INVALID_VALUE = 9999;

	@Override
	protected String getMarkerType() {
		return "org.osate.analysis.errormodel.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "FHA";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("FHA", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			return;
		}

		WriteToFile report = new WriteToFile("FHA", si);
		reportHeading(report);
		List<ComponentInstance> cilist = EcoreUtil2.getAllContentsOfType(si, ComponentInstance.class);
		processHazards(si, report);
		for (ComponentInstance componentInstance : cilist) {
			processHazards(componentInstance, report);
		}
		report.saveToFile();

		monitor.done();
	}

	public enum HazardFormat {
		EMV2, MILSTD882, ARP4761
	};

	protected void processHazards(ComponentInstance ci, WriteToFile report) {

		for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(ci.getComponentClassifier())) {
			ConditionExpression cond = trans.getCondition();
			if (cond instanceof ConditionElement) {
				ConditionElement condElement = (ConditionElement) trans.getCondition();
				if (condElement.getIncoming() instanceof ErrorEvent) {
					ErrorEvent errorEvent = (ErrorEvent) condElement.getIncoming();
					EList<ContainedNamedElement> PA = EMV2Properties.getHazardsProperty(ci, errorEvent,
							errorEvent.getTypeSet());
					EList<ContainedNamedElement> Sev = EMV2Properties.getSeverityProperty(ci, errorEvent,
							errorEvent.getTypeSet());
					EList<ContainedNamedElement> Like = EMV2Properties.getLikelihoodProperty(ci, errorEvent,
							errorEvent.getTypeSet());
					for (ContainedNamedElement hazProp : PA) {
						reportHazardProperty(ci, hazProp, EMV2Util.findMatchingErrorType(hazProp, Sev),
								EMV2Util.findMatchingErrorType(hazProp, Like), errorEvent, errorEvent.getTypeSet(),
								errorEvent, report);
					}
				}
				// condElement.getIncoming()
			}

		}

		for (ErrorBehaviorState state : EMV2Util.getAllErrorBehaviorStates(ci)) {

			EList<ContainedNamedElement> PA = EMV2Properties.getHazardsProperty(ci, state, state.getTypeSet());
			EList<ContainedNamedElement> Sev = EMV2Properties.getSeverityProperty(ci, state, state.getTypeSet());
			EList<ContainedNamedElement> Like = EMV2Properties.getLikelihoodProperty(ci, state, state.getTypeSet());
			for (ContainedNamedElement hazProp : PA) {
				reportHazardProperty(ci, hazProp, EMV2Util.findMatchingErrorType(hazProp, Sev),
						EMV2Util.findMatchingErrorType(hazProp, Like), state, state.getTypeSet(), state, report);
			}
		}

		// report all error sources as hazards if they have the property
		Collection<ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		Collection<ErrorPropagation> oeplist = EMV2Util.getAllOutgoingErrorPropagations(ci.getComponentClassifier());
		for (ErrorSource errorSource : eslist) {
			ErrorPropagation ep = errorSource.getOutgoing();
			oeplist.remove(ep);
			ErrorBehaviorStateOrTypeSet fmr = errorSource.getFailureModeReference();
			EList<ContainedNamedElement> HazardPA = null;
			EList<ContainedNamedElement> Sev = null;
			EList<ContainedNamedElement> Like = null;
			TypeSet ts = null;
			ErrorBehaviorState failureMode = null;
			Element target = null;
			Element localContext = null;
			// not dealing with type set as failure mode
			if (fmr instanceof ErrorBehaviorState) {
				// state is originating hazard, possibly with a type set
				failureMode = (ErrorBehaviorState) fmr;
				ts = failureMode.getTypeSet();
				// error source a local context
				HazardPA = EMV2Properties.getHazardsProperty(ci, failureMode, ts);
				Sev = EMV2Properties.getSeverityProperty(ci, failureMode, ts);
				Like = EMV2Properties.getLikelihoodProperty(ci, failureMode, ts);
				target = failureMode;
				localContext = errorSource;
			}
			if ((HazardPA == null) || (HazardPA.isEmpty())) {
				// error propagation is originating hazard
				ts = ep.getTypeSet();
				if (ts == null && failureMode != null) {
					ts = failureMode.getTypeSet();
				}
				HazardPA = EMV2Properties.getHazardsProperty(ci, ep, ts);
				Sev = EMV2Properties.getSeverityProperty(ci, ep, ts);
				Like = EMV2Properties.getLikelihoodProperty(ci, ep, ts);
				target = ep;
				localContext = null;
			}
			if ((HazardPA == null) || (HazardPA.isEmpty())) {
				// error source is originating hazard
				ts = errorSource.getTypeTokenConstraint();
				if (ts == null) {
					ts = ep.getTypeSet();
				}
				if (ts == null && failureMode != null) {
					ts = failureMode.getTypeSet();
				}
				HazardPA = EMV2Properties.getHazardsProperty(ci, errorSource, ts);
				Sev = EMV2Properties.getSeverityProperty(ci, errorSource, ts);
				Like = EMV2Properties.getLikelihoodProperty(ci, errorSource, ts);
				target = errorSource;
				localContext = null;
			}
			if (HazardPA != null) {
				for (ContainedNamedElement hazProp : HazardPA) {
					reportHazardProperty(ci, hazProp, EMV2Util.findMatchingErrorType(hazProp, Sev),
							EMV2Util.findMatchingErrorType(hazProp, Like), target, ts, localContext, report);
				}
			}
		}
		for (ErrorPropagation ep : oeplist) {
			EList<ContainedNamedElement> HazardPA = null;
			EList<ContainedNamedElement> Sev = null;
			EList<ContainedNamedElement> Like = null;
			TypeSet ts = null;
			Element target = null;
			Element localContext = null;
			// error propagation is originating hazard
			ts = ep.getTypeSet();
			HazardPA = EMV2Properties.getHazardsProperty(ci, ep, ts);
			Sev = EMV2Properties.getSeverityProperty(ci, ep, ts);
			Like = EMV2Properties.getLikelihoodProperty(ci, ep, ts);
			target = ep;
			localContext = null;
			if (HazardPA != null) {
				for (ContainedNamedElement hazProp : HazardPA) {
					reportHazardProperty(ci, hazProp, EMV2Util.findMatchingErrorType(hazProp, Sev),
							EMV2Util.findMatchingErrorType(hazProp, Like), target, ts, localContext, report);
				}
			}
		}
	}

	protected String getEnumerationorIntegerPropertyValue(ContainedNamedElement containmentPath) {
		if (containmentPath == null) {
			return "";
		}
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(containmentPath)
				.getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof NamedValue) {
				AbstractNamedValue eval = ((NamedValue) val).getNamedValue();
				if (eval instanceof EnumerationLiteral) {
					return ((EnumerationLiteral) eval).getName();

				} else if (eval instanceof PropertyConstant) {
					return ((PropertyConstant) eval).getName();
				}
			} else if (val instanceof IntegerLiteral) {
				// empty string to force integer conversion to string
				return "" + ((IntegerLiteral) val).getValue();
			}
		}

		return "";
	}

	protected void reportHazardProperty(ComponentInstance ci, ContainedNamedElement PAContainmentPath,
			ContainedNamedElement SevContainmentPath, ContainedNamedElement LikeContainmentPath, Element target,
			TypeSet ts, Element localContext, WriteToFile report) {

		ErrorType targetType = EMV2Util.getContainmentErrorType(PAContainmentPath); // type as last element of hazard containment path
		String targetName;

		if (target == null) {
			targetName = "";
		} else {
			targetName = EMV2Util.getPrintName(target);
			if (target instanceof ErrorEvent) {
				targetName = "event " + targetName;
			}

			if (target instanceof ErrorBehaviorState) {
				targetName = "state " + targetName;
			}
		}

		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PAContainmentPath)
				.getOwnedValues()) {
			PropertyExpression peVal = modalPropertyValue.getOwnedValue();
			if (peVal instanceof ListValue) { // it is always a list
				ListValue lv = (ListValue) peVal;
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					// OsateDebug.osateDebug ("pe=" + pe);
					if (pe instanceof RecordValue) {
						PropertyExpression severityValue = EMV2Properties.getPropertyValue(SevContainmentPath);
						PropertyExpression likelihoodValue = EMV2Properties.getPropertyValue(LikeContainmentPath);
						EList<BasicPropertyAssociation> fields = ((RecordValue) pe).getOwnedFieldValues();
						// for all error types/aliases in type set or the element identified in the containment clause

						if (targetType == null) {
							if (ts != null) {
								for (TypeToken token : ts.getTypeTokens()) {
									reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName,
											EMV2Util.getName(token));
								}
							} else {
								// did not have a type set. Let's use fmr (state of type set as failure mode.

								if (localContext == null) {
									reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName, "");
								} else {
									reportFHAEntry(report, fields, severityValue, likelihoodValue, ci,
											EMV2Util.getPrintName(localContext), EMV2Util.getPrintName(target));
								}
							}
						} else {
							// property points to type
							reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName,
									EMV2Util.getPrintName(targetType));
						}
					}
				}

			}
		}
	}

	protected String makeCSVText(String text) {
		return text.replaceAll(",", ";");
	}

	protected void reportHeading(WriteToFile report) {
		report.addOutputNewline("Component, Error," + " Hazard Description, Crossreference, " + "Functional Failure, " + // "Failure Effect, " +
				"Operational Phases, Environment," + // " Mishap/Failure Condition,"+
//				"Effects of Hazard"+ // "Description" old style
				" Severity, Likelihood," +
				// "Target Severity, Target Likelihood, Assurance Level, " +
				"Verification, " + // "Safety Report, " +
				"Comment");
	}

	protected void reportFHAEntry(WriteToFile report, EList<BasicPropertyAssociation> fields,
			PropertyExpression Severity, PropertyExpression Likelihood, ComponentInstance ci, String failureModeName,
			String typetext) {
		String componentName = ci.getName();
		/*
		 * We include the parent component name if not null and if this is not the root system
		 * instance.
		 */
		if ((ci.getContainingComponentInstance() != null)
				&& (ci.getContainingComponentInstance() != ci.getSystemInstance())) {
			componentName = ci.getContainingComponentInstance().getName() + "/" + componentName;
		}
		if (ci instanceof SystemInstance) {
			componentName = "Root system";
		}
		// component name & error propagation name/type
		report.addOutput(componentName + ", \"" + (typetext.isEmpty() ? "" : typetext)
				+ (failureModeName.isEmpty() ? "" : " on " + failureModeName) + "\"");
		// description (Effect)
		addComma(report);
		if (!reportStringProperty(fields, "hazardtitle", report)) {
			reportStringProperty(fields, "description", report);
		}
		// crossreference
		addComma(report);
		reportStringProperty(fields, "crossreference", report);
		// failure
		addComma(report);
		reportStringProperty(fields, "failure", report);
//		// failure effect
//		addComma(report);
//		reportStringProperty(fields, "failureeffect", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "phases", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "environment", report);
//		// mishap/failure condition
//		addComma(report);
//		if (!reportStringProperty(fields, "mishap", report))
//			reportStringProperty(fields, "failurecondition", report);
		// severity
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "severity", report, Severity);
		// criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "likelihood", report, Likelihood);
//		// target severity
//		addComma(report);
//		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "targetseverity", report,null);
//		// target criticality
//		addComma(report);
//		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "targetlikelihood", report,null);
//		// Development assurance level
//		addComma(report);
//		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "developmentassurancelevel", report,null);
		// verification method
		addComma(report);
		reportStringProperty(fields, "verificationmethod", report);
		// safety report
		addComma(report);
		reportStringProperty(fields, "safetyreport", report);
		// comment
		addComma(report);
		reportStringProperty(fields, "comment", report);
		report.addOutputNewline("");
	}

	protected void addComma(WriteToFile report) {
		report.addOutput(", ");
	}

	protected void addString(WriteToFile report, String str) {
		report.addOutput(str);
	}

	/**
	 * report String based property values. Can be list of string values (for handling Phases)
	 * @param fields
	 * @param fieldName
	 * @param report
	 */
	protected Boolean reportStringProperty(EList<BasicPropertyAssociation> fields, String fieldName, WriteToFile report) {
		BasicPropertyAssociation xref = GetProperties.getRecordField(fields, fieldName);
		String text = null;
		if (xref != null) {
			PropertyExpression val = xref.getOwnedValue();
			if (val instanceof StringLiteral) {
				text = ((StringLiteral) val).getValue();
			}
			if (val instanceof ListValue) {
				ListValue lv = (ListValue) val;
				text = "";
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					if (text.length() > 0) {
						text += " or ";
					}
					text += stripQuotes(((StringLiteral) pe).getValue());
				}
			}
		}
		if (text != null) {
			text = makeCSVText(stripQuotes(text));
			text = text.replaceAll(System.getProperty("line.separator"), " ");
			report.addOutput("\"" + text + "\"");
			return true;
		}
		return false;
	}

	/**
	 * Handle enumeration literals or integer values possibly assigned as property constant
	 * @param fields
	 * @param fieldName
	 * @param report
	 */
	protected void reportEnumerationOrIntegerPropertyConstantPropertyValue(EList<BasicPropertyAssociation> fields,
			String fieldName, WriteToFile report, PropertyExpression alternativeValue) {
		// added code to handle integer value and use of property constant instead of enumeration literal
		PropertyExpression val = alternativeValue;
		BasicPropertyAssociation xref = GetProperties.getRecordField(fields, fieldName);
		if (xref != null) {
			val = xref.getOwnedValue();
		}
		report.addOutput(EMV2Properties.getEnumerationOrIntegerPropertyConstantPropertyValue(val));
	}

	protected String stripQuotes(String text) {
		if (text.startsWith("\"") && text.endsWith("\"")) {
			return text.substring(1, text.length() - 1);
		}
		return text;
	}

}
