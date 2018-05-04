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
		case SUCCESS:
			return successBold;
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
