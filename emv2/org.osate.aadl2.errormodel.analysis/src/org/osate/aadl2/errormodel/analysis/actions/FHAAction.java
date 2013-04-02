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

import java.util.Collections;
import java.util.HashMap;
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
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public final class FHAAction extends AaxlReadOnlyActionAsJob {
	protected String getMarkerType() {
		return "org.osate.analysis.errormodel.FaultImpactMarker";
	}

	protected String getActionName() {
		return "FHA";
	}

	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("FHA", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject){
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else return;

		WriteToFile report = new WriteToFile("FHA", si);
		reportHeading(report);
		List<ComponentInstance> cilist = EcoreUtil2.getAllContentsOfType(si, ComponentInstance.class);
		for (ComponentInstance componentInstance : cilist) {
			processHazards(componentInstance, report);
		}
		report.saveToFile();

		monitor.done();
	}
	

	protected ContainedNamedElement getSeverityProperty(ComponentInstance ci, NamedElement localContext,NamedElement target, TypeSet ts){
		ContainedNamedElement result = EMV2Util.getProperty("MILSTD882::Severity",ci,localContext,target,ts);
		if (result==null)result = EMV2Util.getProperty("ARP4761::Severity",ci,localContext,target,ts);
		if (result==null)result = EMV2Util.getProperty("EMV2::Severity",ci,localContext,target,ts);
		return result;
	}
	
	protected ContainedNamedElement getLikelihoodProperty(ComponentInstance ci, NamedElement localContext,NamedElement target, TypeSet ts){
		ContainedNamedElement result = EMV2Util.getProperty("MILSTD882::Likelihood",ci,localContext,target,ts);
		if (result==null)result = EMV2Util.getProperty("ARP4761::Likelihood",ci,localContext,target,ts);
		if (result==null)result = EMV2Util.getProperty("EMV2::Likelihood",ci,localContext,target,ts);
		return result;
	}
	

	protected void processHazards(ComponentInstance ci, WriteToFile report)
	{

		ErrorModelSubclause errorModelSubclause = EMV2Util.getClassifierEMV2Subclause(ci.getComponentClassifier());
		if (errorModelSubclause != null)
		{
			ErrorBehaviorStateMachine errorBehavior = errorModelSubclause.getUseBehavior();
			if (errorBehavior != null)
			{
	
				for (ErrorBehaviorTransition trans : errorBehavior.getTransitions())
				{
					ConditionExpression cond = trans.getCondition();
					if (cond instanceof ConditionElement)
					{
						ConditionElement condElement = (ConditionElement)trans.getCondition();
						if (condElement.getIncoming() instanceof ErrorEvent)
						{
							ErrorEvent errorEvent = (ErrorEvent)condElement.getIncoming();
							ContainedNamedElement PA = null;
							ContainedNamedElement Sev = null;
							ContainedNamedElement Like = null;
							PA = EMV2Util.getHazardProperty(ci, null,errorEvent,errorEvent.getTypeSet());
							Sev = getSeverityProperty(ci, null,errorEvent,errorEvent.getTypeSet());
							Like = getLikelihoodProperty(ci, null,errorEvent,errorEvent.getTypeSet());
							if ((PA != null) && (Sev != null) && (Like != null))
							{
								reportHazardProperty(ci, PA, Sev, Like, null, errorEvent.getTypeSet(), errorEvent,report);
							}
						}
						//condElement.getIncoming()
					}

				}
			}
		}

		HashMap<String, ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		for (ErrorSource errorSource : eslist.values()) {
			ErrorPropagation ep = errorSource.getOutgoing();
			ErrorBehaviorStateOrTypeSet fmr = errorSource.getFailureModeReference();
			ContainedNamedElement PA = null;
			ContainedNamedElement Sev = null;
			ContainedNamedElement Like = null;
			TypeSet ts = null;
			ErrorBehaviorState failureMode = null;
			NamedElement target =null;
			NamedElement localContext = null;
			// not dealing with type set as failure mode
			if (fmr instanceof ErrorBehaviorState){
				// state is originating hazard
				failureMode =  (ErrorBehaviorState) fmr;
				ts = failureMode.getTypeSet();
				PA = EMV2Util.getHazardProperty(ci,errorSource,failureMode,ts);
				Sev = getSeverityProperty(ci,errorSource,failureMode,ts);
				Like = getLikelihoodProperty(ci,errorSource,failureMode,ts);
				target = failureMode;
				localContext = errorSource;
			}
			if (PA==null) {
				// error propagation is originating hazard
				ts = ep.getTypeSet();
				if (ts == null&& failureMode != null) ts = failureMode.getTypeSet();
				PA = EMV2Util.getHazardProperty(ci, null,ep,ts);
				Sev = getSeverityProperty(ci, null,ep,ts);
				Like = getLikelihoodProperty(ci, null,ep,ts);
				target = ep;
				localContext = null;
			}
			if (PA==null) {
				// error source is originating hazard
				ts = errorSource.getTypeTokenConstraint();
				if (ts == null) ts = ep.getTypeSet();
				if (ts == null&& failureMode != null) ts = failureMode.getTypeSet();
				PA = EMV2Util.getHazardProperty(ci, null,errorSource,ts);
				Sev = getSeverityProperty(ci, null,errorSource,ts);
				Like = getLikelihoodProperty(ci, null,errorSource,ts);
				target = errorSource;
				localContext = null;
			}
			if (PA==null) return;
			reportHazardProperty(ci, PA, Sev, Like, target, ts, localContext,report);
		}
	}
	
	
	protected String getEnumNumericPropertyValue(ContainedNamedElement ContainmentPath){
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(ContainmentPath).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof NamedValue){
				AbstractNamedValue eval = ((NamedValue)val).getNamedValue();
				if (eval instanceof EnumerationLiteral){
					return ((EnumerationLiteral)eval).getName();

				}else if (eval instanceof PropertyConstant){
					return ((PropertyConstant)eval).getName();
				}
			} else if (val instanceof IntegerLiteral){
				// empty string to force integer conversion to string
				return ""+((IntegerLiteral)val).getValue();
			}
		}
		
		return "";
	}
	
	protected void reportHazardProperty(ComponentInstance ci,ContainedNamedElement PAContainmentPath, 
			ContainedNamedElement SevContainmentPath,ContainedNamedElement LikeContainmentPath,
			NamedElement target, TypeSet ts, NamedElement localContext,WriteToFile report){
		
		ErrorType targetType = EMV2Util.getContainmentErrorType(PAContainmentPath); // type as last element of hazard containment path
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PAContainmentPath).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue){
				String Severity = getEnumNumericPropertyValue(SevContainmentPath);
				String Likelihood = getEnumNumericPropertyValue(LikeContainmentPath);
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				// for all error types/aliases in type set or the element identified in the containment clause 

				if (targetType==null){
					if (ts != null){
						for(TypeToken token: ts.getElementType()){
							reportFHAEntry(report, fields, Severity, Likelihood, ci, EMV2Util.getPrintName(target),EMV2Util.getName(token));
						}
					} else {
						// did not have a type set. Let's use fmr (state of type set as failure mode.
						String targetName;
						if (target == null)
						{
							targetName = "";
						}
						else
						{
							targetName = EMV2Util.getPrintName(target);
						}
						if (localContext == null)
						{
							reportFHAEntry(report, fields, Severity, Likelihood,ci, targetName,"");
						} else {
							reportFHAEntry(report, fields, Severity, Likelihood,ci, EMV2Util.getPrintName(localContext),EMV2Util.getPrintName(target));
						}
					}
				} else {
					// property points to type
					reportFHAEntry(report, fields,  Severity, Likelihood,ci,EMV2Util.getPrintName(target), EMV2Util.getPrintName(targetType));
				}
			}
		}
	}

	protected String makeCVSText(String text){
		return text.replaceAll(",", ";");
	}
	
	protected void reportHeading(WriteToFile report){
		report.addOutputNewline("Component, Error, Crossreference, " +
				"Functional Failure (Hazard), Operational Phase, Environment, Effects of Hazard, Severity, Criticality, Verification, Comment");	
	}
	
	protected void reportFHAEntry(WriteToFile report,EList<BasicPropertyAssociation> fields,
			String Severity, String Likelihood, ComponentInstance ci,
			String failureModeName,  String typetext){
		// component name & error propagation name/type
		report.addOutput(ci.getName()+", "+(typetext.isEmpty()?"":typetext+" on ")+failureModeName);
		// crossreference
		addComma(report);
		reportStringProperty(fields, "crossreference", report);
		// failure
		addComma(report);
		reportStringProperty(fields, "failure", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "phase", report);
		// phase
		addComma(report);
		reportStringProperty(fields, "environment", report);
		// description (Effect)
		addComma(report);
		reportStringProperty(fields, "description", report);
		// severity
		addComma(report);
		addString(report,Severity);
//		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "severity", report);
		// criticality
		addComma(report);
		addString(report,Likelihood);
//		reportEnumerationOrIntegerPropertyConstantPropertyValue(fields, "likelihood", report);
		// comment
		addComma(report);
		reportStringProperty(fields, "verificationmethod", report);
		// comment
		addComma(report);
		reportStringProperty(fields, "comment", report);
		report.addOutputNewline("");
	}
	
	protected void addComma(WriteToFile report){
		report.addOutput(", ");
	}
	
	protected void addString(WriteToFile report, String str){
		report.addOutput(str);
	}
	
	protected void reportStringProperty(EList<BasicPropertyAssociation> fields, String fieldName,WriteToFile report){
		BasicPropertyAssociation xref = GetProperties.getRecordField(fields, fieldName);
		if (xref != null){
			PropertyExpression val = xref.getOwnedValue();
			if (val instanceof StringLiteral){
				String text = ((StringLiteral)val).getValue();
				report.addOutput(makeCVSText(stripQuotes(text)));
			}
		}
	}
	
	/**
	 * Handle enumeration literals or integer values possibly assigned as property constant
	 * @param fields
	 * @param fieldName
	 * @param report
	 */
	protected void reportEnumerationOrIntegerPropertyConstantPropertyValue(EList<BasicPropertyAssociation> fields, String fieldName,WriteToFile report){
		// added code to handle integer value and use of property constant instead of enumeration literal
		BasicPropertyAssociation xref = GetProperties.getRecordField(fields, fieldName);
		if (xref != null){
			PropertyExpression val = xref.getOwnedValue();
			if (val instanceof NamedValue){
				AbstractNamedValue eval = ((NamedValue)val).getNamedValue();
				if (eval instanceof EnumerationLiteral){
					report.addOutput(((EnumerationLiteral)eval).getName());

				}else if (eval instanceof PropertyConstant){
					report.addOutput(((PropertyConstant)eval).getName());
				}
			} else if (val instanceof IntegerLiteral){
				report.addOutput(""+((IntegerLiteral)val).getValue());
			}
		}
	}
	
	protected String stripQuotes(String text){
		if (text.startsWith("\"")&& text.endsWith("\"")){
			return text.substring(1, text.length()-1);
		}
		return text;
	}


}
