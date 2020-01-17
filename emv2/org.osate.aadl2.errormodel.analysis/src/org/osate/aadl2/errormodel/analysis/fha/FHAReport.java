/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.analysis.fha;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public final class FHAReport {

	public enum HazardFormat {
		EMV2, MILSTD882, ARP4761
	};

	private HazardFormat currentFormat = HazardFormat.EMV2;

	public FHAReport(HazardFormat emv2) {
		this.currentFormat = emv2;
	}

	public void doFHAReport(SystemInstance si) {
		WriteToFile report = new WriteToFile("FHA", si);
		if (currentFormat != HazardFormat.EMV2) {
			report.setSuffix("_" + currentFormat.name());
		}
		reportHeading(report);
		List<ComponentInstance> cilist = EcoreUtil2.getAllContentsOfType(si, ComponentInstance.class);
		processHazards(si, report);
		for (ConnectionInstance conni : si.getConnectionInstances()) {
			processHazards(conni, report);
		}
		for (ComponentInstance componentInstance : cilist) {
			processHazards(componentInstance, report);
			for (ConnectionInstance conni : componentInstance.getConnectionInstances()) {
				processHazards(conni, report);
			}
		}
		report.saveToFile();
	}

	protected void processHazards(ComponentInstance ci, WriteToFile report) {

		for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(ci.getComponentClassifier())) {
			ConditionExpression cond = trans.getCondition();
			if (cond instanceof ConditionElement) {
				ConditionElement condElement = (ConditionElement) trans.getCondition();
				EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(condElement);
				if (eop instanceof ErrorEvent) {
					ErrorEvent errorEvent = (ErrorEvent) eop;
					List<EMV2PropertyAssociation> PA = getHazardsPropertyInCurrentFormat(ci, errorEvent,
							errorEvent.getTypeSet());
					List<EMV2PropertyAssociation> Sev = EMV2Properties.getSeverityProperty(ci, errorEvent,
							errorEvent.getTypeSet());
					List<EMV2PropertyAssociation> Like = EMV2Properties.getLikelihoodProperty(ci, errorEvent,
							errorEvent.getTypeSet());
					reportHazardProperty(ci, PA, Sev, Like, errorEvent, errorEvent.getTypeSet(), errorEvent, report);
				}
				// condElement.getIncoming()
			}

		}

		for (ErrorBehaviorState state : EMV2Util.getAllErrorBehaviorStates(ci)) {

			List<EMV2PropertyAssociation> PA = getHazardsPropertyInCurrentFormat(ci, state, state.getTypeSet());
			List<EMV2PropertyAssociation> Sev = EMV2Properties.getSeverityProperty(ci, state, state.getTypeSet());
			List<EMV2PropertyAssociation> Like = EMV2Properties.getLikelihoodProperty(ci, state, state.getTypeSet());
			reportHazardProperty(ci, PA, Sev, Like, state, state.getTypeSet(), state, report);
		}

		// report all error sources as hazards if they have the property
		Collection<ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		Collection<ErrorPropagation> oeplist = EMV2Util.getAllOutgoingErrorPropagations(ci.getComponentClassifier());

		for (ErrorSource errorSource : eslist) {
			NamedElement ne = errorSource.getSourceModelElement();
			ErrorBehaviorState failureMode = errorSource.getFailureModeReference();
			List<EMV2PropertyAssociation> HazardPA = Collections.emptyList();
			List<EMV2PropertyAssociation> Sev = Collections.emptyList();
			List<EMV2PropertyAssociation> Like = Collections.emptyList();
			TypeSet ts = null;
			NamedElement target = null;
			Element localContext = null;
			// not dealing with type set as failure mode
			if (failureMode != null) {
				// state is originating hazard, possibly with a type set
				ts = failureMode.getTypeSet();
				// error source a local context
				HazardPA = getHazardsPropertyInCurrentFormat(ci, failureMode, ts);
				Sev = EMV2Properties.getSeverityProperty(ci, failureMode, ts);
				Like = EMV2Properties.getLikelihoodProperty(ci, failureMode, ts);
				target = failureMode;
				localContext = errorSource;
			}
			if (HazardPA.isEmpty()) {
				// error source is originating hazard
				ts = errorSource.getTypeTokenConstraint();
				if (ts == null && ne instanceof ErrorPropagation) {
					ts = ((ErrorPropagation) ne).getTypeSet();
				}
				HazardPA = getHazardsPropertyInCurrentFormat(ci, errorSource, ts);
				Sev = EMV2Properties.getSeverityProperty(ci, errorSource, ts);
				Like = EMV2Properties.getLikelihoodProperty(ci, errorSource, ts);
				target = errorSource;
				localContext = null;
				if (HazardPA.isEmpty() && errorSource.getFailureModeType() != null) {
					ts = errorSource.getFailureModeType();
					HazardPA = getHazardsPropertyInCurrentFormat(ci, errorSource, ts);
					Sev = EMV2Properties.getSeverityProperty(ci, errorSource, ts);
					Like = EMV2Properties.getLikelihoodProperty(ci, errorSource, ts);
				}
			}
			if (!HazardPA.isEmpty()) {
				reportHazardProperty(ci, HazardPA, Sev, Like, target, ts, localContext, report);
			}
		}
		for (ErrorPropagation ep : oeplist) {
			TypeSet ts = null;
			NamedElement target = null;
			Element localContext = null;
			// error propagation is originating hazard
			ts = ep.getTypeSet();
			List<EMV2PropertyAssociation> HazardPA = getHazardsPropertyInCurrentFormat(ci, ep, ts);
			List<EMV2PropertyAssociation> Sev = EMV2Properties.getSeverityProperty(ci, ep, ts);
			List<EMV2PropertyAssociation> Like = EMV2Properties.getLikelihoodProperty(ci, ep, ts);
			target = ep;
			localContext = null;
			// XXX we may have more than one matching hazard
			if (!HazardPA.isEmpty()) {
				reportHazardProperty(ci, HazardPA, Sev, Like, target, ts, localContext, report);
			}
		}
	}

	protected void processHazards(ConnectionInstance conni, WriteToFile report) {
		ErrorSource ces = EMV2Util.findConnectionErrorSourceForConnection(conni);
		if (ces == null) {
			return;
		}
		Element localContext = null;
		// error propagation is originating hazard
		TypeSet ts = ces.getTypeTokenConstraint();
		List<EMV2PropertyAssociation> HazardPA = getHazardsPropertyInCurrentFormat(conni, ces, ts);
		List<EMV2PropertyAssociation> Sev = EMV2Properties.getSeverityProperty(conni, ces, ts);
		List<EMV2PropertyAssociation> Like = EMV2Properties.getLikelihoodProperty(conni, ces, ts);
		NamedElement target = ces;
		// XXX we may have more than one matching hazard
		if (!HazardPA.isEmpty()) {
			reportHazardProperty(conni, HazardPA, Sev, Like, target, ts, localContext, report);
		}
	}

	protected String getEnumerationorIntegerPropertyValue(PropertyAssociation pa) {
		if (pa == null) {
			return "";
		}
		for (ModalPropertyValue modalPropertyValue : pa.getOwnedValues()) {
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

	protected void reportHazardProperty(InstanceObject ci, List<EMV2PropertyAssociation> PAList,
			List<EMV2PropertyAssociation> SevList, List<EMV2PropertyAssociation> LikeList, NamedElement target,
			TypeSet ts,
			Element localContext, WriteToFile report) {

		String targetName;
		if (PAList.isEmpty()) {
			return;
		}
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
		for (EMV2PropertyAssociation PA : PAList) {

			for (ModalPropertyValue modalPropertyValue : PA.getOwnedValues()) {
				PropertyExpression peVal = modalPropertyValue.getOwnedValue();
				ListValue lv = (ListValue) peVal;
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					EList<BasicPropertyAssociation> fields = ((RecordValue) pe).getOwnedFieldValues();
					// for all error types/aliases in type set or the element identified in the containment clause

					if (ts != null) {
						// do smaller of ts or hazard type set.
						EList<EMV2Path> epathlist = PA.getEmv2Path();
						for (EMV2Path ep : epathlist) {
							ErrorTypes et = EMV2Util.getErrorType(ep);
							ErrorTypes targettype = ts;
							if (et != null && EMV2TypeSetUtil.contains(ts, et)) {
								targettype = et;
							}
							List<EMV2PropertyAssociation> Sevs = EMV2Properties.getSeverityProperty(ci, target, et);
							List<EMV2PropertyAssociation> Likes = EMV2Properties.getLikelihoodProperty(ci, target, et);
							EMV2PropertyAssociation Sev = Sevs.isEmpty() ? null : Sevs.get(0);
							EMV2PropertyAssociation Like = Likes.isEmpty() ? null : Likes.get(0);
							PropertyExpression severityValue = EMV2Properties.getPropertyValue(Sev);
							PropertyExpression likelihoodValue = EMV2Properties.getPropertyValue(Like);
							if (targettype instanceof TypeSet) {
								for (TypeToken token : ((TypeSet) targettype).getTypeTokens()) {
									reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName,
											EMV2Util.getName(token));
								}
							} else {
								reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName,
										EMV2Util.getName(targettype));
							}
						}
					} else {
						// did not have a type set. Let's use fmr (state of type set as failure mode.
						EMV2PropertyAssociation Sev = SevList.isEmpty() ? null : SevList.get(0);
						EMV2PropertyAssociation Like = LikeList.isEmpty() ? null : LikeList.get(0);
						PropertyExpression severityValue = EMV2Properties.getPropertyValue(Sev);
						PropertyExpression likelihoodValue = EMV2Properties.getPropertyValue(Like);
						if (localContext == null) {
							reportFHAEntry(report, fields, severityValue, likelihoodValue, ci, targetName, "");
						} else {
							reportFHAEntry(report, fields, severityValue, likelihoodValue, ci,
									EMV2Util.getPrintName(localContext), EMV2Util.getPrintName(target));
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

		switch (currentFormat) {
		case EMV2:
			report.addOutputNewline("Component, Error Model Element," + " Hazard Title, Description, Crossreference, "
					+ "Failure, " + "Failure Effect, " + "Operational Phases, Environment," + "Risk,"
					+ "Mishap, Failure Condition," + " Severity, Likelihood, Probability,"
					+ "Target Severity, Target Likelihood, Development Assurance Level, " + "Verification Method, "
					+ "Safety Report, " + "Comment");
			break;
		case ARP4761:
			report.addOutputNewline("Component, Error Model Element," + " Hazard Title, Description, Crossreference, "
					+ "Failure, " + "Failure Effect, " + "Operational Phases, Environment,"
					+ "  Risk, Mishap, Failure Condition,Failure Condition Classification, "
					+ "Qualitative Probability, Quantitative Probability, Qualitative Probability Objective, Quantitative Probability Objective, Development Assurance Level, "
					+ "Verification Method, " + "Safety Report, " + "Comment");
			break;
		case MILSTD882:
			report.addOutputNewline("Component, Error Model Element," + " Hazard Title, Description, Crossreference, "
					+ "Failure, " + "Failure Effect, " + "Operational Phases, Environment," + " Mishap, Risk,"
					+ " Severity Level, Severity Category, Qualitative Probability,Probability Level,Quantitative Probability, "
					+ "Target Severity Level, Target Probability Level, " + "Verification Method, " + "Safety Report, "
					+ "Comment");
			break;
		}
	}

	protected void reportFHAEntry(WriteToFile report, EList<BasicPropertyAssociation> fields,
			PropertyExpression Severity, PropertyExpression Likelihood, InstanceObject ci, String failureModeName,
			String typetext) {

		switch (currentFormat) {
		case EMV2:
			reportFHAEntryEMV2(report, fields, Severity, Likelihood, ci, failureModeName, typetext);
			break;
		case ARP4761:
			reportFHAEntryARP4761(report, fields, Severity, Likelihood, ci, failureModeName, typetext);
			break;
		case MILSTD882:
			reportFHAEntryMILSTD882(report, fields, Severity, Likelihood, ci, failureModeName, typetext);
			break;
		}
	}

	protected void reportFHAEntryEMV2(WriteToFile report, EList<BasicPropertyAssociation> fields,
			PropertyExpression Severity, PropertyExpression Likelihood, InstanceObject ci, String failureModeName,
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
		reportStringProperty(fields, "hazardtitle", report);
		addComma(report);
		reportStringProperty(fields, "description", report);
		// crossreference
		addComma(report);
		reportStringProperty(fields, "crossreference", report);
		// failure
		addComma(report);
		reportStringProperty(fields, "failure", report);
		// failure effect
		addComma(report);
		reportStringProperty(fields, "failureeffect", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "phases", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "environment", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "risk", report);
		// mishap/failure condition
		addComma(report);
		reportStringProperty(fields, "mishap", report);
		addComma(report);
		reportStringProperty(fields, "failurecondition", report);
		// severity
		addComma(report);
		if (hasFieldValue(fields, "Severity")) {
			reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "Severity", report, Severity);
		} else if (hasFieldValue(fields, "FailureConditionClassification")) {
			reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "FailureConditionClassification", report,
					Severity);
		} else {
			reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "SeverityLevel", report, Severity);
		}
		// criticality
		addComma(report);
		if (hasFieldValue(fields, "Likelihood")) {
			reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "Likelihood", report, Likelihood);
		} else {
			reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QualitativeProbability", report,
					Likelihood);
		}
		// probability
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "probability", report, null);
		// target severity
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "targetseverity", report, null);
		// target criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "targetlikelihood", report, null);
		// Development assurance level
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "developmentassurancelevel", report, null);
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

	protected void reportFHAEntryARP4761(WriteToFile report, EList<BasicPropertyAssociation> fields,
			PropertyExpression Severity, PropertyExpression Likelihood, InstanceObject ci, String failureModeName,
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
		reportStringProperty(fields, "hazardtitle", report);
		addComma(report);
		reportStringProperty(fields, "description", report);
		// crossreference
		addComma(report);
		reportStringProperty(fields, "crossreference", report);
		// failure
		addComma(report);
		reportStringProperty(fields, "failure", report);
		// failure effect
		addComma(report);
		reportStringProperty(fields, "failureeffect", report);
		addComma(report);
		reportStringProperty(fields, "phases", report);
		addComma(report);
		reportStringProperty(fields, "environment", report);
		addComma(report);
		reportStringProperty(fields, "risk", report);
		addComma(report);
		reportStringProperty(fields, "mishap", report);
		// mishap/failure condition
		addComma(report);
		reportStringProperty(fields, "failurecondition", report);
		// severity
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "FailureConditionClassification", report,
				Severity);
		// criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QualitativeProbability", report, Likelihood);
		// probability
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QuantitativeProbability", report, null);
		// criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QualitativeProbabilityObjective", report,
				Likelihood);
		// probability
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QuantitativeProbabilityObjective", report,
				null);
		// Development assurance level
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "developmentassurancelevel", report, null);
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

	protected void reportFHAEntryMILSTD882(WriteToFile report, EList<BasicPropertyAssociation> fields,
			PropertyExpression Severity, PropertyExpression Likelihood, InstanceObject ci, String failureModeName,
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
		reportStringProperty(fields, "hazardtitle", report);
		addComma(report);
		reportStringProperty(fields, "description", report);
		// crossreference
		addComma(report);
		reportStringProperty(fields, "crossreference", report);
		// failure
		addComma(report);
		reportStringProperty(fields, "failure", report);
		// failure effect
		addComma(report);
		reportStringProperty(fields, "failureeffect", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "phases", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "environment", report);
		// mishap/failure condition
		addComma(report);
		if (!reportStringProperty(fields, "mishap", report)) {
			reportStringProperty(fields, "failurecondition", report);
		}
		// phase
		addComma(report);
		reportStringProperty(fields, "risk", report);
		// severity
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "SeverityLevel", report, Severity);
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "SeverityCategory", report, Severity);
		// criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QualitativeProbability", report, Likelihood);
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "ProbabilityLevel", report, Likelihood);
		// probability
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "QuantitativeProbability", report, null);
		// criticality
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "TargetSeverityLevel", report, Likelihood);
		// probability
		addComma(report);
		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "TargetProbabilityLevel", report, null);
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
	protected Boolean reportStringProperty(EList<BasicPropertyAssociation> fields, String fieldName,
			WriteToFile report) {
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

	protected boolean hasFieldValue(EList<BasicPropertyAssociation> fields, String fieldName) {
		return GetProperties.getRecordField(fields, fieldName) != null;
	}

	protected String stripQuotes(String text) {
		if (text.startsWith("\"") && text.endsWith("\"")) {
			return text.substring(1, text.length() - 1);
		}
		return text;
	}

	protected List<EMV2PropertyAssociation> getHazardsPropertyInCurrentFormat(NamedElement ci, NamedElement target,
			TypeSet ts) {
		switch (currentFormat) {
		case EMV2:
			return EMV2Properties.getHazardsProperty(ci, target, ts);
		case ARP4761:
			return EMV2Properties.getARP4761HazardsProperty(ci, target, ts);
		case MILSTD882:
			return EMV2Properties.getMILSTD882HazardsProperty(ci, target, ts);
		}
		return null;
	}

}
