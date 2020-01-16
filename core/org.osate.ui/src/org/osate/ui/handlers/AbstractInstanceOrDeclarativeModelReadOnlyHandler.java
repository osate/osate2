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
package org.osate.ui.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.window.Window;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.dialogs.SOMChooserDialog;

public abstract class AbstractInstanceOrDeclarativeModelReadOnlyHandler extends AaxlReadOnlyHandlerAsJob {
	private static final String INITIAL_MODE_LABEL = "Initial Mode";
	private static final String CHOOSE_MODE_LABEL = "Choose Mode...";
	private static final String ALL_MODES_LABEL = "All Modes";

	private static final String[] ALL_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL, ALL_MODES_LABEL };
	private static final String[] SINGLE_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL };

	private static final int INITIAL_MODE = 0;
	private static final int CHOOSE_MODE = 1;

	private static final int DEFAULT_MODE_CHOICE = INITIAL_MODE;

	private int lastDefaultModeChoice = DEFAULT_MODE_CHOICE;

	/**
	 * Should instance models be analyzed in a single mode only?  If this
	 * returns <code>true</code>, then the user is not allowed to choose
	 * to analyze the model in all modes.
	 *
	 * <p>The default implementation returns <code>false</code>.
	 */
	protected boolean analyzeInSingleModeOnly() {
		return false;
	}

	@Override
	public final void doAaxlAction(final IProgressMonitor monitor, final Element obj) {
		final NamedElement root = ((NamedElement) obj).getElementRoot();
		if (root instanceof SystemInstance) {
			final SystemInstance si = (SystemInstance) root;
			final int whichMode;
			if (si.getSystemOperationModes().size() > 1) {
				whichMode = Dialog.askQuestion("Choose Mode",
						"Please choose in which mode(s) the model should be analyzed.",
						analyzeInSingleModeOnly() ? SINGLE_MODE_CHOICE_LABELS : ALL_MODE_CHOICE_LABELS,
						lastDefaultModeChoice);
			} else {
				// A system with no modes still has at least one SOM named NORMAL_SOM_NAME aka "no modes"
				whichMode = INITIAL_MODE;
			}
			if (whichMode != -1) {
				lastDefaultModeChoice = whichMode;

				SystemOperationMode chosenSOM = null;
				if (!si.getSystemOperationModes().isEmpty()) {
					// the SOM list should not be empty
					if (whichMode == INITIAL_MODE) {
						// this may also be "No Modes" aka NORMAL_SOM_NAME
						chosenSOM = si.getInitialSystemOperationMode();
					} else if (whichMode == CHOOSE_MODE) {
						final SOMChooserDialog somDialog = new SOMChooserDialog(getShell(), si, false);
						if (somDialog.openThreadSafe() == Window.OK) {
							chosenSOM = somDialog.getSOM();
						} else {
							return;
						}
					}
				}

				if (initializeAnalysis(si)) {
					final AnalysisErrorReporterManager errManager = getErrorManager();
					if (chosenSOM != null) {
						analyzeInstanceModelInMode(monitor, errManager, si, chosenSOM);
					} else {
						final SOMIterator soms = new SOMIterator(si);
						while (soms.hasNext()) {
							final SystemOperationMode som = soms.nextSOM();
							analyzeInstanceModelInMode(monitor, errManager, si, som);
						}
					}
					finalizeAnalysis();
				}
			}
		} else if (obj instanceof NamedElement) {
			if (canAnalyzeDeclarativeModels()) {
				Dialog.showError("Error", "Please select an instance model");
			} else if (initializeAnalysis((NamedElement) obj)) {
				analyzeDeclarativeModel(monitor, getErrorManager(), obj);
				finalizeAnalysis();
			}
		}
	}

	private void analyzeInstanceModelInMode(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final SystemInstance si, final SystemOperationMode som) {
		errManager.addPrefix(Aadl2Util.getPrintableSOMName(som) + ": ");
		si.setCurrentSystemOperationMode(som);
		analyzeInstanceModel(monitor, errManager, si, som);
		si.clearCurrentSystemOperationMode();
		errManager.removePrefix();
	}

	/**
	 * Is analysis of declarative models supported?  If not, then an error dialog is opened when the analysis is
	 * invoked on declarative models.
	 */
	protected abstract boolean canAnalyzeDeclarativeModels();

	/**
	 * Analyze the model starting from a declarative model element.
	 * @param monitor The progress monitor to use.
	 * @param errManager The error manager to use.  This is the same as error
	 * manager that {@link #getErrorManager()} returns.  It is provided here
	 * as a convenience.
	 * @param declarativeObject The declarative object.
	 */
	protected abstract void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject);

	/**
	 * Analyze a system instance model in a particular system operation mode.
	 * The model is already projected into the given SOM, and the error
	 * manager has been adjusted to report errors relative to that SOM.
	 * @param monitor The progress monitor to use.
	 * @param errManager The error manager to use.  This is the same as error
	 * manager that {@link #getErrorManager()} returns.  It is provided here
	 * as a convenience.
	 * @param root The system instance model.
	 * @param som The system operation mode that the model is projected into.
	 */
	protected abstract void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som);

	/**
	 * Initialize the state of analysis.  For example,
	 * this can open a dialog box to get additional parameters to the
	 * analysis.  The analysis state should be initialized by setting
	 * fields that are then used by {@link #analyzeDeclarativeModel}
	 * and {@link #analyzeInstanceModel}.
	 *
	 * <p>The default implementation of this method simply returns
	 * <code>true</code>.
	 *
	 * @return <code>true</code> if the analysis should proceed or
	 * <code>false</code> if the user cancelled the analysis.
	 */
	protected boolean initializeAnalysis(NamedElement object) {
		return true;
	}

	/**
	 * finalize the state of analysis.  For example,
	 * this can close a report being generated.
	 * <p>The default implementation of this method simply returns
	 * <code>true</code>.
	 *
	 * @return <code>true</code> if the analysis should proceed or
	 * <code>false</code> if the user cancelled the analysis.
	 */
	protected boolean finalizeAnalysis() {
		return true;
	}
}