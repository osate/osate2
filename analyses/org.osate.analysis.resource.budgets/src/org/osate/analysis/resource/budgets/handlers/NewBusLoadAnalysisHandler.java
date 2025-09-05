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
package org.osate.analysis.resource.budgets.handlers;

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
import org.osate.analysis.resource.budgets.busload.NewBusLoadAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.ui.handlers.AbstractAnalysisHandler;

/**
 * @since 3.0
 */
public final class NewBusLoadAnalysisHandler extends AbstractAnalysisHandler {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.BusLoadAnalysisMarker";
	private static final String REPORT_SUB_DIR = "BusLoad";

	public NewBusLoadAnalysisHandler() {
		super();
	}

	@Override
	protected String getSubDirName() {
		return REPORT_SUB_DIR;
	}

	@Override
	protected String getOutputFileForAaxlFile(final IFile aaxlFile, final String filename) {
		return filename + "__BusLoad.csv";
	}

	@Override
	protected Job createAnalysisJob(final IFile aaxlFile, final IFile outputFile) {
		return new BusLoadJob(aaxlFile);
	}

	private final class BusLoadJob extends WorkspaceJob {
		private final IFile aaxlFile;

		public BusLoadJob(final IFile aaxlFile) {
			super("Bus load analysis of " + aaxlFile.getName());
			this.aaxlFile = aaxlFile;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
			final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
					new MarkerAnalysisErrorReporter.Factory(MARKER_TYPE));

			// Two phases (1) analysis, (2) marker generation
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
			boolean cancelled = false;

			try {
				final AnalysisResult analysisResult = new NewBusLoadAnalysis().invoke(subMonitor.split(1),
						(SystemInstance) AadlUtil.getElement(aaxlFile));
				if (subMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				generateMarkers(analysisResult, errManager);
				subMonitor.worked(1);
			} catch (final OperationCanceledException e) {
				cancelled = true;
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}
}
