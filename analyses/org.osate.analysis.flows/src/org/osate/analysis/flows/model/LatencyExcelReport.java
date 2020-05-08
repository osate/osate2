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
package org.osate.analysis.flows.model;

import java.io.IOException;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.FlowanalysisPlugin;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class LatencyExcelReport {
	private static final WritableCellFormat BOLD_FORMAT = new WritableCellFormat(
			new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD));
	private static final WritableCellFormat ERROR_FORMAT;
	private static final WritableCellFormat WARNING_FORMAT;

	static {
		WritableFont boldWhiteFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
		ERROR_FORMAT = new WritableCellFormat(boldWhiteFont);
		WARNING_FORMAT = new WritableCellFormat(boldWhiteFont);
		try {
			ERROR_FORMAT.setBackground(Colour.RED);
			WARNING_FORMAT.setBackground(Colour.LIGHT_ORANGE);
		} catch (WriteException e) {
			String pluginId = FlowanalysisPlugin.getDefault().getBundle().getSymbolicName();
			IStatus status = new Status(IStatus.ERROR, pluginId, e.getMessage(), e);
			StatusManager.getManager().handle(status);
		}
	}

	public static void generateExcelReport(AnalysisResult latres) {
		IFile file = getExcelFile(latres);
		try {
			if (file.exists()) {
				file.delete(true, null);
			}
			if (!latres.getResults().isEmpty()) {
				AadlUtil.makeSureFoldersExist(file.getFullPath());

				String reportHeader = "Latency analysis with preference settings: "
						+ FlowLatencyUtil.getParametersAsDescriptions(latres);

				WorkbookSettings wbSettings = new WorkbookSettings();
				wbSettings.setLocale(new Locale("en", "EN"));
				wbSettings.setCellValidationDisabled(false);
				wbSettings.setRationalization(false);

				WritableWorkbook workbook = Workbook.createWorkbook(file.getLocation().toFile(), wbSettings);

				int sheetNumber = 0;
				for (Result result : latres.getResults()) {
					InstanceObject instanceObject = (InstanceObject) result.getModelElement();
					String flowName = instanceObject.getComponentInstancePath();
					String systemName = instanceObject.getSystemInstance().getComponentClassifier().getName();
					String inMode = ResultUtil.getString(result, 0);
					String sheetName;
					if (inMode.isEmpty()) {
						sheetName = flowName;
					} else {
						sheetName = flowName + " in mode " + inMode;
					}
					WritableSheet sheet = workbook.createSheet(sheetName, sheetNumber);
					sheet.addCell(new Label(0, 0, reportHeader, BOLD_FORMAT));
					sheet.addCell(new Label(0, 2, "Latency results for end-to-end flow '" + flowName + "' of system '"
							+ systemName + "'" + inMode, BOLD_FORMAT));
					sheet.addCell(new Label(0, 4, "Result", BOLD_FORMAT));
					sheet.addCell(new Label(1, 4, "Min Specified", BOLD_FORMAT));
					sheet.addCell(new Label(2, 4, "Min Actual", BOLD_FORMAT));
					sheet.addCell(new Label(3, 4, "Min Method", BOLD_FORMAT));
					sheet.addCell(new Label(4, 4, "Max Specified", BOLD_FORMAT));
					sheet.addCell(new Label(5, 4, "Max Actual", BOLD_FORMAT));
					sheet.addCell(new Label(6, 4, "Max Method", BOLD_FORMAT));
					sheet.addCell(new Label(7, 4, "Comments", BOLD_FORMAT));
					int row = 5;
					for (Result contributor : result.getSubResults()) {
						for (Result subc : contributor.getSubResults()) {
							addContributor(sheet, row, subc, true);
							row++;
						}
						addContributor(sheet, row, contributor, false);
						row++;
					}
					sheet.addCell(new Label(0, row, "Latency Total"));
					sheet.addCell(new Label(1, row, ResultUtil.getReal(result, 3) + "ms"));
					sheet.addCell(new Label(2, row, ResultUtil.getReal(result, 1) + "ms"));
					sheet.addCell(new Label(4, row, ResultUtil.getReal(result, 4) + "ms"));
					sheet.addCell(new Label(5, row, ResultUtil.getReal(result, 2) + "ms"));
					row++;
					sheet.addCell(new Label(0, row, "Specified End To End Latency"));
					sheet.addCell(new Label(2, row, ResultUtil.getReal(result, 5) + "ms"));
					sheet.addCell(new Label(5, row, ResultUtil.getReal(result, 6) + "ms"));
					row++;
					sheet.addCell(new Label(0, row, "End To End Latency Summary", BOLD_FORMAT));
					row++;
					for (Diagnostic dia : result.getDiagnostics()) {
						sheet.addCell(new Label(0, row, dia.getDiagnosticType().toString(), getCellFormat(dia)));
						sheet.addCell(new Label(1, row, dia.getMessage()));
						row++;
					}
					sheetNumber++;
				}

				workbook.write();
				workbook.close();

				file.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			StatusManager.getManager().handle(e, FlowanalysisPlugin.getDefault().getBundle().getSymbolicName());
		} catch (IOException | WriteException e) {
			String pluginId = FlowanalysisPlugin.getDefault().getBundle().getSymbolicName();
			IStatus status = new Status(IStatus.ERROR, pluginId, e.getMessage(), e);
			StatusManager.getManager().handle(status);
		}
	}

	private static void addContributor(WritableSheet sheet, int row, Result contributor, boolean subcontributor)
			throws WriteException {
		String comp = FlowLatencyUtil.getContributorType(contributor.getModelElement()) + " "
				+ FlowLatencyUtil.getFullComponentContributorName(contributor.getModelElement());
		String flowSpecName = ResultUtil.getString(contributor, 6);
		if (!flowSpecName.isEmpty()) {
			comp = comp + " (" + flowSpecName + ")";
		}
		if (subcontributor) {
			comp = "(" + comp + ")";
		}
		sheet.addCell(new Label(0, row, comp));
		sheet.addCell(new Label(1, row, ResultUtil.getReal(contributor, 2) + "ms"));
		sheet.addCell(new Label(2, row, ResultUtil.getReal(contributor, 0) + "ms"));
		sheet.addCell(new Label(3, row, ResultUtil.getString(contributor, 4)));
		sheet.addCell(new Label(4, row, ResultUtil.getReal(contributor, 3) + "ms"));
		sheet.addCell(new Label(5, row, ResultUtil.getReal(contributor, 1) + "ms"));
		sheet.addCell(new Label(6, row, ResultUtil.getString(contributor, 5)));
		int column = 7;
		for (Diagnostic dia : contributor.getDiagnostics()) {
			sheet.addCell(new Label(column, row, dia.getMessage()));
			column++;
		}
	}

	private static CellFormat getCellFormat(Diagnostic dia) {
		switch (dia.getDiagnosticType()) {
		case ERROR:
			return ERROR_FORMAT;
		case WARNING:
			return WARNING_FORMAT;
		default:
			return BOLD_FORMAT;
		}
	}

	private static IFile getExcelFile(AnalysisResult ar) {
		URI arURI = ar.eResource().getURI();
		URI excelURI = arURI.trimFileExtension().appendFileExtension("xls");
		return OsateResourceUtil.toIFile(excelURI);
	}
}