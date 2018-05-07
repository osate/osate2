package org.osate.analysis.flows.reporting.exporters;

import org.eclipse.core.runtime.IPath;
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
		return ReportUtils.getReportPath(report.getRelatedObject(), report.getReportFolder(), report.getReportPostfix(),
				fileExtension);
	}

	public abstract void save();
}
