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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osgi.framework.Bundle;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.impl.ClassifierImpl;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.architecture.ArchitecturePlugin;
import org.osate.analysis.architecture.ModelStatistics;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.linking.Aadl2LinkingService;

public final class DoModelStatistics extends AaxlReadOnlyActionAsJob {
	protected Bundle getBundle() {
		return ArchitecturePlugin.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.architecture.ModelStatisticsObjectMarker";
	}

	protected String getActionName() {
		return "Model statistics";
	}

	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		/*
		 * Doesn't make sense to set the number of work units, because the whole
		 * point of this action is count the number of elements. To set the work
		 * units we would effectively have to count everything twice.
		 */
		monitor.beginTask("Gathering model statistics", IProgressMonitor.UNKNOWN);
		// Get the root object of the model
		Element root = obj.getElementRoot();

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject)
			si = ((InstanceObject)obj).getSystemInstance();
		else
			si = null;
		/*
		 * Create a new model statistics analysis object and run it over the
		 * declarative model. If an instance model exists, run it over that too.
		 */
		ModelStatistics stats = new ModelStatistics(monitor);
		
		/**
		 * Example of using the Index to get the classifiers
		 * In this case we then resolver the reference (causing the classifier to be loaded)
		 */

//			Aadl2LinkingService als = Aadl2LinkingService.getAadl2LinkingService(obj);
//			EList<IEObjectDescription> classifierlist = als.getAllClassifiersInWorkspace(obj.eResource());
//			Resource res = obj.eResource();
//			for (IEObjectDescription cleod : classifierlist){
//				Classifier cl = (Classifier) EcoreUtil.resolve(cleod.getEObjectOrProxy(), obj.eResource().getResourceSet());
//				stats.process(cl);
//			}
		
		/**
		 * Example of counting without causing the classifier to load
		 */
//		
//		Aadl2LinkingService als = Aadl2LinkingService.getAadl2LinkingService(obj);
//		EList<IEObjectDescription> classifierlist = als.getAllClassifiersInWorkspace(obj.eResource());
//		Resource res = obj.eResource();
//		for (IEObjectDescription cleod : classifierlist){
//			stats.countClassifier(cleod.getEClass());
//		}
		
		/*
		 * Accumulate the results in a StringBuffer, but also report them using
		 * info markers attached to the root model object.
		 */
		// run statistics on all declarative models in the workspace
		stats.defaultTraversalAllDeclarativeModels();
		final StringBuffer msg = new StringBuffer();
		final String modelStats = stats.getModelResult();
		final String flowStats = stats.getFlowResult();
		info(root, modelStats);
		info(root, flowStats);
		msg.append(modelStats);
		msg.append(flowStats);

//		 final StringBuffer msg = stats.doStats(root);

		if (si != null) {
			stats.defaultTraversal(si);
			final String appStats = stats.getApplicationResult();
			final String epStats = stats.getExecutionPlatformResult();
			info(root, appStats);
			info(root, epStats);
			msg.append(appStats);
			msg.append(epStats);
		}
		monitor.done();


		Dialog.showInfo("Model Statistics", msg.toString());
	}
}
