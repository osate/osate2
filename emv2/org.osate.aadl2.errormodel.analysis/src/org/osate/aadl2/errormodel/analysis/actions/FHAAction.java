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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

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

	
	protected void processHazards(ComponentInstance ci, WriteToFile report){
		ErrorPropagations eps = EM2Util.getContainingClassifierErrorPropagations(ci.getComponentClassifier());
		if (eps == null) return;
		EList<PropertyAssociation> props = eps.getProperties();
		EList<ErrorSource> eslist = EM2Util.getErrorSources(eps);
		for (ErrorSource errorSource : eslist) {
			ErrorPropagation ep = errorSource.getOutgoing();
			ErrorBehaviorStateOrTypeSet fmr = errorSource.getFailureModeReference();
			if (fmr instanceof ErrorBehaviorState){
			ErrorBehaviorState failureMode =  null;
			// only propagate if error propagation?// XXX TODO phf fix up
			PropertyAssociation failureModePA = EM2Util.getProperty(props, "EMV2::hazard",failureMode);
			PropertyAssociation errorPropPA = EM2Util.getProperty(props, "EMV2::hazard",ep);
			PropertyAssociation errorSourcePA = EM2Util.getProperty(props, "EMV2::hazard",errorSource);
			EList<ErrorType> targetType = null;
			EList<ModalPropertyValue> vallist;
			TypeSet ts ;
			// process if hazard defined for error source, error state, or error propagation (or its error type)
			if (failureModePA == null && errorPropPA == null && errorSourcePA == null) break;
			if (failureModePA != null){
				vallist = failureModePA.getOwnedValues();
				targetType = EM2Util.getContainmentErrorType(failureModePA,failureMode);
				ts = failureMode.getTypeSet();
			} else if (errorPropPA != null){
				targetType = EM2Util.getContainmentErrorType(errorPropPA,ep);
				vallist = errorPropPA.getOwnedValues();
				ts = ep.getTypeSet();
				if (ts == null) ts = failureMode.getTypeSet();
			} else {
				// error source)
				targetType = EM2Util.getContainmentErrorType(errorSourcePA,ep);
				vallist = errorSourcePA.getOwnedValues();
				ts = errorSource.getTypeTokenConstraint();
				if (ts == null) ts = ep.getTypeSet();
				if (ts == null) ts = failureMode.getTypeSet();
			}
			for (ModalPropertyValue modalPropertyValue : vallist) {
				PropertyExpression val = modalPropertyValue.getOwnedValue();
				if (val instanceof RecordValue){
					RecordValue rv = (RecordValue)val;
					EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
					// for all error types/aliases in type set or the element identified in the containment clause 
					if (targetType.isEmpty()){
						if (ts != null){
							reportFHAEntry(report, fields, ci, EM2Util.getPrintName(ep),EM2Util.getTableName(ts));
						} else {
							reportFHAEntry(report, fields, ci, EM2Util.getPrintName(ep),failureMode!=null?EM2Util.getPrintName(failureMode):"");
						}
					} else {
						// property points to type
						for (ErrorType et : targetType) {
							reportFHAEntry(report, fields, ci, EM2Util.getPrintName(failureModePA!=null?failureMode:ep), EM2Util.getPrintName(et));
						}
					}
				}
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
	
	protected void reportFHAEntry(WriteToFile report,EList<BasicPropertyAssociation> fields,ComponentInstance ci,
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
		reportEnumerationProperty(fields, "severity", report);
		// criticality
		addComma(report);
		reportEnumerationProperty(fields, "criticality", report);
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
	
	protected void reportStringProperty(EList<BasicPropertyAssociation> fields, String fieldName,WriteToFile report){
		BasicPropertyAssociation xref = EM2Util.getRecordField(fields, fieldName);
		if (xref != null){
			PropertyExpression val = xref.getOwnedValue();
			if (val instanceof StringLiteral){
				String text = ((StringLiteral)val).getValue();
				report.addOutput(makeCVSText(stripQuotes(text)));
			}
		}
	}
	
	protected void reportEnumerationProperty(EList<BasicPropertyAssociation> fields, String fieldName,WriteToFile report){
		BasicPropertyAssociation xref = EM2Util.getRecordField(fields, fieldName);
		if (xref != null){
			PropertyExpression val = xref.getOwnedValue();
			if (val instanceof NamedValue){
				 AbstractNamedValue eval = ((NamedValue)val).getNamedValue();
				 if (eval instanceof EnumerationLiteral)
				report.addOutput(((EnumerationLiteral)eval).getName());
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
