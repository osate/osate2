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
package org.osate.aadl2.errormodel.FaultTree.util;

import java.math.BigDecimal;

import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;

/**
 * @deprecated Unused. Will be removed in 2.8.1
 */
@Deprecated
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
				prob = BigDecimal.valueOf(0.1);
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
}
