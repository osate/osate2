package org.osate.analysis.flows.reporting.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Section;

public class CsvExport {
	private Report report;
	private IPath path;

	public CsvExport(Report r) {
		this.report = r;
	}

	// public static IPath getReportPath(EObject root, String subDirectory, String reportType, String fileSuffix,

	public StringBuffer getFileContent() {
		StringBuffer result;
		result = new StringBuffer();

		result.append("Latency Analysis Report");

		for (Section section : this.report.getSections()) {

			for (Line line : section.getLines()) {
				for (String content : line.getContent()) {
					result.append(content);
					result.append(",");
				}
				result.append("\n");
			}
			result.append("\n\n\n");
		}
		return result;
	}

	public void save(EObject relatedObject) {
		IPath path;
		IFile file;
		InputStream input;
		StringBuffer reportContent;

		path = ReportUtils.getReportPath(relatedObject, "latency", "latency", "latency", "csv");
		reportContent = this.getFileContent();

		if (path != null) {
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				input = new ByteArrayInputStream(reportContent.toString().getBytes());
				try {
					if (file.exists()) {
						file.setContents(input, true, true, null);
					} else {
						AadlUtil.makeSureFoldersExist(path);
						file.create(input, true, null);
					}
				} catch (final CoreException e) {
					OsateDebug.osateDebug("CsvExport", "Fail to create the report");
				}
			}
		}
	}

}
