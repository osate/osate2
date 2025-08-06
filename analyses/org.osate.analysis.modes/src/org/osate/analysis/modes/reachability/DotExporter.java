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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.analysis.modes.modemodel.ActiveNode;
import org.osate.analysis.modes.modemodel.FeatureTrigger;
import org.osate.analysis.modes.modemodel.InactiveNode;
import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMNode;

public class DotExporter extends FileExporter {

	private static final String FILE_EXT = "dot";

	private SOMGraph graph;

	private static final boolean SKIP_DEAD_NODES = true;

	private Set<SOMNode> deadNodes = new HashSet<>();

	DotExporter() {
	}

	@Override
	Resource getGraphs() {
		return graph.eResource();
	}

	@Override
	CharSequence getContent() {
		return generateDOT();
	}

	private void collectDeadNodes() {
		var levels = graph.getLevels();
		int levelCount = levels.size();
		for (int i = levelCount - 2; i >= 0; i--) {
			for (var pn : levels.get(i).getNodes()) {
				boolean dead = true;
				for (var cn : pn.getChildren()) {
					if (cn.isReachable() && !deadNodes.contains(cn)) {
						dead = false;
						break;
					}
				}
				if (dead) {
					deadNodes.add(pn);
				}
			}
		}
	}

	@Override
	String getFileExtension() {
		return FILE_EXT;
	}

	StringBuilder generateDOT() {
		var b = new StringBuilder();
		b.append("""
				digraph {
				  rankdir=LR
				""");
		var domainNo = ModeDomain.domains.size() - 1;
		for (var d : ModeDomain.domains.reversed()) {
			graph = d.graph;
			deadNodes.clear();
			if (SKIP_DEAD_NODES) {
				collectDeadNodes();
			}
			var label = "Mode domain D%d: %s".formatted(domainNo, d.root.getInstanceObjectPath());
			generateDOT(b, label, domainNo);
			domainNo -= 1;
		}
		b.append("}\n");
		return b;
	}

	StringBuilder generateDOT(StringBuilder b, String name, int domainNo) {
		var node2n = new HashMap<SOMNode, Integer>();
		b.append("""
				  subgraph {
				    cluster=true
				    newrank=true
				    compound=true
				    labeljust=l
				    nodesep=0.5 ranksep=0.5
				    label="%s"
				""".formatted(name));

		var n = 1;
		final int lastLevel = graph.getLevels().size() - 1;
		for (int l = 0; l <= lastLevel; l++) {
			var level = graph.getLevels().get(l);
			var n0 = n;
			var label = level.getComponent().getFullName();
			b.append("    subgraph l" + l + " {\n");
			b.append("      cluster=true\n");
			b.append("      label=\"" + label + "\"\n");
			for (var node : level.getNodes()) {
				if (deadNodes.contains(node)) {
					continue;
				}
				label = "none";
				if (node instanceof ActiveNode mn) {
					label = "\u22a4"; // Top
					if (mn.hasMode()) {
						label += "[" + mn.getMode().getName() + "]";
					}
				} else if (node instanceof InactiveNode in) {
					label = "\u22a5"; // Bottom
					if (in.hasMode()) {
						label += "[" + in.getMode().getName() + "]";
					}
				}
				var styles = new ArrayList<String>();
				if (node == level.getInitialNode()) {
					styles.add("filled");
				}
				if (node.isDerived()) {
					styles.add("dashed");
				}
				String style = styles.isEmpty() ? "" : " style=\"" + String.join(",", styles) + "\"";
				b.append("      " + nodeName(domainNo, n) + " [label=\"" + label + "\"" + style + "]\n");
				node2n.put(node, n);
				n += 1;
			}
			if (l != lastLevel || level.getNodes().size() == 2) {
				b.append("      rank=same\n");
			}
			b.append("    }\n");
			n = n0;
			for (var node : level.getNodes()) {
				if (SKIP_DEAD_NODES && deadNodes.contains(node)) {
					continue;
				}
				if (l != 0) {
					b.append("    " + nodeName(domainNo, node2n.get(node.getParent())) + " -> ");
					b.append(nodeName(domainNo, n) + " [color=red arrowhead=none");
					if (!node.isReachable()) {
						b.append(" style=dashed");
					}
					b.append("]\n");
				}
				n += 1;
			}
		}

		var level = graph.getLevels().get(lastLevel);
		for (var tn : level.getTransitions()) {
			var s = node2n.get(tn.getSrc());
			var d = node2n.get(tn.getDst());
			var label = "";
			if (tn.getTrigger() instanceof FeatureTrigger ftg) {
				label = ftg.getFeature().getComponentInstancePath();
			}
			b.append("    " + nodeName(domainNo, s) + " -> " + nodeName(domainNo, d) + " [label=\"" + label
					+ "\" color=\"#aaaaaa\"]\n");
		}

		b.append("  }\n");
		return b;
	}

	String nodeName(int domainNo, int n) {
		return "D%d_%d".formatted(domainNo, n);
	}

}
