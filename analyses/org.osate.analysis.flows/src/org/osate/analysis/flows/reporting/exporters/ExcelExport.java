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
package org.osate.analysis.flows.reporting.exporters;

import java.io.IOException;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.ReportedCell;
import org.osate.analysis.flows.reporting.model.Section;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelExport extends GenericExport {
	private WritableCellFormat normal;
	private WritableCellFormat normalBold;
	private WritableCellFormat warning;
	private WritableCellFormat warningBold;
	private WritableCellFormat error;
	private WritableCellFormat errorBold;
	private WritableCellFormat success;
	private WritableCellFormat successBold;

	private WritableFont defaultFont;
	private WritableFont defaultFontBold;
	private WritableFont successFont;
	private WritableFont successFontBold;
	private WritableFont warningFont;
	private WritableFont warningFontBold;
	private WritableFont errorFont;
	private WritableFont errorFontBold;

	public ExcelExport(Report r) {
		super(r);

		this.fileExtension = "xls";

		defaultFont = new WritableFont(WritableFont.ARIAL, 10);
		defaultFontBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE);
		successFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.WHITE);
		successFontBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
		warningFont = successFont;
		warningFontBold = successFontBold;
		errorFont = successFont;
		errorFontBold = successFontBold;

		normal = new WritableCellFormat(defaultFont);
		normalBold = new WritableCellFormat(defaultFontBold);
		warning = new WritableCellFormat(warningFont);
		warningBold = new WritableCellFormat(warningFontBold);
		error = new WritableCellFormat(errorFont);
		errorBold = new WritableCellFormat(errorFontBold);
		success = new WritableCellFormat(successFont);
		successBold = new WritableCellFormat(successFontBold);

		try {
			error.setBackground(Colour.RED);
			errorBold.setBackground(Colour.RED);
			warning.setBackground(Colour.LIGHT_ORANGE);
			warningBold.setBackground(Colour.LIGHT_ORANGE);
			success.setBackground(Colour.GREEN);
			successBold.setBackground(Colour.GREEN);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	private static void addLabel(WritableSheet sheet, int column, int row, String s, WritableCellFormat cellformat)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, cellformat);
		sheet.addCell(label);
	}

	private void populateSheet(WritableSheet sheet, Section section, String reportHeading)
			throws RowsExceededException, WriteException {
		addLabel(sheet, 0, 0, reportHeading, normalBold);
		int row = 2;
		for (Line line : section.getLines()) {
			int col = 0;

			for (ReportedCell cell : line.getContent()) {
				addLabel(sheet, col, row, cell.getMessage(), getCellFormat(cell));
				col = col + 1;
			}
			row = row + 1;
		}

	}

	private WritableCellFormat getCellFormat(ReportedCell cell) {
		switch (cell.getSeverity()) {
		case ERROR:
			return error;
		case WARNING:
			return warningBold;
		case INFO:
			return normal;
		default:
			return normalBold;
		}

	}

	@Override
	public void save() {

		WritableSheet excelSheet;
		IFile file;
		int sectionNumber;
		WritableWorkbook workbook;
		WorkbookSettings wbSettings;

		wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));
		wbSettings.setCellValidationDisabled(false);
		wbSettings.setRationalization(false);

		try {
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(this.getPath());
			if (file.exists()) {
				file.delete(true, null);
			}
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(this.getPath());
			AadlUtil.makeSureFoldersExist(this.getPath());
//			file.touch(null);
			workbook = Workbook.createWorkbook(file.getLocation().toFile(), wbSettings);

			sectionNumber = 0;
			for (Section section : report.getSections()) {
//				workbook.createSheet("Flow Analysis" + sectionNumber, sectionNumber);
				excelSheet = workbook.createSheet(section.getName(), sectionNumber);

//				excelSheet = workbook.getSheet(sectionNumber);
				populateSheet(excelSheet, section, report.getTextContent());
				sectionNumber++;
			}

			workbook.write();
			workbook.close();
			file.refreshLocal(IResource.DEPTH_INFINITE, null);

		} catch (WriteException we) {
			we.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException bounds) {
			bounds.printStackTrace();
		}
	}
}
