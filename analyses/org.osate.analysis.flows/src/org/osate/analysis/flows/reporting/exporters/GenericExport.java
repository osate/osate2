package org.osate.analysis.flows.reporting.exporters;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.osate.analysis.flows.preferences.Values;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.utils.ReportUtils;

public abstract class GenericExport {
	protected Report report;
	protected String fileExtension;

	public GenericExport(Report r) {
		this.report = r;
	}

	// public static IPath getReportPath(EObject root, String subDirectory, String reportType, String fileSuffix,

	public IPath getPath() {
		return ReportUtils.getReportPath(report.getRelatedObject(), "latency", "latency", getPreferencesSuffix(),
				fileExtension);
	}

	public String getPreferencesSuffix() {
		return Values.getSynchronousSystemLabel() + "-" + Values.getMajorFrameDelayLabel() + "-"
				+ Values.getWorstCaseDeadlineLabel() + "-" + Values.getBestcaseEmptyQueueLabel();
	}

	public abstract void save(EObject relatedObject);
}
