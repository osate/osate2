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

import static java.util.Objects.isNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.analysis.modes.internal.ModeAnalysisPlugin;
import org.osate.analysis.modes.modemodel.SOMNode;
import org.osate.contribution.sei.sei.Sei;
import org.osate.result.AnalysisResult;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;

//TODO: internal feature as trigger
//TODO: processor feature as trigger
//TODO: ??? subprogram as trigger

public final class ReachabilityAnalyzer {

	private static final boolean DEBUG = false;

	private ReachabilityConfiguration config = ReachabilityConfiguration.DEFAULT;

	private SystemInstance root;

	private Resource graphs;

	private AnalysisResult result;

	private SubMonitor progress;

	/**
	 * Create a reachability analyzer with default configuration
	 */
	public ReachabilityAnalyzer(SystemInstance root) {
		this.root = root;
		var rs = root.eResource().getResourceSet();
		var uri = makeURI(root);
		var res = rs.getResource(uri, false);

		if (isNull(res)) {
			res = rs.createResource(uri);
		} else {
			res.unload();
		}
		graphs = res;
	}

	/**
	 * Create a reachability analyzer.
	 * @param config - the reporting configuration
	 */
	public ReachabilityAnalyzer(ReachabilityConfiguration config, SystemInstance root) {
		this(root);
		this.config = config;
	}

	public AnalysisResult analyzeModel() {
		return analyzeModel(new NullProgressMonitor());
	}

	public AnalysisResult analyzeModel(IProgressMonitor monitor) {
		ModeDomain.clearData();
		initializeResult();
		try {
			if (!fillAndValidateModeDomains(root)) {
				result.setMessage("Mode domains are not set up correctly, check instance model for problems");
				result.setResultType(ResultType.ERROR);
				return result;
			}

			progress = SubMonitor.convert(monitor, 100);

			while (!ModeDomain.toAnalyze.isEmpty()) {
				var d = ModeDomain.toAnalyze.iterator().next();
				ModeDomain.toAnalyze.remove(d);
				var r = d.analyze(config, progress.split(1));
				result.getResults().add(r);
			}

			monitor.done();

			markUnreachableSOMs();

			if (ResultUtil.hasResultFailures(result)) {
				result.setMessage("The analysis could not be executed successfully");
				result.setResultType(ResultType.FAILURE);
			} else if (ResultUtil.hasResultErrors(result)) {
				result.setMessage("An error occurred during analysis, check instance model for problems");
				result.setResultType(ResultType.ERROR);
			} else if (ResultUtil.hasResultTBDs(result)) {
				result.setMessage("Analysis was cancelled");
				result.setResultType(ResultType.TBD);
			} else {
				result.setResultType(ResultType.SUCCESS);
			}
			return result;
		} finally {
			ModeDomain.cleanResource();
		}
	}

