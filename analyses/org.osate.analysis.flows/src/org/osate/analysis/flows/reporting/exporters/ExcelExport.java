package org.osate.analysis.flows.reporting.exporters;

import java.io.IOException;
import java.util.Locale;

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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Section;

public class ExcelExport extends GenericExport {
	private static WritableCellFormat normal;
	private static WritableCellFormat normalBold;
	private static WritableCellFormat warning;
	private static WritableCellFormat warningBold;
	private static WritableCellFormat error;
	private static WritableCellFormat errorBold;
	private static WritableCellFormat success;
	private static WritableCellFormat successBold;

	private static WritableFont defaultFont = new WritableFont(WritableFont.ARIAL, 10);
	private static WritableFont defaultFontBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
			UnderlineStyle.NO_UNDERLINE);
	private static WritableFont successFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
			UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	private static WritableFont successFontBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
			UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	private static WritableFont warningFont = successFont;
	private static WritableFont warningFontBold = successFontBold;
	private static WritableFont errorFont = successFont;
	private static WritableFont errorFontBold = successFontBold;

	public ExcelExport(Report r) {
		super(r);

		this.fileExtension = "xls";

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

	private void populateSheet(WritableSheet sheet, Section section) throws RowsExceededException, WriteException {
		int nbLines;
		WritableCellFormat format;

		nbLines = 0;

		for (Line line : section.getLines()) {
			switch (line.getSeverity()) {
			case ERROR:
				format = errorBold;
				break;
			case WARNING:
				format = warningBold;
				break;
			case SUCCESS:
				format = successBold;
				break;
			default:
				format = normal;
				break;
			}
			for (int col = 0; col < line.getContent().size(); col++) {
				addLabel(sheet, col, nbLines, line.getContent().get(col), format);
			}
			nbLines = nbLines + 1;
		}

	}

	public void save(EObject relatedObject) {

		WritableSheet excelSheet;
		IFile file;
		int sectionNumber;

		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook;
		try {
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(this.getPath());
			AadlUtil.makeSureFoldersExist(this.getPath());

			workbook = Workbook.createWorkbook(file.getLocation().toFile(), wbSettings);

			sectionNumber = 0;
			for (Section section : report.getSections()) {
//				workbook.createSheet("Flow Analysis" + sectionNumber, sectionNumber);
				workbook.createSheet(section.getName() + "(flow " + sectionNumber + ")", sectionNumber);

				excelSheet = workbook.getSheet(sectionNumber);
				populateSheet(excelSheet, section);
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
		}
	}
}
