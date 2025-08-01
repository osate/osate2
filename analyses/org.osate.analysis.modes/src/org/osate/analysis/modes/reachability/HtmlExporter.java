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

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.analysis.modes.modemodel.ActiveNode;
import org.osate.analysis.modes.modemodel.FeatureTrigger;
import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMNode;
import org.osate.analysis.modes.modemodel.Trigger;

public class HtmlExporter extends FileExporter {

	private static final String FILE_EXT = "html";

	private SOMGraph graph;

	private ArrayList<HashMap<SOMNode, Integer>> domSomNo = new ArrayList<>();

	private ArrayList<HashMap<Trigger, Integer>> domTriggerNo = new ArrayList<>();

	HtmlExporter() {
	}

	@Override
	Resource getGraphs() {
		return graph.eResource();
	}

	@Override
	CharSequence getContent() {
		return generateHTML();
	}

	@Override
	String getFileExtension() {
		return FILE_EXT;
	}

	StringBuilder generateHTML() {
		StringBuilder b = new StringBuilder();
		b.append("""
				<html>
				<head>
				  <style>
				    table {
				      table-layout: fixed;
				    }
				    table, th, td {
				      border: 1px solid black;
				      border-collapse: collapse;
				    }
				    th {
				      text-align: left;
				    }
				    th.drop {
				      border-style: none solid none solid;
				    }
				    th.noborder {
				      border-style: none;
				    }
				  </style>
				</head>
				<body>
				""");
		generateHTML(b);
		b.append("""
				</body>
				</html>
				""");
		return b;
	}

	StringBuilder generateHTML(StringBuilder b) {
		ComponentInstance root = ModeDomain.domains.get(0).root.getSystemInstance();
		var skip = generateLayout(root);
		b.append("  <h1>System Operation Modes and Transitions for " + root.getName() + "</h1>");
		if (skip) {
			b.append("  <p>The model has no modal components.</p>");
		} else {
			int domainNo = 0;
			for (var d : ModeDomain.domains) {
				graph = d.graph;
				root = d.root;
				skip = generateLayout(root);
				b.append("""
						  <h2>Mode domain D%d: %s</h2>
						""".formatted(domainNo, root.getInstanceObjectPath()));
				if (skip) {
					b.append("  <p>This mode domain has no modal components.</p>");
				} else {
					generateSomTable(b, root, domainNo);
					generateTriggerTable(b, domainNo);
					generateTransitionTable(b, domainNo);
				}
				domainNo += 1;
			}
		}
		return b;
	}

	private void generateSomTable(StringBuilder b, ComponentInstance root, int domainNo) {
		b.append("""
				  <h3>SOMs</h3>
				  <p>
				    This table shows the individual component modes for each system operation mode in this domain.
				  </p>
				""");
		b.append("  <table>\n");

		// table header - component names
		var level = List.of(root);
		while (!level.isEmpty() && level.stream().anyMatch(ci -> !layoutData.get(ci).skip)) {
			b.append("    <tr>\n");
			b.append("      <th class=\"drop\"></th>\n");
			var first = true;
			for (var ci : level) {
				var l = layoutData.get(ci);
				if (l.skip) {
					continue;
				}
				if (first) {
					first = false;
					for (int i = 0; i < l.col; i++) {
						b.append("      <th class=\"drop\"></th>\n");
					}
				}
				b.append("      <th colspan=\"" + l.width + "\">" + ci.getFullName() + "</th>\n");
			}
			b.append("    </tr>\n");
			level = level.stream().flatMap(ci -> ci.getComponentInstances().stream()).toList();
		}
		// table content - mode names
		var lc = graph.getLevels().size();
		var lastLevel = graph.getLevels().get(lc - 1);
		var initial = lastLevel.getInitialNode();

		var w = "width:" + Math.round(100.0 / (Layout.cols + 1)) + "%;";

		var i = 0;
		var somNo = new HashMap<SOMNode, Integer>();
		domSomNo.add(somNo);
		for (var n : lastLevel.getNodes()) {
			somNo.put(n, i);
			var ul = n == initial ? "background-color:#dddddd;" : "";
			var style = " style=\"" + w + ul + "\"";

			b.append("    <tr>\n");
			b.append("      <td" + style + ">som" + i + "</td>\n");
			generateModeData(b, n, 1);
			b.append("    </tr>\n");
			i++;
		}
		b.append("    <tr>\n");
		b.append("      <td>SMV:</td>\n");
		for (var c = 0; c < Layout.cols; c++) {
			b.append("      <td style=\"" + w + "\">c" + c + "</td>\n");
		}
		b.append("    </tr>\n");
		b.append("  </table>\n");
		b.append("""
				  <p>
				    The table cells show the mode of components (column) in an SOM (row).
				    Derived component modes are shown in italic font,
				    an empty cell means that the component is not active in the SOM.<br/>
				    Only modal components are included in the table, always active components are not shown.<br/>
				    A gray background indicates the initial mode.<br/>
				    The last row contains the component names used in the SMV file.<br/>
				    <i>Note that the SOM names in this table are not related to SOM names in the
				    instance model.</i>
				  </p>
				""");
	}

