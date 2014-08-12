package org.osate.analysis.flows.reporting.exporters;

import java.io.IOException;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Section;

public class ExcelExport extends GenericExport {
	private static WritableCellFormat timesBoldUnderline;
	private static WritableCellFormat times;
	private WritableFont times10pt;
	private WritableFont times10ptBoldUnderline;

	public ExcelExport(Report r) {
		super(r);

		this.fileExtension = "xls";

		times10pt = new WritableFont(WritableFont.TIMES, 10);
		times = new WritableCellFormat(times10pt);
		// times.setWrap(true);
		times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
	}

	private static void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException,
			WriteException {
		addCaption(sheet, column, row, s, true);
	}

	private static void addCaption(WritableSheet sheet, int column, int row, String s, boolean bold)
			throws RowsExceededException, WriteException {
		Label label;
		WritableCellFormat toUse;

		if (bold) {
			toUse = timesBoldUnderline;
		} else {
			toUse = times;
		}

		label = new Label(column, row, s, toUse);
		sheet.addCell(label);
	}

	private static void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException,
			RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addNumber(WritableSheet sheet, int column, int row, Long integer) throws WriteException,
			RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addNumber(WritableSheet sheet, int column, int row, Double integer) throws WriteException,
			RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException,
			RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);
	}

	private static void addLabel(WritableSheet sheet, int column, int row, String s, Colour col) throws WriteException,
			RowsExceededException {
		Label label;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		WritableCellFormat t = new WritableCellFormat(times10pt);
		t.setBackground(col);
		label = new Label(column, row, s, t);
		sheet.addCell(label);
	}

	private void populateSheet(WritableSheet sheet, Section section) throws RowsExceededException, WriteException {
		int nbLines = 0;
		for (Line line : section.getLines()) {
			for (int col = 0; col < line.getContent().size(); col++) {
				addLabel(sheet, col, nbLines, line.getContent().get(col));
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
			workbook = Workbook.createWorkbook(file.getLocation().toFile(), wbSettings);

			sectionNumber = 0;
			for (Section section : report.getSections()) {
				workbook.createSheet("Flow Analysis" + sectionNumber, sectionNumber);
				excelSheet = workbook.getSheet(sectionNumber);
				populateSheet(excelSheet, section);
				sectionNumber++;
			}

			workbook.write();
			workbook.close();
		} catch (WriteException we) {
			we.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
