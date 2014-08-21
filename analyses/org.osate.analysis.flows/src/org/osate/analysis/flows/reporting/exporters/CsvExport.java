package org.osate.analysis.flows.reporting.exporters;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Section;

public class CsvExport extends GenericExport {

	public CsvExport(Report r) {
		super(r);
		fileExtension = "csv";
	}

	public StringBuffer getFileContent() {
		StringBuffer result;
		result = new StringBuffer();

		result.append("Latency Analysis Report" + System.lineSeparator() + System.lineSeparator());

		for (Section section : report.getSections()) {
			result.append("Flow analysis for end to end flow " + section.getName() + System.lineSeparator());
			for (Line line : section.getLines()) {
				for (String content : line.getContent()) {
					result.append(content);
					result.append(",");
				}
				result.append(System.lineSeparator());
			}
			result.append(System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
		}
		return result;
	}

	@Override
	public void save(EObject relatedObject) {
		IFile file;
		InputStream input;
		StringBuffer reportContent;

		reportContent = getFileContent();

		if (getPath() != null) {
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(getPath());
			if (file != null) {
				input = new ByteArrayInputStream(reportContent.toString().getBytes());
				try {
					if (file.exists()) {
						file.setContents(input, true, true, null);
					} else {
						AadlUtil.makeSureFoldersExist(getPath());
						file.create(input, true, null);
					}
				} catch (final CoreException e) {
					OsateDebug.osateDebug("CsvExport", "Fail to create the report");
				}
			}
		}
	}

}
