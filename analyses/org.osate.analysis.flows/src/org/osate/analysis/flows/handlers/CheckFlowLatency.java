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
package org.osate.analysis.flows.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.model.LatencyReport;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.analysis.flows.reporting.exporters.CsvExport;
import org.osate.analysis.flows.reporting.exporters.ExcelExport;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.result.Result;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;

public final class CheckFlowLatency extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	protected static LatencyReport latreport = null;

	@Override
	protected String getActionName() {
		return "Check flow latency";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.flows.FlowLatencyObjectMarker";
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
		Dialog.showError("Flow Latency Error", "Please select an instance model");
	}

	@Override
	protected boolean initializeAnalysis(NamedElement object) {
		if (object instanceof SystemInstance) {
			latreport = new LatencyReport((SystemInstance) object);
			return true;
		}
		return false;
	};

	@Override
	protected boolean finalizeAnalysis() {
		if (latreport != null && !latreport.getEntries().isEmpty()) {
			// do cvs and xsl reports
			Report report = latreport.export();
			CsvExport csvExport = new CsvExport(report);
			csvExport.save();
			ExcelExport excelExport = new ExcelExport(report);
			excelExport.save();

			generateMarkers(latreport, errManager);


			Result results = latreport.genResult();
			SystemInstance root = latreport.getRootinstance();
			URI rootURI = EcoreUtil.getURI(root).trimFragment().trimFileExtension();
			String rootname = rootURI.lastSegment();
			URI latencyURI = rootURI.trimFragment().trimSegments(1).appendSegment("reports")
					.appendSegment("latency")
					.appendSegment(rootname + "__latency_" + latreport.getPreferencesSuffix() + ".result");
			AadlUtil.makeSureFoldersExist(new Path(latencyURI.toPlatformString(true)));
			OsateResourceUtil.saveEMFModel(results, latencyURI, root);
		}
		return true;
	};

	private void generateMarkers(LatencyReport report, AnalysisErrorReporterManager errMgr) {
		for (LatencyReportEntry re : report.getEntries()) {
			re.generateMarkers(errMgr);
		}
	}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		monitor.beginTask(getActionName(), 1);
		FlowLatencyAnalysisSwitch flas = new FlowLatencyAnalysisSwitch(monitor, root, latreport);
		flas.processPreOrderAll(root);
		monitor.done();
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root, SystemOperationMode som) {
		initializeAnalysis(root);
		analyzeInstanceModel(monitor, null, root, som);
		finalizeAnalysis();
	}


}