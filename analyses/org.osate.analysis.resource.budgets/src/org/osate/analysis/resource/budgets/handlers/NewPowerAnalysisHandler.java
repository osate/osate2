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
package org.osate.analysis.resource.budgets.handlers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.resource.budgets.power.PowerRequirementAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

/**
 * @since 4.1
 */
public class NewPowerAnalysisHandler extends NewAbstractAaxlHandler {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.PowerAnalysisMarker";
	private static final String REPORT_SUB_DIR = "Power";

	@Override
	protected String getSubDirName() {
		return REPORT_SUB_DIR;
	}

	@Override
	protected String getOutputFileForAaxlFile(final IFile aaxlFile, final String filename) {
		return filename + "__Power.csv";
	}

	@Override
	protected Job createAnalysisJob(IFile aaxlFile, IFile outputFile) {
		return new PowerReqJob(aaxlFile, outputFile);
	}

	private final class PowerReqJob extends WorkspaceJob {
		private final IFile aaxlFile;
		private final IFile outputFile;

		public PowerReqJob(final IFile aaxlFile, final IFile outputFile) {
			super("Power Requirements analysis of " + aaxlFile.getName());
			this.aaxlFile = aaxlFile;
			this.outputFile = outputFile;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
			final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
					new MarkerAnalysisErrorReporter.Factory(MARKER_TYPE));

			// Three phases (1) analysis, (2) marker generation, (3) csv file
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);
			boolean cancelled = false;

			try {
				final AnalysisResult analysisResult = new PowerRequirementAnalysis().invoke(subMonitor.split(1),
						(SystemInstance) AadlUtil.getElement(aaxlFile));
				if (subMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				generateMarkers(analysisResult, errManager);
				subMonitor.worked(1);

				final String csvContent = getCSVasString(analysisResult);
				final InputStream inputStream = new ByteArrayInputStream(csvContent.getBytes());
				writeCSVFile(inputStream, outputFile, subMonitor.split(1));
			} catch (final OperationCanceledException e) {
				cancelled = true;
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	private static String getCSVasString(final AnalysisResult analysisResult) {
		final StringWriter writer = new StringWriter();
		final PrintWriter pw = new PrintWriter(writer);
		generateCSVforAnalysis(pw, analysisResult);
		pw.close();
		return writer.toString();
	}

	// generate csv report
	public static void generateCSVforAnalysis(final PrintWriter pw, final AnalysisResult analysisResult) {
		pw.println(analysisResult.getMessage());
		pw.println();

		analysisResult.getResults().forEach(result -> { // section per result
			if (result.getSubResults().size() > 0) {
				Result subResult = result.getSubResults().get(0);

				String resourceName = ResultUtil.getString(subResult, 5);
				printItem(pw, "Computing Electrical Power for " + resourceName);
				pw.println();

				double capacity = ResultUtil.getReal(subResult, 2);
				printItem(pw, "Capacity: " + PowerRequirementAnalysis.toString(capacity));
				pw.println();

				// Supply
				double totalSupply = ResultUtil.getReal(subResult, 4);
				printItem(pw, "Supply: " + PowerRequirementAnalysis.toString(totalSupply));

				result.getSubResults().forEach(sResult -> {
					double currentValue = ResultUtil.getReal(sResult, 1);
					if (currentValue > 0) {
						printSeparator(pw);
						printItem(pw, PowerRequirementAnalysis.toString(currentValue) + " for "
								+ ResultUtil.getString(sResult, 7));
					}
				});
				pw.println();

				// Budget
				double totalBudget = ResultUtil.getReal(subResult, 3);
				printItem(pw, "Budget: " + PowerRequirementAnalysis.toString(totalBudget));

				result.getSubResults().forEach(sResult -> {
					double currentValue = ResultUtil.getReal(sResult, 0);

					if (currentValue > 0) {
						printSeparator(pw);
						printItem(pw, PowerRequirementAnalysis.toString(currentValue) + " for "
								+ ResultUtil.getString(sResult, 7));
					}
				});
				pw.println();

				if (capacity > 0.0 && totalBudget > 0.0) {
					if (totalBudget > capacity) {
						printItem(pw,
								"** " + resourceName + " budget total " + PowerRequirementAnalysis.toString(totalBudget)
										+ " exceeds capacity " + PowerRequirementAnalysis.toString(capacity));
						pw.println();

						// errManager.error(ci, somName + ": " + message);
						// powerComponentError(section, message);
					} else {
						printItem(pw, resourceName + " budget total " + PowerRequirementAnalysis.toString(totalBudget)
								+ " within capacity " + PowerRequirementAnalysis.toString(capacity));
						pw.println();

						// errManager.info(ci, somName + ": " + message);
						// powerComponentSuccess(section, message);
					}
				}

				String suppliedmsg = "";
				double available = 0.0;
				if (totalSupply == 0.0) {
					available = capacity;
					suppliedmsg = " capacity ";
				} else {
					available = totalSupply;
					suppliedmsg = " supply ";
				}

				if (totalBudget > available) {
					printItem(pw, "** " + "budget total " + PowerRequirementAnalysis.toString(totalBudget) + " exceeds"
							+ suppliedmsg + PowerRequirementAnalysis.toString(available));
					pw.println();
					// powerComponentError(section, message);
					// errManager.error(ci, somName + ": " + message);
				} else {
					printItem(pw, "budget total " + PowerRequirementAnalysis.toString(totalBudget) + " within"
							+ suppliedmsg + PowerRequirementAnalysis.toString(available));
					pw.println();
					// errManager.info(ci, somName + ": " + message);
					// powerComponentSuccess(section, message);
				}

				pw.println();
			}
		});
	}
}