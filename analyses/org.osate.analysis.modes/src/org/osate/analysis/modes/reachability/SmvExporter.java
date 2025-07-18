/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.reachability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMNode;
import org.osate.analysis.modes.modemodel.Trigger;

public class SmvExporter extends FileExporter {

	private static final String FILE_EXT = "smv";

	private SOMGraph graph;

	SmvExporter(SOMGraph graph) {
		this.graph = graph;
	}

	@Override
	SOMGraph getGraph() {
		return graph;
	}

	@Override
	CharSequence getContent() {
		return generateSMV();
	}

	@Override
	String getFileExtension() {
		return FILE_EXT;
	}

	private List<ComponentInstance> modalComponents = new ArrayList<>(100);

	private Map<SOMNode, Integer> n2i = new HashMap<>(100);

	private Map<Trigger, Integer> tg2i = new HashMap<>(100);

	private SOMNode[][] somTable;

	StringBuilder generateSMV() {
		StringBuilder b = new StringBuilder();
		ComponentInstance root = graph.getLevels().get(0).getComponent();

		fillComponentList(root);
		if (modalComponents.isEmpty()) {
			b.append("The model has no modal components");
			return b;
		}

		var lc = graph.getLevels().size();
		var lastLevel = graph.getLevels().get(lc - 1);
		if (lastLevel.getTransitions().isEmpty()) {
			b.append("The model has no SOM transitions");
			return b;
		}

		var somCount = lastLevel.getNodes().size();
		var compCount = modalComponents.size();
		somTable = new SOMNode[somCount][compCount];

		fillNodeIndices(lastLevel.getNodes());
		somTable = new SOMNode[somCount][compCount];
		fillSomTable(somCount, compCount, lastLevel.getNodes());
		var triggerCount = fillTriggerMap();

		b.append("MODULE main\n");
		b.append("  IVAR\n");
		b.append("    trg: 0.." + (triggerCount - 1) + ";\n");
		b.append("  VAR\n");
		b.append("    som: 0.." + (somCount - 1) + ";\n");
		b.append("  ASSIGN\n");
		b.append("    init(som) := " + n2i.get(lastLevel.getInitialNode()) + ";\n");
		b.append("    next(som) := case\n");
		for (var n : lastLevel.getNodes()) {
			for (var tn : n.getOutTransitions()) {
				b.append("                   ");
				b.append("som = " + n2i.get(n) + " & trg = " + tg2i.get(tn.getTrigger()) + " : "
						+ n2i.get(tn.getDst()) + ";\n");
			}
		}
		b.append("                   TRUE : som;\n");
		b.append("                 esac;\n");

		for (int i = 0; i < compCount; i++) {
			var c = modalComponents.get(i);
			var name = c.eContainer() == null ? c.getName() : c.getComponentInstancePath();
			b.append("  VAR -- " + name + "\n");
			b.append("    c" + i + ": {_inactive_");
			for (var m : c.getModeInstances()) {
				b.append(", " + m.getName());
			}
			b.append("};\n");
			b.append("  ASSIGN\n");
			b.append("    c" + i + " := case\n");
			for (int j = 0; j < somCount; j++) {
				var dn = somTable[j][i];
				name = dn.isActive() ? dn.getMode().getName() : "_inactive_";
				b.append("            som = " + j + " : " + name + ";\n");
			}
			b.append("          esac;\n");
		}

		return b;
	}

	private void fillNodeIndices(List<SOMNode> nodes) {
		var i = 0;
		for (var n : nodes) {
			n2i.put(n, i++);
		}
	}

	private void fillSomTable(int somCount, int compCount, List<SOMNode> nodes) {
		for (var i = 0; i < nodes.size(); i++) {
			var n = nodes.get(i);
			var j = compCount - 1;
			while (n != null) {
				var comp = n.getLevel().getComponent();
				if (!comp.getModeInstances().isEmpty()) {
					somTable[i][j--] = n;
				}
				n = n.getParent();
			}
		}
	}

	private void fillComponentList(ComponentInstance c) {
		if (!c.getModeInstances().isEmpty()) {
			modalComponents.add(c);
		}
		for (var ch : c.getComponentInstances()) {
			fillComponentList(ch);
		}
	}

	private int fillTriggerMap() {
		var i = 0;
		for (var tg : graph.getTriggers().values()) {
			if (!tg.getTransitions().isEmpty()) {
				tg2i.put(tg, i);
				i++;
			}
		}
		return i;
	}

}
