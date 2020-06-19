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
package org.osate.analysis.resource.budgets.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.flows.reporting.exporters.CsvExport;
import org.osate.analysis.flows.reporting.exporters.ExcelExport;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;
import org.osate.analysis.resource.budgets.logic.PowerAnalysis;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;

/**
 * @since 2.0
 */
public class PowerAnalysisHandler extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	Report powerReport;

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.resource.budgets.PowerAnalysisMarker";
	}

	@Override
	protected String getActionName() {
		return "Power Analysis";
	}

	@Override
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
	}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		monitor.beginTask(getActionName(), 1);
		PowerAnalysis pas = new PowerAnalysis(errManager);

		pas.analyzePowerBudget(root, powerReport, som);

		monitor.done();
	}

	@Override
	protected boolean initializeAnalysis(NamedElement object) {
		if (object instanceof SystemInstance) {
			powerReport = new Report(object, "Power", "Power", ReportType.TABLE);
			return true;
		}
		return false;
	};

	@Override
	protected boolean finalizeAnalysis() {
		CsvExport csvExport = new CsvExport(powerReport);
		csvExport.save();
		ExcelExport excelExport = new ExcelExport(powerReport);
		excelExport.save();
		return true;
	};

	public void setErrManager() {
		this.errManager = new AnalysisErrorReporterManager(this.getAnalysisErrorReporterFactory());
	}

	public void setSummaryReport() {
		this.summaryReport = new StringBuffer();
	}

	public void saveReport() {
		this.getCSVLog().saveToFile();
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
	}

	public Report invokeAndGetReport(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
		return powerReport;
	}
}