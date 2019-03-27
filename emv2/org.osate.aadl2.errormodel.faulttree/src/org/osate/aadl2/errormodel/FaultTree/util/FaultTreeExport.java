package org.osate.aadl2.errormodel.FaultTree.util;

import java.math.BigDecimal;

import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;

public class FaultTreeExport {

	public static void exportFaultTree(FaultTree ft) {
		SystemInstance si = ((InstanceObject) ft.getRoot().getRelatedInstanceObject()).getSystemInstance();
		WriteToFile xmlFile = new WriteToFile("FTA", si);
		xmlFile.setFileExtension("xml");
		toXML(xmlFile, ft.getRoot());
		xmlFile.saveToFile();

		WriteToFile ftaFile = new WriteToFile("FTA", si);
		ftaFile.setFileExtension("fta");
		ftaFile.addOutput(WriteToFile.getFileName("FTA", si) + ".ped\nS NULL 0\n3 fta\n");
		toPED(ftaFile, ft.getRoot());
		ftaFile.saveToFile();

		WriteToFile pedFile = new WriteToFile("FTA", si);
		pedFile.setFileExtension("ped");
		toPED(pedFile, ft.getRoot());
		pedFile.saveToFile();
	}

	private static void toXML(WriteToFile report, Event root) {

		report.addOutput("<event");
		report.addOutput(" id=\"" + root.getName() + "\" ");

		if (root.getProbability().compareTo(FaultTreeUtils.BigZero) != 0) {
			report.addOutput(" probability=\"" + root.getProbability() + "\"");
		}

		if (root.getType() == EventType.INTERMEDIATE) {
			report.addOutput(" type=\"event\"");
		} else if (root.getSubEventLogic() == LogicOperation.AND) {
			report.addOutput(" type=\"and\"");
		} else if (root.getSubEventLogic() == LogicOperation.OR) {
			report.addOutput(" type=\"or\"");
		} else if (root.getSubEventLogic() == LogicOperation.XOR) {
			report.addOutput(" type=\"xor\"");
		}
		if (root.getMessage() != null) {
			report.addOutput(" description=" + root.getMessage());
		}
		report.addOutputNewline(">");
		for (Event e : root.getSubEvents()) {
			toXML(report, e);
		}
		report.addOutputNewline("</event>");
	}

	private static void toPED(WriteToFile report, Event root) {
		BigDecimal prob;
		String description;

		if (root.getType() != EventType.INTERMEDIATE) {
			prob = root.getProbability();
			/**
			 * A probability of 0 makes the whole thing crash.
			 * So, we put a default prob of 0.1
			 */
			if (prob.compareTo(FaultTreeUtils.BigZero) == 0) {
				prob = new BigDecimal(0.1);
			}
			if (root.getMessage() != null) {
				description = root.getMessage();
			} else {
				description = root.getName() + "(no extended description)";
			}
			report.addOutputNewline(root.getName() + ";;B;" + description + ";" + prob + ";L;");
			return;
		}

		for (Event e : root.getSubEvents()) {
			toPED(report, e);
		}
	}

	private static void toFTA(WriteToFile report, Event root) {
		String title = "";
		if (root.getType() != EventType.INTERMEDIATE) {
			report.addOutputNewline("B " + root.getName() + " 0");
			return;
		}

		if ((root.getType() == EventType.INTERMEDIATE)
//				|| ((parent != null) && (type == EventType.AND) && (parent.getType() == EventType.AND))
//				|| ((parent != null) && (type == EventType.AND) && (parent.getType() == EventType.OR))
//				|| ((parent != null) && (type == EventType.OR) && (parent.getType() == EventType.AND))
//				|| ((parent != null) && (type == EventType.OR) && (parent.getType() == EventType.OR))
				) {
			report.addOutput("M " + root.getName());

			if (root.getType() == EventType.INTERMEDIATE) {
				if (root.getSubEvents().size() > 0) {
					report.addOutputNewline(" " + root.getSubEvents().size());
				} else {
					report.addOutputNewline(" 1");
				}
			} else {
				report.addOutputNewline(" 1");
			}

			title = root.getName();

			if (root.getMessage() != null) {
				title = root.getMessage();
			}

			report.addOutputNewline("" + title.length() + " " + title);

			/**
			 * If a state does not have subevents, we add a diamond in the FTA to show
			 * that it does not have other contributors. This makes the FTA complete.
			 * It has been suggestion by Bill Fletecher from the SAE S18 group.
			 */
			if (root.getType() == EventType.UNDEVELOPED) {
				report.addOutputNewline("U NULL 0\n");
			}
		}

		switch (root.getSubEventLogic()) {
		case AND: {
			report.addOutputNewline("A " + root.getName() + " " + root.getSubEvents().size());
			break;
		}
		case OR: {
			report.addOutputNewline("O " + root.getName() + " " + root.getSubEvents().size());
			break;
		}
		default: {
			break;
		}

		}

		for (Event e : root.getSubEvents()) {
			toFTA(report, e);
		}

		return;
	}

}
