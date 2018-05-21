package org.osate.analysis.flows.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

public class LatencyCSVReport {

	public StringBuffer getReportContent(AnalysisResult ar) {
		StringBuffer report = new StringBuffer();

		String reportheader = "Latency analysis with preference settings: "
				+ FlowLatencyUtil.getParametersAsDescriptions(ar.getInfo());

		report.append(reportheader + System.lineSeparator() + System.lineSeparator());
		for (Result result : ar.getResults()) {
			String flowname = ((InstanceObject) result.getSourceReference()).getComponentInstancePath();
			SystemInstance si = ((InstanceObject) result.getSourceReference()).getSystemInstance();
			String systemName = si.getComponentClassifier().getName();
			String inMode = ResultUtil.getString(result, 0);
			String analysisheader = "Latency results for end-to-end flow '" + flowname + "' of system '" + systemName
					+ "'"
					+ inMode;
			report.append(analysisheader + System.lineSeparator() + System.lineSeparator());
			report.append("Result,Min Specified,Min Actual,Min Method,Max Specified,Max Actual,Max Method,Comments"
					+ System.lineSeparator());
			for (Result contributor : result.getSubResults()) {
				for (Result subc : contributor.getSubResults()) {
					addContributor(report, contributor, true);
				}
				addContributor(report, contributor, false);
			}
			report.append("Latency Total'" + ResultUtil.getReal(result, 3) + "ms," + ResultUtil.getReal(result, 1)
					+ "ms,," + ResultUtil.getReal(result, 4) + "ms," + ResultUtil.getReal(result, 2) + "ms"
					+ System.lineSeparator());
			report.append("Specified End To End Latency,," + ResultUtil.getReal(result, 5) + ",,,"
					+ ResultUtil.getReal(result, 6) + System.lineSeparator());
			report.append("End to end Latency Summary" + System.lineSeparator());
			for (Diagnostic dia : result.getDiagnostics()) {
				report.append(dia.getType() + "," + dia.getMessage() + System.lineSeparator());
			}
			report.append(System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
		}
		return report;
	}

	private void addContributor(StringBuffer report, Result contributor, boolean subcontributor) {
		String comp = FlowLatencyUtil.getContributorType(contributor.getSourceReference()) + " "
				+ FlowLatencyUtil.getFullComponentContributorName((contributor.getSourceReference()));
		if (subcontributor) {
			comp = "(" + comp + ")";
		}
		report.append(comp + "," + ResultUtil.getReal(contributor, 2) + "ms," + ResultUtil.getReal(contributor, 0)
				+ "ms," + ResultUtil.getString(contributor, 9) + ResultUtil.getReal(contributor, 3) + "ms,"
				+ ResultUtil.getReal(contributor, 1) + "ms," + ResultUtil.getString(contributor, 8));
		for (Diagnostic dia : contributor.getDiagnostics()) {
			report.append("," + dia.getMessage());
		}
		report.append(System.lineSeparator());
	}

	public void generateCSVReport(AnalysisResult latres) {
		IFile file;
		InputStream input;
		StringBuffer reportContent;

		reportContent = getReportContent(latres);
		IPath csvPath = getCSVPath(latres);
		if (csvPath != null) {
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(csvPath); // getFileForLocation
			if (file != null) {
				input = new ByteArrayInputStream(reportContent.toString().getBytes());
				try {
					if (file.exists()) {
						file.setContents(input, true, true, null);
					} else {
						AadlUtil.makeSureFoldersExist(csvPath);
						file.create(input, true, null);
					}
				} catch (final CoreException e) {
				}
			}
		}
	}

	public IPath getCSVPath(AnalysisResult ar) {
		URI arURI = ar.eResource().getURI();
		URI csvURI = arURI.trimFileExtension().appendFileExtension("csv");
		return new Path(csvURI.toString());
	}

}