	public IStatus writeReports() {

		if (config.generateHTML()) {
			try {
				var uri = new HtmlExporter().writeFile();
				var r = ResultUtil.createSuccessResult("HTML file URI", root);
				ResultUtil.addStringValue(r, uri.toString());
				result.getResults().add(r);
			} catch (IOException e) {
				var r = ResultUtil.createErrorDiagnostic("Could not write HTML file: " + e.getMessage(), root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not write HTML file: " + e.getMessage(), e);
			}
		} else {
			try {
				new HtmlExporter().delete();
			} catch (IOException e) {
				var r = ResultUtil.createWarningDiagnostic("Could not delete existing HTML file: " + e.getMessage(),
						root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not delete existing HTML file: " + e.getMessage(), e);
			}
		}

		if (config.generateDot()) {
			try {
				var uri = new DotExporter().writeFile();
				var r = ResultUtil.createSuccessResult("DOT file URI", root);
				ResultUtil.addStringValue(r, uri.toString());
				result.getResults().add(r);
			} catch (IOException e) {
				var r = ResultUtil.createErrorDiagnostic("Could not write DOT file: " + e.getMessage(), root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not write DOT file: " + e.getMessage(), e);
			}
		} else {
			try {
				new DotExporter().delete();
			} catch (IOException e) {
				var r = ResultUtil.createWarningDiagnostic("Could not delete existing DOT file: " + e.getMessage(),
						root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not delete existing DOT file: " + e.getMessage(), e);
			}
		}

		if (config.generateSMV()) {
			try {
				var uri = new SmvExporter().writeFile();
				var r = ResultUtil.createSuccessResult("SMV file URI", root);
				ResultUtil.addStringValue(r, uri.toString());
				result.getResults().add(r);
			} catch (IOException e) {
				var r = ResultUtil.createErrorDiagnostic("Could not write SMV file: " + e.getMessage(), root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not write SMV file: " + e.getMessage(), e);
			}
		} else {
			try {
				new SmvExporter().delete();
			} catch (IOException e) {
				var r = ResultUtil.createWarningDiagnostic("Could not delete existing SMV file: " + e.getMessage(),
						root);
				result.getDiagnostics().add(r);
				return new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
						"Could not delete existing SMV file: " + e.getMessage(), e);
			}
		}

		return new Status(IStatus.OK, ModeAnalysisPlugin.ID, "");
	}

	private Iterator<SystemOperationMode> instanceSOMs;

	private List<SOMNode> nodes;

	private void markUnreachableSOMs() {
		instanceSOMs = root.getSystemOperationModes().iterator();
		nodes = new ArrayList<>();
		generateNodes(0);
		instanceSOMs.forEachRemaining(som -> {
			if (DEBUG) {
				System.out.println("UNREACHABLE\n");
			}
			result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(som.getName() + " is not reachable", som));
		});
	}

	private void generateNodes(int i) {
		if (i == ModeDomain.domains.size()) {
			findMatchingSOM();
		} else {
			var d = ModeDomain.domains.get(i);
			var level = d.graph.getLevels().getLast();
			for (var n : level.getNodes()) {
				nodes.addLast(n);
				generateNodes(i + 1);
				nodes.removeLast();
			}
		}
	}

	private void findMatchingSOM() {
		while (instanceSOMs.hasNext()) {
			var som = instanceSOMs.next();
			if (!matchesNodes(som)) {
				if (DEBUG) {
					System.out.println("UNREACHABLE\n");
				}
				result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(som.getName() + " is not reachable", som));
			} else {
				break;
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private boolean matchesNodes(SystemOperationMode som) {
		if (DEBUG) {
			System.out.println(som.getName());
			for (var m1 : som.getCurrentModes()) {
				System.out.println(m1.getComponentInstancePath());
			}
			System.out.println();
			System.out.println("Nodes:");
			for (var n1 : nodes) {
				for (var n11 = n1; !isNull(n11); n11 = n11.getParent()) {
					if (n11.isActive() && n11.hasMode()) {
						System.out.println(n11.getMode().getComponentInstancePath());
					}
				}
			}
			System.out.println();
		}
		var modes = new ArrayList<ModeInstance>();
		for (var node : nodes) {
			var ms = new ArrayList<ModeInstance>();
			for (var n = node; !isNull(n); n = n.getParent()) {
				if (n.isActive() && n.hasMode()) {
					ms.addLast(n.getMode());
				}
			}
			for (var m : ms.reversed()) {
				modes.addLast(m);
			}
		}
		return modes.equals(som.getCurrentModes());
	}

	private boolean fillAndValidateModeDomains(ComponentInstance ci) {
		fillModeDomains(ci);
		if (ModeDomain.domains.isEmpty()) {
			new ModeDomain(root, graphs);
			return true;
		} else {
			return validateModeDomains(root, null);
		}
	}

	private void fillModeDomains(ComponentInstance ci) {
		if (Sei.getModeDomain(ci).orElse(false)) {
			new ModeDomain(ci, graphs);
		} else {
			for (var sci : ci.getComponentInstances()) {
				fillModeDomains(sci);
			}
		}
	}

	private boolean validateModeDomains(ComponentInstance ci, ComponentInstance inDomain) {
		boolean ok = true;

		if (isNull(inDomain)) {
			if (Sei.getModeDomain(ci).orElse(false)) {
				inDomain = ci;
			} else if (!ci.getModeInstances().isEmpty()) {
				ok = false;
				result.getDiagnostics()
						.add(ResultUtil.createErrorDiagnostic("Modal component not in a mode domain", ci));
			}
		} else {
			if (Sei.getModeDomain(ci).orElse(false)) {
				ok = false;
				result.getDiagnostics()
						.add(ResultUtil.createErrorDiagnostic(
								"Mode domain contained in another: " + inDomain.getQualifiedName(), ci));
			}
		}
		for (var sci : ci.getComponentInstances()) {
			ok &= validateModeDomains(sci, inDomain);
		}

		return ok;
	}

	private void initializeResult() {
		result = ResultUtil.createAnalysisResult("SOM Reachability Analysis", root);
	}

	private URI makeURI(ComponentInstance root) {
		var uri = root.eResource().getURI();
		var fn = uri.segment(uri.segmentCount() - 1);
		uri = uri.trimSegments(1).appendSegment("reports").appendSegment("som-reachability").appendSegment(fn);
		uri = uri.trimFileExtension().appendFileExtension("modemodel");
		return uri;
	}

}
