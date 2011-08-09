/*
*
* <copyright>
* Copyright  2004 by Carnegie Mellon University, all rights reserved.
*
* Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
* at http://www.eclipse.org/legal/cpl-v10.html.
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
* Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
* of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
* under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
* documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
* under the contract clause at 252.227.7013.
*
* </copyright>
*
*
* %W%
* @version %I% %H%
*/
package edu.cmu.sei.aadl.flowanalysis.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.osgi.framework.Bundle;

import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.Property;
import edu.cmu.sei.aadl.aadl2.UnitLiteral;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.aadl2.instance.SystemInstance;
import edu.cmu.sei.aadl.aadl2.instance.SystemOperationMode;
import edu.cmu.sei.aadl.flowanalysis.FlowLatencyAnalysisSwitch;
import edu.cmu.sei.aadl.flowanalysis.FlowanalysisPlugin;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager;
import edu.cmu.sei.aadl.modelsupport.util.AadlUtil;
import edu.cmu.sei.contributes.sei.names.SEI;
import edu.cmu.sei.osate.ui.actions.AbstractInstanceOrDeclarativeModelModifyActionAction;
import edu.cmu.sei.osate.workspace.names.standard.AadlProject;
import edu.cmu.sei.osate.workspace.names.standard.CommunicationProperties;
import edu.cmu.sei.osate.workspace.names.standard.ThreadProperties;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties;

public final class CheckFlowLatency extends AbstractInstanceOrDeclarativeModelModifyActionAction {
	private FlowLatencyProperties properties;

	protected void initPropertyReferences() {
		Property partitionLatency = lookupPropertyDefinition(SEI._NAME, SEI.PARTITION_LATENCY);
		Property isPartition = lookupPropertyDefinition(SEI._NAME, SEI.IS_PARTITION);
		Property dispatchProtocol = lookupPropertyDefinition(ThreadProperties .DISPATCH_PROTOCOL);
		Property Latency = lookupPropertyDefinition(CommunicationProperties.LATENCY);
		Property actualLatencyPD = lookupPropertyDefinition(CommunicationProperties.ACTUAL_LATENCY);
		Property deadlinePD = lookupPropertyDefinition(TimingProperties.DEADLINE);
		Property periodPD = lookupPropertyDefinition(TimingProperties.PERIOD);
		Property queuesizePD = lookupPropertyDefinition(CommunicationProperties.QUEUE_SIZE);
		UnitLiteral microSec = lookupUnitLiteral(AadlProject.TIME_UNITS, AadlProject.US_LITERAL);
		properties = new FlowLatencyProperties(dispatchProtocol, partitionLatency, isPartition, Latency,
				 actualLatencyPD, deadlinePD, periodPD, microSec,queuesizePD);
	}
	
	protected Bundle getBundle() {
		return FlowanalysisPlugin.getDefault().getBundle();
	}
	
	protected String getActionName() {
		return "Check flow latency";
	}
	
	protected String getMarkerType() {
		return "edu.cmu.sei.aadl.flowanalysis.FlowLatencyObjectMarker";
	}

//	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager, AObject declarativeObject) {
//		if (declarativeObject instanceof ComponentImpl) {
//			try {
//				final FlowLatencyAnalysisSwitch flowLatencySwitch =
//					new FlowLatencyAnalysisSwitch(properties, monitor, errManager);
//				monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
//				flowLatencySwitch.processBottomUpComponentImpl((ComponentImpl) declarativeObject);
//			} catch (PropertyIsModalException e) {
//				Dialog.showError("Latency analysis failed",
//						"Encountered modal-valued \"" +
//						e.getDefinition().getQualifiedName() +
//						"\" property on " +
//						e.getHolder().getName() + ".  Analysis aborted.");
//			} finally {
//				monitor.done();
//			}
//		} else {
//			Dialog.showError("Flow Latency Error",
//				"Please select a component implementation or an instance model");
//		}
//		
//		if (monitor.isCanceled()) {
//			throw new OperationCanceledException();
//		}
//	}

	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager, SystemInstance root, SystemOperationMode som) {
		int count = AadlUtil.countElementsBySubclass(root, ComponentInstance.class);
		monitor.beginTask(getActionName(), count);
		final FlowLatencyAnalysisSwitch flowLatencySwitch =
			new FlowLatencyAnalysisSwitch(properties, monitor, errManager);
		flowLatencySwitch.processPreOrderComponentInstance(root);
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		monitor.done();		
	}

@Override
protected void analyzeDeclarativeModel(IProgressMonitor monitor,
		AnalysisErrorReporterManager errManager, Element declarativeObject) {	
	int i=0;
}

}