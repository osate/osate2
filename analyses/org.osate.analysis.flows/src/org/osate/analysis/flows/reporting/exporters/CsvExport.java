package org.osate.analysis.flows.reporting.exporters;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.ReportedCell;
import org.osate.analysis.flows.reporting.model.Section;

public class CsvExport extends GenericExport {

	public CsvExport(Report r) {
		super(r);
		fileExtension = "csv";
	}

	public StringBuffer getFileContent() {
		StringBuffer result;
		result = new StringBuffer();
		result.append(report.getTextContent() + System.lineSeparator() + System.lineSeparator());
		for (Section section : report.getSections()) {
			for (Line line : section.getLines()) {
				for (ReportedCell content : line.getContent()) {
					result.append(content.getMessage());
					result.append(",");
				}
				result.append(System.lineSeparator());
			}
			result.append(System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
		}
		return result;
	}

	@Override
	public void save() {
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
				}
			}
		}
	}

}
