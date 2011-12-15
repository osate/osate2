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

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.architecture.ArchitecturePlugin;
import org.osate.analysis.architecture.RequiredConnectionSwitch;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;
import org.osgi.framework.Bundle;


public final class CheckRequiredConnection extends AbstractInstanceOrDeclarativeModelReadOnlyAction {

	protected Bundle getBundle() {
		return ArchitecturePlugin.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.architecture.RequiredConnectionObjectMarker";
	}

	protected String getActionName() {
		return "Check for required connections";
	}

	@Override
	protected void analyzeDeclarativeModel(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final Element declarativeObject) {
		int count = AadlUtil.countElementsBySubclass((Element)declarativeObject, Subcomponent.class);
		monitor.beginTask(getActionName(), count);
		final RequiredConnectionSwitch requiredConnectionSwitch = new RequiredConnectionSwitch(monitor, errManager);
		requiredConnectionSwitch.processPreOrderAll((Element)declarativeObject);
		if (requiredConnectionSwitch.cancelled()) {
			throw new OperationCanceledException();
		}
		monitor.done();
	}

	protected void analyzeInstanceModel(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);

		// Get all the features with required connections
		final List<Element> features = new ForAllElement() {
			@Override
			protected boolean suchThat(final Element obj) {
				return !monitor.isCanceled() && (obj instanceof FeatureInstance);
			}

			@Override
			protected void action(final Element obj) {
				if (!(obj instanceof NamedElement)) return;
				final FeatureInstance fi = (FeatureInstance) obj;
				final FeatureCategory fc = fi.getCategory();
				if (fc == FeatureCategory.EVENT_PORT || fc == FeatureCategory.DATA_PORT
						|| fc == FeatureCategory.EVENT_DATA_PORT) {
					if (GetProperties.getRequiredConnection((NamedElement)obj)) {
						resultList.add(fi);
					}
				}
			}
		}.processPreOrderAll(root);

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		/*
		 * Now go through all the semantic connections, and remove from the list
		 * those features that connections pass through. If a feature is unused,
		 * it remain in the list when we are done.
		 */
		for (final Iterator<ConnectionInstance> i = root.getConnectionInstances().iterator(); i.hasNext();) {
			final ConnectionInstance ci = i.next();
			if (ci.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
				final List<InstanceObject> passesThrough = ci.getThroughFeatureInstances();
				features.removeAll(passesThrough);
			}

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
		}

		/* Report any errors */
		for (final Iterator<Element> i = features.iterator(); i.hasNext();) {
			final FeatureInstance fi = (FeatureInstance) i.next();
			warning(fi, MessageFormat.format("Port \"{0}\" requires connections but does not have any",
					new Object[] { fi.getInstanceObjectPath() }));
		}

		monitor.done();
	}
}