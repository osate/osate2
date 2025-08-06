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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.analysis.modes.internal.ModeAnalysisPlugin;
import org.osate.contribution.sei.sei.Sei;
import org.osate.result.AnalysisResult;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;

//TODO: internal feature as trigger
//TODO: processor feature as trigger
//TODO: ??? subprogram as trigger

//TODO: progress monitor
//TODO: cancel

public final class ReachabilityAnalyzer {

	private ReachabilityConfiguration config = ReachabilityConfiguration.DEFAULT;

	private ComponentInstance root;

	private Resource graphs;

	private AnalysisResult result;

	private SubMonitor progress;

	/**
	 * Create a reachability analyzer with default configuration
	 */
	public ReachabilityAnalyzer(ComponentInstance root) {
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
	public ReachabilityAnalyzer(ReachabilityConfiguration config, ComponentInstance root) {
		this(root);
		this.config = config;
	}

	public AnalysisResult analyzeModel() {
		return analyzeModel(new NullProgressMonitor());
	}

	public AnalysisResult analyzeModel(IProgressMonitor monitor) {
		ModeDomain.clearData();
		initializeResult();
		if (!fillAndValidateModeDomains(root)) {
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

		if (ResultUtil.hasResultFailures(result)) {
			result.setResultType(ResultType.FAILURE);
		} else if (ResultUtil.hasResultErrors(result)) {
			result.setResultType(ResultType.ERROR);
		} else if (ResultUtil.hasResultTBDs(result)) {
			result.setResultType(ResultType.TBD);
		} else {
			result.setResultType(ResultType.SUCCESS);
		}
		return result;
	}

	public IStatus writeReports() {

		try {
			new HtmlExporter().writeFile();
		} catch (IOException e) {
			return Status.error("An exception occurred while writing the HTML report", e);
		}

		return new Status(IStatus.OK, ModeAnalysisPlugin.ID, "");
//
//		Assert.isNotNull(graph, "SOM graph is null");
//
//		try {
//			if (config.saveModel()) {
//				try {
//					graph.eResource().save(null);
//				} catch (IOException e) {
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write model file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateDot()) {
//				try {
//					var uri = new DotExporter(graph).writeFile();
//					var r = ResultUtil.createSuccessResult("DOT file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getSubResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write DOT file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write DOT file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new DotExporter(graph).delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing DOT file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing DOT file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateHTML()) {
//				try {
//					var uri = new HtmlExporter().writeFile();
//					var r = ResultUtil.createSuccessResult("HTML file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write HTML file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write HTML file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new HtmlExporter().delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing HTML file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing HTML file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateSMV()) {
//				try {
//					var uri = new SmvExporter(graph).writeFile();
//					var r = ResultUtil.createSuccessResult("SMV file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getSubResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write SMV file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write SMV file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new SmvExporter(graph).delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing SMV file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing SMV file: " + e.getMessage(), e));
//				}
//			}
//
//			if (sts.isEmpty()) {
//				return new Status(IStatus.OK, ModeAnalysisPlugin.ID, "");
//			} else {
//				var status = new MultiStatus(ModeAnalysisPlugin.ID, IStatus.ERROR, sts.toArray(new IStatus[] {}), null,
//						null);
//				return status;
//			}
//		} catch (OperationCanceledException oce) {
//			var r = ResultUtil.createInfoDiagnostic("Cancelled by user", root);
//			result.getDiagnostics().add(r);
//			return new Status(IStatus.CANCEL, ModeAnalysisPlugin.ID,
//					"The SOM reachability analysis was cancelled by the user");
//		}
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
