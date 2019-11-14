/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * %W%
 * @version %I% %H%
 */
package org.osate.ui.actions;

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

/**
 * @deprecated Usage of this class should be replaced with
 * {@link org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler}. Will be removed in 2.7.
 */
@Deprecated
public abstract class AbstractInstanceOrDeclarativeModelReadOnlyAction extends AaxlReadOnlyActionAsJob {
	private static final String INITIAL_MODE_LABEL = "Initial Mode";
	private static final String CHOOSE_MODE_LABEL = "Choose Mode...";
	private static final String ALL_MODES_LABEL = "All Modes";

	private static final String[] ALL_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL, ALL_MODES_LABEL };
	private static final String[] SINGLE_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL };

	private static final int INITIAL_MODE = 0;
	private static final int CHOOSE_MODE = 1;
	private static final int ALL_MODES = 2;

	private static final int DEFAULT_MODE_CHOICE = INITIAL_MODE;

	private int lastDefaultModeChoice = DEFAULT_MODE_CHOICE;

	protected AbstractInstanceOrDeclarativeModelReadOnlyAction() {
		super();
	}

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
						si.setCurrentSystemOperationMode(chosenSOM);
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
		} else {
			if (obj instanceof NamedElement && initializeAnalysis((NamedElement) obj)) {
				analyzeDeclarativeModel(monitor, getErrorManager(), obj);
				finalizeAnalysis();
			}
		}
	}

	private void analyzeInstanceModelInMode(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final SystemInstance si, final SystemOperationMode som) {
		errManager.addPrefix(Aadl2Util.getPrintableSOMName(som) + ": ");
		analyzeInstanceModel(monitor, errManager, si, som);
		si.clearCurrentSystemOperationMode();
		errManager.removePrefix();
	}

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
}