	private void generateModeData(StringBuilder b, SOMNode n, int col) {
		if (n == null) {
			return;
		}
		generateModeData(b, n.getParent(), col + 1);
		var comp = n.getLevel().getComponent();
		var w = 100.0 / (Layout.cols + 1);
		if (!(layoutData.get(comp).skip || comp.getModeInstances().isEmpty())) {
			b.append("      <td style=\"width:" + Math.round(w) + "%;");
			if (n.isDerived()) {
				b.append(" font-style:italic;");
			}
			b.append("\">");
			if (n instanceof ActiveNode && n.hasMode()) {
				b.append(n.getMode().getName());
			}
			b.append("</td>\n");
		}
	}

	static class Layout {
		static int cols = 0;
		static int rows = 0;

		boolean skip = false;
		int row = 0;
		int col = 0;
		int width = 0;
		boolean modes = false;
	}

	private Map<ComponentInstance, Layout> layoutData = new HashMap<>();

	private boolean generateLayout(ComponentInstance root) {
		Layout.cols = 0;
		Layout.rows = 0;
		// mark components to skip (no owned modes and no modes in subcomponents)
		layoutData.clear();
		var skip = initMap(root);
		if (!skip) {
			// generate layout data
			var l = fillLayoutData(root, 0, 0);
			Layout.cols = l.width;
		}
		return skip;
	}

	private boolean initMap(ComponentInstance ci) {
		var l = new Layout();
		layoutData.put(ci, l);
		var ownModes = ci.getModeInstances();
		l.width = ownModes.isEmpty() ? 0 : 1;
		l.skip = ownModes.isEmpty();
		for (var c : ci.getComponentInstances()) {
			l.skip &= initMap(c);
		}
		// skip components that have no modes and none of their children has modes
		return l.skip;
	}

	private Layout fillLayoutData(ComponentInstance ci, int row, int offset) {
		var l = layoutData.get(ci);
		if (l.skip) {
			return l;
		}
		l.row = row;
		l.col = offset;
		for (var c : ci.getComponentInstances()) {
			if (!layoutData.get(c).skip) {
				l.modes = !ci.getModeInstances().isEmpty();
				var cl = fillLayoutData(c, row + 1, l.modes ? offset + 1 : offset);
				offset = cl.col;
				l.width += cl.width;
				Layout.rows = Math.max(Layout.rows, cl.row);
			}
		}
		return l;
	}

	private void generateTriggerTable(StringBuilder b, int domainNo) {
		b.append(
				"""
						  <h3>SOM Transition Triggers</h3>
						  <p>
						    This table shows all triggers that can cause a transition between system operation modes in this domain.<br/>
						  </p>
						""");
		b.append("  <table>\n");

		b.append("    <tr>\n");
		b.append("      <th>ID</th><th>Trigger</th>\n");
		b.append("    </tr>\n");

		// table content - mode names
		var triggerNo = new HashMap<Trigger, Integer>();
		domTriggerNo.add(triggerNo);
		var i = 0;
		for (var tg : graph.getTriggers().values()) {
			triggerNo.put(tg, i);
			if (!tg.getTransitions().isEmpty()) {
				b.append("    <tr>\n");
				b.append("      <td>tg" + i + "</td><td>" + qualifiedName(tg) + "</td>\n");
				b.append("    </tr>\n");
				i++;
			}
		}
		b.append("  </table>\n");
	}

	private void generateTransitionTable(StringBuilder b, int domainNo) {
		b.append("""
				  <h3>SOM Transitions</h3>
				  <p>
				    This table shows the possible transitions between system operation modes in this domain.<br/>
				  </p>
				""");
		b.append("  <table>\n");

		b.append("    <tr>\n");
		b.append("      <th>Source</th><th>Trigger</th><th>Target</th>\n");
		b.append("    </tr>\n");

		var lc = graph.getLevels().size();
		var lastLevel = graph.getLevels().get(lc - 1);
		var initial = lastLevel.getInitialNode();

		for (var n : lastLevel.getNodes()) {
			var ul = n == initial ? "background-color:#dddddd;" : "";
			var style = " style=\"" + ul + "\"";

			for (var tn : n.getOutTransitions()) {
				b.append("    <tr>\n");
				b.append("      <td" + style + ">som" + domSomNo.get(domainNo).get(n) + "</td>\n");
				b.append("      <td>tg" + domTriggerNo.get(domainNo).get(tn.getTrigger()) + "</td>\n");
				b.append("      <td>som" + domSomNo.get(domainNo).get(tn.getDst()) + "</td>\n");
				b.append("    </tr>\n");
			}
		}
		b.append("  </table>\n");
	}

	private String qualifiedName(Trigger tg) {
		String result = "some name";
		if (tg instanceof FeatureTrigger ftg) {
			result = ftg.getFeature().getComponentInstancePath();
		}
		return result;
	}

}
