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
package org.osate.analysis.security.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.security.ComponentInstanceLevelChecker;
import org.osate.analysis.security.ComponentLevelChecker;
import org.osate.analysis.security.ConnectionInstanceLevelChecker;
import org.osate.analysis.security.ConnectionLevelChecker;
import org.osate.analysis.security.LevelComparator;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelModifyHandler;

public abstract class AbstractLevelChecker extends AbstractInstanceOrDeclarativeModelModifyHandler {
	private boolean initialized = false;

	/**
	 * Connection level comparator for levels that must be greater on the
	 * connection source.
	 */
	protected static final LevelComparator sourceMustBeGreater = new LevelComparator() {
		@Override
		public boolean compareLevels(final long src, final long dest) {
			return src >= dest;
		}
	};

	/**
	 * Connection level comparator for levels that must be greater on the
	 * connection destination.
	 */
	protected static final LevelComparator destMustBeGreater = new LevelComparator() {
		@Override
		public boolean compareLevels(final long src, final long dest) {
			return dest >= src;
		}
	};

	/**
	 * The property we are checking.
	 */
	private Property theProperty;

	/**
	 * Empty implementation to prevent subclasses from mistakenly overridding
	 * this method as they normally would.
	 */
	@Override
	protected final void initPropertyReferences() {
	}

	/**
	 * Make this method abstract to force subclasses to differentiate
	 * their markers.
	 */
	@Override
	protected abstract String getMarkerType();

	/**
	 * Return the name of the property set in which the level property
	 * is declared.
	 */
	protected abstract String getLevelPropertyPropertySet();

	/**
	 * Return the name of the property to analyse.  This property must
	 * be of type aadlinteger.
	 */
	protected abstract String getLevelPropertyName();

	/**
	 * Return the connection level comparator to be used.
	 */
	protected abstract LevelComparator getLevelComparator();

	protected boolean initializeAnalysis() {
		if (initialized) {
			return true;
		}
		theProperty = lookupOptionalPropertyDefinition(getLevelPropertyPropertySet(), getLevelPropertyName());
		if (theProperty == null) {
			final String propName = getLevelPropertyPropertySet() + "::" + getLevelPropertyName();
			Dialog.showError("Error", "Cannot find property " + propName + ".");
			return false;
		} else {
			initialized = true;
			return true;
		}
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
		final Element as;
		initializeAnalysis();
		if (!(declarativeObject instanceof ComponentImplementation)) {
			as = declarativeObject.getElementRoot();
		} else {
			as = declarativeObject;
		}

		/*
		 * ensure that enclosing component security level encompasses contained
		 * security levels. The switch acts as filter on the model object
		 * classes.
		 */
		final ComponentLevelChecker componentSecuritySwitch = new ComponentLevelChecker(monitor, errManager,
				theProperty);
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		if (as instanceof ComponentImplementation) {
			componentSecuritySwitch.processBottomUpComponentImpl((ComponentImplementation) as);
		} else {
			componentSecuritySwitch.processBottomUpComponentImpl();
		}
		if (componentSecuritySwitch.cancelled()) {
			throw new OperationCanceledException();
		}

		final ConnectionLevelChecker connectionSecuritySwitch = new ConnectionLevelChecker(monitor, errManager,
				theProperty, getLevelComparator());
		if (as instanceof ComponentImplementation) {
			connectionSecuritySwitch.processTopDownComponentImpl((ComponentImplementation) as);
		} else {
			connectionSecuritySwitch.processAllComponentImpl();
		}
		if (connectionSecuritySwitch.cancelled()) {
			throw new OperationCanceledException();
		}
		monitor.done();
	}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		/*
		 * ensure that enclosing component security level encompasses contained
		 * security levels. The switch acts as filter on the model object
		 * classes.
		 */
		initializeAnalysis();
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		final ComponentInstanceLevelChecker componentSecuritySwitch = new ComponentInstanceLevelChecker(errManager,
				theProperty);
		final ConnectionInstanceLevelChecker connectionSecuritySwitch = new ConnectionInstanceLevelChecker(errManager,
				theProperty, getLevelComparator());
		componentSecuritySwitch.processPostOrderAll(root);
		connectionSecuritySwitch.processPostOrderAll(root);
		monitor.done();
	}
}