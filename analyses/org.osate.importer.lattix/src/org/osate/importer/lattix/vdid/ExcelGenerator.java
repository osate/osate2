/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the �Content� or �Material�) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.vdid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
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

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.impl.ProcessorImplementationImpl;
import org.osate.aadl2.impl.SubprogramCallImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.importer.Utils;
import org.osate.importer.properties.CriticalityProperty;
import org.osate.importer.properties.SlocProperty;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ExcelGenerator {

	private static WritableCellFormat timesBoldUnderline;
	private static WritableCellFormat times;

	private static void getSubprogramsWithThreads(HashMap<SubprogramCall, ComponentInstance> spgs,
			ComponentInstance ci) {
		if ((ci.getCategory() == ComponentCategory.THREAD)
				&& (ci.getComponentClassifier() instanceof ThreadImplementation)) {
			ThreadImplementation ti = (ThreadImplementation) ci.getComponentClassifier();
			for (SubprogramCall cs : ti.getSubprogramCalls()) {
				if (!(cs instanceof SubprogramCallImpl)) {
					continue;
				}

				SubprogramCallImpl sci = (SubprogramCallImpl) cs;

				if (sci.getCalledSubprogram() instanceof SubprogramClassifier) {
//
//					System.out.println ("SPG " + sci.getCalledSubprogram());
//					System.out.println ("THR " + ci);

					spgs.put(cs, ci);
				}
			}
		}
		for (Element e : ci.getChildren()) {
			if (e instanceof ComponentInstance) {

				getSubprogramsWithThreads(spgs, (ComponentInstance) e);
			}
		}
	}

	private static void getSubprogramsWithCPU(HashMap<SubprogramCall, ComponentInstance> spgs, ComponentInstance ci) {
		if ((ci.getCategory() == ComponentCategory.THREAD)
				&& (ci.getComponentClassifier() instanceof ThreadImplementation)) {
			ComponentInstance cpu = GetProperties.getActualProcessorBinding(ci.getContainingComponentInstance()).get(0);
			ThreadImplementation ti = (ThreadImplementation) ci.getComponentClassifier();
			for (SubprogramCall cs : ti.getSubprogramCalls()) {
				if (!(cs instanceof SubprogramCallImpl)) {
					continue;
				}

				SubprogramCallImpl sci = (SubprogramCallImpl) cs;

				if (sci.getCalledSubprogram() instanceof SubprogramClassifier) {

//					System.out.println ("SPG " + sci.getCalledSubprogram());
//					System.out.println ("CPU " + cpu);

					spgs.put(cs, cpu);
				}
			}
		}
		for (Element e : ci.getChildren()) {
			if (e instanceof ComponentInstance) {

				getSubprogramsWithCPU(spgs, (ComponentInstance) e);
			}
		}
	}

	private static boolean areConnected(ComponentInstance thr1, ComponentInstance thr2, ComponentInstance root) {
		for (ConnectionInstance ci : root.getAllEnclosingConnectionInstances()) {
			if ((ci.getSource().getContainingComponentInstance() == thr1)
					&& (ci.getDestination().getContainingComponentInstance() == thr2)) {
				return true;
			}

			if ((ci.getSource().getContainingComponentInstance() == thr2)
					&& (ci.getDestination().getContainingComponentInstance() == thr1)) {
				return true;
			}
		}
		return false;
	}

	private static void createCriticalityMatrix(WritableSheet sheet, ComponentInstance systemInstance)
			throws WriteException {
		int crit;
		Colour colour;
		String label;
		int row;
		HashMap<SubprogramCall, ComponentInstance> subprogramsCPU;
		HashMap<SubprogramCall, ComponentInstance> subprogramsThreads;

		addCaption(sheet, 0, 0, "Criticality Matrix");
		row = 1;

		subprogramsCPU = new HashMap<SubprogramCall, ComponentInstance>();
		subprogramsThreads = new HashMap<SubprogramCall, ComponentInstance>();

		getSubprogramsWithCPU(subprogramsCPU, systemInstance);
		getSubprogramsWithThreads(subprogramsThreads, systemInstance);

		for (SubprogramCall cs : subprogramsCPU.keySet()) {
			SubprogramCallImpl sci = (SubprogramCallImpl) cs;
			addLabel(sheet, row, 1, ((SubprogramType) sci.getCalledSubprogram()).getName());
			addLabel(sheet, 0, row + 1, ((SubprogramType) sci.getCalledSubprogram()).getName());

			int col = 1;
			for (SubprogramCall cs2 : subprogramsCPU.keySet()) {
				ComponentInstance cpu1 = subprogramsCPU.get(cs);
				ComponentInstance cpu2 = subprogramsCPU.get(cs2);
				ComponentInstance thr1 = subprogramsThreads.get(cs);
				ComponentInstance thr2 = subprogramsThreads.get(cs2);

				label = null;
				if (areConnected(thr1, thr2, systemInstance)) {
					if (CriticalityProperty.getCriticality(cpu1) == CriticalityProperty.getCriticality(cpu2)) {
						label = "OK";
						colour = Colour.GREEN;
					} else {
						label = "KO";
						colour = Colour.RED;
					}
					if (label != null) {
						addLabel(sheet, col, row + 1, label, colour);
					}
				}

				col++;
			}
			row++;
		}

	}

	private static String getLocationProximity(SubprogramCall cs1, ComponentInstance t1, SubprogramCall cs2,
			ComponentInstance t2) {
		if (t1 == t2) {
			return "L";
		}
		if (t1.getContainingComponentInstance() == t2.getContainingComponentInstance()) {
			return "M";
		}
		return "H";
	}

	private static void createLocationMatrix(WritableSheet sheet, ComponentInstance systemInstance)
			throws WriteException {
		addLabel(sheet, 0, 0, "Location Matrix");
		HashMap<SubprogramCall, ComponentInstance> subprograms;

		subprograms = new HashMap<SubprogramCall, ComponentInstance>();

		getSubprogramsWithThreads(subprograms, systemInstance);
		int row = 2;
		for (SubprogramCall cs : subprograms.keySet()) {
			SubprogramCallImpl sci = (SubprogramCallImpl) cs;
			ComponentInstance cpu = subprograms.get(cs);
			addLabel(sheet, row - 1, 1, ((SubprogramType) sci.getCalledSubprogram()).getName());
			addLabel(sheet, 0, row, ((SubprogramType) sci.getCalledSubprogram()).getName());

			int col = 1;
			for (SubprogramCall cs2 : subprograms.keySet()) {
				addLabel(sheet, col, row, getLocationProximity(cs, subprograms.get(cs), cs2, subprograms.get(cs2)));
				col++;
			}
			row++;
		}
	}

	private static void createDsmMatrix(WritableSheet sheet, MatrixGenerator matrix, List<String> comps)
			throws WriteException {
		addLabel(sheet, 0, 0, "DSM Matrix for level 0");
//		System.out.println ("max" + matrix.getMaxConnections());
		int nbConnections;
		int srcIndex;
		int dstIndex;
		double relativeWeight;

		relativeWeight = 1.0 / matrix.getMaxConnections();

		for (String s : comps) {
			addLabel(sheet, 0, comps.indexOf(s) + 2, s);
			addLabel(sheet, comps.indexOf(s) + 1, 1, s);
			srcIndex = comps.indexOf(s);

			if (matrix.getCriticality(s) != CriticalityProperty.INVALID_CRITICALITY) {
				addLabel(sheet, srcIndex + 1, srcIndex + 2, CriticalityProperty.toString(matrix.getCriticality(s)));
			}

			List<String> ltmp = matrix.getMatrix().get(s);
			if (ltmp != null) {
				for (String tmp : ltmp) {
					if (comps.contains(tmp)) {
						dstIndex = comps.indexOf(tmp);
						// System.out.println ("Max connections=" + matrix.getMaxConnections());
						// System.out.println ("Nb connections between + " + s + " and " + tmp + "=" +
// matrix.getNbConnection(s, tmp));
						nbConnections = matrix.getNbConnection(s, tmp);

						addNumber(sheet, srcIndex + 1, dstIndex + 2, 1);

					}
				}
			}
		}
	}

	private static void createCostImpactReport(WritableSheet sheet, MatrixGenerator matrix, List<String> comps,
			CostGenerator costGenerator) throws WriteException {
		int line;

		line = 0;

		addLabel(sheet, 0, 0, "Impact on SLOCs");

//		System.out.println ("max" + matrix.getMaxConnections());

		addLabel(sheet, 1, 1, "Total");
		addLabel(sheet, 2, 1, "Level A");
		addLabel(sheet, 3, 1, "Level B");
		addLabel(sheet, 4, 1, "Level C");
		addLabel(sheet, 5, 1, "Level D");
		addLabel(sheet, 6, 1, "Level E");
		addLabel(sheet, 7, 1, "Unknown");

		for (String s : comps) {
			CostImpactReport report = costGenerator.getReport(s);
			if (report != null) {
//				System.out.println ("comp (" + s + ", nslocs=" + matrix.getSlocs (s) + ")");
				addLabel(sheet, 0, line + 2, s);
				addNumber(sheet, 1, line + 2, report.getTotalImpactedSlocs());
				addNumber(sheet, 2, line + 2, report.getImpactedSlocs(CriticalityProperty.LEVEL_A));
				addNumber(sheet, 3, line + 2, report.getImpactedSlocs(CriticalityProperty.LEVEL_B));
				addNumber(sheet, 4, line + 2, report.getImpactedSlocs(CriticalityProperty.LEVEL_C));
				addNumber(sheet, 5, line + 2, report.getImpactedSlocs(CriticalityProperty.LEVEL_D));
				addNumber(sheet, 6, line + 2, report.getImpactedSlocs(CriticalityProperty.LEVEL_E));
				addNumber(sheet, 7, line + 2, report.getImpactedSlocs(CriticalityProperty.INVALID_CRITICALITY));
				line = line + 1;
			}
		}

	}

	private static void createGeneralReport(WritableSheet sheet, MetricsReporter reporter, CostGenerator costGenerator,
			MatrixGenerator matrix, ComponentInstance mainSystem) throws WriteException {
		CellView cv;
		WritableFont times10pt;
		List<ComponentInstance> componentsList;
		WritableFont times10ptBoldUnderline;
		String compName;
		int line;

		times10pt = new WritableFont(WritableFont.TIMES, 10);
		times = new WritableCellFormat(times10pt);
		// times.setWrap(true);
		times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// timesBoldUnderline.setWrap(true);

		cv = new CellView();
		times.setAlignment(Alignment.CENTRE);
		timesBoldUnderline.setAlignment(Alignment.CENTRE);
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);

		// Write a few headers
		addCaption(sheet, 0, 0, "Component type");
		addCaption(sheet, 1, 0, "Total");

		addLabel(sheet, 0, 1, "System");
		addLabel(sheet, 0, 2, "Abstract");
		addLabel(sheet, 0, 3, "Process");
		addLabel(sheet, 0, 4, "Thread");
		addLabel(sheet, 0, 5, "Processor");
		addLabel(sheet, 0, 6, "Bus");
		addLabel(sheet, 0, 7, "Data");
		addLabel(sheet, 0, 8, "Device");
		addLabel(sheet, 0, 9, "Memory");
		addLabel(sheet, 0, 10, "Virtual Processor");
		addLabel(sheet, 0, 11, "Virtual Bus");
		addLabel(sheet, 0, 12, "Total SLOCS");

		addNumber(sheet, 1, 1, reporter.getNbSystem());
		addNumber(sheet, 1, 2, reporter.getNbAbstract());
		addNumber(sheet, 1, 3, reporter.getNbProcess());
		addNumber(sheet, 1, 4, reporter.getNbThread());
		addNumber(sheet, 1, 5, reporter.getNbProcessor());
		addNumber(sheet, 1, 6, reporter.getNbBus());
		addNumber(sheet, 1, 7, reporter.getNbData());
		addNumber(sheet, 1, 8, reporter.getNbDevice());
		addNumber(sheet, 1, 9, reporter.getNbMemory());
		addNumber(sheet, 1, 10, reporter.getNbVirtualProcessor());
		addNumber(sheet, 1, 11, reporter.getNbVirtualBus());
		addNumber(sheet, 1, 12, reporter.getSLOCS());

		if (reporter.useCriticalityLevel(CriticalityProperty.INVALID_CRITICALITY))
			addCaption(sheet, 2, 0, "Unknown");

		if (reporter.useCriticalityLevel(CriticalityProperty.LEVEL_A))
			addCaption(sheet, 3, 0, "Level A");

		if (reporter.useCriticalityLevel(CriticalityProperty.LEVEL_B))
			addCaption(sheet, 4, 0, "Level B");

		if (reporter.useCriticalityLevel(CriticalityProperty.LEVEL_C))
			addCaption(sheet, 5, 0, "Level C");

		if (reporter.useCriticalityLevel(CriticalityProperty.LEVEL_D))
			addCaption(sheet, 6, 0, "Level D");

		if (reporter.useCriticalityLevel(CriticalityProperty.LEVEL_E))
			addCaption(sheet, 7, 0, "Level E");

		for (int crit = 0; crit < CriticalityProperty.NB_CRITICALITIES; crit++) {

			if (reporter.useCriticalityLevel(crit) == false) {
				continue;
			}

			addNumber(sheet, 2 + crit, 1, reporter.getNbSystem(crit));
			addNumber(sheet, 2 + crit, 2, reporter.getNbAbstract(crit));
			addNumber(sheet, 2 + crit, 3, reporter.getNbProcess(crit));
			addNumber(sheet, 2 + crit, 4, reporter.getNbThread(crit));
			addNumber(sheet, 2 + crit, 5, reporter.getNbProcessor(crit));
			addNumber(sheet, 2 + crit, 6, reporter.getNbBus(crit));
			addNumber(sheet, 2 + crit, 7, reporter.getNbData(crit));
			addNumber(sheet, 2 + crit, 8, reporter.getNbDevice(crit));
			addNumber(sheet, 2 + crit, 9, reporter.getNbMemory(crit));
			addNumber(sheet, 2 + crit, 10, reporter.getNbVirtualProcessor(crit));
			addNumber(sheet, 2 + crit, 11, reporter.getNbVirtualBus(crit));
			addNumber(sheet, 2 + crit, 12, reporter.getSLOCS(crit));

		}

		/*
		 * Function criticality
		 */
		line = 20;
		addCaption(sheet, 0, line - 1, "Criticality of Functions");
		HashMap<SubprogramCall, ComponentInstance> subprograms;

		subprograms = new HashMap<SubprogramCall, ComponentInstance>();

		getSubprogramsWithCPU(subprograms, mainSystem);

		for (SubprogramCall cs : subprograms.keySet()) {
			SubprogramCallImpl sci = (SubprogramCallImpl) cs;
			ComponentInstance cpu = subprograms.get(cs);
			addLabel(sheet, 0, line, ((SubprogramType) sci.getCalledSubprogram()).getName());
			addLabel(sheet, 1, line, CriticalityProperty.toString(CriticalityProperty.getCriticality(cpu)));
			line++;
		}

		line = line + 2;

		/*
		 * List of components
		 */
		componentsList = new ArrayList<ComponentInstance>();
		Utils.listComponents(costGenerator.getMainComponent(), componentsList);
		addCaption(sheet, 0, line++, "List of components");

		addCaption(sheet, 0, line, "Name");
		addCaption(sheet, 1, line, "Lines of code");
		addCaption(sheet, 2, line, "Criticality");
		addCaption(sheet, 3, line, "Criticality");
		addCaption(sheet, 3, line, "# incoming connections");
		addCaption(sheet, 4, line, "# outgoing connections");
		addCaption(sheet, 5, line, "Primary connections");
		line++;

		for (ComponentInstance componentTemp : componentsList) {
			StringBuffer tmp = new StringBuffer();
			addCaption(sheet, 0, line, Utils.getComponentName(componentTemp));
			addNumber(sheet, 1, line, SlocProperty.getSloc(componentTemp));
			addCaption(sheet, 2, line, CriticalityProperty.toString(CriticalityProperty.getCriticality(componentTemp)),
					false);
			compName = Utils.getComponentName(componentTemp);

			/**
			 * # incoming connections
			 */
			int nbIncoming = 0;
			for (Feature f : componentTemp.getComponentClassifier().getAllFeatures()) {
				if (f instanceof Port) {
					Port p = (Port) f;
					if ((p.getDirection() == DirectionType.IN) || (p.getDirection() == DirectionType.IN_OUT)) {
						nbIncoming++;
					}
				}
			}
			addNumber(sheet, 3, line, nbIncoming);

			/**
			 * # outgoing connections
			 */
			int nbOutgoing = 0;
			for (Feature f : componentTemp.getComponentClassifier().getAllFeatures()) {
				if (f instanceof Port) {
					Port p = (Port) f;
					if ((p.getDirection() == DirectionType.OUT) || (p.getDirection() == DirectionType.IN_OUT)) {
						nbOutgoing++;
					}
				}
			}
			addNumber(sheet, 4, line, nbOutgoing);

			/**
			 * Primary connections
			 */
			if (matrix.getMatrix().get(compName) != null) {
				for (String v : matrix.getMatrix().get(compName)) {
					tmp.append(v + "|");
				}
				addCaption(sheet, 5, line, tmp.toString(), false);
			}

			line++;
		}

		line = line + 3;

		/**
		 * List all processors with information about number of partitions
		 */
		addCaption(sheet, 0, line++, "List of processors");

		addCaption(sheet, 0, line, "Name");
		addCaption(sheet, 1, line, "Number of partitions");
		line++;

		for (ComponentInstance componentTemp : componentsList) {
			if (componentTemp.getComponentClassifier().getCategory() == ComponentCategory.PROCESSOR) {
				int nbPartitions = 0;
				addCaption(sheet, 0, line, Utils.getComponentName(componentTemp));

				if (componentTemp.getComponentClassifier() instanceof ProcessorImplementationImpl) {
					ProcessorImplementation pi = (ProcessorImplementation) componentTemp.getComponentClassifier();
					for (Subcomponent s : pi.getAllSubcomponents()) {
						if (s.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
							nbPartitions++;
						}
					}
				}
				addNumber(sheet, 3, line, nbPartitions);
				line++;
			}
		}

		line = line + 3;

		/**
		 * List all busses with associated connections
		 */
		addCaption(sheet, 0, line++, "List of buses");

		addCaption(sheet, 0, line, "Name");
		addCaption(sheet, 1, line, "Number of connections");
		line++;

		for (ComponentInstance componentTemp : componentsList) {
			if (componentTemp.getComponentClassifier().getCategory() == ComponentCategory.BUS) {
				int nbConnections = 0;
				addCaption(sheet, 0, line, Utils.getComponentName(componentTemp));
				for (ConnectionInstance ci : componentTemp.getSystemInstance().getAllConnectionInstances()) {
					for (ComponentInstance boundComponent : GetProperties.getActualConnectionBinding(ci)) {
						if (boundComponent == componentTemp) {
							nbConnections++;
						}
					}
				}
				addNumber(sheet, 3, line, nbConnections);
				line++;
			}
		}

		line = line + 3;

		addCaption(sheet, 0, line++, "Cost Analysis using McCormack boolean method");

		addCaption(sheet, 0, line, "Total links");
		addNumber(sheet, 1, line++, costGenerator.getTotal());

		addCaption(sheet, 0, line, "Components");
		addNumber(sheet, 1, line++, costGenerator.getDepth());

		addCaption(sheet, 0, line, "Propagation Cost");
		addNumber(sheet, 1, line++, costGenerator.getCost());
	}

	private static void addCaption(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
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

	private static void addNumber(WritableSheet sheet, int column, int row, Integer integer)
			throws WriteException, RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addNumber(WritableSheet sheet, int column, int row, Long integer)
			throws WriteException, RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addNumber(WritableSheet sheet, int column, int row, Double integer)
			throws WriteException, RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private static void addLabel(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);
	}

	private static void addLabel(WritableSheet sheet, int column, int row, String s, Colour col)
			throws WriteException, RowsExceededException {
		Label label;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		WritableCellFormat t = new WritableCellFormat(times10pt);
		t.setBackground(col);
		label = new Label(column, row, s, t);
		sheet.addCell(label);
	}

	public static void writeReport(String path, ComponentInstance mainComponent, MetricsReporter reporter,
			MatrixGenerator matrix, List<String> comps) throws IOException, WriteException {
		WritableSheet excelSheet;
		File file;
		CostGenerator costGenerator = new CostGenerator(matrix, mainComponent);

		costGenerator.compute();
		file = new File(path);
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);

		workbook.createSheet("General Report", 0);
		excelSheet = workbook.getSheet(0);
		createGeneralReport(excelSheet, reporter, costGenerator, matrix, mainComponent);

		workbook.createSheet("DSM Matrix", 1);
		excelSheet = workbook.getSheet(1);
		createDsmMatrix(excelSheet, matrix, comps);

		workbook.createSheet("Cost Impact", 2);
		excelSheet = workbook.getSheet(2);
		createCostImpactReport(excelSheet, matrix, comps, costGenerator);

		workbook.createSheet("Criticality", 3);
		excelSheet = workbook.getSheet(3);
		createCriticalityMatrix(excelSheet, mainComponent);

		workbook.createSheet("Location", 4);
		excelSheet = workbook.getSheet(4);
		createLocationMatrix(excelSheet, mainComponent);
		workbook.write();
		workbook.close();
	}
}