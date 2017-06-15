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
package org.osate.analysis.architecture.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.architecture.ArchitecturePlugin;
import org.osate.analysis.architecture.PropertyTotals;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osgi.framework.Bundle;

public final class DoPropertyTotals extends AaxlReadOnlyActionAsJob {
	@Override
	protected Bundle getBundle() {
		return ArchitecturePlugin.getDefault().getBundle();
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.architecture.WeightTotalObjectMarker";
	}

	@Override
	protected String getActionName() {
		return "Weight totals";
	}

	@Override
	public boolean initializeAction(NamedElement obj) {
		setCSVLog("WeightAnalysis", obj);
		return true;
	}

	public void setErrManager() {
		this.errManager = new AnalysisErrorReporterManager(this.getAnalysisErrorReporterFactory());
	}

	public void saveReport() {
		this.getCSVLog().saveToFile();
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		/*
		 * Doesn't make sense to set the number of work units, because
		 * the whole point of this action is count the number of elements.
		 * To set the work units we would effectively have to count everything
		 * twice.
		 */
		monitor.beginTask("Gathering weight summaries", IProgressMonitor.UNKNOWN);

		if (!(obj instanceof ComponentInstance)) {
			warning(obj, "Weight totals: Please invoke command on an instance model");
			monitor.done();
			return;
		}

		// Get the system instance (if any)
		SystemInstance si = ((ComponentInstance) obj).getSystemInstance();

		/*
		 * Create a new model statistics analysis object and run it over
		 * the declarative model. If an instance model exists, run it over
		 * that too.
		 */
		PropertyTotals stats = new PropertyTotals(monitor, this);
		stats.getWeight(si);
		monitor.done();

		/*
		 * Accumulate the results in a StringBuffer, but also report them
		 * using info markers attached to the root model object.
		 */
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
	}
}
